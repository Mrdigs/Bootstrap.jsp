package org.bootstrapjsp.tags.core.misc;

import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.SCRIPTLESS, dynamicAttributes=true)
public class Caption extends Div {

	public Caption() {
		super("caption");
	}
}
