/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.facet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bootstrapjsp.dialect.BlockLevel;
import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.exception.InvalidAttributeException;
import org.bootstrapjsp.tags.Component;

public class ResponsiveFacet extends Facet<Component, Boolean> {

	private static List<String> VALID = Arrays.asList("visible", "hidden");

	private Set<String> classes = new HashSet<String>();
	
	public ResponsiveFacet() {
		super(null, null);
	}

	@Override
	public boolean setValue(String name, Object value) {
		if (VALID.contains(name) && value instanceof String) {
			for (String media : ((String) value).split(",")) {
				media = media.trim();
				if (media.length() > 0) {
					this.classes.add(name + "-" + media);
				}
			}
			if (this.classes.size() > 0) {
				super.setValue(true);
				return true;
			}
		} else if ("print".equals(name)) {
			if (Boolean.valueOf(value.toString())) {
				this.classes.add("visible-print");
			} else {
				this.classes.add("hidden-print");				
			}
			super.setValue(true);
			return true;
		}
		return false;
	}
	
	@Override
	public void apply(Component tag) {
		if (tag instanceof BlockLevel) {
			for (String clazz : this.classes) {
				tag.setAttribute(Html.CLASS_ATTRIBUTE, clazz);
			}
		} else {
			throw new InvalidAttributeException("Responsive classes are only available for block level elements");
		}
	}

	@Override
	public Boolean convert(String value) {
		return Boolean.valueOf(value);
	}
}
