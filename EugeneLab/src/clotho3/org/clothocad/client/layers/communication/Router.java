package org.clothocad.client.layers.communication;

import org.clothocad.client.layers.communication.activemq.Messenger;
import org.clothocad.client.layers.communication.activemq.SynchronousMessenger;
import org.clothocad.client.layers.communication.activemq.AsynchronousMessenger;
import org.json.JSONObject;

/* 
 * the Requestor is some kind of Message Router
 * 
 * dependent on the action, the requestor dispatches the JSON object to an appropriate channel
 * e.g. action==LOGIN -> channel: access
 *      action==RUN   -> channel: execution 
 */
public class Router {

	private volatile static RoutingTable routingTable;
	
	public Router() {
		if(null == routingTable) {
			routingTable = RoutingTable.get();
		}
	}
	
	public synchronized JSONObject sendMessage(Channel channel, JSONObject json) {
		try {			
			JSONObject actionJSON = new JSONObject();
			actionJSON.put("channel", channel.toString());
			actionJSON.put("data", json);
						
			Messenger messenger = RoutingTable.get().getMessenger(channel);
			if(messenger instanceof SynchronousMessenger) {
				return ((SynchronousMessenger)messenger).sendMessage(actionJSON);
			} else if(messenger instanceof AsynchronousMessenger) {
				((AsynchronousMessenger)messenger).setJSON(actionJSON);
				new Thread((AsynchronousMessenger)messenger).start();				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (JSONObject)null;
	}
	
}
