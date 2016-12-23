/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.grid;

import org.bootstrapjsp.tags.core.misc.Container;
import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

/**
 * A Grid Row. Only valid inside a Container.
 */
@Tag(bodyContent=BodyContent.SCRIPTLESS, dynamicAttributes=true)
public class Row extends Div {

	@SuppressWarnings("unchecked")
	public Row() {
		super("row");
		super.setValidParents(Container.class, Column.class);
	}
}
