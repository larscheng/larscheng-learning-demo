<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="common/error.jsp" %>
<html>
<body>
<%@include file="common/header.jsp"%>


<h2>Hello World!</h2>
<%-- jsp注释 --%>
<%-- jsp表达式      变量或者表达式<%= %>  --%>
<%= new java.util.Date()%>

<hr>

<%-- jsp脚本片断     <% %>  --%>
<%
    int sum = 0;
    for (int j = 0; j < 10; j++) {
        sum += j;
    }
    out.write("<h1>i: " + sum + "</h1>");
%>
<hr>

<%for (int i = 0; i < 5; i++) {%>
    <h3>hahah121231233ah <%=i%></h3>
<%}%>

<%@include file="common/footer.jsp"%>

</body>
</html>
