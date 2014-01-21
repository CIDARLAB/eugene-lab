package org.cidarlab.minieugene;

import org.cidarlab.minieugene.impl.MiniEugeneImpl;

/**
 * @author Ernst Oberortner
 *
 */
public class MiniEugeneFactory {

	public static MiniEugene instantiate() {
		return new MiniEugeneImpl();		
	}
}
