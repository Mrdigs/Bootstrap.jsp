/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.dropdown;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.html.List;
import org.tldgen.annotations.Tag;

/**
 * A Dropdown Menu.
 * <p>
 * &lt;ul class="dropdown-menu" role="menu"&gt;...&lt;/ul&gt;
 * </p>
 */
@Tag(name="dropdownmenu",dynamicAttributes=true)
public class DropdownMenu extends List {

	public DropdownMenu() {
		super(false, "dropdown-menu");
		super.setAttribute(Html.ROLE_ATTRIBUTE, "menu");
	}
}
