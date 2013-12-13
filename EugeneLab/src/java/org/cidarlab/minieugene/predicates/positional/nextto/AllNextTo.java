package org.cidarlab.minieugene.predicates.positional.nextto;

import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.predicates.BinaryPredicate;
import org.cidarlab.minieugene.rules.RuleOperator;

import JaCoP.constraints.And;
import JaCoP.constraints.Constraint;
import JaCoP.constraints.IfThen;
import JaCoP.constraints.Or;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqC;
import JaCoP.core.IntVar;
import JaCoP.core.Store;

/*
 * A NEXTTO B
 * 
 * Definition:  
 */
public class AllNextTo 
	extends BinaryPredicate {

	public AllNextTo(int a, int b) {
		super(a, b);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getA())
			.append(" ").append(RuleOperator.ALL_NEXTTO).append(" ")
			.append(this.getB());
		return sb.toString();
	}

	@Override
	public String getOperator() {
		return RuleOperator.ALL_NEXTTO.toString();
	}

	@Override
	public Constraint toJaCoP(Store store, IntVar[] variables) 
				throws EugeneException {
		int a = (int)this.getA();
		int b = (int)this.getB();
		int N = variables.length;
		
		int[] idxA = new int[N];
		for(int i=0; i<N; i++) {
			idxA[i] = i;
		}

		/*
		 * a NEXTTO b
		 */
		PrimitiveConstraint[] pc = constraintIndices(variables, idxA, a, b);
		if(null != pc) {
			for(int i=0; i<pc.length; i++) {
				store.impose(pc[i]);
			}
		}
		
		return null;
	}

	/*
	 * a NEXTTO b
	 */
	private static PrimitiveConstraint[] constraintIndices(IntVar[] variables, int[] indices, int a, int b) {
		int N = variables.length;
		PrimitiveConstraint[] pc = new PrimitiveConstraint[indices.length];
		for(int i=0; i<indices.length; i++) {
			int idx = indices[i];
			if(idx > 0 && idx<N-1) {
				
				/*
				 * if a is placed at any position (except the first and the last position),
				 * then place b either at the position immediately before or 
				 *                     at the position immediately after
				 */
				pc[i] = new IfThen(
						new XeqC(variables[idx], a),
						new Or(
								new XeqC(variables[idx-1], b),
								new XeqC(variables[idx+1], b)));
			} else if(idx == 0) {
				/*
				 * if a is placed at the first position,
				 * then place b at the second position
				 */
				pc[i] = new IfThen(
							new XeqC(variables[idx], a),
							new XeqC(variables[idx+1], b));
			} else if(idx == N-1) {
				
				/*
				 * if a is placed at the last position,
				 * then place b at the second last position
				 */
				pc[i] = new IfThen(
								new XeqC(variables[idx], a),
								new XeqC(variables[idx-1], b));
			}
		}
		
		return pc;
	}
	
}