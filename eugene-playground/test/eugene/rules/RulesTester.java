package eugene.rules;

import eugene.Eugene;

public class RulesTester {

	public static void main(String[] args) {
		RulesTester rt = new RulesTester();
		
		rt.testStartsWith();
	}
	
	public void testStartsWith() {
		System.out.println("*** STARTSWITH ***");
		new Eugene("./tests/rules/startswith.eug");
		
		System.out.println("*** ENDSWITH ***");
		new Eugene("./tests/rules/endswith.eug");
	}

}
