package org.cidarlab.eugene.rules.tree;

import org.antlr.runtime.tree.CommonTree;

import eugene.cache.SymbolTables;
import eugene.dom.NamedElement;
import eugene.dom.Variable;
import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.exception.EugeneException;

public class Indexer {
	
	public static int getIndex(NamedElement element, CommonTree t) 
			throws EugeneException {
		
		global_element = null;
		if(element == null) {
			global_element = SymbolTables.get(t.getText());						
		} else {
			global_element = element.get(t.getText());
		}

		if(global_element == null) {
			throw new EugeneException("I don't know "+t.getText());						
		}
		
//		System.out.println("[Indexer.getIndex] objElement: "+global_element.getName()+", tree: "+t.toStringTree());
		
		if(t.getChildCount() == 1) {
			global_index = 0;
			parent_element = null;
			current_element = global_element;
			int idx = calculateIndex((CommonTree)t.getChild(0));

//			System.out.println(((CommonTree)t.getChild(0)).getChildCount());
			if(((CommonTree)t.getChild(0)).getChildCount() == 1) {
				return idx;
			}
//			
//			//System.out.println("global_index: "+global_index);
			return global_index;
		}
		
		return -1;
	}
	
	private static int global_index;
	private static NamedElement global_element;
	private static NamedElement current_element;
	private static NamedElement parent_element;
	
	private static int calculateIndex(CommonTree tree) 
			throws EugeneException {
		if(tree != null) {
			
			if("[".equals(tree.getText()) || 
				".".equals(tree.getText())) {

				if(tree.getChildCount() == 2) {
					
					// go left
					CommonTree left = (CommonTree)tree.getChild(0);
					int idx = calculateIndex(left);
					if(parent_element != null) {
						if(parent_element instanceof Device) {
							for(int k=0; k<idx; k++) {
								NamedElement tmp = parent_element.get(k);
								if(tmp instanceof Device) {
									global_index += ((Device)tmp).getAllComponents().size();
								} else {
									global_index += tmp.size();
								}
							}
						}
					} else {
						global_index += idx;
					}

//					System.out.println("current_element: "+current_element.getName()+", parent_element: "+parent_element.getName()+" ");
					CommonTree right = (CommonTree)tree.getChild(1);					
					int idx2 = calculateIndex(right);
					if(!parent_element.getName().equals(global_element.getName()) && (-1) != idx2) {
						global_index += idx2;
					}
//					System.out.println("[calculateIndex] -> global_index: "+global_index);

					
				} else if(tree.getChildCount() == 1) {
					
					// get the position of the current element 
					CommonTree leaf = (CommonTree)tree.getChild(0);
					
					String indexName = leaf.getText();
					
					int idx = -1;
					if("[".equals(tree.getText())) {
						idx = toIndex(indexName);
					} else {
						idx = elementIndexOf(current_element, indexName);
					}
					
					if(idx != (-1)) {
//						System.out.print(current_element.getName()+"["+idx+"] -> ");
						parent_element = current_element;
						current_element = current_element.get(idx);
//						System.out.println(current_element);
						return idx;
					}
					
				}
			} else if(tree.getChildCount() == 0) {
			}
		}
		return -1;
	}
	
	/*
	 * the elementIndexOf() method returns the index of the name s 
	 * in the element's components
	 */
	public static int elementIndexOf(NamedElement element, String s) 
			throws EugeneException {

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
	
	public static int toIndex(String s) 
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
