<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>图书后台管理</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>
    </head>

    <body>
       <header>
            <div class="container">
                    <nav>
                            <a href="${pageContext.request.contextPath }/admin/bookList.jsp" >图书信息管理</a>
                    </nav>
                    <nav>
                            <a href="${pageContext.request.contextPath }/admin/categoryList.jsp" >分类管理</a>
                    </nav>
                   
            </div>
        </header>
        <section class="banner">
            <div class="container">
                <div>
                    <h1>图书管理系统</h1>
                    <p>图书分类管理</p>
                    <p id="msg">${requestScope.msg}</p>
                </div>
            </div>
        </section>
        <section class="main">
            <div class="container">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>分类编号</th>
                        <th>分类名称</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- 显示分类列表信息 -->
                       <c:forEach var="cate" items="${applicationScope.categoryList }" varStatus="idx">
                            <tr>
                                <td>${idx.index + 1 }</td>
                                <td>${cate.categoryId }</td>
                                <td>${cate.categoryName }</td>
                                <td><a href="${pageContext.request.contextPath }/servlet/deleteCategory?categoryId=${cate.categoryId }">删除</a></td>
                                
                            </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>
        <section class="page">
            <div class="container">
                <div id="fatie">
                    <a href="${pageContext.request.contextPath }/admin/addCategory.jsp"><button>新建</button></a>
                </div>
            </div>
        </section>
        <footer>
            copy@慕课网
        </footer>
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