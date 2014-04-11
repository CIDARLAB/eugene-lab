package org.cidarlab.minieugene.web.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ScriptCollector
	extends Thread {

	private String path;
	private String script;
	
	public ScriptCollector(String path, String script) {
		this.path = path;
		this.script = script;
	}
	
	public void run() {
		
		/*
		 * create the file
		 * -> the filename depends on the current time
		 */
		File f = createFile();

		/*
		 * write the script to the file
		 */
		writeToFile(this.script, f);
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
