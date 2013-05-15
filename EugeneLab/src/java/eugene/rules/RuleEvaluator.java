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

import java.util.ArrayList;
import java.util.List;

import eugene.constants.EugeneConstants;
import eugene.dom.NamedElement;
import eugene.dom.Variable;
import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.dom.components.Part;
import eugene.dom.components.types.PartType;
import eugene.exception.EugeneException;

/**
 * 
 * @author Ernst Oberortner
 */
public class RuleEvaluator {
	/*
	 * the evaluateRule method returns a list of Strings that contains eventual
	 * violation messages
	 */
	public static boolean evaluate(Device objDevice, NamedElement objLeft,
			String sOperator, NamedElement objRight) throws EugeneException {

		if (null == objLeft || null == objRight) {
			throw new EugeneException("I cannot evaluate the " + sOperator
					+ " rule since one operand has an undefined value!");
		}

		if (EugeneConstants.CONTAINS.equals(sOperator)) {
			return contains(objLeft, objRight);
		} else if (EugeneConstants.EQUALS.equals(sOperator)
				|| "==".equals(sOperator)) {
			return equals(objLeft, objRight);
		} else if (EugeneConstants.NOTEQUALS.equals(sOperator)
				|| "!=".equals(sOperator)) {
			return !equals(objLeft, objRight);
		} else if (EugeneConstants.MORETHAN.equals(sOperator)) {
			return moreThan(objDevice, objLeft, (Variable) objRight);
		} else if (EugeneConstants.STARTSWITH.equals(sOperator)) {
			return startsWith(objLeft, objRight);
		} else if (EugeneConstants.ENDSWITH.equals(sOperator)) {
			return endsWith(objLeft, objRight);
		} else if (EugeneConstants.AFTER.equals(sOperator)) {
			return after(objDevice, objLeft, objRight);
		} else if (EugeneConstants.BEFORE.equals(sOperator)) {
			return before(objDevice, objLeft, objRight);
		} else if (EugeneConstants.NEXTTO.equals(sOperator)) {
			return nextto(objDevice, objLeft, objRight);
		} else if (EugeneConstants.WITH.equals(sOperator)) {
			return with(objDevice, objLeft, objRight);
		} else if (EugeneConstants.THEN.equals(sOperator)) {
			return then(objDevice, objLeft, objRight);
		} else {
			throw new EugeneException("Eugene does not support rules like "
					+ sOperator + ". Please consult eugenecad.org!");
		}
	}

	private static boolean contains(NamedElement A, NamedElement B) {
		if (null != A && null != B) {
			if (A instanceof Component) {
				return ((Component) A).contains(B);
			}
		}
		return false;
	}

	private static boolean after(Device D, NamedElement A, NamedElement B) {
		if (null != D && null != A && null != B) {
			// only evaluate the AFTER rule if the given device contains both
			// operands
			if (contains(D, A) && contains(D, B)) {

				// get all indizes of the before device
				ArrayList<Integer> idxA = new ArrayList<Integer>();
				ArrayList<Integer> idxB = new ArrayList<Integer>();

				int i = 0;
				for (Component c : D.getComponents()) {
					if (c.equals(A)) {
						idxA.add(new Integer(i));
					} else if (c.equals(B)) {
						idxB.add(new Integer(i));
					}
					i++;
				}

				// check if all indices in the array idxBefore are less than
				// all indices in the array idxAfter
				for (int k = 0; k < idxA.size(); k++) {
					int idx = idxA.get(k).intValue();
					for (int j = 0; j < idxB.size(); j++) {
						if (idx < idxB.get(j).intValue()) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	private static boolean before(Device D, NamedElement A, NamedElement B) {
		if (null != D && null != A && null != B) {
			// only evaluate the BEFORE rule if the given device contains both
			// operands
			if (contains(D, A) && contains(D, B)) {
				// get all indizes of the before device
				ArrayList<Integer> idxA = new ArrayList<Integer>();
				ArrayList<Integer> idxB = new ArrayList<Integer>();

				int i = 0;
				for (Component c : D.getComponents()) {
					if (c.equals(A)) {
						idxA.add(new Integer(i));
					} else if (c.equals(B)) {
						idxB.add(new Integer(i));
					}
					i++;
				}

				// check if all indices in the array idxBefore are less than
				// all indices in the array idxAfter
				for (int k = 0; k < idxA.size(); k++) {
					int idx = idxA.get(k).intValue();
					for (int j = 0; j < idxB.size(); j++) {
						if (idx > idxB.get(j).intValue()) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	private static boolean equals(NamedElement A, NamedElement B) {
		return A.equals(B);
	}

	// the device D should contain the A element more than B
	// e.g. promoter MORETHAN 1
	private static boolean moreThan(Device D, NamedElement A, Variable N) {
		List<Component> lst = null;
		if (A instanceof Device) {
			lst = D.getComponents();
		} else {
			lst = D.getAllComponents();
		}

		int nCount = 0;
		for (Component c : lst) {
			if (null != c && c.equals(A)) {
				nCount++;
				if (nCount > N.getNum()) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean startsWith(NamedElement A, NamedElement B) {
		if (A instanceof Device) {
			if (null != ((Device) A).getComponents()
					&& !((Device) A).getComponents().isEmpty()) {
				if (B instanceof Device) {
					return (((Device) A).getComponents().get(0))
							.equals((Device) B);
				} else if (B instanceof PartType) {
					Component first = ((Device) A).getComponents().get(0);
					if (first instanceof Part) {
						return ((Part) first).getPartType().getName()
								.equals(B.getName());
					} else if (first instanceof PartType) {
						return ((PartType) first).equals((PartType) B);
					}
				} else if (B instanceof Part) {
					return (((Device) A).getAllComponents().get(0))
							.equals((Part) B);
				}
			}
		}
		return false;
	}

	public static boolean endsWith(NamedElement A, NamedElement B) {
		if (A instanceof Device) {
			if (null != ((Device) A).getComponents()
					&& !((Device) A).getComponents().isEmpty()) {
				if (B instanceof Device) {
					int nComponents = ((Device) A).getComponents().size();
					return (((Device) A).getComponents().get(nComponents - 1))
							.equals((Device) B);
				} else if (B instanceof PartType) {
					int nComponents = ((Device) A).getComponents().size();
					Component last = ((Device) A).getComponents().get(
							nComponents - 1);
					if (last instanceof Part) {
						return ((Part) last).getPartType().equals((PartType) B);
					} else if (last instanceof PartType) {
						return ((PartType) last).equals((PartType) B);
					}
				} else if (B instanceof Part) {
					int nComponents = ((Device) A).getAllComponents().size();
					return (((Device) A).getAllComponents()
							.get(nComponents - 1)).equals((Part) B);
				}
			}
		}
		return false;
	}

	private static boolean nextto(Device D, NamedElement A, NamedElement B) {
		if (null != D && null != A && null != B) {
			if (contains(D, A) && contains(D, B)) {
				int nSize = D.getComponents().size();

				int i = 0;
				Component leftToA, rightToA;
				for (Component c : D.getComponents()) {
					if (c.equals(A)) {
						if (i == 0) {
							rightToA = D.get(i + 1);
							if (!B.equals(rightToA)) {
								return false;
							}
						} else if (i == nSize - 1) {
							leftToA = D.get(i - 1);
							if (!B.equals(leftToA)) {
								return false;
							}
						} else {
							leftToA = D.get(i - 1);
							rightToA = D.get(i + 1);
							if (!B.equals(leftToA) && !B.equals(rightToA)) {
								return false;
							}
						}
					}
					i++;
				}
			}
		}
		return true;
	}

	private static boolean with(Device D, NamedElement A, NamedElement B) {
		return contains(D, A) && contains(D, B);
	}


	private static boolean then(Device D, NamedElement A, NamedElement B) {
		if (contains(D, A)) {
			return contains(D, B);
		}
		return true;
	}
}
