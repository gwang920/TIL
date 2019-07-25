<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('input[type="button"]').click(function(){
		var c = confirm('삭제하시겠습니까?');
		if(c == true){
			$('#d_form').attr('method','POST');
			$('#d_form').attr('action','user.do?cmd=userdeleteimpl');
			$('#d_form').submit();
		}
	});
});
</script>
</head>
<body>
<h1>User Delete Page</h1>
<form id="d_form">
ID<input type="text" name="id"><br>
<input type="button" value="DELETE"><br>
</form>
</body>
</html>