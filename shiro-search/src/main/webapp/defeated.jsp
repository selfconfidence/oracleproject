<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/10/1
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>defeated</title>
</head>
<body>
        <!--代表着当前登陆人的用户名-->
welCome:<shiro:principal></shiro:principal>
<<a href="/shiro/visit.do">访问</a>

</body>
</html>
