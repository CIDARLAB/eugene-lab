package org.cidarlab.eugene.rules.tree.predicate;

import java.util.Arrays;
import java.util.List;

import org.cidarlab.eugene.rules.LogicalOperator;

import org.cidarlab.eugene.dom.components.Component;
import org.cidarlab.eugene.dom.components.Device;
import org.cidarlab.eugene.exception.EugeneException;

import JaCoP.constraints.And;
import JaCoP.constraints.Constraint;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqC;
import JaCoP.core.IntVar;
import JaCoP.core.Store;

public class LogicalAnd 
	implements LogicalPredicate {
	
	private Predicate A;
	private Predicate B;
	
	public LogicalAnd(Predicate A, Predicate B) {
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
		return LogicalOperator.AND.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getA()).append(" AND ").append(this.getB());
		return sb.toString();
	}

	@Override
	public Constraint toJaCoP(Store store, List<Component> components, IntVar[] variables) {
		
		Constraint cA = this.getA().toJaCoP(store, components, variables);
		Constraint cB = this.getB().toJaCoP(store, components, variables);

		if(cA instanceof PrimitiveConstraint &&
			cB instanceof PrimitiveConstraint) {
			
			//System.out.println("[AND]");
			
			return new And(
					(PrimitiveConstraint)cA, 
					(PrimitiveConstraint)cB);
			
		} else if(cA instanceof PrimitiveConstraint && 
				!(cB instanceof PrimitiveConstraint)) {

			// in this case, we return an ``always true'' constraint
//			IntVar iv = new IntVar(store, "tmp", -1, -1);
//			PrimitiveConstraint pc = new XeqC(iv, -1);
			if(null != cB) {
				store.impose(cB);
			}
			return (PrimitiveConstraint)cA;
			//return new And((PrimitiveConstraint)cA, pc); 

		} else if(!(cA instanceof PrimitiveConstraint) && 
				cB instanceof PrimitiveConstraint) {

//			IntVar iv = new IntVar(store, "tmp", -1, -1);
//			PrimitiveConstraint pc = new XeqC(iv, -1);
			if(null != cA) {
				store.impose(cA);
			}
			return (PrimitiveConstraint)cB;
			// return new And(pc, (PrimitiveConstraint)cB); 

		} else if(null != cA && null != cB) {
			store.impose(cA);
			store.impose(cB);
		}
		return null;
/**
		store.impose(cA);
			store.impose(cB);
			
			IntVar iv = new IntVar(store, "tmp", -1, -1);
			PrimitiveConstraint pc = new XeqC(iv, -1);
			return pc;
 **/			
	}

	@Override
	public boolean evaluate(long[] l) 
			throws EugeneException {
		boolean b = this.getA().evaluate(l);
//		System.out.println("[LogicalAnd.evaluate] -> "+Arrays.toString(l)+" -> "+b);
		if(b) {
			b = b & this.getB().evaluate(l);
		}
		return b;
	}

	@Override
	public boolean evaluate(long deviceId) 
			throws EugeneException {
		boolean b = this.getA().evaluate(deviceId);

		if(b) {
			b = b && this.getB().evaluate(deviceId);
		}
		
		return b;
	}

	@Override
	public boolean evaluate(String sDeviceName) 
			throws EugeneException {
		boolean b = this.getA().evaluate(sDeviceName);

		if(b) {
			b = b && this.getB().evaluate(sDeviceName);
		}
		
		return b;
	}
	
	@Override
	public boolean evaluate(Device device) 
			throws EugeneException {
		boolean b = this.getA().evaluate(device);

		if(b) {
			b = b && this.getB().evaluate(device);
		}
		
		return b;
	}

}
