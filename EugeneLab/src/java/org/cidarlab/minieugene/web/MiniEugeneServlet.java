package org.cidarlab.minieugene.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/*
 * miniEugene imports
 */
import org.cidarlab.minieugene.MiniEugene;
import org.cidarlab.minieugene.MiniEugeneStatistics;
import org.cidarlab.minieugene.dom.Component;
import org.cidarlab.minieugene.stats.Measurement;
import org.cidarlab.minieugene.util.SolutionExporter;
import org.cidarlab.minieugene.web.data.ScriptCollector;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Ernst Oberortner
 */
public class MiniEugeneServlet 
	extends HttpServlet {

	private static final long serialVersionUID = 1608090753599454559L;
	
	private static final String SOLVE = "solve";
	
    @Override
    public void init()
            throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
    }

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
    	
    	// not GET requests allowed ...

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
     * @return a String containing the servlet's description
     */
    @Override
    public String getServletInfo() {
        return "MiniEugeneServlet serving HTTP POST requests";
    }

    protected void processPostRequest(HttpServletRequest request, HttpServletResponse response) 
               throws IOException {

        JSONObject result = new JSONObject();
        
    	PrintWriter out = null;
        try {
            response.setContentType("application/json");
            out = response.getWriter();
            String command = request.getParameter("command");
            if (MiniEugeneServlet.SOLVE.equals(command)) {
                boolean bOk = true;
            	int sizeOfDesign = Integer.parseInt(
                        request.getParameter("N"));
                String input = request.getParameter("input");                    
                boolean predefined = Boolean.parseBoolean(
                        request.getParameter("predefined"));
                
                /*
                 * currently, we find all solutions
                 * -> we plan on allowing the user to specify a
                 *    desired number of solutions
                 */
                int nrOfSolutions = -1;
                
                
                if(bOk) {
                	result = executeMiniEugene(
                        	request.getSession().getId(), 
                        	sizeOfDesign, input, predefined, nrOfSolutions);
                
                	/*
                	 * for ``data'' collection
                	 * 
                	 * IDEA: I can relate the rules to the SBOL file
                	 * -> we can then do a lot of interesting stuff...
                	 */                    
                	collectScript(
                			request.getSession().getId(), 
                			sizeOfDesign, 
                			input);

                	out.write(result.toString());
                }
            } else {
            	result.put("status", "bad");
            }
        } catch (Exception e) {
        	try {
        		result.put("status", "exception");
        	} catch(Exception exc) {}
        } finally {
            out.flush();
            out.close();
        }
    }


    public JSONObject executeMiniEugene(
            String sessionId, 
            int N, String input, boolean predefined, int nrOfSolutions) {

        JSONObject returnJSON = new JSONObject();
        
    	/*
    	 * first, we instantiate miniEugene
    	 */
    	MiniEugene me = new MiniEugene();

    	/*
    	 * then, we turn the input string into 
    	 * an array of strings
    	 */
    	String[] rules = input.split(
    			System.getProperty("line.separator"));

    	try {
        	
        	/*
        	 * then, we build the script
        	 */
        	String script = this.buildScript(N, rules);
        	
            /*
             * then, we solve the problem
             * finding ALL solutions 
             */    
        	me.solve(script);

            /*
             * SolutionExporter, what else?
             */
            SolutionExporter se = new SolutionExporter(
            		me.getSolutions(),
            		me.getInteractions());

            // pigeon
            List<JSONObject> lstPigeon = new ArrayList<JSONObject>();
            JSONObject pigeon = new JSONObject();
            pigeon.put("pigeon-uri", se.toPigeon());
            lstPigeon.add(pigeon);
            returnJSON.put("results", lstPigeon);

            // Eugene 
            String eugeneFilePath = Paths.get(this.getServletContext().getRealPath(""), "data", "eugene").toString();
            new File(eugeneFilePath).mkdirs();
            String uuid = UUID.randomUUID().toString();
            String eugeneFile = eugeneFilePath+"/"+uuid+".eug";
            se.toEugene(eugeneFile);
            returnJSON.put("eugene", "data/eugene/"+uuid+".eug");
            
            // SBOL
            String sbolFilePath = Paths.get(this.getServletContext().getRealPath(""), "data", "sbol").toString();
            new File(sbolFilePath).mkdirs();
            String sbolFile = sbolFilePath+"/"+uuid+".sbol";
            se.toSBOL(sbolFile);            
            returnJSON.put("sbol", "data/sbol/"+uuid+".sbol");
        	
            // statistics
            returnJSON.put("stats", processStatistics(me.getStatistics()));
            
            // everything's good
            returnJSON.put("status", "good");

        } catch(Exception e) {
            try {
                returnJSON.put("status", "exception");
                returnJSON.put("results", e.toString());
            } catch(JSONException jse) {}
        }

        /*
         * regardless what happened, we visualize the ACT
         */
    	try {
    		returnJSON.put("act-uri", me.visualizeACT().toString());
    	} catch(Exception e) {
    		// ignore
    	}
    	
        return returnJSON;
    }
    
    /**
     * 
     * @param N
     * @param rules
     * @return
     */
	public String buildScript(int N, String[] rules) {
		StringBuilder sb = new StringBuilder();

		// N = number .
		sb.append("N=").append(N).append(".").append("\r\n");
		
		// rules
		for(int i=0; i<rules.length; i++) {
			if(!rules[i].trim().isEmpty()) {
				if(!rules[i].startsWith("//")) {
					sb.append(rules[i]);
					if(!rules[i].endsWith(".")) {
						sb.append(".").append("\r\n");
					}
				}
			}
		}

		return sb.toString();
	}
    
    private List<JSONObject> processStatistics(MiniEugeneStatistics mes) {
        List<JSONObject> lstStatsJSON = new ArrayList<JSONObject>();
        
    	if (null != mes && !mes.isEmpty()) {
        	
        	for(Measurement m : mes.getMeasurements()) {
        		JSONObject statsJSON = new JSONObject();
        		try {
        			statsJSON.put("name", m.getKey());
        			statsJSON.put("value", m.getValue());
        			
            		lstStatsJSON.add(statsJSON);	            		
        		} catch(Exception e) {
        			// don't know how to handle such an exception
        		}
        	}
        }
    	
    	return lstStatsJSON;
    }
    
    private JSONObject textualizeSolutions(List<Component[]> solutions) {
        
    	StringBuilder sb = new StringBuilder();
    	sb.append("<table class=\"table table-bordered table-hover\" id=\"solutionList\">");
    	if (null != solutions && !solutions.isEmpty()) {

        	for(Component[] solution :  solutions) {	 
        		sb.append("<tr><td>");
        		for(int i=0; i<solution.length; i++) {
        			Component component = solution[i];
        			if(!component.isForward()) {
        				sb.append("-");
        			} 
        			sb.append(component.getName());
        			if(i != solution.length - 1) {
        				sb.append(", ");
        			}
        		}
        		sb.append("</td></tr>");
        	}
        }
    	sb.append("</table>");
    	
    	System.out.println(sb.toString());
    	
    	/*
    	 * put the HTML of the textual solutions table into JSON format
    	 */
    	JSONObject solutionsJSON = new JSONObject();
    	try {
    		solutionsJSON.put("solution", sb.toString());
    	} catch(Exception e) {
    		try {
    			solutionsJSON.put("solution", "");
    		} catch(Exception ee) {}
    	}    	
    	return solutionsJSON;
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
}
