<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="${pageContext.request.contextPath }/jquery-3.1.0/jquery-3.2.1.slim.min.js"></script>
   	<script src="${pageContext.request.contextPath }/jquery-3.1.0/jquery-3.1.0.min.js"></script>
   	<script src="${pageContext.request.contextPath }/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
  	<script src="${pageContext.request.contextPath }/js/popper.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/kindeditor-4.1.11-en/kindeditor/themes/default/default.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/kindeditor-4.1.11-en/kindeditor/plugins/code/prettify.css" />
    <script charset="utf-8" src="${pageContext.request.contextPath }/kindeditor-4.1.11-en/kindeditor/kindeditor-all-min.js"></script>
    <script charset="utf-8" src="${pageContext.request.contextPath }/kindeditor-4.1.11-en/kindeditor/lang/zh-CN.js"></script>
    <script charset="utf-8" src="${pageContext.request.contextPath }/kindeditor-4.1.11-en/kindeditor/plugins/code/prettify.js"></script>
    <title>首页</title>
	<script type="text/javascript">
		$(function(){
			var contentDiv = $("#content");
			var text = contentDiv.text();
			//$("#content").html(text);
		});
	</script>
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
      <a class="navbar-brand" href="#">论文管理系统(${sessionScope.teacher.xm })</a>
      
      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
        </ul>
        <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath }/teacher/TeacherServlet?method=logout" method="POST">
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
	      <div class="my-3 p-3 bg-white rounded box-shadow">
	        
	        <div class="table-responsive">
          	<form action="javascript:void(0)">
          		<%-- <input type="hidden" name="lwid" value="${paper.lwid}"> --%>
	            <table class="table table-striped" style="border:solid 1px white;">
	              <tbody>
	                <tr>
	                  <th width="120px;">论文题目</th>
	                  <td>${paper.lwtm}</td>
	                </tr>
	                	<tr>
		                  <th>关键词</th>
	                  	  <td>${paper.gjc}</td>
	                	</tr>
	                	<tr>
		                  <th>摘要</th>
	                  	  <td>${paper.zhy}</td>
	                	</tr>
	                	<tr>
		                  <th>姓名</th>
	                  	  <td>${paper.xm}</td>
	                	</tr>
	                	<tr>
		                  <th>学院</th>
	                  	  <td>${paper.xy}</td>
	                	</tr>
	                	<tr>
		                  <th>专业</th>
	                  	  <td>${paper.zy}</td>
	                	</tr>
	                	<tr>
		                  <th>届次</th>
	                  	  <td>${paper.jc}</td>
	                	</tr>
	                	<tr>
		                  <th>指导老师</th>
	                  	  <td>${paper.zdls}</td>
	                	</tr>
	                	<tr>
		                  <th>级别</th>
	                  	  <td>${paper.jb}</td>
	                	</tr>
	                	<tr>
		                  <th>内容</th>
	                  	  <td><div id="content">${paper.nr }</div></td>
	                	</tr>
	              </tbody>
	            </table>
            </form>
          </div>
	     </div>
      </div>
    </main>

   	
  </body>
</html>
