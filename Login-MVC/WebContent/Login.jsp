<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登陆</title>
	<script type="text/javascript">
	function check(){
		var userName = document.LoginForm.userName.value;
		var userPwd = document.LoginForm.passwold.value;

		if (userName == "") {
			alert("用户名不能为空");
			return false;
		}

		if (userPwd == "") {
			alert("请输入密码");
			return false;
		}
		return true;
	}
	</script>
</head>
<body background="#ffffff">
	<form action="LoginServlet" method="post" name="LoginForm">
		<table width="757" height="108" align="center">
		<col width="300">
		<col width="">
			<tr>
				<td colspan="2" align="center">
					<h2>用户登陆</h2>
				</td>
			</tr>
			<tr>
				<td align="right">
					用户名：
				</td>
				<td align="left">
					<input type="text" name="userName" width="200">
				</td>
			</tr>
			<tr>
				<td align="right">
					密码：
				</td>
				<td align="left">
					<input type="password" name="passwold" width="200">
				</td>
			</tr>
			<tr>
				<td align="center">
				</td>
				<td align="left">
					<input type="submit" name="submit" value="提交" onclick="reurn check()">
					<input type="reset" name="submit" value="重置">
				</td>
			</tr>
		</table>
		<jsp:useBean id="loginUser" class="cn.com.systop.javabean.UserBean" scope="request"></jsp:useBean>
		<%
		if(loginUser.getError() != null)
		{
			out.print("<script type=\"text/javascript\">alert(\"用户名或者密码错误！\");</script>");
		}
		%>
	</form>
</body>
</html>