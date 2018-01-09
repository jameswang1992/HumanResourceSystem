<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>显示面试信息</title>
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
		
		<h1 align="center">欢迎来到欢满堂招聘会</h1>							
		
		<div id="left">
			<ul type="square">
				<li><a href="${pageContext.request.contextPath}/user/showIVinfo"><span>反馈</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/user/readResume"><span>查看简历</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/user/modify"><span>修改密码</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/job/recruitInfo"><span>招聘信息</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/user/quit" id="quit"><span>退出</span></a></li><br/>
			</ul>		
		</div>	
		
		
		<div id="right">
			<table border="1" cellpadding="10" cellspacing="0">
				<tr>
					<td colspan="4">反馈信息</td>
				</tr>
				<tr>
					<td>投递时间</td>
					<td>面试时间</td>
					<td>面试地点</td>
					<td>是否录用</td>
				</tr>
				<tr>
					<td><f:formatDate value='${requestScope.app.appCreateTime}' pattern='yyyy-MM-dd'/></td>
					<td><f:formatDate value='${requestScope.iv.interTime}' pattern='yyyy-MM-dd'/></td>
					<td>${requestScope.iv.interAddress}</td>
					<td>${requestScope.iv.isHire}</td>
				</tr>
			</table>
		</div>					
	</div>
	
</body>
</html>