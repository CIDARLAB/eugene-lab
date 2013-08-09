package eugene.test;

import java.io.File;
import java.io.IOException;

import org.antlr.runtime.RecognitionException;

import eugene.Eugene;
import eugene.EugeneExecutor;


public class TestSuite {

	public static void main(String[] args) {
		/* DECLARATIONS */		
		//new TestSuite().testAll("./tests/declaration");
		
		/* PERMUTATIONS */		
		//new TestSuite().test("./tests/permute/permute-large-D.eug");
		//new TestSuite().test("./tests/permute/permute-rules.eug");
		//new TestSuite().testAll("./tests/permute");

		//new TestSuite().test("./tests/device-arrays.eug");
		//new TestSuite().test("./designs/cidar/raven/lu-invertase-gates/and-gate.eug");
		
		/* RULES */
		//new TestSuite().test("./tests/rules/rule-declaration.eug");		
		//new TestSuite().test("./tests/rules/positional/after.eug");		
		//new TestSuite().test("./tests/rules/positional/startswith.eug");	<-- DONE
		//new TestSuite().test("./tests/rules/positional/before.eug");      <-- DONE		
		//new TestSuite().test("./tests/rules/positional/after.eug");       <-- TODO		
		//new TestSuite().test("./tests/rules/positional/nextto.eug");		
		//new TestSuite().test("./tests/rules/composite.eug");

		//new TestSuite().test("./tests/rules/contains.eug");
		//new TestSuite().test("./tests/rules/counting/morethan.eug");
		//new TestSuite().test("./tests/rules/with.eug");
		
		
		/** CARTESIAN PRODUCT **/
		new TestSuite().test("./designs/cidar/swati/inverters/rev3/inverter_rev3.eug");
		
		//new TestSuite().test("./tests/inverter.eug");
		
		//new TestSuite().test("./tests/product/inverter-product.eug");
		//new TestSuite().test("./tests/product/small-product.eug");
		//new TestSuite().test("./tests/product/constraint-product.eug");
		//new TestSuite().test("./tests/product/large-product.eug");
		//new TestSuite().test("./tests/product/product.eug");
		
		//new TestSuite().test("./designs/mit-lf/s3.eug");
		//new TestSuite().test("./designs/mit-lf/s3_rev1.eug");
		//new TestSuite().test("./designs/mit-lf/s4.eug");
		//new TestSuite().test("./designs/mit-lf/stata.eug");
		//new TestSuite().test("./designs/mit-lf/stata_rev1.eug");
		
		/* LOOPS */
		
		/* CONDITIONAL STATEMENTS */
		
		/* FUNCTION PROTOTYPING */
		
		//new TestSuite().test("./tests/scoping/scope.eug");		
		//new TestSuite().test("./tests/functions/functions.eug");
		//new TestSuite().test("./tests/devices/device-depth.eug");
		//new TestSuite().test("./tests/devices/inverter-depth.eug");
		//new TestSuite().test("./tests/product.eug");
		//new TestSuite().test("./tests/permute.eug");
		//new TestSuite().testAll("./tests");
		
		/** DIRECTIONALITY **/
		//new TestSuite().test("./tests/directions.eug");
		
		/** RELATIONSHIPS **/
		//new TestSuite().test("./tests/relations/relations.eug");
		
		/** First-Order-Logic Examples **/
		//new TestSuite().test("./tests/fol-examples.eug");
		
		/** BACKWARD COMPATIBILITY **/
//		new TestSuite().test("./tests/backward-compatibility/AllSyntaxExample.eug");
		//new TestSuite().test("./tests/backward-compatibility/Demo.eug");
//		new TestSuite().test("./tests/backward-compatibility/Example.eug");
		//new TestSuite().testAll("./tests/backward-compatibility");
		
		
		// RULE PROOFS
		//new TestSuite().test("./test/eugene/rules/contains/contains-tu.eug");
		//new TestSuite().test("./test/eugene/rules/contains/not-contains-tu.eug");
		
		//new TestSuite().test("./test/eugene/rules/morethan/morethan.eug");

//		/new TestSuite().test("./test/eugene/rules/before/before.eug");

	}

	public void test(String sFile) {
		new Eugene(sFile);
	}
	
	public void testAll( String path ) {
		File root = new File( path );
		File[] list = root.listFiles();

		for ( File f : list ) {
			if ( f.isDirectory() ) {
				testAll( f.getAbsolutePath() );
			} else {
				System.out.println("**** "+f.getAbsoluteFile()+" ****");
				try {
					EugeneExecutor.execute(
							f.getAbsoluteFile(), 0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	
}
