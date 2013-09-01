package org.cidarlab.eugene.rules.tree.predicate;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.cidarlab.eugene.rules.RuleOperator;

import JaCoP.constraints.*;
import JaCoP.core.IntVar;
import JaCoP.core.Store;

import eugene.cache.SymbolTables;
import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.dom.components.types.PartType;
import eugene.exception.EugeneException;

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
			Store store, List<Component> components, IntVar[] variables) {
		if(variables.length <= 1 || (null != components && components.size()<=1)) {
			IntVar iv = new IntVar(store, "invalid", 1, 1);
			return new XneqC(iv, 1);
		}
		
		int a = (int)this.getA();
		int b = (int)this.getB();
		int NR_OF_VARIABLES = variables.length;
		
		
		PrimitiveConstraint[] pc = new PrimitiveConstraint[NR_OF_VARIABLES*2];
		int posA = 0;
//		pc[posA] = new IfThen(
//				new XeqC(variables[posA], a),
//				new XeqC(variables[posA+1], b));
		pc[posA] = new And(
				new XeqC(variables[posA], a),
				new XeqC(variables[posA+1], b));
		
		for(posA=1; posA<NR_OF_VARIABLES-1; posA++) {
//			pc[posA] = new IfThen(
//				new XeqC(variables[posA], a),
//				new Or(
//					new XeqC(variables[posA-1], b),
//					new XeqC(variables[posA+1], b)));
			pc[posA] = new And(
					new XeqC(variables[posA], a),
					new Or(
						new XeqC(variables[posA-1], b),
						new XeqC(variables[posA+1], b)));
		}
		
		posA = NR_OF_VARIABLES-1;		
//		pc[posA] = new IfThen(
//				new XeqC(variables[posA], a),
//				new XeqC(variables[posA-1], b));
		pc[posA] = new And(
				new XeqC(variables[posA], a),
				new XeqC(variables[posA-1], b));
		posA++;
		
		//PrimitiveConstraint[] pcB = new PrimitiveConstraint[NR_OF_VARIABLES];
		int posB = 0;
//		pc[posA+posB] = new IfThen(
//				new XeqC(variables[posB], b),
//				new XeqC(variables[posB+1], a));
		pc[posA+posB] = new And(
				new XeqC(variables[posB], b),
				new XeqC(variables[posB+1], a));
		
		for(posB=1; posB<NR_OF_VARIABLES-1; posB++) {
//			pc[posA+posB] = new IfThen(
//					new XeqC(variables[posB], b),
//					new Or(
//						new XeqC(variables[posB-1], a),
//						new XeqC(variables[posB+1], a)));
			pc[posA+posB] = new And(
					new XeqC(variables[posB], b),
					new Or(
						new XeqC(variables[posB-1], a),
						new XeqC(variables[posB+1], a)));
		}
		
		posB = NR_OF_VARIABLES-1;
//		pc[posA+posB] = new IfThen(
//				new XeqC(variables[posB], b),
//				new XeqC(variables[posB-1], a));
		pc[posA+posB] = new And(
				new XeqC(variables[posB], b),
				new XeqC(variables[posB-1], a));

		//PrimitiveConstraint b_nextto_a = new Or(pcB);
		
		return new Or(pc);
	}

}
