package org.cidarlab.eugene.rules.tree.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.cidarlab.eugene.rules.RuleOperator;

import JaCoP.constraints.And;
import JaCoP.constraints.Constraint;
import JaCoP.constraints.IfThen;
import JaCoP.constraints.Or;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqC;
import JaCoP.constraints.XeqY;
import JaCoP.constraints.XneqC;
import JaCoP.constraints.XneqY;
import JaCoP.core.IntVar;
import JaCoP.core.Store;

import eugene.cache.SymbolTables;
import eugene.dom.components.Component;
import eugene.exception.EugeneException;

/* A BEFORE B 
 * 
 * IF the long[] array, that the evaluate() method receives, CONTAINS A and B, THEN 
 *     A's first occurrence must be before B's first occurrence
 * ELSE
 *     A BEFORE B is true
 * END IF
 * 
 * Note:
 * rules like ``All A's must occur BEFORE all B's'' can be achieved 
 * by using Eugene's new ``FOR ALL'' operator...
 */
public class Before 
		extends BinaryPredicate {

	public Before(long A, long B) 
			throws EugeneException {
		super(A,B);
	}
	
	@Override
	public boolean evaluate(long[] l) {
		long idxA = ArrayUtils.indexOf(l, this.getA());
		long idxB = ArrayUtils.indexOf(l, this.getB());
		
//		System.out.println("[Before.evaluate(long[])] evaluating "+
//				this.getA()+" BEFORE "+this.getB()+" ON "+Arrays.toString(l)+" -> "+(idxA < idxB));

		/*
		 * IF the long[] array, that the evaluate() method receives, CONTAINS A and B, THEN
		 */
		boolean b = true;
		if(idxA != (-1) && idxB != (-1)) {
			/* 
			 *   A's first occurrence must be before B's first occurrence
			 */     
			b = idxA < idxB;
		}

//		System.out.println("[Before.evaluate] "+this.getA()+" BEFORE "+this.getB()+" -> "+Arrays.toString(l)+" -> "+b);

		//System.out.println("[Before.evaluate] evaluating "+this.toString()+" ON "+Arrays.toString(l)+" FALSE");
		return b;
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
	
	@Override
	public String getOperator() {
		return RuleOperator.BEFORE.toString();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		try {
			sb.append(SymbolTables.getNameById(this.getA()))
				.append(" ").append(RuleOperator.BEFORE).append(" ")
				.append(SymbolTables.getNameById(this.getB()));
		} catch(Exception e) {
			// do nothing...
		}
		return sb.toString();
	}


	@Override
	public Constraint toJaCoP(
			Store store, List<Component> components, IntVar[] variables) {
		
		int a = (int)this.getA();
		int b = (int)this.getB();
		int NR_OF_VARIABLES = variables.length;
		
		/*
		 * a BEFORE b
		 * 1        2
		 */
		//System.out.println("imposing "+a+" BEFORE "+b);
		
		PrimitiveConstraint[] pc = new PrimitiveConstraint[NR_OF_VARIABLES];
		
		for(int posA=0; posA<NR_OF_VARIABLES;posA++) {
			PrimitiveConstraint[] v1 = new PrimitiveConstraint[posA+1];
			for(int posB = 0; posB<=posA; posB++) {
				v1[posB] = new XneqC(variables[posB], b);
			}
			
			PrimitiveConstraint[] v2 = new PrimitiveConstraint[NR_OF_VARIABLES - (posA+1)];
			for(int posB = posA+1; posB<NR_OF_VARIABLES; posB++) {
				v2[posB-(posA+1)] = new XeqC(variables[posB], b);
			}
			
			pc[posA] = new And(
							new IfThen(
									new XeqC(variables[posA], a), 
									new And(v1)),
							new IfThen(
									new XeqC(variables[posA], a), 
									new Or(v2)));
		}
		
		return new And(pc);
		
	}
}
