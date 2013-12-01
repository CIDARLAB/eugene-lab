package org.cidarlab.minieugene;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.cidarlab.minieugene.stats.EugeneStatistics;
import org.cidarlab.minieugene.symbol.Symbol;

public class MiniEugeneReturn {

	private EugeneStatistics stats;
	private Set<URI> uris;
	private List<Symbol[]> solutions;
	
	public MiniEugeneReturn(Set<URI> uris, List<Symbol[]> solutions, EugeneStatistics stats) {
		this.stats = stats;
		this.uris = uris;
		this.solutions = solutions;
	}
	
	public Set<URI> getURIs() {
		return this.uris;
	}

	public List<Symbol[]> getSolutions() {
		return this.solutions;
	}

	public EugeneStatistics getStatistics() {
		return this.stats;
	}
	
	
	public void printSolutions() {
		if(null != solutions && !solutions.isEmpty()) {
			for(Symbol[] s : solutions) {
				System.out.println(Arrays.toString(s));
			}
		}
	}
}
