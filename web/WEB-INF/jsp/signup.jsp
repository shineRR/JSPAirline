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
    <title>Sign Up - FREE TICKETS</title>
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
        <h2>Register</h2>
        <a class="close" href="controller?command=goToMainPage">&times;</a>
        <form action="controller?command=new/insert" method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${flight != null}">
                            Edit Flight
                        </c:if>
                        <c:if test="${flight == null}">
                            Add New Flight
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${flight != null}">
                    <input type="hidden" name="id" value="<c:out value='${flight.id}' />" />
                </c:if>
                <tr>
                    <th>Src City: </th>
                    <td>
                        <input type="text" name="src" size="45"
                               value="<c:out value='${flight.src}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Login: </th>
                    <td>
                        <input type="text" name="dest" size="45"
                               value="<c:out value='${flight.dest}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Oassword: </th>
                    <td>
                        <input type="text" name="timestamp" size="45"
                               value="<c:out value='${user.timestamp}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Create an account" />
                    </td>
                </tr>
            </table>
        </form>
<%--        <div class="content">--%>
<%--            <span>Email:</span><input type="email">--%>
<%--            <span>Name:</span><input type="text">--%>
<%--            <span>Number:</span><input type="text">--%>
<%--            <span>Password</span><input type="password">--%>
<%--        </div>--%>
<%--        &nbsp;&nbsp;&nbsp;--%>
<%--        <h3><div class="act"><a class="enterBtn" href="controller?command=registration">Get an account</a></div></h3>--%>
    </div>
</div>

<main>
</main>



</body>
</html>