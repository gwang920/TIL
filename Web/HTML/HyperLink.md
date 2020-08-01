java resources

서버의 자바 프로그래밍이 동작하는 곳



web

browser 파일



# Hyper Link

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Hyper Link</h1>
<a href="http://www.naver.com">Clikc1</a>   <!-- <a> 링크생성시 사용  inline-->
<a href="http://www.daum.net">Clikc2</a>
</body>
</html>
```





같은 디렉토리 자유롭게 호출 가능



../ : 상위폴더로가자



**영어, 숫자, 공백 : 1bite특수기호, 한글, 한자 : 2bite**

p91 파일업로드

```
<form enctype="multipart/form-data">
&nbsp


byte
var x=10(byte)
```







```html
target

<a href="#h_target">Clikc3</a>    <!--Click3을 누르면 id h_target으로 이동한다 -->
<h1 id="h_target">Header1</h1>

download

<a href="file/tomcat.zip">Clikc4</a>  

```

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
/* css */
a{
	text-decoration: none; 
	color:red;
	font-size: 2em;   
}
</style>
<script>
/* send함수 */
function send(){
	alert('Are you OK ?'); /* 메세지창 */
	location.href = 'b1.html';
};

</script>
<title>Insert title here</title>
</head>
<body>
<h1>Hyper Link</h1>
<h3><a href="b1.html" target="_blank">Clikc1</a></h3>
<a href="b/b2.html">Clikc2</a>
<a href="#h_target">Clikc3</a>
<a href="file/tomcat.zip">Clikc4</a>
<a href="#" onclick="send()">Clikc5</a> <!-- 작업안할때 # / Click5누르면 javascript 뜬다 -->
<h1>Header1</h1>
<h1>Header1</h1>
<h1>Header1</h1>
<h1>Header1</h1>
<h1>Header1</h1>
<h1>Header1</h1>
<h1>Header1</h1>
<h1>Header1</h1>
<h1>Header1</h1>
<h1>Header1</h1>
<h1>Header1</h1>
<h1>Header1</h1>
<h1>Header1</h1>
<h1>Header1</h1>
<h1>Header1</h1>
<h1>Header1</h1>
<h1>Header1</h1>
<h1 id="h_target">Header1</h1>
<h1>Header1</h1>
<h1>Header1</h1>
</body>
</html>
```



# 홈페이지 제작 실습 (수정 전)

```html
- index.html

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<style>
img{
	width:700px;
	height:300px;  /* 크기 조절 */
	display: block;  /* inline 변경 --> 한줄에 사진하나씩 */
}
</style>
<script>
function login(f)
{
	var c = alert('Go to the login page');
	if(c==true){
		f.method='GET';
		f.action='a';
		f.submit();
		
	};
	
	};


</script>
<title>Insert title here</title>
</head>
<body>
<h1>Hello World</h1>


 <!-- <form action="a" method="GET"> a라는 서버 프로그램에 GET방식으로 전송  -->
<table>
<tbody>
<tr>
	<td></td><td><a href="signin.html"><input onclick="login(this.form);"type="button" value="SingIn"></a>
	</td>
</tr>	


</tbody>

</table>


</body>
</html>

- signin.html

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script>
function login(f)
{	
	
	var c = alert('Signing in..');
	if(c==true){
		f.method='GET';
		f.action='a';
		f.submit();
		
		
		
	};


	
	};
	


function maxLengthCheck(object){

	
	if (object.value.length >10){
		
		
		
		object.value = object.value.slice(0,10);
		alert('Can not enter more than 10 characters'); 
		
			      
			    };
		   
	
	 
			  };



</script>
<title>Insert title here</title>
</head>
<body>
<h1>Sing In</h1>
	

 <!-- <form action="a" method="GET"> a라는 서버 프로그램에 GET방식으로 전송  -->
<table>
<tbody>
<tr>
	<td>ID</td><td><input type="text" title="Can not enter more than 10 characters"  oninput="maxLengthCheck(this)"  name="nm" ></td>
</tr>
<tr>

	<td>PWD</td><td> <input type="password" 
	title ="can not enter more than 8 characters"
	
	name="pwd"></td>
</tr>	

<tr>
	<td></td><td><a href="logon.html"><input onclick="login(this.form);"type="button" value="SingIn"></a>
	<a href="Singup.html"><input type="button" value="SingUp"></a></td>
</tr>	


	



</tbody>

</table>


</body>
</html>

- logon.html

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
img{
	width:1000px;
	height:500px;  /* 크기 조절 */
	display: block;  /* inline 변경 --> 한줄에 사진하나씩 */
}
</style>
<title>Insert title here</title>
</head>
<body>
<h1>Welcome</h1>
<img src="img/sgg1.jpg">
</body>
</html>

- signup.html
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script>
function PsCheck(f)
{
	var c = confirm('Are You Login..');
	if(c==true){
		f.method='GET';
		f.action='a';
		f.submit();
		
	};
	
	};
	
	//메일 유효성체크

	var mailCheck = function(){

			email = document.getElementById("email").value;

			eCheck=/^[_a-zA-Z0-9]+([-+.][_a-zA-Z0-9]+)*@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/i;

			

			var mail_check=eCheck.test(email);

			

			if(mail_check==true){

				// 통과

				alert("correct");

			}else{

				// 실패

				alert("Not in the correct format");

			}

		}

	
	var psCheck=function(){
		
		var pattern1 = /[0-9]/;

        var pattern2 = /[a-zA-Z]/;

        var pattern3 = /[~!@\#$%<>^&*]/;   

        var pw_msg = "";
        
        var ps=document.getElementById("ps").value;
        
        if(ps.length==8){
        	if(!pattern1.test(ps)||!pattern2.test(ps)||!pattern3.test(ps)){

                alert("Password is the number of special English text mixed with 8 characters");

                return false;

            }
        
   	
        }
		
        	/* 
        	 if(!pattern1.test(ps)||!pattern2.test(ps)||!pattern3.test(ps)||ps.length<8||ps.length>50) */
              


	} 
function maxLengthCheck_p(object){

		
		if (object.value.length >8){
			
			
			
			object.value = object.value.slice(0,8);
			alert('Can not enter more than 8 characters'); 
			
				      
				    };
			   
		
		 
				  };
	


	function maxLengthCheck(object){

		
		if (object.value.length >10){
			
			
			
			object.value = object.value.slice(0,10);
			alert('Can not enter more than 10 characters'); 
			
				      
				    };
			   
		
		 
				  };




</script>
<title>Insert title here</title>
</head>
<body>
<h1>Singup Form</h1>


<fieldset>
<legend> Register
</legend>

<input type="hidden" name="geo" value="fff">  <!-- hidden 보이지 않게 전송하는 것  -->

<table>
<tbody>
<tr>
	<td>ID&nbsp;</td> <td><input type="text" oninput="maxLengthCheck(this)" name="tx"><input type="button" value="&nbsp;Duplicate check"></td>
</tr>

<tr>
	<td>PASSWORD&nbsp;</td> <td><input type="password" oninput="maxLengthCheck_p(this)" id="ps" name="pwd" onkeyup="psCheck()"/></td>
</tr>
<tr>
	<td></td><td>(Password is the number of special English text mixed with 8 characters)</td>
</tr>
<tr>
	<td>First Name&nbsp;</td> <td><input type="text" name="fn">&nbsp;Last Name&nbsp;<input type="text" name="lm"><br></td>
</tr>

<tr>
	<td>TEL&nbsp;</td> <td><input type="tel" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
title ="000-0000-0000" name="fn"></td>
</tr>

<tr>
	<td>E-mail&nbsp;</td> <td><input type="email" id="email"
name="e" onkeyup="mailCheck()"/></td>
</tr>


 
</tbody>
</table>
<form>
<br>
<label for ="male">&nbsp;Male</label>

<input id="male" type="radio" name="g" value="m">
Female <input type="radio" name="g" value="f">

<br>
<br>
<input type = "submit" name="SUBMIT" value="SUBMIT">
</form>
</fieldset>

</body>
</html>
```

