/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.panel;

import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.Tag;

/**
 * Wrap buttons or secondary text within a <i>&lt;panel&gt;</i> with a 
 * <i>&lt;panelfooter&gt;</i>. Note that panel footers do not inherit colors 
 * and borders when using contextual variations as they are not meant to be in
 * the foreground.
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;b:panelfooter&gt;...&lt;/b:panelfooter&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;div class="panel-footer"&gt;...&lt;/div&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(name="panelfooter",dynamicAttributes=true)
public class PanelFooter extends Div {

	public PanelFooter() {
		super("panel-footer");
	}
}
