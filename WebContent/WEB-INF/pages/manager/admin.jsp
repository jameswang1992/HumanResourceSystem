<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>管理员页面</title>
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
		
		<h1 align="center">欢迎管理员${sessionScope.user.userName}来到本公司</h1>							
		
		<div id="left">
			<ul type="square">
				<li><a href="${pageContext.request.contextPath}/job/showApp"><span>应聘管理</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/job/recruit"><span>招聘管理</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/job/deptPosit"><span>部门职位</span></a></li><br/>
				<li><a href=""><span>培训管理</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/happy/showEmployees"><span>员工管理</span></a></li><br/>
				<li><a href=""><span>奖惩管理</span></a></li><br/>
				<li><a href=""><span>薪资管理</span></a></li><br/>
				<li><a href=""><span>工资异议</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/user/quit" id="quit"><span>退出</span></a></li><br/>
			</ul>		
		</div>	
		
		
		<div id="right">
				
		</div>					
	</div>
</body>
</html>