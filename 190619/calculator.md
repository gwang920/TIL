# 계산기

```
   결과창
   + - x /  
   1 2 3 0
   4 5 6 =
   7 8 9 
   
   다음과 같은 계산기를 만들자
```

# 실패

##### 문제점 : 연산을 위한 버튼 값들을 value에 저장하지 않아 numcal() 시행시 결과값이 나오지 않았다.

```html

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style></style>
	<script>
		var sum;

		function plus(){
			var result=document.getElementById('result');
			
			result.innerHTML+='+';
			
		}
		function minus(){
			var result=document.getElementById('result');
			
			result.innerHTML+='-';

		}
		function multiply(){
			var result=document.getElementById('result');
			
			result.innerHTML+='X';

		}

		function division(){
			var result=document.getElementById('result');
			
			result.innerHTML+='/';

		}

		function numcal(){

			
			
			
			var result=document.getElementById('result').value;
			var tsum=eval('result');
			document.getElementById("result").value=tsum;

			var result1=document.getElementById('result');
			result.innerHTML='result1';
			
		}

		



		function calc(n){

			if(n=='c'){
			var result=document.getElementById('result');
			
			result.innerHTML='';

			}


			if(n==0){
			var result=document.getElementById('result');
			
			result.innerHTML+='0';
			

			}
			if(n==1){
			var result=document.getElementById('result');
			
			result.innerHTML+='1';
		

			}
			if(n==2){
			var result=document.getElementById('result');
			
			result.innerHTML+='2';

			}
			if(n==3){
			var result=document.getElementById('result');
			
			result.innerHTML+='3';

			}
			if(n==4){
			var result=document.getElementById('result');
			
			result.innerHTML+='4';

			}
			if(n==5){
			var result=document.getElementById('result');
			
			result.innerHTML+='5';

			}
			if(n==6){
			var result=document.getElementById('result');
			
			result.innerHTML+='6';

			}
			if(n==7){
			var result=document.getElementById('result');
			
			result.innerHTML+='7';

			}
			if(n==8){
			var result=document.getElementById('result');
			
			result.innerHTML+='8';

			}
			if(n==9){
			var result=document.getElementById('result');
			
			result.innerHTML+='9';

			}
		
		}
	</script>

</head>

<body>
	
	<form>
		
		<table>

			<thead>
				<tr>
					
					<h1 type="text" id="result"></h1>
					<th colspan="4"><input onclick="calc('c')" type="button" value="C"></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input onclick="plus()" type="button" value="+"></td>
					<td><input onclick="minus()" type="button" value="-"></td>
					<td><input onclick="multiply()" type="button" value="X"></td>
					<td><input onclick="division()" type="button" value="/"></td>
				</tr>
				<tr>
					<td><input onclick="calc(1)" type="button" value="1"></td>
					<td><input onclick="calc(2)" type="button" value="2"></td>
					<td><input onclick="calc(3)" type="button" value="3"></td>
					<td><input onclick="calc(0)" type="button" value="0"></td>
				</tr>
				<tr>
					<td><input onclick="calc(4)" type="button" value="4"></td>
					<td><input onclick="calc(5)" type="button" value="5"></td>
					<td><input onclick="calc(6)" type="button" value="6"></td>
					<td rowspan="2"><input onclick="numcal()" type="button" value="="></td>
				</tr>
				<tr>
					<td><input onclick="calc(7);" type="button" value="7"></td>
					<td><input onclick="calc(8);" type="button" value="8"></td>
					<td><input onclick="calc(9);" type="button" value="9"></td>
					<td></td>
					
				</tr>

			</tbody>
		</table>



	</form>

</body>

</html>
```



# 성공

##### 코드를 간결화하는 연습하자!



```html
<html>
 
<head>
    <title>title</title>
    <style>
    input[type="text"]{
        font-size: 40px;
        height: 70px;
        width: 400px;
    }
    td{
        background-color: skyblue;
        width: 100px;
        height: 70px;
        text-align: center;
        font-size: 40px;
        border-radius: 5px;
    }
    </style>
    <script>
        function input(val){
            var text = document.getElementById("field").value;
            text= text+val;
            document.getElementById("field").value=text;
            
        };
        function cal(){
            var text = document.getElementById("field").value;
            text = eval(text);
            document.getElementById("field").value=text;
        };
        function init(){
            document.getElementById("field").value="";
        };
    </script>
</head>
 
<body>
    <table>
        <tr>
            <td colspan="4">
                <input type="text" readonly id="field">
                
            </td>
        </tr>
        <tr>
            <td colspan="4" onclick="init()">
                <span>C</span>
            </td>
        </tr>
        <tr>
            <td onclick="input('+')">
                <span>
                    +
                </span>
            </td>
            <td onclick="input('-')">
                <span>
                    -
                </span>
            </td>
            <td onclick="input('*')">
                <span>
                    x
                </span>
            </td>
            <td onclick="input('/')">
                <span>
                    /
                </span>
            </td>
        </tr>
        <tr>
            <td onclick="input('1')">
                <span>
                    1
                </span>
            </td>
            <td onclick="input('2')">
                <span>
                    2
                </span>
            </td>
            <td onclick="input('3')">
                <span>
                    3
                </span>
            </td>
            <td onclick="input('0')">
                <span>
                    0
                </span>
            </td>
        </tr>
        <tr>
            <td onclick="input('4')">
                <span>
                    4
                </span>
            </td>
            <td onclick="input('5')">
                <span>
                    5
                </span>
            </td>
            <td onclick="input('6')">
                <span>
                    6
                </span>
            </td>
            <td rowspan="2" onclick="cal()" >
                <span>
                    =
                </span>
            </td>
        </tr>
        <tr>
            <td onclick="input('7')">
                <span>
                    7
                </span>
            </td>
            <td onclick="input('8')">
                <span>
                    8
                </span>
            </td>
            <td onclick="input('9')">
                <span>
                    9
                </span>
            </td>
            
        </tr>
    </table>
</body>
 
</html>



```

