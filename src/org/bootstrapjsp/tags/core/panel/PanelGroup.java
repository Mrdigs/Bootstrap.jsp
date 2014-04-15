package org.bootstrapjsp.tags.core.panel;

import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.Tag;

@Tag(name="panelgroup",dynamicAttributes=true)
public class PanelGroup extends Div {

	public PanelGroup() {
		super("panel-group");
	}
}
