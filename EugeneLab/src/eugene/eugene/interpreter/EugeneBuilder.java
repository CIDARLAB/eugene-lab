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

package eugene.interpreter;

import java.util.List;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;

import com.rits.cloning.Cloner;

import eugene.constants.EugeneConstants;
import eugene.dom.NamedElement;
import eugene.dom.PropertyValue;
import eugene.dom.Variable;
import eugene.dom.collection.Collection;
import eugene.dom.collection.CollectionElement;
import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.dom.components.Part;
import eugene.dom.components.Property;
import eugene.dom.components.types.DeviceType;
import eugene.dom.components.types.PartType;
import eugene.dom.rules.Rule;
import eugene.exception.EugeneException;
import eugene.exception.InvalidEugeneAssignmentException;

public class EugeneBuilder {

	private static Cloner cloner = new Cloner();

	/**
	 * public EugeneBuilder() { this.cloner = new Cloner(); }
	 **/

	public static Property buildProperty(String sName, String sType) {
		return new Property(sName, sType);
	}

	public static Variable buidVariable(String sName, String sType) {
		return new Variable(sName, sType);
	}

	public static PropertyValue buildPropertyValue(String sName,
			Variable objVariable) {
		PropertyValue objPropertyValue = new PropertyValue(sName,
				objVariable.getType());
		objPropertyValue.setValue((Variable) objVariable);
		return objPropertyValue;
	}

	public static PropertyValue buildPropertyValue(String sName,
			PropertyValue objValue) throws InvalidEugeneAssignmentException {
		PropertyValue objPropertyValue = new PropertyValue(sName,
				objValue.getType());
		objPropertyValue.assign(objValue);
		return objPropertyValue;
	}

	public static Device buildDevice(String sName, List<Component> lstElements)
			throws EugeneException {
		return Device.newInstance(sName, lstElements);
	}

	public static DeviceType buildDeviceType(String sName,
			List<NamedElement> lstElements) throws EugeneException {
		return new DeviceType(sName, lstElements);
	}

	public static Rule buildRule(String sName, Device objDevice, Token token,
			CommonTree tree) throws EugeneException {
		return new Rule(sName, objDevice, token, tree);
	}

	public static PartType buildPartType(String sName,
			List<Property> lstProperties) {
		PartType objPartType = new PartType(sName);
		if (null != lstProperties && !lstProperties.isEmpty()) {
			for (Property p : lstProperties) {
				objPartType.addProperty(cloner.deepClone(p));
			}
		}
		return objPartType;
	}

	public static Part buildPart(String sName, List<PropertyValue> lstValues,
			PartType objPartType) throws EugeneException {

		Part objPart;
		try {
			objPart = new Part(objPartType, sName);
		} catch (InvalidEugeneAssignmentException e) {
			throw new EugeneException(e.getMessage());
		}

		if (null != lstValues && !lstValues.isEmpty()) {
			// assign the property values to the part
			for (PropertyValue objValue : lstValues) {
				objPart.setPropertyValue(objValue.getName(), objValue);
			}
		}

		return objPart;
	}

	public static Collection buildCollection(String sName,
			java.util.Collection<CollectionElement> setElements) {
		Collection objCollection = new Collection(sName);
		if (null != setElements && !setElements.isEmpty()) {
			for (CollectionElement objElement : setElements) {
				objCollection.add(objElement);
			}
		}
		return objCollection;
	}

	public static Variable buildVariable(String sValue) {
		Variable objVar = null;
		if (null == sValue || sValue.isEmpty()) {
			return (Variable) null;
		}

		// txt
		if (sValue.startsWith("\"") && sValue.endsWith("\"")) {
			objVar = new Variable(null, EugeneConstants.TXT);
			objVar.setTxt(sValue.substring(1, sValue.length() - 1));
			return objVar;
		}

		// bool
		if ("true".equals(sValue.toLowerCase())) {
			objVar = new Variable(null, EugeneConstants.BOOLEAN);
			objVar.setBoolean(true);
			return objVar;
		} else if ("false".equals(sValue.toLowerCase())) {
			objVar = new Variable(null, EugeneConstants.BOOLEAN);
			objVar.setBoolean(false);
			return objVar;
		}

		// num
		try {
			double num = Double.parseDouble(sValue);
			objVar = new Variable(null, EugeneConstants.NUM);
			objVar.setNum(num);
			return objVar;
		} catch (Exception e) {
		}

		// TODO: num[], txt[]

		objVar = EugeneBuilder.buidVariable(null, EugeneConstants.TXT);
		objVar.setTxt(sValue);

		return objVar;
	}
}
