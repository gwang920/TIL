<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


<!-- hichart -->
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/drilldown.js"></script>





<style>
*{
	margin:0;
	padding:0;
}

a{
	text-decoration: none;
	color:black;
}
header,nav,section,footer{
	margin:0 auto;
}
header{
	width:900px;
	height:150px;
	
	
}
h1{

	font-size:20px;

}
nav{
	width:900px;
	height:30px;
	background:white;
}
section{
	width:900px;
	height:600px;
	background:gray;
	
}
footer{
	width:900px;
	height:50px;
	background:black;
}
.center_page{
	width:880px;
	height:580px;
	margin:0 auto;
	background:white;
}
</style>
</head>
<body>
<header>
<h3>
<c:choose>
	<c:when test="${loginuser!=null }">  <!-- 로그인이됐으면  -->
		<a href="">${loginuser.id }</a>
		<a href="logout.mc">LOGOUT</a> <!-- get방식으로 들어가기때문에 로그아웃이된다  -->
		<a href="register.mc">Register</a>
		<a href="aboutus.mc">ABOUT US</a>
	</c:when>
	<c:otherwise> <!-- 안됐으면  -->
		<a href="login.mc">LOGIN</a>
		<a href="register.mc">REGISTER</a>
		<a href="aboutus.mc">ABOUT US</a>
	</c:otherwise>
</c:choose>


</h3>

<h1>
<br>

<a href="useradd.mc">USERADD</a>   <!-- .do면 diptcher로 이동   user servlet에 요청  -->
<a href="userlist.mc">USERLIST</a>

<!-- product -->
<br>

<a href="productadd.mc">PRODUCTADD</a> 
<a href="productlist.mc">PRODUCTLIST</a> 

</h1>
</header>
<nav>
<c:choose>
	<c:when test="${navi==null}">
		<a href="main.mc">HOME </a>
	</c:when>
	<c:otherwise>
		${navi }
	</c:otherwise>
</c:choose>>
</nav>
<section>
<c:choose>
	<c:when test="${center == null }">
		<jsp:include page="center.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
		<jsp:include page="${center }.jsp"></jsp:include>
	</c:otherwise>
</c:choose>
</section>
<footer></footer>
</body>
</html>