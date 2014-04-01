/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.facet;

import org.bootstrapjsp.support.NestedTagSupport;
import org.bootstrapjsp.tags.Text;

public class LabelFacet extends Facet<NestedTagSupport, String> {

	public LabelFacet() {
		super("label", null);
	}

	@Override
	public void apply(NestedTagSupport tag) {
		if (tag instanceof Labelable) {
			((Labelable) tag).applyLabel(super.getValue());
		} else {
			final Text textTag = new Text(super.getValue());
			tag.appendChild(textTag, NestedTagSupport.BEFORE_BODY);
		}
	}

	@Override
	public String convert(String value) {
		return value;
	}
}
