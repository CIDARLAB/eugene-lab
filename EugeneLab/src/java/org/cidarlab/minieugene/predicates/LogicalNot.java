package org.cidarlab.minieugene.predicates;

import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.predicates.counting.CountingPredicate;
import org.cidarlab.minieugene.rules.LogicalOperator;


import JaCoP.constraints.Constraint;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.Not;
import JaCoP.core.IntVar;
import JaCoP.core.Store;

public class LogicalNot 
	extends LogicalPredicate {

	private Predicate predicate;
	
	public LogicalNot(Predicate predicate) {
		this.predicate = predicate;
	}
	
	public Predicate getPredicate() {
		return this.predicate;
	}
	
	@Override
	public String getOperator() {
		return LogicalOperator.NOT.toString();
	}
	
	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("NOT ").append(this.getPredicate()).append("");
		return sb.toString();
	}
	
	@Override
	public Constraint toJaCoP(
			Store store, IntVar[] variables) 
				throws EugeneException {

		if(this.getPredicate() instanceof CountingPredicate) {
			return ((CountingPredicate)this.getPredicate()).toJaCoPNot(store, variables);
		} else if (this.getPredicate() instanceof LogicalNot) {
			return ((LogicalNot)this.getPredicate()).getPredicate().toJaCoP(store, variables);
		} else {
			return new Not((PrimitiveConstraint)this.getPredicate().toJaCoP(store, variables));
		}
	}

}
