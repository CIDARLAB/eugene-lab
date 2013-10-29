package org.cidarlab.eugene.solver.jacop;

import org.cidarlab.eugene.cache.SymbolTables;
import org.cidarlab.eugene.constants.EugeneConstants;
import org.cidarlab.eugene.dom.PropertyValue;
import org.cidarlab.eugene.dom.components.Part;
import org.cidarlab.eugene.exception.EugeneException;

import JaCoP.constraints.IfThen;
import JaCoP.constraints.XeqC;
import JaCoP.core.IntVar;
import JaCoP.core.Store;

public class Eugene2JaCoP {

	public static IntVar modelPart(Part part, Store store, IntVar[] variables, int position) 
			throws EugeneException {
//		System.out.println("position -> "+position);
		int partId = (int)SymbolTables.getId(part.getName());
		IntVar partVar = (IntVar)store.findVariable(part.getName());
		if(null == partVar) {
			partVar = new IntVar(store, part.getName(), partId, partId);
			
			/*
			 * here, we need to iterate over the part's property values ...
			 */
			for(PropertyValue pv : part.getPropertyValues()) {
				/*
				 * for every property value we create a new IntVar
				 */
				IntVar propertyVar = (IntVar)store.findVariable(pv.getName());
				if(null == propertyVar) {
					propertyVar = new IntVar(store, pv.getName());
				}
				
				int value = toASCII(pv.getValue());
				propertyVar.addDom(value, value);
				
				/*
				 * now, we need to build a relationship between the part variable
				 * and the property variable
				 */
				variables[position].putConstraint(
						new IfThen(
								new XeqC(propertyVar, value),
								new XeqC(variables[position], partId)));
			}
		}
		
		/*
		 * positioning of the parts
		 */
		IntVar partPositionVar = (IntVar)store.findVariable("positions");
		if(null == partPositionVar) {
			partPositionVar = new IntVar(store, "positions", position, position);
		} else {
			partPositionVar.addDom(position, position);
		}
		
		/*
		 * now we use an Element constraint to specify the parts valid position
		 */
		
		// is this the right way???
//		store.impose(new IfThen(
//				new XeqC(partPositionVar, position),
//				new XeqC(variables[position], partId)));
		
		return partVar;
	}
	
	public static int toASCII(String s) {
		int ascii = 0;
		char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
        	ascii += (int)chars[i];
        }
        return ascii;
	}
}
