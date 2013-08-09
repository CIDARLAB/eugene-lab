package eugene.rules.contains;

import JaCoP.constraints.Or;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqC;
import JaCoP.core.IntVar;
import JaCoP.core.Store;
import JaCoP.search.DepthFirstSearch;
import JaCoP.search.IndomainMin;
import JaCoP.search.InputOrderSelect;
import JaCoP.search.Search;
import JaCoP.search.SelectChoicePoint;
import eugene.exception.EugeneException;

public class ContainsTUs {

	public static final int[] PROMOTERS = {10, 11, 12, 13};
	public static final int[] RBS = {20, 21, 22};
	public static final int[] GENES = {30, 31, 32, 33, 34};
	public static final int[] TERMINATORS = {40, 41, 42};

	public static final int[][] p = {PROMOTERS, RBS, GENES, TERMINATORS};
	
	private Store store;
	private IntVar[] variables;
	
	public ContainsTUs() {
		this.store = new Store();
		
		// VARIABLES
		this.variables = new IntVar[4];

		this.variables[0] = new IntVar(
				store, "promoter", PROMOTERS[0], PROMOTERS[PROMOTERS.length-1]);
		this.variables[1] = new IntVar(
				store, "rbs", RBS[0], RBS[RBS.length-1]);
		this.variables[2] = new IntVar(
				store, "gene", GENES[0], GENES[GENES.length-1]);
		this.variables[3] = new IntVar(
				store, "terminator", TERMINATORS[0], TERMINATORS[TERMINATORS.length-1]);
		
		store.print();
	}
		
	public void imposeContains(int b, int i) {
		/*
		 * CONTAINS x
		 */
		System.out.println("imposing CONTAINS "+b);
		
		PrimitiveConstraint[] pc = new PrimitiveConstraint[p[i].length];
		
		for(int p=0; p<pc.length; p++) {
			pc[p] = new XeqC(variables[i], b);
		}
		
		store.impose(new Or(pc));		
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

	public static void count() 
			throws EugeneException {
		
		for(int k=0; k<=4; k++) {
			ContainsTUs tu = new ContainsTUs();
			
			for(int i=0; i<k; i++) {
				tu.imposeContains(p[i][0], i);
			}
			
			tu.solve();
		}
	}

	public static void main(String[] args) 
			throws EugeneException {
		
		count();
		
	}
}
