/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.panel;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.ContextFacet;
import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.facet.Labelable;
import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Panel extends Div implements Labelable {
	
	public Panel() {
		super();
		super.setAttribute(Html.CLASS_ATTRIBUTE, "panel");
		super.addFacet(new ContextFacet("panel", "default"));
		super.addFacet(new LabelFacet());
	}

	@Override
	public void applyLabel(String label) {
		super.appendChild(new PanelHeading(label), BEFORE_BODY);
		super.appendChild(new PanelBody());
	}
}
