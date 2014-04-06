package org.cidarlab.minieugene.web.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ScriptCollector
	extends Thread {

	private String path;
	private int N;
	private String[] rules;
	
	private static final String NEWLINE = System.getProperty("line.separator");
	
	public ScriptCollector(String path, int N, String script) {
		this.path = path;
		this.N = N;
		this.rules = script.split(NEWLINE);
	}
	
	public void run() {
		
		/*
		 * create the ``complete'' miniEugene script
		 * i.e. including the first line (N=x) 
		 */
		String sScript = this.buildScript();
		
		/*
		 * create the file
		 * -> the filename depends on the current time
		 */
		File f = createFile();

		/*
		 * write the script to the file
		 */
		writeToFile(sScript, f);
	}
	
    /**
     * 
     * @param N
     * @param rules
     * @return
     */
	public String buildScript() {
    	StringBuilder sb = new StringBuilder();

		// N = number .
		sb.append("N=").append(this.N).append(".").append(NEWLINE);
		
		// rules
		for(int i=0; i<this.rules.length; i++) {
			if(!this.rules[i].trim().isEmpty()) {
				if(!this.rules[i].startsWith("//")) {
					sb.append(this.rules[i]);
					if(!this.rules[i].endsWith(".")) {
						sb.append(".").append(NEWLINE);
					}
				}
			}
		}

		return sb.toString();
	}

	private File createFile() {
		File fPath = new File(this.path);
		if(!fPath.exists()) {
			fPath.mkdir();
		}
		return new File(this.path+"/"+System.nanoTime()+".eug");
	}
	
	private void writeToFile(String sScript, File f) {
		FileOutputStream fop = null;
		
		try {
			fop = new FileOutputStream(f);
			byte[] contentInBytes = sScript.getBytes();
			
			fop.write(contentInBytes);
			fop.flush();

		} catch ( IOException ioe ) {
            //ioe.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}
	}
}
