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

package eugene.parser;

import java.util.Collection;
import java.util.Stack;

import eugene.cache.DesignSpace;
import eugene.dom.NamedElement;
import eugene.dom.StackElement;
import eugene.dom.arrays.DeviceArray;
import eugene.dom.components.Device;
import eugene.dom.components.Part;
import eugene.dom.components.types.PartType;
import eugene.dom.functions.Function;
import eugene.dom.rules.Rule;
import eugene.exception.EugeneException;

/**
 * 
 * @author Ernst Oberortner
 */
public class SymbolTables {
	/*** Symbol Tables ***/

	// hmDefinitions contains the names of all defined
	// Properties, Parts, Devices, Variables, and their instances

	// the objDesignSpace collection contains all components (i.e. Part Types,
	// Parts, and Devices)
	// that have been defined in a Eugene script
	private static Stack<StackElement> objStack;
	private static Stack<String> stCurrentFunction;

	public static void init() {
		objStack = new Stack<StackElement>();
		stCurrentFunction = new Stack<String>();
	}

	public static java.util.Collection<Rule> getRules() {
		Collection<Rule> colRules = DesignSpace.getRules();

		if (!objStack.isEmpty()) {
			StackElement objStackElement = SymbolTables.pop();
			colRules.addAll(SymbolTables.getRules());
			SymbolTables.push(objStackElement);
		}

		return colRules;
	}

	public static java.util.Collection<Device> getDevices() {
		Collection<Device> colDevices = DesignSpace.getDevices();

		if (!objStack.isEmpty()) {
			StackElement objStackElement = SymbolTables.pop();
			colDevices.addAll(SymbolTables.getDevices());
			SymbolTables.push(objStackElement);
		}

		return colDevices;
	}

	public static java.util.Collection<DeviceArray> getDeviceArrays() {
		Collection<DeviceArray> colDeviceArrays = DesignSpace.getDeviceArrays();

		if (!objStack.isEmpty()) {
			StackElement objStackElement = SymbolTables.pop();
			colDeviceArrays.addAll(SymbolTables.getDeviceArrays());
			SymbolTables.push(objStackElement);
		}

		return colDeviceArrays;
	}

	public static java.util.Collection<PartType> getPartTypes() {
		Collection<PartType> colPartTypes = DesignSpace.getPartTypes();

		if (!objStack.isEmpty()) {
			StackElement objStackElement = SymbolTables.pop();
			colPartTypes.addAll(SymbolTables.getPartTypes());
			SymbolTables.push(objStackElement);
		}

		return colPartTypes;
	}

	public static java.util.Collection<Part> getParts() {
		Collection<Part> colParts = DesignSpace.getParts();

		if (!objStack.isEmpty()) {
			StackElement objStackElement = SymbolTables.pop();
			colParts.addAll(SymbolTables.getParts());
			SymbolTables.push(objStackElement);
		}

		return colParts;
	}

	public static java.util.Collection<Part> getParts(PartType objPartType) {
		Collection<Part> colParts = DesignSpace.getParts(objPartType);

		if (!objStack.isEmpty()) {
			StackElement objStackElement = SymbolTables.pop();
			colParts.addAll(SymbolTables.getParts(objPartType));
			SymbolTables.push(objStackElement);
		}

		return colParts;
	}

	public static void cleanUp() {
		if (null != objStack) {
			objStack.clear();
			objStack = null;
		}

		DesignSpace.clear();
		System.gc();
	}

	public static void clear(String sGroup) {
		DesignSpace.clear(sGroup);
	}

	public static boolean contains(String sName) {
		return DesignSpace.contains(sName);
	}

	public static NamedElement get(String sName) {
		// System.out.println("[SymbolTables.get] "+sName+" -> stack: "+SymbolTables.peek());
		NamedElement objElement = DesignSpace.get(sName);
		if (objElement != null) {
			return objElement;
		}

		if (null != objStack && !objStack.isEmpty()) {
			StackElement objStackElement = SymbolTables.pop();
			objElement = SymbolTables.get(sName);
			SymbolTables.push(objStackElement);

			if (null != objElement) {
				return objElement;
			}
		}

		return (NamedElement) null;
	}

	public static void remove(String sName) {
		if (null != sName) {
			DesignSpace.remove(sName);
		}
	}

	public static void remove(NamedElement objElement) {
		if (null != objElement && null != objElement.getName()
				&& !objElement.getName().isEmpty()) {
			DesignSpace.remove(objElement.getName());
		}
	}

	public static void put(NamedElement objElement) throws EugeneException {
		if (null != objElement) {
			SymbolTables.put(objElement.getName(), objElement);
		}
	}

	public static void put(String sName, NamedElement objElement)
			throws EugeneException {
		if (null != sName && null != objElement) {
			try {
				DesignSpace.put(sName, objElement);
			} catch (Exception e) {
				e.printStackTrace();
				throw new EugeneException(e.getMessage());
			}
		} else {
			throw new EugeneException("I cannot put the " + objElement
					+ " element into the symbol tables!");
		}

	}

	/** STACK OPERATIONS ***/
	public static StackElement peek() {
		if (null != objStack && !objStack.isEmpty()) {
			return objStack.peek();
		}
		return null;
	}

	public static boolean push(StackElement objStackElement) {
		if (objStackElement != null) {
			if (null == objStack) {
				init();
			}
			objStack.push(objStackElement);
			if (objStackElement instanceof Function) {
				stCurrentFunction.push(((Function) objStackElement).getName());
			}
		}
		return true;
	}

	public static StackElement pop() {
		StackElement objElement = null;
		if (null != objStack && !objStack.isEmpty()) {
			objElement = objStack.pop();
			if (objElement instanceof Function) {
				stCurrentFunction.pop();
			}
		}
		return objElement;
	}

	public static String getCurrentFunctionName() {
		if (stCurrentFunction.size() > 0) {
			return stCurrentFunction.peek();
		}
		return null;
	}

}
