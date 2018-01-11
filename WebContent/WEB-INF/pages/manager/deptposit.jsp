<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>部门职位添加</title>
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
		$("button[name='deptId']").click(function(){
			var deptId = $(this).val();
			$.ajax({
				url:"${pageContext.request.contextPath}/user/queryPositionsByDeptId",
				type:"post",
				dataType:"json",
				data:{deptId:deptId},
				success:function(data){
					$("#position").empty();
					$.each(data,function(index,item){
						$("#position").append("<span value="+item.positionId+">"+item.positionName+"</span>");
						$("#position").append("<a href='' name='modifyPos' id='"+item.positionId+"'>修改</a>").find("a[name='modifyPos']").click(function(){
							var positionName = prompt("请输入您要修改的职位名称：");
							if(positionName == "" || positionName == null){
								alert("职位不能为空");
								return;
							}
							var positionId = $(this).attr("id");
							$.ajax({
								url:"${pageContext.request.contextPath}/happy/modifyPosition",
								type:"post",
								dataType:"text",
								data:{positionName:positionName,positionId:positionId},
								success:function(data){
									if(data == 1){
										alert("该部门已有该职位，修改失败");
									}else if(data == 2){
										alert("修改职位成功");
									}else{
										alert("修改职位失败");
									}
									window.location.reload();
								},
								error:function(x,msg,obj){
									alert(msg);
								}
							})
							return false;
							
						});
						
						
						
						
						$("#position").append("<a href='"+item.positionName+"' name='deletePos' id='"+item.positionId+"'>删除</a><br/>").find("a[name='deletePos']").click(function(){
							var positionId = $(this).attr("id");
							var positionName = $(this).attr("href");
							if(confirm("确定要删除"+positionName+"这个职位吗?")){
								$.ajax({
									url:"${pageContext.request.contextPath}/happy/deletePosition",
									type:"post",
									dataType:"text",
									data:{positionId:positionId},
									success:function(data){
										if(data == 1){
											alert("该职位有员工，删除失败");
										}else if(data == 2){
											alert("删除成功");
										}else{
											alert("删除职位失败");
										}
										window.location.reload();
									},
									error:function(x,msg,obj){
										alert(msg);
									}
								})
							}
							return false;
						});
						
						
						
						
						
					})
					
					
					$("#position").append("<button id='btn' name="+deptId+">添加职位</button>").find('#btn').click(function(){
						var positionName = prompt("请输入您要添加的职位名称：");
						if(positionName == "" || positionName == null){
							alert("职位不能为空");
							return;
						}
						var deptId = $(this).attr("name");
						$.ajax({
							url:"${pageContext.request.contextPath}/job/insertPosition",
							type:"post",
							dataType:"text",
							data:{positionName:positionName,deptId:deptId},
							success:function(data){
								if(data == 1){
									alert("该部门已有该职位，添加失败");
								}else if(data == 0){
									alert("添加职位成功");
								}
								window.location.reload();
							},
							error:function(x,msg,obj){
								alert(msg);
							}
						})
						return false;
					});
				},
				error:function(x,msg,obj){
					alert(msg);
				}
			})
			return false;
			
		})
		
		$("a[name='dept']").click(function(){
			var deptName = prompt("请输入您要添加的部门名称：");
			if(deptName == "" || deptName == null){
				alert("部门名称不能为空");
				return;
			}
			$.ajax({
				url:"${pageContext.request.contextPath}/job/insertDept",
				type:"post",
				dataType:"text",
				data:{deptName:deptName},
				success:function(data){
					if(data == 1){
						alert("部门添加成功");
					}else{
						alert("部门已存在，不能添加");
					}
					window.location.reload();
				},
				error:function(x,msg,obj){
					alert(msg);
				}
			})
			return false;
		})
		
	})
	
	
	
	$(function(){
		$("a[name='modify']").click(function(){
			var deptName = prompt("请输入您要修改的部门名称：");
			var deptId = $(this).attr("id");
			if(deptName == "" || deptName == null){
				alert("部门名称不能为空");
				return;
			}
			$.ajax({
				url:"${pageContext.request.contextPath}/happy/modifyDept",
				type:"post",
				dataType:"text",
				data:{deptName:deptName,deptId:deptId},
				success:function(data){
					if(data == 1){
						alert("部门修改成功");
					}else if(data == 3){
						alert("该部门已存在");
					}else if(data == 0){
						alert("修改失败");
					}
						
					window.location.reload();
				},
				error:function(x,msg,obj){
					alert(msg);
				}
			})
			return false;
		})
	})
	
	
	
	$(function(){
		$("a[name='delete']").click(function(){
			var deptName = $(this).attr("href");
			var deptId = $(this).attr("id");
			if(confirm("您确定要删除"+deptName+"这个部门吗?")){
				$.ajax({
					url:"${pageContext.request.contextPath}/happy/deleteDept",
					type:"post",
					dataType:"text",
					data:{deptId:deptId},
					success:function(data){
						if(data == 1){
							alert("部门还有员工，不能删除");
						}else if(data == 2){
							alert("删除成功");
						}			
						window.location.reload();
					},
					error:function(x,msg,obj){
						alert(msg);
					}
				})
			}
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
			<div id="dept" style="float: left;">
				<c:forEach items="${requestScope.depts}" var="dept">
					<button name="deptId" value="${dept.deptId}">${dept.deptName}</button>
					<a href="#" name="modify" id="${dept.deptId}">修改</a>
					<a href="${dept.deptName}" name="delete" id="${dept.deptId}">删除</a>
					<br/>			
				</c:forEach>
				<a href="" name="dept">添加部门</a>
			</div>
			<div id="position" style="float: left;">
				
			</div>
			
		</div>					
	</div>
</body>
</html>