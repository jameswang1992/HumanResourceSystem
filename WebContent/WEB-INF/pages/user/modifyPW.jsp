<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>修改密码</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tourist.css">
</head>
<body background="${pageContext.request.contextPath}/pictures/bg.jpg">
	<div id="large">			
		
		<h1 align="center">欢迎来到欢满堂招聘会</h1>							
		
		<div id="left">
			<ul type="square">
				<li><a href=""><span>反馈</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/user/readResume"><span>查看简历</span></a></li><br/>
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