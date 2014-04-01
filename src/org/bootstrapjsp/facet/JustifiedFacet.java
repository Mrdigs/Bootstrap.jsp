/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.facet;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.Component;

public class JustifiedFacet extends PrefixedFacet<Component, Boolean> {

	public JustifiedFacet(String prefix, Boolean dflt) {
		super("justified", prefix, dflt);
	}

	@Override
	public void apply(Component tag) {
		if (super.getValue()) {
			final String value = super.getPrefix() + "-justified";
			tag.setAttribute(Html.CLASS_ATTRIBUTE, value);
		}
	}

	@Override
	public Boolean convert(String value) {
		return Boolean.valueOf(value);
	}
}
