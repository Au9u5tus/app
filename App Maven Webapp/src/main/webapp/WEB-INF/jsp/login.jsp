<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file="bootHead.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../static/css/login.css"/>
	</head>
	<body style="background: url('../static/image/loginback.jpg') no-repeat;background-size:100% 100%">
		<div class="login-header">
			<div align="right">
				<button class="btn btn-lg btn-success" onclick="showLogin()">登录</button>
				<button class="btn btn-lg btn-success" >注册</button>
			</div>
		</div>
		<div class="login-box">
			<div class="panel panel-primary">
				<div class="panel-heading login-title">
					<h3 class="panel-title">登录信息</h3>
				</div>
				<div class="panel-body">
					<div class="login-body">
						<div class="login-avator">
							<img src="../static/image/avator.jpg" style="width:100%;height:70%;border-radius:50px;"/>
						</div>
					<div class="login-info">
					<form role="form" action="/StudentApp/login/go">
						<div class="form-group">
							<label for="name">名称</label>
							<input type="text" class="form-control" autocomplete="off" id="name" placeholder="请输入名称">
						</div>
						<div class="form-group">
							<label for="password">密码</label>
							<input type="password" id="password" class="form-control" placeholder="请输入密码">
						</div>
						<div class="checkbox">
							<label>
      						<input type="checkbox">记住用户名和密码
    					</label>
    					</div>
						<div class="login-btn">
							<button style="width: 100%;" class="btn btn-md btn-success" type="submit">
								<span class="glyphicon glyphicon-user"></span>登录
							</button>
						</div>
					</form>
				</div>
				</div>
				</div>
			</div>
		</div>
	</body>
<script>
	$("body").width($(document).width())
	$("body").height($(document).height())
	$(document).resize(function(){
		$("body").width($(document).width())
		$("body").height($(document).height())
	})
	var showLogin=function(){
		$(".login-box").toggle(500)
	}
</script>
</html>