/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.panel;

import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(name="panelfooter",bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class PanelFooter extends Div {

	public PanelFooter() {
		super("panel-footer");
	}
}
