# I. CSS(Cascading Style Sheet)

##### 다수의 페이지의 디자인을 일괄적으로 수정하고 획일한 디자인으로 유지하기 위한 Sheet



![1560422690548](C:\Users\student\AppData\Roaming\Typora\typora-user-images\1560422690548.png)





##### css 작성법

```html
선택자 {

	속성:속성값;
}


ex) a{
	text-decoration: none;
	color:black;
}



* HTML 작성법
<태그 속성="속성값">내용</태그>

ex) <h3>Header</h3>
	<h3 class="a">Header</h3>
	
```





- 



# II. CSS 기능

#### :nth-child(), :nth-last-child()

- 특정 순서에 있는 요소를 선택할 때 사용
- :nth-child()  앞에서 부터  :nth-last-child()  뒤에서 부터

```html
x:nth-child(an+b)
- a,b는 정수 / 0과 음수도 가능

ex) table 1열을 가운데 정렬, 녹색 배경

td:nth-child(4n+1){
		text-align:center;
		background:green;
	}

```

### ID / CLASS

##### 	- ID : 스타일을 한 가지만 지정할 때

##### 	- CLASS : 그룹으로 묶어 스타일을 지정할 때

##### 		

##### 		1) ID(아이디) 선택자

​     	   -  #special { color : red; }

```html


ex)

TEXT <input id="t" type="text" name="tx"><br>


#id{
	color:red;
}
```



##### 		2) CLASS(클래스) 선택자

​			- .target { color : red; };

```css
ex)	

tr.row:hover{
	background-color:#B7F0B1;
}

```
```html
<tr class="row">
				<td>1</td>
				<td>algorithm</td>
				<td>2019-06-13</td>
				<td>seo</td>
			</tr>
```



### 호출( HTML )

```html
<table class="t1">
		<thead>
			<tr> 
				<th>NO</th>
				<th>CONTENT</th>
				<th>DATE</th>
				<th>AUTHOR</th>
			</tr>

		</thead>
</table>
```

```css
th의 속성을 바꾸자.

호출 
-------------------------
경로를 따라가자.
.t1 > thead > tr > th{
		background:black;
		color:white;
	}
```



#### body 전체 값 설정

```HTML
* {
	설정할 값
}

ex) 화면의 바깥쪽 여백(margin) =0 안쪽 여백(padding)=0 으로 설정

* {
	margin: 0;
	padding: 0;
}
```

#### table row 설정

```html
<style type="text/css"> 
<!-- 
    tr.row:hover { background-color: lightyellow; } 
--> 
</style> 

<table> 
<tr class="row"> 
    <td>xxxxxxxxxxxxxxxx</td> 
</tr> 
</table>
```



# III. CSS / HTML 연동

##### html의 style 부분을 css 파일로 양도한다

``` 
- html 의 <style> ~ </style>을 옮긴다 css로
- 연동  <link type = "" rel="" href=">

ex)  <link type = "text/css" rel="stylesheet" href="c1.css">
```

```css
- html
<!DOCTYPE html>
<html>
<head>
---------------------------    
    <style>
    
    </style>
 --------------------------   
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>

- css

@charset "EUC-KR";
----------------------


----------------------


예제)

1)

- c1.html

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<!-- css 연동  -->
<link type = "text/css" rel="stylesheet" href="c1.css">
<style>
	h1{
	color:red;
	background: black;
	}
	#h1{
	color:pink;
	background: blue;
	}
	#h1{
	color:pink;
	background: blue;
	} 
	.cc{
	color:red;
	background: gray;
	}
	/* attribute 가져오기  */
	input[name="id"] {
		background: yellow;
	}
</style>
<title>Insert title here</title>
</head>
<body>
<!-- HTML Comments -->
ID<input type ="text" name="id"><br>
PWD<input type ="password" name="pwd"><br>

<h1>Header1</h1>
<h1 id="h1">Header1</h1>
<h1 class="cc">Header1</h1>
<h2 class="cc">Header2</h2>
<h2>Header2</h2>
<p class="cc">Paragraph</p>
<p>Paragraph</p>
</body>
</html>


2)

-c1.html

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<!-- css 연동  -->
<link type = "text/css" rel="stylesheet" href="c1.css">
<style>
	
</style>
<title>Insert title here</title>
</head>
<body>
<!-- HTML Comments -->
ID<input type ="text" name="id"><br>
PWD<input type ="password" name="pwd"><br>

<h1>Header1</h1>
<h1 id="h1">Header1</h1>
<h1 class="cc">Header1</h1>
<h2 class="cc">Header2</h2>
<h2>Header2</h2>
<p class="cc">Paragraph</p>
<p>Paragraph</p>
</body>
</html>


- c1.css

@charset "EUC-KR";


/* c1.css ==> css만을 위한 파일 html 의 <style> ~ </style>을 옮긴다 */


/* CSS Comments */
	h1{
	color:red;
	background: black;
	}
	#h1{
	color:pink;
	background: blue;
	}
	#h1{
	color:pink;
	background: blue;
	} 
	.cc{
	color:red;
	background: gray;
	}
	/* attribute 가져오기  */
	input[name="id"] {
		background: yellow;
	}
```





## 실습

- page 제작
- 기능 : 전체 column에 마우스 커서를 올리면 background색상 변경

![1560421761333](C:\Users\student\AppData\Roaming\Typora\typora-user-images\1560421761333.png)

```HTML

- index.html

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<link type="text/css" rel="stylesheet" href="but.css">
<link type = "text/css" rel="stylesheet" href="frame.css">
<title>Insert title here</title>
</head>
<body >



	<ul>
		<li><a href="">H&nbsp;O&nbsp;M&nbsp;E</a></li>
		<li><a href="">B&nbsp;L&nbsp;O&nbsp;G</a></li>
		<li><a href="">A&nbsp;B&nbsp;O&nbsp;U&nbsp;T</a></li>
		<li><a href="">C&nbsp;O&nbsp;N&nbsp;T&nbsp;A&nbsp;C&nbsp;T</a></li>
	</ul>
	<h1>M&nbsp;E&nbsp;N&nbsp;U</h1>
	<table class="t1">
		<thead>
			<tr> 
				<th>NO</th>
				<th>CONTENT</th>
				<th>DATE</th>
				<th>AUTHOR</th>
			</tr>

		</thead>

		<tbody>
			<tr class="row">
				<td>1</td>
				<td>algorithm</td>
				<td>2019-06-13</td>
				<td>seo</td>
			</tr>
			<tr class="row">
				<td>2</td>
				<td>java</td>
				<td>2019-06-13</td>
				<td>seo</td>
			</tr>
			<tr class="row">
				<td>3</td>
				<td>c++</td>
				<td>2019-06-13</td>
				<td>seo</td>
			</tr>
			<tr class="row">
				<td>4</td>
				<td>html</td>
				<td>2019-06-13</td>
				<td>seo</td>
			</tr>
			<tr class="row">
				<td>5</td>
				<td>iot</td>
				<td>2019-06-13</td>
				<td>seo</td>
			</tr>
			<tr class="row">
				<td>6</td>
				<td>embbeded</td>
				<td>2019-06-13</td>
				<td>seo</td>
			</tr>
		</tbody>
	</table>

	<div class="but">
		<a href="">Click</a>
		<a href="">Click</a>
	</div>


</body>
</html>

```



```css
- frame.css

@charset "EUC-KR";


* {
	margin: 0;
	padding: 0;
}

a {
	text-decoration: none;
	color: black;
}

body {
	
	/* background-image: url('img/bg.jpg'); */
	background-size: 700px 300px;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: right-top;
}

	td:nth-child(4n+1){
		text-align:center;
		background:green;
	}
	
	td:nth-child(4n+3){
		text-align:center;
		background:green;
	}
	
	td:nth-child(4n+4){
		text-align:right;
		
	}
	h1{
		margin:10px auto;
		text-align:center;
	}


	tr.row:hover{
		background-color:#B7F0B1;
	}

*{
		margin:0;
		padding:0;
	}
	a{
		line-height:40px;
		text-decoration: :none;
		color:black;
	}
	ol,ul{
		list-style: none;
	}
	ul{
	
		margin:20px auto;
		width:600px;
		height:40px;
		padding:10px 0 10px 0;
		border-top:3px solid black;
		border-bottom:3px solid black;
	}
	li{
		display:inline;
		margin:10px 30px;
	}
	
	li > a {
	
		font-weight: bold;
	
	}


.t1{
		margin:10px auto;
		border:2px solid black;
		width:350px;
		border-collapse: collapse;
	}
	.t1 > thead > tr > th{
		background:black;
		color:white;
	}

- but.css

@charset "EUC-KR";
.but {
	text-align:center;
}
.but > a {
	
	font-family: 'Monda', sans-serif;
	display:block;  /* block안의 block으로 설정하기 위함 */
	font-size: 2em;
	margin:10px solid red;
	width:100px;
	
/* 	box-shadow:5px 5px 5px black; */
	
	border-radius:30px 30px 30px 30px; 
	
	background:orange;
	
	display:inline;
	text-align:center;
	line-height:100px;
	
	height:auto;    /* 글자의 영역크기  */
	margin:auto auto;  
}
```





##### 참고자료

```
` 폰트

[https://fonts.google.com](https://fonts.google.com/)

standard - html

@import - css



` 네이버 색상표 

name : #CC3D3D

ex) color:#CC3D3D;


- 출처 : https://mmblue.tistory.com/entry/%EC%A0%95%EC%9D%98-CSS%EC%9D%98-%EA%B0%9C%EB%85%90-%EB%B0%8F-%EC%86%8C%EA%B0%9C


```



