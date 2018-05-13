<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"> </script> 
<title>用户管理</title>
</head>
<body>
<h1>用户管理</h1>
<form:form action="/?"  modelAttribute="displayForm"  method="post"  name="manager">
	<table style="width: 1000px;">
	<tr>
		<td>用戶：${displayForm.userMessage.loginName} </td>
		<td>職位：${displayForm.userMessage.role.roleName} </td>
	</tr>
		<c:if test="${displayForm.userMessage.role.roleId == 1}">
			<tr>
				<td><input type="button" value="新增" onclick="addUser()"></td>
				<td><input type="button" value="导出"  onblur="toExecl()"></td>
				<td><input type="button" value="导入"> <input type="file" value="选择文件"></td>
				<form:hidden path="row"/>
			</tr>
		</c:if>
	</table>
	<table style="border: 1px; width: 1000px;">
	<tr class="">
		<td>用户ID</td>
		<td>登陆名</td>
		<c:if test="${displayForm.userMessage.role.roleId == 1}">
			<td>登陆密码</td>
		</c:if>
		<td>真实姓名</td>
		<td>性别</td>
		<td>联系电话</td>
		<td>職位</td>
		<c:if test="${displayForm.userMessage.role.roleId == 1}">
			<td>操作</td>
		</c:if>
	</tr>
<c:forEach items="${displayForm.userList}" var="user">
	<tr>
		<td>${user.userID}</td>
		<td>${user.loginName}</td>
		<c:if test="${displayForm.userMessage.role.roleId == 1}">
			<td>${user.passWord}</td>
		</c:if>
		<td>${user.realName}</td>
		<td>
			<c:if test="${user.sex == '1'}">男</c:if>
			<c:if test="${user.sex == '0'}">女</c:if>
		</td>
		<td>${user.phone}</td>
		<td>${user.role.roleName}</td>
		<c:if test="${displayForm.userMessage.role.roleId == 1}">
		<td>
<!-- 		<a href="UserController/register" onclick="return confirm("确认删除么")">删除</a></td> -->
		<td><input type="button" value="删除" onclick="deleteUser(this)"></td>
		</c:if>
	</tr>
</c:forEach>
</table>
</form:form>
</body>
</html>