package org.cidarlab.minieugene.predicates.pairing;

import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.predicates.BinaryPredicate;
import org.cidarlab.minieugene.rules.RuleOperator;

import JaCoP.constraints.And;
import JaCoP.constraints.Constraint;
import JaCoP.constraints.Count;
import JaCoP.constraints.Or;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqC;
import JaCoP.constraints.XeqY;
import JaCoP.core.IntVar;
import JaCoP.core.Store;


public class Equals 
		extends BinaryPredicate {

	
	public Equals(int idxA, int idxB) {
		super(idxA, idxB);
	}

	@Override	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[").append(this.getA()).append("] ")
			.append(RuleOperator.EQUALS).append(" ")
			.append("[").append(this.getB()).append("]");
		return sb.toString();
	}

	@Override
	public String getOperator() {
		return RuleOperator.EQUALS.toString();
	}


	@Override
	public Constraint toJaCoP(Store store, IntVar[] variables) 
				throws EugeneException {

		/*
		 * the element at index idxA must be
		 * equal to the element at index idxB
		 */
		
		return new XeqY(variables[this.getA()], variables[this.getB()]);
		
	}

}
