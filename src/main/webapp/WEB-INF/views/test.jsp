<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/3/10
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
test........
<hr>
<c:forEach items="${depts}" var="dept">

    <p>${dept.deptno}---${dept.dname}----${dept.dlocation}</p>

</c:forEach>

</body>
</html>
