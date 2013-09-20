package org.cidarlab.eugene.rules.tree.predicate;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.cidarlab.eugene.cache.SymbolTables;
import org.cidarlab.eugene.dom.components.Component;
import org.cidarlab.eugene.dom.components.Device;
import org.cidarlab.eugene.dom.components.Part;
import org.cidarlab.eugene.dom.components.types.PartType;
import org.cidarlab.eugene.exception.EugeneException;
import org.cidarlab.eugene.rules.RuleOperator;

import JaCoP.constraints.And;
import JaCoP.constraints.Constraint;
import JaCoP.constraints.Or;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqC;
import JaCoP.constraints.XneqC;
import JaCoP.core.IntVar;
import JaCoP.core.Store;

/*
 * A NEXTTO B
 * 
 * Definition:  
 */
public class NextTo 
	extends BinaryPredicate {

	public NextTo(long A, long B) 
			throws EugeneException {
		super(A, B);
	}
	
	@Override
	public boolean evaluate(long[] l) {
		int idxA = ArrayUtils.indexOf(l, this.getA());
		int idxB = ArrayUtils.indexOf(l, this.getB());

		if(idxA!=(-1) && idxB!=(-1)) {
			return idxA+1==idxB || idxA-1==idxB || idxB+1==idxA || idxB-1==idxA;
		}
		
		return true;
		
	}

	@Override
	public boolean evaluate(long nId) 
			throws EugeneException {
		return this.evaluate(
				SymbolTables.getDeviceComponentIds(nId));		
	}
	
	@Override
	public boolean evaluate(String sDeviceName) 
			throws EugeneException {
		return this.evaluate(
				SymbolTables.getDeviceComponentIds(sDeviceName));
	}
	
	@Override
	public boolean evaluate() 
			throws EugeneException {
		throw new EugeneException(this.toString()+" requires information about a Device!");
	}

	@Override
	public boolean evaluate(Device device) 
			throws EugeneException {
		Component componentA = this.getComponentA();
		if(null == componentA) {
			componentA = SymbolTables.getComponent(this.getA());
		}
		
		Component componentB = this.getComponentB();
		if(null == componentB) {
			componentB = SymbolTables.getComponent(this.getB());
		}

		if((null != componentB && (componentB instanceof Device || componentB instanceof PartType)) &&
				null != componentA && (componentA instanceof Device || componentA instanceof PartType)) {
			
			int idxA = device.getComponents().indexOf(componentA);
			int idxB = device.getComponents().indexOf(componentB);

			if(idxA!=(-1) && idxB!=(-1)) {
				return idxA+1==idxB || idxA-1==idxB || idxB+1==idxA || idxB-1==idxA;
			}
			
		}
		return this.evaluate(SymbolTables.getDeviceComponentIds(device.getName()));
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		try {
			sb.append(SymbolTables.getNameById(this.getA()))
				.append(" ").append(RuleOperator.NEXTTO).append(" ")
				.append(SymbolTables.getNameById(this.getB()));
		} catch(Exception e) {}
		return sb.toString();
	}

	@Override
	public String getOperator() {
		return RuleOperator.NEXTTO.toString();
	}

	@Override
	public Constraint toJaCoP(
			Store store, IntVar[] variables, 
			Device device, List<Component> components) 
				throws EugeneException {

		if(variables.length <= 1 || (null != components && components.size()<=1)) {
			IntVar iv = new IntVar(store, "invalid", 1, 1);
			return new XneqC(iv, 1);
		}

//		PrimitiveConstraint[] pcA = null;

		try {
			int a = (int)this.getA();
			int b = (int)this.getB();

//			System.out.println(this.componentA.getName()+"("+a+") NEXTTO "+this.componentB.getName()+"("+b+")");
			PrimitiveConstraint[] pc = null;
			
			int i=0;
			for(Component component : components) {

				if(component instanceof Device) {
					if(null == pc) {
						pc = new PrimitiveConstraint[1];
						pc[0] = (PrimitiveConstraint)this.toJaCoP(
								store, variables, (Device)device, ((Device)component).getComponents());
					} else {
						pc = ArrayUtils.add(pc, (PrimitiveConstraint)this.toJaCoP(
								store, variables, (Device)device, ((Device)component).getComponents()));
					}

				} else if(this.componentA instanceof Part && component instanceof PartType &&
						((Part)this.componentA).getPartType().equals((PartType)component)) {

					if(i == 0) {

						PrimitiveConstraint pConst = new And(new XeqC(variables[i], a), new XeqC(variables[i+1], b));

						if(null == pc) {
							pc = new PrimitiveConstraint[1];
							pc[0] = pConst;
						} else {
							pc = ArrayUtils.add(pc, pConst);
						}

					} else if (i==components.size()-1) {
						PrimitiveConstraint pConst = new And(new XeqC(variables[i], a), new XeqC(variables[i-1], b)); 
						if(null == pc) {
							pc = new PrimitiveConstraint[1];
							pc[0] = pConst;
						} else {
							pc = ArrayUtils.add(pc, pConst);
						}
						
					} else {
						PrimitiveConstraint pConst = new And(new XeqC(variables[i], a), 
															new Or(new XeqC(variables[i-1], b), new XeqC(variables[i+1], b)));

						if(null == pc) {
							pc = new PrimitiveConstraint[1];
							pc[0] = pConst;
						} else {
							pc = ArrayUtils.add(pc, pConst);
						}
						
					} 

				}	
	
				
				i++;
			}

			if(null != pc) {
				return new Or(pc);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	/*** toJaCoP for the ``positioning'' approach
	@Override
	public Constraint toJaCoP(
			Store store, List<Component> components, IntVar[] variables) {
		int a = (int)this.getA();
		int b = (int)this.getB();

		
		IntVar ivA = (IntVar)store.findVariable(String.valueOf(a));
		IntVar ivB = (IntVar)store.findVariable(String.valueOf(b));
		
		return new Or(
				new Or(new XplusCeqZ(ivA, 1, ivB), new XplusCeqZ(ivA, -1, ivB)),
				new Or(new XplusCeqZ(ivB, 1, ivA), new XplusCeqZ(ivB, -1, ivA)));

	}
	****/
}
