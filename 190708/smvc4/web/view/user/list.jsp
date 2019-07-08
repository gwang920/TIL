<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="center_page">
<h1>User List Page</h1>
<!-- items¿¡´Â key°ª -->
<c:forEach var="it" items="${userlist }">
	<h3>
	<a href="userdetail.mc?id=${it.id}">${it.id}</a> 
	${it.name } </h3>
</c:forEach>




</div>