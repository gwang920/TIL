# Visible을 활용한 pos 시스템 제작

page1



![sub](C:\Users\student\Desktop\sub.JPG)



<!DOCTYPE html>
<html>






page2

![pay](C:\Users\student\Desktop\pay.JPG)





##### 지능형 웹 제작 시 table에 적용하는 방법(?)

- h태그에만 적용됨


<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		@import url('https://fonts.googleapis.com/css?family=Anton&display=swap');

​		


```css
	.menuname>td {

		font: bold;
		font-size: 30px;
		font-style: initial;
```


```css
	}

	.table {
		
		text-align: center;
		font-family: 'Anton', sans-serif;

	}
	.or>input{
		font-family: 'Anton', sans-serif;
		font-size:15px;
		background-color: white;
		border: 0;
		outline: none;

	}
	.or {
		
		text-align: center;
	}

	.last1>td {

		text-align: center;
		width: 200px;
		height: 100px;

		border-radius: 20px;

		background-color: green;
	}

	.last1>td>input {

		text-align: center;
		width: 280px;
		height: 100px;

		border-radius: 20px;
```


```css
	}

	#subway {
		background-color: green;
		border-radius: 20px;
	}

	#sub {

		color: yellow;
		height: 100px;
		font-size: 100px;
		font: bold;
		font-style: inherit;
		border-radius: 20px;
	}

	#way {
		color: white;
		height: 100px;
		font-size: 100px;
		font: bold;
		font-style: inherit;
		border-radius: 20px;

	}
```


​	

```css
	.fi {
		visibility: hidden;
		width: 50px;

	}

	.btnon>td>input {
		font-family: 'Anton', sans-serif;
		background-color: white;
		font-size: 1.2em;
		color:black;
		border: 0;
		outline: none;
		
	};
```


​	

```html
	.total>td>input {

		font-family: 'Anton', sans-serif;
		background-color: white;
		
		font-size: 1.2em;
		border: 0;
		outline: none;
	};
</style>
<script language="javascript">
```



		var sum = 0;
	
		function order(i) {
	
			if (i == 'no') {
				window.location.reload();
			}
			else if (confirm("주문하시겠습니까?")) {
				alert("결제창으로 이동합니다.");
				location.href = "move.html?" + sum;



```css
		}

	};
	var count=0;
	function menuon(i, j) {
		
		this.sum += parseInt(j);

		document.getElementById("price").value
			= this.sum;
		//빵	
		if (i == 'h') { document.getElementById("last").value = '허니오트 '; }
		if (i == 'w') { document.getElementById("last").value = '화이트 '; }
		if (i == 'f') { document.getElementById("last").value = '플랫브래드 ' };
		//메뉴
		if (i == '쉬림프') { document.getElementById("me").value = '쉬림프 ' };
		if (i == '햄') { document.getElementById("me").value = '햄 '; }
		if (i == '에그마요m') { document.getElementById("me").value = '에그마요 ' };
		if (i == '참치') { document.getElementById("me").value = '참치 ' };
		if (i == '미트볼') { document.getElementById("me").value = '미트볼 ' };
		//토핑
		if (i == '쉬림프D') { document.getElementById("toppin").value += '쉬림프 더블 업 '};
		if (i == '아보카도') { document.getElementById("toppin").value += '아보카도 ' };
		if (i == '에그마요') { document.getElementById("toppin").value += '에그마요 ' };
		if (i == '베이컨') { document.getElementById("toppin").value += '베이컨 ' };
		if (i == '더블치즈') { document.getElementById("toppin").value += '더블치즈 ' };

		//음료
		if (i == '음료') { document.getElementById("soda").value = '음료 ' };
		if (i == '커피') { document.getElementById("soda").value = '커피 ' };

		//사이드
		if (i == '웨지감자') { document.getElementById("side").value = '웨지감자 ' };
		if (i == '더블초코') { document.getElementById("side").value = '더블 초코칩 쿠키' };
```



		};
	
		function visible(t) {


```css
		if (t == 'b') {

			document.getElementById('bread').style.visibility = 'visible';
		}

		if (t == 'm') {

			document.getElementById('menu').style.visibility = 'visible';
		}
		if (t == 't') {
			document.getElementById('top').style.visibility = 'visible';

		}
		if (t == 'w') {
			document.getElementById('bv').style.visibility = 'visible';

		}
		if (t == 's') {
			document.getElementById('side-1').style.visibility = 'visible';

		}
```



		};
	
	</script>

</head>

<body>

	<table class="table">
		<tr>
			<td colspan="5" id="subway"> <span id="sub">SUB</span><span id="way">WAY</span> </td>
		</tr>
		<tr class="btnon">
			<td><input type="button" onclick="visible('b');" value="빵"></td>
			<td><input type="button" onclick="visible('m');" value="메뉴"></td>
			<td><input type="button" onclick="visible('t');" value="추가토핑"></td>
			<td><input type="button" onclick="visible('w');" value="음료"></td>
			<td><input type="button" onclick="visible('s');" value="사이드 메뉴"></td>
		</tr>
		<tr class="fi">
			<td id="bread">
				<input type="image" src="img/honey.jpg" style="WIDTH: 200pt; " onclick="menuon('h',1000);" 
					value="허니오트">

```html
			<br><strong>허니오트</strong><br><span>Honey Oat</span><br><span>230kcal</span><br>

			<input type="image" src="img/white.jpg" style="WIDTH: 200pt; " onclick="menuon('w',1200);" 
				value="화이트">

			<br><strong>화이트</strong><br><span>White</span><br><span>200kcal</span><br>

			<input type="image" src="img/flat.jpg" style="WIDTH: 200pt; " onclick="menuon('f',1300);"
				value="플랫브레드">

			<br><strong>플랫브래드</strong><br><span>Flat Bread</span><br><span>230kcal</span><br>
			
		</td>
		<td id="menu">
			<input type="image" src="img/shi.jpg" style="WIDTH: 200pt; " onclick="menuon('쉬림프',1300);" 
				value="허니오트">

			<br><strong>쉬림프</strong><br><span> Shrimp</span><br><span>500kcal</span><br>

			<input type="image" src="img/egg.jpg" style="WIDTH: 200pt; " onclick="menuon('에그마요m',1500);"
				name="hobby" value="화이트">

			<br><strong>에그마요</strong><br><span>Egg Mayo</span><br><span>400kcal</span><br>

			<input type="image" src="img/meat.jpg" style="WIDTH: 200pt; " onclick="menuon('미트볼',1200);" 
				value="플랫브레드">

			<br><strong>미트볼</strong><br><span>Meat Ball</span><br><span>330kcal</span><br>

			<input type="image" src="img/ham.jpg" style="WIDTH: 200pt; " onclick="menuon('햄',1800);" 
				value="플랫브레드">

			<br><strong>햄</strong><br><span>Ham</span><br><span>310kcal</span><br>

			<input type="image" src="img/tuna.jpg" style="WIDTH: 200pt; " onclick="menuon('참치',1900);" 
				value="플랫브레드">

			<br><strong>참치</strong><br><span>Tuna</span><br><span>400kcal</span><br>

		</td>
		<td id="top">

			<input type="image" src="img/sd.jpg" style="WIDTH: 200pt; " onclick="menuon('쉬림프D',1000);" 
				value="허니오트">

			<br><strong>쉬림프 더블 업</strong><br><span> Shrimp double up</span><br><span>230kcal</span><br>

			<input type="image" src="img/eggm.jpg" style="WIDTH: 200pt; " onclick="menuon('에그마요',1000);"
				name="hobby" value="화이트">

			<br><strong>에그마요</strong><br><span>Egg Mayo</span><br><span>200kcal</span><br>

			<input type="image" src="img/ab.jpg" style="WIDTH: 200pt; " onclick="menuon('아보카도',1000);" 
				value="플랫브레드">

			<br><strong>아보카도</strong><br><span>Meat Ball</span><br><span>230kcal</span><br>

			<input type="image" src="img/bay.jpg" style="WIDTH: 200pt; " onclick="menuon('베이컨',1000);" 
				value="플랫브레드">

			<br><strong>베이컨</strong><br><span>Ham</span><br><span>230kcal</span><br>

			<input type="image" src="img/dc.jpg" style="WIDTH: 200pt; " onclick="menuon('더블치즈',1000);" 
				value="플랫브레드">

			<br><strong>더블치즈</strong><br><span>Tuna</span><br><span>230kcal</span><br>

		</td>
		<td id="bv">
			<input type="image" src="img/tan.jpg" style="WIDTH: 200pt; " onclick="menuon('탄산',1000);" 
				value="허니오트">

			<br><strong>탄산음료</strong><br><span> Soda </span><br><span>230kcal</span><br>

			<input type="image" src="img/cof.jpg" style="WIDTH: 200pt; " onclick="menuon('커피',1000);" 
				value="화이트">

			<br><strong>커피</strong><br><span> Coffee </span><br><span>200kcal</span><br>
```


```html
		</td>
		<td id="side-1">

			<input type="image" src="img/wz.jpg" style="WIDTH: 200pt; " onclick="menuon('웨지감자',3000);" 
				value="허니오트">

			<br><strong>웨지감자</strong><br><span> Wedge </span><br><span>550kcal</span><br>

			<input type="image" src="img/dcho.jpg" style="WIDTH: 200pt; " onclick="menuon('더블초코',3000);"
				 value="화이트">

			<br><strong>더블 초코칩 쿠기</strong><br><span> Double Choco </span><br><span>450kcal</span><br>

		</td>
```


```html
	</tr>

	<tr class="menuname">
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>

	<tr class="last1">
		<td><input id="last" readonly type="text"  value=""></td>
		<td><input id="me" readonly type="text"  value=""></td>
		<td><input id="toppin" readonly type="text"  value=""></td>
		<td><input id="soda" readonly type="text"  value=""></td>
		<td><input id="side" readonly type="text" value=""></td>
	</tr>
	<tr class="total">

		<td colspan="5">Total : <input id="price" readonly type="text" name="hobby" value=""></td>
	</tr>

</table>
<h1 class="or">
	<input type="button" onclick="order('yes');" value="주문">
	<input type="button" onclick="order('no');"  value="취소">
</h1>
```
</body>

</html> 