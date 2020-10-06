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
    <div class="register">
        <a href="controller?command=goToSignUnPage">Register</a>
        <a href="controller?command=goToSignInPage">Log In</a>
    </div>

    <div class="grid-container">
        <nav class="header-menu">
            <a href="#"> <span>Tickets</span></a>
            <a href="#"> <span>Airline</span></a>
            <a href="#"> <span>Uno momento</span></a>
        </nav>
    </div>
</header>

<div id="popup1" class="overlay">
    <div class="popup">
        <h2>Register</h2>
        <a class="close" href="controller?command=goToMainPage">&times;</a>
        <div class="content">
            <span>Email:</span><input type="email">
            <span>Name:</span><input type="text">
            <span>Number:</span><input type="text">
            <span>Password</span><input type="password">
        </div>
        <div class="act"><a class="enterBtn" href="controller?command=goToMainPage">Get an account</a></div>
    </div>
</div>

<main>
<%--    <div class="sidebar">--%>
<%--        categories: <br><br>--%>
<%--        <a href="#">Italy</a> <a href="">Belarus</a> <a href="">USA</a> <a href="">Spain</a>--%>
<%--    </div>--%>
<%--    <div class="main-content">--%>
<%--        <div class="tickets">--%>
<%--            <div class="postbox">--%>
<%--                <div class="postcover"><img src="../../Assets/soldout.jpg" alt="" width="214" height="304"></div>--%>
<%--                <div class="posttitle"><a href="#">Italy</a></div>--%>
<%--            </div>--%>
<%--            <div class="postbox">--%>
<%--                <div class="postcover"><img src="../../Assets/soldout.jpg" alt="" width="214" height="304"></div>--%>
<%--                <div class="posttitle"><a href="#">Spain</a></div>--%>
<%--            </div>--%>
<%--            <div class="postbox">--%>
<%--                <div class="postcover"><img src="../../Assets/soldout.jpg" alt="" width="214" height="304"></div>--%>
<%--                <div class="posttitle"><a href="#">Turkey</a></div>--%>
<%--            </div>--%>
<%--            <div class="postbox">--%>
<%--                <div class="postcover"><img src="../../Assets/soldout.jpg" alt="" width="214" height="304"></div>--%>
<%--                <div class="posttitle"><a href="#">USA</a></div>--%>
<%--            </div>--%>
<%--            <div class="postbox">--%>
<%--                <div class="postcover"><img src="../../Assets/soldout.jpg" alt="" width="214" height="304"></div>--%>
<%--                <div class="posttitle"><a href="post.html">India</a></div>--%>
<%--            </div>--%>
<%--            <div class="postbox">--%>
<%--                <div class="postcover"><img src="../../Assets/soldout.jpg" alt="" width="214" height="304"></div>--%>
<%--                <div class="posttitle"><a href="#">Japan</a></div>--%>
<%--            </div>--%>
<%--            <div class="postbox">--%>
<%--                <div class="postcover"><img src="../../Assets/soldout.jpg" alt="" width="214" height="304"></div>--%>
<%--                <div class="posttitle"><a href="#">China</a></div>--%>
<%--            </div>--%>
<%--            <div class="postbox">--%>
<%--                <div class="postcover"><img src="../../Assets/soldout.jpg" alt="" width="214" height="304"></div>--%>
<%--                <div class="posttitle"><a href="#">Belarus</a></div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
</main>


<footer>
    <span>Hidden</span>
    <div class="bottom">
        <section>GIVE ME A MOMENT</section>
    </div>
</footer>

</body>
</html>