package org.cidarlab.minieugene.symbol;

public class Symbol {

	/*
	 * id
	 */
	private int id;
	
	/*
	 * name
	 */
	private String name;
	
	/*
	 * direction
	 */
	private boolean forward;
	
	public Symbol(String name) {
		this.name = name;
		this.forward = true;

		this.id = this.name.hashCode();
	}
	
	public Symbol(String name, boolean forward) {
		this.name = name;
		this.forward = forward;
		
		this.id = this.name.hashCode();
	}
	
	public boolean isForward() {
		return forward;
	}
	
	public void setForward(boolean forward) {
		this.forward = forward;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String toPigeon() {
		if(!this.isForward()) {
			return "<"+this.getName();
		}
		return this.getName();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{").append(this.getId()).append(", ").append(this.getName()).append(", ");
		if(this.isForward()) {
			sb.append("->");
		} else {
			sb.append("<-");
		}
		sb.append("}");
		return sb.toString();
	}
}
