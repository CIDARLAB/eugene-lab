package org.cidarlab.eugene.rules.tree.predicate;

import java.util.List;

import JaCoP.constraints.Constraint;
import JaCoP.core.IntVar;
import JaCoP.core.Store;
import eugene.dom.components.Component;
import eugene.exception.EugeneException;

public abstract class CountingPredicate 
	extends BinaryPredicate {

	public CountingPredicate(long A, long B) 
			throws EugeneException {
		super(A, B);
	}

	public abstract Constraint toJaCoPNot(
			Store store, List<Component> components, IntVar[] variables);

}
