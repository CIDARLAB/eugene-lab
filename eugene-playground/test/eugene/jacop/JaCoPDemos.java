package eugene.jacop;

import JaCoP.constraints.IfThen;
import JaCoP.constraints.Or;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqY;
import JaCoP.constraints.XneqY;
import JaCoP.core.IntVar;
import JaCoP.core.Store;
import JaCoP.search.DepthFirstSearch;
import JaCoP.search.IndomainMin;
import JaCoP.search.InputOrderSelect;
import JaCoP.search.Search;
import JaCoP.search.SelectChoicePoint;

public class JaCoPDemos {

	public static void main(String[] args) {
		Store store = new Store();
		
		int N = 16;
		
		IntVar[] variables = new IntVar[N];

		for(int i=0; i<N; i++) {
			// 100 promoters
			variables[i] = new IntVar(store, "StataPart", 1, 5);
		}
		
		/* let's say that the first element can be either 1, 2, or 3 */
//		startswith.addDom(2, 2);
//		startswith.addDom(3, 3);
		
		// we also define the bound variables
		IntVar one = new IntVar(store, "nextto", 1, 1);
		IntVar two = new IntVar(store, "nextto", 2, 2);		
		IntVar three = new IntVar(store, "nextto", 3, 3);		
		IntVar four = new IntVar(store, "nextto", 4, 4);		
		IntVar five = new IntVar(store, "nextto", 5, 5);


		/** STARTSWITH 1 **/
		IntVar startswith = new IntVar(store, "startswith", 1, 1);
		store.impose(new XeqY(variables[0], startswith));
		
		/** ENDSWITH 5 **/
		IntVar endswith = new IntVar(store, "endswith", 5, 5);
		store.impose(new XeqY(variables[N-1], endswith));
		
		/** 1 NEXTTO 2 **/		
		for(int i=0; i<N-1; i++) {
			store.impose(new IfThen(new XeqY(variables[i], one), new XeqY(variables[i+1], two)));
			store.impose(new IfThen(new XeqY(variables[i+1], one), new XeqY(variables[i], two)));
		}
		
		/** CONTAINS 3 **/
		PrimitiveConstraint[] pc = new PrimitiveConstraint[N];
		for(int i=0; i<N; i++) {
			pc[i] = new XeqY(variables[i], three);
		}
		// NOT CONTAINS 3
		//store.impose(new Not(new Or(pc)));
		
		// CONTAINS 3
		store.impose(new Or(pc));
		
		/** 5 AFTER 4 **/
		for(int i=0; i<N-1; i++) {
			/** 5 AFTER 4 **/
			store.impose(new IfThen(new XeqY(variables[i], five), new XneqY(variables[i+1], four)));
			
			/** 3 BEFORE 4 **/
			store.impose(new IfThen(new XeqY(variables[i], four), new XneqY(variables[i+1], three)));
		}
		
		Search<IntVar> search = new DepthFirstSearch<IntVar>(); 
        SelectChoicePoint<IntVar> select = 
            new InputOrderSelect<IntVar>(store, variables, new IndomainMin<IntVar>()); 
        search.getSolutionListener().searchAll(true);
        //search.getSolutionListener().recordSolutions(true);
        boolean result = search.labeling(store, select); 
 
        System.out.println("number of solutions: "+search.getSolutionListener().solutionsNo());

//        for (int i=1; i<=search.getSolutionListener().solutionsNo(); i++) { 
//	        for (int j=0; j<search.getSolutionListener().getSolution(i).length; j++) { 
//	        	System.out.print(search.getSolutionListener().getSolution(i)[j]+", "); 
//	        }
//	        System.out.println();
//        }
//            
//            for (int j=0; j<search.getSolution(i).length; j++) { 
//               System.out.print(search.getSolution(i)[j]); 
//            }
//            System.out.println(); 
//         }
//        if ( result ) 
//            System.out.println("Solution: " + variables[0]+", "+variables[1] +", "+ 
//            		variables[2] +", "+variables[3]); 
//        else 
//            System.out.println("*** No"); 
	}
}
