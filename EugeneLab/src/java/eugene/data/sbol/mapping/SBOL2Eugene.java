/*
Copyright (c) 2012 Boston University.
All rights reserved.
Permission is hereby granted, without written agreement and without
license or royalty fees, to use, copy, modify, and distribute this
software and its documentation for any purpose, provided that the above
copyright notice and the following two paragraphs appear in all copies
of this software.

IN NO EVENT SHALL BOSTON UNIVERSITY BE LIABLE TO ANY PARTY
FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES
ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
BOSTON UNIVERSITY HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

BOSTON UNIVERSITY SPECIFICALLY DISCLAIMS ANY WARRANTIES,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND BOSTON UNIVERSITY HAS
NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES,
ENHANCEMENTS, OR MODIFICATIONS.
 */

package eugene.data.sbol.mapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.cidarlab.eugene.builder.EugeneBuilder;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.SBOLRootObject;
import org.sbolstandard.core.SequenceAnnotation;
import org.sbolstandard.core.util.SequenceOntology;

import eugene.cache.SymbolTables;
import eugene.constants.EugeneConstants;
import eugene.dom.NamedElement;
import eugene.dom.PropertyValue;
import eugene.dom.collection.CollectionElement;
import eugene.dom.components.Property;
import eugene.dom.components.types.PartType;
import eugene.exception.EugeneException;

public class SBOL2Eugene {

	private static List<Property> lstProperties = null;

	public static NamedElement convert(SBOLRootObject sbolComponent)
			throws EugeneException {

		if (null == lstProperties) {
			createSBOLProperties();
		}

		if (null != sbolComponent) {
			if (sbolComponent instanceof org.sbolstandard.core.impl.CollectionImpl) {
				org.sbolstandard.core.impl.CollectionImpl sbolCollection = (org.sbolstandard.core.impl.CollectionImpl) sbolComponent;

				Set<CollectionElement> setCollectionElements = new HashSet<CollectionElement>();
				for (DnaComponent dc : sbolCollection.getComponents()) {
					NamedElement objElement = SBOL2Eugene.convert(dc);
					if (null != objElement
							&& objElement instanceof CollectionElement) {
						setCollectionElements
								.add((CollectionElement) objElement);
					}
				}

				return EugeneBuilder.buildCollection(
						sbolCollection.getDisplayId(), setCollectionElements);
			} else if (sbolComponent instanceof org.sbolstandard.core.impl.DnaComponentImpl) {
				org.sbolstandard.core.impl.DnaComponentImpl sbolDC = (org.sbolstandard.core.impl.DnaComponentImpl) sbolComponent;
				if (null != sbolDC.getAnnotations()
						&& !sbolDC.getAnnotations().isEmpty()) {
					// if the SBOL component does have annotations, then it is a
					// device

					List<eugene.dom.components.Component> lstDeviceElements = new ArrayList<eugene.dom.components.Component>(
							sbolDC.getAnnotations().size());

					// for a device, we have to iterate over all sequence
					// annotations and
					// convert each annotated DNA component
					for (SequenceAnnotation sa : sbolDC.getAnnotations()) {
						NamedElement objElement = SBOL2Eugene.convert(sa
								.getSubComponent());
						if (null != objElement
								&& objElement instanceof eugene.dom.components.Component) {
							lstDeviceElements
									.add((eugene.dom.components.Component) objElement);
						}
					}
					return EugeneBuilder.buildDevice(sbolDC.getDisplayId(),
							lstDeviceElements, (char[])null);
				} else {
					// if the SBOL component does not have any annotations, then
					// check if
					// the SBOL component has a DNA sequence
					if (null != sbolDC.getDnaSequence()) {
						// if yes -> the SBOL component is a part

						// check if a SEQUENCE property exists already
						NamedElement objTmp = SymbolTables
								.get(EugeneConstants.SEQUENCE_PROPERTY);
						Property objSequenceProperty = (Property) null;
						if (null != objTmp && objTmp instanceof Property) {
							objSequenceProperty = (Property) objTmp;
						} else {
							// if not, then create one and put it into the
							// symbol tables
							objSequenceProperty = EugeneBuilder.buildProperty(
									EugeneConstants.SEQUENCE_PROPERTY,
									EugeneConstants.TXT);

							SymbolTables.put(objSequenceProperty);
						}

						// build a sequence property
						PropertyValue objSequenceValue = EugeneBuilder
								.buildPropertyValue(
										EugeneConstants.SEQUENCE_PROPERTY,
										EugeneBuilder.buildVariable(sbolDC
												.getDnaSequence()
												.getNucleotides()));
						ArrayList<PropertyValue> lstValues = new ArrayList<PropertyValue>(
								1);
						lstValues.add(objSequenceValue);

						return EugeneBuilder.buildPart(sbolDC.getDisplayId(),
								lstValues, (PartType) SymbolTables
										.get(EugeneConstants.SBOL_PART_TYPE));
					} else {
						// if no -> the SBOL component is a part type (with a
						// Sequence property)
						List<Property> lstProperties = new ArrayList<Property>(
								1);
						lstProperties.add(getSequenceProperty());

						// get the type of the component
						if (null == sbolDC.getTypes()
								|| sbolDC.getTypes().isEmpty()) {
							// if the type is null, then check if the standard
							// SBOL part type was created already
							PartType objPartType = (PartType) SymbolTables
									.get(EugeneConstants.SBOL_PART_TYPE);
							if (null != objPartType) {
								return objPartType;
							}

							// if the standard SBOL part type was not created
							// already, then create it
							// and put it into the symbol tables
							objPartType = EugeneBuilder.buildPartType(
									EugeneConstants.SBOL_PART_TYPE,
									lstProperties);
							SymbolTables.put(objPartType);

							return objPartType;
						} else {
							for (URI uri : sbolDC.getTypes()) {
								// for every part type, create a new Eugene part
								// type
								String sSOTerm = uri.getPath();
								int n = (-1);
								if ((-1) != (n = sSOTerm.lastIndexOf('/'))) {
									sSOTerm = sSOTerm.substring(n + 1,
											sSOTerm.length() - 1);
								}
								PartType objPartType = getPartType(uri
										.toString());
								return objPartType;
							}
						}
					}
				}
			}
		}

		return (NamedElement) null;
	}

	private static PartType getPartType(String s) throws EugeneException {
		String sPartTypeName = soMapping(s);

		PartType objPartType = (PartType) null;
		NamedElement objTmp = SymbolTables.get(sPartTypeName);
		if (null != objTmp && objTmp instanceof PartType) {
			objPartType = (PartType) objTmp;
		} else {
			objPartType = EugeneBuilder.buildPartType(sPartTypeName,
					lstProperties);
			SymbolTables.put(objPartType);
		}
		return objPartType;
	}

	private static String soMapping(String s) {
		if (SequenceOntology.FIVE_PRIME_UTR.toString().equals(s)) {
			return "Five_Prime_UTR";
		} else if (SequenceOntology.CDS.toString().equals(s)) {
			return "CDS";
		} else if (SequenceOntology.INSULATOR.toString().equals(s)) {
			return "Insulator";
		} else if (SequenceOntology.OPERATOR.toString().equals(s)) {
			return "Operator";
		} else if (SequenceOntology.ORIGIN_OF_REPLICATION.toString().equals(s)) {
			return "Origin_of_Replication";
		} else if (SequenceOntology.PRIMER_BINDING_SITE.toString().equals(s)) {
			return "Primiter_Binding_Site";
		} else if (SequenceOntology.PROMOTER.toString().equals(s)) {
			return "Promoter";
		} else if (SequenceOntology.RESTRICTION_ENZYME_RECOGNITION_SITE
				.toString().equals(s)) {
			return "Restriction_Enzyme_Recognition_Site";
		} else if (SequenceOntology.TERMINATOR.toString().equals(s)) {
			return "Terminator";
		}
		return EugeneConstants.SBOL_PART_TYPE;
	}

	public static void readURI(URI uri) throws Exception {
		URL url = uri.toURL();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream()));

		String inputLine;
		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();
	}

	private static void createSBOLProperties() throws EugeneException {
		if (null == lstProperties) {
			lstProperties = new ArrayList<Property>(6);
			lstProperties.add(EugeneBuilder.buildProperty("URI", "txt"));
			lstProperties.add(EugeneBuilder.buildProperty("displayId", "txt"));
			lstProperties.add(EugeneBuilder.buildProperty("name", "txt"));
			lstProperties
					.add(EugeneBuilder.buildProperty("description", "txt"));
			lstProperties.add(EugeneBuilder.buildProperty("type", "txt[]"));
			lstProperties.add(EugeneBuilder.buildProperty(
					EugeneConstants.SEQUENCE_PROPERTY, "txt"));
			for (Property objProperty : lstProperties) {
				if (!SymbolTables.contains(objProperty.getName())) {
					SymbolTables.put(objProperty);
				}
			}
		}
	}

	private static Property getSequenceProperty() {
		// every part type should have a sequence property
		Property objSequenceProperty = (Property) SymbolTables
				.get(EugeneConstants.SEQUENCE_PROPERTY);
		if (null == objSequenceProperty) {
			objSequenceProperty = EugeneBuilder.buildProperty(
					EugeneConstants.SEQUENCE_PROPERTY, EugeneConstants.TXT);
		}
		return objSequenceProperty;
	}

}
