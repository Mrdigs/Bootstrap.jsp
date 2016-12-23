package org.bootstrapjsp.tags.html;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.dialect.Inline;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Anchor extends Component implements Inline {

	public Anchor() {
		this(null);
	}

	public Anchor(String clazz) {
		super("a");
		super.setAttribute(Html.CLASS_ATTRIBUTE, clazz);
	}
}
