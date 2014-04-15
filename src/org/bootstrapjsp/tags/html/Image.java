package org.bootstrapjsp.tags.html;

import java.util.Arrays;
import java.util.List;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.exception.InvalidAttributeException;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.Tag;

/**
 * An Image.
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;img&gt;... &lt;/img&gt;</dd>
 * <dt><b>Bootstrap Reference</b></dt>
 * <dd><a href="http://getbootstrap.com/css/#images">http://getbootstrap.com/css/#images</a></dd>
 * </dl>
 * @see <a href="http://getbootstrap.com/css/#images">http://getbootstrap.com/css/#images</a>
 */
@Tag(dynamicAttributes=true)
public class Image extends Component {

	private static final List<String> VALID_SHAPES = Arrays.asList("rounded", "circle", "thumbnail");
	
	public Image() {
		super("img");
	}

	/**
	 * Sets whether this is a responsive image or not.
	 */
	@Attribute(rtexprvalue=true)
	public void setResponsive(boolean responsive) {
		if (responsive) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "img-responsive");
		}
	}

	/**
	 * Sets the image shape.
	 */
	@Attribute(rtexprvalue=true)
	public void setShape(String shape) {
		if (VALID_SHAPES.contains(shape)) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "img-" + shape);
		} else {
			throw new InvalidAttributeException(this, "shape", shape);
		}
	}
	
	@Attribute(rtexprvalue=true)
	public void setThumbnail(boolean thumbnail) {
		if (thumbnail) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "img-thumbnail");
		}
	}
}
