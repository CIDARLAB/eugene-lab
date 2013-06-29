package org.clothocad.client;

import org.clothocad.client.communication.Channel;
import org.clothocad.client.communication.Router;
import org.clothocad.dom.ClothoUser;
import org.clothocad.dom.ClothoObject;
import org.clothocad.dom.Function;
import org.json.JSONObject;

public class ClothoAPI {

	private Router router;
	public ClothoAPI() {
		this.router = new Router();
	}
	
	public ClothoObject get(String id) {
		return (ClothoObject)null;
	}
	
	public boolean set(String id, ClothoObject datum) {
		return false;
	}
	
	// create is an asynchronous call...
	// i.e. we need a callback-handler which handles the server's response...
	public boolean create(ClothoObject datum) {
		
		try {
			router.sendMessage(Channel.create, datum.toJSON());						
			return true;					
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}		
	
	public boolean execute(Function function) {
		return true;
	}
	
	// edit
	
	// revert
	
	// say
	
	// alert
	
	// show
	public boolean show(String sID) {		
		return true;
	}
	
	// remove
	
	// run
	
	// login is a synchronous call ...
	public boolean login(ClothoUser aUser) {
		try {
			JSONObject json = router.sendMessage(Channel.login, aUser.toJSON());
			return json.getBoolean("login");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// logout follows the "fire-and-forget" principle...
	// i.e. the client sends the "logout"-command to the server 
	// not taking care of the server's response...
	public void logout(ClothoUser aUser) {
		try {
			router.sendMessage(Channel.logout, aUser.toJSON());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
