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

package eugene.dom.components;

import eugene.dom.NamedElement;
import eugene.dom.collection.CollectionElement;
import eugene.exception.EugeneException;
import eugene.exception.InvalidEugeneAssignmentException;

/**
 * 
 * @author Ernst Oberortner
 */
public abstract class Component extends CollectionElement {

	private static final long serialVersionUID = 6045834162841472128L;
	private String sSequence;

	protected Component() {
		super();
	}

	public Component(String sName) {
		super(sName);
	}

	public void setSequence(String sSequence) {
		this.sSequence = sSequence;
	}

	public String getSequence() {
		return this.sSequence;
	}

	// public abstract void assign(Component objComponent);
	public abstract String toSequence() throws EugeneException;

	public abstract int size();

	public abstract boolean contains(NamedElement objElement);

	public abstract void add(NamedElement objElement)
			throws InvalidEugeneAssignmentException;

	public abstract boolean isInstanceOf(String sType);
}
