package eugene.evaluation;

import eugene.Eugene;

public class RealDesignsEvaluator {

	public static void main(String[] args) {
		
		// zum einpendeln
		/**
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			new Eugene("./designs/literature/inverter/inverter.eug");
		}
		**/
		
		/** LITERATURE DESIGNS **/
		//evaluateInverters();   			//--> DONE 
		//evaluateNorGates();				//--> DONE
		//evaluateToggleSwitches();			//--> DONE
		//evaluateRepressilators();			//--> DONE
		

		/** EVAN's DESIGNS **/
		//evaluateInvertaseGates();			//--> TODO
		
		/***
		evaluateAmplifyingLogicGates();		//--> TODO
		evaluateRewriteableStorage();		//--> TODO
		evaluateCollinsCounters();			//--> TODO
		evaluateRepressilator();			//--> TODO
		evaluateVoigtEdgeDetector();		//--> TODO
		evaluateVoigtLayeredGate();			//--> TODO
		 ***/
		
		//evaluateVoigtNorGates();			//--> TODO
		
		/***
		evaluateVoigtSpacers();				//--> TODO
		 ***/
		
		/** SONYA's DESIGNS **/
		//evaluate4StateMemoryCircuit(); 	//--> DONE
		//evaluateFusionProteins();		 	//--> DONE
		
		/** TYLER's DESIGNS **/
		//evaluateRNACircuits();			//--> DONE

		/** SWATI's DESIGNS **/
		evaluateSwatisInverters();		//--> DONE
		
		/** SWAPNIL's DESIGNS **/
		//evaluateBasicOperon();			//--> TODO
		
		/** JENHAN's DESIGNS **/
		//evaluateGenomaticaFlow();         //--> DONE
		
		System.exit(0);
	}
	
	private static final int NR_OF_ITERATIONS = 1;
	
	private static void evaluateInverters() {
		System.out.println("*** INVERTER ***");

		
		double sum = 0.0;
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			double t1 = System.nanoTime();
			new Eugene("./designs/literature/inverter/inverter.eug");
			double nProcTime = (System.nanoTime()-t1) * Math.pow(10, -9);
			sum += nProcTime;
		}
		System.out.println("average processing time: " + (sum/NR_OF_ITERATIONS)+" sec");
	}
	
	private static void evaluateNorGates() {
		System.out.println("*** NOR GATES ***");
		
		double sum = 0.0;
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			double t1 = System.nanoTime();
			new Eugene("./designs/literature/nor-gate/nor-gate.eug");
			double nProcTime = (System.nanoTime()-t1) * Math.pow(10, -9);
			sum += nProcTime;
		}
		System.out.println("average processing time: " + (sum/NR_OF_ITERATIONS)+" sec");
	}
	
	private static void evaluateToggleSwitches() {
		System.out.println("*** TOGGLE-SWITCH ***");
		
		double sum = 0.0;
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			double t1 = System.nanoTime();
			new Eugene("./designs/literature/toggle-switch/toggle-switch.eug");
			double nProcTime = (System.nanoTime()-t1) * Math.pow(10, -9);
			sum += nProcTime;
		}
		System.out.println("average processing time: " + (sum/NR_OF_ITERATIONS)+" sec");
	}

	private static void evaluateRepressilators() {
		System.out.println("*** REPRESSILATOR ***");
		
		double sum = 0.0;
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			double t1 = System.nanoTime();
			new Eugene("./designs/literature/repressilator/repressilator.eug");
			double nProcTime = (System.nanoTime()-t1) * Math.pow(10, -9);
			sum += nProcTime;
		}
		System.out.println("average processing time: " + (sum/NR_OF_ITERATIONS)+" sec");
	}
	
	private static void evaluateAmplifyingLogicGates() {
		System.out.println("*** AMPLIFYING LOGIC GATES [Endy] ***");
		
		double sum = 0.0;
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			double t1 = System.nanoTime();
			new Eugene("./designs/cidar/raven/endy-amplifying-genetic-logic-gates/endy_amplifying_gates.eug");
			double nProcTime = (System.nanoTime()-t1) * Math.pow(10, -9);
			sum += nProcTime;
		}
		System.out.println("average processing time: " + (sum/NR_OF_ITERATIONS)+" sec");
	}

	private static void evaluateRewriteableStorage() {
		System.out.println("*** REWRITEABLE STORAGE [Endy] ***");
		
		double sum = 0.0;
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			double t1 = System.nanoTime();
			new Eugene("./designs/cidar/raven/endy-rewriteable-storage/endy_rewritable_storage.eug");
			double nProcTime = (System.nanoTime()-t1) * Math.pow(10, -9);
			sum += nProcTime;
		}
		System.out.println("average processing time: " + (sum/NR_OF_ITERATIONS)+" sec");
	}
	private static void evaluateCollinsCounters() {
		System.out.println("*** COUNTERS [Collins] ***");
		
		double sum = 0.0;
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			double t1 = System.nanoTime();
			new Eugene("./designs/cidar/raven/collins-counters/collins_counters.eug");
			double nProcTime = (System.nanoTime()-t1) * Math.pow(10, -9);
			sum += nProcTime;
		}
		System.out.println("average processing time: " + (sum/NR_OF_ITERATIONS)+" sec");
	}
	private static void evaluateRepressilator() {
		System.out.println("*** REPRESSILATOR ***");
		
		double sum = 0.0;
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			double t1 = System.nanoTime();
			new Eugene("./designs/cidar/raven/repressilator/repressilator.eug");
			double nProcTime = (System.nanoTime()-t1) * Math.pow(10, -9);
			sum += nProcTime;
		}
		System.out.println("average processing time: " + (sum/NR_OF_ITERATIONS)+" sec");
	}
	private static void evaluateInvertaseGates() {
		System.out.println("*** INVERTASE GATES [Lu] ***");
		
		double sum = 0.0;
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			double t1 = System.nanoTime();
			new Eugene("./designs/cidar/raven/lu-invertase-gates/lu_invertase_gates.eug");
			double nProcTime = (System.nanoTime()-t1) * Math.pow(10, -9);
			sum += nProcTime;
		}
		System.out.println("average processing time: " + (sum/NR_OF_ITERATIONS)+" sec");
	}
	private static void evaluateVoigtEdgeDetector() {
		System.out.println("*** EDGE DETECTOR [Voigt] ***");
		
		double sum = 0.0;
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			double t1 = System.nanoTime();
			new Eugene("./designs/cidar/raven/voigt-edge-detector/voigt_edge_detector.eug");
			double nProcTime = (System.nanoTime()-t1) * Math.pow(10, -9);
			sum += nProcTime;
		}
		System.out.println("average processing time: " + (sum/NR_OF_ITERATIONS)+" sec");
	}
	private static void evaluateVoigtLayeredGate() {
		System.out.println("*** LAYERED GATES [Voigt] ***");
		
		double sum = 0.0;
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			double t1 = System.nanoTime();
			new Eugene("./designs/cidar/raven/voigt-layered-gates/voigt_layered_gates.eug");
			double nProcTime = (System.nanoTime()-t1) * Math.pow(10, -9);
			sum += nProcTime;
		}
		System.out.println("average processing time: " + (sum/NR_OF_ITERATIONS)+" sec");
	}
	private static void evaluateVoigtNorGates() {
		System.out.println("*** NOR GATES [Voigt] ***");
		
		double sum = 0.0;
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			double t1 = System.nanoTime();
			new Eugene("./designs/cidar/raven/voigt-nor-gates/voigt_nor_gates.eug");
			double nProcTime = (System.nanoTime()-t1) * Math.pow(10, -9);
			sum += nProcTime;
		}
		System.out.println("average processing time: " + (sum/NR_OF_ITERATIONS)+" sec");
	}
	private static void evaluateVoigtSpacers() {
		System.out.println("*** SPACERS [Voigt] ***");
		
		double sum = 0.0;
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			double t1 = System.nanoTime();
			new Eugene("./designs/cidar/raven/voigt-spacers/voigt_spacers.eug");
			double nProcTime = (System.nanoTime()-t1) * Math.pow(10, -9);
			sum += nProcTime;
		}
		System.out.println("average processing time: " + (sum/NR_OF_ITERATIONS)+" sec");
	}

	private static void evaluateFusionProteins() {
		System.out.println("*** MoClo FUSION PROTEINS (by Sonya) ***");
		
		double sum = 0.0;
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			double t1 = System.nanoTime();
			new Eugene("./designs/cidar/sonya/fusion-protein-generation/fusion-protein.eug");
			double nProcTime = (System.nanoTime()-t1) * Math.pow(10, -9);
			sum += nProcTime;
		}
		System.out.println("average processing time: " + (sum/NR_OF_ITERATIONS)+" sec");
	}

	private static void evaluateRNACircuits() {
		System.out.println("*** RNA CIRCUITS (by Tyler) ***");
		
		double sum = 0.0;
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			double t1 = System.nanoTime();
			//new Eugene("./designs/cidar/tyler/rna-circuits/Sindbis.eug");
			new Eugene("./designs/cidar/tyler/rna-circuits/Sindbis_rev1.eug");
			double nProcTime = (System.nanoTime()-t1) * Math.pow(10, -9);
			sum += nProcTime;
		}
		System.out.println("average processing time: " + (sum/NR_OF_ITERATIONS)+" sec");
	}

	private static void evaluateSwatisInverters() {
		System.out.println("*** Swati's Inverters ***");
		
		double sum = 0.0;
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			double t1 = System.nanoTime();
			new Eugene("./designs/cidar/swati/inverters/rev2/inverter_rev2.eug");
			double nProcTime = (System.nanoTime()-t1) * Math.pow(10, -9);
			sum += nProcTime;
		}
		System.out.println("average processing time: " + (sum/NR_OF_ITERATIONS)+" sec");
	}

	private static void evaluateBasicOperon() {
		System.out.println("*** Basic Operon (Swapnil) ***");
		
		double sum = 0.0;
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			double t1 = System.nanoTime();
			new Eugene("./designs/cidar/basic-operon/basic_operon.eug");
			double nProcTime = (System.nanoTime()-t1) * Math.pow(10, -9);
			sum += nProcTime;
		}
		System.out.println("average processing time: " + (sum/NR_OF_ITERATIONS)+" sec");
	}

	private static void evaluate4StateMemoryCircuit() {
		System.out.println("*** 4-STATE-MEMORY-CIRCUIT ***");
		
		double sum = 0.0;
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			double t1 = System.nanoTime();
			new Eugene("./designs/cidar/sonya/4-state-memory-circuit/memory-circuit.eug");
			double nProcTime = (System.nanoTime()-t1) * Math.pow(10, -9);
			sum += nProcTime;
		}
		System.out.println("average processing time: " + (sum/NR_OF_ITERATIONS)+" sec");
	}

	private static void evaluateGenomaticaFlow() {
		System.out.println("*** GENOMATICA (Jenhan) ***");
		
		double sum = 0.0;
		for(int i=0; i<NR_OF_ITERATIONS; i++) {
			double t1 = System.nanoTime();
			new Eugene("./designs/genomatica/genomatica.eug");
			double nProcTime = (System.nanoTime()-t1) * Math.pow(10, -9);
			sum += nProcTime;
		}
		System.out.println("average processing time: " + (sum/NR_OF_ITERATIONS)+" sec");
	}
}
