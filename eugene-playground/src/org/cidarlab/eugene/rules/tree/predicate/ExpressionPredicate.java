package org.cidarlab.eugene.rules.tree.predicate;

import java.util.List;

import org.antlr.runtime.tree.CommonTree;
import org.cidarlab.eugene.rules.RuleOperator;
import org.cidarlab.eugene.rules.tree.RuleTreeParser;

import JaCoP.constraints.Constraint;
import JaCoP.constraints.XeqC;
import JaCoP.constraints.XeqY;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XneqC;
import JaCoP.constraints.XneqY;
import JaCoP.core.IntVar;
import JaCoP.core.Store;
import eugene.cache.SymbolTables;
import eugene.dom.NamedElement;
import eugene.dom.Variable;
import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.dom.components.Part;
import eugene.exception.EugeneException;

/* Example:
 * X + Y > Z
 * 
 *        >
 *      /   \
 *     +      Z
 *    / \
 *   X   Y
 */
public class ExpressionPredicate
	implements RulePredicate {

	private CommonTree tree;
	
	//private String node;
	//private ExpressionPredicate lhs;
	//private ExpressionPredicate rhs;
	
	public ExpressionPredicate(CommonTree tree) {
		this.tree = tree;
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
		return this.toString();
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
			if(RuleTreeParser.isExpressionOperator(t.getText())) {

				System.out.println("EXPRESSION OPERATOR -> "+t.getText());
				
			} else if(RuleTreeParser.isRelationalOperator(t.getText())) {

				
				CommonTree lhs = (CommonTree)t.getChild(0);
				CommonTree rhs = (CommonTree)t.getChild(1);
				
				if(null == lhs || null == rhs) {
					throw new EugeneException("Inavlid "+t.getText()+" rule!");
				}
				
				int lhsIdx = -1;
				try {
					lhsIdx = getIndex(element, lhs);
				} catch(EugeneException e) {
					throw new EugeneException(e.toString());
				}
				
				// RIGHT-HAND SIDE
				int rhsIdx = -1;
				try {
					rhsIdx = getIndex(element, rhs);
				} catch(EugeneException e) {
					throw new EugeneException(e.toString());
				}
				
				
				if(RuleOperator.EQUALS.toString().equals(t.getText())) {
					if(rhsIdx == -1 && lhsIdx!=-1) {
						
						int rhsId = (int)SymbolTables.getId(rhs.getText());
						return new XeqC(variables[lhsIdx], rhsId);
						
					} else if(rhsIdx != -1 && lhsIdx == -1) {
						
						int lhsId = (int)SymbolTables.getId(lhs.getText());
						return new XeqC(variables[rhsIdx], lhsId);
						
					} else if(rhsIdx == -1 && lhsIdx == -1) {
						// ???
					} else {
						if(!(rhsIdx>=0 && rhsIdx<variables.length &&
							 lhsIdx>=0 && lhsIdx<variables.length)) {
							throw new EugeneException("Invalid indices!");
						}

						return new XeqY(variables[lhsIdx], variables[rhsIdx]);
					}
				} else 	if(RuleOperator.NOTEQUALS.toString().equals(t.getText())) {
					if(rhsIdx == -1 && lhsIdx!=-1) {
						
						int rhsId = (int)SymbolTables.getId(rhs.getText());
						return new XneqC(variables[lhsIdx], rhsId);
						
					} else if(rhsIdx != -1 && lhsIdx == -1) {
						
						int lhsId = (int)SymbolTables.getId(lhs.getText());
						return new XneqC(variables[rhsIdx], lhsId);
						
					} else if(rhsIdx == -1 && lhsIdx == -1) {
						// ???
					} else {
						if(!(rhsIdx>=0 && rhsIdx<variables.length &&
							 lhsIdx>=0 && lhsIdx<variables.length)) {
							throw new EugeneException("Invalid indices!");
						}

						return new XneqY(variables[lhsIdx], variables[rhsIdx]);
					}
				}


			}
		}
		
		return null;	
	}
	
	private int getIndex(NamedElement element, CommonTree t) 
			throws EugeneException {
		
		NamedElement objElement = null;
		if(element == null) {
			objElement = SymbolTables.get(t.getText());						
		} else {
			objElement = element.get(t.getText());
		}

		if(objElement == null) {
			throw new EugeneException("I don't know "+t.getText());						
		}
		
		if(t.getChildCount() == 1) {
			return calculateIndex((CommonTree)t.getChild(0), objElement, 0);
		}
		return -1;
	}
	
	public int calculateIndex(CommonTree tree, NamedElement element, int global_index) 
			throws EugeneException {
		if(tree != null) {
			//System.out.println("****");
			//System.out.println("tree -> "+tree.getText() +" -> "+tree.getChildCount());
			//System.out.println("tree -> "+tree.getText() +" -> "+tree.getChild(0).getChild(0).getText());
			//System.out.println("tree -> "+tree.getText() +" -> "+tree.getChild(1).getChild(0).getText());
			
			if("[".equals(tree.getText()) || 
				".".equals(tree.getText())) {
				
//				System.out.println("A");
				if(tree.getChildCount() == 2) {
//					System.out.println("B -> "+global_index);

					int idx1 = calculateIndex((CommonTree)tree.getChild(0), element, global_index);
					//System.out.println("idx1 -> "+idx1);
					//global_index += idx1;
					for(int k=0; k<idx1; k++) {
						//System.out.println("calculating index... " +tmp.get(k)+" -> "+tmp.get(k).size()+" -> "+global_index);
						global_index += element.get(k).size();
						//System.out.println("calculating index... " +element.get(k)+" -> "+element.get(k).size()+" -> "+global_index);
					}
					element = element.get(idx1);
					int idx2 = calculateIndex((CommonTree)tree.getChild(1), element, global_index);
					return global_index + idx2;
					
				} else if(tree.getChildCount() == 1) {
					//System.out.println("E -> "+global_index);
					if("[".equals(tree.getText())) {
						return this.toIndex(tree.getChild(0).getText());
					} else {
						return this.elementIndexOf(element, tree.getChild(0).getText());
					}
				} else {   // <-- this case should never happen!					
					throw new EugeneException("I don't know what happened!");
				}
			} else if(tree.getChildCount() == 0) {
				if("[".equals(tree.getParent().getText())) {
					global_index += this.toIndex(tree.getText());
				} else if(".".equals(tree.getParent().getText())) {
					global_index += this.elementIndexOf(element, tree.getText());
				}
			}
		}
		//System.out.println("???");
		return 0;
	}
	
//	public int toIndex(NamedElement element, String s) 
//			throws EugeneException {
//		int idx = -1;
//		try {
//			idx = toIndex(s); 
//		} catch(Exception e) {
//			
//		}
//		return idx;
//	}
	
	/*
	 * the elementIndexOf() method returns the index of the name s 
	 * in the element's components
	 */
	private int elementIndexOf(NamedElement element, String s) 
			throws EugeneException {
//		System.out.println("[elementIndexOf] -> "+element+"."+s);
		
		if(null != element && element instanceof Component) {
			Component component = (Component)element;
			
			if(component instanceof Device) {
				Device device = (Device)component;
				int idx = 0;
				for(Component comp : device.getComponents()) {
					if(comp.getName().equals(s)) {
						return idx;
					}
					idx ++;
				}
			}
		}
		return -1;
	}
	
	private int toIndex(String s) 
			throws EugeneException {
		int idx = -1;
		try {
			// the index is either a constant
			idx = Integer.valueOf(s);
		} catch(Exception e) {
			// or a variable ...
			
			// do I need to check this here again??
			NamedElement objIdx = SymbolTables.get(s);
			if(null != objIdx && objIdx instanceof Variable) {
				try {
					idx = Integer.valueOf(((Variable)objIdx).getValue());
				} catch(Exception exc) {
					idx = -1;
				}
			} else {
				idx = -1;
			}
		}
		
		if(idx >= 0) {
			return idx;
		} else {				
			throw new EugeneException(s+" is an invalid index!");
		}
	}

}
