package org.cidarlab.eugene.rules.tree.predicate;

import java.util.BitSet;
import java.util.List;

import org.cidarlab.eugene.rules.LogicalOperator;

import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.exception.EugeneException;

import JaCoP.constraints.Constraint;
import JaCoP.constraints.Not;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqC;
import JaCoP.constraints.XneqC;
import JaCoP.core.IntVar;
import JaCoP.core.Store;

public class LogicalNot 
	implements LogicalPredicate {

	private Predicate predicate;
	
	public LogicalNot(Predicate predicate) {
		this.predicate = predicate;
	}
	
	public Predicate getPredicate() {
		return this.predicate;
	}
	
	@Override
	public String getOperator() {
		return LogicalOperator.NOT.toString();
	}
	
	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("NOT ").append(this.getPredicate()).append("");
		return sb.toString();
	}
	
	@Override
	public Constraint toJaCoP(Store store, List<Component> components, IntVar[] variables) {
		
		if(this.getPredicate() instanceof MoreThan) {
			store.impose(((MoreThan)this.getPredicate()).toJaCoPNot(store, components, variables));
		} else {
			Constraint c = this.getPredicate().toJaCoP(store, components, variables);

			if(null != c && c instanceof PrimitiveConstraint) {
//				System.out.println("[LogicalNot] -> "+components+" -> "+this.getPredicate().getClass());
				return new JaCoP.constraints.Not(
						(PrimitiveConstraint)c);
			}
		}
		
		return null;
	}

	@Override
	public boolean evaluate(long[] l) 
			throws EugeneException {
		boolean b = this.getPredicate().evaluate(l);
//		if(!b) {
//			System.err.println("[Not] everything's ok again...");
//		} else {
//			System.err.println("[Not] everything's broken...");
//		}
		return !b;
	}
	
	@Override
	public boolean evaluate(long deviceId) 
			throws EugeneException {
		return !this.getPredicate().evaluate(deviceId);
	}

	@Override
	public boolean evaluate(String sDeviceName) 
			throws EugeneException {
		return !this.getPredicate().evaluate(sDeviceName);
	}

	@Override
	public boolean evaluate(Device device) 
			throws EugeneException {
		return !this.getPredicate().evaluate(device);
	}
}
