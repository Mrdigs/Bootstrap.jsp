/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.misc;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.ContextFacet;
import org.bootstrapjsp.facet.MoldFacet;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.Tag;

@Tag(dynamicAttributes=true)
public class Alert extends Component {

	public Alert() {
		super(Html.DIV_ELEMENT);
		super.addFacet(new ContextFacet("alert", null));
		super.setAttribute(Html.CLASS_ATTRIBUTE, "alert");
	}

	/**
	 * Sets whether this alert is dismissable or not. If true, a
	 * close button is added to the alert, and an 'alert-dismissable'
	 * class added to inform Bootstrap that the alert can is dismissed.
	 */
	@Attribute(rtexprvalue=true)
	public void setDismissable(boolean dismissable) {
		if (dismissable) {
			final Button closeButton = new Button();
			closeButton.getFacet(MoldFacet.class).setValue("close");
			closeButton.setDismiss("alert");
			super.appendChild(closeButton, BEFORE_BODY);
			super.setAttribute(Html.CLASS_ATTRIBUTE, "alert-dismissable");
		}
	}

}