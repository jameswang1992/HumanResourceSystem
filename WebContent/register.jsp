<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>Insert title here</title>
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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("input[name='username']").blur(function(){
			var username = $(this).val();
			if(username.length < 3){
				$("#s1").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;长度不能小于3");
			}else{
				$("#s1").html("");
			}
		})
	})
</script>
</head>
<body background="${pageContext.request.contextPath}/pictures/register.jpg">
	<div id="main">
		<h1 style="color: blue">欢迎注册</h1><br/>
		<form action="#" method="post">
			<span style="color: white">用户名字：&nbsp;</span><input type="text" required="required" name="username"><br/>
			<span id="s1" style="color: red"></span><br/><br/>
			<span style="color: white">设置密码：&nbsp;</span><input type="text" required="required"><br/>	
			<span></span><br/><br/>
			<input type="submit" value="注册">
		</form>
	</div>
</body>
</html>