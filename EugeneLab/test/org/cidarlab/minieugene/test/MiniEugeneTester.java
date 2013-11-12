package org.cidarlab.minieugene.test;

import org.cidarlab.minieugene.MiniEugene;

public class MiniEugeneTester {

	private static final String NEWLINE = System.getProperty("line.separator");
	
	private static final char[] letters = {'p', 'r', 'g', 't'};
	
	public boolean testN() {
		String[] testN = new String[20];
		/* Invalid ones */
		testN[0] = new String("N");
		testN[1] = new String("*");
		testN[2] = new String("1");
		testN[3] = new String("N=");
		testN[4] = new String("*=");
		testN[5] = new String("1=");
		testN[6] = new String("*=1");
		testN[7] = new String("N=x1");
		testN[8] = new String("*=N");
		testN[9] = new String("*=1");
		testN[10] = new String("");
		testN[11] = new String("N=1.0");
		testN[12] = new String("1=3.14");
		testN[13] = new String("1.0=N");
		testN[14] = new String("x=3.14");
		testN[15] = new String("N 3.14");
		testN[16] = new String("N=1=*");
		testN[17] = new String("1 =");
		
		/* valid ones */
		testN[18] = new String("N=     1");
		testN[19] = new String("    N    =    *");
		
		
		int[] valid = new int[2];		
		int validIdx = 0;		
		for(int i=0; i<testN.length; i++) {
			try {
				new MiniEugene(false).parseN(testN[i]);
				valid[validIdx++] = i;
			} catch(Exception e) {
			}
		}
		if(valid[0] == 18 && valid[1]==19) {
			return true;
		}
		return false;
	}
	
	public boolean testRules() {
		
//		testContains();
		testAllBefore();
		testSomeBefore();
		
		return true;
	}
	
	public boolean testContains() {
		boolean b = true;
		for(int i=0; i<letters.length; i++) {
			b &= testContains(i+1);
		}
		return b;
	}
	
	public boolean testAllBefore() {
		
		for(int i=2; i<=10; i++) {
			String s = new String("N="+i+NEWLINE+"a BEFORE b");
			try {
				new MiniEugene(false).execute(s, -1);
			} catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return true;
	}

	public boolean testSomeBefore() {
		
		for(int i=2; i<=10; i++) {
			String s = new String("N="+i+NEWLINE+"a SOME_BEFORE b");
			try {
				new MiniEugene(false).execute(s, -1);
			} catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return true;
	}

	private boolean testContains(int n) {
		
		/*
		 * N ... length/size of the design
		 * 0 < N <= 10
		 */
		String[] testN = new String[10];

		for(int i=0; i<10; i++) {
			testN[i] = buildContains(i+1, n);
		}

		for(int i=0; i<testN.length; i++) {
			try {
				new MiniEugene(true).execute(testN[i], -1);
			} catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
		return true;
	}
	
	private String buildContains(int N, int k) {
		String s = new String("N="+N)+NEWLINE;
		for(int i=1; i<=k; i++) {
			s += "CONTAINS "+letters[i-1]+NEWLINE;
		}
		return s;
	}
	
	public static void main(String[] args) {
		MiniEugeneTester st = new MiniEugeneTester();
		
		if(st.testN()) {
			System.out.println("testN passed!");
		} else {
			System.err.println("testN failed!");			
		}

		if(st.testRules()) {
			System.out.println("testRules passed!");
		} else {
			System.err.println("testRules failed!");			
		}

	}

}
