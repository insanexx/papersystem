<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>首页</title>

    <link href="${pageContext.request.contextPath }/bootstrap-4.0.0-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/jumbotron.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/offcanvas.css" rel="stylesheet">
    <style type="text/css">
	    .input-group-lg>.form-control {
	   		font-size: 1rem;
	    }
	    .input-group-lg{
	   		padding-bottom: 2px;
	    }
    </style>
  </head>

  <body class="bg-light">
  
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">论文管理系统(${sessionScope.admin.xm })</a>
      
      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
        </ul>
        <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath }/admin/AdminServlet?method=logout" method="POST">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">注销</button>
        </form>
      </div>
    </nav>

    <main role="main">

      <div class="container">
      
		  <div class="d-flex align-items-center p-3 my-3 text-white-50 bg-purple rounded box-shadow">
	        <img class="mr-3" src="${pageContext.request.contextPath }/img/2.png" alt="" width="48" height="48">
	        <div class="lh-100">
	          <h6 class="mb-0 text-white lh-100">论文管理系统</h6>
	        </div>
      	  </div>
      	  <a class="btn btn-outline-success my-2 my-sm-0" role="button" href="${pageContext.request.contextPath }/admin/AdminServlet?method=teacherlist" target="_blank">教学秘书管理</a>
      	  <a class="btn btn-outline-success my-2 my-sm-0" role="button" href="${pageContext.request.contextPath }/admin/AdminServlet?method=userlist" target="_blank">用户管理</a>
	      <div class="my-3 p-3 bg-white rounded box-shadow">
	         <c:forEach items="${paperList }" var="paper">
		       <div class="media text-muted pt-3">
		          <img src="${pageContext.request.contextPath }/img/3.png" alt="" class="mr-2 rounded">
		          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
		            <div class="d-flex justify-content-between align-items-center w-100">
		              <span class="d-block">论文题目：${paper.lwtm}</span>
		            </div>
	            	<span class="d-block">论文编号：${paper.lwid }</span>
	            	<span class="d-block">级　　别：${paper.jb }</span>
	            	<span class="d-block">姓　　名：${paper.xm }</span>
	            	<span class="d-block">学　　院：${paper.xy}</span>
	            	<span class="d-block">专　　业：${paper.zy}</span>
	            	<span class="d-block">届　　次：${paper.jc}</span>
	            	<span class="d-block">指导老师：${paper.zdls}</span>
		            <div>
		            	<br/>
		            	 <a target="_blank" href="${pageContext.request.contextPath }/admin/AdminServlet?method=viewpaper&lwid=${paper.lwid}">查看论文详情</a>
		            </div>
		          </div>
		        </div>
	        </c:forEach>
	      </div>
      </div>
    </main>

   <script src="${pageContext.request.contextPath }/jquery-3.1.0/jquery-3.2.1.slim.min.js"></script>
   <script src="${pageContext.request.contextPath }/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
   <script src="${pageContext.request.contextPath }/js/popper.min.js"></script>
  </body>
</html>
