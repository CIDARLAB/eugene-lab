package eugene.test;

import java.util.ArrayList;
import java.util.List;

import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.dom.components.Part;
import eugene.dom.components.types.PartType;

public class MoCloFormatExample {

	private static final int NR_OF_DEVICES = 5;
	
	public static void main(String[] args) 
			throws Exception {		
		
		/* first, let's define the usual part types */
		PartType promoter = new PartType("Promoter");
		PartType rbs = new PartType("RBS");
		PartType gene = new PartType("Gene");
		PartType terminator = new PartType("Terminator");
		
		/* now, we create some devices that consist of 
		 * parts of the above defined part types 
		 */
		List<Device> devices = new ArrayList<Device>(NR_OF_DEVICES);
		for(int i=1; i<=NR_OF_DEVICES; i++) {

			Device device = new Device("device_"+i);
			device.getComponents().add(new Part(promoter, "promoter_"+i));
			device.getComponents().add(new Part(rbs, "rbs_"+i));
			device.getComponents().add(new Part(gene, "gene_"+i));
			device.getComponents().add(new Part(terminator, "terminator_"+i));
			
			devices.add(device);
		}

//		// now, let's define a list of the available MoClo Fusion Sites
//		List<FusionSite> fusionSites = new ArrayList<FusionSite>();
//		
//		// TODO: define a FusionSite class in the eugene.format package
//		//       that gets as input:
//		//       - the name of the fusion site (e.g. A)
//		//       - the sequence of the fusion site (e.g. ATCT)
//		fusionSites.add(new FusionSite("A", "ATCG"));
//		// ...
//		
//		// we also need to inform the MoCloFormat class about the available fusion sites
//		// TODO: create a STATIC function in the MoCloFormat class that gets as input 
//		//       a list of fusion site objects (i.e. List<FusionSite>) and stores them 
//		//       into a STATIC member variable (of type List<FusionSite>) of the MoCloFormat class		
//		MoCloFormat.setFusionSites(fusionSites);
//		
//		// next, we assemble every created device using the available fusion sites
//		for(Device device : devices) {
//			
//			// we compose every device according the moclo format...
//			// TODO: create a STATIC method in the MoCloFormat class that gets as input 
//			//       an object of the Device class and returns an object of the Device class
//			//       whose components are composed according the MoClo format...
//			Device mocloDevice = MoCloFormat.build(d);
//			
//			System.out.println(mocloDevice);
//		}
//		
//		System.out.println(mocloDevice);				
	}
}
