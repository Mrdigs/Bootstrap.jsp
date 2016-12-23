/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.form;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.Tag;

@Tag(name="formcontrol",dynamicAttributes=true)
public class FormControl extends Component {

	public FormControl() {
		super("input");
		super.setAttribute(Html.CLASS_ATTRIBUTE, "form-control");
	}

	/**
	 * Sets the input type. If 'textarea', the input will be a
	 * &lt;textarea&gt;, if 'select', a &lt;select&gt;, otherwise a 
	 * &lt;input type="[type]"&gt;
	 */
	@Attribute(rtexprvalue=true)
	public void setType(String type) {
		if ("textarea".equals(type) || "select".equals(type)) {
			super.setElement(type);
		} else {
			super.setAttribute("type", type);
		}
	}
}