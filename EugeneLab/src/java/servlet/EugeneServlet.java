/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import eugene.EugeneExecutor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            if(command.equals("run")) {
                String[] devices = (String[]) EugeneExecutor.execute("eugeneString",1);
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
        processRequest(request, response);
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
}