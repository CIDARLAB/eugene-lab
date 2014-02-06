package org.cidarlab.minieugene.web.util;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.cidarlab.minieugene.Symbol;
import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.interaction.Interaction;
import org.cidarlab.minieugene.web.data.pigeon.Pigeonizer;
import org.cidarlab.minieugene.web.data.sbol.SBOLExporter;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

public class SolutionExporter {
	
	private List<Symbol[]> solutions;
	private Set<Interaction> interactions;
	
	private static final int NR_OF_PIGEON = 10;
	private static final int NR_OF_SBOL = 1000;
	
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
	        	if(this.solutions.size() > NR_OF_PIGEON) {
	            	return pigeon.pigeonize(
	            			this.getRandomSolutions(NR_OF_PIGEON), 
	            			this.interactions);
	        	}
	        	
	        	return pigeon.pigeonize(
	        			this.solutions, 
	        			this.interactions);
	        	
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
	
	public boolean toSBOL(String filename) 
			throws EugeneException {
		
		/*
		 * create the SBOLDocument
		 */
		SBOLDocument doc = this.sbolExport();
		
		/*
		 * write the document to the given filename
		 */
		try {
			FileOutputStream fos = new FileOutputStream(
				new File(filename));
			SBOLFactory.write(doc, fos);
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
	private SBOLDocument sbolExport()  
			throws EugeneException {
		if(null != this.solutions) {
			try {
				
	            /* 
	             * we SBOL up to 100 designs 
	             */
				if(this.solutions.size() > NR_OF_SBOL) {
					return new SBOLExporter().toSBOLDocument(this.getRandomSolutions(NR_OF_SBOL));
				} 
				return new SBOLExporter().toSBOLDocument(this.solutions);
				
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