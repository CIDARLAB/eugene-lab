package org.cidarlab.eugene.rules.tree.predicate;

import java.util.List;

import org.cidarlab.eugene.rules.RuleOperator;

import JaCoP.constraints.Constraint;
import JaCoP.constraints.IfThen;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqY;
import JaCoP.constraints.XneqY;
import JaCoP.constraints.And;
import JaCoP.core.IntVar;
import JaCoP.core.Store;


import eugene.cache.SymbolTables;
import eugene.dom.components.Component;
import eugene.exception.EugeneException;

/* A AFTER B 
 * 
 * IF the long[] array, that the evaluate() method receives, CONTAINS A and B, THEN 
 *     A's first occurrence must be AFTER B's first occurrence
 * ELSE
 *     A AFTER B is true
 * END IF
 * 
 * Notes:
 * - A AFTER B is equal to B BEFORE A... therefore, we utilize the BEFORE predicate 
 *   to evaluate the AFTER rule...
 * - rules like ``All A's must occur BEFORE all B's'' can be achieved 
 *   by using Eugene's new ``FOR ALL'' operator...
 */
public class After 
		extends BinaryPredicate {

	private Before before;
	//private boolean[][] position_matrix;
	
	public After(long A, long B) 
			throws EugeneException {
		super(A, B);
		this.before = new Before(B, A);
	}

	@Override
	public boolean evaluate(long[] l) 
			throws EugeneException {
		return this.before.evaluate(l);
		//System.out.println("[After.evaluate(long[])] evaluating "+
		//		this.before.getB()+" AFTER "+this.before.getA()+" ON "+Arrays.toString(l)+" -> "+b);
	}
	
	@Override
	public boolean evaluate(long nId) 
			throws EugeneException {
		return this.evaluate(
				SymbolTables.getDeviceComponentIds(nId));		
	}
	
	@Override
	public boolean evaluate(String sDeviceName) 
			throws EugeneException {
		return this.evaluate(
				SymbolTables.getDeviceComponentIds(sDeviceName));
	}
	
	@Override
	public boolean evaluate() 
			throws EugeneException {
		throw new EugeneException(this.toString()+" requires information about a Device!");
	}
	
	public long getA() {
		return this.before.getB();
	}

	public long getB() {
		return this.before.getA();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getA())
				.append(" ").append(RuleOperator.AFTER).append(" ")
			.append(this.getB());
		/**
		try {
			sb.append(SymbolTables.getNameById(this.getA()))
					.append(" ").append(RuleOperator.AFTER).append(" ")
				.append(SymbolTables.getNameById(this.getB()));
		} catch (EugeneException e) {
			e.printStackTrace();
			return null;
		}
		**/
		return sb.toString();
	}
	
	@Override
	public String getOperator() {
		return RuleOperator.AFTER.toString();
	}

	@Override
	public Constraint toJaCoP(Store store, List<Component> components,
			IntVar[] variables) {
		return this.before.toJaCoP(store, components, variables);
	}
}

