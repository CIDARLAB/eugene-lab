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

package org.cidarlab.eugene.data.sbol.mapping;

// SBOL
import java.net.URI;
import java.util.ArrayList;

import org.sbolstandard.core.Collection;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.DnaSequence;
import org.sbolstandard.core.SequenceAnnotation;
import org.sbolstandard.core.impl.CollectionImpl;
import org.sbolstandard.core.impl.DnaComponentImpl;
import org.sbolstandard.core.impl.DnaSequenceImpl;
import org.sbolstandard.core.impl.SequenceAnnotationImpl;
import org.sbolstandard.core.util.SequenceOntology;

import org.cidarlab.eugene.cache.SymbolTables;
import org.cidarlab.eugene.constants.EugeneConstants;
import org.cidarlab.eugene.dom.NamedElement;
import org.cidarlab.eugene.dom.PropertyValue;
import org.cidarlab.eugene.dom.arrays.ComponentArray;
import org.cidarlab.eugene.dom.arrays.DeviceArray;
import org.cidarlab.eugene.dom.components.Component;
import org.cidarlab.eugene.dom.components.Device;
import org.cidarlab.eugene.dom.components.Part;
import org.cidarlab.eugene.dom.components.types.PartType;
import org.cidarlab.eugene.exception.EugeneException;

public class Eugene2SBOL {

	public static ArrayList<String> lstURIs;

	public static DnaComponent convert(Component objComponent, String sURI)
			throws Exception {
		if (null == objComponent) {
			throw new EugeneException("I cannot export a NULL value to SBOL!");
		}

		DnaComponent dc = new DnaComponentImpl();
		if (objComponent instanceof Device) {
			Device objDevice = (Device) objComponent;
			int n = 1;
			for (Component c : objDevice.getComponents()) {
				SequenceAnnotation sa = new SequenceAnnotationImpl();
				sa.setURI(URI.create(sURI + "/" + objDevice.getName() + "/anno"
						+ n));
				n++;

				sa.setSubComponent(Eugene2SBOL.convert(c, sURI + "/"
						+ objDevice.getName()));

				dc.addAnnotation(sa);
			}

			dc.setDescription(objDevice.getName());
			dc.setDisplayId(objDevice.getName());
			dc.setDisplayId(sURI + "/" + objDevice.getName());
			dc.setURI(URI.create(sURI + "/" + objDevice.getName()));

			String seq = objDevice.toSequence();
			if (null != seq && !seq.isEmpty()) {
				DnaSequence dnaSeq = new DnaSequenceImpl();
				dnaSeq.setURI(URI.create(sURI + "/" + objDevice.getName()
						+ "_Sequence"));
				dnaSeq.setNucleotides(seq);
				dc.setDnaSequence(dnaSeq);
			}

			return dc;
		} else if (objComponent instanceof PartType) {
			PartType objPartType = (PartType) objComponent;

			DnaComponent c = new DnaComponentImpl();
			c.setDescription(objPartType.getName());
			c.setDisplayId(objPartType.getName());
			c.setDisplayId(sURI + "/" + objPartType.getName());

			c.setURI(URI.create(sURI + "/" + objPartType.getName()));
			c.addType(SequenceOntology.type(objPartType.getName()));

			return c;
		} else if (objComponent instanceof Part) {
			Part objPart = (Part) objComponent;

			DnaComponent c = new DnaComponentImpl();
			c.setDescription(objPart.getName());
			c.setDisplayId(objPart.getName());
			c.setDisplayId(sURI + "/" + objPart.getName());

			// SEQUENCE information
			PropertyValue pv = (PropertyValue) null;
			if (null != (pv = (PropertyValue) objPart
					.get(EugeneConstants.SEQUENCE_PROPERTY))) {
				DnaSequence seq = new DnaSequenceImpl();
				seq.setURI(URI.create(sURI + "/" + objPart.getName()
						+ "_Sequence"));
				seq.setNucleotides(pv.getTxt());
				c.setDnaSequence(seq);
			}

			c.setURI(URI.create(sURI + "/" + objPart.getName()));
			c.addType(SequenceOntology.type(objPart.getPartType().getName()));

			return c;
		} else {
			throw new EugeneException("I cannot export the "
					+ objComponent.getName() + " element to SBOL!");
		}
	}

	public static Collection convert(ComponentArray objArray, String sURI)
			throws Exception {
		if (null == objArray) {
			throw new EugeneException("I cannot export a NULL value to SBOL!");
		}

		Collection col = new CollectionImpl();
		col.setDescription(objArray.getName());
		col.setDisplayId(objArray.getName());

		try {
			col.setURI(URI.create(sURI + "/" + objArray.getName()));
		} catch (Exception e) {
			throw new EugeneException(e.toString());
		}

		if (objArray instanceof DeviceArray) {
			DeviceArray objDeviceArray = (DeviceArray) objArray;
			for (String sDeviceName : objDeviceArray.getDeviceNames()) {
				NamedElement objElement = SymbolTables.get(sDeviceName);

				if (objElement instanceof Component) {
					col.addComponent(Eugene2SBOL.convert(
							(Component) objElement,
							sURI + "/" + objArray.getName()));
				}
			}
		} else {
			throw new EugeneException(
					"Currently Eugene only supports the export of Device arrays!");
		}

		return col;
	}

	public static Collection convert(
			org.cidarlab.eugene.dom.collection.EugeneCollection objCollection) {
		Collection c = new CollectionImpl();

		return c;
	}

	public static void addURI(String s) {
		if (null == lstURIs) {
			lstURIs = new ArrayList<String>();
		}

		if (!lstURIs.contains(s)) {
			lstURIs.add(s);
		} else {
			System.out.println(s + " appears several times");

		}
	}
}
