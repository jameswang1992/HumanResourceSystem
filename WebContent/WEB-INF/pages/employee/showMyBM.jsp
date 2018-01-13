<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>查看个人奖惩</title>
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
	
	$(function(){
		$("#bMonth").change(function(){
			var bYear = $("#bYear").val();
			var bMonth = $(this).val();
			window.location.href="${pageContext.request.contextPath}/noob/searchbmRecord?bYear="+bYear+"&bMonth="+bMonth;
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
				<li><a href="${pageContext.request.contextPath}/noob/myBM"><span>我的奖惩</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/"><span>部门职位</span></a></li><br/>
				<li><a href=""><span>我的薪资</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/cry/goCheck"><span>点我去签到</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/user/quit" id="quit"><span>退出</span></a></li><br/>
			</ul>		
		</div>	
		
		
		<div id="right">
			<div align="center">
				<select id="bYear">
						<option value="2018" <c:if test="${requestScope.bYear == 2018}">selected</c:if>>2018</option>
					</select>年
				<select id="bMonth">
						<option value="1" <c:if test="${requestScope.bMonth == 1}">selected</c:if>>1</option>
						<option value="2" <c:if test="${requestScope.bMonth == 2}">selected</c:if>>2</option>
						<option value="3" <c:if test="${requestScope.bMonth == 3}">selected</c:if>>3</option>
					</select>月<br/>
					
					
				<table border="1" bordercolor="orange" cellpadding="10" cellspacing="0" id="table">
					<tr>
						<td>编号</td>
						<td>奖惩缘由</td>
						<td>奖惩时间</td>
						<td>奖惩金额</td>
						<td>奖惩类型</td>
					</tr>
					<c:if test="${!empty sessionScope.bms}">
						<c:forEach items="${sessionScope.bms}" var="bm">
							<tr>
								<td>${bm.bmId}</td>
								<td>${bm.bmReason}</td>
								<td><f:formatDate value="${bm.bmTime}" pattern="yyyy-MM-dd"/></td>
								<td>${bm.bmSalary}</td>
								<td>${bm.bmType}</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty sessionScope.bms}">
						<tr>
							<td colspan="5" align="center">暂无奖惩记录</td>
						</tr>
					</c:if>
				</table>
			</div>
		</div>					
	</div>
</body>
</html>