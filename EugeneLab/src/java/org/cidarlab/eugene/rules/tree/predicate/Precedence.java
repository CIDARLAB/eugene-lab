package org.cidarlab.eugene.rules.tree.predicate;

import java.util.Arrays;
import java.util.List;

import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.exception.EugeneException;
import JaCoP.constraints.Constraint;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqC;
import JaCoP.core.IntVar;
import JaCoP.core.Store;


/* 
 * for ( ) 
 */
public class Precedence 
		implements Predicate {

	private Predicate predicate;
	
	public Precedence(Predicate predicate) {
		this.predicate = predicate;
	}

	public Predicate getPredicate() {
		return this.predicate;
	}
	
	@Override
	public String getOperator() {
		return "(";
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" ( ").append(this.getPredicate()).append(" ) ");
		return sb.toString();
	}

	@Override
	public Constraint toJaCoP(Store store, List<Component> components, IntVar[] variables) {
		if(this.getPredicate() instanceof CountingPredicate) {
			return ((CountingPredicate)this.getPredicate()).toJaCoP(store, components, variables);
		} else {
			return (PrimitiveConstraint) this.getPredicate().toJaCoP(store, components, variables);
		}
	}

	@Override
	public boolean evaluate(long[] l) 
			throws EugeneException {
		return this.getPredicate().evaluate(l);
	}
	
	@Override
	public boolean evaluate(long deviceId) 
			throws EugeneException {
		return this.getPredicate().evaluate(deviceId);
	}
	
	@Override
	public boolean evaluate(String sDeviceName) 
			throws EugeneException {
		return this.getPredicate().evaluate(sDeviceName);
	}

	@Override
	public boolean evaluate(Device device) 
			throws EugeneException {
		return this.getPredicate().evaluate(device);
	}

}
