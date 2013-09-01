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

package org.cidarlab.eugene.dom.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import JaCoP.core.Domain;
import JaCoP.core.ValueEnumeration;

import org.cidarlab.eugene.cache.SymbolTables;
import org.cidarlab.eugene.dom.NamedElement;
import org.cidarlab.eugene.dom.components.Component;
import org.cidarlab.eugene.dom.components.Device;
import org.cidarlab.eugene.exception.EugeneException;
import org.cidarlab.eugene.exception.EugeneException;

public class DeviceArray 
	extends ComponentArray {

	private static final long serialVersionUID = 2775241154187528389L;

	// v1.8
	private ArrayList<String> lstDeviceNames;
	
	// v1.9
	private long[] devices;
	private long[][] device_components;
	
	public DeviceArray() {
		super(null);
		lstDeviceNames = new ArrayList<String>();
	}
	
	public DeviceArray(String sName) {
		super(sName);
		lstDeviceNames = new ArrayList<String>();
	}
	
	// for product()
	private Device device;
	private Domain[][] solutions;
	public DeviceArray(Device device, Domain[][] solutions) {
		super(null);
		this.device = device;
		this.solutions = solutions;
	}
	
	public Domain[][] getSolutions() {
		return this.solutions;
	}
	
	// v1.9 -- Constructor
	public DeviceArray(String sName, long[] devices) {
		super(sName);
		this.devices = devices;
	}
	public DeviceArray(String sName, long[][] device_components) {
		super(sName);
		this.device_components = device_components;
	}

	public long[] getDevices() {
		return this.devices;
	}
	
	/** ITERATOR FUNCTIONS **/	
	public boolean hasNext() {
		return false;
	}
	
	public Device next() {
		return null;
	}
	

	public DeviceArray(String sName, int nSize) {
		super(sName);
		lstDeviceNames = new ArrayList<String>(nSize);
	}

	public DeviceArray(String sName, List<String> lstDeviceNames) {
		super(sName);
		this.lstDeviceNames = new ArrayList<String>(lstDeviceNames);
	}

	public void setDeviceNames(ArrayList<String> lstDeviceNames) {
		this.lstDeviceNames = lstDeviceNames;
	}

	public ArrayList<String> getDeviceNames() {
		return this.lstDeviceNames;
	}
	
	public void add(long deviceId) {
		this.devices = ArrayUtils.add(this.devices, deviceId);
	}
	
	public void addAll(long[] devices) {
		this.devices = ArrayUtils.addAll(this.devices, devices);
	}
	
	public void remove(int idx) {
		if(idx>=0 && idx<this.devices.length) {
			this.devices = ArrayUtils.remove(this.devices, idx);
		}
	}
	
	public void add(String sDeviceName) {
		System.out.println("[DeviceArray.add] -> "+sDeviceName);
		
		this.lstDeviceNames.add(sDeviceName);
	}

	public void addAll(DeviceArray objArray) {
		
		if(null != objArray) {
			if (null != objArray.lstDeviceNames && !objArray.lstDeviceNames.isEmpty()) {
	
				if (null == this.lstDeviceNames) {
					this.lstDeviceNames = new ArrayList<String>();
				}
	
				// v1.9
				this.devices = ArrayUtils.clone(objArray.getDevices());
				
				// v1.8
				this.lstDeviceNames.addAll(objArray.getDeviceNames());
				
			} else if(null != objArray.getSolutions()) {
				Domain[][] arraySolutions = objArray.getSolutions();
				if(null == this.solutions) {
					this.solutions = arraySolutions.clone();
					int idx = 0;
					for(Domain[] d : this.solutions) {
						if(null == d) {
							this.solutions = ArrayUtils.remove(this.solutions, idx);
						} else {
							idx++;
						}
					}
				} else {
					for(Domain[] d : arraySolutions) {
						if(null != d) {
							this.solutions = ArrayUtils.add(this.solutions, ArrayUtils.clone(d));
						}
					}
				}
			}
		}
	}
	
	public NamedElement get(int idx) 
			throws EugeneException {

//		System.out.println("[DeviceArray.get] -> "+idx);
		// v1.9
		if(null != this.solutions) {
			
			/** here, we create the device on-the-fly **/

			Device device = null;
			if(null != this.device) {
				device = new Device(this.device.getName()+"_"+(idx+1));
				device.setDirections(this.device.getDirections());
			} else {
				device = new Device(this.getName()+"_"+(idx+1));
			}
			
			Domain[] domain = this.solutions[idx];
			for(Domain d : domain) {
				ValueEnumeration ve = d.valueEnumeration();
				/* here, we need to create the device */
				while(ve.hasMoreElements()) {
					Component c = SymbolTables.getComponent((long)ve.nextElement());
					device.add(c);
				}				
			}
			
			return device;
			
			
//			ValueEnumeration ve = this.solutions[idx].valueEnumeration();
//			
//			while(ve.hasMoreElements()) {
//				Node node = this.graphDb.getNodeById((long)ve.nextElement());
//				Relationship rel = solution_node.createRelationshipTo(node, EugeneRelation.CONSISTS_OF);
//				rel.setProperty("position", j);
//
//				System.out.print(node.getProperty("name"));
//			}
			
		} else if(null != this.devices) {
			if(idx >= 0 && idx < this.devices.length) {		
				return SymbolTables.getDevice(this.devices[idx]);
			}

		// v1.8
		} else if(null != this.lstDeviceNames) {		
			if (idx >= 0 && idx < lstDeviceNames.size()) {
				return SymbolTables.get(this.lstDeviceNames.get(idx));
			}
		}
		
		return null;
	}

	public NamedElement get(String sDeviceName) 
			throws EugeneException {
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

		// v1.9
		if(null != this.solutions) {
			
			int counter = 0;
			boolean notNull = true;
			for(int i=0; i<this.solutions.length && notNull; i++) {
				if(this.solutions[i] != null) {
					counter ++;
				} else {
					notNull = false;
				}
			}
			return counter;
			//return this.solutions.length;
			
		} else if(null != this.devices && 0 != this.devices.length) {
			return this.devices.length;
		}
			
		// v1.8
		else if (this.lstDeviceNames != null && !this.lstDeviceNames.isEmpty()) {
			return this.lstDeviceNames.size();
		}
		return 0;
	}

	@Override
	public String toString() {
		String NEWLINE = System.getProperty("line.separator");
		
		StringBuilder sb = new StringBuilder();
		sb.append("Device[] ").append(this.getName()).append(" [");
		if(null != this.solutions) {
				
			char[] directions = {};
			if(null != this.device) {
				directions = this.device.getDirections();
			}

			int k=0;
			for(int i=0; i<this.size(); i++) {
//				System.out.println(i+": "+this.solutions[i]);
				Domain[] dArray = this.solutions[i];
				if(null != dArray) {
					k=0;
					for(Domain d : dArray) {
						ValueEnumeration ve = d.valueEnumeration();
						while(ve.hasMoreElements()) {
							try {
								Component c = SymbolTables.getComponent((long)ve.nextElement());

								if(k<directions.length && directions[k++] == '-') {
									sb.append("-");
								}
								
								sb.append(c.getName()).append(", ");
							} catch(Exception e) {
								e.printStackTrace();
							}
						}
					}
					sb.append(NEWLINE);
				} else {
					break;
				}
			}
		} else if (null != this.lstDeviceNames && !lstDeviceNames.isEmpty()) {
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
			throws EugeneException {
		if (objElement == null) {
			throw new EugeneException(
					"I cannot assign an undefined value to an array of devices!");
		} else if (!(objElement instanceof DeviceArray)) {
			throw new EugeneException(""
					+ "Incompatible types! I cannot assign the " + objElement
					+ " element to an array of devices!");
		}
		
		this.devices = ArrayUtils.clone(((DeviceArray)objElement).getDevices());
//		this.lstDeviceNames = new ArrayList<String>(
//				((DeviceArray) objElement).getDeviceNames());
	}

	@Override
	public void set(int idx, NamedElement objElement)
			throws EugeneException {
		if (objElement instanceof Device) {
			if (idx >= 0 && idx < this.lstDeviceNames.size()) {
				this.lstDeviceNames.set(idx, ((Device) objElement).getName());
			} else {
				throw new EugeneException("Array index ("
						+ idx + ") is out of bounds!");
			}
		} else {
			throw new EugeneException(objElement.getName()
					+ " is not a Device!");
		}

	}

	@Override
	public void set(String sDeviceName, NamedElement objElement)
			throws EugeneException {
		if (null != this.lstDeviceNames && !this.contains(sDeviceName)) {
			if (objElement instanceof Device) {
				this.lstDeviceNames.set(
						this.lstDeviceNames.indexOf(sDeviceName),
						objElement.getName());
			} else {
				throw new EugeneException("I cannot place a "
						+ objElement.getClass() + " element into the "
						+ this.getName() + " Device list!");
			}
		} else {
			throw new EugeneException("The " + this.getName()
					+ " Device list does not contain a Device named "
					+ sDeviceName + "!");
		}
	}

	public void add(NamedElement objElement)
			throws EugeneException {

		if (!(objElement instanceof Device)) {
			throw new EugeneException("I cannot add the "
					+ objElement.getName() + " to the " + this.getName()
					+ " device array!");
		}

//		if (this.contains((Device) objElement)) {
//			throw new EugeneException("The " + this.getName()
//					+ " device array contains the " + objElement.getName()
//					+ " device already!");
//		}

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

	/***
	@Override
	public void remove(int idx) 
			throws EugeneException {
		if(null != this.instances) {
			if(idx>=0 && idx<this.instances.length) {
				this.instances = ArrayUtils.remove(this.instances, idx);
			} else {
				throw new EugeneException(idx+" is an invalid index!");
			}
		}
		if(null != this.lstDeviceNames) {
			if(idx>=0 && idx<this.lstDeviceNames.size()) {
				this.lstDeviceNames.remove(idx);
			} else {
				throw new EugeneException(idx+" is an invalid index!");
			}
		}
	}
	***/

}
