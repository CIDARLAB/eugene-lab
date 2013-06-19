/*
 * 
Copyright (c) 2010 The Regents of the University of California.
All rights reserved.
Permission is hereby granted, without written agreement and without
license or royalty fees, to use, copy, modify, and distribute this
software and its documentation for any purpose, provided that the above
copyright notice and the following two paragraphs appear in all copies
of this software.

IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY
FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES
ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
SUCH DAMAGE.

THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY WARRANTIES,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
CALIFORNIA HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES,
ENHANCEMENTS, OR MODIFICATIONS..
 */

package org.clothocad.dom;

import org.json.JSONObject;

/**
 * User's are used to authenticate individuals (by the Authenticator)
 * It's the object that represents an individual and whether or not
 * they are globally logged off or not.
 * 
 * Note that User explicitly does not implement Sharable.
 * 
 * The User is also entirely inaccessible from within the container.
 * 
 * When you log in to Clotho you are loggin in as a person, which
 * is relayed onto a user.  This is a personal security measure to allow people
 * to make distinct separations between modes of use.  For example, if an
 * individual works for two employers, and their IP needs to stay separated,
 * then that user would create two separate Persons to log in with.
 * 
 * When logged in, all aspects of your world are related to your person, not
 * your user.  The core does know about your Persons via their uuid, but the container
 * must be indexed from within the container, so indexing will occur over Persons,
 * not Users.
 * 
 * I think the deal is that Persons are normal dynamic objects referred to by the core
 * It's the one piece of the container hard coded by the core.  Other than that it is 
 * a normal Schema with normal ObjBases that follow normal Sharable rules.  So, Person
 * objects pass freely across domains (if you allow that).  However, Users own objects
 * while Persons have permissions for objects and are the owners of Objects (since people
 * will need to see who made stuff from within the container).
 * For security reasons, a User should never leak out of its domain.  You create a User on
 * a per-domain basis, and on each domain your Person maps to a User.  So, login state is 
 * referential to a particular domain.
 *
 * @author Ernst Oberortner
 */

public class ClothoUser 
		extends ClothoObject {
	
	private static final long serialVersionUID = 5084296205189240430L;
	
	private String username;
	private String password;
	
	public ClothoUser() {
		super();
	}
	
    public ClothoUser(String username, String password) {
    	super();
    	this.username = username;
    	this.password = password;
    }
    
    public String getUsername() {
    	return this.username;
    }
    
    public String getPassword() {
    	return this.password;
    }

	@Override
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put("username", this.getUsername());
			json.put("password", this.getPassword());
			return json;
		} catch(Exception e) {

		}
		return (JSONObject)null;
	}    
}
