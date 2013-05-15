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

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 import net.sf.ehcache.Cache;
 import net.sf.ehcache.CacheManager;
 import net.sf.ehcache.config.CacheConfiguration;
 import net.sf.ehcache.store.MemoryStoreEvictionPolicy;
 **/

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;

import com.rits.cloning.Cloner;

import eugene.dom.NamedElement;
import eugene.dom.StackElement;
import eugene.dom.arrays.DeviceArray;
import eugene.dom.components.Device;
import eugene.dom.components.Part;
import eugene.dom.components.types.PartType;
import eugene.dom.rules.Rule;
import eugene.parser.SymbolTables;
import eugene.util.EugeneUtil;

public class DesignSpace {
	private static JCS jcsCache;
	private static Cloner cloner;

	private static void initCache() {
		/*** JCS CACHE ***/
		try {
			jcsCache = JCS.getInstance("eugene");
		} catch (Exception e) {
		}

		cloner = new Cloner();
	}

	public static void put(String sName, NamedElement objElement)
			throws CacheException {
		if (null != sName && null != objElement) {
			if (null == jcsCache) {
				initCache();
			}
			jcsCache.putInGroup(sName, getGroupName(),
					cloner.deepClone(objElement));
		}
	}

	public static NamedElement get(String sName) {
		if (null != sName && null != jcsCache) {
			return (NamedElement) jcsCache.getFromGroup(sName, getGroupName());
		}
		return (NamedElement) null;
	}

	private static String getGroupName() {
		String sGroupName = "MAIN";

		StackElement objStackElement = SymbolTables.peek();
		if (null != objStackElement) {
			sGroupName = objStackElement.toString();
		}

		return sGroupName;
	}

	/** GET functions **/
	public static Collection<Rule> getRules() {
		Collection<Rule> colRules = new ArrayList<Rule>();

		String sGroupName = getGroupName();
		if (null != sGroupName && null != jcsCache) {
			Set<String> setKeys = jcsCache.getGroupKeys(sGroupName);
			if (null != setKeys && !setKeys.isEmpty()) {
				Iterator<String> it = setKeys.iterator();
				while (it.hasNext()) {
					String s = it.next();
					NamedElement objElement = (NamedElement) jcsCache
							.getFromGroup(s, sGroupName);
					if (objElement instanceof Rule) {
						colRules.add((Rule) objElement);
					}
				}
			}
		}

		return colRules;
	}

	public static java.util.Collection<Device> getDevices() {
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
	}

	public static Collection<PartType> getPartTypes() {
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
	}

	public static java.util.Collection<Part> getParts() {
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
	}

	public static java.util.Collection<Part> getParts(PartType objPartType) {
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
						Part objPart = (Part) objElement;
						if (objPart.getPartType().equals(objPartType)) {
							colParts.add((Part) objElement);
						}
					}
				}
			}
		}
		return colParts;
	}

	public static java.util.Collection<DeviceArray> getDeviceArrays() {
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
	}

	public static java.util.Collection<?> getAll(Class c) {
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
	}

	/** CONTAINS **/
	public static boolean contains(String sName) {
		if (null != DesignSpace.get(sName)) {
			return true;
		}
		return false;
	}

	/** REMOVE **/
	public static void remove(String sName) {
		jcsCache.remove(sName, getGroupName());
	}

	/** CLEANUP **/
	public static void clear() {
		if (null != jcsCache) {
			try {
				jcsCache.clear();
			} catch (CacheException e) {
			}
			jcsCache = null;

			EugeneUtil.deleteDirectory(new File("./eugene.cache"));
		}
	}

	public static void clear(String sGroup) {
		if (null != sGroup && null != jcsCache) {
			Set<String> setKeys = jcsCache.getGroupKeys(sGroup);
			if (null != setKeys && !setKeys.isEmpty()) {
				Iterator<String> it = setKeys.iterator();
				while (it.hasNext()) {
					String s = it.next();
					jcsCache.remove(s, sGroup);
				}
			}
		}
	}
}
