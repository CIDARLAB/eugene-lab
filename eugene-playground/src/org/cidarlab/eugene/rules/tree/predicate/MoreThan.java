package org.cidarlab.eugene.rules.tree.predicate;

import java.util.Arrays;
import java.util.List;

import org.cidarlab.eugene.rules.RuleOperator;

import JaCoP.constraints.Constraint;
import JaCoP.constraints.Count;
import JaCoP.core.IntVar;
import JaCoP.core.Store;
import eugene.cache.SymbolTables;
import eugene.dom.components.Component;
import eugene.exception.EugeneException;

public class MoreThan 
	extends CountingPredicate {

	public MoreThan(long A, long N) 
			throws EugeneException {				
		super(A, N);
	}

	@Override
	public boolean evaluate(long[] l) 
			throws EugeneException {

		long A = this.getA();

		
		// count the number of A's occurrences and compare it to N
		int counter = 0;
		for(long id : l) {
			if(id == A) {
				counter ++;
			}
		}
		boolean b = false;
		if(counter>this.getB()) {
			b = true;
		}
		
		//System.out.println("[MoreThan.evaluate] "+A+" MORETHAN "+this.getB()+" -> "+Arrays.toString(l)+" -> "+b);

		return b;
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
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		try {
			sb.append(SymbolTables.getNameById(this.getA()))
				.append(" ").append(RuleOperator.MORETHAN).append(" ")
				.append(this.getB());
		} catch(Exception e) {
			sb = new StringBuilder();
			sb.append(e.toString());
		}
		return sb.toString();
	}
	
	@Override
	public String getOperator() {
		return RuleOperator.MORETHAN.toString();
	}

	@Override
	public Constraint toJaCoP(
			Store store, List<Component> components, IntVar[] variables) {

		//System.out.println("imposing "+this.getA()+" MORETHAN "+this.getB());

		// a MORETHAN N
		IntVar count = new IntVar(store, "counter", (int)(this.getB()+1), components.size()); 
		return new Count(variables, count, (int)this.getA());
	}

	@Override
	public Constraint toJaCoPNot(
			Store store, List<Component> components, IntVar[] variables) {
		//System.out.println("imposing "+this.getA()+" NOTMORETHAN "+this.getB());

		// a MORETHAN N
		IntVar count = new IntVar(store, "counter", 0, (int)this.getB()); 
		return new Count(variables, count, (int)this.getA());
	}

}
