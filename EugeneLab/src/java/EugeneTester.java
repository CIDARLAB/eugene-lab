
import org.cidarlab.eugene.EugeneExecutor;
import org.cidarlab.eugene.dom.SavableElement;
import org.cidarlab.eugene.dom.components.Component;
import org.cidarlab.eugene.dom.components.Device;
import org.cidarlab.eugene.dom.components.Part;
import org.cidarlab.eugene.dom.components.types.PartType;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernstl
 */
public class EugeneTester {
    
    public static void main(String[] args) 
            throws Exception {
        EugeneTester et = new EugeneTester();
        et.execute("./web/eugene-examples/inverter_rev3.eug");
    }

    public void execute(String sFile) 
            throws Exception {
        
        //(HashMap<String, SavableElement>) EugeneExecutor.execute(input, 2)
        HashMap<String, SavableElement> results = 
                (HashMap<String, SavableElement>)EugeneExecutor.execute(
                    new File(sFile), 2);
        System.out.println(results.size());
        if(null != results && !results.isEmpty()) {
            for(String key:results.keySet()) {
                SavableElement objElement = results.get(key);
                
                JSONObject json = this.toJSON((Device)objElement);
                System.out.println(json.get("Pigeon"));
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

        for (Component component : lstComponents) {
            JSONObject componentJSON = new JSONObject();
            componentJSON.put("name", component.getName());
            componentJSON.put("Schema", component.getClass().getCanonicalName());
            if (component instanceof Device) {
                componentJSON = this.toJSON((Device) component);
            } else if (component instanceof PartType) {
                //componentJSON.put("name", lstComponents)
            } else if (component instanceof Part) {
                Part objPart = (Part) component;
                List<JSONObject> lstPropertyValuesJSON = new ArrayList<JSONObject>();
                componentJSON.put("pigeon", objPart.get("Pigeon"));
                sbPigeon.append(objPart.get("Pigeon")).append(NEWLINE);

                if (null != objPart.get("Represses")) {
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
