/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.facet;

import java.util.Arrays;

public class MoldFacet extends Facet<Moldable, String> {

	public MoldFacet(String... valid) {
		super("mold", null);
		if (valid.length > 0) {
			super.setValidValues(Arrays.asList(valid));
		}
	}

	@Override
	public void apply(Moldable tag) {
		tag.applyMold(super.getValue());
	}
	
	@Override
	public String convert(String value) {
		return value;
	}
}
