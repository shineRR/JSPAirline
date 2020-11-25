<%--
  Created by IntelliJ IDEA.
  User: shine
  Date: 9/29/20
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link href="https://fonts.googleapis.com/css?family=Montserrat+Alternates&display=swap" rel="stylesheet">
  <c:set var="root" value="${pageContext.request.contextPath}"/>
  <link type="text/css" rel="stylesheet" href="../style/style.css">
  <title>FREE TICKETS!!!</title>
</head>
<body>
<header>
  <div class="register" align="center">
    <h3>
      <a href="controller?command=goToSignUpPage">Register</a>
      &nbsp;&nbsp;&nbsp;
      <a href="controller?command=goToSignInPage">Log In</a>
      &nbsp;&nbsp;&nbsp;
      <a href="controller?command=goToFlightPage">Flights</a>
    </h3>
  </div>

</header>

<main>
</main>

</body>
</html>
