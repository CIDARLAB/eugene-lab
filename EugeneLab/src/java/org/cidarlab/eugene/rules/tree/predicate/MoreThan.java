package org.cidarlab.eugene.rules.tree.predicate;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.cidarlab.eugene.rules.RuleOperator;

import JaCoP.constraints.Constraint;
import JaCoP.constraints.Count;
import JaCoP.constraints.Or;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqC;
import JaCoP.core.IntVar;
import JaCoP.core.Store;
import eugene.cache.SymbolTables;
import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.dom.components.Part;
import eugene.dom.components.types.PartType;
import eugene.exception.EugeneException;

public class MoreThan 
	extends CountingPredicate {

	public MoreThan(long A, long N) 
			throws EugeneException {				
		super(A, N);
	}

	@Override
	public boolean evaluate(long[] l) 
			throws EugeneException {

		long A = this.getA();

		
		// count the number of A's occurrences and compare it to N
		int counter = 0;
		for(long id : l) {
			if(id == A) {
				counter ++;
			}
		}
		boolean b = false;
		if(counter>this.getB()) {
			b = true;
		}
		
//		System.out.println("[MoreThan.evaluate] "+A+" MORETHAN "+this.getB()+" -> "+Arrays.toString(l)+" -> "+b);
//		if(!b) {
//			System.err.println("[MoreThan] violation of "+this.toString()+"....");
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
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		try {
			sb.append(SymbolTables.getNameById(this.getA()))
				.append(" ").append(RuleOperator.MORETHAN).append(" ")
				.append(this.getB());
		} catch(Exception e) {
			sb = new StringBuilder();
			sb.append(e.toString());
		}
		return sb.toString();
	}
	
	@Override
	public String getOperator() {
		return RuleOperator.MORETHAN.toString();
	}

	@Override
	public Constraint toJaCoP(
			Store store, List<Component> components, IntVar[] variables) {
		
		// impose contains
		this.imposeContains(store, components, variables);
		
		// a MORETHAN N
		IntVar count = new IntVar(store, "counter", (int)(this.getB()+1), variables.length); 
		return new Count(variables, count, (int)this.getA());
	}

	@Override
	public Constraint toJaCoPNot(
			Store store, List<Component> components, IntVar[] variables) {
		//System.out.println("imposing "+this.getA()+" NOTMORETHAN "+this.getB());

		if(this.getB() > 0) {
			// impose contains
			this.imposeContains(store, components, variables);
		}
		
		// a NOTMORETHAN N
		IntVar count = new IntVar(store, "counter", 0, (int)this.getB()); 
		return new Count(variables, count, (int)this.getA());
	}

	public void imposeContains(
			Store store, List<Component> components, IntVar[] variables) {
		Component componentA = this.getComponentA();
		PrimitiveConstraint[] pc = null;
		if(componentA instanceof Part) {
			//System.out.println("imposing CONTAINS "+componentB+"("+this.getB()+")");
			
			for(int p=0; p<components.size(); p++) {
				// here, we need to check if B is part of parttype components[p]
				if(components.get(p) instanceof PartType && 
					((Part)componentA).getPartType().getName().equals(((PartType)components.get(p)).getName())) {
					
					if(pc == null) {
						pc = new PrimitiveConstraint[1];
						pc[0] = new XeqC(variables[p], (int)this.getA());
					} else {					
						pc = ArrayUtils.add(pc, new XeqC(variables[p], (int)this.getA()));
					}
				} 
			}
		}
		
		if(null != pc) {
			store.impose(new Or(pc));
		}

	}
	@Override
	public boolean evaluate(Device device) 
				throws EugeneException {
//		System.out.println("[MoreThan.evaluate] -> "+device);
		int counter = 0;
		long N = this.getB();
		
		Component componentA = SymbolTables.getComponent(this.getA());
		if(null != componentA) {
			if(componentA instanceof Device) {
				/*
				 * TODO: here we need to evaluate the MORETHAN rule for every depth level of the device
				 */
				List<Component> lst = device.getComponents();
				if(null != lst && !lst.isEmpty()) {
					for(Component component : lst) {
						if(componentA.equals(component)) {
							counter ++;
						}
						
						if(counter > N) {
							return true;
						}
	 				}
				}
			} else if(componentA instanceof PartType) {
				List<Component> lst = device.getAllComponents();
				if(null != lst && !lst.isEmpty()) {
					for(Component component : lst) {
						if(componentA.equals(component)) {
							counter ++;
						}
						
						if(counter > N) {
							return true;
						}
	 				}
				}
			}
			return false;
		}
		
		return this.evaluate(SymbolTables.getDeviceComponentIds(device.getName()));
	}

}
