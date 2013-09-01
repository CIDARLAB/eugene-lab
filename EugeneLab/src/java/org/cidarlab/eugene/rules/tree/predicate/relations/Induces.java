package org.cidarlab.eugene.rules.tree.predicate.relations;

import java.util.Arrays;
import java.util.List;

import org.antlr.runtime.tree.CommonTree;
import org.cidarlab.eugene.rules.RuleOperator;
import org.cidarlab.eugene.rules.tree.Indexer;
import org.cidarlab.eugene.rules.tree.predicate.PairingPredicate;

import JaCoP.constraints.And;
import JaCoP.constraints.Constraint;
import JaCoP.constraints.Or;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqC;
import JaCoP.core.IntVar;
import JaCoP.core.Store;
import eugene.cache.SymbolTables;
import eugene.dom.NamedElement;
import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.exception.EugeneException;

public class Induces 
	extends PairingPredicate {
	
	public Induces(CommonTree tree) {
		super(tree);
	}
		
	@Override
	public boolean evaluate(long[] l) 
			throws EugeneException {
		/* here we need to parse the tree 
		 * and retrieve the values of the node's information 
		 * from the symboltables
		 * and perform the appropriate actions  
		 */
		
		// currently we just print-out the tree
		return false;
	}
	
	@Override
	public boolean evaluate(long n) 
			throws EugeneException {
		return false;
	}
	
	@Override
	public boolean evaluate(String sDeviceName) 
			throws EugeneException {
		return false;
	}
	
	@Override
	public boolean evaluate() 
			throws EugeneException {
		return false;
	}
	
	@Override
	public String getOperator() {
		return RuleOperator.INDUCES.toString();
	}

	public String toString() {
		return "";
	}

	@Override
	public Constraint toJaCoP(
			Store store, List<Component> components, IntVar[] variables) {
		// TODO 
		
		//System.out.println("[ExpressionPredicate.toJaCoP] -> "+tree.toStringTree());
		
		if(components.size() != variables.length) {
			return null;
		}
		
		// here we need to parse the ExpressionTree
		PrimitiveConstraint pc = null;
		try {
			pc = buildConstraint(store, variables, components, tree, null);
		} catch (EugeneException e) {
			e.printStackTrace();
			pc = null;
		}
		
		return pc;
	}
	
	private PrimitiveConstraint buildConstraint(
			Store store, IntVar[] variables, List<Component> components, CommonTree t, NamedElement element) 
			throws EugeneException {
		if (null != t) {
			CommonTree lhs = (CommonTree)t.getChild(0);
			CommonTree rhs = (CommonTree)t.getChild(1);
			
			if(null == lhs || null == rhs) {
				throw new EugeneException("Inavlid "+t.getText()+" rule!");
			}
			
			int lhsIdx = -1;
			try {
				lhsIdx = Indexer.getIndex(element, lhs);
			} catch(EugeneException e) {
				throw new EugeneException(e.toString());
			}
			
			// RIGHT-HAND SIDE
			int rhsIdx = -1;
			try {
				rhsIdx = Indexer.getIndex(element, rhs);
			} catch(EugeneException e) {
				throw new EugeneException(e.toString());
			}
			
			if(lhsIdx == -1 || rhsIdx == -1) {
				throw new EugeneException("Invalid index!");
			}
			
//			System.out.println(lhsIdx+" "+this.getOperator()+" "+rhsIdx);
						
			return this.buildConstraint(
					variables,
					components.get(lhsIdx), lhsIdx, 
					components.get(rhsIdx), rhsIdx);
		}
		
		return null;	
	}
	
	private PrimitiveConstraint buildConstraint(IntVar[] variables, Component lhs, int lhsIdx, Component rhs, int rhsIdx) 
			throws EugeneException {
		/*
		 * first, we need to query all parts of the given part type
		 * and their corresponding partners 
		 */
		long[][] pairs = null;
		try {
			pairs = SymbolTables.queryPairs(this.getOperator(), lhs, rhs);
		} catch(Exception e) {
			throw new EugeneException(e.getMessage());
		}
		
//		for(int i=0; i<pairs.length; i++) {
//			System.out.println(Arrays.toString(pairs[i]));
//		}
		
		// then, we iterate over the retrieved parts
		// creating appropriate JaCoP constraints
		if(null != pairs) {
			PrimitiveConstraint[] pcArray = new PrimitiveConstraint[pairs.length];
			for(int i=0; i<pairs.length; i++) {
				pcArray[i] = new And(
						new XeqC(variables[lhsIdx], (int)pairs[i][0]),
						new XeqC(variables[rhsIdx], (int)pairs[i][1]));
			}
			return new Or(pcArray);
		}
			
		return null;
	}

	@Override
	public boolean evaluate(Device device) 
			throws EugeneException {
		throw new UnsupportedOperationException("a REPRESSES b is not available yet");
	}
	

}
