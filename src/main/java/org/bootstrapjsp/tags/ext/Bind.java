package org.bootstrapjsp.tags.ext;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.bootstrapjsp.bind.Binder;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;
import org.tldgen.annotations.Variable;

@Tag(bodyContent=BodyContent.SCRIPTLESS)
public class Bind extends SimpleTagSupport {

	@Variable
	public Binder binder = new Binder();
	
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
	}

	@Attribute(rtexprvalue=true)
	public void setId(String id) {
		this.binder.setId(id);
	}
	
	@Attribute(rtexprvalue=true)
	public void setVm(Object vm) {
		this.binder.setVm(vm);
	}

}
