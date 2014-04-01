package org.bootstrapjsp.tags.html;

import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Script extends Component {

	public Script() {
		super("script");
		super.setAttribute("type", "text/javascript");
	}
}
