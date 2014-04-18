/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.progress;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.ActiveFacet;
import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

/**
 * A &lt;progress&gt; usually contains one or more &lt;progressbar&gt;s,
 * however, it is not normally required to use this tag unless you are using
 * more than one &lt;progressbar&gt;, since a &lt;progressbar&gt; will 
 * automatically wrap itself in a &lt;progress&gt; if it is not already.
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;progress&gt;... &lt;/progress&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;div class="progress"&gt;... &lt;/div&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Progress extends Div {

	public Progress() {
		super("progress");
		super.addFacet(new ActiveFacet(false));
	}
	
	/**
	 * Uses a gradient to create a striped effect. Not available in IE8. Note
	 * that if you use this component inside a &lt;progress&gt;, you should set 
	 * "striped" on that component instead.
	 */
	@Attribute(rtexprvalue=true)
	public void setStriped(boolean striped) {
		if (striped) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "progress-striped");
		}
	}
}
