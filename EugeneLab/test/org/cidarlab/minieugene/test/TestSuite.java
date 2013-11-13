package org.cidarlab.minieugene.test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.cidarlab.minieugene.MiniEugene;
import org.cidarlab.eugene.util.EugeneUtil;


public class TestSuite {

	public static void main(String[] args) {
		new TestSuite().test(new File("./examples/nor-gate.eug"));
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
			new MiniEugene(true).execute(script);
			long tProcessing = System.nanoTime() - t1;
			
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
				System.out.println("XXXX");
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
