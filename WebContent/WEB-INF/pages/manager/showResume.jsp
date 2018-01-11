<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>简历详情</title>
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
		$("#inter").click(function(){
			$("#interview").show();
			var userId = ${requestScope.userId};
			$.ajax({
				url:"${pageContext.request.contextPath}/job/checkIV",
				type:"post",
				dataType:"text",
				data:{userId:userId},
				success:function(data){
					if(data == 0){
						alert("您已经给这位应聘者预约过面试了");
						$("input[name='submit']").attr("disabled",true);
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
		$("input[name='submit']").click(function(){
			var userId = ${requestScope.userId};
			var interTime = $("input[name='interTime']").val();
			var interAddress = $("input[name='interAddress']").val();
			$.ajax({
				url:"${pageContext.request.contextPath}/job/insertIV",
				type:"post",
				dataType:"text",
				data:{userId:userId,interTime:interTime,interAddress:interAddress},
				success:function(data){
					if(data == 1){
						alert("面试预约成功！");
						$("input[name='submit']").attr("disabled",true);
					}else{
						alert("预约失败！");
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
				<li><a href="${pageContext.request.contextPath}"><span>培训管理</span></a></li><br/>
				<li><a href=""><span>员工管理</span></a></li><br/>
				<li><a href=""><span>奖惩管理</span></a></li><br/>
				<li><a href=""><span>薪资管理</span></a></li><br/>
				<li><a href=""><span>工资异议</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/user/quit" id="quit"><span>退出</span></a></li><br/>
			</ul>		
		</div>	
		
		
		<div id="right">
			<table border="1" bordercolor="gold" cellpadding="10" cellspacing="0">
				<tr style="width:800px">
					<td align="center" colspan="4">简历详情</td>
				</tr>
				<tr>
					<td>姓名</td>
					<td>${resume.realName}</td>
					<td>年龄</td>
					<td>${resume.age}</td>
				</tr>
				<tr>
					<td>性别</td>
					<td>${resume.gender}</td>
					<td>学历</td>
					<td>${resume.academic}</td>
				</tr>
				<tr>
					<td>手机号码</td>
					<td>${resume.contact}</td>
					<td>邮箱</td>
					<td>${resume.email}</td>
				</tr>
				<tr>
					<td>应聘职位</td>
					<td>${resume.rDepartment.deptName},${resume.rPosition.positionName}</td>
					<td>期望薪资</td>
					<td>${resume.expectedSalary}</td>
				</tr>
				<tr>
					<td>工作经验</td>
					<td>${resume.experience}</td>
					<td>上份工作</td>
					<td>${resume.exjob}</td>
				</tr>
				<tr>
					<td>政治面貌</td>
					<td>${resume.political}</td>
					<td>兴趣爱好</td>
					<td>${resume.hobby}</td>
				</tr>
				<tr>
					<td colspan="2"><button id="inter">面试</button></td>
					<td colspan="2"><button onclick="window.location='${pageContext.request.contextPath}/job/back1'">返回</button></td>
				</tr>
				<tr style="display: none" id="interview">
					<td colspan="4" style="height: 100px">
						<form action="${pageContext.request.contextPath}/job/insertIV" method="post">
							面试时间:<input type="date" name="interTime" required="required"><br/>
							面试地点:<input type="text" name="interAddress" required="required"><br/>
								<input type='submit' value='确定' name="submit">
						</form>
					</td>
				</tr>
			</table>
		</div>					
	</div>
</body>
</html>