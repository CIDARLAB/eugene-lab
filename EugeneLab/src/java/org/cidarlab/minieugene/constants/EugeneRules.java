package org.cidarlab.minieugene.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EugeneRules {

	/*
	 * Counting Rules ...
	 * to constraint the number of occurences ...
	 */
	private static final Set<String> setCountingRules = new HashSet<String>(
			Arrays.asList(new String[] { 
					 "CONTAINS", "NOTCONTAINS", "NOTMORETHAN", "MORETHAN", "EXACTLY", "NOTEXACTLY"}));
	
	/*
	 * Relational Rules ... 
	 * for regulatory interactions
	 */
	private static final Set<String> setRelationalRules = new HashSet<String>(
			Arrays.asList(new String[] { 
					"REPRESSES", "INDUCES", "DRIVES", "BINDS", "MATCHES"}));

	/*
	 * Pairing Rules ...
	 * to constraint pairs of domain values
	 */
	private static final Set<String> setPairingRules = new HashSet<String>(
			Arrays.asList(new String[] { 
					"WITH", "NOTWITH", "THEN", "NOTTHEN"}));
	
	/*
	 * Positional Rules
	 */
	private static final Set<String> setPositionalRules = new HashSet<String>(
			Arrays.asList(new String[] { 
					"BEFORE", "ALL_BEFORE", "SOME_BEFORE", 
					"AFTER", "ALL_AFTER", "SOME_AFTER",
					"NEXTTO", "ALL_NEXTTO", "SOME_NEXTTO",
					"LEFTTO", "ALL_LEFTTO", "SOME_LEFTTO",
					"RIGHTTO", "ALL_RIGHTTO", "SOME_RIGHTTO",
					"STARTSWITH", "ENDSWITH"}));

	private static final Set<String> setUnaryRules = new HashSet<String>(
			Arrays.asList(new String[] { 
					"CONTAINS", "NOTCONTAINS", "STARTSWITH", "ENDSWITH"}));

	public static boolean isUnaryRule(String s) {
		return setUnaryRules.contains(s);
	}

	public static boolean isPositionalRule(String s) {
		return setPositionalRules.contains(s);
	}

	public static boolean isCountingRule(String s) {
		return setCountingRules.contains(s);
	}

	public static boolean isPairingRule(String s) {
		return setPairingRules.contains(s);
	}
}
