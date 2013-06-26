package org.clothocad.client.layers.communication.activemq;

import java.util.UUID;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.clothocad.client.layers.communication.ClothoConstants;
import org.fusesource.stomp.jms.StompJmsConnectionFactory;
import org.fusesource.stomp.jms.StompJmsDestination;
import org.json.JSONObject;

public class AsynchronousMessenger 
		implements Messenger, Runnable, MessageListener {

    private Queue queue;
    private Session session;
    private MessageProducer messageProducer;
    private MessageConsumer responseConsumer;
    private JSONObject request;
    private JSONObject response;
    private String sCorrelationID;
    
    private boolean bRunning;
    
    public AsynchronousMessenger(String messageBrokerUrl) {
        StompJmsConnectionFactory factory = new StompJmsConnectionFactory();
        factory.setBrokerURI("tcp://localhost:61613");

        try {

            Connection connection = factory.createConnection("admin", "password");
            connection.start();
            
            this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    		this.messageProducer = session.createProducer(
    				new StompJmsDestination("/queue/CLOTHO"));

    		this.messageProducer.setTimeToLive(10000);
    		this.messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
    		
            this.responseConsumer = session.createConsumer(
            		new StompJmsDestination("/queue/CLOTHORESPONSE"));
            
        } catch (JMSException e) {
        	// if there is an exception, it's highly possible that the server is not running
        	// -> go to ``offline'' mode
        }
	}
	
	public void setJSON(JSONObject json) {
		this.request = json;
	}

	@Override
	public void run() {
		try {
			this.sendMessage(this.request);
			this.bRunning = true;
			while(bRunning) {
				Thread.sleep(250);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(JSONObject json) 
			throws Exception {
		Message request;
		try {
			request = this.session.createMessage();
			
			this.sCorrelationID = UUID.randomUUID().toString();
    		// we tell the server where to reply to (i.e. the temporary destination)
			request.setJMSCorrelationID(this.sCorrelationID);
			request.setJMSDestination(this.queue);
			
			// first, marshal the JSON object into a JMS message
			request.setStringProperty("request", json.toString());

			System.out.println("[Async] sending message -> "+json);
			// finally, send the request message
			this.messageProducer.send(request);
			
			// now, we create a Listener which listens for the server's response
            this.responseConsumer.setMessageListener(this);
            
		} catch (JMSException e) {
			throw new Exception(e);
		}
	}

	public JSONObject receiveMessage() {
		this.bRunning = false;
		return this.response;
	}
	
	public void onMessage(Message response) {
		try {			
			System.out.println("[onMessage] -> "+this.sCorrelationID+" vs "+response.getJMSCorrelationID());
			
			/** TODO!
			if(this.sCorrelationID.equals(response.getJMSCorrelationID())) {
				if(null != response.getStringProperty(ActionType.RESPONSE.toString())) {
					this.response = new JSONObject(
							response.getStringProperty(ActionType.RESPONSE.toString()));
					this.receiveMessage();
				}
			} else {
	            this.responseConsumer.setMessageListener(this);
			}
			**/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
