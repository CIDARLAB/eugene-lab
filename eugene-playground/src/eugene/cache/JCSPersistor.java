package eugene.cache;

import java.util.Iterator;
import java.util.Set;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;

import com.rits.cloning.Cloner;

import eugene.dom.NamedElement;
import eugene.dom.StackElement;
import eugene.dom.components.Component;
import eugene.exception.EugeneException;

public class JCSPersistor {
	private JCS jcsCache;	
	private Cloner cloner;

	public JCSPersistor() {
		
		/*** JCS CACHE ***/
		try {
			jcsCache = JCS.getInstance("eugene");
		} catch (Exception e) {
			e.printStackTrace();
		}

		cloner = new Cloner();
	}
	
	public void put(String sName, NamedElement objElement)
			throws EugeneException {

		if (null != sName && null != objElement) {
			try {
				if(objElement instanceof Component) {
					jcsCache.putInGroup(sName, "MAIN",
						cloner.deepClone(objElement));
				} else {
					jcsCache.putInGroup(sName, getGroupName(),
						cloner.deepClone(objElement));
				}
			} catch(Exception e) {
				throw new EugeneException(e.toString());
			}
		}
	}

	public NamedElement get(String sName) {
		if (null != sName && null != jcsCache) {
			String sGroupName = getGroupName();
			
			NamedElement obj = (NamedElement) jcsCache.getFromGroup(sName, sGroupName);

			// TODO: go down the stack and check for the element
			if(null == obj && !"MAIN".equals(sGroupName)) {
				obj = (NamedElement) jcsCache.getFromGroup(sName, "MAIN");
			}
			return obj;
		}
		return (NamedElement) null;
	}

	private static String getGroupName() {
		String sGroupName = "MAIN";
		StackElement objStackElement = SymbolTables.peek();
		if (null != objStackElement) {
			sGroupName = String.valueOf(objStackElement.hashCode());
		}
		
		return sGroupName;
	}


	/** CONTAINS **/
	public boolean contains(String sName) {
		
        if(null == jcsCache) {
        	return false;
        }

        if(null != sName) {
        	
        	/**
        	if(null != SymbolTables.peek()) {        		
        		StackElement se = SymbolTables.pop();
        		System.out.println(se);        		
        		SymbolTables.push(se);        		
        	}
        	**/
        	
        	return (null != jcsCache.getFromGroup(sName, getGroupName()));
        }
        return false;
	}

	/** REMOVE **/
	public void remove(String sName) {
		if(null != sName) {
			jcsCache.remove(sName, getGroupName());
		}
	}

	/** CLEANUP **/
	public void clear() {
		if (null != jcsCache) {
			try {
				jcsCache.clear();
			} catch (CacheException e) {
			}
			jcsCache = null;

			//System.out.println("XXXXX");
			//EugeneUtil.deleteDirectory(new File("./eugene.cache"));
			//System.out.println("XXXXX");
		}
	}

	public void clear(String sGroup) {
		if (null != sGroup && null != jcsCache) {
			Set<String> setKeys = this.jcsCache.getGroupKeys(sGroup);
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
