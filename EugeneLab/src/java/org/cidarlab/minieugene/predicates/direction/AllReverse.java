package org.cidarlab.minieugene.predicates.direction;

import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.rules.RuleOperator;
import org.cidarlab.minieugene.symbol.SymbolTables;

import JaCoP.constraints.Constraint;
import JaCoP.core.IntVar;
import JaCoP.core.Store;

/*
 * ALL_REVERSE
 * 
 * all elements must have a reverse direction
 * 
 * X := the set of all symbols (defined by the user)
 * a element_of X
 * a == -1 => forall X : direction(X) = '-'
 * a != -1 => forall a : direction(a) = '-'
 * 
 */
public class AllReverse 
	extends DirectionalityPredicate {

	public AllReverse(SymbolTables symbols, int a) {
		super(symbols, a);
	}

	@Override
	public String getOperator() {
		return RuleOperator.ALL_REVERSE.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(RuleOperator.ALL_REVERSE);
		return sb.toString();
	}

	@Override
	public Constraint toJaCoP(Store store, IntVar[] variables) 
				throws EugeneException {
		if(this.getA() == -1) {
			this.symbols.allReverse();
		} else {
			this.symbols.reverse(this.getA());
		}
		
		return null;
	}

	@Override
	public Constraint toJaCoPNot(Store store, IntVar[] variables)
			throws EugeneException {
		if(this.getA() == -1) {
			this.symbols.allForward();
		} else {
			this.symbols.forward(this.getA());
		}
		return null;
	}

}
