<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
	<h4>Buy Message!</h4>
	${"Hello!" }
	<br>
	${sessionScope.itemCount}

<%-- 	<c:forEach var="name" items="${sessionScope.itemList}"> --%>
<%-- 		${name} --%>
<!-- 		<br> -->
<%-- 	</c:forEach> --%>
</body>
</html>