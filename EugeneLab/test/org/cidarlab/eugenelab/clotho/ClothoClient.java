package org.cidarlab.eugenelab.clotho;

import java.io.File;
import java.util.HashMap;

import org.clothocad.clotho.client.Clotho;
import org.clothocad.clotho.client.ClothoImpl;
import org.clothocad.dom.ClothoUser;

import eugene.EugeneExecutor;
import eugene.dom.SavableElement;
import eugene.interpreter.EugeneBuilder;

public class ClothoClient
		implements Runnable {
	
    private int ID;
    private boolean bRunning;
    private ClothoUser user;
    private final int NR_OF_REQUESTS = 1;
    private Clotho clotho;
    
    public ClothoClient(int ID) {
    	this.ID = ID;
    	this.bRunning = true;
    	this.clotho = new ClothoImpl();
    }
    
	public int getID() {
		return ID;
	}

	@Override
	public void run() {

		try {
			
			System.out.println("Client "+this.getID()+" is logging in...");
			
			this.user = new ClothoUser("ernst", "s3cr3t");

			boolean b = this.clotho.login(
					this.user.getUsername(), 
					this.user.getPassword());
			
			if(b) {
				// now, we execute a Eugene script
				HashMap<String, SavableElement> results = (HashMap<String, SavableElement>)EugeneExecutor.execute(new File("./examples/inverter.eug"), 2);

				System.out.println("Client "+this.getID()+" is sending a new nucseq to the server...");
				
				// TODO:
				// package the results into a JSON object
				for(String s:results.keySet()) {
					SavableElement se = results.get(s);
					
					
					
				}
					
	

				// finally, log out
				System.out.println("and now I'm logging off...");
				this.clotho.logout();
			} else {
				System.err.println("YOU ARE NOT ALLOWED TO LOGIN!");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void stop() {
		this.bRunning = false;
	}
	
	public static void main(String[] args) {
		new Thread(new ClothoClient(1)).start();
	}
}