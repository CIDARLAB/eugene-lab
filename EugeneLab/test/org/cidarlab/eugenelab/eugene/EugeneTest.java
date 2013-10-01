package org.cidarlab.eugenelab.eugene;

import org.cidarlab.eugene.Eugene;
import org.cidarlab.eugene.EugeneExecutor;
import org.cidarlab.eugene.dom.PropertyValue;
import org.cidarlab.eugene.dom.SavableElement;
import org.cidarlab.eugene.dom.components.Component;
import org.cidarlab.eugene.dom.components.Device;
import org.cidarlab.eugene.dom.components.Part;
import org.cidarlab.eugene.dom.components.Property;
import org.cidarlab.eugene.dom.components.types.PartType;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/**
 *
 * @author ernstl
 */
public class EugeneTest {

    public static void main(String[] args)
            throws Exception {
        //new EugeneTest().testInverters();
        //new EugeneTest().testNORGates();
        //new EugeneTest().testInvertaseNOR();
        new EugeneTest().testNiF();
        System.exit(0);
    }

    public void testInverters()
            throws Exception {
        Set<JSONObject> results = (HashSet<JSONObject>) EugeneExecutor.execute(
                new File("./web/data/testuser/Examples/SynBERC/inverter.eug"), 3);

        if (null != results && !results.isEmpty()) {
            Iterator<JSONObject> it = results.iterator();
            while(it.hasNext()) {
                JSONObject json = it.next();
                
                System.out.println(json.toString());
            }
        }
        /**
         * // TODO: // package the results into a JSON object for(String
         * s:results.keySet()) { SavableElement se = results.get(s); }
        * *
         */
    }

    public void testNORGates()
            throws Exception {
        Set<JSONObject> results = (HashSet<JSONObject>) EugeneExecutor.execute(
                new File("./web/data/testuser/Examples/SynBERC/nor-gate.eug"), 3);

        if (null != results && !results.isEmpty()) {
            Iterator<JSONObject> it = results.iterator();
            while(it.hasNext()) {
                JSONObject json = it.next();
                
                System.out.println(json.toString());
            }
        }
    }

    public void testInvertaseNOR()
            throws Exception {
        Set<JSONObject> results = (HashSet<JSONObject>) EugeneExecutor.execute(
                new File("./web/data/testuser/Examples/SynBERC/invertase-nor.eug"), 3);

        if (null != results && !results.isEmpty()) {
            Iterator<JSONObject> it = results.iterator();
            while(it.hasNext()) {
                JSONObject json = it.next();
                
                System.out.println(json.toString());
            }
        }
    }

    public void testNiF()
            throws Exception {
//        Set<JSONObject> results = (HashSet<JSONObject>) EugeneExecutor.execute(
//                new File("./web/data/testuser/Examples/SynBERC/NiF.eug"), 3);
        Set<JSONObject> results = (HashSet<JSONObject>) EugeneExecutor.execute(
                new File("./web/data/testuser/Examples/SynBERC/NiF.eug"), 3);

        if (null != results && !results.isEmpty()) {
            Iterator<JSONObject> it = results.iterator();
            while(it.hasNext()) {
                JSONObject json = it.next();
                
                System.out.println(json.toString());
            }
        }
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
