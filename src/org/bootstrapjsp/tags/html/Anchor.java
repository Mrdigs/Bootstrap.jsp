package org.bootstrapjsp.tags.html;

import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Anchor extends Component {

	public Anchor() {
		super("a");
	}
		
}
