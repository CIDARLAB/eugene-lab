package org.cidarlab.minieugene;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.cidarlab.eugenelab.data.sbol.SBOLExporter;
import org.cidarlab.minieugene.data.pigeon.Pigeonizer;
import org.cidarlab.minieugene.dom.interaction.Interaction;
import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.symbol.Symbol;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

public class SolutionExporter {
	
	private List<Symbol[]> solutions;
	private Set<Interaction> interactions;
	
	public SolutionExporter(List<Symbol[]> solutions, Set<Interaction> interactions) {
		this.solutions = solutions;
		this.interactions = interactions;
	}
	
	/*
	 * visualize (using pigeon) N solutions
	 */
	public URI pigeonizeSolutions() 
			throws EugeneException {

		if(null != solutions) {
			
			try {
	        	Pigeonizer pigeon = new Pigeonizer();
	            
	            /* 
	             * we visualize up to 10 designs 
	             */
	        	if(this.solutions.size() > 10) {
	            	return pigeon.pigeonize(this.getRandomSolutions(10), this.interactions);
	        	}
	        	
	        	return pigeon.pigeonize(this.solutions, this.interactions);
	        	
	        } catch(Exception e) {
	        	e.printStackTrace();
	            throw new EugeneException(e.getMessage());
	        }
		}
		
		return URI.create("");
	}

	private int[] generateRandomIndices(int N, int range) {
		int[] idx = new int[N];
		Random generator = new Random();
		for(int i=0; i<N; i++) {
			idx[i] = generator.nextInt( range );
		}
		return idx;
	}
	

	public SBOLDocument sbolExport() 
			throws EugeneException {
		if(null != this.solutions) {
			try {
				
	            /* 
	             * we SBOL up to 100 designs 
	             */
				if(this.solutions.size() > 100) {
					return new SBOLExporter().serialize(this.getRandomSolutions(100));
				} 
				return new SBOLExporter().serialize(this.solutions);
				
			} catch(EugeneException ee) {
				throw new EugeneException(ee.getMessage());
			}
		}
		/*
		 * we return an empty document if there 
		 * are no solutions
		 */
		return SBOLFactory.createDocument();
	}
	
	private List<Symbol[]> getRandomSolutions(int N) {
		int[] idx = null;
		if(N != -1 && N < this.solutions.size()) {
			idx = generateRandomIndices(N, this.solutions.size());
		} else {
			idx = new int[this.solutions.size()];
			for(int i=0; i<this.solutions.size(); i++) {
				idx[i] = i;
			}
		}
		
		List<Symbol[]> lst = new ArrayList<Symbol[]>(idx.length);
		for(int i=0; i<idx.length; i++) {
			lst.add(this.solutions.get(idx[i]));
		}
		return lst;
	}
}
