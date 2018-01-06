<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>招聘信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
<style type="text/css">
	#recmt{
		border-bottom:1px solid; 
	}
</style>
</head>
<body background="${pageContext.request.contextPath}/pictures/bg.jpg">
	<div id="large">			
		
		<h1 align="center">欢迎来到欢满堂招聘会</h1>							
		
		<div id="left">
			<ul type="square">
				<li><a href=""><span>反馈</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/user/readResume"><span>查看简历</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/user/modify"><span>修改密码</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/job/recruitInfo"><span>招聘信息</span></a></li><br/>
				<li><a href=""><span>退出</span></a></li><br/>
			</ul>		
		</div>	
		
		
		<div id="right">
			<c:forEach items="${requestScope.recmts}" var="recmt">
				<div id="recmt">
					<p>我们需要这样的一个小伙伴</p>
					<p>任职部门：${recmt.rDepartment.deptName}</p>
					<p>任职职位：${recmt.rPosition.positionName}</p>
					<p>任职要求：${recmt.requirement}</p>
					<p>薪资待遇：${recmt.treatment}</p>
					<p><a href="#">投递简历</a></p>
				</div>
			</c:forEach>
		</div>					
	</div>
</body>
</html>