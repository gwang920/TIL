<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- taglib 디렉티브는 표현 언어(EL : Expression Language), JSTL(JSP Standard Tag Library), 커스텀 태그(Custom Tag)를 JSP 페이지 내에 사용할 때 사용된다.
 -->

<div class="center_page">
<h1>Product Add Page</h1>

<form enctype="multipart/form-data" action="productaddimpl.mc" method="POST">
NAME<input type="text" name="name"><br>
PRICE<input type="number" name="price"><br>
IMG<input type="file" name="mf"><br>
<input type="submit" value="REGISTER"><br>
</form>

</div>