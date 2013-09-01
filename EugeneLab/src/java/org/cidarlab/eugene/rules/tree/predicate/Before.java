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
import eugene.dom.components.Device;
import eugene.dom.components.Part;
import eugene.dom.components.types.PartType;
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

	private Component compA;
	private Component compB;	

	public Before(long A, long B) 
			throws EugeneException {
		super(A,B);
		
		compA = null;
		compB = null;
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
		
//		if(!b) {
//			System.err.println("[Before] violation of "+this.toString()+"....");
//		}
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
	public boolean evaluate(Device device) 
			throws EugeneException {
		Component componentA = SymbolTables.getComponent(this.getA());
		Component componentB = SymbolTables.getComponent(this.getB());
		if((null != componentB && (componentB instanceof Device || componentB instanceof PartType)) &&
				null != componentA && (componentA instanceof Device || componentA instanceof PartType)) {
			
			int idxA = device.getComponents().indexOf(componentA);
			int idxB = device.getComponents().indexOf(componentB);

			if(idxA != (-1) && idxB != (-1)) {
				/* 
				 *   A's first occurrence must be before B's first occurrence
				 */     
				return idxA < idxB;
			}
			
		}
		return this.evaluate(SymbolTables.getDeviceComponentIds(device.getName()));
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

//		System.out.println("**** "+this.getComponentA().getName()+" BEFORE "+this.getComponentB().getName()+" ****");
		if(variables.length <= 1 || (null != components && components.size()<=1)) {
			IntVar iv = new IntVar(store, "invalid", 1, 1);
			return new XneqC(iv, 1);
		}

		List<PrimitiveConstraint> pcA = new ArrayList<PrimitiveConstraint>();

		try {
			int a = (int)this.getA();
			int b = (int)this.getB();

			if(this.compA == null) {
				this.compA = SymbolTables.getComponent(a);
			}
			if(this.compB == null) {
				this.compB = SymbolTables.getComponent(b);
			}
			
			
			int i=0;
			for(Component component : components) {
//				System.out.println("component "+component.getName());
				if(compA instanceof Part && component instanceof PartType &&
						((Part)compA).getPartType().equals((PartType)component)) {

					int[] possibleBPositions = new int[1];
					int[] impossibleBPositions = new int[1];
					
					/* possible positions of B */
					List<PrimitiveConstraint> possibleB = new ArrayList<PrimitiveConstraint>();
					
					/* impossible positions of B */
					List<PrimitiveConstraint> impossibleB = new ArrayList<PrimitiveConstraint>();
					
					for(int k=0; k<variables.length; k++) {
						Component comp = components.get(k);
						if(compB instanceof Part && comp instanceof PartType && 
							((Part)compB).getPartType().equals((PartType)comp)) {
							
							if(k <= i) {
								impossibleB.add(new XneqC(variables[k], b));
								impossibleBPositions = ArrayUtils.add(impossibleBPositions, k);
							} else {
								possibleB.add(new XeqC(variables[k], b));
								possibleBPositions = ArrayUtils.add(possibleBPositions, k);
							}
						}
					}

					PrimitiveConstraint[] pcPossibleB = new PrimitiveConstraint[possibleB.size()];
					PrimitiveConstraint[] pcImpossibleB = new PrimitiveConstraint[impossibleB.size()];
					
					/*
					 * If A is at position N, then we're not allowed to 
					 * 
					 */
					pcA.add(new IfThen(
								new XeqC(variables[i], a),
								new And(new Or(possibleB.toArray(pcPossibleB)), 
										new And(impossibleB.toArray(pcImpossibleB)))));


					possibleBPositions = ArrayUtils.remove(possibleBPositions, 0);
					impossibleBPositions = ArrayUtils.remove(impossibleBPositions, 0);

//					System.out.println(
//							"impossible positions of "+this.compB.getName()+"... "+Arrays.toString(impossibleBPositions)+" -> "+
//							"possible positions of "+this.compB.getName()+"... "+Arrays.toString(possibleBPositions));

//					pcA.add(new IfThen(
//								new XeqC(variables[i], a),
//								new And(pcB.toArray(pcBB))));
				}				
				i++;
			}

			PrimitiveConstraint[] pcAA = new PrimitiveConstraint[pcA.size()];
			return new And(pcA.toArray(pcAA));		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
