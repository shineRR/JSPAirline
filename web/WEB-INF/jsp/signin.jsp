<%--
  Created by IntelliJ IDEA.
  User: shine
  Date: 9/30/20
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://fonts.googleapis.com/css?family=Montserrat+Alternates&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../style/style.css">
    <title>Sign In - FREE TICKETS</title>
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

<div id="popup1" class="overlay">
    <div class="popup">
        <h2>login</h2>
        <a class="close" href="controller?command=goToMainPage">&times;</a>
        <div class="content">
            <span>Email:</span><input type="email">
            <span>Password</span><input type="password">
        </div>
        &nbsp;&nbsp;&nbsp;
        <h3> <div class="act"><a class="enterBtn" href="controller?command=authorization">Enter</a></div></h3>
    </div>
</div>

<main>
</main>

</body>
</html>