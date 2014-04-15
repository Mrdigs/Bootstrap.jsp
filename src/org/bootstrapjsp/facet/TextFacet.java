/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.facet;

import java.util.Arrays;
import java.util.List;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.Component;

public class TextFacet extends PrefixedFacet<Component, String> {

	private static final List<String> VALID = Arrays.asList(
		"primary", "success", "info", "warning", "danger"
	);
	
	public TextFacet() {
		super("text", null, null);
		super.setValidValues(VALID);
	}
	
	@Override
	public void apply(Component tag) {
		final String value = "text-" + super.getValue();
		tag.setAttribute(Html.CLASS_ATTRIBUTE, value);
	}

	@Override
	public String convert(String value) {
		return value;
	}
}
