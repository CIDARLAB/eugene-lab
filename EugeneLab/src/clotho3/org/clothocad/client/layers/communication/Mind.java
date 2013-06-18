package org.clothocad.client.layers.communication;

import org.clothocad.dom.ClothoUser;

public class Mind {

	private ClothoUser user;
	
	public Mind(ClothoUser user) {
		this.user = user;
	}
	
	public ClothoUser getUser() {
		return this.user;
	}
}
