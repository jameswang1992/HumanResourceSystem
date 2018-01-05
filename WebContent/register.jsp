<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>注册页面</title>
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
		$("input[name='userName']").blur(function(){
			var userName = $(this).val();
			if(userName.length < 3){
				$("#s1").html("&nbsp;&nbsp;&nbsp;&nbsp;长度不能小于3");
				$("input[name='register']").attr("disabled",true);
				$("#s2").html("");
			}else{
				$("#s1").html("");
				$("input[name='register']").attr("disabled",false);
				$.ajax({
					url:"${pageContext.request.contextPath}/user/queryUserByUserName",
					type:"post",
					dataType:"text",
					data:{userName:userName},
					success:function(data){
						if(data==1){
							$("#s2").html("用户已存在");
							$("input[name='register']").attr("disabled",true);
							
						}else{
							$("#s2").html("");
							$("input[name='register']").attr("disabled",false);
						}					
					},
					error:function(x,msg,obj){
						alert(msg);
					}
				})
			}
		})
	})
</script>
</head>
<body background="${pageContext.request.contextPath}/pictures/bg.jpg">
	<div id="main">
		<h1 style="color: blue">欢迎注册</h1><br/>
		<form action="${pageContext.request.contextPath}/user/register" method="post">
			<span style="color: gold">用户名字：&nbsp;</span><input type="text" required="required" name="userName"><br/>
			<span id="s1" style="color: red"></span><br/>
			<span id="s2" style="color: red"></span><br/>
			<span style="color: gold">设置密码：&nbsp;</span><input type="text" required="required" name="password"><br/>	
			<span></span><br/><br/>
			<input type="submit" name="register" value="注册">
		</form>
	</div>
</body>
</html>