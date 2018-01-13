<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>录用页面</title>
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
						$("#agree").attr("disabled",true);
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
						$("#disagree").attr("disabled",true);
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
				<li><a href="${pageContext.request.contextPath}/noob/rewards"><span>绩效管理</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/user/quit" id="quit"><span>退出</span></a></li><br/>
			</ul>		
		</div>	
		
		
		<div id="right">
			<div align="center">
				<table border="1" bordercolor="gold" cellpadding="10" cellspacing="0">
					<tr>
						<td colspan="4" align="center">简历详情</td>
					</tr>
					<tr>
						<td>姓名</td>
						<td>${requestScope.resume.realName}</td>
						<td>年龄</td>
						<td>${requestScope.resume.age}</td>
					</tr>
					<tr>
						<td>性别</td>
						<td>${requestScope.resume.gender}</td>
						<td>学历</td>
						<td>${requestScope.resume.academic}</td>
					</tr>
					<tr>
						<td>手机</td>
						<td>${requestScope.resume.contact}</td>
						<td>邮箱</td>
						<td>${requestScope.resume.email}</td>
					</tr>
					<tr>
						<td>应聘职位</td>
						<td>${requestScope.resume.rDepartment.deptName}</td>
						<td>期望薪资</td>
						<td>${requestScope.resume.expectedSalary}</td>
					</tr>
					<tr>
						<td>工作经验</td>
						<td>${requestScope.resume.experience}</td>
						<td>上份工作</td>
						<td>${requestScope.resume.exjob}</td>
					</tr>
					<tr>
						<td>政治面貌</td>
						<td>${requestScope.resume.political}</td>
						<td>兴趣爱好</td>
						<td>${requestScope.resume.hobby}</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><a href="#" id="agree" name="${requestScope.userId}">录用</a></td>
						<td colspan="2" align="center"><a href="#" id="disagree" name="${requestScope.userId}">拒绝</a></td>
					</tr>
				</table>
			</div>
		</div>					
	</div>
</body>
</html>