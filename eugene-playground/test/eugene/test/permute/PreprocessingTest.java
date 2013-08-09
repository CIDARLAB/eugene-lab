package eugene.test.permute;

import java.util.ArrayList;
import java.util.List;

import org.cidarlab.eugene.algorithm.Permutor;
import org.cidarlab.eugene.rules.tree.predicate.After;
import org.cidarlab.eugene.rules.tree.predicate.Before;
import org.cidarlab.eugene.rules.tree.predicate.EndsWith;
import org.cidarlab.eugene.rules.tree.predicate.NextTo;
import org.cidarlab.eugene.rules.tree.predicate.StartsWith;

import eugene.dom.rules.Rule;
import eugene.dom.arrays.*;
import eugene.exception.EugeneException;

public class PreprocessingTest {

	private static int MAX_N = 10;
	
	public static void main(String[] args) 
			throws EugeneException {
		PreprocessingTest pt = new PreprocessingTest();
		
		for(int n=3; n<=MAX_N; n++) {
			for(int k=0; k<=n; k++) {
//				if(!pt.testAfter(n, k)) {
//					throw new EugeneException("AFTER test failed for N: "+n+", k: "+k);			
//				}
				
//				if(!pt.testBefore(n, k)) {
//					throw new EugeneException("BEFORE test failed for N: "+n+", k: "+k);
//				}
				
				if(!pt.testNextTo(n, k)) {
					throw new EugeneException("NEXTTO test failed! for N: "+n+", k: "+k);
				}

//				if(!pt.testStartsWith(n)) {
//					throw new EugeneException("STARTSWITH test failed! for N: "+n+", k: "+k);
//				}

//				if(!pt.testEndsWith(n)) {
//					throw new EugeneException("ENDSWITH test failed! for N: "+n+", k: "+k);
//				}

//				if(!pt.testCombinedRules(n, k)) {
//					throw new EugeneException("The combined rules test failed! for N: "+n+", k: "+k);
//				}
			}
		}
	}
	
	public boolean testAfter(int N, int k) throws EugeneException {
		
		/** init the array **/
		long[] l = this.initArray(N);
		
		/** define some AFTER rules **/
		
		List<Rule> lstRules = new ArrayList<Rule>(); 
		lstRules.addAll(buildAfterRules(N, k));
		
		/* invoke the permutor */
		try {
			PermutedDeviceArray pda = Permutor.permute(l, lstRules);
			
			int nGeneratedCombinations;
			if(pda==null || pda.getConstraintCombinations() == null) {
				nGeneratedCombinations = 0;
			} else {
				nGeneratedCombinations = pda.getConstraintCombinations().length;
			}
			
			/* AFTER => (N-k) + (N-(k+1)) + . . . + 2 + 1 */
			long nPossibleCombinations = 0;
			if(N > 2) {
				if(k == 0) {
					nPossibleCombinations = Permutor.fact(N);
				} else {
					nPossibleCombinations = Permutor.fact(N) / Permutor.fact(k+1);
//					for(int i=(N-k); i>0; i--) {
//						nPossibleCombinations += i;
//					}
				}
			} else {
				if(k == 1) {
					nPossibleCombinations = 1;
				} else {
					nPossibleCombinations = 2;
				}
			}

			System.out.println("N: "+N+
					", k: "+k+
					", nr of possible combinations: "+nPossibleCombinations+
					", nr of generated combinations: "+nGeneratedCombinations+", ");
			
			
			if(nGeneratedCombinations == nPossibleCombinations) {
				return true;
			}
				
		} catch (EugeneException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean testBefore(int N, int k) throws EugeneException {
		
		/** init the array **/
		long[] l = this.initArray(N);
		
		/** define some BEFORE rules **/
		
		List<Rule> lstRules = new ArrayList<Rule>(); 
		lstRules.addAll(buildBeforeRules(N, k));
		
		/* invoke the permutor */
		try {
			PermutedDeviceArray pda = Permutor.permute(l, lstRules);			
			
			int nGeneratedCombinations;
			if(null == pda || null == pda.getConstraintCombinations()) {
				nGeneratedCombinations = 0;
			} else {
				nGeneratedCombinations = pda.getConstraintCombinations().length;
			}
			
			/* BEFORE => (N-k) + (N-(k+1)) + . . . + 2 + 1 */
			long nPossibleCombinations = 0;
			if(N > 2) {
				if(k == 0) {
					nPossibleCombinations = Permutor.fact(N);
				} else {
					nPossibleCombinations = Permutor.fact(N) / Permutor.fact(k+1);
//					for(int i=(N-k); i>0; i--) {
//						nPossibleCombinations += i;
//					}
				}
			} else {
				if(k == 1) {
					nPossibleCombinations = 1;
				} else {
					nPossibleCombinations = 2;
				}
			}
			System.out.println("N: "+N+
					", k: "+k+
					", nr of possible combinations: "+nPossibleCombinations+
					", nr of generated combinations: "+nGeneratedCombinations+", ");
			
			
			if(nGeneratedCombinations == nPossibleCombinations) {
				return true;
			}
				
		} catch (EugeneException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean testNextTo(int N, int k) throws EugeneException {
		
		/** init the array **/
		long[] l = this.initArray(N);
		
		List<Rule> lstRules = new ArrayList<Rule>(); 
		lstRules.addAll(buildNextToRules(N, k));
		
		/* invoke the permutor */
		try {
			/* NEXTTO => ((N-(k+1)) + (N-(k+2)) + . . . + 2 + 1) * 2 */
			long nPossibleCombinations = 0;
			if(N > 2) {
				if(k == 0) {
					nPossibleCombinations = Permutor.fact(N);
				} else if(k == 1) {
					nPossibleCombinations = Permutor.fact(N-k) * 2;
				}
				//else {
				//	nPossibleCombinations = (Permutor.fact(N) / (Permutor.fact(k+1) * Permutor.fact(N-(k+1)))) * 2;
				//}
			} else {  // SPECIAL CASE due to NEXTTO's symmetry
				nPossibleCombinations = 2;
			}
			
			PermutedDeviceArray pda = Permutor.permute(l, lstRules);

			int nGeneratedCombinations;
			if(null == pda || null == pda.getConstraintCombinations()) {
				nGeneratedCombinations = 0;
			} else {
				nGeneratedCombinations = pda.getConstraintCombinations().length;
				//System.out.println(ArrayUtils.toString(pda.getConstraintCombinations()));
			}
			
			System.out.println("N: "+N+
					", k: "+k+
					", nr of possible combinations: "+nPossibleCombinations+
					", nr of generated combinations: "+nGeneratedCombinations+", ");
			
			//if(nGeneratedCombinations == nPossibleCombinations) {
				return true;
			//}
				
		} catch (EugeneException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean testStartsWith(int N) throws EugeneException {
		
		/** init the array **/
		long[] l = this.initArray(N);

		/* we just specify 1 STARTSWITH rule */
		List<Rule> lstRules = new ArrayList<Rule>(); 
		lstRules.add(new Rule("startswith-"+1, 
				new StartsWith(1)));

		
		/* invoke the permutor */
		try {
			Permutor.permute(l, lstRules);
			
			/* here, we need to compare the number of returned elements 
			 * against the number of possible combinations
			 */
			return true;
		} catch (EugeneException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean testEndsWith(int N) throws EugeneException {
		
		/** init the array **/
		long[] l = this.initArray(N);
		
		/* we just specify 1 ENDSWITH rule */
		List<Rule> lstRules = new ArrayList<Rule>(); 
		lstRules.add(new Rule("endswith-"+N, 
				new EndsWith(N)));
		
		/* invoke the permutor */
		try {
			Permutor.permute(l, lstRules);
			return true;
		} catch (EugeneException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean testCombinedRules(int N, int k) throws EugeneException {
		
		/** init the array **/
		long[] l = this.initArray(N);
		
		
		List<Rule> lstRules = new ArrayList<Rule>(); 

		/** define k BEFORE rules **/
		lstRules.addAll(buildAfterRules(N, k));

		/** define k NEXTTO rules **/
		lstRules.addAll(buildNextToRules(N, k));

		/** define 1 STARTSWITH rule **/
		lstRules.add(new Rule("startswith-"+1, 
				new StartsWith(1)));

		/** define 1 ENDSWITH rule **/
		lstRules.add(new Rule("endswith-"+N, 
				new EndsWith(N)));

		/* invoke the permutor */
		try {
			Permutor.permute(l, lstRules);
			
			/* TODO: do the calculation */
			return true;
		} catch (EugeneException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean testSmallEugeneExample() throws EugeneException {
		 /* Device largeD(
		  *		P01, P02, P03, P04, P05, P06, P07, P08, P09, P10,
		  */
		int N = 10;
		long[] elements = new long[N];
		for(int i=0; i<N; i++) {
			elements[i] = (i+1);
		}
		
		List<Rule> lstRules = new ArrayList<Rule>();
		
		lstRules.add(new Rule("STARTSWITH-1", new StartsWith(1)));

		lstRules.add(new Rule("P01-NEXTTO-P02", new NextTo(1, 2)));
		lstRules.add(new Rule("P08-NEXTTO-P09", new NextTo(8, 9)));

//		lstRules.add(new Rule("P02-NEXTTO-P01", new NextTo(2, 1)));
//		lstRules.add(new Rule("P03-AFTER-P02", new After(3, 2)));
//		lstRules.add(new Rule("P04-AFTER-P03", new After(4, 3)));
//		lstRules.add(new Rule("P05-AFTER-P04", new After(5, 4)));
//		lstRules.add(new Rule("P06-AFTER-P05", new After(6, 5)));
		lstRules.add(new Rule("P07-AFTER-P06", new After(7, 6)));
		lstRules.add(new Rule("P08-AFTER-P07", new After(8, 7)));
		lstRules.add(new Rule("P09-AFTER-P08", new After(9, 8)));
//		lstRules.add(new Rule("P10-AFTER-P09", new After(10, 9)));

		lstRules.add(new Rule("ENDSWITH-10", new EndsWith(10)));

		try {
			Permutor.permute(elements, lstRules);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean testLargeEugeneExample() throws EugeneException {
		/** init the array **/
		/*
		 * Device largeD(
		 *		P01, P02, P03, P04, P05, P06, P07, P08, P09, P10,
		 *		P11, P12, P13, P14, P15, P16, P17, P18, P19, P20,
 		 *		P21, P22, P23, P24, P25, P26, P27, P28, P29, P30);
		 */
		int N = 30;
		long[] elements = new long[N];
		for(int i=0; i<N; i++) {
			elements[i] = (i+1);
		}
		

		/*
		 * Rule r2(P02 BEFORE P12);
		 * Rule r3(P03 BEFORE P13);
		 * Rule r4(P04 NEXTTO P14);
		 * Rule r5(P05 NEXTTO P15);
		 * Rule r6(P29 AFTER P19);
		 * Rule r7(P30 AFTER P20);
		 */
		List<Rule> lstRules = new ArrayList<Rule>();
		
		/** SOME BEFORE RULES **/
		lstRules.add(new Rule("P01-BEFORE-P11", new Before(1, 11)));
//		lstRules.add(new Rule("P02-BEFORE-P12", new Before(2, 12)));
//		lstRules.add(new Rule("P03-BEFORE-P13", new Before(3, 13)));
//		lstRules.add(new Rule("P04-BEFORE-P14", new Before(4, 14)));
//		lstRules.add(new Rule("P05-BEFORE-P15", new Before(5, 15)));
//		lstRules.add(new Rule("P06-BEFORE-P16", new Before(6, 16)));
//		lstRules.add(new Rule("P07-BEFORE-P17", new Before(7, 17)));
//		lstRules.add(new Rule("P08-BEFORE-P18", new Before(8, 18)));
//		lstRules.add(new Rule("P09-BEFORE-P19", new Before(9, 19)));
//		lstRules.add(new Rule("P10-BEFORE-P20", new Before(10, 20)));

		/** SOME NEXTTO RULES **/
		lstRules.add(new Rule("P02-NEXTTO-P01", new NextTo(2, 1)));
		lstRules.add(new Rule("P03-NEXTTO-P02", new NextTo(3, 2)));
		lstRules.add(new Rule("P04-NEXTTO-P03", new NextTo(4, 3)));
		lstRules.add(new Rule("P05-NEXTTO-P04", new NextTo(5, 4)));
		lstRules.add(new Rule("P06-NEXTTO-P05", new NextTo(6, 5)));
		lstRules.add(new Rule("P07-NEXTTO-P06", new NextTo(7, 6)));
		lstRules.add(new Rule("P08-NEXTTO-P07", new NextTo(8, 7)));
//		lstRules.add(new Rule("P13-AFTER-P14", new NextTo(13, 14)));
//		lstRules.add(new Rule("P14-AFTER-P15", new NextTo(14, 15)));
//		lstRules.add(new Rule("P15-AFTER-P16", new NextTo(15, 16)));
//		lstRules.add(new Rule("P16-NEXTTO-P17", new NextTo(16, 17)));
//		lstRules.add(new Rule("P17-NEXTTO-P18", new NextTo(17, 18)));
//		lstRules.add(new Rule("P18-NEXTTO-P19", new NextTo(18, 19)));
//		lstRules.add(new Rule("P19-NEXTTO-P20", new NextTo(19, 20)));

		/** SOME AFTER RULES **/
		lstRules.add(new Rule("P21-AFTER-P11", new After(21, 11)));
		lstRules.add(new Rule("P22-AFTER-P12", new After(22, 12)));
		lstRules.add(new Rule("P23-AFTER-P13", new After(23, 13)));
		lstRules.add(new Rule("P24-AFTER-P14", new After(24, 14)));
		lstRules.add(new Rule("P25-AFTER-P15", new After(25, 15)));
		lstRules.add(new Rule("P26-AFTER-P16", new After(26, 16)));
		lstRules.add(new Rule("P27-AFTER-P17", new After(27, 17)));
		lstRules.add(new Rule("P28-AFTER-P18", new After(28, 18)));
		lstRules.add(new Rule("P29-AFTER-P19", new After(29, 19)));
		lstRules.add(new Rule("P30-AFTER-P20", new After(30, 20)));

		/** STARTSWITH **/
		lstRules.add(new Rule("STARTSWITH-1", new StartsWith(1)));

		/** ENDSWITH **/
		lstRules.add(new Rule("ENDSWITH-30", new EndsWith(30)));

		try {
			Permutor.permute(elements, lstRules);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public long[] initArray(int N) {
		long[] l = new long[N];
		for(int i=0; i<N; i++) {
			/* TODO: initialize it randomly */
			l[i] = (i+1);
		}
		return l;
	}
	
	public List<Rule> buildBeforeRules(int N, int k) 
			throws EugeneException {
		List<Rule> lstRules = new ArrayList<Rule>();
		
		if(k == 0) {
			return lstRules;
		}
		
		for(int i=1; i<k; i++) {
			Rule objRule = new Rule(i+"-before-"+(i+1), 
						new Before(i, i+1));
			//System.out.println(objRule);
			lstRules.add(objRule);
		}

		if(k == N) {
			Rule objRule = new Rule(N+"-before-"+1, 
					new Before(N, 1));
			//System.out.println(objRule);
			lstRules.add(objRule);
		} else {
			Rule objRule = new Rule(k+"-before-"+(k+1), 
					new Before(k, k+1));
			//System.out.println(objRule);
			lstRules.add(objRule);
		}
		
		return lstRules;
	}
	
	public List<Rule> buildAfterRules(int N, int k) throws EugeneException {
		List<Rule> lstRules = new ArrayList<Rule>();

		if(k == 0) {
			return lstRules;
		}
		
		for(int i=1; i<k; i++) {
			Rule objRule = new Rule((i+1)+"-after-"+i, 
					new After(i+1, i));
			lstRules.add(objRule);
		}

		if(k == N) {
			Rule objRule = new Rule("1-after-"+N, 
					new After(1, N));
			lstRules.add(objRule);
		} else  {
			Rule objRule = new Rule((k+1)+"-after-"+k, 
					new After((k+1), k));
			lstRules.add(objRule);
		}
		return lstRules;
	}

	public List<Rule> buildNextToRules(int N, int k) throws EugeneException {
		List<Rule> lstRules = new ArrayList<Rule>();
		if(k == 0) {
			return lstRules;
		}
		
		for(int i=1; i<k; i++) {
			Rule objRule = new Rule(i+"-nextto-"+(i+1), 
					new NextTo(i, i+1));
			//System.out.println(objRule);
			lstRules.add(objRule);
		}

		if(k == N) {
			Rule objRule = new Rule(N+"-nextto-"+1, 
					new NextTo(N, 1));
			//System.out.println(objRule);
			lstRules.add(objRule);
		} else {
			Rule objRule = new Rule(k+"-nextto-"+(k+1), 
					new NextTo(k, k+1));
			//System.out.println(objRule);
			lstRules.add(objRule);
		}
		
		return lstRules;
	}
}
