package org.bootstrapjsp.tags.ext;

import org.junit.Ignore;
import org.junit.Test;

import javax.servlet.jsp.JspException;
import java.io.IOException;

public class KickstartTest {

    @Test
    @Ignore
    public void test() throws IOException, JspException {
        Kickstart kickstart = new Kickstart();
        kickstart.doTag();
    }

}
