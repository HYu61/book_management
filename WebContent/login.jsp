<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>登录</title>
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <div class="login">
            <div class="header">
                <h1>
                    <a href="/login.do">登录</a>
                </h1>
                <button></button>
            </div>
            <form action="/login.do" method="post">
                <div class="name">
                    <input type="text" id="name" name="username">
                    <p></p>
                </div>
                <div class="pwd">
                    <input type="password" id="pwd" name="password">
                    <p></p>
                </div>
                <div class="code">
                    <input type="text" id="code" name="verifyCode" style="width: 150px">
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <img src="code.jpg" style="width: 150px;height: 42px;vertical-align: middle;">
                    <p></p>
                </div>
                <div class="btn-red">
                    <input type="submit" value="登录" id="login-btn">
                </div>
            </form>
        </div>
    </body>
</html>