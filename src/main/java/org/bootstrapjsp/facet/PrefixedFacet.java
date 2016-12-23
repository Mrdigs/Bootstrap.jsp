/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.facet;

import org.bootstrapjsp.tags.Component;

public abstract class PrefixedFacet<T extends Component, V> extends Facet<T, V> {

	private final String prefix;

	public PrefixedFacet(String name, String prefix, V dflt) {
		super(name, dflt);
		this.prefix = prefix;
	}

	public final String getPrefixedValue() {
		if (this.prefix != null) {
			return this.prefix + "-" + super.getValue();
		}
		return "" + super.getValue();
	}
	
	public final String getPrefix() {
		return this.prefix;
	}

}
