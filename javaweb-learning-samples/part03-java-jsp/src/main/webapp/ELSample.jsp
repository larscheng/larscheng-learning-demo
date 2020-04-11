<%--
  Created by IntelliJ IDEA.
  User: lars
  Date: 2020/4/10
  Time: 上午10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="ELSample.jsp" method="get">
    <input type="text" name="username" value="${param.username}">
    <input type="submit">
</form>

<c:if test="${param.username == 'admin'}" var="isAdmin">
    <c:out value="管理员欢迎你"/>
</c:if>
<c:out value="${isAdmin}"/>
</body>
</html>
