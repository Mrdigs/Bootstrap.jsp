/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.dropdown;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.AlignFacet;
import org.bootstrapjsp.tags.html.List;
import org.tldgen.annotations.Tag;

/**
 * A Dropdown Menu.
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;dropdownmenu pull="right"&gt;...&lt;/dropdownmenu&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;ul class="dropdown-menu dropdown-menu-right" role="menu"&gt;...&lt;/ul&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(name="dropdownmenu",dynamicAttributes=true)
public class DropdownMenu extends List {

	public DropdownMenu() {
		super(false, "dropdown-menu");
		super.setAttribute(Html.ROLE_ATTRIBUTE, "menu");
		super.addFacet(new AlignFacet("dropdown-menu"));
	}
}
