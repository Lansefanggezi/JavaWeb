<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>ע��ɹ�</title>
</head>
<body>
<h2>ע��ɹ���Ϣ����</h2>
<hr>
<table>
<tr>
<td>�û�����</td>
<td>${userInfo.userName}</td>
</tr>
<tr>
<td>���룺</td>
<td>${userInfo.passwold}</td>
</tr>
<tr>
<td>�Ա�:</td>
<td>${userInfo.sex}</td>
</tr>
<tr>
<td>���ң�</td>
<td>${userInfo.country}</td>
</tr>
<tr>
<td>���ã�</td>
<td>${userInfo.likes }</td>
</tr>
<tr>
<td>��ע��</td>
<td>${userInfo.remark }</td>
</tr>
</table>
</body>
</html>