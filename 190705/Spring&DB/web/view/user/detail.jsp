<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="center_page">
<h1>User Detail Page</h1>

<h1>${userdetail.id }</h1>
<h1>${userdetail.pwd }</h1>
<h1>${userdetail.name }</h1>
<a href="userdelete.mc?id=${userdetail.id }">DELETE</a>
<a href="userupdate.mc?id=${userdetail.id }">UPDATE</a>
</div>