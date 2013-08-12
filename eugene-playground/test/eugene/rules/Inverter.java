package eugene.rules;

import org.cidarlab.eugene.algorithm.Product;
import org.cidarlab.eugene.fact.relation.Relation;
import org.cidarlab.eugene.rules.tree.predicate.Before;
import org.cidarlab.eugene.rules.tree.predicate.Contains;
import org.cidarlab.eugene.rules.tree.predicate.EndsWith;
import org.cidarlab.eugene.rules.tree.predicate.NextTo;
import org.cidarlab.eugene.rules.tree.predicate.LogicalNot;
import org.cidarlab.eugene.rules.tree.predicate.StartsWith;
import org.cidarlab.eugene.rules.tree.predicate.Then;
import org.cidarlab.eugene.rules.tree.predicate.With;

import eugene.cache.SymbolTables;
import eugene.dom.components.Device;
import eugene.dom.components.Part;
import eugene.dom.components.types.PartType;
import eugene.dom.relation.Interaction;
import eugene.dom.relation.Participant;
import eugene.dom.rules.Rule;
import eugene.exception.EugeneException;

public class Inverter {

	public static final int NR_OF_PARTS = 20;
	
	public static void main(String[] args) 
			throws EugeneException {
		Inverter inverter = new Inverter();
		
		SymbolTables.init();
		
		inverter.create();			
		inverter.defineRules();
		inverter.product();
		
		SymbolTables.cleanUp();
	}
	
	public void create() 
			throws EugeneException {

		PartType promoter = new PartType("Promoter");
		SymbolTables.put(promoter);
		PartType rbs = new PartType("RBS");
		SymbolTables.put(rbs);
		PartType gene = new PartType("Gene");
		SymbolTables.put(gene);
		PartType terminator = new PartType("Terminator");
		SymbolTables.put(terminator);
		
		for(int i=1; i<=NR_OF_PARTS; i++) {
			Part partPromoter = new Part(promoter, "promoter_"+i);
			SymbolTables.put(partPromoter);
			Part partRBS = new Part(rbs, "rbs_"+i);
			SymbolTables.put(partRBS);
			Part partGene = new Part(gene, "gene_"+i);
			SymbolTables.put(partGene);
			Part partTerminator = new Part(terminator, "terminator_"+i);
			SymbolTables.put(partTerminator);
		}

		/* create the TUs */
		Device TU1 = new Device("TU1");
		TU1.getComponents().add(promoter);
		TU1.getComponents().add(rbs);
		TU1.getComponents().add(gene);
		TU1.getComponents().add(terminator);		
		SymbolTables.put(TU1);

		Device TU2 = new Device("TU2");
		TU2.getComponents().add(promoter);
		TU2.getComponents().add(rbs);
		TU2.getComponents().add(gene);
		TU2.getComponents().add(terminator);
		SymbolTables.put(TU2);

		Device TU3 = new Device("TU3");
		TU3.getComponents().add(promoter);
		TU3.getComponents().add(rbs);
		TU3.getComponents().add(gene);
		TU3.getComponents().add(terminator);
		SymbolTables.put(TU2);
		
		Device TU4 = new Device("TU4");
		TU4.getComponents().add(promoter);
		TU4.getComponents().add(rbs);
		TU4.getComponents().add(gene);
		TU4.getComponents().add(terminator);
		SymbolTables.put(TU4);
		
		Device Inverter = new Device("Inverter");
		Inverter.getComponents().add(TU1);
		Inverter.getComponents().add(TU2);
		Inverter.getComponents().add(TU3);
		Inverter.getComponents().add(TU4);
		SymbolTables.put(Inverter);
		
//		Device tmpDevice = new Device("TEMP");
//		tmpDevice.getComponents().add(TU1);
//		tmpDevice.getComponents().add(TU2);
//		SymbolTables.put(tmpDevice);

		
		/** next, we gonna define some relationships **/
		Interaction rep1 = new Interaction(
				(Participant)Inverter.get("TU1").get("Gene"), 
				Relation.REPRESSES,
				(Participant)Inverter.get("TU2").get("Promoter")
				);
		SymbolTables.put(rep1);
		Interaction rep2 = new Interaction(
				(Participant)Inverter.get("TU1").get("Gene"), 
				Relation.REPRESSES,
				(Participant)Inverter.get("TU3").get("Promoter")
				);
		SymbolTables.put(rep2);
		Interaction rep3 = new Interaction(
				(Participant)Inverter.get("TU3").get("Gene"), 
				Relation.REPRESSES,
				(Participant)Inverter.get("TU2").get("Promoter")
				);
		SymbolTables.put(rep3);
	}
	
	public void defineRules() 
			throws EugeneException {
		Rule rule01 = new Rule("rbs_1-NEXTTO-gene_1", 
				new NextTo(
						SymbolTables.getId("rbs_1"), 
						SymbolTables.getId("gene_1")));		
		SymbolTables.put(rule01);
		
		Rule rule02 = new Rule("gene_1-BEFORE-gene_2", 
				new Before(
						SymbolTables.getId("gene_1"), 
						SymbolTables.getId("gene_2")));		
		SymbolTables.put(rule02);

//		Rule rule03 = new Rule("NOT_CONTAINS_terminator_6",
//				new LogicalNot(new Contains(SymbolTables.getId("terminator_6"))));		
//		SymbolTables.put(rule03);
		
		Rule rule04 = new Rule("promoter_1-NEXTTO-rbs_1",
				new NextTo(
						SymbolTables.getId("promoter_1"),
						SymbolTables.getId("rbs_1")));
		SymbolTables.put(rule04);
		
//		Rule rule05 = new Rule("promoter_1-WITH-promoter_2",
//				new With(
//						SymbolTables.getId("promoter_1"),
//						SymbolTables.getId("promoter_2")));
//		SymbolTables.put(rule05);
		
		Rule rule06 = new Rule("rbs_2-NEXTTO-promoter_2",
				new NextTo(
						SymbolTables.getId("rbs_2"),
						SymbolTables.getId("promoter_2")));
		SymbolTables.put(rule06);
		
		Rule rule07 = new Rule("gene_1-THEN-gene_2",
				new Then(
						SymbolTables.getId("gene_1"),
						SymbolTables.getId("gene_2")));
		SymbolTables.put(rule07);

//		Rule rule08 = new Rule("CONTAINS-promoter_10",
//				new Contains(SymbolTables.getId("promoter_10")));
//		SymbolTables.put(rule08);
//
//		Rule rule09 = new Rule("CONTAINS-rbs_10",
//				new Contains(SymbolTables.getId("rbs_10")));
//		SymbolTables.put(rule09);
//
//		Rule rule10 = new Rule("CONTAINS-terminator_10",
//				new Contains(SymbolTables.getId("terminator_10")));
//		SymbolTables.put(rule10);
		
		Rule rule11 = new Rule("STARTSWITH-promoter_1",
				new StartsWith(SymbolTables.getId("promoter_1")));
		SymbolTables.put(rule11);
		
		Rule rule12 = new Rule("ENDSWITH-terminator_2",
				new EndsWith(SymbolTables.getId("terminator_2")));
		SymbolTables.put(rule12);
	}
	
	public void product() 
			throws EugeneException {
		
		/* product a TU */
//		Product.product("TU1");
		
		/* product the Inverter */
		Product.product("Inverter", 20000);
	}
}
