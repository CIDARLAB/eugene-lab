package org.cidarlab.minieugene.predicates.pairing;

import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.predicates.BinaryPredicate;
import org.cidarlab.minieugene.rules.RuleOperator;

import JaCoP.constraints.And;
import JaCoP.constraints.Constraint;
import JaCoP.constraints.Or;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqC;
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

		PrimitiveConstraint[] pcA = new PrimitiveConstraint[variables.length];
		for(int i=0; i<variables.length; i++) {
			
			PrimitiveConstraint[] pcB = new PrimitiveConstraint[variables.length-1];
			int k=0;
			for(int j=0; j<variables.length; j++) {
				if(j!=i) {
					pcB[k++] = new XeqC(variables[j], b);
				}
			}
			
			pcA[i] = new And(
							new XeqC(variables[i], a),
							new Or(pcB));
		}
		
		return new Or(pcA);
	}

}
