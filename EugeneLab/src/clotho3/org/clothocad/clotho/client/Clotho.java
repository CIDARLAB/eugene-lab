package org.clothocad.clotho.client;

public interface Clotho {
	public boolean login(String username, String password);	
	public void show(String sID);
	public void execute(String sFunction, Object[] lstParameters);
	public void logout();
}
