package org.cidarlab.minieugene.solver.jacop;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.predicates.Predicate;
import org.cidarlab.minieugene.solver.Solver;
import org.cidarlab.minieugene.solver.stats.jacop.SolverStats;
import org.cidarlab.minieugene.solver.stats.jacop.Stats;
import org.cidarlab.minieugene.symbol.SymbolTables;

import JaCoP.constraints.Alldifferent;
import JaCoP.constraints.And;
import JaCoP.constraints.Constraint;
import JaCoP.constraints.Element;
import JaCoP.constraints.IfThen;
import JaCoP.constraints.Or;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.Reified;
import JaCoP.constraints.XeqC;
import JaCoP.constraints.XeqY;
import JaCoP.constraints.XgtC;
import JaCoP.constraints.XgtY;
import JaCoP.core.BooleanVar;
import JaCoP.core.Domain;
import JaCoP.core.IntDomain;
import JaCoP.core.IntVar;
import JaCoP.core.Store;
import JaCoP.core.ValueEnumeration;
import JaCoP.scala.SetVar;
import JaCoP.search.DepthFirstSearch;
import JaCoP.search.IndomainHierarchical;
import JaCoP.search.IndomainList;
import JaCoP.search.IndomainMiddle;
import JaCoP.search.IndomainMin;
import JaCoP.search.IndomainSimpleRandom;
import JaCoP.search.LargestDomain;
import JaCoP.search.MostConstrainedDynamic;
import JaCoP.search.Search;
import JaCoP.search.SelectChoicePoint;
import JaCoP.search.SimpleMatrixSelect;
import JaCoP.search.SimpleSelect;


public class JaCoPSolver 
		implements Solver {

	private Store store;
	private SolverStats stats;
	private SymbolTables symbols;
	
	public JaCoPSolver(SymbolTables symbols) {
		this.store = new Store();
		this.stats = new SolverStats();
		this.symbols = symbols;
	}
	
	public List<String[]> solve(int N, int[] ids, Predicate[] predicates)
			throws EugeneException {

    	/*
    	 * create the variables of the constraint solving problem
    	 * i.e. the parts
    	 */
    	IntVar[] variables = this.model(N, ids);

    	/*
    	 * map the Eugene rules onto JaCoP constraints
    	 */
    	if(null != predicates) {
    		this.imposeConstraints(variables, predicates);
    	}
    	
    	/*
    	 * for testing: print the store's information
    	 */
//    	store.print();
    	
    	/*
    	 * now, let's solve the problem
    	 */
    	Domain[][] solutions = this.search(variables);
    	
    	/*
    	 * finally, we process and return the solutions
    	 */
//    	return null;
    	if(null != solutions) {
    		try {
    			return this.processSolutions(solutions);
    		} catch(java.lang.OutOfMemoryError e) {
    			throw new EugeneException("I'm sorry! This problem is currently too big for me to solve!");
    			
    		}
    	} 
    	return null;
	}
    
	public IntVar[] model(int N, int[] ids) {
		IntVar[] variables = new IntVar[N];
		for(int i=0; i<N; i++) {
			variables[i] = new IntVar(store, "X"+i);
			for(int j=0; j<ids.length; j++) {
				variables[i].addDom(ids[j], ids[j]);
			}
		}
		return variables;
	}

	public void imposeConstraints(IntVar[] variables, Predicate[] predicates) 
			throws EugeneException {
		for(int i=0; i<predicates.length; i++) {
			try {
				store.impose(predicates[i].toJaCoP(this.store, variables));
			} catch(Exception e) {
				throw new EugeneException("I cannot impose "+predicates[i]);
			}
		}
	}
	
    private Domain[][] search(IntVar[] variables) 
    		throws EugeneException {
    	Search<IntVar> search = new DepthFirstSearch<IntVar>(); 

        SelectChoicePoint<IntVar> select = new SimpleSelect<IntVar>(
							variables, 
							new MostConstrainedDynamic<IntVar>(), 
							new IndomainSimpleRandom<IntVar>());  

        /*
         * we want to find ALL solutions
         */
        search.getSolutionListener().searchAll(true);   
        search.setPrintInfo(false);
        search.getSolutionListener().recordSolutions(true);
                
		try {
			/*
			 * search the solutions
			 */
			search.labeling(store, select);
		} catch(OutOfMemoryError oome) {
			throw new EugeneException("I'm sorry! This problem is currently too big for me to solve!");
		} catch(Exception e) {
			e.printStackTrace();
		}

		/*
		 * return the solutions
		 */
		return search.getSolutionListener().getSolutions();
    }

		
	public List<String[]> processSolutions(Domain[][] solutions) {

		List<String[]> lst = new ArrayList<String[]>();
		for(int i=0; i<solutions.length && solutions[i]!=null; i++) {
			
			Domain[] solution = solutions[i];
			String[] sol = new String[solution.length];
			for(int j=0; j<solution.length; j++) {
				ValueEnumeration ve = solution[j].valueEnumeration();
				while(ve.hasMoreElements()) {
					sol[j] = this.symbols.get(ve.nextElement());
				}
			}
			
			lst.add(sol);
		}
		return lst;
	}
    
}
