/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.grid;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.Component;
import org.bootstrapjsp.tags.core.misc.Container;
import org.tldgen.annotations.Tag;

@Tag(dynamicAttributes=true)
public class Row extends Component {

	@SuppressWarnings("unchecked")
	public Row() {
		super(Html.DIV_ELEMENT);
		super.setAttribute(Html.CLASS_ATTRIBUTE, "row");
		super.setValidParents(Container.class);
	}
}
