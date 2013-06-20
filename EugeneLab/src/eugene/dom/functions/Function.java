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

package eugene.dom.functions;

import java.util.ArrayList;

import org.antlr.runtime.Token;

import eugene.dom.NamedElement;
import eugene.dom.StackElement;
import eugene.dom.components.Part;
import eugene.dom.components.types.PartType;
import eugene.exception.EugeneException;
import eugene.exception.InvalidEugeneAssignmentException;
import eugene.parser.SymbolTables;

/**
 * 
 * @author Ernst Oberortner
 */
public class Function extends NamedElement implements StackElement {

	private static final long serialVersionUID = -2617280999823349320L;

	private NamedElement objReturn;
	private ArrayList<NamedElement> lstParameters;
	private Token lstStatements;
	private int nOldPosition;
	private NamedElement objReturnValue;

	public Function(String sName) {
		super(sName);
		this.objReturn = null;
		this.lstParameters = new ArrayList<NamedElement>();
		this.lstStatements = null;
		nOldPosition = 0;
		objReturnValue = null;
	}

	public String getName() {
		return sName;
	}

	public void setReturn(NamedElement objReturn) {
		this.objReturn = objReturn;
	}

	public NamedElement getReturn() {
		return this.objReturn;
	}

	public void setOldPosition(int nOldPosition) {
		this.nOldPosition = nOldPosition;
	}

	public int getOldPosition() {
		return nOldPosition;
	}

	public void setReturnValue(NamedElement objReturnValue) {
		this.objReturnValue = objReturnValue;
	}

	public NamedElement getReturnValue() {
		return this.objReturnValue;
	}

	public NamedElement get(String sName) {
		return (NamedElement) null;
	}

	public void setStatements(Token lstStatements) {
		this.lstStatements = lstStatements;
	}

	public Token getStatements() {
		return this.lstStatements;
	}

	public void setParameters(ArrayList<NamedElement> lstParameters) {
		this.lstParameters = lstParameters;
	}

	public ArrayList<NamedElement> getParameters() {
		return this.lstParameters;
	}

	@Override
	public String toString() {
		String NEWLINE = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		sb.append("function ");

		if (null != objReturn) {
			sb.append(this.objReturn.getName()).append(" ");
		}
		sb.append(this.sName).append("(");

		// parameters
		if (null != this.lstParameters && !this.lstParameters.isEmpty()) {
			int i = 0;
			for (NamedElement ne : lstParameters) {
				sb.append(ne.getName());
				if ((i++) < this.lstParameters.size() - 1) {
					sb.append(", ");
				}
			}
		}

		sb.append(") {").append(NEWLINE);

		// statements
		sb.append(lstStatements);

		sb.append("}");

		return sb.toString();
	}

	public boolean checkParameters(ArrayList<NamedElement> lstValues) {
		if (null == lstValues && this.lstParameters != null) {
			return false;
		} else {
			if (null != lstValues && null != this.lstParameters) {
				if (lstValues.size() <= this.lstParameters.size()) {
					// compare both lists
					for (int i = 0; i < lstValues.size(); i++) {
						NamedElement objParameter = lstParameters.get(i);
						NamedElement objValue = lstValues.get(i);
						if (!objValue.getClass()
								.equals(objParameter.getClass())
								&& !(objValue instanceof Part && objParameter instanceof PartType)) {
							return false;
						}
					}
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public void initSymbolTables(ArrayList<NamedElement> lstValues)
			throws EugeneException {
		if (lstValues != null && lstParameters != null) {
			if (lstValues.size() <= lstParameters.size()) {
				// put the parameter values into the function's symbol tables
				int i = 0;
				for (; i < lstValues.size(); i++) {
					NamedElement objValue = lstValues.get(i);
					NamedElement objParameter = lstParameters.get(i);

					// special case: part type & part
					try {
						if (objValue instanceof Part
								&& objParameter instanceof PartType) {
							SymbolTables.put(objParameter.getName(),
									(Part) objValue);
						} else {
							objParameter.assign(objValue);
							SymbolTables.put(objParameter);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				if (i < lstParameters.size()) {
					for (int j = i; j < lstParameters.size(); j++) {
						SymbolTables.put(lstParameters.get(j));
					}
				}
			}
		}
	}

	public void clear() {
		SymbolTables.clear(SymbolTables.peek().toString());
	}

	@Override
	public void assign(NamedElement objElement)
			throws InvalidEugeneAssignmentException {
		// TODO Auto-generated method stub
	}

	@Override
	public void set(String sElementName, NamedElement objElement)
			throws InvalidEugeneAssignmentException {
		// TODO Auto-generated method stub
	}

	@Override
	public void set(int idx, NamedElement objElement)
			throws InvalidEugeneAssignmentException {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean equals(NamedElement objElement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NamedElement get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
}
