package org.cidarlab.eugene.rules.tree.predicate;

import java.util.List;

import org.cidarlab.eugene.rules.LogicalOperator;

import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.exception.EugeneException;

import JaCoP.constraints.Constraint;
import JaCoP.constraints.Not;
import JaCoP.constraints.Or;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XneqC;
import JaCoP.core.IntVar;
import JaCoP.core.Store;

public class LogicalXor 
	implements LogicalPredicate {
	
	private Predicate A;
	private Predicate B;
	
	public LogicalXor(Predicate A, Predicate B) {
		this.A = A;
		this.B = B;
	}
	
	public Predicate getA() {
		return this.A;
	}

	public Predicate getB() {
		return this.B;
	}
	
	@Override
	public String getOperator() {
		return LogicalOperator.XOR.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getA()).append(" XOR ").append(this.getB());
		return sb.toString();
	}
	

	@Override
	public Constraint toJaCoP(Store store, List<Component> components, IntVar[] variables) {

		if(this.getA() instanceof CountingPredicate && 
				this.getB() instanceof CountingPredicate) {
			
			store.impose(this.getA().toJaCoP(store, components, variables));
			store.impose(this.getB().toJaCoP(store, components, variables));

			// in this case, we return an ``always false'' constraint
			IntVar iv = new IntVar(store, "tmp", -1, -1);
			return new XneqC(iv, -1);
		} else if(this.getA() instanceof CountingPredicate && 
				!(this.getB() instanceof CountingPredicate)) {

			store.impose(this.getA().toJaCoP(store, components, variables));
			return this.getB().toJaCoP(store, components, variables);
			
		} else if(this.getB() instanceof CountingPredicate && 
				!(this.getA() instanceof CountingPredicate)) {
			
			store.impose(this.getB().toJaCoP(store, components, variables));
			return this.getA().toJaCoP(store, components, variables);
			
		} else {
			PrimitiveConstraint pcA = (PrimitiveConstraint)this.getA().toJaCoP(store, components, variables);
			PrimitiveConstraint pcB = (PrimitiveConstraint)this.getB().toJaCoP(store, components, variables);

			// JaCoP does not support XOR, i.e.
			// a XOR b ::=  (A OR B) AND NOT(A OR B)
			return new JaCoP.constraints.And(
					 new Or(pcA, pcB),
					 new Not(new Or(pcA, pcB)));			
		}
	}

	@Override
	public boolean evaluate(long[] l) 
			throws EugeneException {
		return this.getA().evaluate(l) ^ this.getB().evaluate(l);
	}
	
	@Override
	public boolean evaluate(long deviceId) 
			throws EugeneException {
		return this.getA().evaluate(deviceId) ^ this.getB().evaluate(deviceId);
	}
	
	@Override
	public boolean evaluate(String sDeviceName) 
			throws EugeneException {
		return this.getA().evaluate(sDeviceName) ^ this.getB().evaluate(sDeviceName);
	}

	@Override
	public boolean evaluate(Device device) 
			throws EugeneException {
		return this.getA().evaluate(device) ^ this.getB().evaluate(device);
	}

}
