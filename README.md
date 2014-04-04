Bootstrap.jsp
=============

Bootstrap.jsp is a JSP taglib for producing Bootstrap user interfaces.

Bootstrap is a powerful tool for creating nice looking, interactive interfaces 
quickly and easily. But it's not long before you find yourself wading through 
a mire of nested DIVs and class names.

If you use JSP and Bootstrap as your view technologies, and are frustrated with
the verbosity of Bootstrap markup, or are new to Bootstrap and looking for a 
simpler way of dealing with the details of Bootstrap compatible markup, then
Bootstrap.jsp is for you.

What does it provide?
---------------------

Bootstrap.jsp provides over 70 JSP tags, with a tag for almost every Bootstrap
class, and attributes for controlling the tag output. Many of the tags have a 
number of available molds for creating a predefined component, and some have 
configurable molds so you can define your own.

The Bootstrap.jsp distribution comes with Bootstrap 3.1.1 bundled, so you can 
just install the jar file and away you go.

For Example?
------------

Lets compare the Bootstrap markup for a simple button to the Bootstrap.jsp
markup required for the same result:

In HTML:

```html
<button class="btn btn-success">
	<span class="glyphicon glypicon-ok"></span> OK
</button>
```

In Bootstrap.jsp:

```xml
<b:button context="success" icon="ok" label="OK"/>
```

Not convinced? Let's use one of the predefined molds for buttons:

```xml
<b:button mold="ok"/>
```

Let's say you wanted to add an `href` to your button and have it work as an 
anchor instead of a button. Without Bootstrap.jsp you'd have to rewrite
your markup as:

```html
<a role="button" class="btn btn-success" href="#">
	<span class="glyphicon glyphicon-ok"> </span> OK
</a>
```

With Bootstrap.jsp, you can simply add an `href` attribute and it will take
care of the markup for you:

```xml
<b:button mold="ok" href="#"/>
```

Still not convinced? Ok lets try a more complex example...

Installation
------------

Grab a JAR file from the dist folder and place it in your WEB-INF/lib folder.
If you are using a Servlet 3.0 compatible container (e.g. Tomcat 7 or higher),
that's all there is to it.

If your container is < Servlet 3.0 compatible then you will need to add a
servlet to your web.xml to allow the container to serve the bundled Bootstrap
and supporting files from the JAR file:

```xml
<servlet>
	<servlet-name>ResourceServlet</servlet-name>
	<servlet-class>org.bootstrapjsp.util.ResourceServlet</servlet-class>
</servlet>
<servlet-mapping>
	<servlet-name>ResourceServlet</servlet-name>
	<url-pattern>/bootstrapjsp/*</url-pattern>
</servlet-mapping>
```

Getting Started
---------------

Once installation is complete, create a new JSP with the following contents,
and point your browser at it:

```xml
<%@ taglib uri="http://bootstrapjsp.org/" prefix="b" %>
<b:kickstart title="My First Page">
	<b:button mold="ok"/>
</b:kickstart>
```

The kickstart tag outputs a basic HTML `head` and `body` tag to help you get up
and running quickly. It is not really intended for production use, and you
would probably want to write your own `head` anyway.