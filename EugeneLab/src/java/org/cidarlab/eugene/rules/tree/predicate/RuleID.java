package org.cidarlab.eugene.rules.tree.predicate;

import java.util.Arrays;
import java.util.List;

import JaCoP.constraints.Constraint;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.core.IntVar;
import JaCoP.core.Store;
import org.cidarlab.eugene.dom.components.Component;
import org.cidarlab.eugene.dom.components.Device;
import org.cidarlab.eugene.dom.rules.Rule;
import org.cidarlab.eugene.exception.EugeneException;

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
//		System.out.println("[RuleID.evaluate] "+this.rule.getPredicate()+" ON "+Arrays.toString(l));
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
	public boolean evaluate(Device device) 
			throws EugeneException {
		return this.rule.getPredicate().evaluate(device);
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

	public Constraint toJaCoPNot(
			Store store, List<Component> components, IntVar[] variables) {
		if(this.rule.getPredicate() instanceof MoreThan) {
			store.impose(((MoreThan)this.rule.getPredicate()).toJaCoPNot(store, components, variables));
		} else {
			Constraint c = this.rule.getPredicate().toJaCoP(store, components, variables);
			if(c instanceof PrimitiveConstraint) {
				return c;
			} else {
				store.impose(c);
			}
		}
		return null;
	}
}