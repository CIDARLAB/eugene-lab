package org.cidarlab.minieugene.solver.jacop;

import java.util.ArrayList;
import java.util.List;

import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.predicates.Predicate;
import org.cidarlab.minieugene.solver.Solver;
import org.cidarlab.minieugene.symbol.Symbol;
import org.cidarlab.minieugene.symbol.SymbolTables;

import JaCoP.constraints.Constraint;
import JaCoP.constraints.And;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.core.Domain;
import JaCoP.core.IntVar;
import JaCoP.core.Store;
import JaCoP.core.ValueEnumeration;
import JaCoP.search.DepthFirstSearch;
import JaCoP.search.IndomainSimpleRandom;
import JaCoP.search.MostConstrainedDynamic;
import JaCoP.search.Search;
import JaCoP.search.SelectChoicePoint;
import JaCoP.search.SimpleSelect;


public class JaCoPSolver 
		implements Solver {

	private Store store;
	private SymbolTables symbols;
	
	public JaCoPSolver(SymbolTables symbols) {
		this.store = new Store();
		this.symbols = symbols;
	}
	
	public List<Symbol[]> solve(int N, int[] ids, Predicate[] predicates)
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
    
	public IntVar[] model(int N, int[] ids) 
			throws EugeneException {
		/**
		if(Math.pow(ids.length, N) > Math.pow(10, 7)) {
			throw new EugeneException("I'm sorry! This problem is currently too big for me to solve!");
		}
		**/
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
				Constraint constraint = predicates[i].toJaCoP(this.store, variables);
				if(constraint != null) {
					if(constraint instanceof And) {
						for(PrimitiveConstraint pc : ((And)constraint).listOfC) {
							store.imposeWithConsistency(pc);
						}
					} else {
						store.impose(constraint);
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
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

        //search.getSolutionListener().setSolutionLimit(1);

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

		
	public List<Symbol[]> processSolutions(Domain[][] solutions) {

		List<Symbol[]> lst = new ArrayList<Symbol[]>();
		for(int i=0; i<solutions.length && solutions[i]!=null; i++) {
			
			Domain[] solution = solutions[i];
			Symbol[] sol = new Symbol[solution.length];
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
