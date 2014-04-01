/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.panel;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.facet.Labelable;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(name="panelheading",bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class PanelHeading extends Component implements Labelable {

	public PanelHeading() {
		super(Html.DIV_ELEMENT);
		super.setAttribute(Html.CLASS_ATTRIBUTE, "panel-heading");
		super.addFacet(new LabelFacet());
	}
	
	public PanelHeading(String label) {
		this();
		if (label != null) {
			this.getFacet(LabelFacet.class).setValue(label);
		}
	}
	
	@Override
	public void applyLabel(String label) {
		super.appendChild(new PanelTitle(label), BEFORE_BODY);
	}
}
