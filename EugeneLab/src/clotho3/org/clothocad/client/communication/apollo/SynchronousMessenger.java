package org.clothocad.client.communication.apollo;

import java.util.UUID;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.clothocad.client.communication.Channel;
import org.clothocad.client.communication.ClothoConstants;
import org.fusesource.stomp.jms.StompJmsConnectionFactory;
import org.fusesource.stomp.jms.StompJmsDestination;
import org.json.JSONObject;

public class SynchronousMessenger 
		implements Messenger {

	private Queue queue;
	private Session session;
    private MessageProducer messageProducer;
    private MessageConsumer messageConsumer;
    private Message request;
    private JSONObject response;
    
    public SynchronousMessenger(String messageBrokerUrl) {
        
        StompJmsConnectionFactory factory = new StompJmsConnectionFactory();
        factory.setBrokerURI("tcp://localhost:61613");

        try {

            Connection connection = factory.createConnection("admin", "password");
            connection.start();

            this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

    		this.messageProducer = session.createProducer(
    				new StompJmsDestination(ClothoConstants.CLOTHO_QUEUE));
    		this.messageProducer.setTimeToLive(10000);
    		//messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);            
    		this.messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
    		
            this.messageConsumer = session.createConsumer(
            		new StompJmsDestination(ClothoConstants.CLOTHO_RESPONSE_QUEUE));
            
        } catch (JMSException e) {
        	// if there is an exception, it's highly possible that the server is not running
        	// -> go to ``offline'' mode
        	e.printStackTrace();
                System.exit(1);
        }
	}
	
	public JSONObject sendMessage(JSONObject json) 
			throws Exception {
		Message request;
		try {
			request = this.session.createMessage();
			
			request.setJMSCorrelationID(UUID.randomUUID().toString());

			// first, marshal the JSON object into a JMS message
			request.setStringProperty("request", json.toString());

			// finally, send the request message
			this.messageProducer.send(request);
			
			this.request = request;

			boolean b = true;
			while(b) {

				Message response = this.messageConsumer.receive();
                                
				// now, compare the correlation-ids
				if(this.request.getJMSCorrelationID().equals(response.getJMSCorrelationID())) {
                                    return new JSONObject(response.getStringProperty(Channel.response.toString()));
				} 
			}
			
			return (JSONObject)null;
		} catch (JMSException e) {
			throw new Exception(e);
		}		
	}
	
	public JSONObject receiveMessage() {
		// now, we have to wait for the server's response
		
		return (JSONObject)null;
	}
}
