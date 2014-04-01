/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.listgroup;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.Tag;

@Tag(name="listgroupitemheading", dynamicAttributes=true)
public class ListGroupItemHeading extends Component {

	public ListGroupItemHeading() {
		super("p");
		super.setAttribute(Html.CLASS_ATTRIBUTE, "list-group-item-text");
		super.addFacet(new LabelFacet());
	}
	
	public ListGroupItemHeading(String label) {
		this();
		if (label != null) {
			super.getFacet(LabelFacet.class).setValue(label);
		}
	}
	
}
