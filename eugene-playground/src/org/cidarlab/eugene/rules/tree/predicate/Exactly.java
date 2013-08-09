package org.cidarlab.eugene.rules.tree.predicate;

import java.util.List;

import org.cidarlab.eugene.rules.RuleOperator;

import JaCoP.constraints.Constraint;
import JaCoP.constraints.Count;
import JaCoP.core.IntVar;
import JaCoP.core.Store;
import eugene.cache.SymbolTables;
import eugene.dom.components.Component;
import eugene.exception.EugeneException;

public class Exactly 
	extends BinaryPredicate {

	private long A;
	private long N;
	
	public Exactly(long A, long N) 
			throws EugeneException {				
		super(A, N);
	}

	@Override
	public boolean evaluate(long[] l) 
			throws EugeneException {

		// count the number of A's occurrences and compare it to N
		
		return false;
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
	
	public long getA() {
		return this.A;
	}

	public long getB() {
		return this.N;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getA())
				.append(" ").append(RuleOperator.EXACTLY).append(" ")
			.append(this.getB());
		/**
		try {
			sb.append(SymbolTables.getNameById(this.getA()))
					.append(" ").append(RuleOperator.AFTER).append(" ")
				.append(SymbolTables.getNameById(this.getB()));
		} catch (EugeneException e) {
			e.printStackTrace();
			return null;
		}
		**/
		return sb.toString();
	}
	
	@Override
	public String getOperator() {
		return RuleOperator.EXACTLY.toString();
	}

	@Override
	public Constraint toJaCoP(
			Store store, List<Component> components, IntVar[] variables) {

		//System.out.println("imposing "+this.getA()+" MORETHAN "+this.getB());

		// a MORETHAN N
		IntVar count = new IntVar(store, "counter", (int)(this.getB()), (int)(this.getB())); 
		return new Count(variables, count, (int)this.getA());
	}
}
