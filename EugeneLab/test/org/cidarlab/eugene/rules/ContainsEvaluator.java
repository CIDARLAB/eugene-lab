package org.cidarlab.eugene.rules;

import org.cidarlab.minieugene.MiniEugene;

public class ContainsEvaluator {

	private static final int MAX_DESIGN_SIZE = 30; 
	
	public void evaluate() {
		for(int i=1; i<=MAX_DESIGN_SIZE; i++) {
			System.out.println("*** i: "+i);
			String s=buildScript(i);
			
			try {
				new MiniEugene(i, -1, false).execute(s);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public String buildScript(int N) {
		String NEWLINE = System.getProperty("line.separator");
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append("CONTAINS i").append(i).append(NEWLINE);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ContainsEvaluator ce = new ContainsEvaluator();
		ce.evaluate();
	}
}
