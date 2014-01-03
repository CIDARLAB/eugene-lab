package org.cidarlab.minieugene.predicates.interaction;

import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.rules.RuleOperator;

import JaCoP.constraints.Constraint;
import JaCoP.core.IntVar;
import JaCoP.core.Store;

public class Induces 
	extends InteractionPredicate {
	
	public Induces(int a, int b) {
		super(a, b);
	}
		

	@Override
	public String getOperator() {
		return RuleOperator.INDUCES.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getA())
			.append(" ").append(RuleOperator.INDUCES).append(" ")
			.append(this.getB());
		return sb.toString();
	}

	@Override
	public Constraint toJaCoP(Store store, IntVar[] variables) 
				throws EugeneException {
		throw new UnsupportedOperationException("THIS DOES NOT WORK YET!");
	}
	
}
