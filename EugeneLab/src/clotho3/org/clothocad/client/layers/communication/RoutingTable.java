package org.clothocad.client.layers.communication;

import java.util.HashMap;

import org.clothocad.client.layers.communication.activemq.AsynchronousMessenger;
import org.clothocad.client.layers.communication.activemq.Messenger;
import org.clothocad.client.layers.communication.activemq.SynchronousMessenger;

public class RoutingTable {

	private HashMap<Channel, Messenger> routingMap;
	
	/** SINGLETON **/
	private static RoutingTable rt = null;	
	public static RoutingTable get() {
		if(null == rt) {
			rt = new RoutingTable();
		}
		return rt;
	}
	
	private RoutingTable() {
		initRoutingMap();		
	}
	
	public Messenger getMessenger(Channel channel) {
		
		return routingMap.get(channel);
		
		// bad... currently the RoutingMap must be initialized everytime the Router gets instantiated...
		// Solution: external configuration file (e.g. properties, xml)?
		
	}
	
	private void initRoutingMap() {
		routingMap = new HashMap<Channel, Messenger>();		
		
		// on the LOGIN channel, we have synchronous communication
    	routingMap.put(
    			Channel.login, 
    			new SynchronousMessenger(ClothoConstants.SERVER_URL));
    	routingMap.put(
    			Channel.logout, 
    			new SynchronousMessenger(ClothoConstants.SERVER_URL));

    	// on the CREATE channel, we have an asynchronous communication
    	routingMap.put(
    			Channel.create, 
    			new AsynchronousMessenger(ClothoConstants.SERVER_URL));
	}
}
