package org.cidarlab.minieugene.test;

import java.io.File;
import java.io.FilenameFilter;

import org.cidarlab.minieugene.MiniEugene;
import org.cidarlab.minieugene.MiniEugeneReturn;
import org.cidarlab.eugene.util.EugeneUtil;


public class TestSuite {

	public static void main(String[] args) {
//		new TestSuite().test(new File("./tests/drives.eug"));
		new TestSuite().test(new File("./tests/interactions.eug"));

//		new TestSuite().test(new File("./designs/priority-encoder/rev3/cassette01.eug"));
//		new TestSuite().test(new File("./designs/priority-encoder/rev3/cassette02.eug"));
//		new TestSuite().test(new File("./designs/priority-encoder/rev3/basic_composition.eug"));
//		new TestSuite().test(new File("./examples/nor-gate.eug"));
//		new TestSuite().test(new File("./examples/transcriptional-unit.eug"));

		/*** TESTS ***/
//		new TestSuite().testAll("./tests");
	}

	public void test(File f) {
		try {
			/*
			 * read the file
			 */
			String script = EugeneUtil.readFile(f);
			long t1 = System.nanoTime();
			MiniEugeneReturn mer = new MiniEugene(-1, -1, false).execute(script);
			long tProcessing = System.nanoTime() - t1;
			
			mer.printSolutions();
			mer.getStatistics().print();
			System.out.println(mer.getURIs());
			System.out.println("[TestSuite.test] full processing time: "+tProcessing*Math.pow(10, -9)+"sec");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//new Eugene(sFile);
	}

	public void testAll( String path ) {
		File root = new File( path );
		FilenameFilter filter = new FilenameFilter() {
                @Override 
	        public boolean accept(File directory, String fileName) {
	            return fileName.endsWith(".eug");
	        }
	    };
	    File[] list = root.listFiles(filter);

		for ( File f : list ) {
			if ( f.isDirectory() ) {
				testAll( f.getAbsolutePath() );
			} else {
				System.out.println("**** "+f.getAbsoluteFile()+" ****");
				try {
					this.test(f);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	
}
