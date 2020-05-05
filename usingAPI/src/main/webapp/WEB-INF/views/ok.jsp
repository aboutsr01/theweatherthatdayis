<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="resources/js/jquery-1.11.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div id="aa"></div>
	<script>
		var a = '${html}';
		console.log(a);
		$('#aa').text(a);
	</script>
	
</body>
</html>