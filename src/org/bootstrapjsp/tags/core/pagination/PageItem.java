/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.pagination;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.exception.InvalidAttributeException;
import org.bootstrapjsp.facet.ActiveFacet;
import org.bootstrapjsp.facet.DisabledFacet;
import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.facet.Labelable;
import org.bootstrapjsp.tags.ext.Message;
import org.bootstrapjsp.tags.html.Anchor;
import org.bootstrapjsp.tags.html.ListItem;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.Tag;

@Tag(name="pageitem",dynamicAttributes=true)
public class PageItem extends ListItem implements Labelable {

	private boolean next = false;

	private boolean previous = false;

	private Anchor anchor = new Anchor();
	
	public PageItem() {
		super();
		super.addFacet(new DisabledFacet(false));
		super.addFacet(new ActiveFacet(false));
		super.addFacet(new LabelFacet());
		super.appendChild(this.anchor);
	}

	@Override
	public void doTag() throws JspException, IOException {
		if (this.next) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "next");
		} else if (this.previous) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "previous");
		}
		super.doTag();
	}

	@Attribute(rtexprvalue=true)
	public void setNext(boolean next) {
		if (this.previous) throw new InvalidAttributeException("Page item cannot be both next and previous");
		this.next = next;
	}
	
	@Attribute(rtexprvalue=true)
	public void setPrevious(boolean previous) {
		if (this.next) throw new InvalidAttributeException("Page item cannot be both next and previous");
		this.previous = previous;
	}
	
	@Attribute(rtexprvalue=true)
	public void setHref(String href) {
		this.anchor.setAttribute("href", href);
	}

	@Override
	public void applyLabel(String label) {
		this.anchor.appendChild(new Message(label));
	}
}
