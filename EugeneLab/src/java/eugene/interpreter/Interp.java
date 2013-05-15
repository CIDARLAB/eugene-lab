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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;

import com.rits.cloning.Cloner;

import eugene.constants.EugeneConstants;
import eugene.data.sbol.SBOLExporter;
import eugene.data.sbol.SBOLImporter;
import eugene.dom.NamedElement;
import eugene.dom.PropertyValue;
import eugene.dom.SavableElement;
import eugene.dom.Variable;
import eugene.dom.arrays.ComponentArray;
import eugene.dom.arrays.DeviceArray;
import eugene.dom.arrays.PartArray;
import eugene.dom.arrays.PartTypeArray;
import eugene.dom.arrays.PropertyArray;
import eugene.dom.collection.Collection;
import eugene.dom.collection.CollectionElement;
import eugene.dom.collection.CollectionOps;
import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.dom.components.Part;
import eugene.dom.components.Property;
import eugene.dom.components.types.DeviceType;
import eugene.dom.components.types.PartType;
import eugene.dom.functions.Function;
import eugene.dom.rules.Rule;
import eugene.exception.EugeneException;
import eugene.exception.InvalidEugeneAssignmentException;
import eugene.factory.DeviceFactory;
import eugene.output.ResultSet;
import eugene.parser.SymbolTables;
import eugene.rules.RuleEngine;

public class Interp {

	private ResultSet objResultSet;
	private Cloner cloner;

	public Interp() {
		this.objResultSet = new ResultSet();
		this.cloner = new Cloner();
	}

	/*** CREATIONAL METHODS ***/
	public Variable createVariable(String sName, String sType)
			throws EugeneException {
		if (SymbolTables.contains(sName)) {
			throw new EugeneException("There exists already an element named "
					+ sName);
		}

		Variable objVariable = EugeneBuilder.buidVariable(sName, sType);
		if (null != objVariable && null != sName) {
			SymbolTables.put(objVariable);
		}
		return objVariable;
	}

	public Property createProperty(String sName, String sType)
			throws EugeneException {
		if (SymbolTables.contains(sName)) {
			throw new EugeneException("There exists already an element named "
					+ sName);
		}
		Property objProperty = EugeneBuilder.buildProperty(sName, sType);
		SymbolTables.put(objProperty);

		return objProperty;
	}

	public PartType createPartType(String sName, List<NamedElement> lstElements)
			throws EugeneException {
		if (SymbolTables.contains(sName)) {
			throw new EugeneException("There exists already an element named "
					+ sName);
		}

		List<Property> lstProperties = (List<Property>) null;
		if (null != lstElements && !lstElements.isEmpty()) {
			lstProperties = new ArrayList<Property>(lstElements.size());
			for (NamedElement objElement : lstElements) {
				if (objElement instanceof Property) {
					Property objProperty = (Property) objElement;
					if (!lstProperties.contains(objProperty)) {
						lstProperties.add(objProperty);
					} else {
						throw new EugeneException("The part type " + sName
								+ " contains the property "
								+ objProperty.getName() + " already!");
					}
				} else {
					throw new EugeneException("The " + objElement.getName()
							+ " element is not a Property!");
				}
			}
		}

		PartType objPartType = EugeneBuilder
				.buildPartType(sName, lstProperties);
		SymbolTables.put(objPartType);
		return objPartType;
	}

	public Part createPart(PartType objPartType, String sName, List<?> lstValues)
			throws EugeneException {
		
		if (SymbolTables.contains(sName)) {
			throw new EugeneException("There exists already an element named "
					+ sName);
		}

		
		// iterate over the lstValues list
		ArrayList<PropertyValue> lstPropertyValues = null;
		if (null != lstValues) {
			lstPropertyValues = new ArrayList<PropertyValue>();

			int i = 0;
			Iterator<?> it = lstValues.iterator();
			while (it.hasNext()) {
				Object obj = it.next();
				if (obj instanceof NamedElement) {

					Property objProperty = null;
					PropertyValue objPropertyValue = null;

					NamedElement objElement = (NamedElement) obj;
					if (objElement instanceof PropertyValue) {
						objPropertyValue = (PropertyValue) objElement;

						// check if the part type has this property
						objProperty = new Property(objPropertyValue.getName(),
								objPropertyValue.getType());

						if (!objPartType.contains(objProperty)) {
							throw new EugeneException(
									"The "
											+ objPartType.getName()
											+ " part type does not contain a property named "
											+ objProperty.getName() + "!");
						}
					} else if (objElement instanceof Variable) {
						Variable objVariable = (Variable) objElement;

						if (i >= objPartType.size()) {
							throw new EugeneException("The "
									+ objPartType.getName()
									+ " part type does contain only "
									+ objPartType.size() + " properties!");
						}
						objProperty = objPartType.get(i);
						objPropertyValue = new PropertyValue(
								objProperty.getName(), objVariable.getType());
						objPropertyValue.setValue(objVariable);

					} else {
						throw new EugeneException("The " + objElement.getName()
								+ " element is not a valid property value!");
					}

					// compare both types...
					if (!objPropertyValue.getType().equals(
							objPartType.get(objProperty.getName()).getType())) {
						throw new EugeneException("The "
								+ objProperty.getName() + " property of the "
								+ objPartType.getName()
								+ " part type is not of type "
								+ objPropertyValue.getType() + "!");
					}

					lstPropertyValues.add(objPropertyValue);
				}
				i++;
			}
		}

		Part objPart = EugeneBuilder.buildPart(sName, lstPropertyValues,
				objPartType);
		SymbolTables.put(objPart);
		return objPart;
	}

	public PropertyValue createPropertyValue(String sName, NamedElement objValue)
			throws EugeneException, InvalidEugeneAssignmentException {
		if (null == objValue) {
			throw new EugeneException(
					"I cannot assign a NULL value to a property!");
		}

		if (objValue instanceof Variable) {
			return EugeneBuilder.buildPropertyValue(sName, (Variable) objValue);
		} else if (!(objValue instanceof PropertyValue)) {
			throw new EugeneException("The " + objValue.getName()
					+ " element is not of an appropriate property value!");
		}

		return EugeneBuilder
				.buildPropertyValue(sName, (PropertyValue) objValue);
	}

	public Device createDevice(String sName, List<NamedElement> lstElements)
			throws EugeneException {
		if (SymbolTables.contains(sName)) {
			throw new EugeneException("There exists already an element named "
					+ sName);
		}

		ArrayList<Component> lst = new ArrayList<Component>();
		if (null != lstElements) {
			lst = new ArrayList<Component>(lstElements.size());
			for (NamedElement objElement : lstElements) {
				if (null == objElement || !(objElement instanceof Component)) {
					throw new EugeneException("I cannot add the "
							+ objElement.getName() + " element to the " + sName
							+ " device type!");
				}
				lst.add(((Component) objElement));
			}
		}
		Device objDevice = EugeneBuilder.buildDevice(sName, lst);
		SymbolTables.put(objDevice);
		return objDevice;
	}

	public DeviceType createDeviceType(String sName,
			List<NamedElement> lstElements) throws EugeneException {
		if (SymbolTables.contains(sName)) {
			throw new EugeneException("There exists already an element named "
					+ sName);
		}

		for (NamedElement objElement : lstElements) {
			if (null == objElement
					|| !(objElement instanceof Part
							|| objElement instanceof PartType
							|| objElement instanceof Device || objElement instanceof Collection)) {
				throw new EugeneException("I cannot add the "
						+ objElement.getName() + " element to the " + sName
						+ " device type!");
			}
		}

		DeviceType objDeviceType = EugeneBuilder.buildDeviceType(sName,
				lstElements);
		SymbolTables.put(objDeviceType);
		return objDeviceType;
	}

	public Rule createRule(String sName, String sDevice, Token token,
			CommonTree tree) throws EugeneException {

		// check if Rule does not exist already
		if (null != sName && SymbolTables.contains(sName)) {
			throw new EugeneException("There exists already an element named "
					+ sName + "!");
		}

		// check if the specified rule operands exist
		if (null != tree) {
			try {
				RuleEngine.checkRuleOperands(tree);
			} catch (Exception e) {
				throw new EugeneException(e.getMessage());
			}
		}

		// if the rule is defined on a device, then check if the device exists
		// and the
		// given element is a device
		Device objDevice = (Device) null;
		if (null != sDevice) {
			if (null != sDevice && !SymbolTables.contains(sDevice)) {
				throw new EugeneException("I don't know any device named "
						+ sDevice + "!");
			}

			NamedElement objElement = SymbolTables.get(sDevice);
			if (!(objElement instanceof Device)) {
				throw new EugeneException("The " + sDevice
						+ " element is not a device!");
			}
			objDevice = (Device) objElement;
		}

		Rule objRule = EugeneBuilder.buildRule(sName, objDevice, token, tree);

		// if there is no name specified for the rule (i.e. the rule is defined
		// in an IF statement for example),
		// then return the rule without putting it into the symbol tables
		if (null == sName) {
			return objRule;
		}

		// put the rule into the symbol tables
		SymbolTables.put(objRule);
		// System.out.println("[Interp.createRule] -> "+objRule);
		return objRule;
	}

	public eugene.dom.collection.Collection createCollection(String sName,
			java.util.Collection<NamedElement> setElements)
			throws EugeneException {
		if (SymbolTables.contains(sName)) {
			throw new EugeneException("There exists already an element named "
					+ sName + "!");
		}

		// check if all elements of the setElements set are instances of the
		// CollectionElement class
		java.util.Collection<CollectionElement> colElements = (java.util.Collection<CollectionElement>) null;
		if (null != setElements && !setElements.isEmpty()) {

			colElements = new Vector<CollectionElement>(setElements.size());

			for (NamedElement objElement : setElements) {
				if (null == objElement) {
					throw new EugeneException(
							"I cannot add a NULL element to the " + sName
									+ " collection!");
				} else if (!(objElement instanceof CollectionElement)) {
					throw new EugeneException("The " + objElement.getName()
							+ " element cannot be added to the " + sName
							+ " collection!");
				}
				colElements.add((CollectionElement) objElement);
			}
		}

		// create an instance of the Collection class
		eugene.dom.collection.Collection objCollection = EugeneBuilder
				.buildCollection(sName, colElements);

		SymbolTables.put(objCollection);

		return objCollection;
	}

	public ComponentArray createArray(String sType, String sName)
			throws EugeneException {
		// check if the sName is taken already
		if (null != SymbolTables.get(sName)) {
			throw new EugeneException("There exists already an element named "
					+ sName);
		}

		ComponentArray objArray = (ComponentArray) null;
		if (EugeneConstants.DEVICEARRAY.equals(sType)) {
			objArray = new DeviceArray(sName);
		}

		if (null != objArray) {
			SymbolTables.put(objArray);
		}

		return objArray;
	}

	/**** ASSIGNMENTS ****/
	public void assign(String sName, NamedElement objAssignElement)
			throws EugeneException, InvalidEugeneAssignmentException {
		// System.out.println("[Interp.assign] "+sName+" = "+objAssignElement);
		// 1. lookup the sName element in the symbol tables
		NamedElement objElement = SymbolTables.get(sName);
		if (null != objElement) {
			// if exists ->
			// assign the objElement element to the sName element
			objElement.assign(cloner.deepClone(objAssignElement));
		} else {
			// if !exists ->
			// create a new element dependent on the type of the right side's
			// element
			if (objAssignElement instanceof Variable) {
				objElement = new Variable(sName,
						((Variable) objAssignElement).getType());
			} else if (objAssignElement instanceof Property) {
				objElement = new Property(sName,
						((Property) objAssignElement).getType());
			} else if (objAssignElement instanceof PartType) {
				objElement = new PartType(sName);
			} else if (objAssignElement instanceof Part) {
				objElement = new Part(sName);
			} else if (objAssignElement instanceof DeviceType) {
				objElement = new DeviceType(sName);
			} else if (objAssignElement instanceof Device) {
				objElement = Device.newInstance(sName);
			} else if (objAssignElement instanceof DeviceArray) {
				objElement = new DeviceArray(sName);
			} else if (objAssignElement instanceof Rule) {
				objElement = new Rule(sName);
			} else if (objAssignElement instanceof Collection) {
				objElement = new eugene.dom.collection.Collection(sName);
			} else {
				throw new InvalidEugeneAssignmentException("The assignment of "
						+ objAssignElement.getClass().toString()
						+ " is not supported yet!");
			}

			objElement.assign(cloner.deepClone(objAssignElement));
			SymbolTables.put(objElement);
		}
	}

	// method: getPartVariable
	// description: this method returns a Property's value of a given PartType
	// instance
	// in: sInstanceName...the name of the PartType instance
	// sPropertyName...the name of the Property
	// out: the value of the Property, i.e. an object of the Variable class
	public Variable getPartPropertyValue(String sPartName, String sPropertyName) {
		NamedElement objElement = SymbolTables.get(sPartName);
		if (null == objElement || !(objElement instanceof Part)) {
			return null;
		}
		Part objPartType = (Part) objElement;
		Variable objVariable = objPartType.getPropertyValue(sPropertyName);
		return objVariable;
	}

	// ASSIGNMENT
	// ID = <expression>
	public void assignTo(String sLeftName, NamedElement objRightElement)
			throws EugeneException, InvalidEugeneAssignmentException {

		// get the type of the assignment's left side (i.e. PropertyValue,
		// PartType, PartType Instance, ...)
		NamedElement objLeftElement = SymbolTables.get(sLeftName);
		String sLeftType = null;

		// get the type of the assignment's right side
		String sRightType = this.getElementType(objRightElement);

		if (null == objLeftElement) {
			sLeftType = this.getElementType(objRightElement);
		} else {
			sLeftType = this.getElementType(objLeftElement);
		}

		if (sRightType != null && sLeftType != null
				&& sLeftType.equals(sRightType)) {
			if (EugeneConstants.DEVICE.equals(sLeftType)) {
				Device objDevice = Device.newInstance(sLeftName);
				objDevice.assign((Device) objRightElement);

				if (SymbolTables.contains(objDevice.getName())) {
					SymbolTables.remove(objDevice);
				}
				SymbolTables.put(objDevice);
			} else if (EugeneConstants.PARTTYPE.equals(sLeftType)) {
				PartType objPartType = new PartType(sLeftName);
				objPartType.assign((PartType) objRightElement);
				if (SymbolTables.contains(objPartType.getName())) {
					SymbolTables.remove(objPartType);
				}
				SymbolTables.put(objPartType);
			} else if (EugeneConstants.PART.equals(sLeftType)) {

				Part objRightPart = (Part) objRightElement;

				Part objPart = new Part(objRightPart.getPartType(), sLeftName);
				objPart.assign(objRightPart);

				if (SymbolTables.contains(objPart.getName())) {
					SymbolTables.remove(objPart);
				}
				SymbolTables.put(objPart);
			} else if (EugeneConstants.PROPERTY.equals(sLeftType)) {
				Property objProperty = new Property(sLeftName);
				objProperty.assign((Property) objRightElement);
				if (!SymbolTables.contains(objProperty.getName())) {
					SymbolTables.remove(objProperty);
				}
				SymbolTables.put(objProperty);
			} else if (EugeneConstants.VARIABLE.equals(sLeftType)) {
				Variable objRightVariable = (Variable) objRightElement;
				Variable objLeftVariable = (Variable) objLeftElement;
				if (objLeftVariable == null) {
					// create new variable
					objLeftVariable = new Variable(sLeftName,
							objRightVariable.getType());
					objLeftVariable.setValue(objRightVariable);

					// and put it into the symbol tables
					SymbolTables.put(objLeftVariable);
				}

				// compare the types of both variables
				if (objLeftVariable.getType()
						.equals(objRightVariable.getType())) {
					objLeftVariable.setValue(objRightVariable);
				} else {
					throw new InvalidEugeneAssignmentException(
							objLeftVariable.getName() + " is not of type "
									+ objRightVariable.getType());
				}
				if (SymbolTables.contains(objLeftVariable.getName())) {
					SymbolTables.remove(objLeftVariable);
				}
				SymbolTables.put(objLeftVariable);
			} else if (EugeneConstants.DEVICEARRAY.equals(sLeftType)) {

				DeviceArray objDeviceArray = new DeviceArray(sLeftName);
				objDeviceArray.setDeviceNames(new ArrayList<String>(
						((DeviceArray) objRightElement).getDeviceNames()));
				SymbolTables.put(objDeviceArray);

			} else if (EugeneConstants.PARTTYPEARRAY.equals(sLeftType)) {
				PartTypeArray objPartTypeArray = new PartTypeArray(sLeftName);

				ArrayList<PartType> lstPartTypes = ((PartTypeArray) objRightElement)
						.getPartTypes();
				for (int i = 0; i < lstPartTypes.size(); i++) {
					objPartTypeArray.add(lstPartTypes.get(i));
				}

				SymbolTables.put(objPartTypeArray);
			} else if (EugeneConstants.PARTARRAY.equals(sLeftType)) {
				PartArray objPartArray = new PartArray(sLeftName);

				ArrayList<Part> lstParts = ((PartArray) objRightElement)
						.getParts();
				for (int i = 0; i < lstParts.size(); i++) {
					objPartArray.add(lstParts.get(i));
				}

				SymbolTables.put(objPartArray);
			} else if (EugeneConstants.PROPERTYARRAY.equals(sLeftType)) {
				PropertyArray objPropertyArray = new PropertyArray(sLeftName);

				ArrayList<Property> lstProperties = ((PropertyArray) objRightElement)
						.getProperties();
				for (int i = 0; i < lstProperties.size(); i++) {
					objPropertyArray.add(lstProperties.get(i));
				}

				SymbolTables.put(objPropertyArray);
			} else if (EugeneConstants.RULE.equals(sLeftType)) {
				throw new InvalidEugeneAssignmentException(
						"We are currently working on the assignment of Rules");
			}
		} else {
			throw new InvalidEugeneAssignmentException("I cannot assign the "
					+ objRightElement + " element to " + sLeftName);
		}
	}

	// <component>.<element> = <element>
	public void assignTo(String sLeftComponent, String sLeftElement,
			NamedElement objRightElement)
			throws InvalidEugeneAssignmentException {

		NamedElement objLeftComponent = SymbolTables.get(sLeftComponent);
		if (null == objLeftComponent) {
			throw new InvalidEugeneAssignmentException("I don't know "
					+ sLeftComponent);
		} else if (objLeftComponent instanceof Device) {
			// the left side's element must be a PartType or PartType Instance
			throw new InvalidEugeneAssignmentException(
					"We are currently working on the assignment to PartTypes or PartType Instances of Devices!");
		} else if (objLeftComponent instanceof Part) {
			// the left side's element must be a Property
			Part objLeftPart = (Part) objLeftComponent;

			PartType objPartType = objLeftPart.getPartType();

			Property objLeftProperty = objPartType.getProperty(sLeftElement);
			if (null == objLeftProperty) {
				throw new InvalidEugeneAssignmentException("The "
						+ objPartType.getName()
						+ " Part Type does not contain a Property named "
						+ sLeftElement);
			}

			if (objRightElement instanceof Variable) {
				Variable objRightVariable = (Variable) objRightElement;

				// finally, compare both types
				if (!objRightVariable.getType().equals(
						objLeftProperty.getType())) {
					throw new InvalidEugeneAssignmentException(
							"Invalid assignment to Property "
									+ objLeftProperty.getName()
									+ " of PartType Instance "
									+ objLeftPart.getName() + " => "
									+ objLeftProperty.getType() + " != "
									+ objRightVariable.getType());
				}

				objLeftPart.setPropertyValue(objLeftProperty.getName(),
						((Variable) objRightElement)
								.toPropertyValue(objLeftPart));

			} else {
				throw new InvalidEugeneAssignmentException(sLeftComponent + "."
						+ sLeftElement + " = " + objRightElement
						+ " is an invalid assignment!");
			}
		}
	}

	public Variable assignVariable(String sName, Variable objRightVariable) {
		Variable objLeftVariable = new Variable(sName,
				objRightVariable.getType());
		objLeftVariable.setValue(objRightVariable);
		return objLeftVariable;
	}

	public PropertyValue assignPropertyValue(
			PropertyValue objLeftPropertyValue,
			PropertyValue objRightPropertyValue) {
		objLeftPropertyValue.setValue(objRightPropertyValue);
		return objLeftPropertyValue;
	}

	private String getElementType(NamedElement objElement) {
		if (objElement instanceof Device) {
			return EugeneConstants.DEVICE;
		} else if (objElement instanceof DeviceArray) {
			return EugeneConstants.DEVICEARRAY;
		} else if (objElement instanceof PartType) {
			return EugeneConstants.PARTTYPE;
		} else if (objElement instanceof PartTypeArray) {
			return EugeneConstants.PARTTYPEARRAY;
		} else if (objElement instanceof Part) {
			return EugeneConstants.PART;
		} else if (objElement instanceof PartArray) {
			return EugeneConstants.PARTARRAY;
		} else if (objElement instanceof Property) {
			return EugeneConstants.PROPERTY;
		} else if (objElement instanceof PropertyArray) {
			return EugeneConstants.PROPERTYARRAY;
		} else if (objElement instanceof Variable) {
			return EugeneConstants.VARIABLE;
		} else if (objElement instanceof Rule) {
			return EugeneConstants.RULE;
		}
		return null;
	}

	public String getVariable(Variable objVariable) {
		if (null != objVariable) {
			if (EugeneConstants.TXT.equals(objVariable.getType())) {
				return objVariable.getTxt();
			} else if (EugeneConstants.TXTLIST.equals(objVariable.getType())) {
				return objVariable.getTxtList().toString();
			} else if (EugeneConstants.NUM.equals(objVariable.getType())) {
				return new Double(objVariable.getNum()).toString();
			} else if (EugeneConstants.NUMLIST.equals(objVariable.getType())) {
				return objVariable.getNumList().toString();
			} else if (EugeneConstants.BOOLEAN.equals(objVariable.getType())) {
				return new Boolean(objVariable.getBoolean()).toString();
			}
		}
		return null;
	}

	// <element> + <element>
	public NamedElement add(NamedElement leftElement, NamedElement rightElement)
			throws EugeneException {
		if (leftElement == null) {
			return rightElement;
		} else if (rightElement == null) {
			return leftElement;
		} else if (leftElement instanceof Device
				&& rightElement instanceof Device) {
			// <device> + <device>
			// System.out.println("add "+leftElement);
			// System.out.println("and "+rightElement);

			List<Component> lst = new ArrayList<Component>(
					((Device) leftElement).getComponents());
			lst.addAll(((Device) rightElement).getComponents());
			// System.out.println("[Interp.add] -> buildDevice");
			return EugeneBuilder.buildDevice(leftElement.getName() + "_"
					+ rightElement.getName(), lst);
		} else if (leftElement instanceof PartType
				&& rightElement instanceof PartType) {
			// <PartType> + <PartType>
		} else if (leftElement instanceof Part && rightElement instanceof Part) {
			// <PartType instance> + <PartType instance>
		} else if (leftElement instanceof Rule && rightElement instanceof Rule) {
			// <rule> + <rule>
		} else if (leftElement instanceof Variable
				&& rightElement instanceof Variable) {
			// <variable> + <variable>
			return ((Variable) leftElement).add((Variable) rightElement);
		} else if (leftElement instanceof Collection
				&& rightElement instanceof Collection) {
			// <collection> + <collection>
			return CollectionOps.union((Collection) leftElement,
					(Collection) rightElement);
		}
		throw new EugeneException("I cannot add " + leftElement + " and "
				+ rightElement);
	}

	// <element> - <element>
	public NamedElement subtract(NamedElement leftElement,
			NamedElement rightElement) {
		if (leftElement == null) {
			return rightElement;
		} else if (rightElement == null) {
			return leftElement;

		} else if (leftElement instanceof Device
				&& rightElement instanceof Device) {
			// <device> - <device>
		} else if (leftElement instanceof PartType
				&& rightElement instanceof PartType) {
			// <PartType> - <PartType>
		} else if (leftElement instanceof Part && rightElement instanceof Part) {
			// <PartType instance> - <PartType instance>
		} else if (leftElement instanceof Rule && rightElement instanceof Rule) {
			// <rule> - <rule>
		} else if (leftElement instanceof Variable
				&& rightElement instanceof Variable) {
			// <property value> - <property value>
			return subtractVariables((Variable) leftElement,
					(Variable) rightElement);
		} else if (leftElement instanceof Collection
				&& rightElement instanceof Collection) {
			// <collection> / <collection>
			return CollectionOps.minus((Collection) leftElement,
					(Collection) rightElement);
		}

		return null;
	}

	public Variable subtractVariables(Variable val1, Variable val2) {
		Variable retVal = null;
		if (EugeneConstants.NUM.equals(val1.getType())
				&& EugeneConstants.NUM.equals(val2.getType())) {

			retVal = new Variable(null, EugeneConstants.NUM);
			retVal.setNum(val1.getNum() - val2.getNum());
		}
		return retVal;
	}

	// <element> * <element>
	public NamedElement multiply(NamedElement leftElement,
			NamedElement rightElement) {
		if (leftElement == null) {
			return rightElement;
		} else if (rightElement == null) {
			return leftElement;
		} else if (leftElement instanceof Variable
				&& rightElement instanceof Variable) {
			Variable objLeft = (Variable) leftElement;
			Variable objRight = (Variable) rightElement;
			if (EugeneConstants.NUM.equals(objLeft.getType())
					&& EugeneConstants.NUM.equals(objRight.getType())) {
				Variable objRetVal = new Variable("MULTIPLY-RESULT",
						EugeneConstants.NUM);
				objRetVal.setNum(objLeft.getNum() * objRight.getNum());
				return objRetVal;
			}
		}

		return null;
	}

	// <element> / <element>
	public NamedElement divide(NamedElement leftElement,
			NamedElement rightElement) {
		if (leftElement == null) {
			return rightElement;
		} else if (rightElement == null) {
			return leftElement;
		} else if (leftElement instanceof Variable
				&& rightElement instanceof Variable) {
			Variable objLeft = (Variable) leftElement;
			Variable objRight = (Variable) rightElement;
			if (EugeneConstants.NUM.equals(objLeft.getType())
					&& EugeneConstants.NUM.equals(objRight.getType())) {
				Variable objRetVal = new Variable("DIVISION-RESULT",
						EugeneConstants.NUM);
				objRetVal.setNum(objLeft.getNum() / objRight.getNum());
				return objRetVal;
			}
		}
		return null;
	}

	public boolean and(NamedElement leftElement, NamedElement rightElement)
			throws EugeneException {
		boolean bLeft = false, bRight = false;

		// evaluate the left element
		if (leftElement instanceof Rule) {
			bLeft = RuleEngine.evaluateIfRule((Rule) leftElement);
		} else if (leftElement instanceof Variable) {
			Variable objVariable = (Variable) leftElement;
			if (EugeneConstants.BOOLEAN.equals(objVariable.getType())) {
				bLeft = objVariable.getBoolean();
			} else {
				throw new EugeneException("The value of "
						+ leftElement.getName()
						+ " at the left side is not of type BOOLEAN!");
			}
		} else {
			throw new EugeneException(
					"Cannot apply the AND operator, because the element at the left side "
							+ leftElement.getName()
							+ " is not a Rule, nor a Variable!");
		}

		// evaluate the right element
		if (rightElement instanceof Rule) {
			bRight = RuleEngine.evaluateIfRule((Rule) rightElement);
		} else if (rightElement instanceof Variable) {
			Variable objVariable = (Variable) rightElement;
			if (EugeneConstants.BOOLEAN.equals(objVariable.getType())) {
				bRight = objVariable.getBoolean();
			} else {
				throw new EugeneException("The value of "
						+ rightElement.getName()
						+ " at the right side is not of type BOOLEAN!");
			}
		} else {
			throw new EugeneException(
					"Cannot apply the AND operator, because the element at the right side "
							+ rightElement.getName()
							+ " is not a Rule nor a Variable!");
		}

		return bLeft & bRight;
	}

	// <element> OR <element>
	public boolean or(NamedElement leftElement, NamedElement rightElement)
			throws EugeneException {
		boolean bLeft = false, bRight = false;

		// evaluate the left element
		if (leftElement instanceof Rule) {
			bLeft = RuleEngine.evaluateIfRule((Rule) leftElement);
		} else if (leftElement instanceof Variable) {
			Variable objVariable = (Variable) leftElement;
			if (EugeneConstants.BOOLEAN.equals(objVariable.getType())) {
				bLeft = objVariable.getBoolean();
			} else {
				throw new EugeneException("The value of "
						+ leftElement.getName()
						+ " at the left side is not of type BOOLEAN!");
			}
		} else {
			throw new EugeneException(
					"Cannot apply the OR operator, because the element at the left side "
							+ leftElement.getName()
							+ " is not a Rule nor a Variable");
		}

		// evaluate the right element
		if (rightElement instanceof Rule) {
			bRight = RuleEngine.evaluateIfRule((Rule) rightElement);
		} else if (rightElement instanceof Variable) {
			Variable objVariable = (Variable) rightElement;
			if (EugeneConstants.BOOLEAN.equals(objVariable.getType())) {
				bRight = objVariable.getBoolean();
			} else {
				throw new EugeneException("The value of "
						+ rightElement.getName()
						+ " at the right side is not of type BOOLEAN!");
			}
		} else {
			throw new EugeneException(
					"Cannot apply the OR operator, because the element at the right side "
							+ rightElement.getName()
							+ " is not a Rule nor a Variable!");
		}

		return bLeft | bRight;
	}

	// <element> XOR <element>
	public boolean xor(NamedElement leftElement, NamedElement rightElement)
			throws EugeneException {
		boolean bLeft = false, bRight = false;

		// evaluate the left element
		if (leftElement instanceof Rule) {
			bLeft = RuleEngine.evaluateIfRule((Rule) leftElement);
		} else if (leftElement instanceof Variable) {
			Variable objVariable = (Variable) leftElement;
			if (EugeneConstants.BOOLEAN.equals(objVariable.getType())) {
				bLeft = objVariable.getBoolean();
			} else {
				throw new EugeneException("The value of "
						+ leftElement.getName()
						+ " at the left side is not of type BOOLEAN!");
			}
		} else {
			throw new EugeneException(
					"Cannot apply the XOR operator, because the element at the left side "
							+ leftElement.getName()
							+ " is not a Rule nor a Variable!");
		}

		// evaluate the right element
		if (rightElement instanceof Rule) {
			bRight = RuleEngine.evaluateIfRule((Rule) rightElement);
		} else if (rightElement instanceof Variable) {
			Variable objVariable = (Variable) rightElement;
			if (EugeneConstants.BOOLEAN.equals(objVariable.getType())) {
				bRight = objVariable.getBoolean();
			} else {
				throw new EugeneException("The value of "
						+ rightElement.getName()
						+ " at the right side is not of type BOOLEAN!");
			}
		} else {
			throw new EugeneException(
					"Cannot apply the XOR operator, because the element at the right side "
							+ rightElement.getName()
							+ " is not a Rule nor a Variable!");
		}

		return bLeft ^ bRight;
	}

	// <element> NOT <element>
	public NamedElement not(NamedElement objElement) {
		if (objElement instanceof Variable) {
			Variable objVariable = (Variable) objElement;
			if (EugeneConstants.BOOLEAN.equals(objVariable.getType())) {
				objVariable.setBoolean(!objVariable.getBoolean());
				return objVariable;
			}
		}
		return null;
	}

	public boolean isDevice(String sDeviceName) {
		NamedElement objElement = SymbolTables.get(sDeviceName);
		if (objElement != null && objElement instanceof Device) {
			return true;
		}
		return false;
	}

	public boolean isFunction(String sFunctionName) {
		NamedElement objElement = SymbolTables.get(sFunctionName);
		if (objElement != null && objElement instanceof Function) {
			return true;
		}
		return false;
	}

	public boolean isPartType(String sPartTypeName) {
		NamedElement objElement = SymbolTables.get(sPartTypeName);
		if (objElement != null && objElement instanceof PartType) {
			return true;
		}
		return false;
	}

	public boolean isPart(String sPartName) {
		NamedElement objElement = SymbolTables.get(sPartName);
		if (objElement != null && objElement instanceof Part) {
			return true;
		}
		return false;
	}

	/*** get wrapper ***/
	public NamedElement get(String sName) {
		if (null != sName) {
			return SymbolTables.get(sName);
		}
		return (NamedElement) null;
	}

	public NamedElement get(NamedElement objElement, NamedElement objIdx)
			throws EugeneException {
		if (objIdx instanceof Variable) {

		}

		throw new EugeneException("Invalid use of the get() function!");
	}

	// <objElement> . get ( <sName> )
	// e.g. device.get("promoter")
	public NamedElement get(NamedElement objElement, String sName)
			throws EugeneException {
		if (null == objElement) {
			throw new EugeneException("Invalid use of the get() function!");
		} else if (!(objElement instanceof Component)
				&& !(objElement instanceof ComponentArray)
				&& !(objElement instanceof eugene.dom.collection.Collection)) {
			throw new EugeneException(
					"The get() function is only available on the "
							+ objElement.getName() + " element!");
		}

		if (null == sName) {
			throw new EugeneException(
					"Invalid parameter for the get() function!");
		}

		NamedElement obj = SymbolTables.get(sName);
		if (null != obj) {
			if (obj instanceof Variable) {
				Variable objVar = (Variable) obj;
				if (EugeneConstants.NUM.equals(objVar.getType())) {
					return this.get(objElement, (int) objVar.getNum());
				} else if (EugeneConstants.TXT.equals(objVar.getType())) {
					return this.get(objElement, objVar.getTxt());
				}
			}
		}

		return objElement.get(sName);
	}

	public NamedElement get(String sName, String sElementName)
			throws EugeneException {

		if (null != sName && !sName.isEmpty() && null != sElementName
				&& !sElementName.isEmpty()) {
			NamedElement objElement = SymbolTables.get(sName);
			if (null == objElement) {
				throw new EugeneException("I don't know anything about "
						+ sName + "!");
			}
			return this.get(objElement, sElementName);
		}
		return (NamedElement) null;
	}

	// <objElement> . get ( <objIdx> )
	// e.g. array.get(1);
	public NamedElement get(NamedElement objElement, double idx)
			throws EugeneException {
		if (null == objElement) {
			throw new EugeneException("Invalid use of the get() function!");
		} else if (!(objElement instanceof Component)
				&& !(objElement instanceof ComponentArray)
				&& !(objElement instanceof Collection)) {
			throw new EugeneException(
					"The get() function is not available on the "
							+ objElement.getName() + " element!");
		}

		return objElement.get((int) idx);
	}

	public NamedElement get(String sName, double idx) throws EugeneException {
		if (null != sName && !sName.isEmpty() && idx >= 0) {
			NamedElement objElement = SymbolTables.get(sName);
			if (null == objElement) {
				throw new EugeneException("I don't know anything about "
						+ sName + "!");
			}
			return this.get(objElement, idx);
		}
		return (NamedElement) null;
	}

	/**** RULE EVALUATION METHODS ****/
	public void evaluateRules(NamedElement objDevice,
			List<NamedElement> lstRules, boolean bAssert)
			throws EugeneException {

		if (null != objDevice && !(objDevice instanceof Device)) {
			throw new EugeneException("The " + objDevice.getName()
					+ " element is not a device!");
		}

		List<Device> lstDevices = null;
		if (null == objDevice) {
			lstDevices = new ArrayList<Device>(SymbolTables.getDevices());
		} else {
			lstDevices = new ArrayList<Device>(1);
			lstDevices.add((Device) objDevice);
		}

		if (null == lstRules) {
			lstRules = new ArrayList<NamedElement>(SymbolTables.getRules());
		}

		if (null != lstRules && null != lstDevices) {
			for (NamedElement objElement : lstRules) {

				if (null != objElement && !(objElement instanceof Rule)) {
					throw new EugeneException("The " + objElement.getName()
							+ " element is not a rule!");
				}

				Rule r = (Rule) objElement;
				if (r.getDevice() == null) {
					for (Device d : lstDevices) {
						if (!RuleEngine.evaluate((Rule) objElement, d)) {
							if (bAssert) {
								throw new EugeneException("The " + d.getName()
										+ " device violates the "
										+ objElement.getName() + " rule!");
							} else {
								System.err.println("The " + d.getName()
										+ " device violates the "
										+ objElement.getName() + " rule!");
							}
						}
					}
				} else {
					if (!RuleEngine.evaluate(r, r.getDevice())) {
						if (bAssert) {
							throw new EugeneException("The "
									+ r.getDevice().getName()
									+ " device violates the "
									+ objElement.getName() + " rule!");
						} else {
							System.err.println("The " + r.getDevice().getName()
									+ " device violates the "
									+ objElement.getName() + " rule!");
						}
					}
				}
			}
		}
	}

	/*** PERMUTE **/
	public DeviceArray generateDevices(String sFunction,
			NamedElement objElement, NamedElement objCap, String sDegree)
			throws Exception {

		if (objElement instanceof Device) {
			return this.generateDevices(sFunction, (Device) objElement, objCap,
					sDegree);
		} else if (objElement instanceof eugene.dom.collection.Collection) {
			return this.generateDevicesFromCollection(sFunction,
					(Collection) objElement, objCap, sDegree);
		}
		throw new EugeneException("The " + objElement.getName()
				+ " element is not a Device nor a Collection!");
	}

	private DeviceArray generateDevicesFromCollection(String sFunction,
			Collection objCollection, NamedElement objCap, String sDegree)
			throws Exception {

		DeviceArray objDeviceArray = null;
		if (EugeneConstants.PERMUTE.equals(sFunction)) {
			objDeviceArray = new DeviceArray(objCollection.getName()
					+ "_PERMUTE");
		} else {
			objDeviceArray = new DeviceArray(objCollection.getName()
					+ "_PRODUCT");
		}

		// todo: generate devices out of the collection's elements
		for (Device d : objCollection.getDevices()) {
			objDeviceArray.addAll(this.generateDevices(sFunction, d, objCap,
					sDegree));
		}

		return objDeviceArray;
	}

	private DeviceArray generateDevices(String sFunction, Device objDevice,
			NamedElement objCap, String sDegree) throws Exception {

		int nCap = -1;
		if (null != objCap && objCap instanceof Variable) {
			Variable objVar = (Variable) objCap;
			if (!EugeneConstants.NUM.equals(objVar.getType())) {
				throw new EugeneException(objVar.toString()
						+ " is not a numeric value!");
			}
			try {
				nCap = (int) objVar.getNum();
			} catch (NumberFormatException nfe) {
				throw new EugeneException(objVar.getValue()
						+ " is not a valid decimal number!");
			}
		}

		DeviceArray objDeviceArray = (DeviceArray) null;

		// if degree token = null, set to strict. else string degree =
		// degreeToken.text
		if (null != sDegree
				&& EugeneConstants.STRICT.equals(sDegree.toLowerCase())) {
			objDeviceArray = DeviceFactory.generateDevices(sFunction,
					objDevice, nCap, SymbolTables.getRules());
		} else {
			objDeviceArray = DeviceFactory.generateDevices(sFunction,
					objDevice, nCap, (java.util.Collection<Rule>) null);
		}

		return objDeviceArray;
	}

	/****
	 * // product(Device, Rules, N, strict/flexible) public DeviceArray
	 * product(NamedElement objElement, NamedElement objCap, String sDegree)
	 * throws Exception {
	 * 
	 * if(null == objElement) { throw new
	 * EugeneException("Invalid element to produce devices!"); }
	 * 
	 * //System.out.println("[Interp.product] -> "+objElement.getName()+", "+
	 * objCap+", "+sDegree);
	 * 
	 * if(!(objElement instanceof Device)) { throw new EugeneException("The " +
	 * objElement.getName() + " element is not a Device!"); } Device objDevice =
	 * (Device)objElement;
	 * 
	 * int nCap = -1; if(null != objCap && objCap instanceof Variable) {
	 * Variable objVar = (Variable)objCap;
	 * if(!EugeneConstants.NUM.equals(objVar.getType())) { throw new
	 * EugeneException(objVar.toString()+" is not a numeric value!"); } try {
	 * nCap = (int)objVar.getNum(); } catch(NumberFormatException nfe) { throw
	 * new EugeneException(objVar.getValue()+" is not a valid decimal number!");
	 * } }
	 * 
	 * DeviceArray objDeviceArray = (DeviceArray)null;
	 * 
	 * //if degree token = null, set to strict. else string degree =
	 * degreeToken.text if(null!=sDegree &&
	 * EugeneConstants.STRICT.equals(sDegree.toLowerCase())) { objDeviceArray =
	 * DeviceFactory.product(objDevice, nCap, SymbolTables.getRules()); } else {
	 * objDeviceArray = DeviceFactory.product(objDevice, nCap,
	 * (java.util.Collection<Rule>)null); }
	 * 
	 * return objDeviceArray; }
	 ****/

	/*** WRAPPER STATEMENTS ***/
	public double sizeOf(String sName) throws EugeneException {

		NamedElement objElement = SymbolTables.get(sName);
		if (null == objElement) {
			throw new EugeneException(" => I don't know anything about "
					+ sName);
		}

		if (objElement instanceof Component) {
			return ((Component) objElement).size();
		} else if (objElement instanceof ComponentArray) {
			return ((ComponentArray) objElement).size();
		} else if (objElement instanceof Collection) {
			return ((Collection) objElement).size();
		} else {
			throw new EugeneException("The " + sName
					+ " element is not a biological component!");
		}
	}

	/*** SAVE Statement **/
	public void save(String sName, NamedElement objElement)
			throws EugeneException {

		// get the ID from the symbol tables
		if (null == objElement) {
			throw new EugeneException(
					"I cannot save a NULL object to the result set!");
		}

		if (!(objElement instanceof SavableElement)) {
			throw new EugeneException(
					"The "+ objElement.getName() + 
					" element is not a variable and hence cannot be saved into the result set!");
		}

		if (null != sName) {
			NamedElement objName = SymbolTables.get(sName);
			if (null == objName) {
				throw new EugeneException("I don't know anything about "
						+ sName);
			} else if (!(objName instanceof Variable)) {
				throw new EugeneException("The " + sName
						+ " element is not a variable!");
			}

			Variable objVariable = (Variable) objName;
			if (!EugeneConstants.TXT.equals(objVariable.getType())) {
				throw new EugeneException("The " + sName
						+ " variable is not of type txt!");
			}

			sName = (String) objVariable.getTxt();
		} else {
			sName = objElement.getName();
		}
		
		objResultSet.save(sName, (SavableElement) objElement);
	}

	public ResultSet getResultSet() {
		return this.objResultSet;
	}

	/*** CLEAN UP FUNCTION ***/
	public void cleanUp() {
		if (null != this.objResultSet) {
			this.objResultSet.clear();
			this.objResultSet = null;
		}
	}

	// SBOL Import
	public NamedElement importSBOL(String sFile) throws EugeneException {
		if (null == sFile || sFile.isEmpty()) {
			return (NamedElement) null;
		}

		if (sFile.startsWith("\"") && sFile.endsWith("\"")) {
			sFile = sFile.substring(1, sFile.length() - 1);
		}

		NamedElement objElement = SBOLImporter.importSBOL(sFile);
		if (null != objElement) {
			SymbolTables.put(objElement);
		}
		return objElement;
	}

	public void exportToSBOL(String sName, String sFileName)
			throws EugeneException {
		NamedElement objElement = this.get(sName);
		if (objElement == null) {
			throw new EugeneException("I don't know anything about " + sName
					+ "!");
		} else if (objElement instanceof ComponentArray) {
			SBOLExporter.serialize((ComponentArray) objElement, sFileName);
		} else if (objElement instanceof Device) {

			System.out.println("exporting the " + sName + " device to "
					+ sFileName);
		} else if (objElement instanceof eugene.dom.collection.Collection) {
			System.out.println("exporting the " + sName + " collection to "
					+ sFileName);
		} else {
			throw new EugeneException(
					"I cannot export the "
							+ sName
							+ " element to SBOL! "
							+ "Only collections, arrays, devices, parts, and part types are allowed!");
		}
	}

	/*** COMPARATIVE EXPRESSION ***/
	public Variable compare(NamedElement objLeft, String sOperator,
			NamedElement objRight) throws EugeneException {

		boolean b = false;
		if (EugeneConstants.EQUALS.equals(sOperator) || "==".equals(sOperator)) {
			b = objLeft.equals(objRight);
		} else if (EugeneConstants.NOTEQUALS.equalsIgnoreCase(sOperator)
				|| "!=".equals(sOperator)) {
			b = !objLeft.equals(objRight);
		} else if (EugeneConstants.INSTANCEOF.equalsIgnoreCase(sOperator)) {

			if (objLeft instanceof Component && objRight instanceof Component) {
				b = ((Component) objLeft).isInstanceOf(((Component) objRight)
						.getName());
			}
		} else if (objLeft instanceof Variable && objRight instanceof Variable) {
			Variable objVar1 = (Variable) objLeft;
			Variable objVar2 = (Variable) objRight;

			if (!EugeneConstants.NUM.equals(objVar1.getType())
					|| !EugeneConstants.NUM.equals(objVar2.getType())) {
				throw new EugeneException("The " + sOperator
						+ " operator is only applicable on numeric values!");
			}

			if (EugeneConstants.LT.equals(sOperator)) {
				b = ((Variable) objLeft).lt(objRight);
			} else if (EugeneConstants.LEQ.equals(sOperator)) {
				b = ((Variable) objLeft).leq(objRight);
			} else if (EugeneConstants.GEQ.equals(sOperator)) {
				b = ((Variable) objLeft).geq(objRight);
			} else if (EugeneConstants.GT.equals(sOperator)) {
				b = ((Variable) objLeft).gt(objRight);
			}
		}

		return EugeneBuilder.buildVariable(String.valueOf(b));
	}

	public boolean isInstanceOf(NamedElement objElement, String sType)
			throws EugeneException {
		if (null == objElement) {
			throw new EugeneException(
					"I cannot apply the INSTANCEOF operator on a NULL value!");
		}
		if (null == sType || sType.isEmpty()) {
			throw new EugeneException("Invalid type given!");
		}

		// objElement instanceof {Device, Part, ID}

		if (objElement instanceof Device) { // Device
			return EugeneConstants.DEVICE.equals(sType);
		} else if (objElement instanceof PartType) { // Part
			return EugeneConstants.PART.equals(sType);
		} else if (objElement instanceof Part) {
			// check if the sType is an Part (ID)
			NamedElement objType = SymbolTables.get(sType);
			if (null == objType) {
				throw new EugeneException("I don't know anything about "
						+ sType);
			}

			if (objType instanceof PartType) {
				// check if the part's (i.e. the objElement) part type is equal
				// to the given part type
				return ((Part) objElement).getPartType().getName()
						.equals(((PartType) objType).getName());
			}
			return false;
		}
		throw new EugeneException(
				"The INSTANCEOF operator is currently available only on Devices, Parts, and Part Types!");
	}
}
