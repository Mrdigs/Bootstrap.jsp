/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.panel;

import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.tags.html.Heading;
import org.tldgen.annotations.Tag;

@Tag(name="paneltitle",dynamicAttributes=true)
public class PanelTitle extends Heading {

	public PanelTitle() {
		super(3, "panel-title");
		super.addFacet(new LabelFacet());
	}
	
	public PanelTitle(String label) {
		this();
		if (label != null) {
			super.getFacet(LabelFacet.class).setValue(label);
		}
	}

}