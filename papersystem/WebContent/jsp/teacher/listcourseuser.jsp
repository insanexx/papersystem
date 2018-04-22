<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>预订列表</title>

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
  
  
  		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="max-width: 600px">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">
							用户信息
						</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
					</div>
					<form >
						<div class="modal-body">
							<div class="input-group input-group-lg">
							  <span class="input-group-addon" style="margin-top: 10px;">账　　号：</span>
							  <input type="text" class="form-control" disabled id="username">
							</div>
							<div class="input-group input-group-lg">
							  <span class="input-group-addon" style="margin-top: 10px;">姓　　名：</span>
							  <input type="text" class="form-control" disabled id="name">
							</div>
							<div class="input-group input-group-lg">
							  <span class="input-group-addon" style="margin-top: 10px;">手　　机：</span>
							  <input type="text" class="form-control" disabled id="phone">
							</div>
							
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
						</div>
					</form>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		  </div>

    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">私教预订系统(${sessionScope.coach.name })</a>
      
      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
        </ul>
        <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath }/coach/CoachServlet?method=logout" method="POST">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">注销</button>
        </form>
      </div>
    </nav>

    <main role="main">

      <div class="container">
      
		  <div class="d-flex align-items-center p-3 my-3 text-white-50 bg-purple rounded box-shadow">
	        <img class="mr-3" src="${pageContext.request.contextPath }/img/2.png" alt="" width="48" height="48">
	        <div class="lh-100">
	          <h6 class="mb-0 text-white lh-100">User</h6>
	        </div>
      	  </div>
	      <div class="my-3 p-3 bg-white rounded box-shadow">
	       <div class="media text-muted pt-3">
	          <img src="${pageContext.request.contextPath }/img/3.png" alt="" class="mr-2 rounded">
	          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
	            <div class="d-flex justify-content-between align-items-center w-100">
	              <span class="d-block">课程时间：${course.time }</span>
	            </div>
            	<span class="d-block">课程地点：${course.place }</span>
            	<span class="d-block">课程简介：${course.content }</span>
	          </div>
	        </div>
	        <c:forEach items="${list }" var="u">
	        	<div class="media text-muted pt-3">
		          <img src="${pageContext.request.contextPath }/img/4.jpg" width="32" height="32" alt="" class="mr-2 rounded">
		          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
	            	<span class="d-block"><a href="#" onclick="showuser('${u.username}','${u.name}','${u.phone }')" data-toggle="modal" data-target="#myModal">用户：${u.username}</a></span>
		          </div>
	        	</div>
	        </c:forEach>
	      </div>
      </div>
    </main>

    <footer class="container">
      <p>&copy; Company 2017-2018</p>
    </footer>

   <script src="${pageContext.request.contextPath }/jquery-3.1.0/jquery-3.2.1.slim.min.js"></script>
   <script src="${pageContext.request.contextPath }/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
   <script src="${pageContext.request.contextPath }/js/popper.min.js"></script>
   <script>
   function showuser(username,name,phone){
	   $("#username").val(username);
	   $("#name").val(name);
	   $("#phone").val(phone);
   }
   </script>
  </body>
</html>
