package org.clothocad.client.layers.communication.activemq;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.json.JSONObject;


/*
 * A synchronous channel listener processes the messages in their incoming order...
 * after message processing, the listener returns the message...
 */
public class ClothoMessageConsumer 
		implements MessageListener {
    private int ackMode;
    private String queueName;    
    private String messageBrokerUrl;
    private Session session;
    
    private boolean transacted = false;
    
    //private ClothoProtocol messageProtocol;

    public ClothoMessageConsumer(String messageBrokerUrl, String queueName) {
        this.queueName = queueName;
        this.ackMode = Session.AUTO_ACKNOWLEDGE;
    	this.messageBrokerUrl = messageBrokerUrl;
        
    	this.init();
    }

    private void init() {
        ActiveMQConnectionFactory connectionFactory = 
        		new ActiveMQConnectionFactory(messageBrokerUrl);
        Connection connection;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            
            this.session = connection.createSession(this.transacted, ackMode);

            // this is the queue, the listener is listening to... 
            Destination adminQueue = this.session.createQueue(queueName.toString());
           
            MessageConsumer consumer = this.session.createConsumer(adminQueue);
            consumer.setMessageListener(this);
            
        } catch (JMSException e) {
            //Handle the exception appropriately
        }
    }
    
    // the onMessage method gets executed if a message arrives on the given channel...
	@Override
	public void onMessage(Message message) {	
		try {
        	System.out.println("[ClothoMessageConsumer.onMessage] -> "+message.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}