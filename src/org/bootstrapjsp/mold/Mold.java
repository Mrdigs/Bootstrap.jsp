/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.mold;

import org.bootstrapjsp.tags.Component;

public abstract class Mold<T extends Component> {
	
	public abstract void apply(T component, String mold);
	
	public boolean setAttribute(String name, Object value) {
		return false;
	}
}
