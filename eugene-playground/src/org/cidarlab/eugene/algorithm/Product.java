package org.cidarlab.eugene.algorithm;

import eugene.cache.SymbolTables;
import eugene.dom.arrays.DeviceArray;
import eugene.exception.EugeneException;

public class Product {

	public static DeviceArray product(String sDeviceName, long N) 
			throws EugeneException {
		
		return SymbolTables.product(sDeviceName, N);
		
	}
	
}
