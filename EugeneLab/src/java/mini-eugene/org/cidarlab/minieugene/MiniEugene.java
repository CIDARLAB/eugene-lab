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
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.cidarlab.minieugene.constants.EugeneRules;
import org.cidarlab.minieugene.data.pigeon.Pigeonizer;
import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.predicates.Predicate;
import org.cidarlab.minieugene.solver.jacop.JaCoPSolver;
import org.cidarlab.minieugene.symbol.SymbolTables;

import JaCoP.core.Domain;
import JaCoP.core.ValueEnumeration;

public class MiniEugene {

	/*
	 * we need a reference to the symbol tables
	 */
	private SymbolTables symbols;
	private PredicateBuilder pb;
	
	/*
	 * N ... length/size of the design
	 */
	private int N;
	
	public MiniEugene(boolean usePredefined) {
		this.symbols = new SymbolTables();
		this.pb = new PredicateBuilder();
		
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
	public Set<URI> execute(String script, int nrOfSolutions) 
			throws EugeneException {

		if(script == null || script.isEmpty()) {
			throw new EugeneException("please provide some input!");
		}
		
		/*
		 * we parse the received string line by line
		 */
		String[] lines = script.split(System.getProperty("line.separator"));
		
		if(lines.length>0) {
			/*
			 * the first line needs to be the N line
			 */
			int i=0;
			try {
				
				/*
				 * PARSING
				 */
				this.N = parseN(lines[i++]);
				Predicate[] predicates = null;
				for(; i<lines.length; i++) {
					if (! (lines[i].startsWith("//") || lines[i].isEmpty())) {
						if(predicates == null) {
							predicates = new Predicate[1];
							predicates[0] = parseRule(lines[i]);
						} else {
							predicates = ArrayUtils.add(predicates, parseRule(lines[i]));
						}
					}
				}
				
				/*
				 * finally, we solve the problem
				 */
				int[] symbolIds = this.symbols.getIds();
				if(null == symbolIds || symbolIds.length==0) {
					throw new EugeneException("no solutions found!");
				}
				
//				System.out.println("symbolIds -> "+Arrays.toString(symbolIds));
				
				/*
				 * SOLUTION FINDING
				 */
				List<String[]> solutions = new JaCoPSolver(this.symbols).solve(N, symbolIds, predicates);

				if(null == solutions || solutions.isEmpty()) {
					throw new EugeneException("no solutions found!");
				} else {				
					return new SolutionExporter().exportSolutions(solutions, nrOfSolutions);
				}
				
			} catch(Exception e) {
				throw new EugeneException("line "+i+" => "+e.getMessage());
			}
		}		
		
		/*
		 * for testing, we print the symbol tables
		 */
//		this.symbols.print();
		
		return null;
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
	 * (NOT)? <symbol> <predicate> <symbol>
	 * 
	 * <symbol>    := {p, r, g, t}
	 * <predicate> := {CONTAINS, NOTCONTAINS}
	 */
	private Predicate parseRule(String line) 
			throws EugeneException {
		String[] s = line.split(" ");

		switch(s.length) {
		case 2:
			/*
			 * unary rule
			 */
			return createUnaryPredicate(s[0], s[1]);
		case 3:
			/*
			 * binary rule
			 * or
			 * negated unary rule
			 */
			return createBinaryPredicate(s[0], s[1], s[2]);
		case 4:
			/*
			 * negated binary rule
			 */
			break;
		default:
			throw new EugeneException("Invalid Rule!");
		}
		
		return null;
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
		
		throw new EugeneException("Invalid rule predicate!");		
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
	
}
