/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.facet;

import org.bootstrapjsp.exception.InvalidAttributeException;
import org.bootstrapjsp.tags.Component;

public class ForwardFacet extends Facet<Component, String> {

	public ForwardFacet() {
		super("forward", null);
	}

	@Override
	public void setValue(String value) {
		if (value.split("[=,]").length % 2 == 0) {
			super.setValue(value);
		} else {
			throw new InvalidAttributeException(this.getTag(), this.getName(), value);
		}
	}
	
	@Override
	public void apply(Component tag) {
		tag.setAttribute("data-forward", super.getValue());
	}

	@Override
	public String convert(String value) {
		return value;
	}
}
