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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("a[name='sendResume']").click(function(){
			if(confirm("确定要投递这个招聘岗位吗?")){
				var recruitId = $(this).attr("value");
				$.ajax({
					url:"${pageContext.request.contextPath}/job/insertApp",
					type:"post",
					dataType:"text",
					data:{recruitId:recruitId},
					success:function(data){
						alert(data);
						if(data == 3){
							alert("您还没有填写简历，请去填写");
						}else if(data == 2){
							alert("对不起，您投递的岗位与您的简历应聘岗位不符合");
						}else if(data == 1){
							alert("投递简历成功");
						}else{
							alert("很遗憾，投递失败");
						}
					},
					error:function(x,msg,obj){
						alert(msg);
					}
				})
				return false;
			}
			
		})
			
	})
	
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
			<c:forEach items="${requestScope.recmts}" var="recmt">
				<div id="recmt">
					<p>我们需要这样的一个小伙伴</p>
					<p>任职部门：${recmt.rDepartment.deptName}</p>
					<p>任职职位：${recmt.rPosition.positionName}</p>
					<p>任职要求：${recmt.requirement}</p>
					<p>薪资待遇：${recmt.treatment}</p>
					<p><a href="#" name="sendResume" value="${recmt.recruitId}">投递简历</a></p>
				</div>
			</c:forEach>
		</div>					
	</div>
</body>
</html>