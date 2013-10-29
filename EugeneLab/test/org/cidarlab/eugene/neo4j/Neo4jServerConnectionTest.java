package org.cidarlab.eugene.neo4j;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Neo4jServerConnectionTest {

	public static final String SERVER_URL = "http://localhost:7474";
	
	public static void main(String[] args) {
		Neo4jServerConnectionTest neo4jServer = new Neo4jServerConnectionTest();
		
		neo4jServer.connect();
	}
	
	public void connect() {
		WebResource resource = 
				Client.create().resource( SERVER_URL );
		ClientResponse response = resource.get( ClientResponse.class );
		
		System.out.println( String.format( "GET on [%s], status code [%d]",
				SERVER_URL, response.getStatus() ) );
		response.close();
	}
}
