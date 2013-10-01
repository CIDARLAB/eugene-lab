package org.cidarlab.eugene.rules.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.runtime.tree.CommonTree;
import org.cidarlab.eugene.cache.SymbolTables;
import org.cidarlab.eugene.dom.NamedElement;
import org.cidarlab.eugene.dom.rules.Rule;
import org.cidarlab.eugene.exception.EugeneException;
import org.cidarlab.eugene.rules.LogicalOperator;
import org.cidarlab.eugene.rules.PredicateBuilder;
import org.cidarlab.eugene.rules.tree.predicate.ExpressionPredicate;
import org.cidarlab.eugene.rules.tree.predicate.LogicalNot;
import org.cidarlab.eugene.rules.tree.predicate.Precedence;
import org.cidarlab.eugene.rules.tree.predicate.Predicate;
import org.cidarlab.eugene.rules.tree.predicate.RuleID;


public class RuleTreeParser {

	private static final Set<String> setLogicalBooleanOperators = new HashSet<String>(
			Arrays.asList(new String[] { "AND", "OR", "XOR" }));

	private static final Set<String> setCountingRules = new HashSet<String>(
			Arrays.asList(new String[] { 
					"NOTMORETHAN", "MORETHAN", "EXACTLY"}));
	
	private static final Set<String> setPairingRules = new HashSet<String>(
			Arrays.asList(new String[] { 
					"REPRESSES", "INDUCES", "DRIVES", "BINDS", "MATCHES"}));

	private static final Set<String> setRuleOperators = new HashSet<String>(
			Arrays.asList(new String[] { "CONTAINS", "BEFORE", "AFTER",
					"WITH", "STARTSWITH", "ENDSWITH", "NEXTTO", "THEN",
					"NOTCONTAINS", "NOTWITH"}));
	
	private static final Set<String> setRelationalOperators = new HashSet<String>(
			Arrays.asList(new String[] { "NOTEQUALS", "!=", "EQUALS", "==", "<", "<=", ">=", ">" })); 

	private static final Set<String> setExpressionOperator = new HashSet<String>(
			Arrays.asList(new String[] { "+", "-", "*", "/" }));

	public static boolean isLogicalBooleanOperator(String s) {
		return setLogicalBooleanOperators.contains(s);
	}

	public static boolean isRuleOperator(String s) {
		return setRuleOperators.contains(s);
	}

	public static boolean isCountingRule(String s) {
		return setCountingRules.contains(s);
	}

	public static boolean isRelationalOperator(String s) {
		return setRelationalOperators.contains(s);
	}

	public static boolean isExpressionOperator(String s) {
		return setExpressionOperator.contains(s);
	}
	
	public static boolean isPairingRule(String s) {
		return setPairingRules.contains(s);
	}
	
	public static boolean evaluate(Predicate predicate) {
		return true;
	}
	
	public static Predicate buildTree(CommonTree t) 
			throws EugeneException {

		if (null != t) {
			if ("NOT".equals(t.getText()) || "!".equals(t.getText())) {
				List<Predicate> lstChildren = new ArrayList<Predicate>();
				
				Predicate childPredicate= buildTree((CommonTree) t.getChild(0));
				lstChildren.add(childPredicate);

				return (LogicalNot)PredicateBuilder.build(
						LogicalOperator.NOT, 
						childPredicate);
				
			} else if ("(".equals(t.getText())) {
				
				return new Precedence(
						buildTree((CommonTree) t.getChild(0)));
				
			} else if (isLogicalBooleanOperator(t.getText())) {
				
				return PredicateBuilder.buildLogicalPredicate(
						(Predicate)buildTree((CommonTree) t.getChild(0)),
						t.getText(), 
						(Predicate)buildTree((CommonTree) t.getChild(1)));
				
			} else if(isExpressionOperator(t.getText()) ||
					isRelationalOperator(t.getText())) {
				/* we're talking about a expressional rule here ... */
				/* e.g. X + Y > 15 */
				
				Predicate predicate = new ExpressionPredicate(t);
				//System.out.println("[RuleTreeParser.buildTree] -> "+predicate);
				return predicate;
				
			} else if(isCountingRule(t.getText())) {

				return PredicateBuilder.buildCountingPredicate(
						getOperandId((CommonTree)t.getChild(0)),
						t.getText(),
						Integer.valueOf(t.getChild(1).getText()));

			} else if(isPairingRule(t.getText())) {
				
				return PredicateBuilder.buildPairingPredicate((CommonTree)t);

			} else if (isRuleOperator(t.getText())) {
				
				/* here, we need to create the rule predicate dependent on the rule operator */
//				System.out.println("[RuleTreeParser.parseTree] creating predicate for "+t.getText());
				
				if(t.getChildCount() == 1) {
					return PredicateBuilder.build(
							t.getText(), 
							getOperandId((CommonTree)t.getChild(0)));
				} else if(t.getChildCount() == 2) {
					return PredicateBuilder.build(
							getOperandId((CommonTree)t.getChild(0)),
							t.getText(), 
							getOperandId((CommonTree)t.getChild(1)));
				}
				
				throw new EugeneException("???");
				
				/* TODO:
				 * we need to replace the current node 
				 * with the rule predicate 
				 */
				
			} else {
				NamedElement objElement = SymbolTables.get(t.getText());
				
				if(null != objElement && objElement instanceof Rule) {
					return new RuleID((Rule)objElement);
				} else {
					throw new EugeneException(
						"Invalid rule operand! " + t.getText());
				}
			}
		}
		
		//System.out.println("[RuleTreeParser.buildTree] return null; F**K");
		return null;
	}
	
	/***
	private static ExpressionPredicate buildExpressionTree(CommonTree t) 
			throws EugeneException {
		if (null != t) {
			if ("[".equals(t.getText())) {
				return new ExpressionPredicate(
						null,
						t.getText(),
						buildExpressionTree((CommonTree)t.getChild(0)));
			} else if (isRelationalOperator(t.getText()) ||
					isExpressionOperator(t.getText()) ||
					".".equals(t.getText())) {
				return new ExpressionPredicate(
						buildExpressionTree((CommonTree)t.getChild(0)),
						t.getText(),
						buildExpressionTree((CommonTree)t.getChild(1)));
			} else {
				return new ExpressionPredicate(null, t.getText(), null);
			}
		}
		return null;
	}
	***/
	
	private static long getOperandId(CommonTree t) 
			throws EugeneException {

		return SymbolTables.getId(t.getText());
	}
	
}
