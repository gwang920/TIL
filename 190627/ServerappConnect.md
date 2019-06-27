

![1561599054995](C:\Users\student\AppData\Roaming\Typora\typora-user-images\1561599054995.png)

관제시스템



자동차에서 올라온 데이터 수집

http는 신호를 보낼 수 없다





jstl, cos,standard : jsp에서 자바코딩을 안쓰게 하기 위한 파일

ojdbc6_g : db연동하기위해







list 명령이면   req -> user -> DB 

req -> product



servlet java

```java
package com.sds;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({ "/HelloServlet", "/hello" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//service 는 post get 전부 가능  회원가입은 post방식으로
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//request로 요청을 받고 , 값을 끄집어내는 역할
			
			System.out.println("doGet Start...");
			String id= request.getParameter("id");  // form으로 들어왔을때는 getParameter로만 꺼낼 수 있다
			String pwd= request.getParameter("pwd");
			System.out.println(id+" "+pwd);  
			
			
			// HTML5
			//response.sendRedirect("ok.jsp?id="+id);  // 현재 들어온 servlet에서 다른 쪽으로 이동  jsp에서 A를 자동으로 해준다
			//server program은 web에 위치          프로그램이름?data
			ArrayList<Integer> list=
					new ArrayList<Integer>();
			list.add(23);list.add(3);list.add(8);
			
			ArrayList<Item> list2= new ArrayList<Item>();  // item.java의 class 이름 item을 가져온다 ?
			
			list2.add(new Item("k1",1000));
			list2.add(new Item("k2",2000));
			list2.add(new Item("k3",3000));
			list2.add(new Item("k4",4000));
			list2.add(new Item("k5",5000));
			list2.add(new Item("k6",6000));
			
			request.setAttribute("list1", list);
			
			request.setAttribute("id", id);    // (key value) jsp로 넘겨주기 위해
			request.setAttribute("cnt", 7);
			RequestDispatcher rd= request.getRequestDispatcher("ok.jsp");  // 객체 생성
			rd.forward(request,response);
			
			// A
			
//			response.setContentType("text/html;charset=UTF-8");  // 나갈때
//			response.setCharacterEncoding("UTF-8");   // response로 나가는 type 설정
//			PrintWriter out = response.getWriter();
//			out.println("<H1>LOGIN OK</H1>");
//			out.println("<H1>"+id+"님 환영합니다.</H1>"); 
//			out.close();
	}

}

```



item java

```java
package com.sds;

public class Item {
	String name;
	int price;
	public Item() {
	}
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + "]";
	}
	
}

```



```
html
```

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<style></style>
<script>

</script>

</head>
<body>
<h1>Hello Page</h1>
<!-- action에는 "서버프로그램" , 방식은 GET  -->
<form action="hello" method="POST">  
ID<input type="text" name="id"><br>
PWD<input type="password" name="pwd"><br>
<input type="submit" name="LOGIN"><br>
</form>
</body>
</html>
```



```
jsp
```

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> <%-- sendRedirect로 실행이되면 servlet으로 바뀌어 실행되고, 결과치가 HTML로 나온다 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>LOGIN OK</h1>
<%-- EL --%>
<h3>${id } ${cnt }님 환영 합니다.</h3>   <%-- servlet의 request가 값을 가지고 있다면 ${ }로 가져올 수 있다  expression language --%>
<c:if test="${cnt>5 }"><%--jstl--%>

<%-- JSTL CHOOSE WHEN THEN --%>
<c:choose>
	<c:when test="${cnt>=9}"><h4>1등급</h4></c:when>
	<c:when test="${cnt>=8 && cnt<9}"><h4>2등급</h4></c:when>
	<c:when test="${cnt>=7 && cnt<8}"><h4>3등급</h4></c:when>
	<c:otherwise><h4>F등급</h4></c:otherwise>
</c:choose>
<%-- FOR 2 --%>
<table border="1">
<tbody>
	<c:forEach var="it" items="${list2 }">
	<tr>
	<td>${it.name }</td><td>${it.price }</td>
	</tr>
	</c:forEach>
</tbody>
</table>


<%-- FOR 1 --%>
<c:forEach var="num" items="${list1 }"> <%-- list1을 num에 넣겠다  --%>

<h5>${num }</h5>
</c:forEach>
<h3>High</h3>

</c:if>
</body>
</html>
```

