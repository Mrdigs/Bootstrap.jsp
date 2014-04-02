/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.facet;

import java.util.Arrays;
import java.util.List;

import org.bootstrapjsp.tags.Component;

public class ToggleFacet extends Facet<Component, String> {

	private static List<String> VALID = Arrays.asList(
		"tooltip", "modal", "tab"
	);

	public ToggleFacet() {
		super("toggle", null);
		super.setValidValues(VALID);
	}

	@Override
	public void apply(Component tag) {
		if (tag instanceof Toggleable) {
			((Toggleable) tag).applyToggle(super.getValue());
		} else {
			tag.setAttribute("data-toggle", super.getValue());
		}
	}
	
	@Override
	public String convert(String value) {
		return value;
	}

}
