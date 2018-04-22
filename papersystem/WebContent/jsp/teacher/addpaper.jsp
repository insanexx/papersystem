<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/kindeditor-4.1.11-en/kindeditor/themes/default/default.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/kindeditor-4.1.11-en/kindeditor/plugins/code/prettify.css" />
    <script charset="utf-8" src="${pageContext.request.contextPath }/kindeditor-4.1.11-en/kindeditor/kindeditor-all-min.js"></script>
    <script charset="utf-8" src="${pageContext.request.contextPath }/kindeditor-4.1.11-en/kindeditor/lang/zh-CN.js"></script>
    <script charset="utf-8" src="${pageContext.request.contextPath }/kindeditor-4.1.11-en/kindeditor/plugins/code/prettify.js"></script>
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
    <script type="text/javascript">
    	function sure(){
    		return confirm("确定删除吗？");
    	}
    </script>
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
	                  <th>论文题目：</th>
	                  <td><input type="text" id="lwtm" name="lwtm" class="form-control" placeholder="请输入论文题目" value="${paper.lwtm}"></td>
	                </tr>
	                	<tr>
		                  <th>关键词：</th>
	                  	  <td><input type="text" id="gjc" name="gjc" class="form-control" placeholder="请输入论文关键词" value="${paper.gjc}"></td>
	                	</tr>
	                	<tr>
		                  <th>摘要：</th>
	                  	  <td><input type="text" id="zhy" name="zhy" class="form-control" placeholder="请输入论文摘要" value="${paper.zhy}"></td>
	                	</tr>
	                	<tr>
		                  <th>姓名：</th>
	                  	  <td><input type="text" id="xm" name="xm" class="form-control" placeholder="请输入论文作者" value="${paper.xm}"></td>
	                	</tr>
	                	<tr>
		                  <th>学院：</th>
	                  	  <td><input type="text" id="xy" name="xy" class="form-control" placeholder="请输入学院" value="${paper.xy}"></td>
	                	</tr>
	                	<tr>
		                  <th>专业：</th>
	                  	  <td><input type="text" id="zy" name="zy" class="form-control" placeholder="请输入专业" value="${paper.zy}"></td>
	                	</tr>
	                	<tr>
		                  <th>届次：</th>
	                  	  <td><input type="text" id="jc" name="jc" class="form-control" placeholder="请输入届次" value="${paper.jc}"></td>
	                	</tr>
	                	<tr>
		                  <th>指导老师：</th>
	                  	  <td><input type="text" id="zdls" name="zdls" class="form-control" placeholder="请输入指导老师" value="${paper.zdls}"></td>
	                	</tr>
	                	<tr>
		                  <th>级别：</th>
	                  	  <td><input type="text" id="jb" name="jb" class="form-control" placeholder="请输入级别" value="${paper.jb}"></td>
	                	</tr>
	                	<tr>
		                  <th>内容：</th>
	                  	  <td><textarea id="nr" name="nr"  class="form-control" rows="6" cols="100">${paper.nr }</textarea></td>
	                	</tr>
	              		<tr>
	                  	  <td colspan="2" class="text-center">
	                  	  	<button class="btn btn-default" onclick="go()">提交</button>
	                  	  </td>
	                	</tr>
	              </tbody>
	            </table>
	            <script>
	            var editor1;
        		KindEditor.ready(function(K) {
        			editor1 = K.create('textarea[id="nr"]', {
        				cssPath : '${pageContext.request.contextPath }/kindeditor-4.1.11-en/kindeditor/plugins/code/prettify.css',
        				//uploadJson : '${pageContext.request.contextPath }/kindeditor-4.1.11-en/kindeditor/jsp/upload_json.jsp',
        			});
        			prettyPrint();
        		});
            	</script>
            </form>
          </div>
	     </div>
      </div>
    </main>

   	<script src="${pageContext.request.contextPath }/jquery-3.1.0/jquery-3.2.1.slim.min.js"></script>
   	<script src="${pageContext.request.contextPath }/jquery-3.1.0/jquery-3.1.0.min.js"></script>
   	<script src="${pageContext.request.contextPath }/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
  	<script src="${pageContext.request.contextPath }/js/popper.min.js"></script>
	<script>
	    $(function(){
			$(".ke-container").css("width","auto");
		});
       	var params = {lwtm:"论文题目？",nr:"内容？"};
    	//var control = $("#file-0");
    	var conf = {
    	        //'allowedFileExtensions' : [],
    	        //'maxFileSize': 1000,
    	        //'maxFilesNum': 3,
    	        maxFileSize: 10*1024,//单位为kb，如果为0表示不限制文件大小
    	       	showUpload: true, //<%--是否显示上传按钮(需要置为true，在css修改不可见，这样才能执行上面的提交：$(".fileinput-upload-button").click();)--%>
    	        showPreview: true,//是否预览
    	        uploadAsync: false,
    	        language: 'zh', //设置语言
    	        uploadExtraData:function(){
    	        	return params;
    	        },
    	        uploadUrl: "${pageContext.request.contextPath }/teacher/TeacherServlet?method=addpaper",
    	};
		
    	function go(){
    		editor1.sync();
    		var nr = $("#nr").val();
			var lwtm = $.trim($("#lwtm").val());
			if(lwtm==""){
				alert("请输入论文题目");
				return;
			}
			if(nr==""){
				alert("请输入内容");
				return;
			}
			if(lwtm.length>50){
				alert("论文题目不能超过50字");
				return;
			}
			params.lwtm = $("#lwtm").val();
			params.nr = $("#nr").val();
			params.gjc = $("#gjc").val();
			params.zhy = $("#zhy").val();
			params.xm = $("#xm").val();
			params.xy = $("#xy").val();
			params.zy = $("#zy").val();
			params.jc = $("#jc").val();
			params.zdls = $("#zdls").val();
			params.jb = $("#jb").val();
			
			params.method="addpaper";
			console.log("before send ajax");
			$.ajax({
	    		type:"POST",
	    		async:true,
	    		contentType:"application/x-www-form-urlencoded",
				url:"${pageContext.request.contextPath }/teacher/TeacherServlet",
				data:params,
				datatype: "text",//"xml", "html", "script", "json", "jsonp", "text".
				beforeSend:function(){
					console.log("before 00000");
				},
				success:function(data){
					data = jQuery.parseJSON(data);
					console.log(data);
					if(data.ok=="true"){
						alert(data.msg);
					}else{
						alert(data.msg);
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
  </body>
</html>
