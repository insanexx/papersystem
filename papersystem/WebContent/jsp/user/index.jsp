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
   <script src="${pageContext.request.contextPath }/jquery-3.1.0/jquery-3.2.1.slim.min.js"></script>
    <script src="${pageContext.request.contextPath }/jquery-3.1.0/jquery-3.1.0.min.js"></script>
   <script src="${pageContext.request.contextPath }/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
   <script src="${pageContext.request.contextPath }/js/popper.min.js"></script>
    <script>
    	function mysubmit(){
    		var params = {};
    		params.lwtm=$("#lwtm").val();
    		params.gjc=$("#gjc").val();
    		params.jc=$("#jc").val();
    		params.zy=$("#zy").val();
    		params.method="query";
    		$.ajax({
	    		type:"POST",
	    		async:true,
	    		contentType:"application/x-www-form-urlencoded",
				url:"${pageContext.request.contextPath }/user/UserServlet",
				data:params,
				datatype: "text",//"xml", "html", "script", "json", "jsonp", "text".
				beforeSend:function(){
				},
				success:function(data){
					data = jQuery.parseJSON(data);
					console.log(data);
					if(data.result=="yes"){
						var listdiv = $("#paperlistdiv");
						listdiv.empty();
						for(var i=0;i<data.data.length;i++){
							var lwtm = data.data[i].lwtm;
							var lwid = data.data[i].lwid;
							var div = "<div class='media text-muted pt-3'>"
									+"<div class='media-body pb-3 mb-0 small lh-125 border-bottom border-gray'>"
										+"<div class='d-flex justify-content-between align-items-center w-100'>"
											+"<span class='d-block'>论文编号："+lwid+"</span>"
										+"</div>"
										+"<span class='d-block'>论文题目："
											+"<a target='_blank' href='${pageContext.request.contextPath }/user/UserServlet?method=viewpaper&lwid="+lwid+"'>"+lwtm+"</a>"
										+"</span>"
									+"</div>"
									+"</div>";
							div = $(div);
							listdiv.append(div);
						}
						
					}else{
						alert(data.data);
					}
				},
	            complete: function(XMLHttpRequest, textStatus){
	            },
	            error: function(){
	            	alert("出错了，请稍后再试");
	            }
	    	});
    	}
    </script>
  </head>

  <body class="bg-light">
  
  

    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">论文管理系统(${sessionScope.user.xm })</a>
      
      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
        </ul>
        <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath }/user/UserServlet?method=logout" method="POST">
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
	      	<div class="container">
	      		<form class="navbar-form navbar-left" action="javascript:void(0)">
				  <div class="row">
				    <div class="col">
				      <input id="lwtm" name="lwtm" type="text" class="form-control" placeholder="论文题目">
				    </div>
				    <div class="col">
				      <input id="gjc" name="gjc" type="text" class="form-control" placeholder="关键词">
				    </div>
				    <div class="col">
				      <input id="jc" name="jc" type="text" class="form-control" placeholder="届次">
				    </div>
				    <div class="col">
				      <input id="zy" name="zy" type="text" class="form-control" placeholder="专业">
				    </div>
				    <div class="col">
				      <button class="btn btn-default" onclick="mysubmit()">查询</button>
				    </div>
				  </div>
				  <hr>
			  </form>
			</div>
			<div id="paperlistdiv">
		      	<%-- <div class="media text-muted pt-3">
		          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
		            <div class="d-flex justify-content-between align-items-center w-100">
		              <span class="d-block">论文编号：***</span>
		            </div>
	            	<span class="d-block">论文题目：<a target="_blank" href="${pageContext.request.contextPath }/user/UserServlet?method=viewpaper&lwid=${paper.lwid}">aaa</a></span>
		          </div>
		        </div> --%>
	        </div>
	      </div>
      </div>
    </main>
   
  </body>
</html>
