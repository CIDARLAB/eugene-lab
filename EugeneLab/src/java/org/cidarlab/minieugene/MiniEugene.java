/*
Copyright (c) 2012 Boston University.
All rights reserved.
Permission is hereby granted, without written agreement and without
license or royalty fees, to use, copy, modify, and distribute this
software and its documentation for any purpose, provided that the above
copyright notice and the following two paragraphs appear in all copies
of this software.

IN NO EVENT SHALL BOSTON UNIVERSITY BE LIABLE TO ANY PARTY
FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES
ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
BOSTON UNIVERSITY HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

BOSTON UNIVERSITY SPECIFICALLY DISCLAIMS ANY WARRANTIES,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND BOSTON UNIVERSITY HAS
NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES,
ENHANCEMENTS, OR MODIFICATIONS.
 */

package org.cidarlab.minieugene;

import java.net.URI;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.cidarlab.minieugene.constants.EugeneConstants;
import org.cidarlab.minieugene.constants.EugeneRules;
import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.predicates.LogicalNot;
import org.cidarlab.minieugene.predicates.Predicate;
import org.cidarlab.minieugene.solver.jacop.JaCoPSolver;
import org.cidarlab.minieugene.stats.EugeneStatistics;
import org.cidarlab.minieugene.symbol.SymbolTables;

public class MiniEugene {

	/*
	 * we need a reference to the symbol tables
	 */
	private SymbolTables symbols;
	private PredicateBuilder pb;
	
	private static boolean TEST_MODE = true;
	
	/*
	 * N ... length/size of the design
	 */
	private int N;
	private int NR_OF_SOLUTIONS;
	
	public MiniEugene(int N, int NR_OF_SOLUTIONS, boolean usePredefined) {
		this.symbols = new SymbolTables();
		this.pb = new PredicateBuilder();
		
		this.N = N;
		this.NR_OF_SOLUTIONS = NR_OF_SOLUTIONS;
		
		/*
		 * use our predefined symbols
		 */
		if(usePredefined) {
			this.symbols.put("p");
			this.symbols.put("r");
			this.symbols.put("c");
			this.symbols.put("t");
		}

	}
	
	/*
	 * return .. a set of URIs that point to the pigeon images
	 */
	public MiniEugeneReturn execute(String script) 
			throws EugeneException {

		if(script == null || script.isEmpty()) {
			throw new EugeneException("please provide some input!");
		}
		
		EugeneStatistics stats = new EugeneStatistics();		
		Set<URI> imageUris = null;
		List<String[]> solutions = null;
		
		/*
		 * we parse the received string line by line
		 */
		String[] lines = script.split(System.getProperty("line.separator"));
		
		if(lines.length>0) {
			
			Predicate[] predicates = this.parsePredicates(lines);

			try {
				/*
				 * finally, we solve the problem
				 */
				int[] symbolIds = this.symbols.getIds();
				if(null == symbolIds || symbolIds.length==0) {
					throw new EugeneException("no solutions found!");
				}

				stats.add("Number of Parts", symbolIds.length);
				stats.add("Possible Solutions", Math.pow(symbolIds.length, this.N));
				stats.add("Number of Rules", predicates.length);
				
				/*
				 * SOLUTION FINDING
				 */
				long T1 = System.nanoTime();
				solutions = new JaCoPSolver(this.symbols).solve(N, symbolIds, predicates);
				long T2 = System.nanoTime();
				stats.add(EugeneConstants.SOLUTION_FINDING_TIME, (T2-T1)*Math.pow(10, -9));
				stats.add(EugeneConstants.NUMBER_OF_SOLUTIONS, solutions.size());

				
				if(null == solutions || solutions.size()==0) {
					throw new EugeneException("no solutions found!");
				} else if(!TEST_MODE) {	
					long T3 = System.nanoTime();
					if(solutions.size() > 100) {
						imageUris = new SolutionExporter().pigeonizeSolutions(solutions, 100);
					} else {
						imageUris = new SolutionExporter().pigeonizeSolutions(solutions, solutions.size());
					}
					long T4 = System.nanoTime();
					stats.add("Solution Visualization Time", (T4-T3)*Math.pow(10, -9));
				}
			} catch(Exception e) {
				throw new EugeneException(e.getMessage());
			}
				
		}		
		
		/*
		 * for testing, we print the symbol tables
		 */
//		this.symbols.print();
		
		return new MiniEugeneReturn(imageUris, solutions, stats);
	}
	
	/*
	 * N = ( <number> | '*' )
	 */
	public int parseN(String line) 
			throws EugeneException {

		String[] s = line.split("=");
		if(s.length != 2 || !("N".equalsIgnoreCase(s[0].trim()))) {
			throw new EugeneException("invalid N");
		}
		
		if(!"*".equalsIgnoreCase(s[1].trim())) {
			try {
				return Integer.valueOf(s[1].trim());			
			} catch(NumberFormatException nfe) {
				throw new EugeneException("invalid N");
			}
		}
		
		return -1;
	}

	
	/*
	 * INTERPRETER - RELATED METHODS
	 */
	private Predicate interpreteRule(String[] tokens) 
			throws EugeneException {
		
		switch(tokens.length) {
		case 2:
			/*
			 * unary rule
			 */
			return createUnaryPredicate(tokens[0], tokens[1]);
		case 3:
			/*
			 * binary rule
			 * or
			 * negated unary rule
			 */
			if("NOT".equalsIgnoreCase(tokens[0])) {
				return new LogicalNot(createUnaryPredicate(tokens[1], tokens[2]));
			}
			return createBinaryPredicate(tokens[0], tokens[1], tokens[2]);
		case 4:
			/*
			 * negated binary rule
			 */
			if("NOT".equalsIgnoreCase(tokens[0]) && !("NOT".equalsIgnoreCase(tokens[1]))) {
				return new LogicalNot(createBinaryPredicate(tokens[1], tokens[2], tokens[3]));
			}
		default:
			throw new EugeneException("Invalid Rule!");
		}
	}
	
	private Predicate createUnaryPredicate(String p, String s) 
			throws EugeneException {

		if(EugeneRules.isUnaryRule(p)) {
			/*
			 * get the id from the symbol
			 */
			int id = -1;
			if(this.symbols.contains(s)) {
				id = this.symbols.getId(s);
			} else {
				/*
				 * if the symbol does not exist, 
				 * then add it to the symbol tables
				 */
				id = this.symbols.put(s);
			}

			/*
			 * build the predicate (by the predicate builder)
			 * and store it in the symbol tables
			 */
			return this.pb.buildUnary(p, id);
		}
		
		throw new EugeneException("Invalid rule!");		
	}

	
	private Predicate createBinaryPredicate(String a, String X, String b) 
			throws EugeneException {
		
		if("NOT".equalsIgnoreCase(a)) {
			/*
			 * negated unary rule
			 * e.g. NOT CONTAINS a
			 */
			return this.pb.buildNegatedUnary(X, this.symbols.getId(b));
		}
		
		/*
		 * get a's id from the symbol
		 */
		int idA = this.symbols.getId(a);
		int idB = -1;
		if(EugeneRules.isCountingRule(X)) {
			
			/*
			 * b must be a decimal non-negative number
			 */
			try {
				idB = Integer.parseInt(b);
			} catch(Exception e) {
				throw new EugeneException("Invalid rule!");
			}

			/*
			 * 	0 <= b <= N
			 */
			if(idB < 0 || idB > this.N) {
				throw new EugeneException("Invalid rule!");
			}
			
		} else if(EugeneRules.isPositionalRule(X) ||
				EugeneRules.isPairingRule(X)) {
			
			idB = this.symbols.getId(b);

		}

		/*
		 * build the predicate (by the predicate builder)
		 * and store it in the symbol tables
		 */
		if( idB != (-1)) {
			return this.pb.buildBinary(idA, X, idB);
		}
		
		throw new EugeneException("Invalid rule!");
	}
	
	/*
	 * PARSING - RELATED METHODS
	 */
	public Predicate[] parsePredicates(String[] lines) 
			throws EugeneException {
		/*
		 * the first line needs to be the N line
		 */
		Predicate[] predicates = null;
		int i=0;
		try {
			
			/*
			 * if there was no N provided, then N
			 * is specified in the first line
			 */
			if(this.N == -1) {
				this.N = parseN(lines[i++]);
			}
			
			for(; i<lines.length; i++) {
				lines[i] = lines[i].trim();

				if (! (lines[i].startsWith("//") || lines[i].isEmpty())) {
					predicates = addPredicate(predicates, 
							interpreteRule(parseRule(lines[i])));
				}
			}
			
		} catch(Exception e) {
			throw new EugeneException("line "+(i+1)+" => "+e.getMessage());
		}

		return predicates;
	}
	
	private Predicate[] addPredicate(Predicate[] predicates, Predicate predicate) {
		if(predicates == null) {
			predicates = new Predicate[1];
			predicates[0] = predicate;
		} else {
			predicates = ArrayUtils.add(predicates, predicate);
		}
		
		return predicates;
	}
	
	/*
	 * (NOT)? <symbol> <predicate> <symbol>
	 * 
	 * <symbol>    := {p, r, g, t}
	 * <predicate> := {CONTAINS, NOTCONTAINS}
	 */
	private String[] parseRule(String line) 
			throws EugeneException {
		String[] s = line.split(" ");

		String[] tokens = null;
		
		// remove possible white spaces
		for(int i=0; i<s.length; i++) {
			s[i].trim();
			if(s[i] != null && !(s[i].isEmpty())) {
				
				if(null == tokens) {
					tokens = new String[1];
					tokens[0] = s[i];
				} else {
					tokens = ArrayUtils.add(tokens, s[i]);
				}
			}
		}
		
		if(null == tokens) {
			throw new EugeneException("Invalid Rule! "+line);
		}
		
		return tokens;
	}

}
