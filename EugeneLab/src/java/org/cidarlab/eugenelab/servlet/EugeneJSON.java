/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.eugenelab.servlet;

import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.dom.components.Part;
import eugene.dom.components.types.PartType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Erik
 */
public class EugeneJSON {
    /**
     * Converts a Eugene part into a JSON Object
     * <p>
     * The JSON object contains a name field, a schema field, and a type field with the part type
     * @TODO: Pigeon field?
     * 
     */
    public static JSONObject toJSON(Part part) throws JSONException {
        JSONObject partJSON = new JSONObject();
        partJSON.put("name", part.getName());
        partJSON.put("schema", "Part");
        partJSON.put("type", part.getPartType().getName());
        partJSON.put("sequence", part.getSequence().toString().replaceAll("\n", ""));
        partJSON.put("pigeon", part.get("Pigeon"));
        return partJSON;
    }
    
    public static JSONObject toJSON(PartType pt) throws JSONException {
        JSONObject ptJSON = new JSONObject();
        ptJSON.put("name", pt.getName());
        ptJSON.put("schema", "PartType");
        return ptJSON;
    }
    
    public static JSONObject toJSON(Component c) throws Exception {
        if(c instanceof Device) {
            return toJSON((Device) c);
        } else if (c instanceof Part) {
            return toJSON((Part) c);
        } else if (c instanceof PartType) {
            return toJSON((PartType) c);
        } else {
            return null;
        }
    }
    
    public static JSONArray toJSONPartArray(Component c) throws JSONException {
        List componentList = new ArrayList<Component>();
        componentList.add(c);
        return toJSONPartArray(componentList);
    }
    
    public static JSONArray toJSONPartArray(List<Component> componentList) throws JSONException {
        JSONArray result = new JSONArray();
        for(Component c: componentList) {
            if(c instanceof Device) {
                JSONArray ja = toJSONPartArray(((Device)c).getAllComponents());
                result = combine(result, ja);
            } else if(c instanceof Part) {
                result.put(toJSON((Part)c));
            } else if(c instanceof PartType) {
                result.put(toJSON((PartType)c));
            }
        }
        return result;
    }
    
    private static JSONArray combine(JSONArray ja1, JSONArray ja2) throws JSONException {
        JSONArray result = new JSONArray();
        for(int i = 0; i < ja1.length(); i++) {
            result.put(ja1.get(i));
        }
        for(int i = 0; i < ja2.length(); i++) {
            result.put(ja2.get(i));
        }
        return result;
    }
    
    public static JSONObject toJSON(Device objDevice)
            throws Exception {
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder sbPigeon = new StringBuilder();
        StringBuilder sbPigeonArcs = new StringBuilder();

        sbPigeonArcs.append("# Arcs").append(NEWLINE);

        JSONObject deviceJSON = new JSONObject();
        deviceJSON.put("name", objDevice.getName());
        deviceJSON.put("schema", "CompositePart");
        deviceJSON.put("type", "composite");
        List<Component> lstComponents = objDevice.getAllComponents();
        List<JSONObject> lstComponentsJSON = new ArrayList<JSONObject>();

        for (Component component : lstComponents) {
            JSONObject componentJSON = new JSONObject();
            componentJSON.put("name", component.getName());
            componentJSON.put("schema", "BasicPart");
            if (component instanceof Device) {
                componentJSON = toJSON((Device) component);
            } else if (component instanceof PartType) {
                //componentJSON.put("name", lstComponents)
            } else if (component instanceof Part) {
                Part objPart = (Part) component;
                List<JSONObject> lstPropertyValuesJSON = new ArrayList<JSONObject>();
                componentJSON.put("Pigeon", objPart.get("Pigeon"));
                sbPigeon.append(objPart.get("Pigeon")).append(NEWLINE);
                componentJSON.put("sequence", objPart.get("Sequence").toString().replaceAll("\n", ""));
                componentJSON.put("type", objPart.getPartType().getName());
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
