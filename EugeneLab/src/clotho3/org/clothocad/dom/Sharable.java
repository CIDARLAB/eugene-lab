package org.clothocad.dom;

/**
 *
 * @author jcanderson
 */
public abstract class Sharable 
		extends Datum {
	
	private static final long serialVersionUID = 4685496726003406285L;
	
	public static enum SharableType {SCHEMA, VIEW, FUNCTION, INSTANCE, BADGE, QUIZ, TRAIL, CONTENT, FIELD};

	private SharableType type;
	
	public Sharable(SharableType type) {
		this.type = type;
	}
	
    public SharableType getType() {
    	return this.type;
    }
    
}
