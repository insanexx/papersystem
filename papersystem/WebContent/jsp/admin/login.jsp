<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>管理员登录</title>
    <link href="${pageContext.request.contextPath }/bootstrap-4.0.0-dist/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/signin.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/jquery-3.1.0/jquery-3.1.0.min.js"></script>
  </head>
  <body class="text-center">
  	<label id="msg" style="display:none">${requestScope.message }</label>
    <form class="form-signin" action="${pageContext.request.contextPath }/admin/AdminServlet?method=login" method="POST">
      <img class="mb-4" src="${pageContext.request.contextPath }/img/2.png" alt="" width="72" height="72">
 	  <h1 class="jumbotron-heading">论文管理系统</h1>
 	  <h3>管理员登录</h3>
      <h1 class="h3 mb-3 font-weight-normal">login</h1>
      <label for="xm" class="sr-only">用户名</label>
      <input type="text" id="xm" class="form-control" placeholder="管理员姓名" required autofocus name="xm">
      <label for="mm" class="sr-only">密码</label>
      <input type="password" id="mm" class="form-control" placeholder="密码" required name="mm">
      <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      <br/>
    </form>
  </body>
</html>