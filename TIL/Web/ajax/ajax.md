# Ajax

#### I. Ajax(Asynchronous Javascript And Xml)

![image](https://user-images.githubusercontent.com/49560745/83612230-19e40f80-a5bd-11ea-9805-d018da4a6428.png)

- Ajax는 서버와 데이터를 교환하는 기술
- 비동기적으로 HTML 페이지를 업데이트
- 즉, 전체 페이지를 다시 적재하지 않고, 웹 페이지의 일부를 업데이트 할 수 있다. 

```
기본적으로 HTTP 프로토콜은 클라이언트쪽에서 Request를 보내고 Server쪽에서 Response하는데 이때 이어졌던 연결이 끊기게 된다. 따라서, 변화 된 내용을 갱신하기 위해 페이지 전체를 다시 로드해야한다. 이럴 경우 자원낭비, 시간낭비가 엄청나다.
  
  이를 조금 더 효율적으로 하기 위해 html이 아닌 일부분만 갱신할 수 있는 XML HttpRequest객체를 통해 서버에 request 한다.
  
  JSON이나 XML형태로 필요한 데이터만 받아 갱신하기 때문에 자원, 시간을 아낄 수 있다.
  
  웹페이지에서 최근 가장 중요한 것은 속도!!! 이기 때문에 ajax는 필수적이다.
```

  ##### 	  ex) 검색창 자동완성 기능, 실시간 검색 순위

  스마트폰 상단바

- 즉,  Javascript를 사용하여 비동기 통신, 클라이언트와 서버간에 XML 데이터를 주고 받는 기술이라고 정의할 수 있음



#### II. AJAX 장단점

##### 장점

- 웹페이지 속도 향상
- 서버에서 Data만 전송하면 되므로 전체적인 코딩 양이 줄어든다.
- 기존 웹에서는 불가능했던 UI 실현이 가능하다. EX) 스마트폰 상단바

##### 단점

- 히스토리 관리가 안된다. (보안 취약)

- 연속으로 데이터 요청이 오면 서버 과부하가 올 수 있다.

-  XMLHttpRequest를 통해 통신을 하는 경우 사용자에게 진행 정보가 주어지지 않는다. 

  그렇기 때문에, 아직 요청이 완료되지 않았는데 사용자가 페이지를 떠나거나 오작동할 우려가 발생하게 된다. 
  
  

#### III. Ajax 서버 연결

- java Resources : 서버프로그램 위치
- servelet : 자바서버
- Method를 누르는 순간 servelet의 Method 라는 서버 프로그램 요청
- JRE  : JVM(자바)을 구현할 수 있게 하는 환경설정 / 라이브러리



#### IIII. Ajax 실행 순서

```
1. XMLHttpRequest (요청) 객체를 생성
2. 처리 결과를 받을 이벤트 리스너 등록
3. 서버로 보낼 데이터 생성 
4. 클라이언트와 서버 간의 연결 요청 준비(open() 메서드 이용)
4-1. 서버로 보낼 데이터 전송방식 설정(GET, POST 중 선택)
4-2. 서버 응답 방식 설정(동기, 비동기 중 선택)
5. 실제 데이터 전송
6. 응답처리
7. 데이터 처리
```

#### Jquery를 이용한 Ajax

```javascript
// jQuery를 이용한 Ajax 기본 사용방법
$.ajax({
    // URL은 필수 요소이므로 반드시 구현해야 하는 Property이다.
    url : '요청 URL 주소를 입력'
    // 다양한 속성들 중에서 필요한 Option을 선택해서 구현('[]'는 반복해서 사용할 수 있다는 의미)
    [, Options]
});
```

#### 예제 (비밀번호찾기)

````javascript
<script>
	$(document).ready(function() {
		var findInfo = '';
		$('#btn_find').on('click', function() {
			if (findInfo != '') {
				var hint_result = $('#find_hint_answer').val();
				
				if(hint_result == findInfo.hint_answer) {
					alert(findInfo.pwd);
					location.href = "#slide05";
				}else{
					alert("힌트 답변이 틀렸습니다.");
				}
			}
			else {
				var id = $('#find_id').val();
				var name = $('#find_name').val();
				console.log(id + name);
				$.ajax({
					method : "POST",
					url : "find.mc",
					data : {
						'id' : id,
						'name' : name
					},
					success : function(result) {
						console.log(result);
						if (result == "0") {
							alert("사용자가 존재하지 않습니다.");
							return;
						} else {
							findInfo = result;
							$('#find_hint').val(result.hint);
							$('#btn_find').val("비밀번호 조회");
							/* location.href = "index.mc"; */
						}
					}
				});
			}
		});
	});
````



* 참고

```
json / jquery / ajax 개념

전부 javascript 기반이다.

1)json
key: value로 구성된 자바스크립트의 객체표현에서 따온 일종의 데이터의 열거방식

2)jquery
자바스크립트를 직관적으로 사용하는 것으로 테그이름이나 브라우져안의 문서를 쉽고 짭게 조작가능함 ( 단 사용하기 위해 jquery js파일을 별도로 추가해야함.

3)ajax 
화면 갱신없이 클라이언트에서 자바스크립트를 이용해 변경되는 부분을 바꾸어주는 방식.
자바스크립트방식이도 있고 제이쿼리 방식도 있음
```

