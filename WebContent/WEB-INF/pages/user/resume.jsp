<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>简历页面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tourist.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("select[name='deptId']").change(function(){
			var deptId = $(this).val();
			alert(deptId);
			$.ajax({
				url:"${pageContext.request.contextPath}/user/queryPositionsByDeptId",
				type:"post",
				dataType:"json",
				data:{deptId:deptId},
				success:function(data){
									
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
				<li><a href=""><span>查看简历</span></a></li><br/>
				<li><a href="${pageContext.request.contextPath}/modifyPW.jsp"><span>修改密码</span></a></li><br/>
				<li><a href=""><span>公司人事</span></a></li><br/>
				<li><a href=""><span>退出</span></a></li><br/>
			</ul>		
		</div>	
		
		
		<div id="right">
			<form action="#" method="post">
				<table border="1px" cellpadding="10px" cellspacing="0">
					<tr>
						<td colspan="4">简历</td>
					</tr>
					
					<tr>
						<td>真实姓名</td>
						<td><input type="text" name="realName" placeholder="请输入真实姓名">
						<td>性别</td>
						<td><input type="radio" name="gender" value="男">男
							<input type="radio" name="gender" value="女">女</td>
					</tr>
					
					<tr>
						<td>年龄</td>
						<td><input type="text" name="age" placeholder="请输入年龄"></td>
						<td>学历</td>
						<td>
							<select name="academic">
								<option value="无">学历</option>
								<option value="高中">高中</option>
								<option value="专科">专科</option>
								<option value="本科">本科</option>
								<option value="硕士">硕士</option>
								<option value="博士">博士</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td>联系方式</td>
						<td><input type="tel" name="contact" placeholder="请输入联系方式,一共11位" required pattern="^(0|86|17951)?(13[0-9]|15[012356789]|17[0678]|18[0-9]|14[57])[0-9]{11}"></td>
						<td>e-mail</td>
						<td><input type="email" name="email" placeholder="请输入邮箱">
						</td>
					</tr>
					
					<tr>
						<td>应聘职位</td>
						<td>
							<select name="deptId">
								<option value="0">部门</option>
								<c:forEach items="${requestScope.depts}" var="dept">
									<option value="${dept.deptId}">${dept.deptName}</option>
								</c:forEach>
							</select>
							<select name="positionId">
								<option value="无">职位</option>
							</select>
						</td>
						<td>政治面貌</td>
						<td>
							<select name="political">
								<option value="普通群众">普通群众</option>
								<option value="妇联主席">妇联主席</option>
								<option value="国家总理">国家总理</option>
								<option value="小学班长">小学班长</option>
								<option value="社团团长">社团团长</option>
								<option value="国家主席">国家主席</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td>上份工作</td>
						<td><input type="text" name="exjob" placeholder="请输入工作名称"></td>
						<td>工作经验</td>
						<td><input type="number" name="experience" placeholder="请输入工作经验多少年"></td>
					</tr>
					
					<tr>
						<td>期望薪资</td>
						<td>
							<select name="expectedSalary">
								<option value="3000-4000">3000-4000</option>
								<option value="4000-5000">4000-5000</option>
								<option value="5000-6000">5000-6000</option>
								<option value="6000-7000">6000-7000</option>
								<option value="7000-8000">7000-8000</option>
								<option value="8000-10000">8000-10000</option>
							</select>
						</td>
						<td>兴趣爱好</td>
						<td><input type="text" name="hobby" placeholder="请输入兴趣爱好"></td>
					</tr>
					
					<tr>
						<td colspan="2"><input type="submit" value="保存"></td>
						<td colspan="2"><input type="submit" value="返回"></td>
					</tr>
				</table>
			</form>
		</div>					
	</div>
</body>
</html>