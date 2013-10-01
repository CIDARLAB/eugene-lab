package org.cidarlab.eugene.rules.tree.predicate;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.cidarlab.eugene.cache.SymbolTables;
import org.cidarlab.eugene.dom.components.Component;
import org.cidarlab.eugene.dom.components.Device;
import org.cidarlab.eugene.dom.components.Part;
import org.cidarlab.eugene.dom.components.types.PartType;
import org.cidarlab.eugene.exception.EugeneException;
import org.cidarlab.eugene.rules.RuleOperator;

import JaCoP.constraints.And;
import JaCoP.constraints.Constraint;
import JaCoP.constraints.IfThen;
import JaCoP.constraints.Or;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.Reified;
import JaCoP.constraints.XeqC;
import JaCoP.constraints.XneqC;
import JaCoP.constraints.XneqY;
import JaCoP.core.BooleanVar;
import JaCoP.core.IntVar;
import JaCoP.core.Store;

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
		if((null != this.componentB && (this.componentB instanceof Device || this.componentB instanceof PartType)) &&
				null != this.componentA && (this.componentA instanceof Device || this.componentA instanceof PartType)) {
			
			int idxA = device.getComponents().indexOf(this.componentA);
			int idxB = device.getComponents().indexOf(this.componentB);

			if(idxA != (-1) && idxB != (-1)) {
				/* 
				 *   A's first occurrence must be before B's first occurrence
				 */     
				return idxA < idxB;
			}
			
			return true;
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
			Store store, IntVar[] variables, 
			Device device, List<Component> components) 
				throws EugeneException {

		if(variables.length <= 1 || (null != components && components.size()<=1)) {
			IntVar iv = new IntVar(store, "invalid", 1, 1);
			return new XneqC(iv, 1);
		}

//		PrimitiveConstraint[] pcA = null;

		try {
			int a = (int)this.getA();
			int b = (int)this.getB();

//			System.out.println(this.componentA.getName()+"("+a+") BEFORE "+this.componentB.getName()+"("+b+")");
			PrimitiveConstraint[] pc = null;
			
			int i=0;
			for(Component component : components) {

				if(component instanceof Device) {
					if(null == pc) {
						pc = new PrimitiveConstraint[1];
						pc[0] = (PrimitiveConstraint)this.toJaCoP(
								store, variables, (Device)device, ((Device)component).getComponents());
					} else {
						pc = ArrayUtils.add(pc, (PrimitiveConstraint)this.toJaCoP(
								store, variables, (Device)device, ((Device)component).getComponents()));
					}

				} else if(this.componentA instanceof Part && component instanceof PartType &&
						((Part)this.componentA).getPartType().equals((PartType)component)) {

					for(int k=i+1; k<components.size(); k++) {
						Component comp = components.get(k);
						if(this.componentB instanceof Part && comp instanceof PartType && 
							((Part)this.componentB).getPartType().equals((PartType)comp)) {
							
							if(null == pc) {
								pc = new PrimitiveConstraint[1];
								pc[0] = new And(new XeqC(variables[i], a), new XeqC(variables[k], b));
							} else {
								pc = ArrayUtils.add(pc, new And(new XeqC(variables[i], a), new XeqC(variables[k], b)));
							}
						}
					}

				}	
				
				i++;
			}

			if(null != pc) {
				return new Or(pc);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

/*** toJaCop if we use the ``positioning'' approach 	
	@Override
	public Constraint toJaCoP(
			Store store, List<Component> components, IntVar[] variables) {

//		System.out.println("**** "+this.getComponentA().getName()+" BEFORE "+this.getComponentB().getName()+" ****");
		if(variables.length <= 1 || (null != components && components.size()<=1)) {
			IntVar iv = new IntVar(store, "invalid", 1, 1);
			return new XneqC(iv, 1);
		}

		int a = (int)this.getA();
		int b = (int)this.getB();

		IntVar ivA = (IntVar)store.findVariable(String.valueOf(a));
		IntVar ivB = (IntVar)store.findVariable(String.valueOf(b));
		
		return new XltY(ivA, ivB);
	}
***/
	
}
