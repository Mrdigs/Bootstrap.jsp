package org.bootstrapjsp.tags.html;

import org.bootstrapjsp.dialect.BlockLevel;
import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Paragraph extends Component implements BlockLevel {

	public Paragraph() {
		this(null);
	}
	
	public Paragraph(String clazz) {
		super("p");
		super.setAttribute(Html.CLASS_ATTRIBUTE, clazz);
	}
}
