package eugene.rules.nextto;

import JaCoP.constraints.IfThen;
import JaCoP.constraints.Or;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqC;
import JaCoP.core.IntVar;
import JaCoP.core.Store;
import JaCoP.search.DepthFirstSearch;
import JaCoP.search.IndomainHierarchical;
import JaCoP.search.IndomainList;
import JaCoP.search.IndomainMiddle;
import JaCoP.search.IndomainMin;
import JaCoP.search.IndomainRandom;
import JaCoP.search.IndomainSimpleRandom;
import JaCoP.search.InputOrderSelect;
import JaCoP.search.Search;
import JaCoP.search.SelectChoicePoint;
import eugene.exception.EugeneException;

public class NextToStata {

	private static final int NR_OF_PARTS = 300;
	private static final int SIZE_OF_DEVICE = 30;
	private int[] STATA_PARTS;
	private int[][] p;
	
	private Store store;
	private IntVar[] variables;
	
	public NextToStata() {
		// init the design space
		this.STATA_PARTS = new int[NR_OF_PARTS];
		for(int i=0; i<NR_OF_PARTS; i++) {
			this.STATA_PARTS[i] = 100 + i;
		}

		
		// VARIABLES
		this.store = new Store();
		
		this.variables = new IntVar[SIZE_OF_DEVICE];		

		for(int i=0; i<SIZE_OF_DEVICE; i++) {
			this.variables[i] = new IntVar(
				store, 
				"StataPart", 
				this.STATA_PARTS[0], 
				this.STATA_PARTS[this.STATA_PARTS.length-1]);
		}
				
		store.print();
	}
		
	public void imposeNextTo(int a, int b) {
		System.out.println("imposing "+a+" NEXTTO "+b);
		
		PrimitiveConstraint[] pc = new PrimitiveConstraint[4*2];
		int posA = 0;
		pc[posA] = new IfThen(
				new XeqC(variables[posA], a),
				new XeqC(variables[posA+1], b));
		
		for(posA=1; posA<4-1; posA++) {
			pc[posA] = new IfThen(
				new XeqC(variables[posA], a),
				new Or(
					new XeqC(variables[posA-1], b),
					new XeqC(variables[posA+1], b)));
		}
		
		posA = 4-1;		
		pc[posA] = new IfThen(
				new XeqC(variables[posA], a),
				new XeqC(variables[posA-1], b));
		posA++;
		
		//PrimitiveConstraint[] pcB = new PrimitiveConstraint[NR_OF_VARIABLES];
		int posB = 0;
		pc[posA+posB] = new IfThen(
				new XeqC(variables[posB], b),
				new XeqC(variables[posB+1], a));
		
		for(posB=1; posB<4-1; posB++) {
			pc[posA+posB] = new IfThen(
					new XeqC(variables[posB], b),
					new Or(
						new XeqC(variables[posB-1], a),
						new XeqC(variables[posB+1], a)));
		}
		
		posB = 4-1;
		pc[posA+posB] = new IfThen(
				new XeqC(variables[posB], b),
				new XeqC(variables[posB-1], a));
		//PrimitiveConstraint b_nextto_a = new Or(pcB);
		
		store.impose(new Or(pc));
	}

	public void solve(int N) {
		   
		Search<IntVar> label = new DepthFirstSearch<IntVar>(); 
		SelectChoicePoint<IntVar> select = null;
		
        if(N != (-1)) {
			select = new InputOrderSelect<IntVar>(store, this.variables, new IndomainSimpleRandom<IntVar>()); 
        	label.getSolutionListener().setSolutionLimit(N);
        } else {
			new InputOrderSelect<IntVar>(store, this.variables, new IndomainMiddle<IntVar>()); 
            label.getSolutionListener().searchAll(true);            
        }
        
        label.getSolutionListener().recordSolutions(true);

		long T1 = System.nanoTime();

        // SOLVE
        label.labeling(store, select);

		long T2 = System.nanoTime();		
		System.out.println("processing time: "+(T2-T1)*Math.pow(10, -9)+"sec");

		//System.out.println(label.getSolutionListener().getSolutions().length+" solutions generated...");
		
//		for (int i=1; i<=label.getSolutionListener().solutionsNo(); i++) { 
//			System.out.print("Solution " + i + ": "); 
//			for (int j=0; j<label.getSolution(i).length; j++) { 
//				System.out.print(label.getSolution(i)[j]+", "); 
//			}
//			System.out.println(); 
//		}
	}

	public static void count() 
			throws EugeneException {
		NextToStata stata = new NextToStata();
		
		stata.solve(2000);
	}

	public static void main(String[] args) 
			throws EugeneException {		
		count();		
	}

}
