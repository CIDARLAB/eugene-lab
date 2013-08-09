package eugene.jacop;

import JaCoP.constraints.Count;
import JaCoP.constraints.Not;
import JaCoP.core.IntVar;
import JaCoP.core.Store;
import JaCoP.search.DepthFirstSearch;
import JaCoP.search.IndomainMin;
import JaCoP.search.InputOrderSelect;
import JaCoP.search.Search;
import JaCoP.search.SelectChoicePoint;

public class MoreThanExample {

	private Store store;
	private IntVar[] variables;
	
	private static final int NR_OF_VARIABLES = 3;
	private static final int SIZE_OF_DOMAIN = 30;
	
	public MoreThanExample() {
		this.store = new Store();
		this.variables = new IntVar[NR_OF_VARIABLES];
	}
	
	public void defineVariables() {
		
		for(int i=0; i<NR_OF_VARIABLES; i++) {
			variables[i] = new IntVar(store, 1, SIZE_OF_DOMAIN);
		}
		
	}
	
	public void defineConstraints() {
		
		/*
		 * 1 NOT MORETHAN 1 
		 * The value 1 should appear only once 
		 */		
		IntVar c1 = new IntVar(store, 0, 1);		
		store.impose(new Count(this.variables, c1, 1));  
		
		/*
		 * 2 MORETHAN 1 
		 * The value 2 should appear at least once 
		 */
		IntVar c2 = new IntVar(store, (1 + 1), NR_OF_VARIABLES);		
		store.impose(new Count(this.variables, c2, 2));
		
		/*
		 * 3 EXACTLY 1
		 */
		IntVar c3 = new IntVar(store, 1, 1);		
		store.impose(new Count(this.variables, c3, 3));

		/*
		 * GENERAL:
		 * x MORETHAN n
		 * => IntVar n = new IntVar(store, n+1, N);
		 *    store.impose(new Count(this.variables, n, x));
		 * 
		 * 
		 * x NOTMORETHAN n
		 * => IntVar n = new IntVar(store, 0, n);
		 *    store.impose(new Count(this.variables, n, x));
		 */
	}
	
	public void solve() {
		Search<IntVar> label = new DepthFirstSearch<IntVar>(); 
        SelectChoicePoint<IntVar> select = 
            new InputOrderSelect<IntVar>(store, variables, new IndomainMin<IntVar>());
        label.getSolutionListener().searchAll(true); 
        label.getSolutionListener().recordSolutions(true);
        boolean result = label.labeling(store, select);
		for (int i=1; i<=label.getSolutionListener().solutionsNo(); i++) { 
			System.out.print("Solution " + i + ": "); 
			for (int j=0; j<label.getSolution(i).length; j++) { 
				System.out.print(label.getSolution(i)[j]); 
			}
			System.out.println(); 
		}
	}
	
	public static void main(String[] args) {
		MoreThanExample mte = new MoreThanExample();		
		mte.defineVariables();
		
		mte.defineConstraints();
		
		mte.solve();
	}
}
