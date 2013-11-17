package org.cidarlab.minieugene;

import java.net.URI;
import java.util.List;
import java.util.Set;

import org.cidarlab.minieugene.stats.EugeneStatistics;

public class MiniEugeneReturn {

	private EugeneStatistics stats;
	private Set<URI> uris;
	private List<String[]> solutions;
	
	public MiniEugeneReturn(Set<URI> uris, List<String[]> solutions, EugeneStatistics stats) {
		this.stats = stats;
		this.uris = uris;
		this.solutions = solutions;
	}
	
	public Set<URI> getURIs() {
		return this.uris;
	}

	public List<String[]> getSolutions() {
		return this.solutions;
	}

	public EugeneStatistics getStatistics() {
		return this.stats;
	}
	
}
