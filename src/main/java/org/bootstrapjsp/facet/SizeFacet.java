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

public class SizeFacet extends PrefixedFacet<Component, String> {

	private static final List<String> VALID = Arrays.asList(
		"lg", "sm", "xs"
	);

	public SizeFacet(String prefix, String dflt) {
		super("size", prefix, dflt);
		super.setValidValues(VALID);
	}

	public SizeFacet(String prefix, String dflt, String... valid) {
		super("size", prefix, dflt);
		super.setValidValues(Arrays.asList(valid));
	}

	@Override
	public void apply(Component tag) {
		final String value = super.getPrefix() + "-" + super.getValue();
		if (tag instanceof Sizeable) {
			((Sizeable) tag).applySize(value);
		} else {
			tag.setAttribute(Html.CLASS_ATTRIBUTE, value);
		}
	}

	@Override
	public String convert(String value) {
		return value;
	}
}
