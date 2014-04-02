/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.dropdown;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.html.ListItem;
import org.tldgen.annotations.Tag;

/**
 * A dropdown divider.
 * <p>
 * &lt;li class="divider" role="presentation"&gt;
 * </p>
 */
@Tag(dynamicAttributes=true)
public class Divider extends ListItem {

	public Divider() {
		super("divider");
		super.setAttribute(Html.ROLE_ATTRIBUTE, "presentation");
	}

}
