package org.cidarlab.minieugene.predicates.counting;

import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.rules.RuleOperator;

import JaCoP.constraints.Constraint;
import JaCoP.constraints.Count;
import JaCoP.core.IntVar;
import JaCoP.core.Store;

public class Exactly 
	extends CountingPredicate {

	public Exactly(int a, int n) 
			throws EugeneException {				
		super(a, n);

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getA())
			.append(" ").append(RuleOperator.EXACTLY).append(" ")
			.append(this.getN());
		return sb.toString();
	}
	
	@Override
	public String getOperator() {
		return RuleOperator.EXACTLY.toString();
	}

	@Override
	public Constraint toJaCoP(Store store, IntVar[] variables) 
				throws EugeneException {

//		System.out.println("[Exactly] "+this.getA()+" EXACTLY "+this.getN());
		
		// a EXACTLY N
		IntVar count = new IntVar(store, this.getA()+"_EXACTLY_"+this.getN()+"-counter", this.getN(), this.getN()); 
		return new Count(variables, count, (int)this.getA());
	}

	@Override
	public Constraint toJaCoPNot(Store store, IntVar[] variables)
			throws EugeneException {
		/*
		 * NOT a EXACTLY N
		 */
		// a EXACTLY N
		
		/*
		 * this is not a nice solution...
		 * however, it works...
		 */
		
		/*
		 * counter for 0...n-1
		 */
		IntVar count1 = new IntVar(store, this.getA()+"_NOT-EXACTLY_"+this.getN()+"-counter1", 0, this.getN()-1); 
		store.impose(new Count(variables, count1, (int)this.getA()));
		
		IntVar count2 = new IntVar(store, this.getA()+"_NOT-EXACTLY_"+this.getN()+"-counter2", this.getN()+1, variables.length); 
		return new Count(variables, count2, (int)this.getA());

	}

}
