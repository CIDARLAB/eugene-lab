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

package eugene.dom.arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import eugene.dom.NamedElement;
import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.exception.InvalidEugeneAssignmentException;
import eugene.parser.SymbolTables;

public class DeviceArray extends ComponentArray {

	private static final long serialVersionUID = 2775241154187528389L;

	private ArrayList<String> lstDeviceNames;

	public DeviceArray(String sName) {
		super(sName);
		lstDeviceNames = new ArrayList<String>();
	}

	public DeviceArray(String sName, int nSize) {
		super(sName);
		lstDeviceNames = new ArrayList<String>(nSize);
	}

	public void setDeviceNames(ArrayList<String> lstDeviceNames) {
		this.lstDeviceNames = lstDeviceNames;
	}

	public ArrayList<String> getDeviceNames() {
		return this.lstDeviceNames;
	}

	public void add(String sDeviceName) {
		this.lstDeviceNames.add(sDeviceName);
	}

	public void addAll(DeviceArray objArray) {
		if (null != objArray && null != objArray.lstDeviceNames
				&& !objArray.lstDeviceNames.isEmpty()) {

			if (null == this.lstDeviceNames) {
				this.lstDeviceNames = new ArrayList<String>();
			}

			this.lstDeviceNames.addAll(objArray.getDeviceNames());
		}
	}

	public NamedElement get(int idx) {
		if (idx >= 0 && idx < lstDeviceNames.size()) {
			return SymbolTables.get(this.lstDeviceNames.get(idx));
		}
		return null;
	}

	public Device get(String sDeviceName) {
		if (sDeviceName != null) {
			if (this.lstDeviceNames.contains(sName)) {
				return (Device) SymbolTables.get(sDeviceName);
			}
		}
		return null;
	}

	@Override
	public boolean equals(NamedElement objElement) {
		if (objElement != null && objElement instanceof DeviceArray) {
			DeviceArray objDeviceArray = (DeviceArray) objElement;
			if (objDeviceArray.getDeviceNames().equals(this.lstDeviceNames)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		if (this.lstDeviceNames != null && !this.lstDeviceNames.isEmpty()) {
			return this.lstDeviceNames.size();
		}
		return 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Device[] ").append(this.getName()).append(" [");
		if (null != this.lstDeviceNames && !lstDeviceNames.isEmpty()) {
			for (String s : lstDeviceNames) {
				sb.append(s).append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public boolean contains(Device objDevice) {
		if (null != objDevice) {
			return lstDeviceNames.contains(objDevice.getName());
		}
		return false;
	}

	public boolean contains(String sDeviceName) {
		if (null != sDeviceName && !sDeviceName.isEmpty()) {
			return this.lstDeviceNames.contains(sDeviceName);
		}
		return false;
	}

	@Override
	public void assign(NamedElement objElement)
			throws InvalidEugeneAssignmentException {
		if (objElement == null) {
			throw new InvalidEugeneAssignmentException(
					""
							+ "I cannot assign an undefined value to an array of devices!");
		} else if (!(objElement instanceof DeviceArray)) {
			throw new InvalidEugeneAssignmentException(""
					+ "Incompatible types! I cannot assign the " + objElement
					+ " element to an array of devices!");
		}
		this.lstDeviceNames = new ArrayList<String>(
				((DeviceArray) objElement).getDeviceNames());
	}

	@Override
	public void set(int idx, NamedElement objElement)
			throws InvalidEugeneAssignmentException {
		if (objElement instanceof Device) {
			if (idx >= 0 && idx < this.lstDeviceNames.size()) {
				this.lstDeviceNames.set(idx, ((Device) objElement).getName());
			} else {
				throw new InvalidEugeneAssignmentException("Array index ("
						+ idx + ") is out of bounds!");
			}
		} else {
			throw new InvalidEugeneAssignmentException(objElement.getName()
					+ " is not a Device!");
		}

	}

	@Override
	public void set(String sDeviceName, NamedElement objElement)
			throws InvalidEugeneAssignmentException {
		if (null != this.lstDeviceNames && !this.contains(sDeviceName)) {
			if (objElement instanceof Device) {
				this.lstDeviceNames.set(
						this.lstDeviceNames.indexOf(sDeviceName),
						objElement.getName());
			} else {
				throw new InvalidEugeneAssignmentException("I cannot place a "
						+ objElement.getClass() + " element into the "
						+ this.getName() + " Device list!");
			}
		} else {
			throw new InvalidEugeneAssignmentException("The " + this.getName()
					+ " Device list does not contain a Device named "
					+ sDeviceName + "!");
		}
	}

	public void add(NamedElement objElement)
			throws InvalidEugeneAssignmentException {

		if (!(objElement instanceof Device)) {
			throw new InvalidEugeneAssignmentException("I cannot add the "
					+ objElement.getName() + " to the " + this.getName()
					+ " device array!");
		}

		if (this.contains((Device) objElement)) {
			throw new InvalidEugeneAssignmentException("The " + this.getName()
					+ " device array contains the " + objElement.getName()
					+ " device already!");
		}

		lstDeviceNames.add(objElement.getName());
	}

	public boolean isEmpty() {
		return this.lstDeviceNames.isEmpty();
	}

	@Override
	public ArrayList<Device> getComponents() {
		if (null != this.lstDeviceNames && !this.lstDeviceNames.isEmpty()) {
			ArrayList<Device> lst = new ArrayList<Device>(
					this.lstDeviceNames.size());
			for (String s : this.lstDeviceNames) {
				lst.add((Device) SymbolTables.get(s));
			}
			return lst;
		}
		return new ArrayList<Device>();
	}

}
