package org.bootstrapjsp.tags.core.table;

import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

/**
 * A Div element that responsive tables should be wrapped in. It should rarely
 * be necessary to use this tag directly, as setting the "responsive" attribute
 * of the table component will automatically wrap it in one of these, but 
 * provided for that purpose and the purpose of completeness.
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;b:tableresponsive&gt;... &lt;/b:tableresponsive&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;div class="table-responsive"&gt;... &lt;/div&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(name="tableresponsive",bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class TableResponsive extends Div {

	public TableResponsive() {
		super("table-responsive");
	}

}
