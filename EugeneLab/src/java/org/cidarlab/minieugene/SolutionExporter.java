package org.cidarlab.minieugene;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.cidarlab.minieugene.data.pigeon.Pigeonizer;
import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.symbol.Symbol;

public class SolutionExporter {
	
	/*
	 * visualize (using pigeon) N solutions
	 */
	public Set<URI> pigeonizeSolutions(List<Symbol[]> solutions, int N) 
			throws EugeneException {
		int[] idx = null;
		if(N != -1 && N < solutions.size()) {
			idx = generateRandomIndices(N, solutions.size());
		} else {
			idx = new int[solutions.size()];
			for(int i=0; i<solutions.size(); i++) {
				idx[i] = i;
			}
		}
		
		List<Symbol[]> lst = new ArrayList<Symbol[]>(idx.length);
		for(int i=0; i<idx.length; i++) {
			lst.add(solutions.get(idx[i]));
		}
		
        try {
            Set<URI> uris = new HashSet<URI>();
        	Pigeonizer pigeon = new Pigeonizer();
            
            /* 
             * we visualize always 20 designs 
             */           
            if(lst.size() > 20) {
                int k=0;
                while(k<lst.size()) {   
                    if(k+20 >= solutions.size()) {
                        uris.add(pigeon.pigeonize(lst.subList(k, solutions.size())));
                    } else {
                        uris.add(pigeon.pigeonize(lst.subList(k, k+20)));
                    }
                    k+=20;
                }
            } else {
                uris.add(pigeon.pigeonize(lst));
            }
            
            return uris;
        } catch(Exception e) {
            throw new EugeneException(e.getMessage());
        }
	}

	private int[] generateRandomIndices(int N, int range) {
		int[] idx = new int[N];
		Random generator = new Random();
		for(int i=0; i<N; i++) {
			idx[i] = generator.nextInt( range );
		}
		return idx;
	}
	

}
