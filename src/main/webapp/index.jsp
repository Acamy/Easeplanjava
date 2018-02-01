<%--
  Created by IntelliJ IDEA.
  User: Hebh
  Date: 2018/2/1
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Jsp Example!</title>
    </head>
    <body>
        <%--This is jsp comment--%>
        <%! String name;%>
        request uri is <%=request.getRequestURL()%>
        <br/>
        <%
            name = "abc";
            out.println("name is: " + name);
        %>
    </body>
</html>
