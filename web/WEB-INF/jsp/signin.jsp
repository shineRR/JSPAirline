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

<div id="popup1" class="overlay" align="center">
    <div class="popup">
        <h2>login</h2>
        <a class="close" href="controller?command=goToMainPage">&times;</a>
        <form action="controller?command=authorization" method="post">
            <table border="1" cellpadding="5">
                <tr>
                    <th>Login: </th>
                    <td>
                        <input type="text" name="login" size="45" minlength="1"/>
                    </td>
                </tr>
                <tr>
                    <th>Password: </th>
                    <td>
                        <input type="password" name="password" size="45" minlength="1"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Create an account" />
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

<main>
</main>

</body>
</html>