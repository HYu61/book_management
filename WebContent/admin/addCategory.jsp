<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>新建图书分类</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/add.css">
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>
         <script type="text/javascript" src="${pageContext.request.contextPath }/js/book-management.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="">
                        图书分类管理
                    </a>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="jumbotron">
                <h1>Hello, ${sessionScope.user.userName}</h1>
                <p>请小心地新增图书分类，要是建了一个错误的就不好了。。。</p>
            </div>
            <div class="page-header">
                <h3><small>新建</small></h3>
            </div>
            <form class="form-horizontal" action="${pageContext.request.contextPath }/servlet/addCategory" method="post" onsubmit="return validateForm()">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">分类ID ：</label>
                    <div class="col-sm-8">
                        <input name="categoryId" class="form-control" id="categoryId">
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">分类名称 ：</label>
                    <div class="col-sm-8">
                        <input name="categoryName" class="form-control" id="categoryName">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;
                    </div>
                </div>
            </form>
        </div>
        <footer class="text-center" >
            copy@imooc
        </footer>
        <script type="text/javascript">
        	function validateForm(){
        		var flag = true;
        		var cateId = $("input[id='categoryId']").val();
        		var cateName = $("input[id='categoryName']").val().trim();
        		
        		//id正则表达式
            	var regxPatt = /^ca\d{4}$/;          	
            	if(!regxPatt.test(cateId)){
            		alert("格式不对，请以ca开头4位数字结尾！");
            		flag = false;
            	}else if(!cateName ){
        			alert("名称不能为空");
        			flag = false;
        		}
        		return flag;
        	}
        </script>
    </body>
</html>
