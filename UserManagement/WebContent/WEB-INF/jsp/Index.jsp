<%@ page language="java" contentType="text/html;UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"> </script> 
<title>登陆页面</title>
</head>
<body>
<h1>歡迎登陸</h1>
<span><a href="UserController/register">没有账户？点击注册</a></span>
	<form action="UserController/doLogin" method="get" >
		<table align="center" style="margin-top: 150px;">
			<tr>
				<td>用戶名：</td>
				<td><input type="text" id="name" name="loginName"></td>
			</tr>
			<tr>
				<td>密碼：</td>
				<td><input type="password" id="password" name="passWord"></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交" onclick="return check()"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>