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

package eugene.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.ArrayUtils;
import org.cidarlab.eugene.fact.Fact;
import org.cidarlab.eugene.fact.relation.Relation;
import org.cidarlab.eugene.rules.tree.predicate.BinaryPredicate;
import org.cidarlab.eugene.rules.tree.predicate.Predicate;
import org.cidarlab.eugene.rules.tree.predicate.UnaryPredicate;

import eugene.dom.NamedElement;
import eugene.dom.StackElement;
import eugene.dom.arrays.DeviceArray;
import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.dom.components.Part;
import eugene.dom.components.types.PartType;
import eugene.dom.relation.Interaction;
import eugene.dom.rules.Rule;
import eugene.exception.EugeneException;

public class DesignSpace {

	private JCSPersistor jcs;
	private Neo4jPersistor neo4j;
	//private DroolsPersistor drools;

	/*
	 * in these 2 hashmaps we keep track about what
	 * devices and part types where specified... 
	 * 
	 * i.e. these 2 hashmaps link the name of a device/part type
	 * onto the ID as stored in the database
	 */
	private HashMap<String, Long> hmIds;
	private HashMap<String, Long> hmPartTypeIds;
	
	private HashMap<String, PartType> hmPartTypes;
	
	/* in this hashmap, we keep track about what rules 
	 * where linked to what devices...
	 * key   ... device-id
	 * value ... rule-object
	 */
	private HashMap<String, Rule> hmRules;
	
	public DesignSpace() {

		/** JCS Persistor **/
		this.jcs = new JCSPersistor();
		
		/** Neo4j Persistor **/
		this.neo4j = null;
		//this.neo4j = new Neo4jPersistor();
		
		/** Drools **/
		// TODO:
		//this.drools = new DroolsPersistor();
		
		/** HashMaps **/
		this.hmIds = new HashMap<String, Long>();
		this.hmPartTypeIds = new HashMap<String, Long>();
		this.hmRules = new HashMap<String, Rule>();
	}
	
	private void startNeo4j() {
//		System.out.println("[DesignSpace.startNeo4j]");
		this.neo4j = new Neo4jPersistor(UUID.randomUUID().toString());
		this.neo4j.startTransaction();
	}
	
	/**
	public void queryEverything(int N) {
		if(null != this.neo4j) {
			this.neo4j.queryEverything(N);
		}
	}
	***/
	
	public void put(String sName, NamedElement objElement)
			throws Exception {

		if(this.contains(sName)) {
			return;
		}
		
		if (null != sName && null != objElement) {

			/** we store all parts in neo4j **/
			if(objElement instanceof Part) {
				
				this.jcs.put(sName, objElement);
				
				if(null == this.neo4j) {
					this.startNeo4j();
				}								
			
				long nId = neo4j.put(sName, (Component)objElement);
				//System.out.println("[DesignSpace.put] Device "+objElement+" -> "+nId);
				if((-1) != nId) {
					this.hmIds.put(sName, new Long(nId));
					//System.out.println(sName+" -> "+nId);
				}
				
			} else if(objElement instanceof Device ||
					objElement instanceof PartType) { 
			
				/* ONLY global devices and part types will be put into 
				 * the neo4j database
				 */
				if(null == SymbolTables.peek()) {
					if(null == this.neo4j) {
						this.startNeo4j();
					}								
				
					long nId = neo4j.put(sName, (Component)objElement);
					
					//System.out.println("[DesignSpace.put] Device "+objElement+" -> "+nId);
					
					if((-1) != nId) {
						if(objElement instanceof Device) {
							this.hmIds.put(sName, new Long(nId));
						} else if(objElement instanceof PartType) {
							this.hmPartTypeIds.put(sName, Long.valueOf(nId));
						}
						//System.out.println(sName+" -> "+nId);
					}
				}
				this.jcs.put(sName, objElement);
				
			} else if (objElement instanceof Rule) {
				
				/* here we need to link the rule's device with the device 
				 * in the hmIds hashmap
				 */
				
				if(!hmRules.containsKey(sName)) {
//					System.out.println("[DesignSpace.put] -> "+((Rule)objElement).toString());
					this.hmRules.put(sName, (Rule)objElement);
				}
				
			} else {
				this.jcs.put(sName, objElement);
			}
		}
	}	
	
	public void put(Interaction interaction) 
			throws EugeneException {
		if(null != this.neo4j) {
			this.neo4j.put(interaction);
		}
	}
	
	public DeviceArray product(String sDeviceName, long N) 
			throws EugeneException {
		
		// first, get the device and it's components
		NamedElement element = this.jcs.get(sDeviceName);
		if(null == element || !(element instanceof Device)) {
			throw new EugeneException("I don't know any Device named "+sDeviceName);
		} 		
		Device device = (Device)element;
		
		// second, check what rules constrain the device
		List<Rule> lstRules = this.getDeviceRules(device);
		
		// third, perform product()
		return this.neo4j.product(device,  lstRules, (int)N);
		
//		if(this.hmIds.containsKey(sDeviceName) && null != this.neo4j) {
//			long deviceId = this.hmIds.get(sDeviceName).longValue();
//			
//			/* that's the new product */
//			return this.neo4j.product(deviceId,  this.getDeviceRules(deviceId), (int)N);
//			
//			/* old product */
//			//return this.neo4j.createProduct(deviceId, N, this.getDeviceRules(deviceId));
//		} else if(null != device) {
//			return this.neo4j.product(, lstRules, N)
//		}
//		return null;
	}
	
	public void permute(String sDeviceName) {
		if(this.hmIds.containsKey(sDeviceName) && null != this.neo4j) {
			this.neo4j.permute(this.hmIds.get(sDeviceName).longValue());
		}
	}
	
	public long[][] queryPairs(String relation, Component c1, Component c2) 
			throws EugeneException {
		/** let's do it just for part types **/
		if(this.hmPartTypeIds.containsKey(c1.getName())) {			
			if(hmPartTypeIds.containsKey(c2.getName())) {
				return this.neo4j.queryPairs(relation, c1, c2);
			}
		}
		return null;
	}
	
	public Device getDevice(long deviceId) {
		return this.neo4j.createDevice(deviceId);
	}
	
	public long[] getInstancesOf(String sDeviceName) {
		if(this.hmIds.containsKey(sDeviceName) && null != this.neo4j) {
			return this.neo4j.getInstancesOf(this.hmIds.get(sDeviceName));
		}
		return null;
	}
	
	public List<Rule> getDeviceRules(String sDeviceName) 
			throws EugeneException {
		
		//System.out.println("[DesignSpace.getDeviceRules] -> "+sDeviceName);
		
		/* get the id of the given device */
		if(this.hmIds.containsKey(sDeviceName)) {
			return this.getDeviceRules(
					this.hmIds.get(sDeviceName).longValue());
		}
		
		throw new EugeneException(sDeviceName + " is not defined or it is not a device!");
	}
	
	/*
	 * the getDeviceIds() method returns an array of long values
	 * representing the IDs of all the stored devices
	 */
	public long[] getDeviceIds() {
		if(null != this.neo4j) {
			return this.neo4j.getDeviceIds();
		}
		return null;
	}
	
	public PartType getPartType(String name) {
		NamedElement element = this.jcs.get(name);
		if(null!=element && element instanceof PartType) {
			return (PartType)element;
		}
		return null;
	}
	
	public Component getComponent(long id) 
			throws EugeneException {
		if(id>0) {
			if(this.hmIds.containsValue(id) || this.hmPartTypeIds.containsValue(id)) {
				return this.neo4j.queryById(id);
			} else {
				throw new EugeneException("I don't anything about a component with ID "+id+"!");
			}
		} else {
			throw new EugeneException(id+" is an invalid ID!");
		}
	}

	
	/**
	public void executeCypherQuery(String s) 
		throws EugeneException {
		if(null == neo4j) {
			this.startNeo4j();
		}
		this.neo4j.executeCypherQuery(s);
	}
	**/
	
	public List<Rule> getDeviceRules(long nDeviceId) {
		
		long[] device_elements = this.getDeviceComponentIds(nDeviceId);
		
		List<Rule> lstRules = new ArrayList<Rule>();
		// iterate over all rules
		if(null != this.hmRules) {			
			for(Rule rule : this.hmRules.values()) {				
				if(rule.getDeviceId() == (-1) || rule.getDeviceId() == nDeviceId) {
					lstRules.add(rule);
				} else if(rule.getDevice() != null) {
					long deviceId = this.neo4j.queryNodeIdByName(rule.getDevice().getName());
					if(deviceId != (-1)) {
						lstRules.add(rule);
					}
				} else {
					/* if the rule does not contain a device, then check if the rule contains operands 
					 * specified on the device's components  
					 */
					Predicate predicate = rule.getPredicate();
					if(predicate instanceof BinaryPredicate) {
						// check if A of B are in the device's elements
						if((-1) != ArrayUtils.indexOf(device_elements, ((BinaryPredicate)predicate).getA()) || 
								(-1) != ArrayUtils.indexOf(device_elements, ((BinaryPredicate)predicate).getB())) {
							lstRules.add(rule);
						}
					} else if(predicate instanceof UnaryPredicate) {
						// check if B is in the device's elements
						if((-1) != ArrayUtils.indexOf(device_elements, ((UnaryPredicate)predicate).getB())) {
							lstRules.add(rule);
						}
					}
				}
			}			
		}
		return lstRules;
	}
		
	public List<Rule> getDeviceRules(Device device) {
		
		List<Rule> lstRules = new ArrayList<Rule>();
		// iterate over all rules
		if(null != this.hmRules) {			
			for(Rule rule : this.hmRules.values()) {				
				if(rule.getDevice() != null) {
					if(rule.getDevice().getName().equals(device.getName())) {
						lstRules.add(rule);
					}
				} else {
					//lstRules.add(rule);
					/* here we need to check if the rule can be applied on the device */
//					List<Component> components = device.getComponents();
//					
//					Predicate predicate = rule.getPredicate();
//					if(predicate instanceof BinaryPredicate) {
//						((BinaryPredicate)predicate).getA()
//					} else if(predicate instanceof UnaryPredicate) {
//						
//					}
//					System.out.println(rule);
				}
			}			
		}
		return lstRules;
	}

	public long getId(String sName) {
		if(this.hmIds.containsKey(sName)) {
			return this.hmIds.get(sName).longValue();
		} else if (this.hmPartTypeIds.containsKey(sName)) {
			return this.hmPartTypeIds.get(sName).longValue();
		} else {
			return this.neo4j.queryNodeIdByName(sName);
		}
	}
	
	/* TODO: 
	 * this needs to be replaced with returning a NamedElement
	 * Q: how can we serialize Eugene's domain model into neo4j?
	 *    any JSON serializers?
	 */
	public String getNameById(long nId) {
		if(this.hmIds.containsValue(nId)) {
			
			for(String key : this.hmIds.keySet()) {
				Long value = this.hmIds.get(key);
				if(value.longValue() == nId) {
					return key;
				}
			}
		} else if (this.hmPartTypeIds.containsValue(nId)) {
			
			for(String key : this.hmPartTypeIds.keySet()) {
				Long value = this.hmPartTypeIds.get(key);
				if(value.longValue() == nId) {
					return key;
				}
			}
			
		}
		return null;
	}
	
	public void put(Fact fact) 
			throws EugeneException {
		this.neo4j.put(fact);
	}

	public long[] getDeviceComponentIds(String sName) 
			throws EugeneException {
		
		Long l = this.hmIds.get(sName);
		if(l != null && null != this.neo4j) {
			return neo4j.getDeviceConsistsOf(l.longValue());
		} 
		
		
		NamedElement element = this.jcs.get(sName);
		if(element instanceof Device) {
			Device device = (Device)element;
			try {
				List<Component> lstComponents = device.getComponentsAtDepth(device.getMaxDepth());
				if(null != lstComponents) {
					long[] ids = new long[lstComponents.size()];
					int i=0;
					for(Component component : lstComponents) {
						ids[i++] = this.neo4j.queryNodeIdByName(component.getName()); 
					}
					return ids;
				}
			} catch(EugeneException e) {
				throw new EugeneException("I don't know what weng wrong...");
			}
		}
		return null;
	}

	public long[] getAllDeviceComponentIds(long nId) {
		if(this.contains(nId) && null != this.neo4j) {			
			// TODO: get the IDs from Neo4j
			return neo4j.getOrderedDeviceComponents(nId);
		}		
		return null;
	}

	public long[] getDeviceComponentIds(long nId) {
		if(this.contains(nId) && null != this.neo4j) {			
			// TODO: get the IDs from Neo4j
			return neo4j.getDeviceConsistsOf(nId);
		}		
		return null;
	}

	public NamedElement get(String sName) {
		
		NamedElement objElement = this.jcs.get(sName);
		
		if(null == objElement) {
			// first, check if the sName is in the id's hashmap
			if(this.hmIds.containsKey(sName) && null != this.neo4j) {
				// then, get if from Neo4j			
				objElement = neo4j.queryById(Long.valueOf(this.hmIds.get(sName)).longValue());
				
			} else if(this.hmPartTypeIds.containsKey(sName) && null != this.neo4j) {
				// then, get if from Neo4j			
				objElement = neo4j.queryById(Long.valueOf(this.hmPartTypeIds.get(sName)).longValue());
				
			// if we're talking about a rule, 	
			} else if (this.hmRules.containsKey(sName)) {

				// then get it from the rules hashmap
				return this.hmRules.get(sName);
			}
		}
		
		return objElement;
	}
	
	public List<Interaction> getInteractions(Component component) {
		return this.neo4j.queryInteractions(component.getName());
	}
	
	public boolean contains(String sName) {
		/** here we need to add some scoping **/
		StackElement el = SymbolTables.peek();
		if(null != el) {
			return this.jcs.contains(sName);
		} else {		
			if(!(this.hmIds.containsKey(sName) || this.hmPartTypeIds.containsKey(sName))) {
				return this.jcs.contains(sName);
			}
		}
		return true;
	}
	
	public boolean contains(long nId) {
		//System.out.println("[DesignSpace.contains] -> "+nId+
		//		" -> "+this.hmIds.containsValue(Long.valueOf(nId))+" || "+ this.hmPartTypeIds.containsValue(Long.valueOf(nId)));
		return this.hmIds.containsValue(Long.valueOf(nId)) || this.hmPartTypeIds.containsValue(Long.valueOf(nId));
	}
	
	public void remove(String sName) {
//		System.out.println("[DesignSpace.remove] -> "+sName);
		this.jcs.remove(sName);
	}
	
	/** GET functions **/
	public Collection<Rule> getRules() {
		return hmRules.values();
	}

	
	public Collection<Device> getDevices() {
		return new HashSet<Device>();
		
		/***
		Collection<Device> colDevices = new ArrayList<Device>();

		String sGroupName = getGroupName();
		if (null != sGroupName && null != jcsCache) {
			Set<String> setKeys = jcsCache.getGroupKeys(sGroupName);
			if (null != setKeys && !setKeys.isEmpty()) {
				Iterator<String> it = setKeys.iterator();
				while (it.hasNext()) {
					String s = it.next();
					NamedElement objElement = (NamedElement) jcsCache
							.getFromGroup(s, sGroupName);
					if (objElement instanceof Device) {
						colDevices.add((Device) objElement);
					}
				}
			}
		}
		return colDevices;
		**/
	}

	public Collection<PartType> getPartTypes() {
		return new HashSet<PartType>();
		
		/***
		Collection<PartType> colPartTypes = new ArrayList<PartType>();

		String sGroupName = getGroupName();
		if (null != sGroupName && null != jcsCache) {
			Set<String> setKeys = jcsCache.getGroupKeys(sGroupName);
			if (null != setKeys && !setKeys.isEmpty()) {
				Iterator<String> it = setKeys.iterator();
				while (it.hasNext()) {
					String s = it.next();
					NamedElement objElement = (NamedElement) jcsCache
							.getFromGroup(s, sGroupName);
					if (objElement instanceof PartType) {
						colPartTypes.add((PartType) objElement);
					}
				}
			}
		}
		return colPartTypes;
		**/
	}

	public Collection<Part> getParts() {
		return new HashSet<Part>();
		
		/***
		Collection<Part> colParts = new ArrayList<Part>();

		String sGroupName = getGroupName();
		if (null != sGroupName && null != jcsCache) {
			Set<String> setKeys = jcsCache.getGroupKeys(sGroupName);
			if (null != setKeys && !setKeys.isEmpty()) {
				Iterator<String> it = setKeys.iterator();
				while (it.hasNext()) {
					String s = it.next();
					NamedElement objElement = (NamedElement) jcsCache
							.getFromGroup(s, sGroupName);
					if (objElement instanceof Part) {
						colParts.add((Part) objElement);
					}
				}
			}
		}
		return colParts;
		**/
	}

	public Collection<Part> getParts(PartType objPartType) {
		return this.jcs.getParts(objPartType);
	}

	public Collection<DeviceArray> getDeviceArrays() {
		return new HashSet<DeviceArray>();
		
		/***
		Collection<DeviceArray> colDeviceArrays = new ArrayList<DeviceArray>();

		String sGroupName = getGroupName();
		if (null != sGroupName && null != jcsCache) {
			Set<String> setKeys = jcsCache.getGroupKeys(sGroupName);
			if (null != setKeys && !setKeys.isEmpty()) {
				Iterator<String> it = setKeys.iterator();
				while (it.hasNext()) {
					String s = it.next();
					NamedElement objElement = (NamedElement) jcsCache
							.getFromGroup(s, sGroupName);
					if (objElement instanceof DeviceArray) {
						colDeviceArrays.add((DeviceArray) objElement);
					}
				}
			}
		}
		return colDeviceArrays;
		**/
	}

	public Collection<?> getAll(Class c) {
		return new HashSet();
		
		/***		
		Collection colDeviceArrays = new ArrayList();

		String sGroupName = getGroupName();
		if (null != sGroupName && null != jcsCache) {
			Set<String> setKeys = jcsCache.getGroupKeys(sGroupName);
			if (null != setKeys && !setKeys.isEmpty()) {
				Iterator<String> it = setKeys.iterator();
				while (it.hasNext()) {
					String s = it.next();
					Object obj = jcsCache.getFromGroup(s, sGroupName);

					if (obj.getClass().toString().equals(c.toString())) {
						colDeviceArrays.add(obj);
					}
				}
			}
		}
		return colDeviceArrays;
		***/
	}
	
	/** CLEANUP METHODS **/
	public void clear() {
		
		/* print the id table */
		//System.out.println("nr of ids: "+this.hmIds.size());
		//System.out.println("nr of part-types: "+this.hmPartTypeIds.size());
		/**
		for(String s : this.hmIds.keySet()) {
			System.out.println(s+" -> "+this.hmIds.get(s));
		}
		**/
		this.jcs.clear();
		
		if(null != neo4j) {
			neo4j.finalize();
		}
	}

	public void clear(String sGroup) {
		this.jcs.clear(sGroup);
	}
}
