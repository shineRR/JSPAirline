
<%--
  Created by IntelliJ IDEA.
  User: shine
  Date: 10/6/20
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index.jsp</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="../style/style.css">
</head>
<body>
<%--    <header>Yes</header>--%>
    <c:redirect url = "controller?command=goToMainPage" />
</body>
</html>
