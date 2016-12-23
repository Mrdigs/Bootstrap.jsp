/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.jsp.JspException;

import org.bootstrapjsp.bind.BindFacet;
import org.bootstrapjsp.facet.Facet;
import org.bootstrapjsp.facet.ForwardFacet;
import org.bootstrapjsp.facet.MoldFacet;
import org.bootstrapjsp.facet.ResponsiveFacet;
import org.bootstrapjsp.facet.TextFacet;
import org.bootstrapjsp.facet.ToggleFacet;
import org.bootstrapjsp.facet.TooltipFacet;
import org.bootstrapjsp.support.BaseTag;
import org.bootstrapjsp.support.HtmlTagSupport;

public abstract class Component extends HtmlTagSupport {

	private Set<Facet<? extends BaseTag, ?>> facets = new LinkedHashSet<Facet<? extends BaseTag, ?>>();
	
	public Component(String element) {
		super(element);
		this.addFacet(new MoldFacet());
		this.addFacet(new BindFacet());
		this.addFacet(new ResponsiveFacet());
		this.addFacet(new TooltipFacet());
		this.addFacet(new ToggleFacet());
		this.addFacet(new ForwardFacet());
		this.addFacet(new TextFacet());
	}

	public Component(String element, int evaluation) {
		super(element, evaluation);
		this.addFacet(new ResponsiveFacet());
	}

	public void addFacet(Facet<? extends BaseTag, ?> facet) {
		this.facets.add(facet);
		facet.setTag(this);
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		for (Facet<? extends BaseTag, ?> facet : this.facets) {
			facet.applyTo(this);
		}
		super.doTag();
	}
	
	public <T> T getFacet(Class<T> clazz) {
		for (Facet<? extends BaseTag, ?> facet : this.facets) {
			if (clazz.isInstance(facet)) {
				return (T) clazz.cast(facet);
			}
		}
		return null;
	}

	@Override
	public void setAttribute(String name, Object value) {
		if (value != null) {
			boolean set = false;
			for (Facet<? extends BaseTag, ?> facet : this.facets) {
				set = set || facet.setValue(name, value);
			}
			if (!set) {
				super.setAttribute(name, value);
			}
		}
	}
		
}
