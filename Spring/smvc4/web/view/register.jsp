<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f0d6e6a070335aaa5e70c85e9c45b206"></script>

<head>
	<meta charset="utf-8"/>
	<title>Kakao 지도 시작하기</title>
</head>
<body>
	<div class="center_page">
	<h1>Register Page</h1>
	
	
	<div id="map" style="width:500px;height:400px;"></div>
	
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(37.5012428, 127.03958590000002),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
	</script>
</body>
