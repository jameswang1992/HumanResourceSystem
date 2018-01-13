<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>培训管理</title>
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
		$("#tt").click(function(){
			$("#training").show();
		})
	})
	
	
	$(function(){
		$("#cancel").click(function(){
			window.location.href="${pageContext.request.contextPath}/job/cancel";
		})
	})
	

	
	
	$(function(){
		$("#submit").click(function(){
			var trainName = $("input[name='trainName']").val();
			var trainTime = $("input[name='trainTime']").val();
			var deptId = $("select[name='deptId']").val();
			if(trainName == null || trainName == ""){
				alert("培训名称不能为空");
				return;
			}
			$.ajax({
				url:"${pageContext.request.contextPath}/job/insertTraining",
				type:"post",
				dataType:"text",
				data:{trainName:trainName,trainTime:trainTime,deptId:deptId},
				success:function(data){
					if(data == 1){
						alert("添加培训成功");
						window.location.reload();
					}else{
						alert("添加失败");
					}
				},
				error:function(x,msg,obj){
					alert(msg);
				}
			})
		})
	})
	
	
	
	
	
	$(function(){
		$(".training").click(function(){
			var trainName = $(this).text();
			var trainTime = $(this).attr("id");
			var deptId = $(this).attr("name");
			var trainId = $(this).attr("title");
			$.ajax({
				url:"${pageContext.request.contextPath}/job/modifyTraining",
				type:"post",
				dataType:"json",
				data:{trainName:trainName,trainTime:trainTime,deptId:deptId},
				success:function(data){
					alert(data[2]);
					$("#training").empty();
					$("#training").append("<h4>培训-详情</h4>");
					$("#training").append("<form action='' method='post'>培训名称:<input type='text' name='trainName' value='"+data[0]+"'><br/>培训时间:<input type='text' name='trainTime' value='"+data[1]+"'/><br/>");	
					$("#training").append("培训部门:<select name='deptId'><c:forEach items='${sessionScope.deptss}' var='dept'><option value='${dept.deptId}'>${dept.deptName}</option></c:forEach></select><br/>");
					$("#training").append("<input type='submit' value='修改' id='submit1'>     ").find("#submit1").click(function(){
						var trainName = $("input[name='trainName']").val();
						var trainTime = $("input[name='trainTime']").val();
						var deptId = $("select[name='deptId']").val();
						if(trainName == null || trainName == ""){
							alert("培训名称不能为空");
							return;
						}else if(trainTime == null || trainTime == ""){
							alert("培训时间不能为空");
							return;
						}
						$.ajax({
							url:"${pageContext.request.contextPath}/job/updateTraining",
							type:"post",
							dataType:"text",
							data:{trainName:trainName,trainTime:trainTime,deptId:deptId,trainId:trainId},
							success:function(data){
								if(data == 1){
									alert("修改培训成功");
									window.location.reload();
								}else{
									alert("修改失败");
								}
							},
							error:function(x,msg,obj){
								alert(msg);
							}
						})
					});
					$("#training").append("<input type='button' value='取消' id='cancel1'></form>").find("#cancel1").click(function(){
						window.location.href="${pageContext.request.contextPath}/job/cancel";
					});
					$("#training").show();
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
		<%-- <f:formatDate value='"+trainTime+"' pattern='yyyy/MM/dd'/> --%>
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
			<div>
				<h3>培训部门技能</h3>
				
				<div id="course">
					<c:forEach items="${sessionScope.trains}" var="train">
						<a href="#" id="${train.trainTime}" name="${train.tDept.deptId}" title="${train.trainId}" class="training">${train.trainName}</a><br/>
					</c:forEach>
				</div>
				
				<button id="tt">添加培训内容</button>
				
			</div>
				
			
			<div id="training" style="display: none;position:absolute;right:325px;">
				<h4>培训-增改</h4>
				<form action="" method="post">						
					培训名称:<input type="text" name="trainName"><br/>		
					培训时间:<input type="date" name="trainTime"><br/>			
					培训部门:<select name="deptId">
							<c:forEach items="${sessionScope.deptss}" var="dept">
								<option value="${dept.deptId}">${dept.deptName}</option>
							</c:forEach>
						</select><br/>
						<input type="submit" name="smt" value="添加" id="submit">
						<input type="button" name="btn" value="取消" id="cancel">		
				</form>
			</div>
					
					
		</div>					
	</div>
</body>
</html>