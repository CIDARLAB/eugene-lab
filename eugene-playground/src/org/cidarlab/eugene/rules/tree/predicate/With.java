package org.cidarlab.eugene.rules.tree.predicate;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.cidarlab.eugene.rules.RuleOperator;

import JaCoP.constraints.Constraint;
import JaCoP.constraints.Or;
import JaCoP.constraints.And;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqC;
import JaCoP.constraints.XneqC;
import JaCoP.core.IntVar;
import JaCoP.core.Store;

import eugene.cache.SymbolTables;
import eugene.dom.components.Component;
import eugene.exception.EugeneException;

public class With 
		extends BinaryPredicate {

	public With(long A, long B) 
			throws EugeneException {
		super(A, B);
	}
	
	public boolean evaluate(long[] elements) {		
		return (-1)!=ArrayUtils.indexOf(elements, this.getB()) && (-1)!=ArrayUtils.indexOf(elements, this.getA());
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		try { 
		sb.append(SymbolTables.getNameById(this.getA())).append(" ")
			.append(RuleOperator.WITH).append(" ")
			.append(SymbolTables.getNameById(this.getB()));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	@Override
	public boolean evaluate() 
			throws EugeneException {
		if(-1 == this.getA()) {
			throw new EugeneException("The "+RuleOperator.WITH+" requires a left-hand-side rule operand!");
		}
		return this.evaluate(SymbolTables.getDeviceComponentIds(this.getA()));
	}

	@Override
	public boolean evaluate(long n) 
			throws EugeneException {
		long[] device_components = SymbolTables.getAllDeviceComponentIds(n);
		//System.out.println("[Contains.evaluate("+SymbolTables.getNameById(n)+")] -> "+
		//		this.toString()+" -> "+Arrays.toString(device_components) + " -> "+this.evaluate(device_components));
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
		return RuleOperator.WITH.toString();
	}


	@Override
	public Constraint toJaCoP(
			Store store, List<Component> components, IntVar[] variables) {
		int a = (int)this.getA();
		int b = (int)this.getB();
		int NR_OF_VARIABLES = variables.length;
		
		// a WITH b ::= CONTAINS a AND CONTAINS b 
		PrimitiveConstraint[] pcA = new PrimitiveConstraint[NR_OF_VARIABLES];		
		PrimitiveConstraint[] pcB = new PrimitiveConstraint[NR_OF_VARIABLES];		
		
		for(int p=0; p<NR_OF_VARIABLES; p++) {
			pcA[p] = new And(
						new XeqC(variables[p], a), 
						new XneqC(variables[p], b));
			pcB[p] = new And(
						new XeqC(variables[p], b), 
						new XneqC(variables[p], a));
		}
		
		return new And(
				new Or(pcA),
				new Or(pcB));		
	}

}
