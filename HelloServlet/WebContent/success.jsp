<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>注册成功</title>
</head>
<body>
<h2>注册成功信息如下</h2>
<hr>
<table>
<tr>
<td>用户名：</td>
<td>${userInfo.userName}</td>
</tr>
<tr>
<td>密码：</td>
<td>${userInfo.passwold}</td>
</tr>
<tr>
<td>性别:</td>
<td>${userInfo.sex}</td>
</tr>
<tr>
<td>国家：</td>
<td>${userInfo.country}</td>
</tr>
<tr>
<td>爱好：</td>
<td>${userInfo.likes }</td>
</tr>
<tr>
<td>备注：</td>
<td>${userInfo.remark }</td>
</tr>
</table>
</body>
</html>