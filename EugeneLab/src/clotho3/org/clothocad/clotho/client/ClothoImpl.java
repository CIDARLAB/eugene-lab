package org.clothocad.clotho.client;


import org.clothocad.client.layers.communication.Mind;
import org.clothocad.dom.ClothoUser;
import org.clothocad.dom.Function;

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
}
