package org.cidarlab.minieugene.predicates.positional.before;

import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.predicates.BinaryPredicate;
import org.cidarlab.minieugene.rules.RuleOperator;

import JaCoP.constraints.And;
import JaCoP.constraints.Constraint;
import JaCoP.constraints.IfThen;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqC;
import JaCoP.constraints.XneqC;
import JaCoP.core.IntVar;
import JaCoP.core.Store;

/* A BEFORE B 
 * 
 * IF the long[] array, that the evaluate() method receives, CONTAINS A and B, THEN 
 *     A's first occurrence must be before B's first occurrence
 * ELSE
 *     A BEFORE B is true
 * END IF
 * 
 * Note:
 * rules like ``All A's must occur BEFORE all B's'' can be achieved 
 * by using Eugene's new ``FOR ALL'' operator...
 */
public class AllBefore 
		extends BinaryPredicate {

	public AllBefore(int a, int b) {
		super(a, b);
	}

	@Override
	public String getOperator() {
		return RuleOperator.ALL_BEFORE.toString();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		try {
			sb.append(this.getA())
				.append(" ").append(RuleOperator.ALL_BEFORE).append(" ")
				.append(this.getB());
		} catch(Exception e) {
			// do nothing...
		}
		return sb.toString();
	}

	@Override
	public Constraint toJaCoP(Store store, IntVar[] variables) 
				throws EugeneException {

		int a = (int)this.getA();
		int b = (int)this.getB();

		int N = variables.length;

		/*
		 * a ALLBEFORE b
		 * 
		 * contains(a) => for all a, b: position(a) < position(b)
		 */
		
		PrimitiveConstraint pc[] = new PrimitiveConstraint[N];
		for(int i=0; i<N; i++) {
			if(i > 0) {
				PrimitiveConstraint[] pcB = new PrimitiveConstraint[i];
				for(int j=0; j<i; j++) {
					pcB[j] = new XneqC(variables[j], b);
				}
				
				store.impose(
						new IfThen(
								new XeqC(variables[i], a),
								new And(pcB)));
//				pc[i] = new IfThen(
//							new XeqC(variables[i], a),
//							new And(pcB));
			} else {

				store.impose(
						new IfThen(
								new XeqC(variables[i], a),
								new XneqC(variables[i], b)));
				
//				pc[i] = new IfThen(
//							new XeqC(variables[i], a),
//							new XneqC(variables[i], b));
			}							
		}			
		
		return null;
//		return new And(pc);
	}
	
}
