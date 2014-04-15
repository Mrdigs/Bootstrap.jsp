/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.listgroup;

import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.tags.html.Heading;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.Tag;

@Tag(name="listgroupitemheading", dynamicAttributes=true)
public class ListGroupItemHeading extends Heading {

	public ListGroupItemHeading() {
		super(4, "list-group-item-heading");
		super.addFacet(new LabelFacet());
	}
	
	public ListGroupItemHeading(String label) {
		this();
		super.setAttribute("label", label);
	}
	
	@Override
	@Attribute(rtexprvalue=true)
	public void setLevel(int level) {
		super.setLevel(level);
	}
}
