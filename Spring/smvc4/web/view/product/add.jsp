<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- taglib ��Ƽ��� ǥ�� ���(EL : Expression Language), JSTL(JSP Standard Tag Library), Ŀ���� �±�(Custom Tag)�� JSP ������ ���� ����� �� ���ȴ�.
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