package eugene.jacop;

import JaCoP.constraints.And;
import JaCoP.constraints.Constraint;
import JaCoP.constraints.Count;
import JaCoP.constraints.ExtensionalSupportVA;
import JaCoP.constraints.IfThen;
import JaCoP.constraints.Not;
import JaCoP.constraints.Or;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqC;
import JaCoP.constraints.XeqY;
import JaCoP.constraints.XneqC;
import JaCoP.constraints.XneqY;
import JaCoP.core.IntVar;
import JaCoP.core.IntervalDomain;
import JaCoP.core.Store;
import JaCoP.search.DepthFirstSearch;
import JaCoP.search.IndomainMin;
import JaCoP.search.InputOrderSelect;
import JaCoP.search.Search;
import JaCoP.search.SelectChoicePoint;
import JaCoP.search.SimpleSolutionListener;
import JaCoP.search.SimpleSelect;
import JaCoP.set.constraints.AdisjointB;
import JaCoP.set.constraints.AeqB;
import JaCoP.set.constraints.AunionBeqC;
import JaCoP.set.constraints.EinA;
import JaCoP.set.core.BoundSetDomain;
import JaCoP.set.core.SetVar;
import JaCoP.set.search.IndomainSetMin;
import JaCoP.set.search.MaxGlbCard;
import JaCoP.set.search.MinLubCard;

public class JaCoPExamples {

	private Store store;
	private SetVar[] variables;
	
	private static final int NR_OF_VARIABLES = 5;
	
	public JaCoPExamples() {
		this.store = new Store();
	}
	
	public void defineVariables() {
		
		// VARIABLES
		this.variables = new SetVar[NR_OF_VARIABLES];
		
		// DOMAIN
		for(int i=0; i<NR_OF_VARIABLES; i++) {
			this.variables[i] = new SetVar(
				store, 
				"parts-"+(i+1), 
				new BoundSetDomain(1, 5));
		}
			
	}
	
	public void defineConstraints() {
		/*
		 * a BEFORE b
		 */
		
		// here, we use ExtensionalSupport

		// let's try to define Set constraints

		// STARTSWITH
		PrimitiveConstraint[] pc = new PrimitiveConstraint[NR_OF_VARIABLES-1];
		for(int i=0; i<NR_OF_VARIABLES-1; i++) {

//			store.impose(new AdisjointB(this.variables[i], this.variables[i+1]));
//			
//			// CONTAINS i
//			store.impose(
//					new EinA(i+1, this.variables[i]));
			
			// i NEXTTO i+1
				pc[i] = new Or(
							new And(
								new AeqB(new SetVar(store, i+1, i+2), this.variables[i]),
								new AeqB(new SetVar(store, i+2, i+2), this.variables[i+1])),
							new And(
								new AeqB(new SetVar(store, i+2, i+2), this.variables[i]),
								new AeqB(new SetVar(store, i+1, i+1), this.variables[i+1])));
		}
		store.impose(new Or(pc));
		
//		store.impose(
//				new AunionBeqC(
//						this.variables[0], 
//						this.variables[1]));
		// 1 before 2
		// get all promoters
		
		store.print();

	}
	
	public void solve() {
		Search<SetVar> label = new DepthFirstSearch<SetVar>(); 
        SelectChoicePoint<SetVar> select = 
            new SimpleSelect<SetVar>(
            		this.variables,
            		new MinLubCard<SetVar>(), 
                    new MaxGlbCard<SetVar>(), 
                    new IndomainSetMin<SetVar>());
        
//        label.setSolutionListener(new PrintListener());
        label.getSolutionListener().searchAll(true); 
//        label.getSolutionListener().recordSolutions(true);
        boolean result = label.labeling(store, select);
//		for (int i=1; i<=label.getSolutionListener().solutionsNo(); i++) { 
//			System.out.print("Solution " + i + ": "); 
//			for (int j=0; j<label.getSolution(i).length; j++) { 
//				System.out.print(label.getSolution(i)[j]); 
//			}
//			System.out.println(); 
//		}
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
	
	
	public static void main(String[] args) {
		JaCoPExamples mte = new JaCoPExamples();		
		mte.defineVariables();
		
		mte.defineConstraints();


		mte.solve();
	}
}
