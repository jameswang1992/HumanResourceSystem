<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>个人信息</title>
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
		$("#submit").click(function(){
			var age = $("input[name='age']").val();
			var contact = $("input[name='contact']").val();
			var email = $("input[name='email']").val();
			var hobby = $("input[name='hobby']").val();
			$.ajax({
				url:"${pageContext.request.contextPath}/cry/modifyResume",
				type:"post",
				dataType:"text",
				data:{age:age,contact:contact,email:email,hobby:hobby},
				success:function(data){
					if(data == 1){
						alert("修改成功");
					}else{
						alert("修改失败");
					}
				},
				error:function(x,msg,obj){
					alert(msg);
				}
			})
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
				<li><a href="${pageContext.request.contextPath}/"><span>修改密码</span></a></li><br/>
				<li><a href=""><span>我的奖惩</span></a></li><br/>
				<li><a href=""><span>部门职位</span></a></li><br/>
				<li><a href=""><span>我的薪资</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/cry/goCheck"><span>点我去签到</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/user/quit" id="quit"><span>退出</span></a></li><br/>
			</ul>		
		</div>	
		
		
		<div id="right">
			<form action="" method="post">
				<table border="1" bordercolor="white" cellpadding="10" cellspacing="0">
					<tr>
						<td colspan="4">个人信息</td>
					</tr>
					<tr>
						<td>真实姓名</td>
						<td>${requestScope.resume.realName}</td>
						<td>性别</td>
						<td>${requestScope.resume.gender}</td>
					</tr>
					<tr>
						<td>年龄</td>
						<td><input type="number" name="age" value="${requestScope.resume.age}" required="required"></td>
						<td>学历</td>
						<td>${requestScope.resume.academic}</td>
					</tr>
					<tr>
						<td>联系方式</td>
						<td><input type="tel" name="contact"  required pattern="^[0-9]{11}" value="${requestScope.resume.contact}" required="required"></td>
						<td>e-mail</td>
						<td><input type="email" name="email"  value="${requestScope.resume.email}" required="required">
						</td>
					</tr>
					<tr>
						<td>应聘职位</td>
						<td>${requestScope.resume.rDepartment.deptName},${requestScope.resume.rPosition.positionName}</td>
						<td>政治面貌</td>
						<td>${requestScope.resume.political}</td>
					</tr>
					<tr>
						<td>入职时间</td>
						<td><f:formatDate value="${sessionScope.user.entryTime}" pattern="yyyy-MM-dd"/></td>
						<td>爱好</td>
						<td><input type="text" name="hobby" value="${requestScope.resume.hobby}" required="required"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="保存" id="submit"></td>
						<td colspan="2"><button onclick="window.location='${pageContext.request.contextPath}/cry/backup'" >返回</button></td>
					</tr>
				</table>
			</form>
		</div>					
	</div>
</body>
</html>