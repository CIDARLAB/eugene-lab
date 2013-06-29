package org.cidarlab.eugenelab.clotho3;

import java.util.Random;
import org.clothocad.client.Clotho;
import org.clothocad.client.ClothoFactory;
import org.json.JSONObject;

/**
 *
 * @author ernstl
 */
public class Clotho3Tester {
    
    public static void main(String[] args) {
        
        Clotho clotho = ClothoFactory.getAPI("ws://localhost:8080/websocket");
        //Clotho clotho = ClothoFactory.getAPI("ws://cidar.bu.edu/clotho/websocket");
        
        System.out.println("*** LOGIN ***");
        
        clotho.query(createQueryAllPartsJSON());
        
        if(clotho.login()) {       
            
            /**
            for(int i=1; i<=100; i++) {
                JSONObject json = new JSONObject();
                try {
                    json.put("name", "Part_"+i);
                    json.put("sequence", generateRandomSequence());

                    System.out.println("*** CREATE ***");
                    System.out.println(json.toString());
                    clotho.create(json);
                } catch(Exception e) {
                    e.printStackTrace();
                }
                
                try {
                    Thread.sleep(500);
                } catch(Exception e) {}
            }
            **/
            
            // now, I'd like to fetch all parts from the database
            //clotho.get();
            
            System.out.println("*** LOGOUT ***");
            clotho.logout();
        } else {
            System.out.println("F**K");
        }
    }
    
        private static JSONObject createQueryAllPartsJSON() {
            /*
             * {"channel": "query", data: {"schema":"Part"}}
             */
            try {
                JSONObject json = new JSONObject();
                json.put("auth_key", "some_auth_key");
                json.put("channel", "query");

                JSONObject data = new JSONObject();
                data.put("Schema", "Part");
                json.put("data", data);

                return json;
            } catch(Exception e) {
                e.printStackTrace();
            }
            return null;
        }

    private static String generateRandomSequence() {
        StringBuilder sb = new StringBuilder();
        Random generator = new Random();
        for(int i=1; i<100; i++) {
            int n = generator.nextInt(4);
            switch(n) {
                case 0:
                    sb.append("A");
                case 1:
                    sb.append("T");
                case 2:
                    sb.append("C");
                case 3:
                    sb.append("G");
            }
        }
        return sb.toString();
    }
}
