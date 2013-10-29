package org.cidarlab.eugene.solver.jacop;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.cidarlab.eugene.cache.SymbolTables;
import org.cidarlab.eugene.dom.arrays.DeviceArray;
import org.cidarlab.eugene.dom.arrays.GeneratedDeviceArray;
import org.cidarlab.eugene.dom.components.Component;
import org.cidarlab.eugene.dom.components.Device;
import org.cidarlab.eugene.dom.components.Part;
import org.cidarlab.eugene.dom.components.types.PartType;
import org.cidarlab.eugene.dom.rules.Rule;
import org.cidarlab.eugene.exception.EugeneException;
import org.cidarlab.eugene.solver.Solver;
import org.cidarlab.eugene.solver.stats.jacop.SolverStats;

import JaCoP.constraints.And;
import JaCoP.constraints.Constraint;
import JaCoP.constraints.Element;
import JaCoP.constraints.IfThen;
import JaCoP.constraints.Or;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqC;
import JaCoP.constraints.XeqY;
import JaCoP.constraints.XgtC;
import JaCoP.constraints.XgtY;
import JaCoP.core.Domain;
import JaCoP.core.IntVar;
import JaCoP.core.Store;
import JaCoP.search.DepthFirstSearch;
import JaCoP.search.IndomainMin;
import JaCoP.search.IndomainSimpleRandom;
import JaCoP.search.LargestDomain;
import JaCoP.search.MostConstrainedDynamic;
import JaCoP.search.Search;
import JaCoP.search.SelectChoicePoint;
import JaCoP.search.SimpleSelect;


public class JaCoPSolver 
	implements Solver {

	private Store store;
	private SolverStats stats;
	
	public JaCoPSolver() {
		this.store = new Store();
		this.stats = new SolverStats();
	}
	
	@Override
	public GeneratedDeviceArray solveProduct(
			Device device, List<Rule> rules, int N) 
			throws EugeneException {
		
    	/*
    	 * create the variables of the constraint solving problem
    	 * i.e. the parts
    	 */
    	IntVar[] variables = null;
    	try {
    		variables = modelProduct(device);
    		//System.out.println("# possible devices: "+this.NUMBER_OF_DEVICES);
    	} catch(EugeneException ee) {
    		throw new EugeneException(ee.toString());
    	}

    	/*
    	 * map the Eugene rules onto JaCoP constraints
    	 */
    	imposeConstraints(store, variables, rules);
    	
    	
    	/*
    	 * for testing: print the store's information
    	 */
    	//store.print();
    	
    	/*
    	 * now, let's solve the problem
    	 */
    	Domain[][] solutions = solve(variables, N);
    	
    	
    	/*
    	 * print the stats
    	 */
    	this.stats.print();
    	
    	/*
    	 * finally, we return the solutions
    	 */

		return new GeneratedDeviceArray(
				device,
				solutions);
	}
	
 
	
    private IntVar[] modelProduct(Device device) 
    		throws EugeneException {
 
    	this.partPositions = new HashMap<String, Integer[]>();
    	
    	List<Component> lstDeviceComponents = device.getAllComponents();
    	IntVar[] variables = new IntVar[lstDeviceComponents.size()];
    	
    	long NUMBER_OF_DEVICES = 1;
    	
    	int i=0;
    	for(Component component : lstDeviceComponents) {

    		variables[i] = new IntVar(store, component.getName()+"_"+i);

    		/*
    		 * 2. load all Domain values (i.e. the parts)
			 */
    		if(component instanceof PartType) {

    			Collection<Part> parts = SymbolTables.getParts((PartType)component);
    			if(null == parts || parts.isEmpty()) {
    				throw new EugeneException("There are no parts of part type "+component.getName()+" available!");
    			}

    			NUMBER_OF_DEVICES *= parts.size();

    			IntVar partTypeVar = new IntVar(store, component.getName());
    			
    			for(Part part : parts) {
    				IntVar iv = Eugene2JaCoP.modelPart(part, this.store, variables, i);
    				partTypeVar.addDom(iv.min(), iv.max());
    				variables[i].addDom(iv.min(), iv.max());

    				/*
    				 * add the possible position of the part to the position hashmap 
    				 */
    				addPartPosition(iv, i);
				}
    			        		
    		} else if(component instanceof Part) {
    			IntVar iv = Eugene2JaCoP.modelPart((Part)component, this.store, variables, i);
				variables[i].addDom(iv.min(), iv.max());

				addPartPosition(iv, i);
    		}
    		
    		i++;
    	}
    	
    	/*
    	 * for the stats
    	 */
    	this.stats.add("number of devices", NUMBER_OF_DEVICES);
    	
    	
    	return variables;
    }
    
    private Map<String, Integer[]> partPositions;
    
    private void addPartPosition(IntVar iv, int i) {
		Integer[] positions = null;
		if(partPositions.containsKey(iv.id())) {
			positions = partPositions.get(iv.id());
			positions = ArrayUtils.add(positions, i);
		} else {
			positions = new Integer[1];
			positions[0] = i;
		}
		partPositions.put(iv.id(), positions);
    }

    public void imposeConstraints(Store store, IntVar[] variables, List<Rule> rules) {
    	int N = 2;
    	
    	System.out.println("imposing X.numProp > "+N+"...");    	
    	IntVar numPropVar = (IntVar)store.findVariable("numProp");
    	store.impose(new XeqC(numPropVar, Eugene2JaCoP.toASCII(String.valueOf(N))));

//    	String txt = "txt4";
//    	System.out.println("imposing X.txtProp == "+txt+"...");    	
//    	IntVar txtPropVar = (IntVar)store.findVariable("txtProp");
//    	pc[1] = new XeqC(txtPropVar, Eugene2JaCoP.toASCII(String.valueOf(txt)));
//    	
    	store.print();
    	
//    	for(Rule rule : rules) {
//    		try {
//
//	    		Constraint constraint = rule.getPredicate().toJaCoP(store, variables, device, device.getAllComponents());
//	    		
//	    		if(null != constraint) {
//	    			store.impose(constraint);
//	    		}
//    		} catch(EugeneException ee) {
//    			ee.printStackTrace();
//    		}
//    	}
    }

    public Domain[][] solve(IntVar[] variables, int N) {
    	Search<IntVar> search = new DepthFirstSearch<IntVar>(); 

        SelectChoicePoint<IntVar> select = null;
        if(N != (-1)) {
			select =  new SimpleSelect<IntVar>(
							variables, 
							new MostConstrainedDynamic<IntVar>(), 
							new IndomainSimpleRandom<IntVar>());  
			search.getSolutionListener().setSolutionLimit(N);
        } else {        	
        	select = new SimpleSelect<IntVar>(
    				variables, 
    				new LargestDomain<IntVar>(),
    				new IndomainMin<IntVar>()); 
        	search.getSolutionListener().searchAll(true);   
        }

        search.setPrintInfo(true);
        search.getSolutionListener().recordSolutions(true);
                
		long T1 = System.nanoTime();

        // SOLVE
		try {
//			store.print();
			search.labeling(store, select);
		} catch(Exception e) {
			e.printStackTrace();
		}

		long T2 = System.nanoTime();
		
		double PROCESSING_TIME = (T2 - T1) * Math.pow(10, -9);
		System.out.println("processing time: "+PROCESSING_TIME+"sec");
        search.getSolutionListener().printAllSolutions();

//		System.out.println(nProcessing);

		//search.printAllSolutions();
		
		return search.getSolutionListener().getSolutions();
    }
	@Override
	public GeneratedDeviceArray solvePermute(
			Device device, List<Rule> rules, int N) {
		// TODO Auto-generated method stub
		return null;
	}

}
