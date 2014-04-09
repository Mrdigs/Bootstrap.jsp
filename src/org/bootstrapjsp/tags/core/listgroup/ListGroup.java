/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.listgroup;

import org.bootstrapjsp.tags.html.List;
import org.tldgen.annotations.Tag;

/**
 * A List Group. List groups are a flexible and powerful component for 
 * displaying not only simple lists of elements, but complex ones with 
 * custom content.
 * <p>
 * &lt;ul class="list-group"&gt;...&lt;/ul&gt;
 * </p>
 */
@Tag(name="listgroup", dynamicAttributes=true)
public class ListGroup extends List {

	public ListGroup() {
		super(false, "list-group");
	}
}
