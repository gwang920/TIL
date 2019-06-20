# 자판기

![자판기](C:\Users\student\Desktop\자판기.JPG)



##### 자판기를 생성하자!

- check box 중복 선택 시 return 값 결정
- 음료 중복시 ' , '로 구분 시 데이터 사이에만 ' , '를 넣는방법 ?
  - id[i] 의 length를 구해서 넣는다 (?) -- > 고민해보자
- id가 겹치면 안된다

```HTML
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		#pay {

			text-align: left;
		}
	

		td {
			text-align: center;
			border-radius: 5px;
			background-color: green;
		}
	</style>
	<script>
		function add() {
			// var id=document.myform.id.value//document에서  form 호출 위해 .myform -> id -> id에 해당하는 값 

			var id = document.myform.hobby;
			document.getElementById("type").value = " ";



			for (var i in id) {


				if (id[i].checked) {

					document.getElementById("type").value
						+= id[i].value + ' ';




				};
			};


			var target = document.getElementById("payment");

			if (target.options[target.selectedIndex].text == "카드/현금") {
				document.getElementById("type").value=' ';
				alert("지불방법을 선택하세요");
			}
			else {
				document.getElementById("pays").value = target.options[target.selectedIndex].text;
			}

		};
	</script>

</head>

<body>
	<form name="myform">
		<table>
			<tr>
				<td colspan="3"> 자 판 기 </td>
			</tr>
			<tr>
				<td>포카리<input type="checkbox" name="hobby" value="포카리">
				</td>
				<td>게토레이<input type="checkbox" name="hobby" value="게토레이"></td>
				<td>2%<input type="checkbox" name="hobby" value="2%"></td>
			</tr>
			<tr>
				<td colspan="3" id="pay">

					지불방법 <select name="payment" id="payment">
						<option value="" selected>카드/현금</option>
						<option value="학생">카드</option>
						<option value="회사원">현금</option>
					</select>
				</td>

			</tr>

			<tr id="sel">
				<td colspan="3"><input type="button" value="선택" id="but" onclick="add();">
				</td>

			</tr>
			<tr>
				<td colspan="3">음료 <input type="text" id="type">
				</td><br>

			</tr>
			<tr>
				<td colspan="3">지불 <input type="text" id="pays">
				</td>

			</tr>
		</table>
	</form>
</body>

</html>
```