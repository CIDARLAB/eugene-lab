/*
Copyright (c) 2012 Boston University.
All rights reserved.
Permission is hereby granted, without written agreement and without
license or royalty fees, to use, copy, modify, and distribute this
software and its documentation for any purpose, provided that the above
copyright notice and the following two paragraphs appear in all copies
of this software.

IN NO EVENT SHALL BOSTON UNIVERSITY BE LIABLE TO ANY PARTY
FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES
ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
BOSTON UNIVERSITY HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

BOSTON UNIVERSITY SPECIFICALLY DISCLAIMS ANY WARRANTIES,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND BOSTON UNIVERSITY HAS
NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES,
ENHANCEMENTS, OR MODIFICATIONS.
 */

package eugene.rules;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.antlr.runtime.tree.CommonTree;

import eugene.constants.EugeneConstants;
import eugene.dom.NamedElement;
import eugene.dom.Variable;
import eugene.dom.components.Device;
import eugene.dom.components.Part;
import eugene.dom.components.Property;
import eugene.dom.components.types.PartType;
import eugene.dom.rules.Rule;
import eugene.exception.EugeneException;
import eugene.interpreter.EugeneBuilder;
import eugene.parser.SymbolTables;

public class RuleEngine {

	private static final Set<String> setLogicalBooleanOperators = new HashSet<String>(
			Arrays.asList(new String[] { "AND", "OR", "XOR" }));

	private static final Set<String> setRuleOperators = new HashSet<String>(
			Arrays.asList(new String[] { "CONTAINS", "BEFORE", "AFTER",
					"MORETHAN", "WITH", "STARTSWITH", "ENDSWITH", "NEXTTO",
					"THEN", "NOTEQUALS", "!=", "EQUALS", "==", "<", "<=", ">=",
					">" }));

	// the evaluateRuleOnAllDevices() method evluates all devices
	// against the given rule
	// returns:
	// true .... all devices satisfy the rule
	// false ... there is at least one device that violates the rule
	public static boolean evaluateRuleOnAllDevices(Rule objRule)
			throws EugeneException {

		boolean b = true;

		if (null != objRule) {
			try {
				Collection<Device> colDevices = SymbolTables.getDevices();
				if (null != colDevices && !colDevices.isEmpty()) {
					for (Device d : colDevices) {
						b = b & evaluateRule(objRule.getTree(), d);

						if (!b) {
							return false;
						}
					}
				}
			} catch (Exception e) {
				throw new EugeneException(e.getMessage());
			}
		}

		return b;
	}

	public static boolean evaluate(Rule objRule, Device objDevice)
			throws EugeneException {
		if (objRule != null && objDevice != null) {
			return evaluateRule(objRule.getTree(), objDevice);
		}
		return false;
	}

	private static boolean isLogicalBooleanOperator(String s) {
		if (null != s) {
			return setLogicalBooleanOperators.contains(s);
		}
		return false;
	}

	private static boolean isRuleOperator(String s) {
		if (null != s) {
			return setRuleOperators.contains(s);
		}
		return false;
	}

	public static void checkRuleOperands(CommonTree t) throws EugeneException {
		if (null != t) {
			if ("NOT".equals(t.getText()) || "!".equals(t.getText())) {
				checkRuleOperands((CommonTree) t.getChild(0));
			} else if ("(".equals(t.getText())) {
				checkRuleOperands((CommonTree) t.getChild(0));
			} else if (isLogicalBooleanOperator(t.getText())) {
				checkRuleOperands((CommonTree) t.getChild(0));
				checkRuleOperands((CommonTree) t.getChild(1));
			} else if (isRuleOperator(t.getText())) {
				NamedElement objLeftElement = getOperand(
						(CommonTree) t.getChild(0), null);
				if (null == objLeftElement) {
					throw new EugeneException("I don't know anything about "
							+ t.getChild(0).getText());
				}
				if (null != (CommonTree) t.getChild(1)) {
					NamedElement objRightElement = getOperand(
							(CommonTree) t.getChild(1), null);
					if (null == objRightElement) {
						throw new EugeneException(
								"I don't know anything about "
										+ t.getChild(1).getText());
					}
					checkOperandTypes(objLeftElement, objRightElement);
				}

			} else {
				throw new EugeneException(
						t.getText()
								+ " is an invalid rule operator! Please consult eugenecad.org!");
			}
		}
	}

	private static void checkOperandTypes(NamedElement objLeft,
			NamedElement objRight) throws EugeneException {
		boolean b = true;
		if (objLeft instanceof Device) {
			if (!(objRight instanceof Device)
					&& !(objRight instanceof PartType)
					&& !(objRight instanceof Part)) {
				b = false;
			}
		} else if (objLeft instanceof PartType) {
			if (!(objRight instanceof Device)
					&& !(objRight instanceof PartType)
					&& !(objRight instanceof Part)
					&& !(objRight instanceof Property)
					&& !(objRight instanceof Variable)) {
				b = false;
			}
		} else if (objLeft instanceof Part) {
			if (!(objRight instanceof Device)
					&& !(objRight instanceof PartType)
					&& !(objRight instanceof Part)
					&& !(objRight instanceof Property)
					&& !(objRight instanceof Variable)) {
				b = false;
			}
		} else if (objLeft instanceof Property) {
			if (!(objRight instanceof PartType) && !(objRight instanceof Part)
					&& !(objRight instanceof Property)
					&& !(objRight instanceof Variable)) {
				b = false;
			}

			if (objRight instanceof Variable) {
				b = ((Property) objLeft).getType().equals(
						((Variable) objRight).getType());
				if (!b) {
					throw new EugeneException("I cannot compare a "
							+ ((Property) objLeft).getType()
							+ " property with a "
							+ ((Variable) objRight).getType() + " value!");
				}
			} else if (objRight instanceof Property) {
				b = ((Property) objLeft).getType().equals(
						((Property) objRight).getType());
				if (!b) {
					throw new EugeneException("I cannot compare a "
							+ ((Property) objLeft).getType()
							+ " property with a "
							+ ((Property) objRight).getType() + " property!");
				}
			}

		} else if (objLeft instanceof Variable) {
			if (!(objRight instanceof Part) && !(objRight instanceof Property)
					&& !(objRight instanceof Variable)) {
				b = false;
			}

			if (objRight instanceof Variable) {
				b = ((Variable) objLeft).getType().equals(
						((Variable) objRight).getType());
				if (!b) {
					throw new EugeneException("I cannot compare a "
							+ ((Variable) objLeft).getType() + " value with a "
							+ ((Variable) objRight).getType() + " value!");
				}
			} else if (objRight instanceof Property) {
				b = ((Variable) objLeft).getType().equals(
						((Property) objRight).getType());
				if (!b) {
					throw new EugeneException("I cannot compare a "
							+ ((Variable) objLeft).getType() + " value with a "
							+ ((Property) objRight).getType() + " property!");
				}
			}
		}

		if (!b) {
			// for a better error reporting
			StringBuilder sb = new StringBuilder("I cannot compare ");

			String sLeftClass = objLeft.getClass().toString();
			sLeftClass = sLeftClass.substring(sLeftClass.lastIndexOf('.') + 1,
					sLeftClass.length());
			if (objLeft instanceof Variable) {
				if (((Variable) objLeft).getName() != null) {
					sb.append(sLeftClass);
				} else {
					sb.append(((Variable) objLeft).getValue());
				}
			} else {
				sb.append("a ").append(sLeftClass);
			}

			sb.append(" with ");

			String sRightClass = objRight.getClass().toString();
			sRightClass = sRightClass.substring(
					sRightClass.lastIndexOf('.') + 1, sRightClass.length());
			if (objRight instanceof Variable) {
				if (((Variable) objLeft).getName() != null) {
					sb.append(sRightClass);
				} else {
					sb.append(((Variable) objRight).getValue());
				}
			} else {
				sb.append("a ").append(sRightClass);
			}
			sb.append("!");

			throw new EugeneException(sb.toString());
		}
	}

	private static boolean evaluateRule(CommonTree t, Device objDevice)
			throws EugeneException {
		if (null != t) {
			if ("NOT".equals(t.getText())) {
				boolean b = evaluateRule((CommonTree) t.getChild(0), objDevice);
				return !b;
			} else if ("(".equals(t.getText())) {
				return evaluateRule((CommonTree) t.getChild(0), objDevice);
			} else if (isLogicalBooleanOperator(t.getText())) {
				boolean left = evaluateRule((CommonTree) t.getChild(0),
						objDevice);
				boolean right = evaluateRule((CommonTree) t.getChild(1),
						objDevice);
				return booleanOp(left, t.getText(), right);
			} else if (isRuleOperator(t.getText())) {
				if (null != (CommonTree) t.getChild(1)) { // binary rule, eg D
															// CONTAINS P

					// get the rule's operand
					NamedElement objLeft = getOperand(
							(CommonTree) t.getChild(0), objDevice);
					NamedElement objRight = getOperand(
							(CommonTree) t.getChild(1), objDevice);

					// check if the rule can be evaluated on the given operands
					// e.g. Promoter MORETHAN 1 -> true
					// Promoter.Sequence == "ATCG" -> false if the promoter is a
					// part type
					if (canRuleBeEvaluated(objLeft, t.getText(), objRight)) {
						return RuleEvaluator.evaluate(objDevice, objLeft,
								t.getText(), objRight);
					}

					// we could throw an exception here! other solutions?
					// System.err.println("WARNING! I can't evaluate the "+t.getText()+" rule since one of the rule operands is abstract!");

					// if the rule cannot be evaluated, we currently assume that
					// the rule is true
					return true;
				} else { // unary rule, eg CONTAINS P
					return RuleEvaluator.evaluate(objDevice, objDevice,
							t.getText(),
							getOperand((CommonTree) t.getChild(0), objDevice));
				}
			} else {
				throw new EugeneException(
						"Eugene does not support rules, such as "
								+ t.toStringTree() + " yet!");
			}
		}
		return false;
	}

	private static boolean canRuleBeEvaluated(NamedElement objLeft,
			String sOperator, NamedElement objRight) {

		if (EugeneConstants.MORETHAN.equals(sOperator)) {
			if ((objLeft instanceof Device || objLeft instanceof PartType || objLeft instanceof Property)
					&& objRight instanceof Variable
					|| (objRight instanceof Device
							|| objRight instanceof PartType || objRight instanceof Property)
					&& objLeft instanceof Variable) {
				return true;
			} else {
				return false;
			}
		} else if (EugeneConstants.EQUALS.equals(sOperator)
				|| "==".equals(sOperator)
				|| EugeneConstants.NOTEQUALS.equals(sOperator)
				|| "!=".equals(sOperator)
				|| EugeneConstants.LT.equals(sOperator)
				|| "<".equals(sOperator)
				|| EugeneConstants.LEQ.equals(sOperator)
				|| "<=".equals(sOperator)
				|| EugeneConstants.GEQ.equals(sOperator)
				|| ">=".equals(sOperator)
				|| EugeneConstants.GT.equals(sOperator)
				|| ">".equals(sOperator)) {
			if ((objLeft instanceof Variable && objRight instanceof Variable)
					|| objLeft.getClass().equals(objRight.getClass())) {
				return true;
			}
		} else if (isRuleOperator(sOperator)) {
			return true;
		}

		return false;
	}

	private static NamedElement getOperand(CommonTree t, NamedElement objElement)
			throws EugeneException {

		if (null != t) {
			if (t.getChildCount() > 0) {
				if ("[".equals(t.getText())) {
					return objElement.get(Integer.valueOf(
							t.getChild(0).getText()).intValue());
				} else if (".".equals(t.getText())) {
					return objElement.get(t.getChild(0).getText());
				} else if ("(".equals(t.getText())) {
					return objElement.get(t.getChild(0).getText());
				} else {
					if (null == objElement) {
						objElement = SymbolTables.get(t.getText());
						if (null == objElement) {
							throw new EugeneException(
									"I don't know anything about "
											+ t.getText());
						}
					} else if (objElement instanceof Device) {

						Device d = (Device) objElement;
						if (!(t.getText().equals(d.getName()))
								&& !(d.isInstanceOf(t.getText()))) {
							NamedElement objTmp = objElement;
							objElement = objElement.get(t.getText());
							if (null == objElement) {
								throw new EugeneException("The "
										+ objTmp.getName()
										+ " device does not contain a "
										+ t.getText() + " element!");
							}
						}
					}

					for (int i = 0; i < t.getChildCount(); i++) {
						NamedElement objTmp = objElement;
						objElement = getOperand((CommonTree) t.getChild(i),
								objElement);
						if (null == objElement) {
							throw new EugeneException("The " + objTmp.getName()
									+ " element does not contain "
									+ t.getChild(i).getChild(0).getText() + "!");
						}
					}
				}
			} else if (t.getChildCount() == 0) {
				objElement = SymbolTables.get(t.getText());
				if (null != objElement) {
					return objElement;
				}
				Variable objVariable = EugeneBuilder.buildVariable(t.getText());
				return objVariable;
			}
		}

		return objElement;
	}

	private static boolean booleanOp(boolean a, String op, boolean b) {
		if ("AND".equals(op)) {
			return a & b;
		} else if ("OR".equals(op)) {
			return a | b;
		} else if ("XOR".equals(op)) {
			return a ^ b;
		}
		return false;
	}

	public static boolean evaluateIfRule(Rule objRule) throws EugeneException {
		if (objRule != null) {
			return evaluateRule(objRule.getTree(), null);
		}
		return false;
	}

	// the abstractEvaluate method is called before the execution of the permute
	// and product functions...
	// the method serves to evaluate the given device against a rule...
	// if the device passes the rule test, then the permute/product function can
	// be executed...
	// if the device does not pass the rule test, then the permute/product
	// function does not need to
	// generate the device instances
	public static boolean abstractEvaluate(Rule objRule, Device objDevice)
			throws EugeneException {

		if (null != objRule && null != objDevice) {
			if (null != objRule.getDevice()) {
				if (objDevice.getName().equals(objRule.getDevice().getName())) {
					return evaluateRule(objRule.getTree(), objDevice);
				}
			}

			// check if the rule contains abstract rule operands
			if (abstractOperands(objRule.getTree(), objDevice)
					&& objDevice.isAbstract()) {
				// if yes, then evaluate the rule on the abstract device
				return evaluateRule(objRule.getTree(), objDevice);
			}
		}

		// else, return true because the device passes the rule test
		return true;
	}

	// the abstractOperands() method checks if the rule is defined
	// on abstract operands
	public static boolean abstractOperands(CommonTree t, Device d)
			throws EugeneException {
		if (null != t && null != d) {
			if ("NOT".equals(t.getText()) || "!".equals(t.getText())) {
				return abstractOperands((CommonTree) t.getChild(0), d);
			} else if ("(".equals(t.getText())) {
				return abstractOperands((CommonTree) t.getChild(0), d);
			} else if (isLogicalBooleanOperator(t.getText())) {
				boolean b = abstractOperands((CommonTree) t.getChild(0), d);
				return b & abstractOperands((CommonTree) t.getChild(1), d);
			} else if (isRuleOperator(t.getText()) && t.getChildCount() > 0) {

				// left operand
				if (isRelationalRule(t.getText())) {
					return false;
				}

				// if the left operand equals the given device
				if (t.getChild(0).getText().equals(t)) {
					return true;
				}

				NamedElement objLeftElement = getOperand(
						(CommonTree) t.getChild(0), null);
				if (null == objLeftElement) {
					throw new EugeneException("I don't know anything about "
							+ t.getChild(0).getText());
				}

				boolean bLeft = false;
				if (objLeftElement instanceof Device) {
					if (objLeftElement.getName().equals(d.getName())) {
						bLeft = true;
					} else {
						bLeft = ((Device) objLeftElement).isAbstract();
					}
				} else if (objLeftElement instanceof PartType) {
					bLeft = true;
				} else if (objLeftElement instanceof Part
						|| objLeftElement instanceof Property) {
					bLeft = false;
				} else {
					bLeft = false;
				}

				// right rule operand
				if (null != (CommonTree) t.getChild(1)) {

					// again, if the right rule operand equals the given device
					// then return true
					if (t.getChild(1).getText().equals(t)) {
						return true;
					}

					NamedElement objRightElement = getOperand(
							(CommonTree) t.getChild(1), null);
					if (null == objRightElement) {
						throw new EugeneException(
								"I don't know anything about "
										+ t.getChild(1).getText());
					}

					boolean b = false;
					if (objRightElement instanceof Device) {
						if (objRightElement.getName().equals(d.getName())) {
							b = true;
						} else {
							b = ((Device) objRightElement).isAbstract();
						}
					} else if (objRightElement instanceof PartType) {
						b = bLeft & true;
					} else if (objRightElement instanceof Part
							|| objRightElement instanceof Property) {
						b = bLeft & true;
					} else {
						b = bLeft & false;
					}
					return b;
				}

				return bLeft;
			} else {
				throw new EugeneException(
						"Eugene does not support rules, such as "
								+ t.toStringTree() + ", yet!");
			}
		}
		return false;
	}

	private static boolean isRelationalRule(String sOperator) {
		if (EugeneConstants.EQUALS.equals(sOperator) || "==".equals(sOperator)
				|| EugeneConstants.NOTEQUALS.equals(sOperator)
				|| "!=".equals(sOperator)
				|| EugeneConstants.LT.equals(sOperator)
				|| EugeneConstants.LEQ.equals(sOperator)
				|| EugeneConstants.GT.equals(sOperator)
				|| EugeneConstants.GEQ.equals(sOperator)) {
			return true;
		}
		return false;
	}
}
