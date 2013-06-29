/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.eugenelab.servlet;

import eugene.EugeneExecutor;
import eugene.dom.SavableElement;
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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.antlr.runtime.RecognitionException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class EugeneServlet extends HttpServlet {

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
                out.write(readFiles());
            } else if (command.equals("execute")) {
                String input = request.getParameter("input");
                String result = executeEugene(input);
                out.write("{\"result\":\"" + result + "\",\"status\":\"bad\"}");
            } else if (command.equals("getFileTree")) {
                out.write(getFileTree());
            } else if (command.equals("addNewFile")) {
                String currentFolder = request.getParameter("currentFolder");
                String newFileName = request.getParameter("newFileName");
                boolean isFile = Boolean.parseBoolean(request.getParameter("isFile"));
                out.write(addNewFile(currentFolder, newFileName, isFile));
            } else if (command.equals("getFileContent")) {
                String fileName = request.getParameter("fileName");
                String currentFolder = request.getParameter("currentFolder");
                out.write(loadFile(fileName, currentFolder));
            } else if (command.equals("test")) {
                out.write("{\"response\":\"test response\"}");
            } else if (command.equals("deleteFile")) {
                String fileName = request.getParameter("fileName");
                String currentFolder = request.getParameter("currentFolder");
                deleteFile(fileName, currentFolder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

    protected void processPostRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(request)) {
            //process code for file upload
            ServletFileUpload uploadHandler = new ServletFileUpload(new DiskFileItemFactory());
            PrintWriter writer = response.getWriter();
            response.setContentType("text/plain");
            response.sendRedirect("eugenelab.html");
            String uploadFilePath = this.getServletContext().getRealPath("/") + "data";
            try {
                List<FileItem> items = uploadHandler.parseRequest(request);
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
                            file = new File(uploadFilePath + "\\" + fileName.substring(fileName.lastIndexOf("\\")));
                        } else {
                            file = new File(uploadFilePath + "\\" + fileName.substring(fileName.lastIndexOf("\\") + 1));
                        }
                        item.write(file);
                        toLoad.add(file);
                    }
                    writer.write("{\"result\":\"good\",\"status\":\"good\"}");
                }
            } catch (FileUploadException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                e.printStackTrace();
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                e.printStackTrace(printWriter);
                String exceptionAsString = stringWriter.toString().replaceAll("[\r\n\t]+", "<br/>");
                writer.write("{\"result\":\"" + exceptionAsString + "\",\"status\":\"bad\"}");
            } finally {
                writer.close();
            }
        } else {
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            String command = request.getParameter("command");
            if (command.equals("execute")) {
                String input = request.getParameter("input");
                String result = executeEugene(input);
                out.write("{\"result\":\"" + result + "\",\"status\":\"bad\"}");
            } else if (command.equals("saveFileContent")) {
                String fileName = request.getParameter("fileName");
                String currentFolder = request.getParameter("currentFolder");
                String fileContent = request.getParameter("fileContent");
                saveFile(fileName, currentFolder, fileContent);
            }

        }
    }

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
                                    + "\",\"Type\":\"" + type + "\"},";
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
        System.out.println("running");
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

    public String executeEugene(String input) {
        HashMap<String, SavableElement> results = new HashMap<String, SavableElement>();
        String toReturn = "<br/>Starting Eugene";
        try {
            try {
                results = (HashMap<String, SavableElement>) EugeneExecutor.execute(input, 2);
                toReturn = toReturn + "<br/>" + results;
                toReturn = toReturn + "<br/>Eugene worked!";
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            toReturn = toReturn + "<br/>Finished Eugene!";
        }
        return toReturn;
    }

    // Returns a JSON Array with the name of a file/directory and if it is a file
    // {"name": name, "isFile", isFile}
    private String getFileTree() {
        String currentFolderExtension = this.getServletContext().getRealPath("/") + "data/" + getCurrentUser() + "/";
        File rootFolder = new File(currentFolderExtension);
        ArrayList<File> queue = new ArrayList();
        queue.add(rootFolder);
        JSONArray rootArray = new JSONArray();
        JSONArray currentArray = rootArray;
        while (!queue.isEmpty()) {
            try {
                File currentFile = queue.get(0);
                queue.remove(0);
                JSONObject toPut = new JSONObject();
                toPut.put("title", currentFile.getName());
                currentArray.put(toPut);
                if (currentFile.isDirectory()) {
                    toPut.put("children", new JSONArray());
                    toPut.put("isFolder", true);
                    currentArray = toPut.getJSONArray("children");
                    File[] subFiles = currentFile.listFiles();
                    for (int i = 0; i < subFiles.length; i++) {
                        queue.add(subFiles[i]);
                    }
                }
            } catch (JSONException ex) {
                ex.printStackTrace();
            }
        }
        return rootArray.toString();
    }

    private String addNewFile(String currentFolderExtension, String newFileName, boolean isFile) {
        currentFolderExtension = this.getServletContext().getRealPath("/") + "data/" + getCurrentUser() + "/" + currentFolderExtension + "/";
        File newFile = new File(currentFolderExtension + newFileName + "/");
        try {
            if (isFile) {
                newFile.createNewFile();
            } else {
                newFile.mkdir();
            }
        } catch (Exception e) {
            return "{\"fileCreateSucessful\":false}";
        }
        return "{\"fileCreateSucessful\":true}";
    }

    private String loadFile(String fileName, String currentFolder) throws FileNotFoundException, IOException {
        String currentFileExtension = getFileExtension(currentFolder + "/" + fileName, true);
        File file = new File(currentFileExtension);
        BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
        String currentLine;
        String toReturn = "";
        while ((currentLine = br.readLine()) != null) {
            toReturn += currentLine + "__BR__";
        }
        br.close();
        return "{\"fileContent\":\"" + toReturn + "\"}";
    }

    private void saveFile(String fileName, String currentFolder, String fileContent) throws IOException {
        String currentFileExtension = getFileExtension(currentFolder + "/" + fileName, true);
        File file = new File(currentFileExtension);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        bw.write(fileContent);
        bw.close();
    }

    private void deleteFile(String fileName, String currentFolder) {
        String currentFileExtension = getFileExtension(currentFolder + "/" + fileName, true);
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
}