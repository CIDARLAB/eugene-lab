package eugene.dom.arrays;

import eugene.dom.components.Device;

public class PermutedDeviceArray 
		extends DeviceArray {

	private static final long serialVersionUID = -7717820454893218128L;
	
	private String  sDeviceName;
	private long[][] constraint_combinations;
	
	public PermutedDeviceArray(
			String  sDeviceName, long[][] constraint_combinations) {
		super(sDeviceName+"_PERMUTE");
		this.constraint_combinations = constraint_combinations;
		this.sDeviceName = sDeviceName;
	}
	
	public String getDeviceName() {
		return this.sDeviceName;
	}

	public long[][] getConstraintCombinations() {
		return this.constraint_combinations;
	}
	
	public boolean hasNext() {
		return false;
	}
	
	public Device next() {
		/* here should also store the device into the db */
		//DesignSpace.neo4j.createPermutation(nDeviceId, sDeviceName+"_"+nCounter, v);

		/** TODO!! **/
		return null;
	}
	
	
	/*** MAYBE I'M GONNA NEED THIS ??
	/* the generated combinations are just telling us where the elements (which are bound to rules)
	 * must be placed...
	 * therefore, we need to fill all empty spots (i.e. all array elements with 0) with remaining elements...
	 *
	System.out.println("This are all possible combinations...");
	System.out.println(ArrayUtils.toString(combinations));
	
	for(int i=0; i<combinations.length; i++) {

		long[] poss_i = ArrayUtils.clone(combinations[i]);
		long[] remain = ArrayUtils.clone(l);
		
		System.out.println("poss_i "+Arrays.toString(poss_i));
		System.out.println("remain "+Arrays.toString(remain));

		for(int k=0, j=0; k<poss_i.length; k++) {
			if(poss_i[k] == 0) {
				poss_i[k] = remain[j++];						
			} else {

				int idx = ArrayUtils.indexOf(remain, poss_i[k]);
				if(idx != (-1)) {
					// delete the j-th element in l_clone
					remain = ArrayUtils.remove(remain, idx);
				}
			}
		}
		
		System.out.println("here are the remaining elements "+Arrays.toString(remain));
		
	}
	***/ 
}
