package org.cidarlab.minieugene;

import java.util.List;

import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.symbol.Symbol;

public interface MiniEugene {
	public List<Symbol[]> solve(String[] rules, int N)
			throws EugeneException;
	public List<Symbol[]> solve(String[] rules, int N, int NR_OF_SOLUTIONS)
			throws EugeneException;
	public MiniEugeneReturn execute(String script, int N, int NR_OF_SOLUTIONS) 
			throws EugeneException;
	
	/*
	 * clears all the symbols from Eugene's symbol tables
	 */
	public void clear();
}
