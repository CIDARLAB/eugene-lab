package org.cidarlab.eugenelab.eugene;

import eugene.Eugene;
import eugene.EugeneExecutor;
import eugene.dom.PropertyValue;
import eugene.dom.SavableElement;
import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.dom.components.Part;
import eugene.dom.components.Property;
import eugene.dom.components.types.PartType;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.clothocad.client.Clotho;
import org.clothocad.client.ClothoFactory;
import org.json.JSONObject;

/**
 *
 * @author ernstl
 */
public class EugeneTest {

    public static void main(String[] args)
            throws Exception {
        new EugeneTest().testInverters();
        System.exit(0);
    }

    public void testInverters()
            throws Exception {
        //Clotho clotho = ClothoFactory.getAPI("ws://localhost:8080/websocket");
        
        Clotho clotho = ClothoFactory.getAPI("ws://cidar.bu.edu/clotho/websocket");
        
        HashMap<String, SavableElement> results = (HashMap<String, SavableElement>) EugeneExecutor.execute(
                new File("./examples/inverter_rev1.eug"), 2);

        if (null != results && !results.isEmpty()) {
            for (String s : results.keySet()) {
                SavableElement objElement = results.get(s);
                if (objElement instanceof Device) {

                    Device objDevice = (Device) objElement;

                    /* we need to convert the Device into a nice JSON representation */
                    JSONObject deviceJSON = this.toJSON(objDevice);
                    
                    // now, we store it in the Clotho DB...
                    //clotho.create(deviceJSON);

                    System.out.println("Device: " + deviceJSON);
                }
            }
        }
        /**
         * // TODO: // package the results into a JSON object for(String
         * s:results.keySet()) { SavableElement se = results.get(s); }
        * *
         */
    }

    private JSONObject toJSON(Device objDevice) 
            throws Exception {
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder sbPigeon = new StringBuilder();
        StringBuilder sbPigeonArcs = new StringBuilder();
        
        sbPigeonArcs.append("# Arcs").append(NEWLINE);
        
        JSONObject deviceJSON = new JSONObject();
        deviceJSON.put("name", objDevice.getName());
        deviceJSON.put("Schema", objDevice.getClass().getCanonicalName());

        List<Component> lstComponents = objDevice.getAllComponents();
        List<JSONObject> lstComponentsJSON = new ArrayList<JSONObject>();
        
        for(Component component : lstComponents) {
            JSONObject componentJSON = new JSONObject();
            componentJSON.put("name", component.getName());
            componentJSON.put("Schema", component.getClass().getCanonicalName());
            if(component instanceof Device) {
                componentJSON = this.toJSON((Device)component);
            } else if(component instanceof PartType) {
                //componentJSON.put("name", lstComponents)
            } else if(component instanceof Part) {
                Part objPart = (Part)component;
                List<JSONObject> lstPropertyValuesJSON = new ArrayList<JSONObject>();
                componentJSON.put("pigeon", objPart.get("Pigeon"));
                sbPigeon.append(objPart.get("Pigeon")).append(NEWLINE);
                
                if(null != objPart.get("Represses")) {
                    sbPigeonArcs.append(objPart.getName())
                            .append(" rep ")
                            .append(objPart.get("Represses"))
                            .append(NEWLINE);
                }
            } 
            lstComponentsJSON.add(componentJSON);
        }
        deviceJSON.put("components", lstComponentsJSON);
        
        String sPigeon = sbPigeon.toString() + sbPigeonArcs.toString();
        deviceJSON.put("Pigeon", sPigeon);

        return deviceJSON;
    }
}
