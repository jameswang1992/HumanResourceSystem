<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	
	$(function(){
		$("#quit").click(function(){
			if(confirm("您确定要退出吗?")){
				return true;
			}
			return false;
		})
	})
	
</script>
</head>
<body background="${pageContext.request.contextPath}/pictures/bg.jpg">
	<div id="large">			
		
		<h1 align="center">欢迎员工${sessionScope.user.userName}来到本公司</h1>							
		
		<div id="left">
			<ul type="square">
				<li><a href="${pageContext.request.contextPath}/cry/personalInfo"><span>个人信息</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/cry/showAttendance"><span>我的考勤</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/cry/updatePW"><span>修改密码</span></a></li><br/>
				<li><a href=""><span>我的奖惩</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/"><span>部门职位</span></a></li><br/>
				<li><a href=""><span>我的薪资</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/cry/goCheck"><span>点我去签到</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/user/quit" id="quit"><span>退出</span></a></li><br/>
			</ul>		
		</div>	
		
		
		<div id="right">
			<div align="center">
				<h3>来来来，改我</h3>
				<form action="${pageContext.request.contextPath}/cry/updatePW1" method="post">
					原始密码：<input type="text" value="${sessionScope.user.password}" readonly="readonly"><br/>
					修改密码：<input type="text" name="password" required="required"><br/>
						<input type="submit" value="确认">
				</form>
			</div>
		</div>					
	</div>
</body>
</html>