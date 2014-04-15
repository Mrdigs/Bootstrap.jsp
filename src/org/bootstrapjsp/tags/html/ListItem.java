package org.bootstrapjsp.tags.html;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class ListItem extends Component {

	public ListItem() {
		this(null);
	}

	@SuppressWarnings("unchecked")
	public ListItem(String clazz) {
		super("li");
		super.setAttribute(Html.CLASS_ATTRIBUTE, clazz);
		super.setValidParents(List.class);
	}

}
