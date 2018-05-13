<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"> </script> 
<title>用户详细信息</title>
</head>
<body>
<table style="width: 1000px;">
	<tr>
		<td><h1>用户详细信息</h1></td>
	</tr>
</table>
<form:form action="addUser" modelAttribute="user" method="post">
	<table style="width: 800px;">
		<tr>
			<td>账户:</td>
			<td><form:input path="loginName"  /></td>
		</tr>
		<tr>
			<td>密码:</td>
			<td><form:input  path="passWord"  /></td>
		</tr>
		<tr>
			<td>性别:</td>
			<td>
				<form:radiobutton path="sex" value="1" />男   
                <form:radiobutton path="sex" value="0"/>女  
                 </td>
		</tr>
		<tr>
			<td>真实姓名：</td>
			<td> </td>
		</tr>
		<tr>
			<td>权限</td>
			<td>
				<form:select path="role.roleId" items="${userList}" itemLabel="roleName"  
      	  itemValue="roleId">
				</form:select>
			</td>
		</tr>
		<tr>
			<td>联系电话</td>
			<td>
				<form:input path="phone" />
			</td>				
		</tr>
		<tr>
			<td><input type="submit"  value="提交" /></td>
			<td><input type="reset"  value = "重置" /></td>
		</tr>
	</table>
	</form:form>
</body>
</html>