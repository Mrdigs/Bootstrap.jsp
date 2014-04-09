/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.misc;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.Tag;

@Tag(name="buttontoolbar",dynamicAttributes=true)
public class ButtonToolbar extends Div {

	public ButtonToolbar() {
		super("btn-toolbar");
		super.setAttribute(Html.ROLE_ATTRIBUTE, "toolbar");
	}
}
