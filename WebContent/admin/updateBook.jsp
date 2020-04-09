<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改图书信息</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/add.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/dept/list.do"> 图书信息管理 </a>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="jumbotron">
			<h1>Hello, ${sessionScope.user.userName }!</h1>
			<p>请小心的修改图书信息。。。</p>
		</div>
		<div class="page-header">
			<h3>
				<small>修改</small>
			</h3>
		</div>
		<form class="form-horizontal"
			action="${pageContext.request.contextPath }/servlet/updateBook"
			method="post" enctype="multipart/form-data"
			onsubmit="return validateForm()">

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">图书编号 ：</label>
				<div class="col-sm-8">
					<input name="bookId" class="form-control" id="bookId"
						readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">图书名称 ：</label>
				<div class="col-sm-8">
					<input name="bookName" class="form-control" id="bookName">
				</div>
			</div>
			<div class="form-group">
				<label for="categoryId" class="col-sm-2 control-label">分类 ：</label>
				<select id="categoryId" name="categoryId"
					class="col-sm-2 form-control"
					style="width: auto; margin-left: 15px">
					<!-- 下拉列表的内容要从分类中进行读取，value值是分类id -->
	
					<c:forEach var="cate" items="${applicationScope.categoryList }">
					<!-- 显示该图书的类别 -->
						<c:choose>
							<c:when
								test="${requestScope.updateBook.bookCategory == cate.categoryName }">
								<option value="${cate.categoryId }" selected="selected">${cate.categoryName }</option>
							</c:when>
							<c:otherwise>
								<option value="${cate.categoryId }">${cate.categoryName }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">价格 ：</label>
				<div class="col-sm-8">
					<input name="bookPrice" class="form-control" id="bookPrice">
				</div>
			</div>

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">图书封面 ：</label> <input
					type="file" id="bookPic" name="bookPic" style="padding-left: 15px">
			</div>

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">备注 ：</label>
				<div class="col-sm-8">
					<input name="remarks" class="form-control" id="remarks">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">修改</button>
					&nbsp;&nbsp;&nbsp;
				</div>
			</div>
		</form>
	</div>
	<footer class="text-center"> copy@imooc </footer>

	<script type="text/javascript">
        //显示要修改的book信息
        $(function(){
        	$("#bookId").attr("value", "${requestScope.updateBook.bookId }");
        	$("#bookName").attr("value","${requestScope.updateBook.bookName }");
        	$("#bookPrice").attr("value","${requestScope.updateBook.bookPrice }");
        	$("#bookPic").attr("value","${requestScope.updateBook.bookImagePath }");
        	$("#remarks").attr("value","${requestScope.updateBook.bookRemark }");
        })
        
        
        function validateForm(){
        	var flag = true;
			//价格正则表达式 整数和2位小数都可以
        	var bookPriceRegex = /((^[1-9]\d*)|^0)(\.\d{0,2})?$/;
			
        	if(!$("#bookName").val()){
        		alert("请输入图书名称!");
        		flag = false;
        	}else if($("#categoryId").val() == "清选择"){
        		alert("请选择图书分类");
        		flag = false;
        	}else if(!bookPriceRegex.test($("#bookPrice").val())){
        		alert("请输入合法格式--99.99 or 0.5 or 10");
        		flag = false;
        	}else if(!$("#bookPic").val()){
        		alert("请上传图书封面");
        		flag = false;
        	}else if(!$("#remarks").val()){
        		alert("请输入备注信息!");
        		flag = false;
        	}
        	return flag;
        }
        
        </script>
</body>
</html>
