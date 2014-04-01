/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.inputgroup;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.Tag;

@Tag(name="inputgroupaddon", dynamicAttributes=true)
public class InputGroupAddon extends Component {

	public InputGroupAddon() {
		super(Html.SPAN_ELEMENT);
		super.setAttribute(Html.CLASS_ATTRIBUTE, "input-group-addon");
		super.addFacet(new LabelFacet());
	}

}
