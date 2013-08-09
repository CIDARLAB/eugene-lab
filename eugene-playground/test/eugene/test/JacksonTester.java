package eugene.test;

import java.util.ArrayList;
import java.util.List;

import org.cidarlab.eugene.builder.EugeneBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import eugene.cache.SymbolTables;
import eugene.constants.EugeneConstants;
import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.dom.components.Part;
import eugene.dom.components.Property;
import eugene.dom.components.types.PartType;
import eugene.exception.EugeneException;

public class JacksonTester {

	private static final int NR_OF_PROPERTIES = 2;
	private static final int NR_OF_PARTTYPES = 5;
	private static final int NR_OF_PARTS = 5;
	private static final int NR_OF_DEVICES = 5;
	private static final int N = 10;
	
	private ObjectMapper mapper;

	public JacksonTester() {
		this.mapper  = new ObjectMapper();
	}
	
	public static void main(String[] args) 
			throws EugeneException {
		JacksonTester jt = new JacksonTester();
		
		jt.createAndSerializeObjects();
		
		jt.deserializeAndPrintObjects();
		
	}
	
	public void createAndSerializeObjects() 
			throws EugeneException {
		
		try {

			ArrayList<Property> lstProperties = new ArrayList<Property>();
			ArrayList<PartType> lstPartTypes = new ArrayList<PartType>();
			
			for(int i=1; i<=NR_OF_PROPERTIES; i++) {
				lstProperties.add(new Property("PROP"+i, EugeneConstants.TXT));
			}
			
			for(int i=1; i<=NR_OF_PARTTYPES; i++) {
				PartType pt = new PartType("PT"+i);
				pt.setProperties(lstProperties);
				
				lstPartTypes.add(pt);
				String ptJSON = this.mapper.writeValueAsString(pt);
				
				System.out.println(ptJSON);
				
				for(int j=1; j<=NR_OF_PARTS; j++) {
					Part p = new Part(pt, "PT"+i+"_P"+j);
					
					String pJSON = this.mapper.writeValueAsString(p);
					System.out.println(pJSON);
				}
			}
			
			for(int i=1; i<=NR_OF_DEVICES; i++) {
				List<Component> lstComponents = new ArrayList<Component>(N);
				
				for(int j=0; j<NR_OF_PARTTYPES; j++) {
					lstComponents.add(lstPartTypes.get(j));
				}
				
				Device d = new Device("D"+i, lstComponents);
				String dJSON = this.mapper.writeValueAsString(d);
				System.out.println(dJSON);
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new EugeneException(e.toString());
		}
	}

	public void deserializeAndPrintObjects() 
			throws EugeneException {
		try {
			String deviceJSON = new String("{\"components\":[{\"properties\":[{\"type\":\"txt\",\"name\":\"PROP1\"},{\"type\":\"txt\",\"name\":\"PROP2\"}],\"sequence\":\"\",\"direction\":1,\"name\":\"PT1\"},{\"properties\":[{\"type\":\"txt\",\"name\":\"PROP1\"},{\"type\":\"txt\",\"name\":\"PROP2\"}],\"sequence\":\"\",\"direction\":1,\"name\":\"PT2\"},{\"properties\":[{\"type\":\"txt\",\"name\":\"PROP1\"},{\"type\":\"txt\",\"name\":\"PROP2\"}],\"sequence\":\"\",\"direction\":1,\"name\":\"PT3\"},{\"properties\":[{\"type\":\"txt\",\"name\":\"PROP1\"},{\"type\":\"txt\",\"name\":\"PROP2\"}],\"sequence\":\"\",\"direction\":1,\"name\":\"PT4\"},{\"properties\":[{\"type\":\"txt\",\"name\":\"PROP1\"},{\"type\":\"txt\",\"name\":\"PROP2\"}],\"sequence\":\"\",\"direction\":1,\"name\":\"PT5\"}],\"abstract\":true,\"valid\":false,\"concrete\":false,\"deviceType\":null,\"compoents\":null,\"allComponents\":[{\"properties\":[{\"type\":\"txt\",\"name\":\"PROP1\"},{\"type\":\"txt\",\"name\":\"PROP2\"}],\"sequence\":\"\",\"direction\":1,\"name\":\"PT1\"},{\"properties\":[{\"type\":\"txt\",\"name\":\"PROP1\"},{\"type\":\"txt\",\"name\":\"PROP2\"}],\"sequence\":\"\",\"direction\":1,\"name\":\"PT2\"},{\"properties\":[{\"type\":\"txt\",\"name\":\"PROP1\"},{\"type\":\"txt\",\"name\":\"PROP2\"}],\"sequence\":\"\",\"direction\":1,\"name\":\"PT3\"},{\"properties\":[{\"type\":\"txt\",\"name\":\"PROP1\"},{\"type\":\"txt\",\"name\":\"PROP2\"}],\"sequence\":\"\",\"direction\":1,\"name\":\"PT4\"},{\"properties\":[{\"type\":\"txt\",\"name\":\"PROP1\"},{\"type\":\"txt\",\"name\":\"PROP2\"}],\"sequence\":\"\",\"direction\":1,\"name\":\"PT5\"}],\"maxDepth\":1,\"properties\":[],\"sequence\":\"\",\"direction\":1,\"name\":\"D5\"}");
			Device device = (Device)this.mapper.readValue(deviceJSON, Device.class);
			System.out.println(device.toString());
		} catch(Exception e) {
			e.printStackTrace();
			throw new EugeneException(e.toString());
		}
	}
}
