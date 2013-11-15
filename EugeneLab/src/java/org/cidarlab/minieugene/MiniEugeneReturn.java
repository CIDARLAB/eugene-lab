package org.cidarlab.minieugene;

import java.net.URI;
import java.util.Set;

import org.cidarlab.minieugene.stats.EugeneStatistics;

public class MiniEugeneReturn {

	private EugeneStatistics stats;
	private Set<URI> uris;
	
	public MiniEugeneReturn(Set<URI> uris, EugeneStatistics stats) {
		this.stats = stats;
		this.uris = uris;
	}
	
	public EugeneStatistics getStatistics() {
		return this.stats;
	}
	
	public Set<URI> getURIs() {
		return this.uris;
	}
}
