/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.eugenelab.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.biojava.bio.BioException;
import org.biojava.bio.seq.Feature;
import org.biojava.bio.seq.Sequence;
import org.biojava.bio.seq.SequenceIterator;
import org.biojava.bio.seq.io.SeqIOTools;

/**
 *
 * @author ernstl
 */
public class GenbankImporter {
    
    public GenbankImporter() {
        
    }
    
    /****
    // Interface that loads a GenBank component straight from the website
    private Component loadGenBank(String componentName) throws MalformedURLException, IOException,
            NoSuchElementException, BioException, EugeneException {

        URL url = new URL("http:www.ncbi.nlm.nih.gov/nuccore/" + componentName);
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        return readGenBankComponent(br);
    }
    
    // Interface that loads a GenBank component from a file
    private Component loadGenBank(File file) throws FileNotFoundException,
            NoSuchElementException, BioException, EugeneException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        return readGenBankComponent(br);
    }

    // Converts a GenBank component to a Eugene component
    // Do not call directly; use above APIs
    private Component readGenBankComponent(BufferedReader br) throws
            NoSuchElementException, BioException, EugeneException {
        SequenceIterator sequences = SeqIOTools.readGenbank(br);
        List<Component> parts = new ArrayList<Component>();
        String deviceName = "UnnamedDevice";
        // Should only have one sequence
        boolean firstPass = true;
        // Get a list of all features
        while (sequences.hasNext()) {
            Sequence seq = sequences.nextSequence();
            if (firstPass) {
                deviceName = seq.getName();
                firstPass = false;

            } else {
                deviceName += "|" + seq.getName();
            }
            Iterator it = seq.features();

            while(it.hasNext()) {
                Feature feature = (Feature) it.next();
                parts.add(buildPart(feature));
            }
        }
        if(parts.isEmpty()) {
            return null;
        } else if(parts.size() == 1) {
            // Size 1 imples just one part
            return parts.get(0);
        } else {
            //@TODO: get a real device name
            return new Device(deviceName, parts);
            //return EugeneBuilder.buildDevice(deviceName, parts);
        }
    }
    * ****/
}
