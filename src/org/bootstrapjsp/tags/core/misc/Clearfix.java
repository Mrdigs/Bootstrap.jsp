package org.bootstrapjsp.tags.core.misc;

import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.Tag;

@Tag(dynamicAttributes=true)
public class Clearfix extends Div {

	public Clearfix() {
		super("clearfix");
	}
}
