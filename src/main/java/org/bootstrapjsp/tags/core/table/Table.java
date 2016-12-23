package org.bootstrapjsp.tags.core.table;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.bootstrapjsp.dialect.BlockLevel;
import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

/**
 * A Bootstrap Table with basic styling - light padding and only horizontal
 * dividers.
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;b:table&gt;... &lt;/b:table&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;table class="table"&gt;... &lt;/table&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Table extends Component implements BlockLevel {

	private boolean responsive = false;
	
	public Table() {
		super("table");
		super.setAttribute(Html.CLASS_ATTRIBUTE, "table");
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		if (this.responsive && !(super.getParent() instanceof TableResponsive)) {
			super.wrapIn(new TableResponsive());
		} else {
			super.doTag();
		}
	}
	
	/**
	 * Adds zebra-striping to any table row within the &lt;tbody&gt;.
	 */
	@Attribute(rtexprvalue=true)
	public void setStriped(boolean striped) {
		if (striped) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "table-striped");
		}
	}
	
	/**
	 * Adds borders on all sides of the table and cells.
	 */
	@Attribute(rtexprvalue=true)
	public void setBordered(boolean bordered) {
		if (bordered) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "table-bordered");
		}
	}

	/**
	 * Enables a hover state on table rows within a &lt;tbody&gt;.
	 */
	@Attribute(rtexprvalue=true)
	public void setHover(boolean hover) {
		if (hover) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "table-hover");
		}
	}

	/**
	 * Makes tables more compact by cutting cell padding in half.
	 */
	@Attribute(rtexprvalue=true)
	public void setCondensed(boolean condensed) {
		if (condensed) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "table-condensed");
		}
	}

	/**
	 * Makes tables scroll horizontally up to small devices (under 768px). When 
	 * viewing on anything larger than 768px wide, you will not see any difference 
	 * in these tables.
	 */
	@Attribute(rtexprvalue=true)
	public void setResponsive(boolean responsive) {
		this.responsive = responsive;
	}

}
