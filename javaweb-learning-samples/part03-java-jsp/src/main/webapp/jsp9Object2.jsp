<%--
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

<h3 style="text-align: center;">
    不同页面读取JSP 9大内置对象
</h3>
<hr>


<%

    String name1 = (String) pageContext.findAttribute("name1");
    String name2 = (String) pageContext.findAttribute("name2");
    String name3 = (String) pageContext.findAttribute("name3");
    String name4 = (String) pageContext.findAttribute("name4");
//    out.write(name1+name2+name3+name4);
%>

<h3><%=name1%></h3>
<h3><%=name2%></h3>
<h3><%=name3%></h3>
<h3><%=name4%></h3>

</body>
</html>
