package org.clothocad.dom;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

import org.json.JSONObject;

@XmlRootElement
public abstract class Datum 
	implements Serializable, ObjBase {
	
	private static final long serialVersionUID = -4383410157216396194L;
	
	private UUID uuid;
	private Date dateCreated;
	private Date lastModified;
	private Date lastAccessed;
	
	public Datum() {
		// create a random UUID
		this.uuid = UUID.randomUUID();
		this.dateCreated = new Date();
		this.lastModified = new Date();
		this.lastAccessed = new Date();
	}	
	
	public UUID getUUID() {
		return this.uuid;
	}
	
	public Date getDateCreated() {
		return this.dateCreated;
	}
	
	public Date getLastModifed() {
		return this.lastModified;
	}
	
	public Date getLastAccessed() {
		return this.lastAccessed;
	}
	
    // every Datum must implement the toJSON method
    public abstract JSONObject toJSON();
}
