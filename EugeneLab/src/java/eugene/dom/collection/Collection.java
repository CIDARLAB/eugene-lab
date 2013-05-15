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

package eugene.dom.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import eugene.dom.NamedElement;
import eugene.dom.StackElement;
import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.dom.components.Part;
import eugene.dom.components.types.PartType;
import eugene.dom.rules.Rule;
import eugene.exception.EugeneException;
import eugene.exception.InvalidEugeneAssignmentException;

/**
 * @author Ernst Oberortner
 */
public class Collection extends NamedElement implements StackElement {

	private static final long serialVersionUID = 2294013861157113570L;
	private HashSet<CollectionElement> hmElements;

	public Collection(String sName) {
		super(sName);
		this.hmElements = new HashSet<CollectionElement>();
	}

	public String getName() {
		return this.sName;
	}

	public void setElements(Set<CollectionElement> hmElements) {
		this.hmElements = new HashSet<CollectionElement>(hmElements);
	}

	public HashSet<CollectionElement> getElements() {
		return this.hmElements;
	}

	/** GET elements of the collection **/
	public CollectionElement get(int idx) throws EugeneException {
		if (idx >= 0 && idx < this.hmElements.size()) {
			return (CollectionElement) (this.hmElements.toArray())[idx];
		}
		throw new EugeneException(idx + " is an invalid index!");
	}

	public CollectionElement get(String sName) throws EugeneException {
		if (null != sName) {
			Iterator<CollectionElement> it = this.hmElements.iterator();
			while (it.hasNext()) {
				CollectionElement objElement = it.next();
				if (null != objElement && sName.equals(objElement.getName())) {
					return objElement;
				}
			}
			throw new EugeneException("The " + this.getName()
					+ " collection does not contain an element named " + sName
					+ "!");
		}
		throw new EugeneException(sName + " is an invalid identifier!");
	}

	public HashSet<CollectionElement> getCollectionElements() {
		return this.hmElements;
	}

	/** SET elements of the collection **/
	public void set(int idx, CollectionElement objElement)
			throws InvalidEugeneAssignmentException {
		throw new InvalidEugeneAssignmentException(
				"It's not possible to set a collection's element at a given index!");
	}

	public void set(String sElementName, CollectionElement objElement)
			throws InvalidEugeneAssignmentException {
		if (objElement == null || !(objElement instanceof CollectionElement)) {
			throw new InvalidEugeneAssignmentException("I cannot assign the "
					+ objElement.getName() + " element to the "
					+ this.getName() + " collection!");
		}

		try {
			CollectionElement objListCollectionElement = this.get(sElementName);
			objListCollectionElement.assign(objElement);
		} catch (EugeneException e) {
			throw new InvalidEugeneAssignmentException(e.getMessage());
		}
	}

	/** CONTAINS **/
	public boolean contains(String sCollectionElement) {
		if (null != sCollectionElement && !this.hmElements.isEmpty()) {
			Iterator<CollectionElement> it = this.hmElements.iterator();
			while (it.hasNext()) {
				if (sCollectionElement.equals(it.next().getName())) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean contains(CollectionElement objElement) {
		if (null != objElement) {
			return this.hmElements.contains(objElement);
		}
		return false;
	}

	/** PUT **/
	public boolean put(NamedElement objElement) {
		if (null != objElement && objElement instanceof CollectionElement) {
			CollectionElement objCollectionElement = (CollectionElement) objElement;
			if (!this.contains(objCollectionElement)) {
				hmElements.add(objCollectionElement);
				return true;
			}
		}
		return false;
	}

	public boolean put(String sKey, NamedElement objElement) {
		if (null != sKey && !this.contains(sKey) && null != objElement
				&& objElement instanceof CollectionElement) {
			hmElements.add((CollectionElement) objElement);
			return true;
		}
		return false;
	}

	/** ADD **/
	public boolean add(CollectionElement objElement) {
		if (!this.contains(objElement)) {
			this.put(objElement.getName(), objElement);
			return true;
		}
		return false;
	}

	public boolean add(String sKey, CollectionElement objElement) {
		if (null != sKey && !this.contains(sKey)) {
			this.put(sKey, objElement);
			return true;
		}
		return false;
	}

	public boolean addAll(ArrayList<CollectionElement> lstElements) {
		if (null != lstElements && !lstElements.isEmpty()) {
			Iterator<CollectionElement> it = lstElements.iterator();
			while (it.hasNext()) {
				CollectionElement ce = it.next();
				this.add(ce.getName(), ce);
			}
		}
		return false;
	}

	/** REPLACE **/
	public boolean replace(String sCollectionElement,
			CollectionElement objElement) {
		if (null != sCollectionElement && this.contains(sCollectionElement)) {
			if (null != objElement && !objElement.getName().isEmpty()) {
				this.hmElements.remove(sCollectionElement);
				this.hmElements.add(objElement);
				return true;
			}
		}
		return false;
	}

	public boolean replace(int idx, CollectionElement objElement) {
		return false;
	}

	/** REMOVE **/
	public boolean remove(int idx) {
		return false;
	}

	public boolean remove(CollectionElement objElement) {
		if (objElement != null) {
			if (this.contains(objElement)) {

			} else if (this.contains(objElement.getName())) {

			}
		}
		return false;
	}

	public boolean remove(String sName) {
		if (null != sName && this.contains(sName)) {
			this.hmElements.remove(sName);
			return true;
		}
		return false;
	}

	public int size() {
		return this.hmElements.size();
	}

	public boolean equals(NamedElement objElement) {
		System.out.println("TODO: implement the equals method of Collection");
		return false;
	}

	@Override
	public void assign(NamedElement objCollection)
			throws InvalidEugeneAssignmentException {
		if (null == objCollection || !(objCollection instanceof Collection)) {
			throw new InvalidEugeneAssignmentException("I cannot assign the "
					+ objCollection.getName() + " collection to the "
					+ this.getName() + " collection!");
		}

		// assign the objCollection's elements to this elements
		if (this.hmElements != null) {
			this.hmElements.clear();
		}

		this.hmElements = new HashSet<CollectionElement>(
				((Collection) objCollection).getElements());
	}

	public ArrayList<Device> getDevices() {
		ArrayList<Device> lstDevices = new ArrayList<Device>();
		Iterator<CollectionElement> it = this.hmElements.iterator();
		while (it.hasNext()) {
			CollectionElement objElement = it.next();
			if (objElement instanceof Device) {
				lstDevices.add((Device) objElement);
			}
		}
		return lstDevices;
	}

	public ArrayList<PartType> getPartTypes() {
		ArrayList<PartType> lstPartTypes = new ArrayList<PartType>();
		Iterator<CollectionElement> it = this.hmElements.iterator();
		while (it.hasNext()) {
			CollectionElement objElement = it.next();
			if (objElement instanceof PartType) {
				lstPartTypes.add((PartType) objElement);
			}
		}
		return lstPartTypes;
	}

	public ArrayList<Part> getParts() {
		ArrayList<Part> lstParts = new ArrayList<Part>();
		Iterator<CollectionElement> it = this.hmElements.iterator();
		while (it.hasNext()) {
			CollectionElement objElement = it.next();
			if (objElement instanceof Part) {
				lstParts.add((Part) objElement);
			}
		}
		return lstParts;
	}

	public ArrayList<Part> getParts(PartType objPartType) {
		ArrayList<Part> lst = new ArrayList<Part>();
		Iterator<Part> it = this.getParts().iterator();
		while (it.hasNext()) {
			Part objPart = it.next();
			if (objPart.getPartType().getName().equals(objPartType.getName())) {
				lst.add(objPart);
			}
		}
		return lst;
	}

	public void set(String sElementName, NamedElement objElement)
			throws InvalidEugeneAssignmentException {
	}

	public void cleanUp() {
		if (null != this.hmElements) {
			this.hmElements.clear();
			this.hmElements = null;
		}
		System.gc();
	}

	@Override
	public String toString() {
		String NEWLINE = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		sb.append("Collection ").append(this.getName()).append(" (")
				.append(NEWLINE);
		if (null != this.hmElements && !this.hmElements.isEmpty()) {
			Iterator<CollectionElement> it = this.hmElements.iterator();
			while (it.hasNext()) {
				CollectionElement objElement = it.next();
				sb.append(objElement.toString());
				if (it.hasNext()) {
					sb.append(", ").append(NEWLINE);
				}
			}
		}
		sb.append(" );");
		return sb.toString();
	}

	public void remove(NamedElement objElement) {
		// TODO Auto-generated method stub

	}

	@Override
	public void set(int idx, NamedElement objElement)
			throws InvalidEugeneAssignmentException {
		// TODO Auto-generated method stub

	}

	public java.util.Collection<Rule> getRules() {
		ArrayList<Rule> lstRules = new ArrayList<Rule>();
		if (null != this.hmElements) {
			Iterator<CollectionElement> it = this.hmElements.iterator();
			while (it.hasNext()) {
				CollectionElement objElement = it.next();
				if (objElement instanceof Rule) {
					lstRules.add((Rule) objElement);
				}
			}
		}
		return lstRules;
	}

	public ArrayList<Component> toArrayList() {
		if (null != this.hmElements && !this.hmElements.isEmpty()) {
			ArrayList<Component> lstComponents = new ArrayList<Component>(
					this.hmElements.size());

			Iterator<CollectionElement> it = this.hmElements.iterator();
			while (it.hasNext()) {
				CollectionElement objElement = it.next();
				if (objElement instanceof Component) {
					lstComponents.add((Component) objElement);
				}
			}

			return lstComponents;
		}
		return null;
	}

	@Override
	public void clear() {
		if (null != this.hmElements) {
			this.hmElements.clear();
			this.hmElements = null;
		}
	}

}
