package org.cidarlab.eugenelab.servlet;


import org.cidarlab.eugene.EugeneExecutor;
import org.cidarlab.eugene.data.genbank.GenbankImporter;
import org.cidarlab.eugene.data.sbol.SBOLImporter;
import org.cidarlab.eugene.dom.NamedElement;
import org.cidarlab.eugene.dom.PropertyValue;
import org.cidarlab.eugene.dom.SavableElement;
import org.cidarlab.eugene.dom.components.Component;
import org.cidarlab.eugene.dom.components.Device;
import org.cidarlab.eugene.dom.components.Part;
import org.cidarlab.eugene.dom.components.Property;
import org.cidarlab.eugene.dom.components.types.PartType;
import org.cidarlab.eugene.exception.EugeneException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.antlr.runtime.RecognitionException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.biojava.bio.BioException;
import org.biojava.bio.seq.Feature;
import org.biojava.bio.seq.Sequence;
import org.biojava.bio.seq.SequenceIterator;
import org.biojava.bio.seq.io.SeqIOTools;

import org.cidarlab.eugene.builder.EugeneBuilder;

import org.cidarlab.weyekin.WeyekinPoster;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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
                String devices = request.getParameter("devices");
                String toReturn = run(devices);
                toReturn = "{\"response\":\"response\"}";
                out.write(toReturn);
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
                 */
                JSONObject json = this.getData();
                if (null != json) {
                    out.write(this.getData().toString());
                }

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
            out.println("{\"result\":\"" + exceptionAsString + "\",\"status\":\"bad\"}");
        } finally {
            out.flush();
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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

    protected void processPostRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                ServletFileUpload uploadHandler = new ServletFileUpload(new DiskFileItemFactory());
                PrintWriter writer = response.getWriter();
                response.setContentType("application/json");
                response.sendRedirect("eugenelab.html");
                List<FileItem> items = uploadHandler.parseRequest(request);
                String uploadFilePath = this.getServletContext().getRealPath("/") + "/data/" + getCurrentUser() + "/";
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
                    JSONObject result = executeEugene(input);
                    out.write(result.toString());
                } else if (command.equals("saveFileContent")) {
                    String fileName = request.getParameter("fileName");
                    String fileContent = request.getParameter("fileContent");
                    saveFile(fileName, fileContent);
                    out.write("{\"status\":\"good\"}");
                } else if ("Pigeon".equals(command)) {
                    String sPigeon = request.getParameter("Pigeon");
                    WeyekinPoster.setPigeonText(sPigeon);
                    WeyekinPoster.postMyBird();
                } else if (command.equals("executeSBOL")) {
                    String fileName = request.getParameter("input");
                    fileName = getFileExtension(fileName, true);
                    NamedElement eugeneConversion;
                    String result;
                    try {
                        eugeneConversion = convertSBOL(fileName);
                        result = eugeneConversion.toString().replaceAll("[\r\n\t]+", " ");
                        result = "{\"results\":\"" + result + "\", \"status\":\"good\"}";
                    } catch (Exception e) {
                        e.printStackTrace();
                        String exceptionAsString = e.toString().replaceAll("[\r\n\t]+", " ");
                        exceptionAsString = exceptionAsString.replaceAll("[\"]+", "'");
                        result = "{\"result\":\"" + exceptionAsString + "\",\"status\":\"bad\"}";
                    }
                    out.write(result);
                } else if (command.equals("executeGenBank")) {
                    response.setContentType("text/plain");
                    String result;
                    String fileName = request.getParameter("input");
                    fileName = getFileExtension(fileName, true);
                    try {
                        Component c = loadGenBank(new File(fileName));
                        result = c.toString();
                    } catch (Exception e) {
                        result = e.toString();
                    }
                    out.write(result);

                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                out.flush();
                out.close();
            }

        }
    }

    private String run(String devices) throws RecognitionException {
        System.out.println(devices);
        String[] deviceArray = devices.split("\\|");
        for (int i = 0; i < deviceArray.length; i++) {
            System.out.println(deviceArray[i]);
        }
        String[] results = (String[]) EugeneExecutor.execute("eugeneString", 1);
        return null;
    }

    private String getCurrentUser() {
        return "testuser";
    }

    private String readImageFiles() {
        //get path relative to servlet; ie the /web directory
        String imagePath = this.getServletContext().getRealPath("/") + "images/sbol_visual_jpeg/";
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

    public JSONObject executeEugene(String input) {

        JSONObject returnJSON = new JSONObject();
        try {
            Set<JSONObject> results = (HashSet<JSONObject>) EugeneExecutor.execute(input, 3);
            List<JSONObject> lstUriJSON = new ArrayList<JSONObject>();
            if (null != results && !results.isEmpty()) {
                lstUriJSON.addAll(results);
            }
            returnJSON.put("results", lstUriJSON);
            returnJSON.put("status", "good");

        } catch (Exception e) {
            e.printStackTrace();
            try {
                returnJSON.put("results", "");
                returnJSON.put("status", "bad");
                returnJSON.put("error", e.getMessage());
            } catch (Exception e1) {
            }
        }

        return returnJSON;
    }

    // Returns a JSON Array with the name of a file/directory and if it is a file
    // {"name": name, "isFile", isFile}
    private String getFileTree() {
        String currentFolderExtension = this.getServletContext().getRealPath("/") + "data/" + getCurrentUser() + "/";
        File rootFolder = new File(currentFolderExtension);
        ArrayList<File> queue = new ArrayList();
        ArrayList<JSONArray> folders = new ArrayList();
        ArrayList<Integer> folderSizes = new ArrayList();
        File[] rootFiles = rootFolder.listFiles();
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
        String extension = this.getServletContext().getRealPath("/") + "data/" + getCurrentUser() + "/" + localExtension;
        if (!isFile) {
            extension += "/";
        }
        return extension;
    }

    public JSONObject getData() {
        List<JSONObject> lstParts = new ArrayList<JSONObject>();

        try {
            File f = new File(this.getServletContext().getRealPath("/")
                    + "eugene-examples/inverter_data.eug");

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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private JSONObject toJSON(Device objDevice)
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
                componentJSON = this.toJSON((Device) component);
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

    // Takes an SBOL file and converts it into a eugene device
    private NamedElement convertSBOL(String sbolFileName) throws Exception {
        return SBOLImporter.importSBOL(sbolFileName);
    }

    // Interface that loads a GenBank component straight from the website
    private Component loadGenBank(String componentName) throws MalformedURLException, IOException,
            NoSuchElementException, BioException, EugeneException {

        URL url = new URL("http:www.ncbi.nlm.nih.gov/nuccore/" + componentName);
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        return readGenBankComponent(br);
    }

    // Interface that loads a GenBank component from a file
    private Component loadGenBank(File file) throws FileNotFoundException,
            NoSuchElementException, BioException, EugeneException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        return readGenBankComponent(br);
    }

    // Converts a GenBank component to a Eugene component
    // Do not call directly; use above APIs
    private Component readGenBankComponent(BufferedReader br) throws
            NoSuchElementException, BioException, EugeneException {
        SequenceIterator sequences = SeqIOTools.readGenbank(br);
        List<Component> parts = new ArrayList<Component>();
        String deviceName = "UnnamedDevice";
        // Should only have one sequence
        boolean firstPass = true;
        // Get a list of all features
        while (sequences.hasNext()) {
            Sequence seq = sequences.nextSequence();
            if (firstPass) {
                deviceName = seq.getName();
                firstPass = false;

            } else {
                deviceName += "|" + seq.getName();
            }
            Iterator it = seq.features();

            while(it.hasNext()) {
                Feature feature = (Feature) it.next();
                parts.add(buildPart(feature));
            }
        }
        if(parts.isEmpty()) {
            return null;
        } else if(parts.size() == 1) {
            // Size 1 imples just one part
            return parts.get(0);
        } else {
            //@TODO: get a real device name
            return new Device(deviceName, parts);
            //return EugeneBuilder.buildDevice(deviceName, parts);
        }
    }
    
    private Part buildPart(Feature feature) 
                throws EugeneException {
        PartType partType = new PartType(feature.getType());
        String partName = getPartName(feature);
        Part part = new Part(partType, partName);
        part.setSequence(feature.getSequence().seqString());
        return part;     
    }
    
    private String getPartName(Feature feature) {
        return feature.getType() + "_at_" + feature.getLocation().getMin();
    }
    
    /* Temporarily saved for reference
    private Component importGenbankComponent(String sFileName) throws MalformedURLException, IOException, 
            NoSuchElementException, BioException, InvalidEugeneAssignmentException {
        //Website has files embedded in the website so need to find a way to isolate the file from the rest of the website
        //Currently using direct file upload to test
	//URL url = new URL("http://www.ncbi.nlm.nih.gov/nuccore/" + sFileName);
	BufferedReader in = new BufferedReader(new FileReader(sFileName));//new InputStreamReader(url.openStream()));
	SequenceIterator sequences = SeqIOTools.readGenbank(in);
        List<Component> parts = new ArrayList<Component>();
        int i = 0;
	// Can this lead to multiple devices?
        while(sequences.hasNext()) {
            Sequence seq = sequences.nextSequence();
            Iterator it = seq.features();
            while(it.hasNext()) {
                Feature feature = (Feature) it.next();
                //Feature is essentially the Genbank version of a part
                PartType partType = new PartType(feature.getType());
                // Still need a part name
                String partName = feature.getType() + "_part" + i;
                Part part = new Part(partType, partName);
                // Add the sequence to the part
                Property property = new Property("sequence", "txt");
                PropertyValue propertyValue = new PropertyValue("sequence", "txt");
                propertyValue.setTxt(feature.getSequence().seqString());
                part.setValue(property, propertyValue);
                parts.add(part);
                i++;
            }
	}
        if(parts.isEmpty()) {
            return null;
        } else if(parts.size() == 1) {
            // File is just a device
            return parts.get(0);
        } else {
            //Will be able to get actual device name when website file upload works
            return Device.newInstance("DeviceName", parts);
=======
            while (it.hasNext()) {
                Feature feature = (Feature) it.next();
                features.add(feature);
            }
        }
        // Process the features to remove overlaps and make it more natural for a Eugene device
        //removeOverlap(features); //Currently just return list of parts
        List<Component> parts = new ArrayList<Component>();
        // Convert features to Eugene parts
        for (Feature feature : features) {
            parts.add(buildPart(feature));
        }
        if (parts.isEmpty()) {
            return null;
        } else if (parts.size() == 1) {
            // Size 1 imples just one part
            return new Part(deviceName, (Part) parts.get(0));
        } else {
            return Device.newInstance(deviceName, parts);
        }
		
    }
    * */
    
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
}
