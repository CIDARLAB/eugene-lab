package org.clothocad.clotho.client;

import java.util.Set;

import org.clothocad.dom.ClothoObject;
import org.json.JSONObject;

public interface Clotho {
	public boolean login(String username, String password);	
	public void show(String sID);
	public void execute(String sFunction, Object[] lstParameters);
	public void logout();
	
	/** METHODS TO CREATE/STORE DATA **/
	public boolean create(ClothoObject datum);
	public boolean create(Set<ClothoObject> datum);
}
