<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>登陆页面</title>
<style type="text/css">
	#main{
		position:absolute;
		top:0;
		right:0;
		bottom:0;
		left:0;
		margin: auto; 
		width:400px; 
		height:400px; 
		text-align:center;
	}
	
	body{
		text-align:center;
		background-repeat:no-repeat;
		background-position:center;
		background-attachment:fixed;
		background-size:cover;
	}

</style>
</head>
<body background="${pageContext.request.contextPath}/pictures/bg.jpg">
	<div id="main">
		<h1 style="color: orange">欢迎登录</h1><br/>
		<form action="${pageContext.request.contextPath}/user/login" method="post">
			<span style="color: purple">用户名字：&nbsp;</span><input type="text" required="required" name="userName">
			<br/><br/>
			<span style="color: purple">输入密码：&nbsp;</span><input type="text" required="required" name="password">
			<br/><br/>
			<span></span>
			<br/><br/>
			<input type="submit" name="login" value="登录">
		</form>
	</div>
</body>
</html>