# 레이아웃(Layout)



##### 블록 / 인라인 요소

- 블록 요소 : 화면의 한 줄을 전부 차지한다.

  ```html
  <h1> <p> <ul> <li> <table> <blockque> <pre> <div> <form> <header> <nav> 
  ```

- 인라인 요소 : 한 줄에 차례대로 배치된다. 현재 줄에서 필요한 만큼의 너비만을 차지한다.

```html
    <em> <br> <input> <span>
```

##### display 속성

- display:block   :  블록
- display:inline  : 인라인  
- display:none  : 없는 것으로 간주됨
- display:hidden  : 화면에서 감춰짐

##### position 설정

- static : 정적 위치 설정 (정상 적인 흐름에 따라 설정 됨)

- relative

- absolute

- fixed

- float 좌정렬 우정렬

```css

static
/* width height가 같아도 static 을 설정하면 차례대로 블록이 배치됨 */

#d1{
	
	background: red;
	width:100px;
	height:100px;
	
}
#d2{
	position: staic;
	background: blue;
	
	width:100px;
	height:100px;

}
#d3{
	background: green;
	width:100px;
	height:100px;
}



relative / absolute / fixed

#d2{

	
	/* 상대기준으로  */
	position: relative;  인접(상)div 기준으로 아래로 50px 왼쪽벽 기준으로 왼쪽으로 50spx 
	left:50px;
	top:50px; 
	
	
	/* body 기준으로 이동 */
 	position: absolute;
	left:50px;
	top:50px; 
	
	
	/* 특정위치고정 */
 	position: fixed;
	left:50px;
	top:20px; 
	
	
margin: 10px; /* 외부여백 */ 
}



float:left; /* 정렬  :상 하 좌 우 (블록정렬)*/
```

##### opacity

투명도

# 실습

- script에 함수를 구현해서 버튼 클릭 시 화면을 이동하지 않고, 해당 부분이 변하게 하는 방식을 구현하려 했지만, css만으로는 구현할 수 없었다,,



```html
<!DOCTYPE html>
<html>
<head>

<meta charset="EUC-KR">
<script>
function includeFunction (num){
	alert("click");
	
}
</script>
<style>

/* hover */

.hover1:hover{ box-shadow:-200px 0 0 0 rgba(0,0,0,0.5) inset;

 }

.btn { display:block; width:200px; 
height:40px; line-height:10px; 
border:1px #F29661 solid;; margin:15px auto; 
background-color:#FFBB00; text-align:center; 
cursor: pointer; color:#333; transition:all 0.9s, 
color 0.3; 
border-radius:15px;} .btn:hover{color:#fff;}






.scale>th {
	transform: scale(1);
	-webkit-transform: scale(1);
	-moz-transform: scale(1);
	-ms-transform: scale(1);
	-o-transform: scale(1);
	transition: all 0.3s ease-in-out; /* 모션 추가*/
}

.scale>th:hover {
	transform: scale(1.1);
	-webkit-transform: scale(1.1);
	-moz-transform: scale(1.1);
	-ms-transform: scale(1.1);
	-o-transform: scale(1.1);
}

.img {
	width: 325px;
	height: 280px;
	overflow: hidden
}

table {
	display: inline
}

/* Global CSS */
* {
	margin: 0;
	padding: 0;
}

a {
	text-decoration: none;
	color: black;
}

header, section, footer {
	margin: 0 auto;
}

ul, ol {
	list-style: none;
}

/* Header CSS */
header {
	position: relative;
	width: 1000px;
	height: 200px;
	background-color: #FFC19E;
	background-image:url(img/gif.gif);
}

header>#top_nav>ul>li {
	font-weight: bold;
	float: right;
	margin: 0 5px;
}

header>#main_nav>ul>li {
	position: relative;
	left: 280px;
	top: 100px;
	float: left;
	margin: 0 5px;
}

header>#hg>h1 {
	display: inline;
	position: relative;
	left: 300px;
	top: 70px;
	float: top;
}

/* Section CSS */
section {
	width: 1000px;
	height: 500px;
	background: orange;
}

#left-aside {
	float: left;
	width: 200px;
	height: 500px;
	background: orange;
}

#center-aside {
	
	float: left;
	width: 560px;
	height: 500px;
	background-color:orange;
}

#right-aside {
	float: left;
	width: 100px;
	height: 500px;
	background-color: https://search.naver.com/search.naver?sm=top_hty&fbm=0&ie=utf8&query=%EC%83%89%EC%83%81%ED%91%9C;
}

#right-aside>img {
	margin: 5px 10px;
}

/* Footer CSS */
footer {
	width: 1000px;
	height: 50px;
	background-color: #F2CB61;
}

</style>
<title>Insert title here</title>
</head>
<body>

	<header>
		<nav id="top_nav">
			<ul>
				<li><a href="">LOGIN</a></li>
				<li><a href="">REGISTER</a></li>
				<li><a href="">ABOUTUS</a></li>
				<li><a href="">MAP</a></li>
			</ul>
		</nav>
		<hgroup id="hg">
			<h1>W2C School</h1>
		</hgroup>
		<nav id="main_nav">
			<ul>
				<li><a href="">HTML5</a></li>
				<li><a href="">CSS3</a></li>
				<li><a href="">AJAX</a></li>
				<li><a href="">JQuery</a></li>
			</ul>

		</nav>
	</header>

	<section>
		<aside id="left-aside">
			<button class="btn hover1" 
			onclick="includeFunction(1);">WEBTOON</button> 
			<button class="btn hover1" 
			onclick="includeFunction(1);">click</button> 
			<button class="btn hover1" 
			onclick="includeFunction(1);">click</button> 
			<button class="btn hover1" 
			onclick="includeFunction(1);">click</button> 
			<button class="btn hover1" 
			onclick="includeFunction(1);">click</button> 
			<button class="btn hover1" 
			onclick="includeFunction(1);">click</button> 
			<button class="btn hover1" 
			onclick="includeFunction(1);">click</button> 
			<button class="btn hover1" 
			onclick="includeFunction(1);">click</button> 
			<!-- <a href=""
				onclick="includeFunction(2)">클릭1</a> -->
		</aside>
		<aside id="center-aside">
			<table id="goal">

				<thead class="img">
					<tr class="scale">
						<th><a
							href=https://comic.naver.com/webtoon/list.nhn?titleId=729036>
								<img src="img/h1.JPG">
						</a></th>


						<th><a
							href=https://comic.naver.com/webtoon/detail.nhn?titleId=727189&no=9&weekday=fri>
								<img src="img/h2.JPG">
						</a></th>
						<th><a
							href=https://comic.naver.com/webtoon/detail.nhn?titleId=726211&no=9&weekday=fri><img
								src="img/h3.JPG"> </a></th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					
				</tbody>
			</table>
			
			
			<table id="goal">

				<thead class="img">
					<tr class="scale">
						<th><a
							href=https://comic.naver.com/webtoon/list.nhn?titleId=729036>
								<img src="img/h1.JPG">
						</a></th>


						<th><a
							href=https://comic.naver.com/webtoon/detail.nhn?titleId=727189&no=9&weekday=fri>
								<img src="img/h2.JPG">
						</a></th>
						<th><a
							href=https://comic.naver.com/webtoon/detail.nhn?titleId=726211&no=9&weekday=fri><img
								src="img/h3.JPG"> </a></th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					
				</tbody>
			</table>
			
			<table id="goal">

				<thead class="img">
					<tr class="scale">
						<th><a
							href=https://comic.naver.com/webtoon/list.nhn?titleId=729036>
								<img src="img/h1.JPG">
						</a></th>


						<th><a
							href=https://comic.naver.com/webtoon/detail.nhn?titleId=727189&no=9&weekday=fri>
								<img src="img/h2.JPG">
						</a></th>
						<th><a
							href=https://comic.naver.com/webtoon/detail.nhn?titleId=726211&no=9&weekday=fri><img
								src="img/h3.JPG"> </a></th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					
				</tbody>
			</table>


		</aside>
		<aside id="right-aside">
			<img src="https://via.placeholder.com/80x150"> <img
				src="https://via.placeholder.com/80x150"> <img
				src="https://via.placeholder.com/80x150">
		</aside>
	</section>

	<footer> </footer>
</body>
</html>
```







```
참고사이트
https://bootstrapmade.com/

https://placeholder.com/
```

