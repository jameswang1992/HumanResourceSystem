<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>显示通知</title>
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
		$("#iv").click(function(){
			$("#notice").show();
		})
	})
	
	$(function(){
		$("#agree").click(function(){
			var userId =$(this).attr("name");
			$.ajax({
				url:"${pageContext.request.contextPath}/happy/agree",
				type:"post",
				dataType:"text",
				data:{userId:userId},
				success:function(data){
					if(data == 1){
						alert("录用成功");
						window.location.reload();
					}else{
						alert("录用失败");
					}
				},
				error:function(x,msg,obj){
					alert(msg);
				}
			})
			return false;
		})
	})
	
	
	$(function(){
		$("#disagree").click(function(){
			var userId =$(this).attr("name");
			$.ajax({
				url:"${pageContext.request.contextPath}/happy/disagree",
				type:"post",
				dataType:"text",
				data:{userId:userId},
				success:function(data){
					if(data == 1){
						alert("拒绝成功");
						window.location.reload();
					}else{
						alert("拒绝失败");
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
		
		<h1 align="center">欢迎部门主管${user.userName}</h1>							
		
		<div id="left">
			<ul type="square">
				<li><a href="${pageContext.request.contextPath}/happy/inform"><span>通知管理</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/"><span>绩效管理</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/user/quit" id="quit"><span>退出</span></a></li><br/>
			</ul>		
		</div>	
		
		
		<div id="right">
			<button id="iv">面试通知</button><br/><br/><br/>
			<button id="train">培训通知</button><br/><br/>
			
			<div id="notice" style="display: none" align="center">
				<table border="1" cellpadding="10" cellspacing="0">
					<tr>
						<td>应聘者ID</td>
						<td>面试时间</td>
						<td>面试地点</td>
						<td>应聘职位</td>
						<td colspan="2">审批结果</td>
					</tr>
					<c:forEach	items="${sessionScope.ivs}" var="iv">
						<c:if test="${'未录用' eq iv.isHire}">
							<tr>
								<td>${iv.iApp.aUser.userId}</td>
								<td><f:formatDate value="${iv.interTime}" pattern="yyyy-MM-dd"/></td>
								<td>${iv.interAddress }</td>
								<td>${iv.iApp.aRecmt.rPosition.positionName}</td>
								<td><a href="#" id="agree" name="${iv.iApp.aUser.userId}">录用</a></td>
								<td><a href="#" id="disagree" name="${iv.iApp.aUser.userId}">拒绝</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
			</div>
			
		</div>					
	</div>
	
</body>
</html>