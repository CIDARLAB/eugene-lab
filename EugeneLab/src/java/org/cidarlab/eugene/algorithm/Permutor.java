package org.cidarlab.eugene.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;
import org.cidarlab.eugene.builder.EugeneBuilder;
import org.cidarlab.eugene.cache.SymbolTables;
import org.cidarlab.eugene.dom.NamedElement;
import org.cidarlab.eugene.dom.arrays.PermutedDeviceArray;
import org.cidarlab.eugene.dom.components.Device;
import org.cidarlab.eugene.dom.rules.Rule;
import org.cidarlab.eugene.exception.EugeneException;
import org.cidarlab.eugene.rules.RuleEngine;
import org.cidarlab.eugene.rules.tree.predicate.After;
import org.cidarlab.eugene.rules.tree.predicate.Before;
import org.cidarlab.eugene.rules.tree.predicate.BinaryPredicate;
import org.cidarlab.eugene.rules.tree.predicate.Contains;
import org.cidarlab.eugene.rules.tree.predicate.EndsWith;
import org.cidarlab.eugene.rules.tree.predicate.NextTo;
import org.cidarlab.eugene.rules.tree.predicate.Predicate;
import org.cidarlab.eugene.rules.tree.predicate.StartsWith;
import org.cidarlab.eugene.rules.tree.predicate.Then;
import org.cidarlab.eugene.rules.tree.predicate.UnaryPredicate;
import org.cidarlab.eugene.rules.tree.predicate.With;



public class Permutor {
	
	public static long fact(long n){
	    if (n <= 1) {
	        return 1;
	    } 
	    return n * fact(n-1);
	}
	
	/***************/
	/** TEST ONLY **/
	/* we return the generated devices ... */ 
	public static PermutedDeviceArray permute(long[] elements, List<Rule> lstRules) 
			throws EugeneException {
		
		if(null != lstRules) {
			
			/** CONTAINS Rule **/
			/* if there's a CONTAINS rule and the device does NOT contain 
			 * the bound element, then don't even start to pre-process and/or permute
			 */
			List<Rule> lstPositionalRules = new ArrayList<Rule>();
			for(Rule rule : lstRules) {
				Predicate predicate = rule.getPredicate();
				if(predicate instanceof After ||
						predicate instanceof Before ||
						predicate instanceof NextTo ||
						predicate instanceof StartsWith ||
						predicate instanceof EndsWith) {
					lstPositionalRules.add(rule);
				} else if(predicate instanceof Contains ||
						predicate instanceof With ||
						predicate instanceof Then) {
					// evaluate the rule
					if(!RuleEngine.evaluatePermute(rule, elements)) {
						throw new EugeneException("RULE VIOLATION! "+predicate.toString()+" violates "+Arrays.toString(elements));
					}
				}
			}
			
			//System.err.println("do the CONTAINS rule...");

			// now, we need to get the rules ...
//			if(!lstPositionalRules.isEmpty()) {
//				System.out.println("[Permutor.permute] and I'm gonna include the following POSITIONAL rules: ");
//				for(Rule rule : lstPositionalRules) {
//						System.out.println(rule.toString());
//				}
//			}				

			long[][] permutations = constraint_permute(elements, lstPositionalRules);
			
//			for(int i=0; i<permutations.length; i++) {
//				System.out.println(Arrays.toString(permutations[i]));
//			}			
			
			/***
			// now, we can create all possible combinations						
			long[][] valid_combinations = create_possible_combinations(elements, hmIndices, lstRules);
			***/
			//System.out.println("and here are all my valid combinations: ");

			return EugeneBuilder.buildPermutedDeviceArray(
					null, permutations);
		}
		
		return null;
	}
	/***************/

	public static PermutedDeviceArray permute(String sDeviceName) 
			throws EugeneException {
				
		NamedElement objElement = SymbolTables.get(sDeviceName);
		Device device = null;
		if(null != objElement && objElement instanceof Device) {
			device = (Device)objElement;
		} else {
			throw new EugeneException(sDeviceName+" is not a Device!");
		}

		//nDeviceId = SymbolTables.getId(sDeviceName);				
		long[] elements = SymbolTables.getDeviceComponentIds(sDeviceName);
		System.out.println("[Permutor.permute] I'm gonna permute : "+Arrays.toString(elements));
		
		// now, we need to get the rules ...
		List<Rule> lstRules = SymbolTables.getDeviceRules(sDeviceName);
//		if(null != lstRules && !lstRules.isEmpty()) {
//			System.out.println("[Permutor.permute] and I'm gonna include the following rules: ");
//			for(Rule rule : lstRules) {
//				System.out.println(rule.toString());
//			}				
//		}

		/* here we can also do further calculations to figure out 
		 * how long permuting would take...
		 */
		if(elements.length > 12 && lstRules.isEmpty()) {
			long X = fact(elements.length);
			if(X<0) {
				throw new EugeneException (
							"WARNING! NO RULES SPECIFIED!"+System.getProperty("line.separator")+
							"I'm NOT gonna permute. This would take up too much time!");
			}
			
			double ms = X/Math.pow(10, -3);
			double sec = ((ms * Math.pow(10, -9))/3600);
			
			System.err.println("WARNING! NO RULES SPECIFIED!");
			System.err.println("I'm gonna create "+fact(elements.length)+" devices. This will take up to "+sec+" hours.");
			System.err.println("Do you want to continue? (y/n) ");
			
			Scanner sc = new Scanner(System.in);
			String s = sc.next();
			do {
			} while("n".equalsIgnoreCase(s) || "no".equalsIgnoreCase(s) || "y".equalsIgnoreCase(s) || "yes".equalsIgnoreCase(s));
			
			if("n".equalsIgnoreCase(s) || "no".equalsIgnoreCase(s)) {
				return null;
			}
		}

		long[][] permutations = null;
		if(null != lstRules && !lstRules.isEmpty()) {
			 permutations = constraint_permute(elements, lstRules);
		} else {
			perms = null;
			// let's do a Heap permute
			heap_permute(elements, elements.length);
			
			permutations = perms;
//			System.out.println("[Permutor.permute] -> "+permutations.length+" permutations");
		}
//		for(int i=0; i<permutations.length; i++) {
//			System.out.println(Arrays.toString(permutations[i]));
//		}			

		return EugeneBuilder.buildPermutedDeviceArray(
				device, permutations);
		
	}

	private static long[][] perms;
	
	private static void heap_permute(long[] elements, int n) {
		if (n==1) {
			/** here we need to create the device **/
			if(perms == null) {
				perms = new long[1][elements.length];
				perms[0] = ArrayUtils.clone(elements);
			} else {
				perms = ArrayUtils.add(perms, ArrayUtils.clone(elements));
			}
		} else {
			for (int i=0; i<n; i++) {
				heap_permute(elements, n-1);
				if (n%2 == 1) {
					elements = swap(elements, 0, n-1);
				} else {
					elements = swap(elements, i, n-1);
				}
			}
		}
	}
	
	private static long[] swap(long[] elements, int i, int j) {
		long tmp = elements[i];
		elements[i] = elements[j];
		elements[j] = tmp;
		return elements;
	}
	/* here we need to do some preprocessing...
	 * 1. for permute, only STRUCTURAL/POSITIONAL rules are important ... 
	 *    all other rules can be ignored ...
	 *    i.e. sort out the list of rules ... 
	 * 
	 *  
	 * 2. on STRUCTURAL/POSITIONAL rules we can prepare the list of elements a bit already ...  
	 * - D STARTSWITH B  ... prepare the device that it start's with B
	 * - D CONTAINS B    ... if D does not contain B, then return immediately false
	 * - ON D: A AFTER B ... if D does not contain A or B, then return immediately
	 * 
	 * Conclusions:
	 * - we must check if A and B are present in D (i.e. CONTAINS)
	 * - ...
	 * 
	 */
	private static long[][] constraint_permute(long[] elements, List<Rule> lstRules) 
			throws EugeneException {
		
		int N = elements.length;
		
		/*
		 * the hmIndices hashmap 
		 * keys   ... the position (i.e. the indices where elements can be placed) 
		 * values ... a list of indices where the element can be placed
		 * 
		 * Example: N = 5 and two (2) rules (A BEFORE B and B NEXTTO A)
		 * 
		 * hmIndices
		 * 0   ->   [A, B, C]
		 * 1   ->   [B]
		 * 2
		 * ...
		 * N-1 ->   [X, Y, Z]
		 */

		/** PRUNE THE NUMBER OF INDICES FOR EACH ELEMENT FOR EVERY RULE **/		
		boolean[][] position_matrix = calculate_position_matrix(elements, lstRules);
		
//		System.out.println("here is my position matrix: ");
//		for(int i=0; i<N; i++) {
//			
//			System.out.print("position "+i+" -> [");
//			for(int j=0; j<N; j++) {
//				if(position_matrix[i][j] == true) {
//					System.out.print(elements[j]+", ");
//				}
//			}
//			System.out.println("]");
//		}
		
		/* now, we create all possible combinations of the position matrix */
		/* -> cartesian product ?? */
		
		/* we evaluate all possible combination against the rules
		 * -> this is currently needed, since the calculation of the position_matrix 
		 * does not work properly :(
		 */
		long[][] valid_combinations = create_valid_combinations(elements, lstRules, position_matrix);
//		for(int i=0; i<valid_combinations.length; i++) {
//			System.out.println(Arrays.toString(valid_combinations[i]));
//		}			
		return valid_combinations;
	}
    
	private static long[][] create_valid_combinations(
			long[] elements, List<Rule> lstRules, boolean[][] position_matrix) 
				throws EugeneException {
		
		int N = elements.length;
		
    	/* now, we're creating all possible combinations without duplicates */		
		List<List<Long>> lll = new ArrayList<List<Long>>();
		for(int i=0; i<N; i++) {
			List<Long> ll = new ArrayList<Long>();
			
			for(int j=0; j<N; j++) {
				if(position_matrix[i][j] == true) {
					ll.add(Long.valueOf(elements[j]));
				}
			}

			lll.add(ll);
		}

		/* let's create a graph of the positioning matrix */
		valid_permutations = new long[1][N];
		current_elements = new long[N];
		create_permutations(lll, 0, N, lstRules);
		valid_permutations = ArrayUtils.remove(valid_permutations, 0);
		
		return valid_permutations;		
	}
	
	private static long[][] valid_permutations;
	private static long[] current_elements;
	
	public static void create_permutations(List<List<Long>> lll, int col, int N, List<Rule> lstRules) 
			throws EugeneException {

		if(col<N) {
			/* take the first element */
			List<Long> ll = lll.get(col);
			for(Long l : ll) {
				current_elements[col] = l.longValue();
				create_permutations(lll, col+1, N, lstRules);
			}
		} else {	
			// check for duplicates
			boolean bDuplicate = false;
			for(int i=0; i<current_elements.length && !bDuplicate; i++) {
				bDuplicate = (-1) != ArrayUtils.indexOf(current_elements, current_elements[i], i+1);
			}

			if(!bDuplicate) {
				if(RuleEngine.evaluate(lstRules, current_elements)) {
//					// check if valid_permutations contains already current_elements
//					boolean bDuplicateFound = false;
//					for(int i=0; i<valid_permutations.length && !bDuplicateFound; i++) {
//						boolean bEquals = true;
//						for(int j=0; j<N && bEquals; j++) {
//							if(valid_permutations[i][j] != current_elements[j]) {
//								bEquals = false;
//							}
//						}
//						if(bEquals) {
//							bDuplicateFound = true;
//						}						
//						System.out.println(Arrays.toString(valid_permutations[i]) + " vs "+Arrays.toString(current_elements));
//					}
//
//					if(!bDuplicateFound) {
						valid_permutations = ArrayUtils.add(valid_permutations, ArrayUtils.clone(current_elements));
//					} else {
//						System.out.println("FOUND A DUPLICATE OF "+Arrays.toString(current_elements));
//					}
				}
			}
		}
	}
    
//    private static boolean containsDuplicates(List<Long> listContainingDuplicates) { 
//    	final Set<Long> set1 = new HashSet<Long>();
//
//    	for (Long l : listContainingDuplicates) {
//    		if (!set1.add(l)) {
//    			return true;
//    		}
//		}
//		return false;
//    }

//    public static void generate(long[][] sets) {
//	    int solutions = 1;
//	    for(int i = 0; i < sets.length; solutions *= sets[i].length, i++);
//	    for(int i = 0; i < solutions; i++) {
//	        int j = 1;
//	        for(long[] set : sets) {
//	            System.out.print(set[(i/j)%set.length] + " ");
//	            j *= set.length;
//	        }
//	        System.out.println();
//	    }
//	}
	
	private static boolean[][] calculate_position_matrix(long[] elements, List<Rule> lstRules) {
		int N = elements.length;
		boolean[][] position_matrix = new boolean[N][N];
		
		/*
		 * the rows in the position matrix represent the positions (i.e i = 0, ..., N-1)
		 * the columns represent the elements (i.e. j = element[0], ..., element[N-1])
		 * 
		 * a cell (i, j) of the position matrix ==
		 * - true if the element element[j] can be placed at position i
		 * - false, otherwise
		 */
		
		// we initialize the position matrix with TRUEs ... 
		// i.e. every element can be placed everywhere
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				position_matrix[i][j] = true;
			}
		}
		
		for(Rule rule : lstRules) {
			Predicate predicate = rule.getPredicate();
			
			if(predicate instanceof StartsWith ||
					predicate instanceof EndsWith) {
				long B = ((UnaryPredicate)predicate).getB();
				
				// get the bitmasks of the predicate				
				int idxB = -1;
				
				// there might be other B's in the elements list too...
				while((-1) != (idxB = ArrayUtils.indexOf(elements, B, idxB+1))) {
					
					if(predicate instanceof StartsWith) {
						for(int i=0; i<N; i++) {
							if(elements[i] != B) {
								position_matrix[0][i] = false;
							}
							position_matrix[i][idxB] = false;
						}
						position_matrix[0][idxB] = true;
					} else if(predicate instanceof EndsWith) {
						for(int i=0; i<N; i++) {
							if(elements[i] != B) {
								position_matrix[N-1][i] = false;
							}
							position_matrix[i][idxB] = false;
						}
						position_matrix[N-1][idxB] = true;
					}
				}
			}		
		}

		/* 
		 * now, we iterate over the rules and AND every ``position'' row 
		 * with the rule's bitmask
		 */
		for(Rule rule : lstRules) {
			Predicate predicate = rule.getPredicate();

			if(predicate instanceof BinaryPredicate) {
				long A = ((BinaryPredicate)predicate).getA();
				long B = ((BinaryPredicate)predicate).getB();
				
				int idxA = ArrayUtils.indexOf(elements, A);
				int idxB = ArrayUtils.indexOf(elements, B);

				//System.out.println(predicate.toString());
				if(idxA == -1 || idxB == -1) {
					break;
				}
				
				if(predicate instanceof After) {
					
					for(int i=N-1; i>=0; i--) {
						
						/* if B can be placed at position i */						
						if(position_matrix[i][idxB]) {
							
							for(int j=0; j<N; j++) {
								/* then A cannot be placed BEFORE B */
								if(j<=i) {
									position_matrix[j][idxA] = false;
									//position_matrix[j][idxB] = position_matrix[j][idxB] & true;
									
								/* but A can be placed AFTER B */
								} else {
									position_matrix[j][idxA] = true;
									
									/* and B cannot be placed AFTER A */
									//position_matrix[j][idxB] = false;									
								}
								
							}
						}
					}
				
				} else if(predicate instanceof Before) {
					for(int i=0; i<N; i++) {
						/* if B can be placed at position i */						
						if(position_matrix[i][idxB]) {
							
							for(int j=0; j<N; j++) {
								/* then A can be placed BEFORE B */
								if(j<i) {
									position_matrix[j][idxA] = true;
									/* and B cannot be placed AFTER A */
									//position_matrix[j][idxB] = false;									

								/* but A cannot be placed AFTER B */
								} else {
									position_matrix[j][idxA] = false;
									//position_matrix[j][idxB] = position_matrix[j][idxB] & true;
								}
							}
						}
					}
				}
			}
		}

		
		for(Rule rule : lstRules) {

			Predicate predicate = rule.getPredicate();
			
			if(predicate instanceof NextTo) {
				long A = ((BinaryPredicate)predicate).getA();
				long B = ((BinaryPredicate)predicate).getB();
				
				int idxA = ArrayUtils.indexOf(elements, A);
				int idxB = ArrayUtils.indexOf(elements, B);
				for(int i=0; i<N; i++) {			
					if(position_matrix[i][idxB] && position_matrix[i][idxA]) {
						position_matrix[i][idxA] = false;
					} else if(!position_matrix[i][idxB] && position_matrix[i][idxA]) {
						if(i>0) {
							position_matrix[i-1][idxB] = true;
						}
						
						position_matrix[i][idxB] = false;
						
						if(i<(N-1)) {
							position_matrix[i+1][idxB] = true;
						}						
					} else if(position_matrix[i][idxB] && !position_matrix[i][idxA]) {
						if(i>0) {
							position_matrix[i-1][idxA] = true;
						}
						
						position_matrix[i][idxA] = false;
						
						if(i<(N-1)) {
							position_matrix[i+1][idxA] = true;
						}
					} else if(!position_matrix[i][idxB] && !position_matrix[i][idxA]) {
						position_matrix[i][idxA] = true;
					}					
				}
			}
		}
		
		for(Rule rule : lstRules) {
			Predicate predicate = rule.getPredicate();
			
			if(predicate instanceof StartsWith ||
					predicate instanceof EndsWith) {
				long B = ((UnaryPredicate)predicate).getB();
				
				// get the bitmasks of the predicate				
				int idxB = -1;
				
				// there might be other B's in the elements list too...
				while((-1) != (idxB = ArrayUtils.indexOf(elements, B, idxB+1))) {
					
					if(predicate instanceof StartsWith) {
						for(int i=0; i<N; i++) {
							if(elements[i] != B) {
								position_matrix[0][i] = false;
							}
							position_matrix[i][idxB] = false;
						}
						position_matrix[0][idxB] = true;
					} else if(predicate instanceof EndsWith) {
						for(int i=0; i<N; i++) {
							if(elements[i] != B) {
								position_matrix[N-1][i] = false;
							}
							position_matrix[i][idxB] = false;
						}
						position_matrix[N-1][idxB] = true;
					}
				}
			}		
		}
		//printMatrix(position_matrix);

		return position_matrix;
	}
	
	/* the getRules() method returns all rules that bind element A */
	private static List<Rule> getRules(long A, List<Rule> lstRules) {
		List<Rule> lstBindingRules = new ArrayList<Rule>();
		for(Rule rule : lstRules) {
			Predicate predicate = rule.getPredicate();
			if(predicate instanceof BinaryPredicate) {
				if(A == ((BinaryPredicate)predicate).getA() ||
						A == ((BinaryPredicate)predicate).getB()) {
					lstBindingRules.add(rule);
				}
			} else if(predicate instanceof UnaryPredicate) {
				if(A == ((BinaryPredicate)predicate).getB()) {
					lstBindingRules.add(rule);
				}
			}
		}
		return lstBindingRules;
	}
	
	private static void printMatrix(boolean[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

	
//	/** THIS IS ALSO JUST FOR TESTING **/
//	/** ULTIMATELY, THIS WILL BE HANDLED IN THE PermutedDeviceArray CLASS **/
//	
//	private static long[][] create_possible_combinations(long[] elements, HashMap<Long, Boolean[]> hmIndices, List<Rule> lstRules) 
//			throws EugeneException {
//
//		/* for every possible combination of the indices, we evaluate all rules **/
//		int N = elements.length;
//
//		/* calculate the number of possible valid combinations */
//		/* and store it in the NR variable */
//		int VC = 1;
//		for(int i=0; i<elements.length; i++) {
//			boolean[] element_bitmask = ArrayUtils.toPrimitive(hmIndices.get(Long.valueOf(elements[i])));
//			if(null != element_bitmask) {
//				int tmp = 0;
//				/* count the 1s */
//				for(int j=0; j<element_bitmask.length; j++) {
//					if(element_bitmask[j] == true) {
//						tmp += 1;
//					}
//				}
//				VC *= tmp;
//			}
//		}
//		
//
//		/* 
//		 * figure out which elements can be placed at what position
//		 */
//		long[][] possible_combinations = new long[1][N];
//		
//		// iterate over all positions
//		for(int i=0; i<N; i++) {
//			
//			// and check which element can be placed in there...
//			long[] elements_at_position = new long[1];
//			for(Long elementId : hmIndices.keySet()) {				
//				boolean[] bitmask = ArrayUtils.toPrimitive(hmIndices.get(Long.valueOf(elementId)));
//				if(bitmask[i] == true) {
//					// place the element into the ``position'' vector
//					elements_at_position = ArrayUtils.add(elements_at_position, elementId.longValue());
//				}
//			}
//			// remove the first element
//			elements_at_position = ArrayUtils.remove(elements_at_position, 0);
//			
//			possible_combinations = ArrayUtils.add(possible_combinations, elements_at_position);
//		}
//		
//		// remove the first element
//		possible_combinations = ArrayUtils.remove(possible_combinations, 0);
//
//		
//		for(int i=0; i<possible_combinations.length; i++) {
//			System.out.println("at position "+i+" the following elements can be placed: "+Arrays.toString(possible_combinations[i]));
//		}
//		return possible_combinations;
//
//		/**
//		CartesianIterable <Integer[]> ci = new CartesianIterable <Integer[]> (lst);		
//		for(List<Integer> device : ci) {
//			System.out.println(ArrayUtils.toString(device));
//			// evaluate the device
//			//if(RuleEngine.evaluate(lstRules, device)) {
//			//	System.out.println(Arrays.toString(device));
//			//}
//		}
//		 **/
//		/* now, we need to build the cartesian product of the positions ... 
//		 * 
//		 */
//		// finally, remove the first element of the possible_combinations
//		// since we've initialized the first row...
//		
////		System.out.println("and here are all my possible combinations...");
////		for(int i=0; i<possible_combinations.length; i++) {
////			System.out.println(Arrays.toString(possible_combinations[i]));
////		}
//		
//		//return null;
//	}
	

//	private static long[][] backup_preprocess(long[] elements, List<Rule> lstRules) 
//			throws EugeneException {
//		
//		int N = elements.length;
//		long[][] possibilities = new long[1][N];
//		
//		/** first, we process all AFTER/BEFORE rules **/
//		
//		/* we iterate over the rules **/
//		for(Rule rule : lstRules) {
//			Predicate predicate = rule.getPredicate();
//
//			if(predicate instanceof BinaryPredicate) {
//				if(possibilities.length > 1) {
//
//					//System.out.println("BEFORE: " + ArrayUtils.toString(possibilities));
//
//					/* here, we need to check if the predicate violates any combination */
//					for(int i=0; i<possibilities.length; i++) {
//						
//						if(!((BinaryPredicate)predicate).evaluate(possibilities[i])) {
//
//							/* here we do some analysis and correction... */
//							
//							/* Example:
//							 * Imagine you're having 
//							 * - this possible combination [1, 2, 0, 0, 0] and
//							 * - a rule saying 2 NEXTTO 5
//							 * 
//							 * now, we can place 5 next to to
//							 * i.e. the resulting array will look like
//							 * [1, 2, 5, 0, 0]
//							 * 
//							 *  Therefore, every binary predicate offers a correct() method...
//							 */
//							long[] tmp = ArrayUtils.clone(possibilities[i]);
//							//System.out.println("I'm trying to correct -> "+Arrays.toString(tmp)+" for predicate "+predicate.toString());
//
//							boolean bCorrected = false;
//							if(predicate instanceof Before) {
//								bCorrected = ((Before)predicate).correct(tmp, elements);
//							} else if(predicate instanceof After) {
//								bCorrected = ((After)predicate).correct(tmp, elements);
//							} else if(predicate instanceof NextTo) {
//								bCorrected = ((NextTo)predicate).correct(tmp, elements);
//							}
//							
//
//							/* doesn't matter what happened, remove the current possible combination */
//							possibilities = ArrayUtils.remove(possibilities, i);
//							i--;
//							
//							/* now, insert the new combination */
//							if(bCorrected) {
//								for(int k=0; k<possibilities.length; k++) {
//									if(ArrayUtils.isEquals(possibilities[k], tmp)) {
//										possibilities = ArrayUtils.remove(possibilities, k);
//										k--;
//										//i--;
//									}
//								}
//
//								//System.out.println("adding -> "+Arrays.toString(tmp));
//								possibilities = ArrayUtils.add(possibilities, tmp);
//							}
//							
//							//System.out.println("after correcting for "+predicate.toString()+" -> "+ArrayUtils.toString(possibilities));
//						} else {
//							
//							//System.out.println("AFTER: " + ArrayUtils.toString(possibilities));							
//						}
//					}
//
//					/* here, we need to add the current predicate into the existing valid combinations */
//					/* we need to add all possible combinations of the current predicate to our global array */
//					/* but try to keep uniqueness */
//					
//					long[][] add_possibilities = ArrayUtils.addAll(possibilities, ((BinaryPredicate) predicate).allCombinations(N));
//					
//					for(int k=0; k<add_possibilities.length; k++) {
//						
//						for(int l=0; l<possibilities.length; l++) {
//							if(ArrayUtils.isEquals(possibilities[l], add_possibilities[k])) {
//								possibilities = ArrayUtils.remove(possibilities, l);
//								l--;
//							}
//						}
//						
//						possibilities = ArrayUtils.add(possibilities, add_possibilities[k]);
//					}
//				} else {
//					/* here is the start */
//					
//					/* 
//					 * ask the predicate to give me all possible combinations
//			         * that comply with the rule 
//			         */
//					possibilities = ((RulePredicate)predicate).allCombinations(N);
//				}
//				
//			}			
//		}
//		
//		
//		/** second, we process all STARTSWITH/ENDSWITH rules **/
//		// now, let's check for unary predicates
//		for(Rule rule : lstRules) {
//			Predicate predicate = rule.getPredicate();
//			
//			if(predicate instanceof UnaryPredicate) {
//				
//				if(possibilities.length > 0) {
//					/* we need to add all possible combinations of the current predicate to our global array */
//					possibilities = ArrayUtils.addAll(possibilities, ((UnaryPredicate) predicate).allCombinations(N));
//					
//					/* here, we need to check if the predicate violates any combination */
//					for(int i=0; i<possibilities.length; i++) {
//						
//						if(!((UnaryPredicate)predicate).evaluate(possibilities[i])) {
//
//							long[] tmp = ArrayUtils.clone(possibilities[i]);
//							
//							boolean bCorrected = false;
//							if(predicate instanceof StartsWith) {
//								bCorrected = ((StartsWith)predicate).correct(tmp, elements);
//							} else if(predicate instanceof EndsWith) {
//								bCorrected = ((EndsWith)predicate).correct(tmp, elements);
//							}
//							
//							/* doesn't matter what happened, remove the current possible combination */
//							possibilities = ArrayUtils.remove(possibilities, i);
//							i--;
//							
//							/* now, insert the new combination */
//							if(bCorrected) {
//								for(int k=0; k<possibilities.length; k++) {
//									if(ArrayUtils.isEquals(possibilities[k], tmp)) {
//										possibilities = ArrayUtils.remove(possibilities, k);
//										k--;
//									}
//								}
//								
//								possibilities = ArrayUtils.add(possibilities, tmp);
//							}
//							//System.out.println("after correcting for "+predicate.toString()+" -> "+ArrayUtils.toString(possibilities));
//						}
//					}
//				} else {
//					/* here is the start */
//					
//					/* 
//					 * ask the predicate to give me all possible combinations
//			         * that comply with the rule 
//			         */
//					possibilities = ((RulePredicate)predicate).allCombinations(N);
//				}
//
//			}
//		}
//
//		// however, after various corrections a corrected combination could violate any rule
//		if(possibilities.length > 0) {
//
//			/* remove violations */
//			for(Rule rule : lstRules) {
//				Predicate predicate = rule.getPredicate();
//				if(predicate instanceof RulePredicate) {
//					for(int i=0; i<possibilities.length; i++) {
//						if(!((RulePredicate)predicate).evaluate(possibilities[i])) {
//							/* throw it away */
//							possibilities = ArrayUtils.remove(possibilities, i);
//							i--;
//						}
//					}
//				}
//			}
//		}
//
//		return possibilities;
//	}
	
}
