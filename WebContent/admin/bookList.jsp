<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书后台管理</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/index.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>
</head>

<body>
	<header>
		<!-- 错误提示信息 会隐藏 -->
		<p id="msg">${requestScope.msg}</p>
		<div class="container">
			<nav>
				<a href="${pageContext.request.contextPath }/admin/bookList.jsp">图书信息管理</a>
			</nav>
			<nav>
				<a href="${pageContext.request.contextPath }/admin/categoryList.jsp">分类管理</a>
			</nav>

		</div>
	</header>
	<section class="banner">
		<div class="container">
			<div>
				<h1>图书管理系统</h1>
				<p>图书信息管理</p>
			</div>
		</div>
	</section>
	<section class="main">


		<div class="container">
			<form class="form-horizontal" action="/searchBook" method="post">
				<div class="form-group" style="float: right;">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary">查询</button>
						&nbsp;&nbsp;&nbsp;
					</div>
				</div>
				<div class="form-group" style="float: right; width: 300px;">
					<div class="col-sm-8">
						<input name="searchContent" class="form-control"
							id="searchContent" placeholder="输入要查询的分类" style="width: 250px">
					</div>
				</div>


			</form>
		</div>
		<div class="container">
			<c:set var="bookList" value="${applicationScope.bookList}"></c:set>
			<c:if test="${bookList == null || bookList.size() == 0 }">
				<h1>暂无书籍，请添加！</h1>
			</c:if>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>序号</th>
						<th>图书编号</th>
						<th>图书名称</th>
						<th>分类</th>
						<th>价格</th>
						<th>图书封面</th>
						<th>操作</th>

					</tr>
				</thead>
				<tbody>


					<c:if test="${bookList.size() > 0 }">
						<c:forEach items="${bookList }" var="book" varStatus="idx">
							<tr>
								<td>${idx.index + 1 }</td>
								<td>${book.bookId }</td>
								<td>${book.bookName }</td>
								<td>${book.bookCategory }</td>
								<fmt:setLocale value="zh_cn" />
								<td><fmt:formatNumber value="${book.bookPrice }"
										type="currency" /></td>
								<td><img width="50" height="50"
									src="${book.bookImagePath }"></td>
								<td><a href="/updateBook?bookId=book0001">修改</a> <a
									href="${pageContext.request.contextPath }/servlet/deleteBook?bookId=${book.bookId }">删除</a></td>
								<!--在循环显示数据时，此处的book0001可以用EL表达式进行替换-->

							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</section>
	<section class="page">
		<div class="container">
			<div id="fatie">
				<a href="${pageContext.request.contextPath }/admin/addBook.jsp"><button>新建</button></a>
			</div>
		</div>
	</section>
	<footer> copy@慕课网 </footer>
	<script type="text/javascript">
        $(function(){
        	showErrorMessage();
        })
        
        //显示category存在的信息
        function showErrorMessage(){
        	$("#msg").hide();
        	var msg = $("#msg").text();
        	if(msg != "" && msg !=null){
        		alert(msg);
        	}
        }
        
        </script>
</body>
</html>