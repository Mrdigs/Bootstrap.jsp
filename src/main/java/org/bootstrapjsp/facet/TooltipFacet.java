/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.facet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bootstrapjsp.support.NestedTagSupport;
import org.bootstrapjsp.tags.Component;
import org.bootstrapjsp.tags.html.Script;

public class TooltipFacet extends Facet<Component, Boolean> {

	private static List<String> VALID = Arrays.asList(
		"placement", "animation", "html", "selector", "trigger", "delay", "container"
	);

	private Map<String, String> attributes = new HashMap<String, String>();

	private boolean enabled = false;
	
	public TooltipFacet() {
		super(null, null);
	}

	@Override
	public boolean setValue(String name, Object value) {
		if (VALID.contains(name) && value instanceof String) {
			this.attributes.put("data-" + name, value.toString());
			super.setValue(true);
			return true;
		} else if ("toggle".equals(name) && "tooltip".equals(value)) {
			super.setValue(true);
			this.enabled = true;
			return true;
		}
		return false;
	}
	
	@Override
	public void apply(Component tag) {
		for (Entry<String, String> attribute : this.attributes.entrySet()) {
			tag.setAttribute(attribute.getKey(), attribute.getValue());
		}
		if (this.enabled) {
			final Script script = new Script();
			final StringBuilder body = new StringBuilder();
			final String uid = tag.getId(true);
			body.append("$(document).on('ready', function() {");
			body.append(" $('#" + uid + "').tooltip(); ");			
			body.append("});");
			script.setBody(body.toString());
			tag.appendChild(script, NestedTagSupport.AFTER_BODY);
		}
	}

	@Override
	public Boolean convert(String value) {
		return Boolean.valueOf(value);
	}
	
}
