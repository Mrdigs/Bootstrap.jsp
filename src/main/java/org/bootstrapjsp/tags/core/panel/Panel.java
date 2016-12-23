/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.panel;

import org.bootstrapjsp.facet.ContextFacet;
import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.facet.Labelable;
import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

/**
 * While not always necessary, sometimes you need to put your DOM in a box. 
 * For those situations, try the panel component.
 * <p>
 * By default, all the <i>&lt;panel&gt;</i> does is apply some basic border 
 * and padding to contain some content.
 * </p>
 * <p>
 * If you set a <i>label</i> attribute, a <i>&lt;panelheading&gt;</i> will
 * automatically be added with the label text as the body, and a 
 * <i>&lt;panelbody&gt;</i> will also be added to hold your body. If not,
 * you will need to add your own heading and body.
 * </p>
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;b:panel label="Heading"&gt;...&lt;/b:panel&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;div class="panel"&gt;&lt;div class="panel-heading"&gt;...&lt;/div&gt;&lt;/div&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Panel extends Div implements Labelable {
	
	public Panel() {
		super("panel");
		super.addFacet(new ContextFacet("panel", "default"));
		super.addFacet(new LabelFacet());
	}

	@Override
	public void applyLabel(String label) {
		super.appendChild(new PanelHeading(label), BEFORE_BODY);
		super.appendChild(new PanelBody());
	}
}
