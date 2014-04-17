/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.panel;

import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.facet.Labelable;
import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.Tag;

/**
 * Easily add a heading container to your panel with <i>&lt;panelheading&gt;</i>. 
 * You may also include a <i>&lt;paneltitle&gt;</i> to add a pre-styled heading.
 * <p>
 * If you set a <i>label</i> attribute then a <i>&lt;paneltitle&gt;</i> will
 * automatically be added for you.
 * </p>
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;b:panelheading label="..."/&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;div class="panel-heading"&gt;&lt;h3 class="panel-title"&gt;...&lt;/h3&gt;&lt;/div&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(name="panelheading",dynamicAttributes=true)
public class PanelHeading extends Div implements Labelable {

	public PanelHeading() {
		super("panel-heading");
		super.addFacet(new LabelFacet());
	}
	
	public PanelHeading(String label) {
		this();
		if (label != null) {
			this.getFacet(LabelFacet.class).setValue(label);
		}
	}
	
	@Override
	public void applyLabel(String label) {
		super.appendChild(new PanelTitle(label), BEFORE_BODY);
	}
}
