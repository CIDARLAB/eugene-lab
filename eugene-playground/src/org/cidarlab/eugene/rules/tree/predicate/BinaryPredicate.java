package org.cidarlab.eugene.rules.tree.predicate;

import eugene.cache.SymbolTables;
import eugene.dom.components.Component;
import eugene.exception.EugeneException;

/* 
 * Binary predicates are predicates that MUST have two rule operators (A and B)
 * 
 * In Eugene, the following rules are binary rules:
 * AFTER, BEFORE, NEXTTO, MATCH, ORTHO, WITH, THEN
 */
public abstract class BinaryPredicate 
	implements RulePredicate {
	
	private long A;
	private long B;
	private Component componentA;
	private Component componentB;
	
	public BinaryPredicate(long A, long B) 
			throws EugeneException {
		this.A = A;
		this.B = B;
		
		this.componentA = SymbolTables.getComponent(A);
		//System.out.println("[UnaryPredicate] -> "+this.componentA);
		this.componentB = SymbolTables.getComponent(B);
		//System.out.println("[UnaryPredicate] -> "+this.componentB);
	}
	
	public long getA() {
		return this.A;
	}
	public long getB() {
		return this.B;
	}
		
	public Component getComponentA() {
		return this.componentA;
	}
	
	public Component getComponentB() {
		return this.componentB;
	}

}
