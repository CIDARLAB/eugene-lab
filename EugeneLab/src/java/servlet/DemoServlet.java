/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

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
public class DemoServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
//            Remember the json object I sent to my servlet? 
//            I'm grabbing the value associated with the key "command". 
//            the value should be test
            String command = request.getParameter("command"); 
            out.println("THIS IS COMING FROM THE SERVER; the command was: "+command); //I'm printing a string to the server
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
        if(request.getParameter("command").equals("getImageList")) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                out.println(getImageFileLocations());
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
    
    //Returns a JSON string with the locations of images to be posted to the specticals drag and drop
    public String getImageFileLocations() {
        return "{\"imageList\":"
              + "[{\"location\":\"assembly-scar.jpeg\"},"
              + "{\"location\":\"blunt-restriction-site.jpeg\"},"
              + "{\"location\":\"cds.jpeg\"},"
              + "{\"location\":\"five-prime-overhang.jpeg\"},"
              + "{\"location\":\"five-prime-sticky-restriction-site.jpeg\"},"
              + "{\"location\":\"insulator.jpeg\"},"
              + "{\"location\":\"operator.jpeg\"},"
              + "{\"location\":\"origin-of-replication.jpeg\"},"
              + "{\"location\":\"primer-binding-site.jpeg\"},"
              + "{\"location\":\"promoter.jpeg\"},"
              + "{\"location\":\"protease-site.jpeg\"},"
              + "{\"location\":\"protein-stability-element.jpeg\"},"
              + "{\"location\":\"restriction-enzyme-recognition-site.jpeg\"},"
              + "{\"location\":\"ribonuclease-site.jpeg\"},"
              + "{\"location\":\"ribosome-entry-site.jpeg\"},"
              + "{\"location\":\"rna-stability-element.jpeg\"},"
              + "{\"location\":\"signature.jpeg\"},"
              + "{\"location\":\"terminator.jpeg\"},"
              + "{\"location\":\"three-prime-overhang.jpeg\"},"
              + "{\"location\":\"three-prime-sticky-restriction-site.jpeg\"},"
              + "{\"location\":\"user-defined.jpeg\"}]}";
        
        
        //I couldn't figure out how to access a file in NetBeans
        //This is what I tried:
        
        /*try {
            Scanner scanner = new Scanner(new File("/WEB-INF/resources/image_index.csv/"));
            scanner.useDelimiter(",");
            String imageFileLocations = "{[";
            while(scanner.hasNext()) {
                String addition ="{\"location\":\"";
                addition += scanner.next();
                addition += "\"}";
                imageFileLocations += addition;
            }
            imageFileLocations += "]}";
            return imageFileLocations;
        } catch (FileNotFoundException ex) {
            return "Did Not Find File";
        }*/
    }
 
    // </editor-fold>
}
