package eugene.test;

import java.util.ArrayList;
import java.util.List;

import org.cidarlab.eugene.builder.EugeneBuilder;

import eugene.cache.SymbolTables;
import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.dom.components.Part;
import eugene.dom.components.types.PartType;

public class VoigtExample {

	private static final int NR_OF_PARTTYPES = 20;
	private static final int NR_OF_PARTS = 500;
	private static final int NR_OF_DEVICES = 10;
	private static final int N = 10;
	
	public static void main(String[] args) 
			throws Exception {
		
		SymbolTables.init();
		
		for(int i=1; i<=NR_OF_PARTTYPES; i++) {
			PartType pt = new PartType("PT"+i);
			SymbolTables.put(pt);
			
			for(int j=1; j<=NR_OF_PARTS; j++) {
				Part p = new Part(pt, "PT"+i+"_P"+j);
				SymbolTables.put(p);
			}
		}
		
		for(int i=1; i<=NR_OF_DEVICES; i++) {
			List<Component> lstComponents = new ArrayList<Component>(N);
			char[] directions = new char[N];
			for(int j=1; j<=N; j++) {
				lstComponents.add((Component) SymbolTables.get("PT"+j));
				if(j%2 == 0) {
					directions[j-1] = '+';
				} else {
					directions[j-1] = '-';
				}
			}
			Device d = EugeneBuilder.buildDevice("D"+i, lstComponents, directions);
			//Device d = Device.newInstance("D"+i, lstComponents);
			SymbolTables.put(d);
		}
		
		long nBefore = System.nanoTime();
		SymbolTables.permute("D1");
		double nProcessing = (System.nanoTime() - nBefore) * Math.pow(10, -9);
		
		System.out.println(nProcessing+" sec");
		
		// now, let's create the cartesian product 
//		for(int i=1; i<=NR_OF_DEVICES; i++) {
//			Product.product("D"+i);
//		}
		
		SymbolTables.cleanUp();
	}
}
