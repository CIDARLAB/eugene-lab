package org.cidarlab.minieugene.web.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ScriptCollector
	extends Thread {

	private String path;
	private int N;
	private String script;
	
	private static final String NEWLINE = System.getProperty("line.separator");
	
	public ScriptCollector(String path, int N, String script) {
		this.path = path;
		this.N = N;
		this.script = script;
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
		 * create the path
		 */
//		System.out.println("writing to "+f.getAbsolutePath()+"...");
//		System.out.println(sScript);
		
		writeToFile(sScript, f);
	}
	
	private String buildScript() {
		StringBuilder sb = new StringBuilder();
		sb.append("N=").append(N).append(NEWLINE);
		sb.append(this.script);
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
