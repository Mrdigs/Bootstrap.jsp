package org.bootstrapjsp.tags.core.typography;

import org.bootstrapjsp.tags.html.Paragraph;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Lead extends Paragraph {

	public Lead() {
		super("lead");
	}
}
