package org.cidarlab.eugene.rules.tree.predicate;

import java.util.Arrays;
import java.util.List;

import JaCoP.constraints.Constraint;
import JaCoP.core.IntVar;
import JaCoP.core.Store;
import eugene.dom.components.Component;
import eugene.dom.rules.Rule;
import eugene.exception.EugeneException;

public class RuleID 
	implements RulePredicate {

	private Rule rule;
	public RuleID(Rule rule) 
			throws EugeneException {
		this.rule = rule;
	}
	
	@Override
	public boolean evaluate(long[] l) 
			throws EugeneException {
		//System.out.println("[RuleID.evaluate] "+this.rule.getPredicate()+" ON "+Arrays.toString(l));
		return this.rule.getPredicate().evaluate(l);
	}

	@Override
	public boolean evaluate(long n) 
			throws EugeneException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean evaluate(String sDeviceName) 
			throws EugeneException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean evaluate() 
			throws EugeneException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getOperator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.rule.toString());
		return sb.toString();
	}
	
	@Override
	public Constraint toJaCoP(
			Store store, List<Component> components, IntVar[] variables) {
		return this.rule.getPredicate().toJaCoP(store, components, variables);
	}

}
