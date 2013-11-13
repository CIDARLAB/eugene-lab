package org.cidarlab.minieugene.predicates.counting;

import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.rules.RuleOperator;

import JaCoP.constraints.Constraint;
import JaCoP.constraints.Count;
import JaCoP.core.IntVar;
import JaCoP.core.Store;

/*
 * ? CONTAINS B
 */
		
public class Contains 
		extends CountingPredicate {

	public Contains(int a) {
		super(a, 1);
	}
	
	@Override
	public Constraint toJaCoP(Store store, IntVar[] variables) 
				throws EugeneException {
		
		/*
		 * CONTAINS B
		 */
		IntVar counter = new IntVar(store, "CONTAINS_"+this.getA()+"-counter", 1, variables.length); 
		return new Count(variables, counter, this.getA());
	}
	
	@Override
	public Constraint toJaCoPNot(
			Store store, IntVar[] variables) 
				throws EugeneException {
		/*
		 * NOT CONTAINS B
		 */

		IntVar counter = new IntVar(store,"NOTCONTAINS_"+this.getA()+"-counter", 0, 0); 
		return new Count(variables, counter, (int)this.getA());
	}

	@Override
	public String getOperator() {
		return RuleOperator.CONTAINS.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getOperator()).append(" ").append(this.getA());
		return sb.toString();
	}
}
