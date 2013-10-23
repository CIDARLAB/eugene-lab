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

import org.cidarlab.eugene.constants.EugeneConstants;
import org.cidarlab.eugene.dom.arrays.ComponentArray;
import org.cidarlab.eugene.dom.arrays.DeviceArray;
import org.cidarlab.eugene.dom.components.Component;
import org.cidarlab.eugene.dom.components.Device;
import org.cidarlab.eugene.dom.components.Part;
import org.cidarlab.eugene.dom.components.types.PartType;
import org.cidarlab.eugene.exception.EugeneException;
import org.sbolstandard.core.Collection;
import org.sbolstandard.core.DnaComponent;
import org.sbolstandard.core.DnaSequence;
import org.sbolstandard.core.SBOLFactory;
import org.sbolstandard.core.SequenceAnnotation;
import org.sbolstandard.core.StrandType;
import org.sbolstandard.core.impl.CollectionImpl;
import org.sbolstandard.core.impl.DnaSequenceImpl;
import org.sbolstandard.core.util.SequenceOntology;


public class Eugene2SBOL {

	public static ArrayList<String> lstURIs;
	private static final String DEFAULT_URI = "http://www.eugenecad.org";
	
	public static DnaComponent convert(Component objComponent, DnaComponent parent)
			throws EugeneException {
		
		if (null == objComponent) {
			throw new EugeneException("I cannot export a NULL value to SBOL!");
		}

		DnaComponent dc = null;
		if (objComponent instanceof Device) {

			/*
			 * Eugene Device -> composite SBOL DnaComponent
			 */
			
			return toDnaComponent((Device)objComponent, parent);
			
		} else if (objComponent instanceof PartType) {
			
			/*
			 * Eugene Part Type -> SBOL DnaComponent
			 */
			
			return toDnaComponent((PartType)objComponent, parent);
			
		} else if (objComponent instanceof Part) {
			
			/*
			 * Eugene Part      -> SBOL DnaComponent
			 */
			
			return toDnaComponent((Part)objComponent, parent);
			
		} else {
			throw new EugeneException("I cannot export the " + objComponent.getName() + " element to SBOL!");
		}
		
	}

	public static DnaComponent toDnaComponent(Device objDevice, DnaComponent parent) 
			throws EugeneException {
		
		DnaComponent dc = SBOLFactory.createDnaComponent();

		/*
		 * displayId
		 */
		String deviceDisplayId = objDevice.getName();
		if(null != parent) {
			deviceDisplayId = parent.getDisplayId()+"_"+deviceDisplayId;
		}
		dc.setDisplayId(deviceDisplayId);

		/*
		 * the composite DNAComponent's description
		 */		
		dc.setDescription(objDevice.getName());
		
		/*
		 * the DNAComponent's URI
		 */
		String sURI = null;
		if(null != parent) {
			sURI = parent.getURI() + "/" + objDevice.getName();
		} else {
			sURI = DEFAULT_URI + "/"  + objDevice.getName();
		}
		dc.setURI(URI.create(sURI));

		/*
		 * n is a counter over the device's sub components
		 */
		int n = 1;
		
		/*
		 * nCurrentStrandIdx is a counter for the current index
		 * in the composite DNA strand
		 * it's used to calculate for SBOL bioStart and bioEnd
		 * (for SequenceAnnotations)
		 */
		int nCurrentStrandIdx = 1; 
		
		String subComponentDisplayIds = null;
		for (Component c : objDevice.getComponents()) {

			if(null == subComponentDisplayIds) {
				subComponentDisplayIds=c.getName();
			} else {
				subComponentDisplayIds+="_"+c.getName();
			}
			
			/*
			 * create a SequenceAnnotation for each sub component
			 */
			SequenceAnnotation sa = SBOLFactory.createSequenceAnnotation();
			if(null != parent) {
				sa.setURI(URI.create(parent.getURI() + "/" + objDevice.getName()+"/annotation_"+n));
			} else {
				sa.setURI(URI.create(DEFAULT_URI + "/" + objDevice.getName()+"/annotation_"+n));
			}
			
			/*
			 * convert the device's sub component into a SBOL DNAComponent
			 * and assign it to the current SequenceAnnoation 
			 */
			DnaComponent subComponent = Eugene2SBOL.convert(c, dc);
			sa.setSubComponent(subComponent);

			/*
			 * START and END (bioStart, bioEnd)
			 */
			int start = nCurrentStrandIdx;
			int end = -1;
			if(null != subComponent.getDnaSequence().getNucleotides()) {
				end = start + (subComponent.getDnaSequence().getNucleotides().length() - 1);
			}			
			sa.setBioStart(start);		
			sa.setBioEnd(end);

			/*
			 * STRAND / DIRECTIONALITY
			 */
			if(objDevice.getDirections()[n-1] == '+') {
				sa.setStrand(StrandType.POSITIVE);
			} else {
				sa.setStrand(StrandType.NEGATIVE);
			}
			dc.addAnnotation(sa);
			
			n++;	
			
			/*
			 * adjust the current strand index appropriately
			 */
			nCurrentStrandIdx = end + 1;				
		}

		/*
		 * complete the DNAComponent's displayId
		 */
		if(null != subComponentDisplayIds) {
			deviceDisplayId += "_"+subComponentDisplayIds;

			/*
			 * complete the DNAComponent's URI
			 */
			dc.setURI(URI.create(dc.getURI()+"_"+subComponentDisplayIds));

		}
		dc.setDisplayId(deviceDisplayId);

		/*
		 * map Eugene device onto the
		 * SO ``engineered component'' term
		 */
		dc.getTypes().add(soMapping("Device"));


		String seq = objDevice.toSequence();
		if (null != seq && !seq.isEmpty()) {
			DnaSequence dnaSeq = new DnaSequenceImpl();
			dnaSeq.setURI(URI.create(dc.getURI() + "_sequence"));
			dnaSeq.setNucleotides(seq.toLowerCase());
			dc.setDnaSequence(dnaSeq);
		}

		return dc;
	}
	
	public static DnaComponent toDnaComponent(PartType objPartType, DnaComponent parent) {
		DnaComponent c = SBOLFactory.createDnaComponent();
		
		c.setDescription(objPartType.getName());
		
		/*
		 * displayId
		 */
		if(null != parent) {
			c.setDisplayId(parent.getDisplayId()+"_"+objPartType.getName());
		} else {
			c.setDisplayId(objPartType.getName());
		}

		/*
		 * URI
		 */
		if(null != parent) {
			c.setURI(URI.create(parent.getURI()+"/"+objPartType.getName()));
		} else {
			c.setDisplayId(objPartType.getName());
		}

		/*
		 * the DNAComponent's type
		 * i.e. the part type's name mapped to an SO term
		 */
		c.addType(soMapping(objPartType.getName()));
		
		return c;
	}
	
	public static DnaComponent toDnaComponent(Part objPart, DnaComponent parent) {
		
		DnaComponent c = SBOLFactory.createDnaComponent();

		/*
		 * Part Type
		 */
		c.addType(soMapping(objPart.getPartType().getName()));

		/*
		 * name
		 */
		c.setName(objPart.getName());		
		
		/*
		 * description
		 */
		if(null != objPart.getPropertyValue(EugeneConstants.DESCRIPTION_PROPERTY)) {
			c.setDescription(objPart.getPropertyValue(EugeneConstants.DESCRIPTION_PROPERTY).getValue());
		} else {
			c.setDescription(objPart.getName());
		}
		
		/*
		 * displayId
		 */
		if(null != objPart.getPropertyValue(EugeneConstants.DISPLAY_ID_PROPERTY)) {
			c.setDisplayId(objPart.getPropertyValue(EugeneConstants.DISPLAY_ID_PROPERTY).getValue());
		} else {
			c.setDisplayId(objPart.getName());
		}

		/*
		 * URI
		 */
		URI partURI = URI.create(DEFAULT_URI + "/parts/" + objPart.getName());
		if(null != objPart.getPropertyValue(EugeneConstants.URI_PROPERTY) &&
				!objPart.getPropertyValue(EugeneConstants.URI_PROPERTY).getValue().isEmpty()) {
			partURI = URI.create(objPart.getPropertyValue(EugeneConstants.URI_PROPERTY).getValue());
		}
		c.setURI(partURI);
		
		/*
		 *  SEQUENCE information			
		 */
		if(null != objPart.getPropertyValue(EugeneConstants.SEQUENCE_PROPERTY)) {
			DnaSequence seq = SBOLFactory.createDnaSequence();
			seq.setURI(URI.create(partURI+"_sequence"));
			
			seq.setNucleotides(objPart.getPropertyValue(EugeneConstants.SEQUENCE_PROPERTY).getValue().toLowerCase());
			c.setDnaSequence(seq);
		}
		return c;
	}
	
	public static Collection convert(ComponentArray objArray, String sURI)
			throws Exception {
		if (null == objArray) {
			throw new EugeneException("I cannot export a NULL value to SBOL!");
		}


		if(null == lstURIs) {
			lstURIs = new ArrayList<String>();
		}
		
		Collection col = new CollectionImpl();
		col.setDescription(objArray.getName());
		col.setDisplayId(objArray.getName());

		try {
			col.setURI(URI.create(DEFAULT_URI + "/" + objArray.getName()));
		} catch (Exception e) {
			throw new EugeneException(e.toString());
		}

		if (objArray instanceof DeviceArray) {
			DeviceArray objDeviceArray = (DeviceArray) objArray;
			int size = objDeviceArray.size();
			
			for(int i=0; i<size; i++) {
				Device device = (Device)objDeviceArray.get(i);
				
				col.addComponent(
						toDnaComponent(
							device,
							null));
			}
		} else {
			throw new EugeneException(
					"Currently Eugene only supports the export of Device arrays!");
		}

		printURIs();
		
		lstURIs = null;
		
		return col;
	}
	
	private static void printURIs() {
		if(null == lstURIs) {
			return;
		}
		for(String s : lstURIs) {
			System.out.println(s);
		}
	}

	private static URI soMapping(String s) {

		if ("Five_Prime_UTR".equals(s)) {
			return SequenceOntology.FIVE_PRIME_UTR;
		} else if ("CDS".equals(s)) {
			return SequenceOntology.CDS;
		} else if("RBS".equals(s)) {
			try {
				return new URI("http://purl.obolibrary.org/obo/SO_0000139");
			} catch(Exception e) {}
		} else if ("Insulator".equals(s)) {
			return SequenceOntology.INSULATOR;
		} else if ("Operator".equals(s)) {
			return SequenceOntology.OPERATOR;
		} else if ("Origin_of_Replication".equals(s)) {
			return SequenceOntology.ORIGIN_OF_REPLICATION;
		} else if ("Primiter_Binding_Site".equals(s)) {
			return SequenceOntology.PRIMER_BINDING_SITE;
		} else if ("Promoter".equals(s)) {
			return SequenceOntology.PROMOTER;
		} else if ("Restriction_Enzyme_Recognition_Site".equals(s)) {
			return SequenceOntology.RESTRICTION_ENZYME_RECOGNITION_SITE;
		} else if ("Terminator".equals(s)) {
			return SequenceOntology.TERMINATOR;
		} else if("Device".equals(s)) {
			/*
			 * SO Term: Engineered Forein Region
			 */
			try {
				return new URI("http://purl.obolibrary.org/obo/SO_0000805");
			} catch(Exception e) {}
		}
		//System.out.println(s);
		return SequenceOntology.CDS;
	}

//	public static Collection convert(
//			org.cidarlab.eugene.dom.collection.EugeneCollection objCollection) {
//		Collection c = new CollectionImpl();
//
//		return c;
//	}

//	public static void addURI(String s) {
//		if (null == lstURIs) {
//			lstURIs = new ArrayList<String>();
//		}
//
//		if (!lstURIs.contains(s)) {
//			lstURIs.add(s);
//		} else {
//			System.out.println(s + " appears several times");
//
//		}
//	}
}
