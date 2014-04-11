package org.bootstrapjsp.tags.html;

import org.bootstrapjsp.dialect.BlockLevel;
import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Div extends Component implements BlockLevel {

	public Div() {
		this(null);
	}
	
	public Div(String clazz) {
		super(Html.DIV_ELEMENT);
		super.setAttribute(Html.CLASS_ATTRIBUTE, clazz);
	}
}
