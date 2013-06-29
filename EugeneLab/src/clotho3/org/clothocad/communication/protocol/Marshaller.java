package org.clothocad.communication.protocol;

import java.net.InetAddress;

import org.clothocad.client.communication.Channel;
import org.clothocad.dom.ClothoObject;
import org.json.JSONObject;

public class Marshaller {

	public static JSONObject toJSON(Channel channel, ClothoObject datum) {
		JSONObject json = new JSONObject();
		try {
			json.put("ip", InetAddress.getLocalHost());
			json.put("channel", channel.toString());
			json.put("data", datum.toJSON());
		} catch (Exception e) {
			e.printStackTrace();
			return (JSONObject)null;
		}
		return json;
	}
}
