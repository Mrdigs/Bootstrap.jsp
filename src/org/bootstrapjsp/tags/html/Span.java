package org.bootstrapjsp.tags.html;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Span extends Component {

	public Span() {
		super(Html.SPAN_ELEMENT);
	}
}
