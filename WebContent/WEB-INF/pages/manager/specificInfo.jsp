<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>员工详细信息</title>
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
		$("#reward").click(function(){
			$("#bonus").show();
		})		
	})
	
	
	$(function(){
		$("#submit").click(function(){
			var userId = ${requestScope.user.userId};
			var bmReason = $("input[name='bmReason']").val();
			var bmSalary = $("input[name='bmSalary']").val();
			var bmTime = $("input[name='bmTime']").val();
			$.ajax({
				url:"${pageContext.request.contextPath}/happy/reward",
				type:"post",
				dataType:"text",
				data:{bmReason:bmReason,bmSalary:bmSalary,bmTime:bmTime,userId:userId},
				success:function(data){
					if(data == 1){
						alert("奖励成功");
						$("#bonus").hide();
					}else{
						alert("奖励失败");
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
		
		<h1 align="center">欢迎管理员${sessionScope.user.userName}来到本公司</h1>							
		
		<div id="left">
			<ul type="square">
				<li><a href="${pageContext.request.contextPath}/job/showApp"><span>应聘管理</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/job/recruit"><span>招聘管理</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/job/deptPosit"><span>部门职位</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/job/training"><span>培训管理</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/happy/showEmployees"><span>员工管理</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/noob/showBM"><span>奖惩管理</span></a></li><br/>
				<li><a href=""><span>薪资管理</span></a></li><br/>
				<li><a href=""><span>工资异议</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/user/quit" id="quit"><span>退出</span></a></li><br/>
			</ul>		
		</div>	
		
		
		<div id="right">
				<table border="1" bordercolor="violet" cellpadding="10" cellspacing="0" align="center">
					<tr>
						<td colspan="4">员工信息</td>
					</tr>
					<tr>
						<td>姓名</td>
						<td>${requestScope.resume.realName}</td>
						<td>性别</td>
						<td>${requestScope.resume.gender}</td>
					</tr>
					<tr>
						<td>年龄</td>
						<td>${requestScope.resume.age}</td>
						<td>学历</td>
						<td>${requestScope.resume.academic}</td>
					</tr>
					<tr>
						<td>联系方式</td>
						<td>${requestScope.resume.contact}</td>
						<td>邮箱</td>
						<td>${requestScope.resume.email}</td>
					</tr>
					<tr>
						<td>入职时间</td>
						<td><f:formatDate value="${requestScope.user.entryTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td>部门，职位</td>
						<td>${requestScope.user.uDepartment.deptName},${requestScope.user.uPosition.positionName}</td>
					</tr>
					<tr>
						<td colspan="2"><button id="reward">赏赐</button></td>
						<td colspan="2"><button onclick="window.location='${pageContext.request.contextPath}/happy/back'">返回</button></td>
					</tr>
					
				</table>
				<div id="bonus" align="center" style="display: none">
					<h3 style="color: red">赏你个蹦得儿</h3>
					<form action="#" method="post">
						奖赏理由:<input type="text" name="bmReason" required="required"><br/>
						奖金款项:<input type="number" name="bmSalary" required="required"><br/>
						奖赏时间:<input type="date" name="bmTime" required="required"><br/>
							<input type="submit" value="确定" id="submit">	
					</form>
				</div>
		</div>					
	</div>
</body>
</html>












