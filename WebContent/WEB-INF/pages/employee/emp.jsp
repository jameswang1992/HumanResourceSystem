<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>员工页面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		if(${!empty requestScope.attendance.raceStart}){
			$("#checkin").attr("disabled",true);
		}
		if(${!empty requestScope.attendance.gameOver}){
			$("#checkout").attr("disabled",true);
		}
	})
	
	
	$(function(){
		$("#quit").click(function(){
			if(confirm("您确定要退出吗?")){
				return true;
			}
			return false;
		})
	})
	
	
	$(function(){
		$("#checkin").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/cry/checkin",
				type:"post",
				dataType:"text",
				data:{},
				success:function(data){
					if(data == 1){
						alert("上班打卡成功");
						$("#checkin").attr("disabled",true);
					}else{
						alert("打卡失败");
					}
				},
				error:function(x,msg,obj){
					alert(msg);
				}
			})
			return false;
		})
		
		
		$("#checkout").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/cry/checkout",
				type:"post",
				dataType:"text",
				data:{},
				success:function(data){
					if(data == 1){
						alert("下班打卡成功");
						$("#checkout").attr("disabled",true);
					}else if(data == 2){
						alert("您还没有上班打卡，请先上班打卡");
					}else{
						alert("下班打卡失败");
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
				<button id="checkin">上班打卡</button><br/>
				<button id="checkout">下班打卡</button>
			</div>
		</div>					
	</div>
</body>
</html>