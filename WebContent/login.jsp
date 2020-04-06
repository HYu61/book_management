<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>登录</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css">
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>
    </head>
    <body>
        <div class="login">
            <div class="header">
                <h1>
                    <a href="${pageContext.request.contextPath }/servlet/login">登录</a>
                    
                    <!-- 显示报错信息 -->
                    <span>${requestScope.msg }</span>
                </h1>
               
                <button></button>
            </div>
            <form action="${pageContext.request.contextPath }/servlet/login" method="post">
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
                    <img src="${pageContext.request.contextPath}/servlet/verifycode" style="width: 150px;height: 42px;vertical-align: middle;">
                    <p></p>
                </div>
                <div class="btn-red">
                    <input type="submit" value="登录" id="login-btn">
                </div>
                <script type="text/javascript">
                $(".header span").css({"color":"red", "font-weight":"bold"});
                
                //刷新验证码
                $(".code>img").click(function(){
                	$(this).attr("src", "${pageContext.request.contextPath}/servlet/verifycode?time=" + new Date().getTime());
                });
                </script>
            </form>
        </div>
    </body>
</html>