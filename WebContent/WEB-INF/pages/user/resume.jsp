<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>简历页面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
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
		
		<h1 align="center">欢迎来到欢满堂招聘会</h1>							
		
		<div id="left">
			<ul>
				<li><a href=""><span>反馈</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/user/readResume"><span>查看简历</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/user/modify"><span>修改密码</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/job/recruitInfo"><span>招聘信息</span></a></li><br/>
				<li><a href=""><span>退出</span></a></li><br/>
			</ul>		
		</div>	
		
		
		<div id="right">
			<form action="${pageContext.request.contextPath}/user/insertResume" method="post">
				<table border="1px" cellpadding="10px" cellspacing="0">
					<tr>
						<td colspan="4" align="center">简历</td>
					</tr>
					
					<tr>
						<td>真实姓名</td>
						<td><input type="text" name="realName" placeholder="请输入真实姓名" value="${requestScope.oldResume.realName}" required="required">
						<td>性别</td>
						<td><input type="radio" name="gender" value="男" <c:if test="${'男' eq requestScope.oldResume.gender}">checked="checked"</c:if>>男
							<input type="radio" name="gender" value="女" <c:if test="${'女' eq requestScope.oldResume.gender}">checked="checked"</c:if>>女</td>
					</tr>
					
					<tr>
						<td>年龄</td>
						<td><input type="text" name="age" placeholder="请输入年龄" value="${requestScope.oldResume.age}" required="required"></td>
						<td>学历</td>
						<td>
							<select name="academic">
								<option value="无"  <c:if test="${'无' eq requestScope.oldResume.academic}">selected</c:if>>学历</option>
								<option value="高中" <c:if test="${'高中' eq requestScope.oldResume.academic}">selected</c:if>>高中</option>
								<option value="专科" <c:if test="${'专科' eq requestScope.oldResume.academic}">selected</c:if>>专科</option>
								<option value="本科" <c:if test="${'本科' eq requestScope.oldResume.academic}">selected</c:if>>本科</option>						
								<option value="硕士" <c:if test="${'硕士' eq requestScope.oldResume.academic}">selected</c:if>>硕士</option>
								<option value="博士" <c:if test="${'博士' eq requestScope.oldResume.academic}">selected</c:if>>博士</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td>联系方式</td>
						<td><input type="tel" name="contact" placeholder="请输入联系方式,一共11位" required pattern="^[0-9]{11}" value="${requestScope.oldResume.contact}" required="required"></td>
						<td>e-mail</td>
						<td><input type="email" name="email" placeholder="请输入邮箱" value="${requestScope.oldResume.email}" required="required">
						</td>
					</tr>
					
					<tr>
						<td>应聘职位</td>
						<td>
							<select name="deptId">
								<option value="0">部门</option>
								<c:forEach items="${requestScope.depts}" var="dept">
									<option value="${dept.deptId}" <c:if test="${dept.deptName eq requestScope.oldResume.rDepartment.deptName}">selected</c:if>>${dept.deptName}</option>
								</c:forEach>
							</select>
							<select name="positionId">
								<option value="无">职位</option>
								<c:if test="${!empty requestScope.oldResume }">
									<c:forEach items="${requestScope.positions}" var="position">
										<option value="${position.positionId}" <c:if test="${position.positionName eq requestScope.oldResume.rPosition.positionName}">selected</c:if>>${position.positionName}</option>
									</c:forEach>
								</c:if>
							</select>
						</td>
						<td>政治面貌</td>
						<td>
							<select name="political">
								<option value="普通群众" <c:if test="${'普通群众' eq requestScope.oldResume.political}">selected</c:if>>普通群众</option>
								<option value="妇联主席" <c:if test="${'妇联主席' eq requestScope.oldResume.political}">selected</c:if>>妇联主席</option>
								<option value="国家总理" <c:if test="${'国家总理' eq requestScope.oldResume.political}">selected</c:if>>国家总理</option>
								<option value="小学班长" <c:if test="${'小学班长' eq requestScope.oldResume.political}">selected</c:if>>小学班长</option>
								<option value="社团团长" <c:if test="${'社团团长' eq requestScope.oldResume.political}">selected</c:if>>社团团长</option>
								<option value="国家主席" <c:if test="${'国家主席' eq requestScope.oldResume.political}">selected</c:if>>国家主席</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td>上份工作</td>
						<td><input type="text" name="exjob" placeholder="请输入工作名称" value="${requestScope.oldResume.exjob}"></td>
						<td>工作经验</td>
						<td><input type="number" name="experience" placeholder="请输入工作经验多少年" value="${requestScope.oldResume.experience}"></td>
					</tr>
					
					<tr>
						<td>期望薪资</td>
						<td>
							<select name="expectedSalary">
								<option value="3000-4000" <c:if test="${'3000-4000' eq requestScope.oldResume.expectedSalary}">selected</c:if>>3000-4000</option>
								<option value="4000-5000" <c:if test="${'4000-5000' eq requestScope.oldResume.expectedSalary}">selected</c:if>>4000-5000</option>
								<option value="5000-6000" <c:if test="${'5000-6000' eq requestScope.oldResume.expectedSalary}">selected</c:if>>5000-6000</option>
								<option value="6000-7000" <c:if test="${'6000-7000' eq requestScope.oldResume.expectedSalary}">selected</c:if>>6000-7000</option>
								<option value="7000-8000" <c:if test="${'7000-8000' eq requestScope.oldResume.expectedSalary}">selected</c:if>>7000-8000</option>
								<option value="8000-10000" <c:if test="${'8000-10000' eq requestScope.oldResume.expectedSalary}">selected</c:if>>8000-10000</option>
							</select>
						</td>
						<td>兴趣爱好</td>
						<td><input type="text" name="hobby" placeholder="请输入兴趣爱好" value="${requestScope.oldResume.hobby}"></td>
					</tr>
					
					<tr>
						<td colspan="2"><input type="submit" value="保存"></td>
						<td colspan="2"><button onclick="window.location='${pageContext.request.contextPath}/user/back'" >返回</button></td>
					</tr>
				</table>
			</form>
		</div>					
	</div>
</body>
</html>