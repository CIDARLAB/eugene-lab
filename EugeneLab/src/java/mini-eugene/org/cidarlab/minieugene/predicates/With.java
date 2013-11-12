package org.cidarlab.minieugene.predicates;

import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.rules.RuleOperator;

import JaCoP.constraints.Constraint;
import JaCoP.constraints.Count;
import JaCoP.core.IntVar;
import JaCoP.core.Store;


public class With 
		extends BinaryPredicate {

	public With(int a, int b) {
		super(a, b);
	}

	@Override	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getA()).append(" ")
			.append(RuleOperator.WITH).append(" ")
			.append(this.getB());
		return sb.toString();
	}

	@Override
	public String getOperator() {
		return RuleOperator.WITH.toString();
	}


	@Override
	public Constraint toJaCoP(Store store, IntVar[] variables) 
				throws EugeneException {

		/*
		 * a must appear at least once AND
		 * b must appear at lease once 
		 */

		IntVar counterA = (IntVar)store.findVariable("CONTAINS_"+this.getA()+"-counter");
		if( null == counterA ) {
			counterA = new IntVar(store, "CONTAINS_"+this.getA()+"-counter", 1, variables.length);
		}

		IntVar counterB = (IntVar)store.findVariable("CONTAINS_"+this.getA()+"-counter");
		if( null == counterB ) {
			counterB = new IntVar(store, "CONTAINS_"+this.getB()+"-counter", 1, variables.length);
		}
		
		/*
		 * this is not a nice solution ...
		 */
		store.impose(new Count(variables, counterA, this.getA()));
		return new Count(variables, counterB, this.getB());
	}

}
