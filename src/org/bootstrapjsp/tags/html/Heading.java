package org.bootstrapjsp.tags.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.bootstrapjsp.dialect.BlockLevel;
import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.exception.InvalidAttributeException;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

/**
 * A heading. Defaults to an &lt;h1&gt; (level 1). The level of the element 
 * can be changed using the 'level' attribute. If the element of this 
 * component is changed from the default, it will acquire a class of
 * .h1-7 instead.
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;b:heading level="3" element="div"&gt;... &lt;/b:heading&gt;</dd>
 * <dd>&lt;b:heading level="4"&gt;... &lt;/b:heading&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;div class="h3"&gt;... &lt;/div&gt;</dd>
 * <dd>&lt;h4&gt;... &lt;/h4&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Heading extends Component implements BlockLevel {

	private int level = 1;
	
	public Heading() {
		this(1, null);
	}

	public Heading(int level, String clazz) {
		super(null);
		this.setLevel(level);
		super.setAttribute(Html.CLASS_ATTRIBUTE, clazz);
	}

	@Override
	public void doTag() throws JspException, IOException {
		final String element = super.getElement();
		if (element != null && !element.matches("^h[1-7]$")) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "h" + this.level);
		} else {
			super.setElement("h" + this.level);
		}
		super.doTag();
	}
	
	/**
	 * Sets the heading level (i.e. 1 = &lt;h1&gt;, 2 = &lt;h2&gt;, etc).
	 */
	@Attribute(rtexprvalue=true)
	public void setLevel(int level) {
		if (level > 0 && level < 7) {
			this.level = level;
			// this.setElement("h" + level);
		} else {
			throw new InvalidAttributeException(this, "level", level);
		}
	}
}
