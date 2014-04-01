/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.listgroup;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.Tag;

@Tag(name="listgroup", dynamicAttributes=true)
public class ListGroup extends Component {

	public ListGroup() {
		super("ul");
		super.setAttribute(Html.CLASS_ATTRIBUTE, "list-group");
	}
}
