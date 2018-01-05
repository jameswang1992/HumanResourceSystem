<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>修改密码</title>
<style type="text/css">
	#large{
		float:left;
		width:100%; 
	}
	
	#left{
		float:left;
		border:1px solid;
		height:450px;
		width:20%; 
	}
	
	
	
	#right{
		float:right;
		border:1px solid;  
		width:70%;
		height:450px;
		text-align: center;
	}
	
	body{
		background-repeat:no-repeat;
		background-position:center;
		background-attachment:fixed;
		background-size:cover;
	}
	
	li{
		list-style-type:none;
	}
	
	a{
		color:brown;
		text-decoration:none;
	}
	
	span{
		font-size:30px;
	}

</style>
</head>
<body background="${pageContext.request.contextPath}/pictures/bg.jpg">
	<div id="large">			
		
		<h1 align="center">欢迎来到欢满堂招聘会</h1>							
		
		<div id="left">
			<ul type="square">
				<li><a href=""><span>反馈</span></a></li><br/>
				<li><a href=""><span>查看简历</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/modifyPW.jsp"><span>修改密码</span></a></li><br/>
				<li><a href=""><span>公司人事</span></a></li><br/>
				<li><a href=""><span>退出</span></a></li><br/>
			</ul>		
		</div>	
		
		
		<div id="right">
			<form action="#" method="post">
				修改密码:<input type="text"><br/>
					<input type="submit" value="确定">
			</form>
		</div>					
	</div>
</body>
</html>