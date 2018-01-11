<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>人事调动</title>
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
	
	
	
	$(function(){
		$("#transfer").click(function(){
			var userId = ${requestScope.user.userId};
			var deptId = $("select[name='deptId']").val();
			var positionId = $("select[name='positionId']").val();
			$.ajax({
				url:"${pageContext.request.contextPath}/happy/confirmTransfer",
				type:"post",
				dataType:"text",
				data:{deptId:deptId,userId:userId,positionId:positionId},
				success:function(data){
					if(data == 1){
						alert("调动成功");
					}else{
						alert("调动失败");
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
				<li><a href=""><span>培训管理</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/happy/showEmployees"><span>员工管理</span></a></li><br/>
				<li><a href=""><span>奖惩管理</span></a></li><br/>
				<li><a href=""><span>薪资管理</span></a></li><br/>
				<li><a href=""><span>工资异议</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/user/quit" id="quit"><span>退出</span></a></li><br/>
			</ul>		
		</div>	
		
		
		<div id="right">
			<h3>请选择调动的部门职位</h3>
			<form action="${pageContext.request.contextPath}/happy/showEmployees" method="post">
				<table align="center">
					<tr>
						<td>
							<select name="deptId">
								<c:forEach items="${requestScope.depts}" var="dept">
									<option value="${dept.deptId}" <c:if test="${dept.deptName eq requestScope.user.uDepartment.deptName}">selected</c:if>>${dept.deptName}</option>
								</c:forEach>
							</select>
							<select name="positionId">
								<c:if test="${!empty requestScope.user}">
									<c:forEach items="${requestScope.positions}" var="position">
										<option value="${position.positionId}" <c:if test="${position.positionName eq requestScope.user.uPosition.positionName}">selected</c:if>>${position.positionName}</option>
									</c:forEach>
								</c:if>
							</select>
						</td>
						<td>
							<input type="submit" value="调动" id="transfer">
							<button onclick="window.location='${pageContext.request.contextPath}/happy/back'">返回</button>
						</td>
					</tr>
				</table>
			</form>
		</div>					
	</div>
</body>
</html>