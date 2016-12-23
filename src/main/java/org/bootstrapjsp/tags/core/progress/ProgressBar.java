/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.progress;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.ContextFacet;
import org.bootstrapjsp.tags.ext.Message;
import org.bootstrapjsp.tags.html.Div;
import org.bootstrapjsp.tags.html.Span;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.Tag;

/**
 * Provide up-to-date feedback on the progress of a workflow or action with 
 * simple yet flexible progress bars.
 * <p>
 * This component will be automatically wrapped in a &lt;progress&gt; if it is 
 * not already.
 * </p>
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;b:progressbar&gt;... &lt;/b:progressbar&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;div class="progress"&gt;&lt;div class="progressbar"&gt;...&lt;/div&gt;&lt;/div&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(name="progressbar",dynamicAttributes=true)
public class ProgressBar extends Div {

	private String label;
	
	private boolean striped = false;
	
	public ProgressBar() {
		super("progress-bar");
		super.setAttribute(Html.ROLE_ATTRIBUTE, "progressbar");
		super.addFacet(new ContextFacet("progress-bar", null));
	}

	@Override
	public void doTag() throws JspException, IOException {
		if (this.label == null) {
			final Span span = new Span();
			span.setAttribute(Html.CLASS_ATTRIBUTE, "sr-only");
			super.appendChild(span);
		} else {
			super.appendChild(new Message(this.label), BEFORE_BODY);
		}
		if (!(super.getParent() instanceof Progress)) {
			final Progress progress = new Progress();
			progress.setStriped(this.striped);
			super.wrapIn(progress);
		} else {
			super.doTag();
		}
	}
	
	@Attribute(rtexprvalue=true)
	public void setLabel(String label) {
		this.label = label;
	}
	
	@Attribute(rtexprvalue=true,required=true)
	public void setValue(int value) {
		super.setAttribute("aria-valuenow", String.valueOf(value));
		super.setAttribute(Html.STYLE_ATTRIBUTE, "width:" + value + "%");
	}
	
	@Attribute(rtexprvalue=true,required=true)
	public void setMin(int min) {
		super.setAttribute("aria-valuemin", String.valueOf(min));
	}

	@Attribute(rtexprvalue=true,required=true)
	public void setMax(int max) {
		super.setAttribute("aria-valuemax", String.valueOf(max));
	}
	
	/**
	 * Uses a gradient to create a striped effect. Not available in IE8. Note
	 * that if you use this component inside a &lt;progress&gt;, you should set 
	 * "striped" on that component instead.
	 */
	@Attribute(rtexprvalue=true)
	public void setStriped(boolean striped) {
		this.striped = striped;
	}

}
