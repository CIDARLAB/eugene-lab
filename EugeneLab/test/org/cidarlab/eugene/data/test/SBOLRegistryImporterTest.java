package org.cidarlab.eugene.data.test;

import java.util.List;

import org.cidarlab.eugene.cache.SymbolTables;
import org.cidarlab.eugene.data.registry.SBOLRegistryImporter;
import org.cidarlab.eugene.dom.components.Component;
import org.cidarlab.eugene.dom.components.Part;

public class SBOLRegistryImporterTest {

	public SBOLRegistryImporterTest() {
		SymbolTables.init();
	}
	
	public boolean testPart() {
		SBOLRegistryImporter importer = new SBOLRegistryImporter();
		try {
//			List<Component> lst = importer.importComponent("K1038001");
			List<Component> lst = importer.importComponent("J61100");
			
			// iterate over the list
			for(Component component : lst) {
				if(null != component && component instanceof Part) {
					return true;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean testDevice() {
		SBOLRegistryImporter importer = new SBOLRegistryImporter();
		try {
			List<Component> component = importer.importComponent("K1129024");
			
			if(null != component && component instanceof Part) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;				
	}
	
	public static void main(String[] args) {
		SBOLRegistryImporterTest sbol = new SBOLRegistryImporterTest();
		
		/* PART */
		if(sbol.testPart()) {
			System.out.println("testPart passed!");
		} else {
			System.err.println("testPart failed!");
		}
		
		/* DEVICE */
//		if(sbol.testDevice()) {
//			System.out.println("testDevice passed!");
//		} else {
//			System.err.println("testDevice failed!");
//		}

//		sbol.testInvalid();
	}

}
