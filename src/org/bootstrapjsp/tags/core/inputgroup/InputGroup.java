/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.inputgroup;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.SizeFacet;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.Tag;

@Tag(name="inputgroup", dynamicAttributes=true)
public class InputGroup extends Component {

	public InputGroup() {
		super(Html.DIV_ELEMENT);
		super.setAttribute(Html.CLASS_ATTRIBUTE, "input-group");
		super.addFacet(new SizeFacet("input-group", null));
	}
}
