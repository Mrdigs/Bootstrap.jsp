/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.misc;

import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.facet.Labelable;
import org.bootstrapjsp.support.NestedTagSupport;
import org.bootstrapjsp.tags.html.Div;
import org.bootstrapjsp.tags.html.Heading;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.Tag;

/**
 * A simple shell for an <i>&lt;heading&gt;</i> to appropriately space out and 
 * segment sections of content on a page. It can utilize the <i>&lt;heading&gt;</i>'s 
 * default small element, as well as most other components (with additional 
 * styles).
 * <p>
 * The <i>&lt;heading&gt;</i> element is automatically added, and the body of
 * the <i>&lt;pageheader&gt;</i> will appear in the body of the <i>&lt;heading&gt;</i>.
 * Just set the <i>level</i> attribute to indicate the level of the 
 * <i>&lt;heading&gt;</i>.
 * </p>
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;b:pageheader level="3" label="..."/&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;div class="page-header"&gt;&lt;h3&gt;...&lt;/h3&gt;&lt;/div&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(name="pageheader",dynamicAttributes=true)
public class PageHeader extends Div implements Labelable {

	final Heading heading = new Heading();

	public PageHeader() {
		super("page-header");
		super.addFacet(new LabelFacet());
		super.appendChild(this.heading, NestedTagSupport.BEFORE_BODY);
	}

	@Override
	public void applyLabel(String label) {
		this.heading.setBody(label);
	}

	/**
	 * Sets the heading level (i.e. 1 = &lt;h1&gt;, 2 = &lt;h2&gt;, etc).
	 */
	@Attribute(rtexprvalue=true)
	public void setLevel(int level) {
		this.heading.setLevel(level);
	}
}
