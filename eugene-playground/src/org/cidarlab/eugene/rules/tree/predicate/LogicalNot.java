package org.cidarlab.eugene.rules.tree.predicate;

import java.util.BitSet;
import java.util.List;

import org.cidarlab.eugene.rules.LogicalOperator;

import eugene.dom.components.Component;
import eugene.exception.EugeneException;

import JaCoP.constraints.Constraint;
import JaCoP.constraints.Not;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqC;
import JaCoP.core.IntVar;
import JaCoP.core.Store;

public class LogicalNot 
	implements LogicalPredicate {

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
	public Constraint toJaCoP(Store store, List<Component> components, IntVar[] variables) {
//		System.out.println("[LogicalNot] -> "+components+" -> "+this.getPredicate().getClass());
		if(this.getPredicate() instanceof CountingPredicate) {
			store.impose(((CountingPredicate)this.getPredicate()).toJaCoPNot(store, components, variables));
						
			// in this case, we return an ``always true'' constraint
			IntVar iv = new IntVar(store, "tmp", -1, -1);
			return new XeqC(iv, -1);
//		} else if(this.getPredicate() instanceof RuleID) {
//			return ((RuleID)this.getPredicate()).toJaCoP(store, components, variables);
		} else {
			return new JaCoP.constraints.Not(
					(PrimitiveConstraint) this.getPredicate().toJaCoP(store, components, variables));
		}
	}

	@Override
	public boolean evaluate(long[] l) 
			throws EugeneException {
		return !(this.getPredicate().evaluate(l));
	}

}
