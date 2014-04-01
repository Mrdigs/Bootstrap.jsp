/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.dropdown;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.Tag;

/**
 * A Dropdown header.
 * <p>
 * &lt;li class="dropdown-header" role="persentaton"&gt;...&lt;/li&gt;
 * </p>
 */
@Tag(name="dropdownheader", dynamicAttributes=true)
public class DropdownHeader extends Component {

	public DropdownHeader() {
		super("li");
		super.setAttribute(Html.CLASS_ATTRIBUTE, "dropdown-header");
		super.setAttribute(Html.ROLE_ATTRIBUTE, "presentation");
		super.addFacet(new LabelFacet());
	}

}
