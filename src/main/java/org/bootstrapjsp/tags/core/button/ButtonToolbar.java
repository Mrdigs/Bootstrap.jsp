/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.button;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.Tag;

/**
 * Combine sets of button groups into a button toolbar for more complex 
 * components.
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;buttontoolbar&gt;... &lt;/buttontoolbar&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;div class="btn-toolbar" role="toolbar"&gt;... &lt;/div&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(name="buttontoolbar",dynamicAttributes=true)
public class ButtonToolbar extends Div {

	public ButtonToolbar() {
		super("btn-toolbar");
		super.setAttribute(Html.ROLE_ATTRIBUTE, "toolbar");
	}
}
