package org.cidarlab.eugenelab.servlet;

import eugene.EugeneExecutor;
import eugene.dom.SavableElement;
import eugene.dom.components.Component;
import eugene.dom.components.Device;
import eugene.dom.components.Part;
import eugene.dom.components.types.PartType;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.antlr.runtime.RecognitionException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.cidarlab.weyekin.WeyekinPoster;
import org.json.JSONArray;
import org.json.JSONException;
import org.clothocad.client.Clotho;
import org.clothocad.client.ClothoFactory;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class EugeneServlet extends HttpServlet {

//    /* here is our Clotho instance */
    private Clotho clotho;

    @Override
    public void init()
            throws ServletException {

        super.init();
        this.clotho = ClothoFactory.getAPI("ws://localhost:8080/websocket");
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
            } else if (command.equals("deleteFile")) {
                String fileName = request.getParameter("fileName");
                deleteFile(fileName);
                out.write("{\"status\":\"good\"}");
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
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                out.flush();
                out.close();
            }
        }
    }

    /**
     * private String simulateReadingPartsFromClotho() { JSONObject resultsJSON
     * = new JSONObject();
     *
     * try { List<JSONObject> lstResults = new ArrayList<JSONObject>();
     * resultsJSON.put("results", lstResults); * JSONObject partJSON = new
     * JSONObject(); partJSON.put("name", "J23100"); partJSON.put("type",
     * "Promoter"); partJSON.put("sequence",
     * "TTGACGGCTAGCTCAGTCCTAGGTACAGTGCTAGC"); partJSON.put("Pigeon", "p
     * J23100");
     *
     * lstResults.add(partJSON); } catch(Exception e) {}
     *
     * return resultsJSON.toString(); }
     *
     */
    private String readFiles() {
        String toReturn = "[";

        try {
            String imagePath = this.getServletContext().getRealPath("/") + "resources/";

            File[] filesToRead = new File(imagePath).listFiles();
            if (filesToRead != null) {
                for (int j = 0; j < filesToRead.length; j++) {
                    File currentFile = filesToRead[j];
                    String filePath = currentFile.getAbsolutePath();
                    String fileExtension = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length()).toLowerCase();
                    if ("csv".equals(fileExtension)) {
                        BufferedReader reader = new BufferedReader(new FileReader(currentFile.getAbsolutePath()));
                        String line = reader.readLine();
                        line = reader.readLine(); //skip first line
                        while (line != null) {
                            while (line.matches("^[\\s,]+")) {
                                line = reader.readLine();
                            }
                            String[] tokens = line.split(",");
                            int tokenCount = tokens.length; //keeps track of how many columns are filled by counting backwards
                            for (int i = tokens.length - 1; i > -1; i--) {
                                if (tokens[i].trim().matches("[\\s]*")) {
                                    tokenCount--;
                                } else {
                                    break;
                                }
                            }
                            String name = tokens[0].trim();
                            String sequence = tokens[1].trim();
                            String leftOverhang = tokens[2].trim();
                            String rightOverhang = tokens[3].trim();
                            String type = tokens[4].trim();
                            toReturn = toReturn
                                    + "{\"Name\":\"" + name
                                    + "\",\"LO\":\"" + leftOverhang
                                    + "\",\"RO\":\"" + rightOverhang
                                    + "\",\"type\":\"" + type + "\"},";
                            line = reader.readLine();
                        }
                        reader.close();
                    }
                }
                toReturn = "{\"result\":" + toReturn.subSequence(0, toReturn.length() - 1) + "]}";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toReturn;
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
        HashMap<String, SavableElement> results = new HashMap<String, SavableElement>();

        JSONObject returnJSON = new JSONObject();
        try {
            results = (HashMap<String, SavableElement>) EugeneExecutor.execute(input, 2);

            if (null != results && !results.isEmpty()) {

                List<JSONObject> lstDeviceJSON = new ArrayList<JSONObject>();
                for (String s : results.keySet()) {
                    SavableElement objElement = results.get(s);
                    if (objElement instanceof Device) {

                        Device objDevice = (Device) objElement;

                        JSONObject deviceJSON = this.toJSON(objDevice);

                        // now, we could store it in the Clotho DB...
                        WeyekinPoster.setPigeonText(
                                deviceJSON.get("Pigeon").toString());
                        deviceJSON.put("pigeon-uri", WeyekinPoster.postMyBird());
                        lstDeviceJSON.add(deviceJSON);

                        /**
                         * clotho.create(deviceJSON); *
                         */
                    }
                }

                returnJSON.put("results", lstDeviceJSON);
            }

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

    private void deleteFile(String fileName) {
        String currentFileExtension = getFileExtension("/" + fileName, true);
        File file = new File(currentFileExtension);
        file = file.getAbsoluteFile();
        file.delete();
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
                    partJSON.put("sequence", objPart.get("sequence"));
                    partJSON.put("Pigeon", objPart.get("Pigeon"));
                    if (null != objPart.get("represses")) {
                        partJSON.put("represses", objPart.get("represses"));
                    }

                    lstParts.add(partJSON);
                }
            }

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
                componentJSON.put("sequence", objPart.get("sequence"));
                componentJSON.put("type", objPart.getPartType().getName());
                if (null != objPart.get("represses")) {
                    sbPigeonArcs.append(objPart.getName())
                            .append(" rep ")
                            .append(objPart.get("represses"))
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
