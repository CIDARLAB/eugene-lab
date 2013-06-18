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

package eugene.dom.rules;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;

import eugene.dom.NamedElement;
import eugene.dom.collection.CollectionElement;
import eugene.dom.components.Device;
import eugene.exception.InvalidEugeneAssignmentException;

/**
 * 
 * @author Ernst Oberortner
 */
public class Rule extends CollectionElement {

	private static final long serialVersionUID = 329956235096352013L;

	// the rule can be specified on a device
	protected Device objDevice;

	protected String operator;

	// protected String sRule;

	// protected boolean NOT=false;

	private CommonTree tree;
	private Token token;

	public Rule(String sRuleName) {
		super(sRuleName);
		this.tree = (CommonTree) null;
		this.token = (Token) null;
	}

	public Rule(String sName, Device objDevice, Token token, CommonTree tree) {
		super(sName);
		this.objDevice = objDevice;
		this.tree = tree;
		this.token = token;
	}

	public CommonTree getTree() {
		return this.tree;
	}

	public Token getToken() {
		return this.token;
	}

	public String toStringTree() {
		return this.tree.toStringTree();
	}

	public void setDevice(Device objDevice) {
		this.objDevice = objDevice;
	}

	public Device getDevice() {
		return this.objDevice;
	}

	public String getOperator() {
		return this.operator;
	}

	public String getRule() {
		if (null != this.tree) {
			return this.tree.toStringTree();
		}
		return (String) null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Rule ").append(this.sName).append(" (");

		if (null != this.objDevice) {
			sb.append("ON ").append(objDevice.getName()).append(": ");
		}

		if (null != this.token) {
			sb.append(this.tree.toStringTree());
		} else {

			if (null != this.tree) {
				sb.append(this.tree.toStringTree());
			}
		}
		sb.append(")");
		return sb.toString();
	}

	@Override
	public boolean equals(NamedElement objElement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public NamedElement get(int index) {
		return null;
	}

	@Override
	public NamedElement get(String sName) {
		return null;
	}

	@Override
	public void assign(NamedElement objElement) {
	}

	@Override
	public void set(int idx, NamedElement objElement)
			throws InvalidEugeneAssignmentException {
		throw new InvalidEugeneAssignmentException(
				"A rule does not support assignments!");
	}

	@Override
	public void set(String sRuleName, NamedElement objElement)
			throws InvalidEugeneAssignmentException {
		throw new InvalidEugeneAssignmentException(
				"A rule does not support assignments!");
	}
}
