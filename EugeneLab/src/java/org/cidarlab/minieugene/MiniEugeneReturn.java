package org.cidarlab.minieugene;

import java.io.File;
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
	private File sbol;
	
	public MiniEugeneReturn(Set<URI> uris, List<Symbol[]> solutions, EugeneStatistics stats, File sbol) {
		this.stats = stats;
		this.uris = uris;
		this.solutions = solutions;
		this.sbol = sbol;
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
	
	public File getSBOL() {
		return sbol;
	}
	
	
	public void printSolutions() {
		if(null != solutions && !solutions.isEmpty()) {
			for(Symbol[] s : solutions) {
				System.out.println(Arrays.toString(s));
			}
		}
	}
}
