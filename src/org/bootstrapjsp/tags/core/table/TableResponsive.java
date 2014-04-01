package org.bootstrapjsp.tags.core.table;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(name="tableresponsive",bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class TableResponsive extends Div {

	public TableResponsive() {
		super();
		super.setAttribute(Html.CLASS_ATTRIBUTE, "table-responsive");
	}

}
