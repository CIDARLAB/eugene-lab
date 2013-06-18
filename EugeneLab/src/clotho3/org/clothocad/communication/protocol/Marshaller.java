package org.clothocad.communication.protocol;

import java.net.InetAddress;

import org.clothocad.client.layers.communication.Channel;
import org.clothocad.dom.Datum;
import org.json.JSONObject;

public class Marshaller {

	public static JSONObject toJSON(Channel channel, Datum datum) {
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
