package org.bootstrapjsp.tags.html;

import org.bootstrapjsp.dialect.BlockLevel;
import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class List extends Component implements BlockLevel {

	public List() {
		this(false, null);
	}

	public List(boolean ordered, String clazz) {
		super(ordered? "ol" : "ul");
		super.setAttribute(Html.CLASS_ATTRIBUTE, clazz);
	}

	
	@Attribute(rtexprvalue=true)
	public void setUnstyled(boolean unstyled) {
		super.setAttribute(Html.CLASS_ATTRIBUTE, "list-unstyled");
	}
	
	@Attribute(rtexprvalue=true)
	public void setInline(boolean inline) {
		super.setAttribute(Html.CLASS_ATTRIBUTE, "list-inline");
	}
	
}
