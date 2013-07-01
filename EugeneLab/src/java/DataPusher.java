

import eugene.EugeneExecutor;
import eugene.dom.SavableElement;
import eugene.dom.components.Part;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.clothocad.client.Clotho;
import org.clothocad.client.ClothoFactory;
import org.json.JSONObject;

/**
 *
 * @author E. Oberortner
 */
public class DataPusher {
    
    private Clotho clotho;

    public DataPusher() {
        this.clotho = ClothoFactory.getAPI("ws://cidar.bu.edu/clotho/websocket");
    }
    
    public void pushData() {
        List<JSONObject> lstParts = new ArrayList<JSONObject>();
        
        try {
            HashMap<String, SavableElement> hm = 
                    (HashMap<String, SavableElement>)EugeneExecutor.execute(new File("./web/eugene-examples/inverter_data.eug"), 2);
            
            for(String s:hm.keySet()) {
                SavableElement objElement = hm.get(s);
                
                if(objElement instanceof Part) {
                    JSONObject partJSON = new JSONObject();
                    Part objPart = (Part)objElement;
                    
                    partJSON.put("Schema", "eugene.dom.components.Part");                    
                    partJSON.put("Name", objPart.getName());
                    partJSON.put("PartType", objPart.getPartType().getName());
                    partJSON.put("Sequence", objPart.get("Sequence"));
                    partJSON.put("Pigeon", objPart.get("Pigeon"));
                    if(null != objPart.get("Represses")) {
                        partJSON.put("Represses", objPart.get("Represses"));
                    }
                    
                    lstParts.add(partJSON);
                }   
            }
            
            JSONObject dataJSON = new JSONObject();
            dataJSON.put("data", lstParts);
            //System.out.println(dataJSON);
            
            this.clotho.create(dataJSON);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        DataPusher dp = new DataPusher();
        dp.pushData();        
    }
}