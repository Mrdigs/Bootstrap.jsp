/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.listgroup;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.bootstrapjsp.facet.ActiveFacet;
import org.bootstrapjsp.facet.ContextFacet;
import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.facet.Labelable;
import org.bootstrapjsp.tags.html.ListItem;
import org.tldgen.annotations.Tag;

/**
 * A List Group Item. 
 * <p>
 * &lt;li class="list-group-item"&gt;...&lt;/li&gt;
 * </p>
 */
@Tag(name="listgroupitem", dynamicAttributes=true)
public class ListGroupItem extends ListItem implements Labelable {
	
	public ListGroupItem() {
		super("list-group-item");
		super.addFacet(new ContextFacet("list-group-item", null));
		super.addFacet(new ActiveFacet(false));
		super.addFacet(new LabelFacet());
	}

	@Override
	public void doTag() throws JspException, IOException {
		final ListGroup listGroup = (ListGroup) super.getParent();
		final String parentElement = listGroup.getElement();
		if (!("ol".equals(parentElement) || "ul".equals(parentElement))) {
			if ("li".equals(super.getElement())) {
				super.setElement("a");
			}
		}
		super.doTag();
	}

	@Override
	public void applyLabel(String label) {
		super.appendChild(new ListGroupItemHeading(label), BEFORE_BODY);
		super.appendChild(new ListGroupItemText());
	}
	
}
