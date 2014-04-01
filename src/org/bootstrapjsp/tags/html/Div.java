package org.bootstrapjsp.tags.html;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Div extends Component {

	public Div() {
		super(Html.DIV_ELEMENT);
	}
}
