package org.cidarlab.eugene.rules.tree.predicate;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.cidarlab.eugene.rules.RuleOperator;

import JaCoP.constraints.Constraint;
import JaCoP.constraints.Or;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqC;
import JaCoP.core.IntVar;
import JaCoP.core.Store;
import eugene.cache.SymbolTables;
import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.dom.components.Part;
import eugene.dom.components.types.PartType;
import eugene.exception.EugeneException;

/*
 * ? CONTAINS B
 */
		
public class Contains 
		extends UnaryPredicate {

	public Contains(long B) 
			throws EugeneException {
		super(B);
	}
	
	public Contains(long A, long B) 
		throws EugeneException {
		super(A, B);
	}
	
	public boolean evaluate(long[] l) {
//		System.out.println("[Contains.evaluate] ON "+Arrays.toString(l)+" -> "+this.getB()+" -> "+((-1)!=ArrayUtils.indexOf(l, this.getB())));
		boolean b = (-1)!=ArrayUtils.indexOf(l, this.getB());
//		if(!b) {
//			System.err.println("[Contains] violation of "+this.toString()+"....");
//		}
		return b;
	}

	@Override
	public boolean evaluate(Device device) 
			throws EugeneException {

		Component componentB = SymbolTables.getComponent(this.getB());
		if((null != componentB && (componentB instanceof Device || componentB instanceof PartType))) {
			
			int idxB = device.getComponents().indexOf(componentB);

			return idxB != (-1);			
		}
		return this.evaluate(SymbolTables.getDeviceComponentIds(device.getName()));
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
	
		try {
			if(-1 != this.getA()) {
				sb.append(SymbolTables.getNameById(this.getA())).append(" ");
			}
			sb.append(RuleOperator.CONTAINS).append(" ").append(
					SymbolTables.getNameById(this.getB()));
		} catch (EugeneException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}

	@Override
	public boolean evaluate() 
			throws EugeneException {
		if(-1 == this.getA()) {
			throw new EugeneException("The CONTAINS rule requires a left-hand-side rule operand!");
		}
		return this.evaluate(SymbolTables.getDeviceComponentIds(this.getA()));
	}

	@Override
	public boolean evaluate(long n) 
			throws EugeneException {

		long[] device_components = SymbolTables.getAllDeviceComponentIds(n);
		//System.out.println("[Contains.evaluate("+SymbolTables.getNameById(n)+")] -> "+Arrays.toString(device_components));
		//return true;
		return this.evaluate(device_components);
	}

	@Override
	public boolean evaluate(String sDeviceName) 
			throws EugeneException {
		return this.evaluate(SymbolTables.getDeviceComponentIds(sDeviceName));
	}

	@Override
	public String getOperator() {
		return RuleOperator.CONTAINS.toString();
	}

	@Override
	public Constraint toJaCoP(Store store, List<Component> components, IntVar[] variables) {
		/*
		 * CONTAINS B
		 */

		Component componentB = this.getComponentB();
		PrimitiveConstraint[] pc = null;
		if(componentB instanceof Part) {
			//System.out.println("imposing CONTAINS "+componentB+"("+this.getB()+")");
			
			for(int p=0; p<components.size(); p++) {
				// here, we need to check if B is part of parttype components[p]
				if(components.get(p) instanceof PartType && 
					((Part)componentB).getPartType().getName().equals(((PartType)components.get(p)).getName())) {
					
					if(pc == null) {
						pc = new PrimitiveConstraint[1];
						pc[0] = new XeqC(variables[p], (int)this.getB());
					} else {					
						pc = ArrayUtils.add(pc, new XeqC(variables[p], (int)this.getB()));
					}
				} 
			}
		}
		
		if(null != pc) {
			return new Or(pc);
		}
		return null;
	}
}
