package eugene.jacop;

import JaCoP.core.IntVar;
import JaCoP.core.Store;
import JaCoP.search.DepthFirstSearch;
import JaCoP.search.IndomainMin;
import JaCoP.search.InputOrderSelect;
import JaCoP.search.Search;
import JaCoP.search.SelectChoicePoint;

public class ScaleJacop {

	private static final int MAX_VARIABLES = 30;
	private static final int DOMAIN_SIZE = 300;
	
	public static void main(String[] args) {		

		for(int i=1; i<=MAX_VARIABLES; i++) {		
			Store store = new Store();

			IntVar[] variables = new IntVar[i];

			/* for every variable */			
			for(int k=0; k<i; k++) {
				// 100 promoters
				variables[k] = new IntVar(store, "part", 1, DOMAIN_SIZE);
										
			}
			
			Search<IntVar> dfs = new DepthFirstSearch<IntVar>(); 
			SelectChoicePoint<IntVar> select = 
			            new InputOrderSelect<IntVar>(store, variables, new IndomainMin<IntVar>()); 
			dfs.getSolutionListener().searchAll(true);
	
			//search.getSolutionListener().recordSolutions(true);
			dfs.labeling(store, select); 
			 
			System.out.println("variables "+i+" -> "+dfs.getSolutionListener().solutionsNo());

		}
	}
}
