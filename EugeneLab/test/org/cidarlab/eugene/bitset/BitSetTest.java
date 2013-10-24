package org.cidarlab.eugene.bitset;

import java.util.Arrays;
import java.util.BitSet;

public class BitSetTest {
	/* 
	 * SIZE_OF_DS specifies the number of parts 
	 * that are in the design space
	 */
	public int SIZE_OF_DS;

	/* 
	 * SIZE_OF_DEVICE specifies the number of elements 
	 * in a possible device
	 */
	public int SIZE_OF_DEVICE;
	
	
	private String[] ds;
	
	public void initDesignSpace() {
		/* the ds array contains the ids of the parts */
		this.ds = new String[SIZE_OF_DS];
		for(int i=0; i<SIZE_OF_DS; i++) {
			ds[i] = new String("part-"+(i+1));
		}
		
		//System.out.println(Arrays.toString(ds));
	}
	
	public BitSet[] initBitSets() {
		
		// we have a set of Parts
		
		
		/* for position in the design, 
		 * we specify a bitset which indicates 
		 * if a certain part can be placed into 
		 * the device's position at index i
		 */
		//long[] designs = new long[SIZE_OF_DEVICE];
		
		/* now, let's say every part can be placed into 
		 * every position of the device
		 * i.e. every bit in every bitset of every device position 
		 *      is set to 1
		 */
		BitSet[] possible_designs = new BitSet[SIZE_OF_DEVICE];
		for(int c=0; c<SIZE_OF_DEVICE; c++) {
			possible_designs[c] = new BitSet(SIZE_OF_DS);
			for(int r=0; r<SIZE_OF_DS; r++) {
				possible_designs[c].set(r);
			}
		}
		return possible_designs;
		
		/*
		 * if possible_designs[i][j] == 1  ... the j-th element can be placed into 
		 *                                     the i-th position of a design
		 * otherwise                       ... we're not allowed to place part j 
		 *                                     at position j
		 */

	}
	
	public void product(BitSet[] bs) {
		this.counter = 0;
		product(bs, 0, SIZE_OF_DEVICE, new String[SIZE_OF_DEVICE]);
	}
	
	private int counter;
	
	private void product(BitSet[] bs, int c, int n, String[] device) {
		if(c < n) {
						
			// get the first set bit in column c
			int setIdx = bs[c].nextSetBit(0);
			while(setIdx != (-1)) {
				
				device[c] = ds[setIdx];
						
				// recursion				
				product(bs, c+1, n, device);
				
				// can I replace the recursion by ANDing, XORing, ORing, appropriate vectors of the matrices???
				
				// get the next set bit
				setIdx = bs[c].nextSetBit(setIdx+1);
			}
		} else {
			
			// here, we need to store the device...
			
			// current, we just increase a counter...
			this.counter ++;
			//System.out.println(Arrays.toString(device));
		}
	}
	
	public static void main(String[] args) {
		BitSetTest bst = new BitSetTest();		
		
		bst.SIZE_OF_DS = 3;
		bst.SIZE_OF_DEVICE = 100;
		bst.initDesignSpace();
		
		int NR_OF_ITERATIONS = 5;
		//int MAX_DEVICE_SIZE = 10;
		
		long[][] times = new long[2][NR_OF_ITERATIONS];
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			
			System.out.println((i+1)+"-th iteration...");
			
			long nInit = 0;
			long nProduct = 0;

			//for(int n = 1; n<=MAX_DEVICE_SIZE; n++) {
				long ts1 = System.nanoTime();			

				BitSet[] bsArray = bst.initBitSets();
				long ts2 = System.nanoTime();
	
				bst.product(bsArray);
				long ts3 = System.nanoTime();
				
				nInit = (ts2-ts1);
				nProduct = (ts3-ts2);
			//}
			
				System.out.println(nInit+", "+nProduct);
			times[0][i] = nInit;
			times[1][i] = nProduct;
		}
		
		// calculate the average
		long nSumInit = 0;
		long nSumProduct = 0;
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			nSumInit += times[0][i];
			nSumProduct += times[0][i];
		}
		double nInit = nSumInit / NR_OF_ITERATIONS;
		double nProduct = nSumProduct / NR_OF_ITERATIONS;
		
		System.out.println(nInit*Math.pow(10, -9)+"sec");
		System.out.println(nProduct*Math.pow(10, -9)+"sec");
	}


}
