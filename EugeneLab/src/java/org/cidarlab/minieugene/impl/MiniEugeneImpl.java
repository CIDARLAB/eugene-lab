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

package org.cidarlab.minieugene.impl;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.cidarlab.minieugene.MiniEugene;
import org.cidarlab.minieugene.MiniEugeneReturn;
import org.cidarlab.minieugene.PredicateBuilder;
import org.cidarlab.minieugene.SolutionExporter;
import org.cidarlab.minieugene.constants.EugeneConstants;
import org.cidarlab.minieugene.constants.EugeneRules;
import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.predicates.LogicalNot;
import org.cidarlab.minieugene.predicates.Predicate;
import org.cidarlab.minieugene.predicates.direction.AllForward;
import org.cidarlab.minieugene.predicates.direction.AllReverse;
import org.cidarlab.minieugene.rules.RuleOperator;
import org.cidarlab.minieugene.solver.jacop.JaCoPSolver;
import org.cidarlab.minieugene.stats.EugeneStatistics;
import org.cidarlab.minieugene.symbol.Symbol;
import org.cidarlab.minieugene.symbol.SymbolTables;
import org.sbolstandard.core.SBOLDocument;

public class MiniEugeneImpl 
		implements MiniEugene {
	
	/*
	 * reference to the symbol tables
	 */
	private SymbolTables symbols;
	private PredicateBuilder pb;
	
	private static boolean TEST_MODE = false;
	
	private int N;
	private int NR_OF_SOLUTIONS;
	
	private EugeneStatistics stats;		
	private List<Symbol[]> solutions;

	public MiniEugeneImpl() {
		this.symbols = new SymbolTables();
		this.pb = new PredicateBuilder(this.symbols);
		this.stats = new EugeneStatistics();
		this.solutions = null;
	}
	
	/*
	 * return .. a set of URIs that point to the pigeon images
	 */
	@Override
	public MiniEugeneReturn execute(String script, int N, int NR_OF_SOLUTIONS) 
			throws EugeneException {

		if(script == null || script.isEmpty()) {
			throw new EugeneException("please provide some input!");
		}
		
		this.N = N;
		this.NR_OF_SOLUTIONS = NR_OF_SOLUTIONS;
		
		EugeneStatistics stats = new EugeneStatistics();		
		Set<URI> imageUri = new HashSet<URI>();
		List<Symbol[]> solutions = null;
		SBOLDocument sbol = null;
		
		/*
		 * we parse the received string line by line
		 */
		String[] lines = script.split(System.getProperty("line.separator"));
		
		if(lines.length>0) {
			
			/*
			 * parsing
			 */
			Predicate[] predicates = this.parsePredicates(lines);
			
			
			/*
			 * solving
			 */
			try {
				Symbol[] symbols = this.symbols.getSymbols();
				if(null == symbols || symbols.length==0) {
					throw new EugeneException("no solutions found!");
				}

				stats.add("Number of Parts", symbols.length);
				stats.add("Possible Solutions", Math.pow(symbols.length, this.N) * Math.pow(2, this.N));
				stats.add("Number of Rules", predicates.length);
				
				/*
				 * SOLUTION FINDING
				 */
				long T1 = System.nanoTime();
				solutions = new JaCoPSolver(this.symbols).solve(this.N, symbols, predicates, this.NR_OF_SOLUTIONS);
				long T2 = System.nanoTime();

				/*
				 * next, we iterate over the predicates and check if there are any
				 * SOME_REVERSE directionality predicates
				 */
				stats.add(EugeneConstants.SOLUTION_FINDING_TIME, (T2-T1)*Math.pow(10, -9));
				
				if(null == solutions || solutions.size()==0) {
					throw new EugeneException("no solutions found!");
				} else if(!TEST_MODE) {	
					long T3 = System.nanoTime();
					
					
					/*
					 * for the time being, we only visualize max. 40 (randomly chosen) solution
					 * using pigeon
					 */
					
					// we need to give the set of interactions as
					// input to the SolutionExporter
					if(null != solutions) {
						SolutionExporter se = new SolutionExporter(solutions, this.symbols.getInteractions());
						
						/*
						 * PIGEONIZATION
						 */
						imageUri.add(se.pigeonizeSolutions());

						/*
						 * SBOL EXPORT
						 */
						sbol = se.sbolExport();
					}
					long T4 = System.nanoTime();
					
					stats.add("Solution Visualization Time [sec]", (T4-T3)*Math.pow(10, -9));
					stats.add(EugeneConstants.NUMBER_OF_SOLUTIONS, solutions.size());
					

				} else if (TEST_MODE) {
					stats.print();
				}
				
			} catch(Exception e) {
				e.printStackTrace();
				throw new EugeneException(e.getMessage());
			}
				
		}		
		
		/*
		 * for testing, we print the symbol tables
		 */
		//this.symbols.print();
		
		return new MiniEugeneReturn(imageUri, solutions, stats, sbol);
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
		case 1:
			/*
			 * PREDICATES w/o a rule operand
			 * e.g. ALL_REVERSE
			 */
			return createPredicate(tokens[0]);
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
	
	private Predicate createPredicate(String s) 
			throws EugeneException {
		return this.pb.buildPredicate(s);
	}
	
	private Predicate createUnaryPredicate(String p, String s) 
			throws EugeneException {

		if("NOT".equalsIgnoreCase(p)) {
			
			if(RuleOperator.ALL_REVERSE.toString().equalsIgnoreCase(s)) {
				return new LogicalNot(new AllReverse(-1));
			} else if(RuleOperator.ALL_FORWARD.toString().equalsIgnoreCase(s)) {
				return new LogicalNot(new AllForward(-1));
			}

			
		} else if(EugeneRules.isUnaryRule(p)) {
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
		} else if(RuleOperator.EQUALS.toString().equalsIgnoreCase(X) ||
				RuleOperator.NOTEQUALS.toString().equalsIgnoreCase(X)) {
				
			if(!(a.startsWith("[") && a.endsWith("]") &&
				 b.startsWith("[") && b.endsWith("]"))) {
				throw new EugeneException("Invalid "+X+" rule!");
			}
			
			
			/*
			 * next, we need to get the index out of the strings a and b
			 */
			a = a.substring(1, a.length()-1);
			b = b.substring(1, b.length()-1);
			
			int idxA = this.toIndex(a);
			int idxB = this.toIndex(b);
			
			return this.pb.buildBinary(idxA, X, idxB);
			
		} else if(EugeneRules.isInteractionRule(X)) {
			
			return this.pb.buildInteraction(a, X, b);
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
				throw new EugeneException("Invalid index! "+idB);
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
			 * MUST be specified in the first line
			 */
			if(this.N == -1) {
				this.N = parseN(lines[i++]);
			}
			
			for(; i<lines.length; i++) {
				lines[i] = lines[i].trim();

				if (! (lines[i].startsWith("//") || lines[i].isEmpty())) {
					Predicate p = interpreteRule(parseRule(lines[i]));
					predicates = addPredicate(predicates, p);
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

	private int toIndex(String a) 
			throws EugeneException {

		int idx = -1;
		try {
			idx = Integer.parseInt(a);
		} catch(NumberFormatException nfe) {
			throw new EugeneException("Invalid index!");
		}

		if(idx < 0 || idx >= this.N) {
			throw new EugeneException("Index "+idx+" is out of range!");
		}
		
		return idx;
	}

	@Override
	public List<Symbol[]> solve(String[] rules, int N, int NR_OF_SOLUTIONS) 
			throws EugeneException {

		/*
		 * parsing
		 */
		Predicate[] predicates = this.parsePredicates(rules);
		
		
		/*
		 * solving
		 */
		try {
			Symbol[] symbols = this.symbols.getSymbols();
			if(null == symbols || symbols.length==0) {
				throw new EugeneException("no solutions found!");
			}

			stats.add("Number of Parts", symbols.length);
			stats.add("Possible Solutions", Math.pow(symbols.length, N) * Math.pow(2, N));
			stats.add("Number of Rules", predicates.length);
			
			long T1 = System.nanoTime();
			/*
			 * SOLUTION FINDING
			 */
			solutions = new JaCoPSolver(this.symbols).solve(N, symbols, predicates, NR_OF_SOLUTIONS);
			long T2 = System.nanoTime();

			stats.add(EugeneConstants.SOLUTION_FINDING_TIME, (T2-T1)*Math.pow(10, -9));
			
			if(null == solutions || solutions.size()==0) {
				throw new EugeneException("no solutions found!");
			}
			
			stats.add(EugeneConstants.NUMBER_OF_SOLUTIONS, solutions.size());
		
		} catch(Exception e) {
			throw new EugeneException(e.getMessage());
		}

		return solutions;
	}

	@Override
	public List<Symbol[]> solve(String[] rules, int N) 
			throws EugeneException {
		/*
		 * find ALL solutions
		 */
		return this.solve(rules, N, -1);
	}
	
	@Override
	public void clear() {
		if(null != this.symbols) {
			this.symbols.clear();
		}
	}
}
