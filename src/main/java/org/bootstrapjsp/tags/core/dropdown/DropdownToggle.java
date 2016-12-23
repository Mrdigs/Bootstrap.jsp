package org.bootstrapjsp.tags.core.dropdown;

import org.bootstrapjsp.facet.ToggleFacet;
import org.bootstrapjsp.tags.html.Anchor;
import org.tldgen.annotations.Tag;

@Tag(name="dropdowntoggle",dynamicAttributes=true)
public class DropdownToggle extends Anchor {

	public DropdownToggle() {
		super("dropdown-toggle");
		super.getFacet(ToggleFacet.class).setValidValues("dropdown");
		super.setAttribute("toggle", "dropdown");
	}
}
