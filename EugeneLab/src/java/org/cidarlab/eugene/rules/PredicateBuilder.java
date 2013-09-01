package org.cidarlab.eugene.rules;

import org.antlr.runtime.tree.CommonTree;
import org.cidarlab.eugene.rules.tree.predicate.*;
import org.cidarlab.eugene.rules.tree.predicate.relations.Induces;
import org.cidarlab.eugene.rules.tree.predicate.relations.Represses;

import eugene.exception.EugeneException;

public class PredicateBuilder {

	/** LOGICAL OPERATORS **/
	
	/** NOT **/
	public static Predicate build(LogicalOperator op, Predicate predicate) 
			throws EugeneException {
		if(null != op && null != predicate && LogicalOperator.NOT.equals(op)) {
			return new LogicalNot(predicate);
		}
		throw new EugeneException("I cannot build a NOT predicate with the given information!");

	}
	
	/** AND, OR, XOR **/
	public static Predicate buildLogicalPredicate(Predicate A, String op, Predicate B) 
			throws EugeneException {
		if(null != op && null != A && null != B) {
			if(LogicalOperator.AND.toString().equals(op)) {
				return new LogicalAnd(A, B);
			} else if(LogicalOperator.OR.toString().equals(op)) {
				return new LogicalOr(A, B);
			} else if(LogicalOperator.XOR.toString().equals(op)) {
				return new LogicalXor(A, B);
			}
		}
		throw new EugeneException("I cannot build a predicate with the given information!");
	}
	
	/** UNARY RULE **/
	/* ? op B
	 * 
	 * valid rules are:
	 * STARTSWITH, ENDSWITH, CONTAINS
	 */
	public static Predicate build(String op, long B) 
			throws EugeneException {
		if(null != op && -1 != B) {
			if(RuleOperator.CONTAINS.toString().equals(op)) {
				return new Contains(B);
			} else if(RuleOperator.STARTSWITH.toString().equals(op)) {
				return new StartsWith(B);				
			} else if(RuleOperator.ENDSWITH.toString().equals(op)) {
				return new EndsWith(B);
			} else if(RuleOperator.NOTCONTAINS.toString().equals(op)) {
				return new LogicalNot(new Contains(B));
			}
		}
		return null;
	}
	
	/** BINARY RULE **/
	/* A op B 
	 * where A is an array (i.e. a composition, such as a Device)
	 * 
	 * valid rules are:
	 * STARTSWITH, ENDSWITH, CONTAINS
	 */
	public static Predicate build(long[] A, String op, long B) {
		// valid rule
		return null;
	}
	
	
	public static Predicate buildCountingPredicate(long A, String op, int N) 
			throws EugeneException {
		if(RuleOperator.NOTMORETHAN.toString().equals(op)) {
			return new LogicalNot(new MoreThan(A, (long)N));
		} else if(RuleOperator.MORETHAN.toString().equals(op)) {
			return new MoreThan(A, (long)N);
		} else if(RuleOperator.NOTEXACTLY.toString().equals(op)) {
			return new LogicalNot(new Exactly(A, (long)N));
		} else if(RuleOperator.EXACTLY.toString().equals(op)) {
			return new Exactly(A, (long)N);
		}
		throw new EugeneException(op+" is an invalid rule operator!");
	}
	
	public static Predicate buildPairingPredicate(CommonTree t) 
			throws EugeneException {
		
		String sOperator = t.getText();
		if(RuleOperator.REPRESSES.toString().equals(sOperator)) {
			return new Represses(t);
		} else if(RuleOperator.MATCHES.toString().equals(sOperator)) {
			return new Matches(t);
		} else if(RuleOperator.REPRESSES.toString().equals(sOperator)) {
			throw new UnsupportedOperationException(sOperator+" IS NOT YET SUPPORTED!");
		} else if(RuleOperator.DRIVES.toString().equals(sOperator)) {
			throw new UnsupportedOperationException(sOperator+" IS NOT YET SUPPORTED!");
		} else if(RuleOperator.ORTHO.toString().equals(sOperator)) {
			throw new UnsupportedOperationException(sOperator+" IS NOT YET SUPPORTED!");
		} else if(RuleOperator.INDUCES.toString().equals(sOperator)) {
			return new Induces(t);
		}

		
		throw new EugeneException(sOperator+" is an invalid rule operator!");
	}
	
	/** BINARY RULE **/
	/* A op B */
	/*
	 * valid rules are:
	 * CONTAINS, STARTSWITH, ENDSWITH, 
	 */
	public static Predicate build(long A, String op, long B) 
			throws EugeneException {
		
		/* here we can check the rule operands against their rule operator */
		/* e.g. A AFTER A -> is an invalid rule */
		/*      A AFTER B -> is a valid rule    */
		if(RuleOperator.AFTER.toString().equals(op)) {
			return new After(A, B);
		} else if(RuleOperator.BEFORE.toString().equals(op)) {
			return new Before(A, B);
		} else if(RuleOperator.NEXTTO.toString().equals(op)) {
			return new NextTo(A,B);
		} else if(RuleOperator.CONTAINS.toString().equals(op)) {
			return new Contains(A, B);
		} else if(RuleOperator.WITH.toString().equals(op)) {
			return new With(A, B);
		} else if(RuleOperator.THEN.toString().equals(op)) {
			return new Then(A, B);
		} else if(RuleOperator.NOTMORETHAN.toString().equals(op)) {
			return new LogicalNot(new MoreThan(A, B));
		} else if(RuleOperator.NOTWITH.toString().equals(op)) {
			return new LogicalNot(new With(A, B));
		} else if(RuleOperator.NOTCONTAINS.toString().equals(op)) {
			return new LogicalNot(new Contains(A, B));
		} 
		
		return null;
	}
}
