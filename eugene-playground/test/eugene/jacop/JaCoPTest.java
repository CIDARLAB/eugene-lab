package eugene.jacop;

import JaCoP.constraints.And;
import JaCoP.constraints.Count;
import JaCoP.constraints.IfThen;
import JaCoP.constraints.Or;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.Values;
import JaCoP.constraints.XeqC;
import JaCoP.constraints.XeqY;
import JaCoP.constraints.XneqC;
import JaCoP.constraints.XneqY;
import JaCoP.core.IntVar;
import JaCoP.core.Store;
import JaCoP.search.DepthFirstSearch;
import JaCoP.search.IndomainMin;
import JaCoP.search.InputOrderSelect;
import JaCoP.search.Search;
import JaCoP.search.SelectChoicePoint;
import JaCoP.search.SimpleSolutionListener;

public class JaCoPTest {

	private Store store;
	private IntVar[] variables;
	
	private int DOMAIN_SIZE;
	private int NR_OF_VARIABLES;
	
	public JaCoPTest(int DOMAIN_SIZE, int NR_OF_VARIABLES) {
		this.store = new Store();
		this.DOMAIN_SIZE = DOMAIN_SIZE;
		this.NR_OF_VARIABLES = NR_OF_VARIABLES;
		   
	}
	
	public void defineVariables() {
		
		// VARIABLES
		this.variables = new IntVar[NR_OF_VARIABLES];
		
		// DOMAIN
		for(int i=0; i<NR_OF_VARIABLES; i++) {
			this.variables[i] = new IntVar(
				store, 
				"parts-"+(i+1), 1, DOMAIN_SIZE);
		}
	}
	
	private void resetStore() {
		Runtime.getRuntime().gc();
		
		this.store = new Store();
		this.defineVariables();
		
	} 
	
	public void defineConstraints() {
		for(int k=1; k<NR_OF_VARIABLES; k++) {			
			//this.imposeContains(this.store, x);
			this.imposeBefore(this.store, k, (k+1));
		
			// let's test the NEXTTO rules
			this.imposeNextTo(store, k, k+1);
		}
		
//		this.imposeContains(this.store, NR_OF_VARIABLES);

		// MORETHAN
		
//		// 1 MORETHAN 1
//		this.imposeMoreThan(this.store, 1, 1);
//		// 2 MORETHAN 1
//		this.imposeMoreThan(this.store, 2, 5);
//		// 1 NOTMORETHAN 5
//		this.imposeNotMoreThan(this.store, 1, 5);
		
		// WITH rule
//		this.imposeWith(store, 1, 2);
//		this.imposeWith(store, 2, 3);
//		this.imposeWith(store, 3, 4);
//		this.imposeWith(store, 4, 5);
//		this.imposeWith(store, 5, 6);

		// THEN rule
//		this.imposeThen(store, 1, 2);
//		this.imposeThen(store, 2, 3);
//		this.imposeThen(store, 3, 4);
//		this.imposeThen(store, 4, 5);
//		this.imposeThen(store, 5, 6);
		
		
		/*
		 * TODO:
		 * this.imposeStartsWith(store, a, b);
		 * this.imposeEndsWith(store, a, b);
		 */
	}
	
	public void imposeContains(Store store, int b) {
		/*
		 * CONTAINS x
		 */
		System.out.println("imposing CONTAINS "+b);

		PrimitiveConstraint[] pc = new PrimitiveConstraint[NR_OF_VARIABLES];
		
		for(int p=0; p<NR_OF_VARIABLES; p++) {
			pc[p] = new XeqC(variables[p], b);
		}
		
		store.impose(new Or(pc));		
	}
	
	public void testContains() {
		for(int k=0; k<=NR_OF_VARIABLES; k++) {
			
			this.resetStore();
			
			// define some constraints
			for(int x=1; x<=k; x++) {			
				this.imposeContains(this.store, x);
			}

			// solve it and get the number of solutions
			this.solve();
		} 		
	}
	
	public void imposeBefore(Store store, int a, int b) {
		/*
		 * a BEFORE b
		 * 1        2
		 */
		System.out.println("imposing "+a+" BEFORE "+b);
		
		for(int posA=0; posA<NR_OF_VARIABLES;posA++) {
			PrimitiveConstraint[] v1 = new PrimitiveConstraint[posA+1];
			for(int posB = 0; posB<=posA; posB++) {
				v1[posB] = new XneqC(variables[posB], b);
			}
			
			PrimitiveConstraint[] v2 = new PrimitiveConstraint[NR_OF_VARIABLES - (posA+1)];
			for(int posB = posA+1; posB<NR_OF_VARIABLES; posB++) {
				v2[posB-(posA+1)] = new XeqC(variables[posB], b);
			}
			
			store.impose(
					new And(
							new IfThen(
									new XeqC(variables[posA], a), 
									new And(v1)),
							new IfThen(
									new XeqC(variables[posA], a), 
									new Or(v2))));
		}
		
	}

	public void imposeNextTo(Store store, int a, int b) {
		System.out.println("imposing "+a+" NEXTTO "+b);
		
		PrimitiveConstraint[] pc = new PrimitiveConstraint[NR_OF_VARIABLES*2];
		int posA = 0;
		pc[posA] = new IfThen(
				new XeqC(variables[posA], a),
				new XeqC(variables[posA+1], b));
		
		for(posA=1; posA<NR_OF_VARIABLES-1; posA++) {
			pc[posA] = new IfThen(
				new XeqC(variables[posA], a),
				new Or(
					new XeqC(variables[posA-1], b),
					new XeqC(variables[posA+1], b)));
		}
		
		posA = NR_OF_VARIABLES-1;		
		pc[posA] = new IfThen(
				new XeqC(variables[posA], a),
				new XeqC(variables[posA-1], b));
		posA++;
		
		//PrimitiveConstraint[] pcB = new PrimitiveConstraint[NR_OF_VARIABLES];
		int posB = 0;
		pc[posA+posB] = new IfThen(
				new XeqC(variables[posB], b),
				new XeqC(variables[posB+1], a));
		
		for(posB=1; posB<NR_OF_VARIABLES-1; posB++) {
			pc[posA+posB] = new IfThen(
					new XeqC(variables[posB], b),
					new Or(
						new XeqC(variables[posB-1], a),
						new XeqC(variables[posB+1], a)));
		}
		
		posB = NR_OF_VARIABLES-1;
		pc[posA+posB] = new IfThen(
				new XeqC(variables[posB], b),
				new XeqC(variables[posB-1], a));
		//PrimitiveConstraint b_nextto_a = new Or(pcB);
		
		store.impose(new Or(pc));
	}

	public void imposeMoreThan(Store store, int a, int N) {

		System.out.println("imposing "+a+" MORETHAN "+N);

		// a MORETHAN N
		IntVar count = new IntVar(store, "counter", (N + 1), NR_OF_VARIABLES); 
		store.impose( new Count(this.variables, count, a) );
	}
	
	public void imposeNotMoreThan(Store store, int a, int N) {
		System.out.println("imposing "+a+" NOTMORETHAN "+N);

		// a NOTMORETHAN N
		IntVar count = new IntVar(store, "counter", 0, N); 
		store.impose( new Count(this.variables, count, a) );
	}
	
	
	public void imposeWith(Store store, int a, int b) {
		/*
		 * a WITH b
		 * 
		 * -> CONTAINS a AND CONTAINS b
		 */
		this.imposeContains(store, a);
		this.imposeContains(store, b);		
	}
	
	public void imposeThen(Store store, int a, int b) {
		System.out.println("imposing "+a+" THEN "+b);
		
		/*
		 * a THEN b
		 * 
		 * IF CONTAINS a THEN CONTAINS b
		 */
		PrimitiveConstraint[] pcA = new PrimitiveConstraint[NR_OF_VARIABLES];
		for(int posA = 0; posA<NR_OF_VARIABLES; posA ++) {
			
			PrimitiveConstraint[] pcB = new PrimitiveConstraint[NR_OF_VARIABLES-1];
			for(int posB = 0, i=0; posB<NR_OF_VARIABLES; posB++) {
				if(posB != posA) {
					pcB[i++] = new XeqC(this.variables[posB], b);
				}			
			}
			
			pcA[posA] = new IfThen(new XeqC(this.variables[posA], a),
							new Or(pcB));
		}
		
		store.impose(new Or(pcA));
	}
	
	public void solve() {
		   
		Search<IntVar> label = new DepthFirstSearch<IntVar>(); 
		SelectChoicePoint<IntVar> select = 
				new InputOrderSelect<IntVar>(store, this.variables, new IndomainMin<IntVar>()); 
        label.getSolutionListener().searchAll(true); 
        label.getSolutionListener().recordSolutions(true);
//        label.getSolutionListener().setSolutionLimit(200);

		long T1 = System.nanoTime();

        // SOLVE
        label.labeling(store, select);

		long T2 = System.nanoTime();		
		System.out.println("processing time: "+(T2-T1)*Math.pow(10, -9)+"sec");

		//System.out.println(label.getSolutionListener().getSolutions().length+" solutions generated...");
		
		for (int i=1; i<=label.getSolutionListener().solutionsNo(); i++) { 
			System.out.print("Solution " + i + ": "); 
			for (int j=0; j<label.getSolution(i).length; j++) { 
				System.out.print(label.getSolution(i)[j]+", "); 
			}
			System.out.println(); 
		}
	}
	
	public class PrintListener 
		extends SimpleSolutionListener {

		@Override
		public boolean executeAfterSolution(Search search, 
				SelectChoicePoint select) {

			boolean returnCode = super.executeAfterSolution(search, select);
			
			if (noSolutions % 10 == 0) {
				System.out.println("Solution # " + noSolutions);
				//printSolution();
			}
			
			return returnCode;
		}
	}
	
	public Store getStore() {
		return this.store;
	}
	
	
	public static void main(String[] args) {
//		if(args.length != 2) {
//			System.err.println("USAGE: java -jar jacopTest.jar <domain-size> <number-of-variables>");
//			System.exit(1);
//		}
		
		try {
//			int DOMAIN_SIZE = Integer.valueOf(args[0]);
//			int NR_OF_VARIABLES = Integer.valueOf(args[1]);
			int DOMAIN_SIZE = 3;
			int NR_OF_VARIABLES = 3;

			JaCoPTest mte = new JaCoPTest(DOMAIN_SIZE, NR_OF_VARIABLES);		
			mte.defineVariables();
			//mte.defineConstraints();
			
			// TEST!!!
			mte.testContains();
			mte.solve();
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}		
	}
}
