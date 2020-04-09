<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<h2>index!</h2>

<form action="${pageContext.request.contextPath}/login" method="get">

    账号： <input type="text" name="username"> <br>
    密码： <input type="password" name="password"> <br>
    <input type="submit">
</form>
</body>
</html>
