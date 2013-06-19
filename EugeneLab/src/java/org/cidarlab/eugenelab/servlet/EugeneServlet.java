/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.eugenelab.servlet;

import eugene.EugeneExecutor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.antlr.runtime.RecognitionException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //I'm returning a JSON object and not a string
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String command = request.getParameter("command");
        try {
            if (command.equals("imageList")) {
                out.write(readImageFiles());
            }
            if (command.equals("run")) {
                System.out.println("detected run command");
                String devices = request.getParameter("devices");
                System.out.println("devices: " + devices);
                String toReturn = run(devices);
                toReturn = "{\"response\":\"response\"}";
                out.write(toReturn);
            }
            if (command.equals("read")) {
                out.write(readFiles());
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

        //Getting image files if the request has command getImageList
        if (request.getParameter("command").equals("getImageList")) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                out.println(readImageFiles());
            } finally {
                out.close();
            }
        } else {


            processRequest(request, response);
        }
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

    private String readImageFiles() {
        //get path relative to servlet; ie the /web directory
        String imagePath = this.getServletContext().getRealPath("/") + "images\\sbol_visual_jpeg\\";
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

    protected void processPostRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!ServletFileUpload.isMultipartContent(request)) {
            throw new IllegalArgumentException("Request is not multipart, please 'multipart/form-data' enctype for your form.");
        }
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
                
                JSONObject json = new JSONObject();
                json.put("result", "good");
                json.put("status", "good");
                writer.write(json.toString());
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
    }

    private String readFiles() {
        String toReturn = "[";

        try {
            String imagePath = this.getServletContext().getRealPath("/") + "data\\";

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
}