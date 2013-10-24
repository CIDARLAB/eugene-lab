package org.cidarlab.eugene.algorithm;

import java.util.List;

import org.cidarlab.eugene.cache.SymbolTables;
import org.cidarlab.eugene.dom.NamedElement;
import org.cidarlab.eugene.dom.arrays.DeviceArray;
import org.cidarlab.eugene.dom.components.Device;
import org.cidarlab.eugene.dom.rules.Rule;
import org.cidarlab.eugene.exception.EugeneException;
import org.cidarlab.eugene.solver.jacop.JaCoPSolver;


public class Product {

	public static DeviceArray product(String sDeviceName, int N) 
			throws EugeneException {
		
//		 old:
		return SymbolTables.product(sDeviceName, N);
		
//		/*
//		 * first, we need to retrieve the device from the symbol tables
//		 */
//		NamedElement element = SymbolTables.get(sDeviceName);
//		if(element == null) {
//			throw new EugeneException("I don't know "+sDeviceName+"!");
//		}
//		if(!(element instanceof Device)) {
//			throw new EugeneException(sDeviceName+" is not a Device!");
//		}
//		
//		/*
//		 * second, we retrieve all rules from the symbol tables
//		 * that were defined on the device
//		 */
//		List<Rule> rules = SymbolTables.getDeviceRules(((Device)element).getName());
//		
//		/*
//		 * finally, we invoke the constraint solver to 
//		 * model and solve the problem
//		 */
//		return new JaCoPSolver().solveProduct(
//				(Device)element, 
//				rules, 
//				N);
	}
	
}
