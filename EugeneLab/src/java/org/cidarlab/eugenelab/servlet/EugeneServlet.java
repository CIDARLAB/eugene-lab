package org.cidarlab.eugenelab.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.biojava.bio.BioException;
import org.biojava.bio.seq.Feature;
import org.biojava.bio.seq.Sequence;
import org.biojava.bio.seq.SequenceIterator;
import org.biojava.bio.seq.io.SeqIOTools;
import org.cidarlab.eugenelab.data.ScriptCollector;
import org.cidarlab.minieugene.MiniEugene;
import org.cidarlab.minieugene.MiniEugeneFactory;
import org.cidarlab.minieugene.MiniEugeneReturn;
import org.cidarlab.minieugene.stats.Measurement;
import org.cidarlab.minieugene.symbol.Symbol;
import org.cidarlab.weyekin.WeyekinPoster;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;

/**
 *
 * @author Admin
 */
public class EugeneServlet extends HttpServlet {

    @Override
    public void init()
            throws ServletException {

        super.init();

        //this.clotho = ClothoFactory.getAPI("ws://localhost:8080/websocket");
    }

    @Override
    public void destroy() {
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processGetRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //I'm returning a JSON object and not a string
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String command = request.getParameter("command");

        try {
            if (command.equals("imageList")) {
                out.write(readImageFiles());
            } else if (command.equals("run")) {
                /* try {*/
                String devices = request.getParameter("devices");
                String toReturn = run(request.getSession().getId(), devices);
                toReturn = "{\"response\":\"response\"}";
                out.write(toReturn);
                /*
                 } catch (Exception e) {
                 JSONObject myJSON = new JSONObject();
                 myJSON.put("results", "Exception (Dummy String)");
                 myJSON.put("status", "exception");
                 }
                 */
            } else if (command.equals("read")) {
                // That's how the query should look like:
                // {"channel":"query","data":{"schema":"org.cidarlab.eugene.dom.component.Part"}}
                // process the data for EugeneLab...
                //System.out.println(this.getData());

                /* option 1: 
                 * retrieve the parts from Clotho
                 */
//                 JSONObject queryJSON = new JSONObject();
//                 try {
//                 queryJSON.put("schema", "eugene.dom.component.Part");
//                 out.write(clotho.query(queryJSON).toString());
//                 } catch(Exception e) {
//                     e.printStackTrace();
//                 }
//                 

                /* option 2:
                 * load the parts from a Eugene script
                 JSONObject json = this.getData();
                 if (null != json) {
                 out.write(this.getData().toString());
                 }
                 */
//                out.write(simulateReadingPartsFromClotho());
//                out.write(readFiles());
            } else if (command.equals("getFileTree")) {
                out.write(getFileTree());
            } else if (command.equals("getFileContent")) {
                response.setContentType("text/html;charset=UTF-8");
                String fileName = request.getParameter("fileName");
                String toReturn = loadFile(fileName);
                out.write(toReturn);
            } else if (command.equals("test")) {
                out.write("{\"response\":\"test response\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            String exceptionAsString = stringWriter.toString().replaceAll("[\r\n\t]+", "<br/>");
            out.println("{\"result\":\"" + exceptionAsString + "\",\"status\":\"exception\"}");
        } finally {
            out.flush();
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processGetRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processPostRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>

    protected void processPostRequest(HttpServletRequest request, HttpServletResponse response) 
               throws IOException {
        
//        System.out.println("[EugeneServlet.processPostRequest] sessionId -> " + request.getSession().getId());

        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                ServletFileUpload uploadHandler = new ServletFileUpload(new DiskFileItemFactory());
                PrintWriter writer = response.getWriter();
                response.setContentType("application/json");
                response.sendRedirect("eugenelab.html");
                List<FileItem> items = uploadHandler.parseRequest(request);
                //String uploadFilePath = this.getServletContext().getRealPath("/") + "/data/" + getCurrentUser() + "/";
                String uploadFilePath = Paths.get(this.getServletContext().getRealPath(""), "data", getCurrentUser()).toString();
                new File(uploadFilePath).mkdir();
                ArrayList<File> toLoad = new ArrayList();
                for (FileItem item : items) {
                    File file;
                    if (!item.isFormField()) {
                        String fileName = item.getName();
                        if (fileName.equals("")) {
                            System.out.println("You forgot to choose a file.");
                        }
                        if (fileName.lastIndexOf("\\") >= 0) {
                            file = new File(uploadFilePath + fileName.substring(fileName.lastIndexOf("\\")));
                        } else {
                            file = new File(uploadFilePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
                        }
                        item.write(file);
                        toLoad.add(file);
                    }
                }
                writer.write("{\"result\":\"good\",\"status\":\"good\"}");
            } catch (FileUploadException ex) {
                Logger.getLogger(EugeneServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(EugeneServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            PrintWriter out = null;
            try {
                response.setContentType("application/json");
                out = response.getWriter();
                String command = request.getParameter("command");
                if (command.equals("execute")) {
                    String input = request.getParameter("input");
                    JSONObject result = executeEugene(
                            request.getSession().getId(),
                            input);
                    out.write(result.toString());
                } else if (command.equals("execute-miniEugene")) {
                    boolean bOk = true;
                	int sizeOfDesign = Integer.parseInt(
                            request.getParameter("N"));
                    String input = request.getParameter("input");                    
                    boolean predefined = Boolean.parseBoolean(
                            request.getParameter("predefined"));
                    
                    JSONObject result = new JSONObject();
                    
                    /*
                     * currently, we find all solutions
                     * -> we plan on allowing the user to specify a
                     *    desired number of solutions
                     */
                    int nrOfSolutions = -1;
                    
//                    if(!request.getParameter("NrOfSolutions").trim().isEmpty()) {
//                    	try {
//                    		nrOfSolutions = Integer.parseInt(
//                    				request.getParameter("NrOfSolutions"));
//                    		if(nrOfSolutions < 0) {
//                    			throw new Exception();
//                    		}
//                    	} catch(Exception e) {
//                    		result.put("status", "exception");
//                    		result.put("results", "Invalid Number of Solutions!");
//                    		out.write(result.toString());
//                    		bOk = false;
//                    	}
//                    }
                    
                    if(bOk) {
                    	result = executeMiniEugene(
                            	request.getSession().getId(), 
                            	sizeOfDesign, input, predefined, nrOfSolutions);
                    
                    	/*
                    	 * for ``data'' collection
                    	 */                    
                    	collectScript(
                    			request.getSession().getId(), 
                    			sizeOfDesign, 
                    			input);

                    	out.write(result.toString());
                    }
                    
                } else if (command.equals("saveFileContent")) {
                    String fileName = request.getParameter("fileName");
                    String fileContent = request.getParameter("fileContent");
                    saveFile(fileName, fileContent);
                    out.write("{\"status\":\"good\"}");
                } else if ("Pigeon".equals(command)) {
                    String sPigeon = request.getParameter("Pigeon");
                    WeyekinPoster.setPigeonText(sPigeon);
                    WeyekinPoster.postMyBird();
                } 
/**                
                else if (command.equals("executeSBOL")) {

                } else if (command.equals("executeGenBank")) {

                }
 **/                
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                out.flush();
                out.close();
            }
        }
    }

    private String run(String sessionId, String devices){
        return null;
    }

    private String getCurrentUser() {
        return "testuser";
    }

    private String readImageFiles() {
        //get path relative to servlet; ie the /web directory
        String imagePath = Paths.get(this.getServletContext().getRealPath(""), "images", "sbol_visual_jpeg").toString();
        String toReturn = "[";
        File[] filesInDirectory = new File(imagePath).listFiles();
        if (filesInDirectory != null) {
            for (File currentFile : filesInDirectory) {
                String filePath = currentFile.getAbsolutePath();
                String fileExtension = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length()).toLowerCase();
                //grab only files that have jpeg extension
                if ("jpeg".equals(fileExtension)) {
                    toReturn = toReturn + "{\"fileName\":\"" + currentFile.getName() + "\"},";
                }
            }
        }
        toReturn = toReturn.substring(0, toReturn.length() - 1);
        toReturn = toReturn + "]";
        return toReturn;
    }

    public JSONObject executeMiniEugene(
            String sessionId, 
            int N, String input, boolean predefined, int nrOfSolutions) {

        JSONObject returnJSON = new JSONObject();
        
        try {
        	
        	MiniEugene me = MiniEugeneFactory.instantiate();
            /*
             * -1 ... currently we find all solutions 
             */
            MiniEugeneReturn eugeneReturn = me.execute(input, N, -1);
 

            List<JSONObject> lstUriJSON = new ArrayList<JSONObject>();
            List<JSONObject> lstStatsJSON = new ArrayList<JSONObject>();
    		JSONObject solutionsJSON = new JSONObject();

            if(null != eugeneReturn) {
	            /*
	             * if there was no exception thrown, then
	             * the result is a list of URIs that refer to 
	             * pigeon images
	             */
//            	System.out.println(eugeneReturn.getURIs().size());
	            if (null != eugeneReturn.getURIs() && !eugeneReturn.getURIs().isEmpty()) {
	                for(URI uri : eugeneReturn.getURIs()) {
	                    JSONObject json = new JSONObject();
	                    json.put("pigeon-uri", uri);
	                    lstUriJSON.add(json);
	                }
	            }
	            
	            if (null != eugeneReturn.getStatistics() && !(eugeneReturn.getStatistics()).isEmpty()) {
	            	for(Measurement m : eugeneReturn.getStatistics().getMeasurements()) {
	            		JSONObject statsJSON = new JSONObject();
	            		statsJSON.put("name", m.getKey());
	            		statsJSON.put("value", m.getValue());
	            		lstStatsJSON.add(statsJSON);	            		
	            	}
	            }
	            
	            /* 
	             * textual representation of the solutions
	             */
	            if (null != eugeneReturn.getSolutions() && !(eugeneReturn.getSolutions()).isEmpty()) {

	            	StringBuilder sb = new StringBuilder();
	            	sb.append("<table class=\"table table-bordered table-hover\" id=\"solutionList\">");
	            	
	            	for(Symbol[] solution :  eugeneReturn.getSolutions()) {	 
	            		sb.append("<tr><td>");
	            		for(int i=0; i<solution.length; i++) {
	            			Symbol symbol = solution[i];
	            			if(!symbol.isForward()) {
	            				sb.append("-");
	            			} 
	            			sb.append(symbol.getName());
	            			if(i != solution.length - 1) {
	            				sb.append(", ");
	            			}
	            		}
	            		sb.append("</td></tr>");
	            	}
	            	sb.append("</table>");
	            	
//	            	System.out.println(sb.toString());
	            	
	            	solutionsJSON.put("solution", sb.toString());
	            }
            }
            
            // SBOL
            if(eugeneReturn.hasSBOL()) {
            	
            	/*
            	 * remove web/
            	 */
                String sbolFilePath = Paths.get(this.getServletContext().getRealPath(""), "data", "sbol").toString();
                new File(sbolFilePath).mkdir();

                String uuid = UUID.randomUUID().toString();

                String filename = sbolFilePath+"/"+uuid+".sbol";
                eugeneReturn.serializeSBOL(filename);

            	returnJSON.put("sbol", "./data/sbol/"+uuid+".sbol");
            }
            
            returnJSON.put("results", lstUriJSON);
            returnJSON.put("stats", lstStatsJSON);
            returnJSON.put("solutions", solutionsJSON);
            
            returnJSON.put("status", "good");

        } catch(Exception e) {
        	e.printStackTrace();
            try {
                returnJSON.put("status", "exception");
                returnJSON.put("results", e.toString());
            } catch(JSONException jse) {}
        }
        
        return returnJSON;
    }
    
    private void collectScript(String sessionId, int N, String script) {
    	/*
    	 * get the path (of the servlet context)
    	 */
        String scriptPath = Paths.get(
        		this.getServletContext().getRealPath(""), 
        		"data", 
        		"scripts", 
        		sessionId).toString();

        /*
         * start a thread (the script collector) that 
         * writes the script to the given file
         */
    	new ScriptCollector(scriptPath, N, script).run();    	
    }
    
    public JSONObject executeEugene(String sessionId, String input) {

        JSONObject returnJSON = new JSONObject();
        try {
            returnJSON.put("results", "***Exception-Dummy-String***");
            returnJSON.put("status", "exception");
        } catch(Exception e) {}
        return returnJSON;
    }

    // Returns a JSON Array with the name of a file/directory and if it is a file
    // {"name": name, "isFile", isFile}
    private String getFileTree() {
       //String currentFolderExtension = this.getServletContext().getRealPath("/") + "/data/" + getCurrentUser() + "/";
       String currentFolderExtension = Paths.get(this.getServletContext().getRealPath(""), "data", getCurrentUser()).toString();        
       
        File rootFolder = new File(currentFolderExtension);
        ArrayList<File> queue = new ArrayList();
        ArrayList<JSONArray> folders = new ArrayList();
        ArrayList<Integer> folderSizes = new ArrayList();
        File[] rootFiles = rootFolder.listFiles();
        if (null == rootFiles) {
            return "";
        }
        for (int i = 0; i < rootFiles.length; i++) {
            queue.add(rootFiles[i]);
        }

        JSONArray rootArray = new JSONArray();
        JSONArray currentArray = rootArray;
        boolean switchFolder = false;
        int currentFolderSize = rootFolder.listFiles().length;
        int counter = 1;
        while (!queue.isEmpty()) {
            try {
                File currentFile = queue.get(0);
                queue.remove(0);
//                System.out.println(switchFolder + " " + counter + " | " + currentFolderSize + " " + currentFile.getName());

                if (!switchFolder) {
                    switchFolder = false;
                }
                JSONObject toPut = new JSONObject();
                toPut.put("title", currentFile.getName());
                currentArray.put(toPut);
                if (currentFile.isDirectory()) {
                    switchFolder = true;
                    toPut.put("children", new JSONArray());
                    toPut.put("isFolder", true);
                    if (currentFile.listFiles().length > 0) {
                        folderSizes.add(currentFile.listFiles().length);
                        folders.add(toPut.getJSONArray("children"));
                    }
                    File[] subFiles = currentFile.listFiles();
                    for (int i = 0; i < subFiles.length; i++) {
                        queue.add(subFiles[i]);
                    }
                }
                if (switchFolder && counter == currentFolderSize) {
//                    System.out.println("switching");
//                    System.out.println(folderSizes);
                    currentArray = folders.get(0);
                    currentFolderSize = folderSizes.get(0);
                    folderSizes.remove(0);
                    folders.remove(0);
                    counter = 0;
                    switchFolder = false;
                }
            } catch (JSONException ex) {
                ex.printStackTrace();
            }
            counter++;
        }
        return rootArray.toString();
    }

    private String loadFile(String fileName) {
        BufferedReader br = null;
        try {
            String currentFileExtension = getFileExtension(fileName, true);
            File file = new File(currentFileExtension);
            br = new BufferedReader(new FileReader(file.getAbsolutePath()));
            String toReturn = "";
            String line = br.readLine();
            while (line != null) {
                toReturn = toReturn + "\n" + line;
                line = br.readLine();
            }
            br.close();
            return toReturn;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "the bads";
        }
    }

    private void saveFile(String fileName, String fileContent) throws IOException {
        String currentFileExtension = getFileExtension("/" + fileName, true);
        File file = new File(currentFileExtension);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        bw.write(fileContent);
        bw.close();
    }

    private String getFileExtension(String localExtension, boolean isFile) {
        //String extension = this.getServletContext().getRealPath("/") + "/data/" + getCurrentUser() + "/" + localExtension;
        String extension = Paths.get(this.getServletContext().getRealPath(""), "data", getCurrentUser(), localExtension).toString();
        if (!isFile) {
            extension += "/";
        }
        return extension;
    }

    public JSONObject getData() {
        List<JSONObject> lstParts = new ArrayList<JSONObject>();

        try {
            /***
            File f = new File(this.getServletContext().getRealPath("/")
                    + "/eugene-examples/inverter_data.eug");

            HashMap<String, SavableElement> hm =
                    (HashMap<String, SavableElement>) EugeneExecutor.execute(f, 2);

            for (String s : hm.keySet()) {
                SavableElement objElement = hm.get(s);

                if (objElement instanceof Part) {
                    JSONObject partJSON = new JSONObject();
                    Part objPart = (Part) objElement;

                    partJSON.put("schema", "BasicPart");
                    partJSON.put("name", objPart.getName());
                    partJSON.put("type", objPart.getPartType().getName());
                    partJSON.put("sequence", objPart.get("Sequence").toString().replaceAll("\n", ""));
                    partJSON.put("Pigeon", objPart.get("Pigeon"));
                    if (null != objPart.get("Represses")) {
                        partJSON.put("represses", objPart.get("Represses"));
                    }

                    lstParts.add(partJSON);
                }
            }

            // pigeon-url ... 
            
            JSONObject resultJSON = new JSONObject();
            resultJSON.put("result", lstParts);

            //System.out.println(dataJSON);

            return resultJSON;
            //this.clotho.create(dataJSON);
            ***/ 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    


    private static String getRandomSequence() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            switch (random.nextInt(4)) {
                case 0:
                    sb.append("A");
                    break;
                case 1:
                    sb.append("T");
                    break;
                case 2:
                    sb.append("C");
                    break;
                case 3:
                    sb.append("G");
                    break;
            }
        }
        return sb.toString();
    }


    private void removeOverlap(List<Feature> features) {
        // Sort the features based on when they start in the sequence
        Collections.sort(features, new Comparator<Feature>() {
            @Override
            public int compare(Feature a, Feature b) {
                return a.getLocation().getMin() - b.getLocation().getMin();
            }
        });
        int i = 0;
        while (i <= features.size() - 2) {
            Feature a = features.get(i);
            Feature b = features.get(i + 1);
            String typeA = a.getType();
            String typeB = b.getType();
            if (typeA.equals("source")) {
                features.remove(a);
            } else if (typeB.equals("source")) {
                features.remove(b);
            } else if (isSameFeature(a, b)) {
                if (typeA.equals("gene")) {
                    features.remove(b);
                } else if (typeB.equals("gene")) {
                    features.remove(a);
                    // Do not advance as current feature is still at i
                } else {
                    features.remove(a);
                }
            } else if (firstContainsSecond(a, b)) {
                features.remove(b);
                i++;
            } else if (firstContainsSecond(b, a)) {
                features.remove(a);
            } else {
                i++;
            }
        }
    }

    private boolean isSameFeature(Feature a, Feature b) {
        return a.getLocation().getMin() == b.getLocation().getMin()
                && a.getLocation().getMax() == b.getLocation().getMax();
    }

    private boolean firstContainsSecond(Feature a, Feature b) {
        return a.getLocation().getMin() <= b.getLocation().getMin()
                && a.getLocation().getMax() >= b.getLocation().getMax();
    }

    /**
    // Takes a device and stores it in Clotho
    private boolean toClotho(NamedElement element) {
        try {
            if (element instanceof Device) {
                //return clotho.create(this.toJSON((Device)element));   
            } else if (element instanceof Part) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    **/
}
