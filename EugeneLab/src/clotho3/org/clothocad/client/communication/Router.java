package org.clothocad.client.communication;

import org.clothocad.client.communication.apollo.Messenger;
import org.clothocad.client.communication.apollo.SynchronousMessenger;
import org.clothocad.client.communication.apollo.AsynchronousMessenger;
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
                        
                        // TODO: retrieve the auth-key from the Mind object
                        actionJSON.put("auth_key", "some-authentication-key");
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
