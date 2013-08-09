package eugene.iGEM;

import eugene.Eugene;

public class iGemTester {

	// TODO:
	// - would junit testing make sense?!
	
	public static void main(String[] args) {
		// iGEM:
		
		// - Bug 109: Rule function does not work
		/** FIXED **/ 
		/**
		System.out.println("BUG 109: ");
		new Eugene("./iGEM/bugs/bug_109.eug");
		**/
		
		/** DIANA is on it...
		// - Bug 110: rules are not being applied
		System.out.println("BUG 110: ");
		new Eugene("./iGEM/bugs/bug_110.eug");
		 **/
		
		/**
		System.out.println("save(): ");
		new Eugene("./iGEM/bugs/save.eug");
		 **/
		
		// TODO!!!
		/** BUG 112: SBOL.export  
		System.out.println("BUG 112: ");
		new Eugene("./iGEM/bugs/bug_112.eug");
		 **/
		
		/** BUG 114: dynamic naming 
		System.out.println("BUG 114: ");
		new Eugene("./iGEM/bugs/bug_114.eug");
		 **/
	}

}
