/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.eugene.stats;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ernstl
 */
public class EugeneStats {
    
    private long tStartUp;
    private Map<String, Long> mMeasurements;
    
    public void setStartUp(long t) {
        tStartUp = t;
    }
    
    /*
     * to initialize the hash map
     */
    public void init() {
           mMeasurements = new HashMap<>();
    }
    
    /*
     * the add() method adds a measurement point 
     * to the hash map
     */
    public void add(String tName, long time) {
        mMeasurements.put(tName, new Long(time));
    }
    
    public void printStats() {
        System.out.println("**** EUGENE RUNTIME STATISTICS ****");
        System.out.println("Start-Up Time: "+tStartUp*Math.pow(10, -9)+"sec");
        
        if(null != mMeasurements) {
            for(String tName : mMeasurements.keySet()) {
                System.out.println(tName+": "+(mMeasurements.get(tName)).longValue() * Math.pow(10, -9)+"sec");
            }
        }
    }
    
    /*
     * to destroy the hash map, making it 
     * ready for garbage collection
     */
    public void destroy() {
        mMeasurements = null;
    }
}
