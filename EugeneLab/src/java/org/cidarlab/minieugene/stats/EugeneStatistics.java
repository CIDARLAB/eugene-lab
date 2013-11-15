package org.cidarlab.minieugene.stats;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EugeneStatistics {

	private Set<Measurement> measurements;
	
	public EugeneStatistics() {
		this.measurements = new HashSet<Measurement>();
	}
	
	public void add(String key, double value) {
		this.measurements.add(new Measurement(key, value));
	}
	
	public boolean isEmpty() {
		return this.measurements.isEmpty();
	}

	public Set<Measurement> getMeasurements() {
		return this.measurements;
	}
	
	public void print() {
		System.out.println("**** STATISTICS ****");
		Iterator<Measurement> it = this.measurements.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
}
