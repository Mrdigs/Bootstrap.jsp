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
 * A progress bar. The "striped" attribute is only used if the &lt;progressbar&gt;
 * is not wrapped in a &lt;progress&gt;, since it is an attribute of that 
 * component. This component will be automatically wrapped in a &lt;progress&gt;
 * if it is not already. In other words, if this component is inside a 
 * &lt;progress&gt;, then used "striped" on that component, otherwise use the
 * "striped" attribute on this component and the &lt;progress&gt; that it
 * is automatically wrapped in will acquire the "striped" value.
 * 
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
	
	@Attribute(required=true)
	public void setValue(int value) {
		super.setAttribute("aria-valuenow", String.valueOf(value));
		super.setAttribute(Html.STYLE_ATTRIBUTE, "width:" + value + "%");
	}
	
	@Attribute(required=true)
	public void setMin(int min) {
		super.setAttribute("aria-valuemin", String.valueOf(min));
	}

	@Attribute(required=true)
	public void setMax(int max) {
		super.setAttribute("aria-valuemax", String.valueOf(max));
	}
	
	@Attribute	
	public void setStriped(boolean striped) {
		this.striped = striped;
	}

}
