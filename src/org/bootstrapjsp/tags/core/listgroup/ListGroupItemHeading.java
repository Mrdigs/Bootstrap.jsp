/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.listgroup;

import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.tags.html.Paragraph;
import org.tldgen.annotations.Tag;

@Tag(name="listgroupitemheading", dynamicAttributes=true)
public class ListGroupItemHeading extends Paragraph {

	public ListGroupItemHeading() {
		super("list-group-item-text");
		super.addFacet(new LabelFacet());
	}
	
	public ListGroupItemHeading(String label) {
		this();
		if (label != null) {
			super.getFacet(LabelFacet.class).setValue(label);
		}
	}
	
}
