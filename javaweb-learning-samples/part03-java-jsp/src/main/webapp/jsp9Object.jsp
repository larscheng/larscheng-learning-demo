<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Collections" %><%--
  Created by IntelliJ IDEA.
  User: lars
  Date: 2020/4/10
  Time: 上午9:31
  To change this template use File | Settings | File Templates.
--%>
<%--JSP 9大内置对象--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP 9大内置对象</title>
</head>
<body>
<%
    String[] objs = {"PageContext","Request","Session","Application","Response","Config","Out","Page","Exception"};
    ServletContext servletContext = pageContext.getServletContext();
    servletContext.setAttribute("objs", objs);
%>
<h3 style="text-align: center;">
    JSP 9大内置对象: <%=Arrays.toString((String[])pageContext.findAttribute("objs"))%>
</h3>
<hr>

<%
    pageContext.setAttribute("name1","张三1");//作用域：一个页面中，不可跨页面
    request.setAttribute("name2","张三2");//作用域：一次请求中，请求转发可跨页面
    session.setAttribute("name3","张三3");//作用域：一次会话中，跨页面
    application.setAttribute("name4","张三4");//作用域：一个服务器中，跨页面
%>

<%

    String name1 = (String) pageContext.findAttribute("name1");
    String name2 = (String) pageContext.findAttribute("name2");
    String name3 = (String) pageContext.findAttribute("name3");
    String name4 = (String) pageContext.findAttribute("name4");
%>

<h3><%=name1%></h3>
<h3><%=name2%></h3>
<h3><%=name3%></h3>
<h3><%=name4%></h3>

</body>
</html>
