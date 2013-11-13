package org.cidarlab.minieugene;

import org.cidarlab.minieugene.exception.EugeneException;
import org.cidarlab.minieugene.predicates.LogicalNot;
import org.cidarlab.minieugene.predicates.Predicate;
import org.cidarlab.minieugene.predicates.Then;
import org.cidarlab.minieugene.predicates.With;
import org.cidarlab.minieugene.predicates.counting.Contains;
import org.cidarlab.minieugene.predicates.counting.Exactly;
import org.cidarlab.minieugene.predicates.counting.MoreThan;
import org.cidarlab.minieugene.predicates.positional.StartsWith;
import org.cidarlab.minieugene.predicates.positional.EndsWith;
import org.cidarlab.minieugene.predicates.positional.after.AllAfter;
import org.cidarlab.minieugene.predicates.positional.after.SomeAfter;
import org.cidarlab.minieugene.predicates.positional.before.AllBefore;
import org.cidarlab.minieugene.predicates.positional.before.SomeBefore;
import org.cidarlab.minieugene.predicates.positional.nextto.AllNextTo;
import org.cidarlab.minieugene.predicates.positional.nextto.SomeNextTo;
import org.cidarlab.minieugene.rules.RuleOperator;

public class PredicateBuilder {

	public Predicate buildUnary(String p, int id) 
			throws EugeneException {
		
		if(RuleOperator.CONTAINS.toString().equalsIgnoreCase(p)) {
			return new Contains(id);
		} else if(RuleOperator.NOTCONTAINS.toString().equalsIgnoreCase(p)) {
			return new LogicalNot(new Contains(id));
		} else if(RuleOperator.STARTSWITH.toString().equalsIgnoreCase(p)) {
			return new StartsWith(id);
		} else if(RuleOperator.ENDSWITH.toString().equalsIgnoreCase(p)) {
			return new EndsWith(id);
		}
		
		throw new EugeneException("Invalid Unary Rule!");
	}

	public Predicate buildNegatedUnary(String p, int id) 
			throws EugeneException {
		
		Predicate predicate = this.buildUnary(p, id);
		if(null != predicate) {
			return new LogicalNot(predicate);
		}

		throw new EugeneException("Invalid Negated Unary Rule!");
	}
	
	public Predicate buildBinary(int idA, String X, int idB) 
			throws EugeneException {

		if(RuleOperator.ALL_BEFORE.toString().equalsIgnoreCase(X) || 
				RuleOperator.BEFORE.toString().equalsIgnoreCase(X)) {
			return new AllBefore(idA, idB);
		} else if(RuleOperator.SOME_BEFORE.toString().equalsIgnoreCase(X)) {
			return new SomeBefore(idA, idB);
		} else if(RuleOperator.ALL_AFTER.toString().equalsIgnoreCase(X) || 
				RuleOperator.AFTER.toString().equalsIgnoreCase(X)) {
			return new AllAfter(idA, idB);
		} else if(RuleOperator.SOME_AFTER.toString().equalsIgnoreCase(X)) {
			return new SomeAfter(idA, idB);
		} else if(RuleOperator.ALL_NEXTTO.toString().equalsIgnoreCase(X) || 
				RuleOperator.NEXTTO.toString().equalsIgnoreCase(X)) {
			return new AllNextTo(idA, idB);
		} else if(RuleOperator.SOME_NEXTTO.toString().equalsIgnoreCase(X)) {
			return new SomeNextTo(idA, idB);
		} else if(RuleOperator.WITH.toString().equalsIgnoreCase(X)) {
			return new With(idA, idB);
		} else if(RuleOperator.NOTWITH.toString().equalsIgnoreCase(X)) {
			return new LogicalNot(new With(idA, idB));
		} else if(RuleOperator.THEN.toString().equalsIgnoreCase(X)) {
			return new Then(idA, idB);
		} else if(RuleOperator.NOTTHEN.toString().equalsIgnoreCase(X)) {
			return new LogicalNot(new Then(idA, idB));
		} else if(RuleOperator.EXACTLY.toString().equalsIgnoreCase(X)) {
			return new Exactly(idA, idB);
		} else if(RuleOperator.NOTEXACTLY.toString().equalsIgnoreCase(X)) {
			return new LogicalNot(new Exactly(idA, idB));
		} else if(RuleOperator.MORETHAN.toString().equalsIgnoreCase(X)) {
			return new MoreThan(idA, idB);
		} else if(RuleOperator.NOTMORETHAN.toString().equalsIgnoreCase(X)) {
			return new LogicalNot(new MoreThan(idA, idB));
		}

		throw new EugeneException("Invalid Binary Rule!");
	}

}
