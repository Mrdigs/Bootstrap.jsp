/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.facet;

import org.bootstrapjsp.support.NestedTagSupport;
import org.bootstrapjsp.tags.Component;
import org.bootstrapjsp.tags.TextNode;
import org.bootstrapjsp.tags.core.button.Button;
import org.bootstrapjsp.tags.core.misc.Glyphicon;
import org.bootstrapjsp.util.Config;

public class IconFacet extends Facet<Component, String> {

	public IconFacet() {
		super("icon", null);
	}

	@Override
	public void apply(Component tag) {
		if (!(tag instanceof Button) || Config.useButtonIcons()) {
			final Glyphicon icon = new Glyphicon(super.getValue());
			tag.appendChild(icon, NestedTagSupport.BEFORE_BODY);
			tag.appendChild(new TextNode(" "), NestedTagSupport.BEFORE_BODY);
		}
	}

	@Override
	public String convert(String value) {
		return value;
	}
}
