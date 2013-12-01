package org.cidarlab.minieugene.data.pigeon;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.symbol.Symbol;

public class Pigeonizer {

	private static Map<String, Character> Eugene2PigeonMap;
	private Map<String, Integer> colors;
		
	public Pigeonizer() {
		if(Eugene2PigeonMap == null) {
			loadMap();
		}
		colors = new HashMap<String, Integer>();
	}
	
	public URI pigeonize(List<Symbol[]> solutions) 
			throws EugeneException {

		StringBuilder sb = new StringBuilder();

		for(int k=0; k<solutions.size(); k++) {
			Symbol[] solution = solutions.get(k);
			for(int i=0; i<solution.length; i++) {
				sb.append(toPigeon(solution[i])).append("\r\n");
			}
			if(k != solutions.size() - 1) {
				sb.append("\r\n");
			}
		}
		/*
		 * finally, we add the arcs line
		 */
		sb.append("# Arcs");

		WeyekinPoster.setPigeonText(sb.toString());
		
		return WeyekinPoster.getMyBirdsURL();
	}
	
	private String toPigeon(Symbol symbol) {
		String s = symbol.getName();
		StringBuilder sb = new StringBuilder();
		if(!symbol.isForward()) {
			sb.append("<");
		}
		
		if(s.startsWith("p")) {
			/*
			 * promoter
			 */
			sb.append("p ").append(s).append(" ").append(getColor(s));
		} else if(s.startsWith("r")) {
			/*
			 * rbs
			 */
			sb.append("r ").append(s).append(" ").append(getColor(s));
		} else if(s.startsWith("c") || s.startsWith("g")) {
			/*
			 * coding sequence v gene
			 */
			sb.append("c ").append(s).append(" ").append(getColor(s));
		} else if(s.startsWith("t")) {
			/*
			 * terminator
			 */
			sb.append("t ").append(s).append(" ").append(getColor(s));
		} else {
			char type = getPigeonType(s);
			if(type != '>') {
				sb.append(type);
			} 
			sb.append(" ").append(s).append(" ").append(getColor(s));
		}
		
		return sb.toString();
	}
	
	private int getColor(String s) {
		if(this.colors.containsKey(s)) {
			return colors.get(s);
		}
		/*
		 * otherwise, we put the name into the coloring map
		 */
		int color = getRandomColor();
		this.colors.put(s, color);
		return color;
	}
	
	
	private static void loadMap() {
		Eugene2PigeonMap = new HashMap<String, Character>();
		
		/*
		 * key   ... Eugene type
		 * value ... Pigeon type 
		 */
		Eugene2PigeonMap.put("p", 'p');
		Eugene2PigeonMap.put("PROMOTER", 'p');
		Eugene2PigeonMap.put("INDUCIBLEPROMOTER", 'p');
		Eugene2PigeonMap.put("CONSTITUTIVEPROMOTER", 'p');
		Eugene2PigeonMap.put("REGULATEDPROMOTER", 'p');

		Eugene2PigeonMap.put("RPROMOTER", 'p');
		Eugene2PigeonMap.put("IPROMOTER", 'p');
		Eugene2PigeonMap.put("PROMOTER", 'p');
		
		Eugene2PigeonMap.put("r", 'r');
		Eugene2PigeonMap.put("RBS", 'r');
		
		Eugene2PigeonMap.put("c", 'c');
		Eugene2PigeonMap.put("RECOMBINASE", 'c');
		Eugene2PigeonMap.put("PACKAGINGSITE", 'c');
		Eugene2PigeonMap.put("LYTICREPLICON", 'c');		
		Eugene2PigeonMap.put("CODINGSEQUENCE", 'c');
		Eugene2PigeonMap.put("RIBOZYME", 'c');
		Eugene2PigeonMap.put("LEADER", 'c');
		Eugene2PigeonMap.put("CDS", 'c');
		Eugene2PigeonMap.put("REPRESSOR", 'c');
		Eugene2PigeonMap.put("REPORTER", 'c');
		Eugene2PigeonMap.put("INDUCER", 'c');
		Eugene2PigeonMap.put("GENE", 'c');
		
		Eugene2PigeonMap.put("t", 't');
		Eugene2PigeonMap.put("TERMINATOR", 't');

		Eugene2PigeonMap.put("MO", 'o');
		Eugene2PigeonMap.put("FUSIONSITE", 'o');
		Eugene2PigeonMap.put("RECSITE", '>');
		Eugene2PigeonMap.put("ANTIREPRESSOR", 'g');
		Eugene2PigeonMap.put("SPACER", 's');
	}
	
	private static char getPigeonType(String eugeneType) {
//		System.out.println("[getPigeonType] -> "+eugeneType);
		if(Eugene2PigeonMap.containsKey(eugeneType.toUpperCase())) {
			return (Eugene2PigeonMap.get(eugeneType.toUpperCase())).charValue();
		}
		return '?';
	}
	
	private static final int COLOR_MIN = 1;
	private static final int COLOR_MAX = 13;
	
	private static int getRandomColor() {
		return COLOR_MIN + (int)(Math.random() * ((COLOR_MAX - COLOR_MIN) + 1));
	}
}
