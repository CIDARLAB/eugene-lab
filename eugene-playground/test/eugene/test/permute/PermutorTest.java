package eugene.test.permute;


public class PermutorTest {

	/*
	 * In this test, we iteratively permute arrays of long values... 
	 * i=2: [1,2]
	 * i=3: [1,2,3]
	 * ...
	 * i=N: [1,2,3,...,N]
	 */
	private static final int MAX_N = 3;  // please set N as big as you want
	
	/*
	 * since order matters in permutations, we define rules saying that
	 * the i-th element must be BEFORE the (i+1)-th element where i=1,2,...,N
	 * 
	 * then, we invoke Eugene's Permutor (org.cidarlab.eugene.algorithm.Permutor)
	 * giving the array and the list of BEFORE rules...
	 * 
	 * if everything works perfectly, then the Permutor should return only one array
	 * that equals the array that we've given to the Permutor
	 * 
	 */
	

	/*
	 * k can have a value from 1,...,N
	 *
	 * k = 1 => l[0] < l[1] < ... < l[N-1]
	 * k = 2 => l[0] < l[1] < ... < l[N-2]
	 * ...
	 * k = j (j>0 & j<N) => l[0] < ... < l[N-j]
	 * 
	 * => the number of generated devices is equal to
	 * N! / (N - (k-1))!  
	 */

	public static void main(String[] args) 
			throws Exception {
		
		/**********************/
		/** STRUCTURAL RULES **/
		/**********************/
//		if(!new AfterTest(MAX_N).testAfter()) {
//			throw new Exception("Ernst! WORK HARDER ON THE AFTER RULE!");
//		} else {
//			System.out.println("AFTER test passed!");		
//		}
//		
//		if(!new BeforeTest(MAX_N).testBefore()) {
//			throw new Exception("Ernst! WORK HARDER ON THE BEFORE RULE!");
//		} else {
//			System.out.println("BEFORE test passed!");		
//		}
//
//		if(!new NextToTest(MAX_N).testNextTo()) {
//			throw new Exception("Ernst! WORK HARDER ON THE NEXTTO RULE!");
//		} else {
//			System.out.println("NEXTTO test passed!");		
//		}
//
//		if(!new StartsWithTest(MAX_N).test()) {
//			throw new Exception("Ernst! WORK HARDER ON THE STARTSWITH RULE!");
//		} else {
//			System.out.println("STARTSWITH test passed!");		
//		}
//
//		if(!new EndsWithTest(MAX_N).test()) {
//			throw new Exception("Ernst! WORK HARDER ON THE ENDSWITH RULE!");
//		} else {
//			System.out.println("ENDSWITH test passed!");		
//		}

	}
	

	
}
