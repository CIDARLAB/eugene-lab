package org.cidarlab.minieugene;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.stats.EugeneStatistics;
import org.cidarlab.minieugene.symbol.Symbol;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

public class MiniEugeneReturn {

	private EugeneStatistics stats;
	private Set<URI> uris;
	private List<Symbol[]> solutions;
	private SBOLDocument sbol;
	private boolean hasSBOL;
	
	public MiniEugeneReturn(Set<URI> uris, List<Symbol[]> solutions, EugeneStatistics stats, SBOLDocument sbol) {
		this.stats = stats;
		this.uris = uris;
		this.solutions = solutions;
		
		this.sbol = sbol;
		hasSBOL = (null != sbol) ? true : false;
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
	
	public boolean hasSBOL() {
		return this.hasSBOL;
	}
	
	public void serializeSBOL(String sFile) 
			throws EugeneException {
		try {
			File f = new File(sFile);
			FileOutputStream fos = new FileOutputStream(f);
			SBOLFactory.write(sbol, fos);
		} catch(Exception e) {
			e.printStackTrace();
			throw new EugeneException("I cannot serialize the SBOL file!");
		}
	}
	
	public void printSolutions() {
		if(null != solutions && !solutions.isEmpty()) {
			for(Symbol[] s : solutions) {
				System.out.println(Arrays.toString(s));
			}
		}
	}
}