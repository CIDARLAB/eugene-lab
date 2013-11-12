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

public class SolutionExporter {
	
	/*
	 * visualize (using pigeon) N solutions
	 */
	public Set<URI> exportSolutions(List<String[]> solutions, int N) 
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
		
		List<String[]> lst = new ArrayList<String[]>(idx.length);
		for(int i=0; i<idx.length; i++) {
			lst.add(solutions.get(idx[i]));
		}
		
		try {
                    Set<URI> uris = new HashSet<URI>();
                    
                    /* 
                     * we visualize always 20 pigeon images
                     */           
                    if(lst.size() > 20) {
                        int k=0;
                        while(k<solutions.size()) {   
                            if(k+20 >= solutions.size()) {
                                uris.add(URI.create(new Pigeonizer().pigeonize(lst.subList(k, solutions.size()-1))));
                            } else {
                                uris.add(URI.create(new Pigeonizer().pigeonize(lst.subList(k, k+20))));
                            }
                            k+=20;
                        }
                    } else {
                        uris.add(URI.create(new Pigeonizer().pigeonize(lst)));
                    }
                    return uris;
		} catch(Exception e) {
                    throw new EugeneException(e.getMessage());
    		}
	}

	private void printAllSolutions(List<String[]> solutions) {
		for(int i=0; i<solutions.size(); i++) {
			System.out.println(Arrays.toString(solutions.get(i)));
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
