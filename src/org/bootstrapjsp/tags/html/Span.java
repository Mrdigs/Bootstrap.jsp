package org.bootstrapjsp.tags.html;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.dialect.Inline;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Span extends Component implements Inline {

	public Span() {
		this(null);
	}
	
	public Span(String clazz) {
		super(Html.SPAN_ELEMENT);
		super.setAttribute(Html.CLASS_ATTRIBUTE, clazz);
	}
}
