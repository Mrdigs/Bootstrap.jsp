/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.misc;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.ContextFacet;
import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.Tag;

/**
 * Provide contextual feedback messages for typical user actions with the 
 * handful of available and flexible alert messages.
 * <p>&lt;div class="alert"&gt;...&lt;/div&gt;</p>
 */
@Tag(dynamicAttributes=true)
public class Alert extends Div {

	public Alert() {
		super("alert");
		super.addFacet(new ContextFacet("alert", null));
	}

	/**
	 * Sets whether this alert is dismissable or not. If true, a
	 * close button is added to the alert, and an 'alert-dismissable'
	 * class added to inform Bootstrap that the alert can is dismissed.
	 */
	@Attribute(rtexprvalue=true)
	public void setDismissable(boolean dismissable) {
		if (dismissable) {
			final Close close = new Close();
			close.setDismiss("alert");
			super.appendChild(close, BEFORE_BODY);
			super.setAttribute(Html.CLASS_ATTRIBUTE, "alert-dismissable");
		}
	}

}