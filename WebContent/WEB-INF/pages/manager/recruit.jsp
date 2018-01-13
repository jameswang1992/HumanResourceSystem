<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>招聘管理</title>
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
		$("#back").click(function(){
			window.location.href="${pageContext.request.contextPath}/job/back";
		})
	})
	
	
	
	$(function(){
		$("select[name='deptId']").change(function(){
			var deptId = $(this).val();
			$.ajax({
				url:"${pageContext.request.contextPath}/user/queryPositionsByDeptId",
				type:"post",
				dataType:"json",
				data:{deptId:deptId},
				success:function(data){
					$("select[name='positionId']").empty();
					$.each(data,function(index,item){
						$("select[name='positionId']").append("<option value="+item.positionId+">"+item.positionName+"</option>");
					})
				},
				error:function(x,msg,obj){
					alert(msg);
				}
			})
			
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
				<li><a href=""><span>奖惩管理</span></a></li><br/>
				<li><a href=""><span>薪资管理</span></a></li><br/>
				<li><a href=""><span>工资异议</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/user/quit" id="quit"><span>退出</span></a></li><br/>
			</ul>		
		</div>	
		
		
		<div id="right">
			<form action="${pageContext.request.contextPath}/job/postRecmt" method="post">
				<table border="1" bordercolor="gray" cellpadding="10" cellspacing="0">
					<tr>
						<td colspan="2">发布招聘信息</td>
					</tr>
					<tr>
						<td>部门招聘</td>
						<td>
							<select name="deptId">
								<option value="0">部门</option>
								<c:forEach items="${requestScope.depts}" var="dept">
									<option value="${dept.deptId}">${dept.deptName}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>职位招聘</td>
						<td>
							<select name="positionId">
								<option value="无">职位</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>任职要求</td>
						<td><input type="text" name="requirement"></td>
					</tr>
					<tr>
						<td>薪资待遇</td>
						<td>
							<select name="treatment">
								<option value="3000-4000">3000-4000</option>
								<option value="4000-5000">4000-5000</option>
								<option value="5000-6000">5000-6000</option>
								<option value="6000-7000">6000-7000</option>
								<option value="7000-8000">7000-8000</option>
								<option value="8000-10000">8000-10000</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><input type="submit" value="发布"></td>
						<td><input type="button" value="返回" id="back"></td>
					</tr>
				</table>
			</form>
		</div>					
	</div>
</body>
</html>