<%@ page import="java.util.Vector" %>
<%@ page import="cn.com.systop.listener.*" %>
<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>Insert title here</title>
</head>
<body>
	<%
	if(session.getAttribute("userName") == null)
	{
		response.sendRedirect("Login.jsp");
	}
	%>
</body>
</html>