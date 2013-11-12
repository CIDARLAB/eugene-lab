package org.cidarlab.minieugene.predicates.regulatory;

import org.cidarlab.minieugene.predicates.BinaryPredicate;

/*
 * for rules like:
 * REPRESSES, INDUCES, BINDS, ORTHO, DRIVES
 */
public abstract class RegulatoryPredicate 
	extends BinaryPredicate {

	public RegulatoryPredicate(int a, int b) {
		super(a, b);
	}

	
}
