# jQuery

##### - 자바스크립트 프로그래밍의 양을 상당히 줄일 수 있는 장점





```
자바스크립트 : document.getElementsById("myPara").innerHTML="안녕하세요?"
jQuery     : $("$myPara").html("안녕하세요?");
```



### I. jQuery 문장의 구조

```javascript
$(selector).action();

$ : jQuery라는 의미이다.
selector : 선택자
$(selector) : 선택자에 의하여 선택된 요소
action() : 선택된 요소의 함수 호출
```



### II. 일반적인 jQuery 구조

```
$(document).ready(function(){

	// DOM이 로딩되어서 준비가 되면 작업을 시작한다.
	// 구체적으로 jQuery 메서드를 호출한다.

});

$(document) : DOM을 의미
ready : 준비가 되면
function(){} : 함수 정의
```



### 예제

```css
대응관계 인지하자

$(document).ready(function(){
	$('h1').text('-----');                 --1
	$('#hh').html('<a href="">Click</a>');  --2
	$('.ch').text('Class');					--3
	$('input[type="text"]').css('background','gray'); --4
	$('input[name="pwd"]').css(
		{'color':'red','background':'blue'}      --5
	);
});
```

```html

<h1>Header1</h1>
	<h1 id="hh">Header1</h1>    --1
	<h1>Header1</h1>			--2
	<h1 class="ch">Header1</h1> --3
	<input type="text" name="id"><br> --4
	<input type="password" name="pwd"><br>  --5
	

```



### 실습

```css

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<style>
div{
	width:300px;
	border:3px solid blue;
	margin-top: 30px;
}
.hh{
	color:red;
	font-size: 1.2em;
	background: pink;
}
.dd{
	width:200px;
	border:3px dotted red;
	background: blue;
}

</style>
<script>
var cnt = 0;
$(document).ready(function(){
	$('button:eq(0)').click(function(){
		$('div').append('<h3>Append'+cnt+'</h3>');
		cnt++;
	});
	$('button:eq(1)').click(function(){
		$('div').prepend('<h3>Prepend'+cnt+'</h3>');
		cnt++;
	});
	$('button:eq(2)').click(function(){
		$('div').after('<h3>After'+cnt+'</h3>');
		cnt++;
	});
	$('button:eq(3)').click(function(){
		$('div').before('<h3>Before'+cnt+'</h3>');
		cnt++;
	});
	$('button:eq(4)').click(function(){
		$('div').empty();
	});
	$('button:eq(5)').click(function(){
		$('div').remove();
	});
	$('button:eq(6)').click(function(){
		$('div').addClass('dd');
		$('h1').addClass('hh');
	});
	$('button:eq(7)').click(function(){
		$('div').removeClass('dd');
		$('h1').removeClass('hh');
	});
});
</script>
</head>
```



```html
<body>
<h1>DOM Management</h1>
<button>Append</button>
<button>Prepend</button>
<button>After</button>
<button>Before</button>
<button>Empty</button>
<button>Remove</button>
<button>ADD CLASS</button>
<button>REMOVE CLASS</button>
<div></div>
</body>
</html>
```

