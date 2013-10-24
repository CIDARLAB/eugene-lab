package org.cidarlab.eugene.evaluation.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;

import org.cidarlab.eugene.algorithm.Product;
import org.cidarlab.eugene.builder.EugeneBuilder;
import org.cidarlab.eugene.cache.SymbolTables;
import org.cidarlab.eugene.dom.components.Component;
import org.cidarlab.eugene.dom.components.Device;
import org.cidarlab.eugene.dom.components.types.PartType;
import org.cidarlab.eugene.dom.rules.Rule;
import org.cidarlab.eugene.exception.EugeneException;
import org.cidarlab.eugene.rules.tree.predicate.Contains;
import org.cidarlab.eugene.rules.tree.predicate.Exactly;
import org.cidarlab.eugene.rules.tree.predicate.Predicate;
import org.cidarlab.eugene.dom.arrays.*;

public class PositionalRulesTester {

	private static final int MAX_N = 7;
	
	private PartType partType;
	
	public PositionalRulesTester() {

		/*
		 * Turn off Eugene logging
		 */
		LogManager.getLogManager().reset();
		
		/*
		 * create a part type
		 */
		partType = EugeneBuilder.buildPartType("part-type", null);

	}
	
	public boolean testExactly() 
			throws EugeneException {
		
		
		boolean bCorrect = true;
		for(int n=1; n<=MAX_N && bCorrect; n++) {

			/*
			 * x == 0
			 */
//			System.out.println("*** n: "+n+", k: "+k+", x: "+0+" ***");
//			System.out.println((long)Math.pow(k, n));
			
			/*
			 * currently keeping k constant
			 */
			
			/*
			 * x ... appearance of part part-1
			 */			
			for(int x=1; x<=n; x++) {

				/*
				 * TODO: Ernst needs to improve the symbol tables start-up and clean-up
				 */
				SymbolTables.init();
				
				/*
				 * currently, k needs to be <= n
				 * TODO: we need to scale k too ...
				 * 
				 */
				int k = n;		
				createParts(k);
				Device d = createDevice(n);
				
				System.out.println("*** n: "+n+", k: "+k+", x: "+x+" ***");
				/*
				 * impose constraints
				 */
				createExactlyRule(d, "part-1", x);
				//System.out.println("part-1 EXACTLY "+x);

				
				long NR_OF_GENERATED_DEVICES = ((GeneratedDeviceArray)Product.product(d.getName(), -1)).size();
				long NR_OF_DEVICES = calculateExactly(n, k, x);	
				
				if(NR_OF_GENERATED_DEVICES != NR_OF_DEVICES) {
					bCorrect = false;
					break;
				}
				
				SymbolTables.cleanUp();
			}
		}
		
		return bCorrect;
	}
	
	private void createExactlyRule(Device d, String partName, int x) 
			throws EugeneException {
		
		Predicate exactly = new Exactly(SymbolTables.getId(partName), x);
		
		// now, let's assign the CONTAINS predicate 
		// to a rule
		
		Rule rule = new Rule(partName+"-EXACTLY-"+x, d, exactly);
		SymbolTables.put(rule);
	}
	
	private void createParts(int k) 
			throws EugeneException {
		/*
		 * store k parts into the database
		 */
		for(int i=1; i<=k; i++) {
			SymbolTables.put(
					EugeneBuilder.buildPart("part-"+i, null, this.partType));
		}
	}
	
	private Device createDevice(int n) 
			throws EugeneException {
		List<Component> lst = new ArrayList<Component>(n);
		char[] directions = new char[n];
		for(int i=1; i<=n; i++) {
			lst.add(this.partType);
			directions[i-1] = '+';
		}
		
		Device d = EugeneBuilder.buildDevice("device-"+n, lst, directions);
		SymbolTables.put(d);
		return d;
	}
	
	private long calculateExactly(int n, int k, int x) {
		/*
		 * n            n-x
		 *     *  (k-1)
		 * x
		 */

		return (long)(choose(n, x) * Math.pow(k-1, n-x));
		
	}
	
	private long choose(int n, int k) {
		return 	fact(n) / (fact(k)*fact(n-k));

	}
	private long fact(int n) {
		if(n>=2) {
			return n * fact(n-1);
		}
		return 1;
	}
	
	public static void main(String[] args) {
		PositionalRulesTester prt = new PositionalRulesTester();
		
		try {
			if(prt.testExactly()) {
				System.out.println("EXACTLY rule works...");
			} else {
				System.err.println("EXACTLY rule does NOT work...");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
