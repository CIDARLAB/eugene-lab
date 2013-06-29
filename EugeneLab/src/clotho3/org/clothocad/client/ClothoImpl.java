package org.clothocad.client;


import java.util.List;
import java.util.Set;

import org.clothocad.client.communication.Mind;
import org.clothocad.dom.ClothoUser;
import org.clothocad.dom.ClothoObject;
import org.clothocad.dom.Function;
import org.json.JSONObject;

public class ClothoImpl 
		implements Clotho {

	private Mind mind;
	private ClothoAPI clotho;
	
	public ClothoImpl() {
		this.mind = null;
		this.clotho = new ClothoAPI();
	}
	
	public boolean login(String sUsername, String sPassword) {
		if(null == mind) {
			ClothoUser user = new ClothoUser(sUsername, sPassword);
			if(clotho.login(user)) {
				mind = new Mind(user);
				return true;
			}
		} 
		return false;
	}
		
	public void show(String sID) {
		clotho.show(sID);
	}

	public void execute(String sFunction, Object[] lstParameters) {	
		clotho.execute(new Function(sFunction, lstParameters));
	}
	
	public void logout() {
		if(null != mind) {
			ClothoUser user = mind.getUser();
			if(null != user) {
				clotho.logout(user);
			}
		}
	}

	@Override
	public boolean create(ClothoObject datum) {
		return false;
	}

	@Override
	public boolean create(Set<ClothoObject> datum) {
		
		// wrap every datum into one big JSON object
		return false;
	}

	@Override
	public boolean create(List<ClothoObject> lstObjects) {
		
		// wrap every datum into one big JSON object
		/* serialize the list of Clotho objects to JSON */
            
		return false;
	}
}
