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

package eugene.dom.components.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import eugene.dom.NamedElement;
import eugene.dom.components.Component;
import eugene.dom.components.Part;
import eugene.dom.components.Property;
import eugene.exception.EugeneException;
import eugene.exception.InvalidEugeneAssignmentException;
import eugene.parser.SymbolTables;

public class PartType extends Component {

	private static final long serialVersionUID = -6622147586177538971L;

	private ArrayList<Property> lstProperties;

	public PartType(String name) {
		super(name);

		lstProperties = new ArrayList<Property>();
	}

	public void addProperty(Property objProperty) {
		if (null != objProperty) {
			this.lstProperties.add(objProperty);
		}
	}

	public void addProperties(ArrayList<Property> lstNewProperties) {
		this.lstProperties.addAll(lstNewProperties);
	}

	public boolean contains(NamedElement objElement) {
		if (objElement != null && objElement instanceof Property) {
			Property objProperty = (Property) objElement;

			// iterate over all properties
			for (Property p : lstProperties) {
				if (p.getName().equals(objProperty.getName())) {
					return true;
				}
			}
		}
		return false;
	}

	public ArrayList<Property> getProperties() {
		return this.lstProperties;
	}

	public Property getProperty(String sPropertyName) {
		for (Property p : lstProperties) {
			if (p.getName().equals(sPropertyName)) {
				return p;
			}
		}
		return (Property) null;
	}

	// returns the i-th Property
	public Property getProperty(int idx) {
		if (idx >= 0 && idx < this.lstProperties.size()) {
			return this.lstProperties.get(idx);
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("PartType ").append(this.getName()).append(" (");
		for (int i = 0; i < this.lstProperties.size(); i++) {
			Property objProperty = lstProperties.get(i);
			sb.append(objProperty.toString());
			if (i != this.lstProperties.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append(");");
		return sb.toString();
	}

	public ArrayList<Part> getInstances() {
		return new ArrayList<Part>(SymbolTables.getParts(this));
	}

	public ArrayList<String> getInstanceNames() {

		ArrayList<String> lstPartInstanceNames = new ArrayList<String>();

		Collection<Part> colPartInstances = SymbolTables.getParts(this);
		if (null != colPartInstances && !colPartInstances.isEmpty()) {
			Iterator<Part> it = colPartInstances.iterator();
			while (it.hasNext()) {
				Part objPart = it.next();
				lstPartInstanceNames.add(objPart.getName());
			}
		}

		return lstPartInstanceNames;
	}

	public boolean compareTo(PartType objPart) {
		if (this == objPart) {
			return true;
		}
		return false;
	}

	@Override
	public void assign(NamedElement objElement)
			throws InvalidEugeneAssignmentException {
		if (null != objElement && objElement instanceof PartType) {
			this.lstProperties = new ArrayList<Property>(
					((PartType) objElement).getProperties());
		} else {
			throw new InvalidEugeneAssignmentException("I cannot assign the "
					+ objElement + " element to a part type!");
		}
	}

	@Override
	public String toSequence() throws EugeneException {
		return "<" + this.getName() + ">";
	}

	@Override
	public int size() {
		return this.lstProperties.size();
	}

	@Override
	public Property get(int index) {
		if (index >= 0 && index < this.lstProperties.size()) {
			return this.lstProperties.get(index);
		}
		return null;
	}

	@Override
	public Property get(String sPropertyName) {
		for (Property p : this.lstProperties) {
			if (p.getName().equals(sPropertyName)) {
				return p;
			}
		}
		return (Property) null;
	}

	@Override
	public boolean equals(NamedElement objComponent) {
		if (objComponent == null) {
			return false;
		} else if (objComponent instanceof Part) {
			Part objPart = (Part) objComponent;
			return this.equals(objPart.getPartType());
		} else if (!(objComponent instanceof PartType)) {
			return false;
		}

		PartType objPartType = (PartType) objComponent;
		if (!objPartType.getName().equals(this.sName)) {
			return false;
		}

		// compare the list of properties
		if (this.lstProperties.size() != objPartType.lstProperties.size()) {
			return false;
		}

		for (int i = 0; i < lstProperties.size(); i++) {
			if (!this.lstProperties.get(i).equals(
					objPartType.lstProperties.get(i))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void add(NamedElement objElement)
			throws InvalidEugeneAssignmentException {
		if (objElement instanceof Property) {
			this.lstProperties.add((Property) objElement);
		} else {
			throw new InvalidEugeneAssignmentException("Cannot assign "
					+ objElement.getClass().toString() + " to a Part Type!");
		}
	}

	@Override
	public void set(int idx, NamedElement objElement)
			throws InvalidEugeneAssignmentException {
		// set the idx-th property to the given element
		if (idx >= 0 && idx < this.lstProperties.size()
				&& objElement instanceof Property) {
			this.lstProperties.set(idx, (Property) objElement);
		} else {
			throw new InvalidEugeneAssignmentException(objElement
					+ " is not a Property and hence cannot be assigned to the "
					+ (idx + 1) + " property of the " + this.getName()
					+ " Part Type");
		}

	}

	@Override
	public void set(String sPropertyName, NamedElement objElement)
			throws InvalidEugeneAssignmentException {
		throw new InvalidEugeneAssignmentException(
				"Cannot set the property value of a Part Type!");
	}

	public boolean isInstanceOf(String sType) {
		return false;
	}
}
