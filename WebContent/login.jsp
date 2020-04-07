<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/login.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>
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
		<form action="${pageContext.request.contextPath }/servlet/login"
			method="post" onsubmit="return validateForm()">
			<div class="name">
				用户名：<input type="text" id="name" name="username">
				<p></p>
			</div>
			<div class="pwd">
				密码：<input type="password" id="pwd" name="password">
				<p></p>
			</div>
			<div class="code">
				<input type="text" id="code" name="verifyCode" style="width: 150px">
				&nbsp;&nbsp;&nbsp;&nbsp; <img
					src="${pageContext.request.contextPath}/servlet/verifyCode"
					style="width: 150px; height: 42px; vertical-align: middle;">
				<p></p>
			</div>
			<div class="btn-red">
				<input type="submit" value="登录" id="login-btn">
			</div>
			<script type="text/javascript">
				$(".header span").css({
					"color" : "red",
					"font-weight" : "bold"
				});

				//刷新验证码
				$(".code>img").click(
						function() {
							$(this).attr(
									"src",
									"${pageContext.request.contextPath}/servlet/verifyCode?time="
											+ new Date().getTime());
						});

				//validate value from input area
				function validateForm() {
					var flag = true;
					if (!$("input[id='name']").val().trim()
							|| !$("input[id='pwd']").val()) {
						alert('用户名或密码不能为空');
						flag = false;
					} else if (!$("input[id='code']").val().trim()) {
						alert('请输入验证码');
						flag = false;
					}
					return flag;
				}
			</script>
		</form>
	</div>
</body>
</html>