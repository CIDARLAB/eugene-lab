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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import eugene.constants.EugeneConstants;
import eugene.dom.NamedElement;
import eugene.dom.Variable;
import eugene.dom.components.types.PartType;
import eugene.exception.EugeneException;
import eugene.exception.InvalidEugeneAssignmentException;
import eugene.interpreter.EugeneBuilder;
import eugene.parser.SymbolTables;

public class Device extends Component {

	private static final long serialVersionUID = 5413691795953256377L;

	private ArrayList<Component> lstComponents;

	private String sDeviceType;

	// the isValid flag marks the device if it passes all defined rules
	// one rule is violated => isValid=false
	// no rule is violated => isValid=true
	// this information is used for the SBOL serialization of the device
	private boolean isValid;

	protected Device() {
		super();
	}

	private Device(String name) {
		super(name);
		lstComponents = new ArrayList<Component>();
		this.sDeviceType = (String) null;
	}

	public static Device newInstance(String sName) {
		return new Device(sName);
	}

	public static Device newInstance(String sName, List<Component> lstComponents) {
		Device objDevice = new Device(sName);
		objDevice.setComponents(lstComponents);
		objDevice.setDeviceType((String) null);
		return objDevice;
	}

	public static Device newInstance(String sName,
			List<Component> lstComponents, String sDeviceType) {
		Device objDevice = new Device(sName);
		objDevice.setComponents(lstComponents);
		objDevice.setDeviceType(sDeviceType);
		return objDevice;
	}

	public void setComponents(List<Component> lstComponents) {
		// System.out.println("[Device.setComponents] -> "+lstComponents.size());

		// for(Component c:lstComponents) {
		// System.out.println(c.getName());
		// }
		this.lstComponents = new ArrayList<Component>(lstComponents);
	}

	public void setDeviceType(String sDeviceType) {
		this.sDeviceType = sDeviceType;
	}

	public String getDeviceType() {
		return this.sDeviceType;
	}

	@Override
	public void add(NamedElement objElement) {
		if (null != objElement && objElement instanceof Component) {
			// System.out.println(this.getName()+".add("+objComponent.getName()+")");
			lstComponents.add((Component) objElement);
		}
	}

	public void add(List<Component> lstComponents) {
		if (null != lstComponents && !lstComponents.isEmpty()) {
			Iterator<Component> it = lstComponents.iterator();
			while (it.hasNext()) {
				Component objComponent = it.next();
				if (null == this.lstComponents) {
					this.lstComponents = new ArrayList<Component>(
							lstComponents.size());
				}
				this.lstComponents.add(objComponent);
			}
		}
	}

	public void addComponentsByName(List<String> lstComponentNames) {
		if (null != lstComponentNames && !lstComponentNames.isEmpty()) {
			Iterator<String> it = lstComponentNames.iterator();
			while (it.hasNext()) {
				this.lstComponents.add((Component) SymbolTables.get(it.next()));
			}
		}
	}

	public void clear() {
		if (null != this.lstComponents) {
			this.lstComponents.clear();
			this.lstComponents = null;
		}
	}

	// the get method returns the i-th component of the device
	@Override
	public Component get(int idx) {
		Component objComponent = null;
		if (idx >= 0 && idx < this.lstComponents.size()) {
			objComponent = this.lstComponents.get(idx);
		}
		return objComponent;
	}

	public ArrayList<Component> getAllComponents() {
		ArrayList<Component> lst = new ArrayList<Component>();
		if (null != this.lstComponents && !this.lstComponents.isEmpty()) {
			Iterator<Component> it = this.lstComponents.iterator();
			while (it.hasNext()) {
				Component objComponent = it.next();
				if (null != objComponent && objComponent instanceof Device) {
					Device containingDevice = (Device) objComponent;
					lst.addAll(containingDevice.getAllComponents());
				} else {
					lst.add(objComponent);
				}
			}
		}
		return lst;
	}

	public ArrayList<Component> getComponents() {
		ArrayList<Component> lstComponents = new ArrayList<Component>();
		if (null != this.lstComponents && !this.lstComponents.isEmpty()) {
			Iterator<Component> it = this.lstComponents.iterator();
			while (it.hasNext()) {
				lstComponents.add(it.next());
			}
		}
		return lstComponents;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Device ").append(this.getName()).append("(");
		int n = 0;
		for (Component c : this.lstComponents) {
			sb.append(c.getName()); // toString());
			if ((++n) < this.lstComponents.size()) {
				sb.append(",");
			}
		}
		sb.append(")");
		return sb.toString();
	}

	public void setIsValid(boolean b) {
		this.isValid = b;
	}

	public boolean isValid() {
		return isValid;
	}

	public String toSequence() throws EugeneException {

		StringBuilder sb = new StringBuilder();
		if (null != this.lstComponents && !this.lstComponents.isEmpty()) {
			Iterator<Component> it = this.lstComponents.iterator();
			while (it.hasNext()) {
				Component objComponent = it.next();

				if (objComponent instanceof Device) {
					Device d = (Device) objComponent;
					sb.append(d.toSequence());
				} else if (objComponent instanceof PartType) {
					PartType p = (PartType) objComponent;
					sb.append("<").append(p.getName()).append(">");
				} else if (objComponent instanceof Part) {
					Part pi = (Part) objComponent;
					String sSequence = pi.toSequence();
					if (null != sSequence) {
						sb.append(sSequence);
						
						/**
						throw new EugeneException("Part Instance "
								+ pi.getName()
								+ " does not have a DNA sequence!");
						**/
					}
				}
			}
		}
		return sb.toString();
	}

	public boolean compareTo(Device objDevice) {
		if (this == objDevice) {
			return true;
		}
		return false;
	}

	@Override
	public void assign(NamedElement objElement)
			throws InvalidEugeneAssignmentException {
		if (objElement instanceof Device) {
			this.lstComponents = new ArrayList<Component>(
					((Device) objElement).getComponents());
		} else {
			throw new InvalidEugeneAssignmentException("Cannot assign a "
					+ objElement.getClass() + " value to a Device!");
		}
	}

	/**
	 * public DnaComponent toSBOL() { // create a DnaComponent and set some of
	 * its properties DnaComponent dnaComponent =
	 * SBOLFactory.createDnaComponent();
	 * dnaComponent.setURI(URI.create("http://cidarlab/"+this.getName()));
	 * dnaComponent.setDisplayId(this.getName());
	 * dnaComponent.setName(this.getName());
	 * dnaComponent.setDescription(this.getComponents().toString());
	 * 
	 * // set the DNA sequence DnaSequence seq=SBOLFactory.createDnaSequence();
	 * try { seq.setNucleotides(this.toSequence()); } catch (EugeneException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); }
	 * dnaComponent.setDnaSequence(seq);
	 * 
	 * 
	 * ArrayList<Component> lstComponents=this.getAllComponents(); for(int
	 * i=0;i<lstComponents.size();i++) { NamedElement
	 * objElement=lstComponents.get(i); if(objElement instanceof Component) {
	 * SequenceAnnotation sa = SBOLFactory.createSequenceAnnotation();
	 * sa.setSubComponent(((Component)objElement).toSBOL()); } }
	 * 
	 * return dnaComponent; }
	 **/

	@Override
	public int size() {
		return this.getComponents().size();
	}

	@Override
	public boolean contains(NamedElement objElement) {
		boolean b = false;
		if (objElement != null && objElement instanceof Component) {
			Component objComponent = (Component) objElement;
			for (int i = 0; i < lstComponents.size() && !b; i++) {
				Component objDeviceComponent = lstComponents.get(i);
				if (objDeviceComponent.equals(objComponent)) {
					return true;
				} else if (objDeviceComponent instanceof Device) {
					b = ((Device) objDeviceComponent).contains(objComponent);
				}
			}
		}
		return b;
	}

	@Override
	public NamedElement get(String sName) {
		// System.out.println("[Device.get] "+this.getName()+".get("+sName+")");

		if (null == sName || null == this.lstComponents
				|| this.lstComponents.isEmpty()) {
			return null;
		}

		if ("name".equals(sName.toLowerCase())) {
			return EugeneBuilder.buildVariable(this.getName());
			// return new Property("name", EugeneConstants.TXT);
		}

		for (Component objComponent : this.lstComponents) {
			if (sName.equals(objComponent.getName())) {
				return objComponent;
			}
		}

		ArrayList<Component> lstComponents = this.getAllComponents();
		for (int i = 0; i < lstComponents.size(); i++) {
			Component objComponent = lstComponents.get(i);

			if (sName.equals(objComponent.getName())) {
				return objComponent;
			} else if (objComponent instanceof Part) {
				Part objPart = (Part) objComponent;
				if (sName.equals(objPart.getPartType().getName())) {
					return objPart;
				}
			}
		}

		return (NamedElement) null;
	}

	public Part getParts(PartType objPartType) {
		// TODO: iterate over the device's components and check if the part
		// is an instance of the given part type
		if (null != objPartType) {
			for (Component objComponent : this.getAllComponents()) {
				if (objComponent instanceof Part) {
					Part objPart = (Part) objComponent;
					if (objPart.getPartType().equals(objPartType)) {
						return objPart;
					}
				}
			}
		}
		return (Part) null;
	}

	@Override
	public boolean equals(NamedElement objComponent) {

		if (!(objComponent instanceof Device)) {
			return false;
		}

		Device objDevice = (Device) objComponent;

		ArrayList<Component> lstThisComponents = this.getAllComponents();
		ArrayList<Component> lstComponents = objDevice.getAllComponents();

		if (lstComponents.size() != lstThisComponents.size()) {
			return false;
		}
		for (int i = 0; i < lstThisComponents.size(); i++) {
			if (!lstThisComponents.get(i).equals(lstComponents.get(i))) {
				return false;
			}
		}
		return true;
	}

	public int indexOf(NamedElement objElement) {
		if (objElement != null && objElement instanceof Component) {
			Iterator<Component> it = this.lstComponents.iterator();
			int i = 0;
			while (it.hasNext()) {
				if (((Component) objElement).equals(it.next())) {
					return i;
				}
				i++;
			}
		}

		return -1;
	}

	public int lastIndexOf(NamedElement objElement) {
		if (objElement != null && objElement instanceof Component) {
			Component objComponent = (Component) objElement;
			if (objComponent instanceof Device) {
				for (int i = this.lstComponents.size() - 1; i >= 0; i--) {
					if (this.lstComponents.get(i).equals(objComponent)) {
						return i;
					}
				}
			} else {
				ArrayList<Component> lst = this.getAllComponents();
				for (int i = lst.size() - 1; i >= 0; i--) {
					// System.out.println(lst.get(i)+" vs. "+objComponent+" -> "+lst.get(i).equals(objComponent));
					if (lst.get(i).equals(objComponent)) {
						// System.out.println("returning "+i);
						return i;
					}
				}
			}
		}
		return -1;
	}

	/*
	 * the count method counts the occurrence of the given component in the
	 * device
	 */
	public int count(Component objComponent) {
		int nCount = 0;
		if (null != this.lstComponents && !lstComponents.isEmpty()) {
			Iterator<Component> it = this.lstComponents.iterator();
			while (it.hasNext()) {
				Component objDeviceComponent = it.next();
				if (objDeviceComponent instanceof Device) {
					nCount += ((Device) objDeviceComponent).count(objComponent);
				} else if (objDeviceComponent.equals(objComponent)) {
					nCount++;
				}
			}
		}
		return nCount;
	}

	@Override
	public void set(int idx, NamedElement objElement)
			throws InvalidEugeneAssignmentException {
		if (objElement instanceof Component && idx >= 0
				&& idx < this.lstComponents.size()) {
			Component objComponent = this.lstComponents.get(idx);
			objComponent.assign(objElement);
		} else {
			throw new InvalidEugeneAssignmentException("Cannot assign the "
					+ objElement + " element to the " + (idx + 1)
					+ " component of the " + this.getName() + " Device");
		}
	}

	@Override
	public void set(String sElementName, NamedElement objAssignElement)
			throws InvalidEugeneAssignmentException {
		if (null != sElementName && "name".equals(sElementName.toLowerCase())) {
			if (null == objAssignElement
					|| !(objAssignElement instanceof Variable)
					|| !EugeneConstants.TXT
							.equals(((Variable) objAssignElement).getType())) {
				throw new InvalidEugeneAssignmentException(objAssignElement
						+ " is an invalid name for the " + this.getName()
						+ " device!");
			} else {
				this.sName = ((Variable) objAssignElement).getTxt();
			}
		} else {
			throw new InvalidEugeneAssignmentException(sElementName
					+ " is an invalid property name for a device!");
		}
	}

	public boolean isAbstract() {
		Iterator<Component> it = this.getAllComponents().iterator();
		while (it.hasNext()) {
			if (it.next() instanceof Part) {
				return false;
			}
		}
		return true;
	}

	public boolean isConcrete() {
		Iterator<Component> it = this.getAllComponents().iterator();
		while (it.hasNext()) {
			if (!(it.next() instanceof Part)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isInstanceOf(String sDeviceType) {
		if (null != this.sDeviceType && null != sDeviceType) {
			return this.sDeviceType.equals(sDeviceType);
		}
		return false;
	}
}
