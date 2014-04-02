/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.progress;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.ActiveFacet;
import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

/**
 * A progress bar.
 */
@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Progress extends Div {

	public Progress() {
		super("progress");
		super.addFacet(new ActiveFacet(false));
	}
	
	@Attribute(rtexprvalue=true)
	public void setStriped(boolean striped) {
		if (striped) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "progress-striped");
		}
	}
}
