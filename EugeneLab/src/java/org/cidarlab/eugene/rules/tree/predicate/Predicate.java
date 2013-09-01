package org.cidarlab.eugene.rules.tree.predicate;

import java.util.List;

import JaCoP.constraints.Constraint;
import JaCoP.core.IntVar;
import JaCoP.core.Store;
import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.exception.EugeneException;

public interface Predicate {
	public String getOperator();

	public Constraint toJaCoP(Store store, List<Component> components, IntVar[] variables);


	/* 
	 * the long[] array contains all IDs of 
	 * one Device's components
	 */
	public boolean evaluate(long[] l) 
			throws EugeneException;
	
	/* 
	 * the long value refers to the ID of 
	 * the Device in the database
	 */
	public boolean evaluate(long deviceId) 
			throws EugeneException;

	/* 
	 * the String value refers to the name of 
	 * the Device 
	 */
	public boolean evaluate(String sDeviceName) 
			throws EugeneException;
	
	
	public boolean evaluate(Device device)
			throws EugeneException;

}
