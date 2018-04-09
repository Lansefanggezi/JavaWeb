<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>登陆页面</title>
</head>
<body>

<form action="Spring-MVC/pringWelcome" method="post">
<table width="757" height="108" align="center">
		<col width="300">
		<col width="">
			<tr>
				<td colspan="2">
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
					<input type="passwold" name="passwold" width="200">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input type="submit" name="submit" value="登陆">
				</td>
				<td align="center">
					<input type="reset" name="submit" value="重置">
				</td>
			</tr>
		</table>
</form>
</body>
</html>