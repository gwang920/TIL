# * 기술

# 객체지향

## 객체지향이란?

```
구현하고자 하는 대상을 하나의 객체로 바라보며 프로그래밍을 하는 기법으로
객체에 상태와 행위를 부여하고, 이 객체들간의 상호작용을 통해 로직을 구현하는
프로그래밍 패러다임 중에 하나이다.
```

## 객체지향의 장단점?

```
* 장점
1) 코드 재사용성

이미 만들어놓은 객체를 가져와서 사용할 수 있기에 코드를 재사용할 수 있다는 장점이있다.

2) 대규모의 프로젝트에 적합하다.

객체 단위로 분류해서 담당하는 부분만 개발하고, 개발이 이루어진 후에 
객체들간의 관계만 형성해주면 되기때문에 대규모의 프로젝트에서 
업무를 분담해 개발하기 편리하다.

3) 유지보수가 쉽다.

절차지향같은 경우에는 코드를 수정할 때, 해당 부분을 직접찾아 수정해야하는 불편함이있지만,
객체지향은 수정하고자하는 객체 내부의 클래스 변수나 메소드를 수정해주면 되기때문에
유지보수에 장점이있다.

* 단점
1) 절차지향보다 속도가 느리다.
2) 설계에 많은시간이 투자된다.
```

## 추상화란?

```
불필요한 정보들은 숨기고 공통의 속성이나 기능을 묶어놓은 것
다시말하면, 객체지향 관점에서 클래스를 정의하는 것
```

## 캡슐화란?

```
필요한 속성(Attribute) 와 행위(Method) 를 하나로 묶고
그 중 일부 메소드를 통해서만 해당 객체에 접근할 수 있도록 하는 것.

데이터 보호, 불필요한 부분은 감춘다.

private public
```

## 다형성이란?

````
하나의 변수명, 함수명 등이 상황에 따라 다른 의미로 해석될 수 있는 것을 뜻함
다형성의 예로는 오버로딩, 오버라이딩이 있다.
````



# 컬렉션

```
여러 원소들을 담을 수 있는 자료구조

- 순서가 있는 LIST 형
- 순서가 중요하지 않은 목록인 SET형
- 먼저 들어온것이 먼저 나가는 QUEUE형
- KEY-VALUE의 형태로 저장되는 MAP형

배열과의 차이점은 정적 메도리 할당이 아닌
동적 메모리 할당이 가능하다는 점
```

## List

```
List 인터페이스는 배열처럼 순서가 있다.
ArrayList, LinkedList,vector,stack
```

## HashMap vs HashTable

```
- 둘의 가장 큰 차이점은 동기화 보장유무, 키와 값에 null 부여 가능 여부
- 동기화가 필요없다면 해시맵을, 동기화 보장이 필요하다면 해시테이블 사용
- 동기화 보장유무외에는 차이가 없음

해시테이블 객체의 모든 메소드는 동기화되어있다
즉, 한개의 객체에 누군가가 작업하고 있다면 이 작업이 종료될때까지
접근할 수 없다

키,값 쌍의 데이터를 저장하는 방법
키를 해시함수에 넣고 돌리면, 해시주소가 반환되고
이 해시주소에 해당하는 테이블에 value값이 저장된다.

해시충돌
체이닝,개방주소법
```

## map vs unorderedmap

```
map은 레드블랙트리기반 => 정렬되어 저장된다.
unorderedmap = hashmap
```

# == / equals

```
== : 주소값비교
equals : 단순 값 비교
```





# 싱글톤 패턴

```
하나의 클래스에 대해 하나의 인스턴스만 만들어서 사용하기 위한 패턴
ex) 커넥션 풀과 같은 객체의 경우 인스턴스를 여러개 만들게 되면
자원이 낭비되므로 하나만 생성하는 것이 효율적이다.
```





# JDBC

```
자바에서 DB의 종류에 상관없이 데이터베이스에 쉽게 접근할 수 있도록 하는 API

java Data Base Connectivity

vs dbcp

Data Base Connection Pool
```





````
jsp란 Java Server Pages의 약자
HTML 코드에 JAVA 코드를 넣어 동적웹페이지를 생성하는 웹어플리케이션 도구이다.

jsp가 실행되면 자바 servlet으로 변환되며 웹 어플리케이션 서버에서 동작되면서 필요한 기능을 수행하고
그렇게 생성된 데잍를 웹페이지와 함께 클라이언트로 응답한다.
````





```
servlet이란

웹에서 java 프로그래밍을 구현하기 위해 탄생
java로 구현된 cgi(common gateway interface)
javax.servlet.http.HttpServlet 클래스를 상속하여 개발하며
Servlet은 Container에 의해서 실행되고 관리된다.

HTML 변경시 servlet을 재컴파일 해야하는 단점이 있다.



```





```
1) 사용자가 URL을 클릭하면 HTTP Request를 Servlet Container에 보낸다.
2) Servlet Container는 HttpServletRequest, HttpServletResponse 두 객체를 생성한다.
3) 사용자가 요청한 URL을 분석하여 어느 서블릿에 대한 요청인지 찾는다. (DD를 참조하여 분석)
4) 컨테이너는 서블릿 service() 메소드를 호출하며, POST, GET여부에 따라 doGet() 또는 doPost()가 호출된다.
5) doGet() or doPost() 메소드는 동적인 페이지를 생성한 후 HttpServletResponse객체에 응답을 보낸다.
6) 응답이 완료되면 HttpServletRequest, HttpServletResponse 두 객체를 소멸시킨다.
```

![image](https://user-images.githubusercontent.com/49560745/100100044-8d4b4780-2ea3-11eb-9432-3ecaa0ab7b48.png)



```
web.xml

Servlet, Error Page, Listener, Filter, 보안설정 등
Web Application의 설정파일

URL과 실제 서블릿의 매핑 정보도 담고있다.


servlet => jsp [model 1] => jsp + servlet [model 2]
```



| Servlet                                                      | JSP                                                          |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| ~ 자바코드로 구현하고 컴파일하고 배포해야 한다. <br />~ HTML태그로 문자열("")스크림으로 처리해야 한다. <br />~ 코드가 수정되면 다시 컴파일하고 배포해야 한다. | ~ 키워드가 태그화 되어 서블릿에 비해 배우기 쉽다. <br />~ 자바코드를 <%%>태그 안에 처리해주어야 한다. <br />~ HTML처럼 태그를 사용하여 자바코드도 사용이 가능하다. |

# String, StringBuilder, StringBuffer

```
String 과 StringBuilder, StringBuffer의 차이점은
String은 immutable, StringBuilder,StringBuffer는 mutable이라는 점이다.

String 객체는 한번 생성되면 할당된 메모리 공간이 변하지 않는다.
+연사자나 concat 메서드를 통해 기존 생성된 String 객체 문자열에 새로운 문자열을 붙이는것은
기존문자열에 새로운 문자열을 붙이는 것이 아니라,

기존 문자열은 그대로 메모리 공간을 차지하고, 새로운 String이 새로운 메모리공간에 할당되는 것이다.

StringBuilder와StringBuffer는
기존의 버퍼크기를 늘리며 유연하게 작동한다.

그러나, 둘의 차이점은
StringBuffer는 각 메서드별로 Sychronized Keyword가 존재하며, 동기화를 보장한다.
반면, StringBuilder는 동기화를 보장하지 않는다.


따라서, 간단한 String 객체를 컨트롤 할거면 Stirng(불변하고, 조회가 빠르고, 멀티스레드 환경에서
동기화를 신경쓸 필요가 없음)을

StringBuffer는 스레드에 안전한 프로그램이 필요할 때나, 개발 중인 시스템의 부분이 스레드에 안전한지 모를 경우 사용하면 좋다.

StringBuilder는 스레드에 안전한지 여부가 전혀 관계 없는 프로그램을 개발할 때 사용하면 좋다.
```

reference - https://12bme.tistory.com/42 [길은 가면, 뒤에 있다.]

# staic 변수 vs static 메소드

```
static 변수

- static 변수는 정적변수라고도 하며, 한번 메모리 공간에 할당되면 변하지않는다.
- 클래스 변수라고도 한다.
- 공유의 성격을 띄는 변수로, 공통적인 값을 공유하고자 할 때 static 키워드를 사용해 변수를 선언한다.

static 메소드

- 정적메소드
- 객체가 생성되지 않은 상태에서 호출되는 메소드이다.
- 정적메소드 안에는 정적변수와 지역변수만 사용할 수 있다.(인스턴스 변수는 사용할 수 없다.)
- 정적메소드 안에서는 인스턴스 메소드를 호출하지 못한다.
- 정적메소드는 this키워드를 사용할 수 없다. this를 참조할 인스턴스가 없기 때문이다.


정리

- 멤버 변수 중 모든 인스턴스에서 공통으로 사용해야 하는 것에만 static 선언한다.
- static이 붙은 멤버변수는 인스턴스를 생성하지 않아도 사용할 수 있다.
- Static 메소드에서는 인스턴스 변수를 사용할 수 없다.
- 절대 변하지 않는 값을 final static으로 선언하면 가비지 컬렉션의 대상이 되지 않는다.
- Static은 심각한 오류의 원인이 될 수 있다.
"전역변수" 성격을 띄기에 버그를 예상외로 찾을 수 없다.
따라서, 자주 변경되지 않는 부분에 제한적으로 사용한다면 성능향상에 도움이 된다.



* 인스턴스 변수
- static 변수와 마찬가지로 클래스내에 선언한다.
- 클래스 변수(static 변수)와 차이점은 인스턴스에 종속되어 인스턴스 생성시마다 새로운 저장공간을 할당한다.
즉, 저장공간이 공유되지 않는다.
- 인스턴스에 종속되기 때문에 꼭 인스턴스객체에서 호출해주어야한다.
```







# 프로세스 vs 쓰레드

````
* 프로세스
프로세스 - 실행중인 프로그램
프로그램 - 실행할 수 있는 프로그램
프로세서 - 프로그램이 실행될 수 있도록 하는 하드웨어(CPU)


CPU(프로세서)는 한순가에 하나의 프로세스만 실행할 수 있다

멀티프로세스는
운영체제가 짧은 시간동안 프로세스를 교체하며
실행하기에 그렇기 보이는 것
(Context Switching)


PCB(Process Control Block)
프로세스를 제어하기 위한 정보 모음
- 프로세스 식별자
- 프로세스 상태
- 다음에 실행할 명령어의 주소
- 이전에 작업하던 작업 내용(레지스터)
- CPU 스케줄링 정보
(우선 순위, 최종 실행시각, CPU 점유시간 등)
- 프로세스의 주소 공간

프로세스 구조
stack : 호출된 함수, 지역변수 등 임시데이터
heap : 동적으로 생긴 데이터
data : 전역변수
code : 프로그램의 코드

프로세스의 비효율 발생 통신(IPC)


* 스레드
프로세스 내에서 동작하는 작업의 흐름 단위
쓰레드는 메모리 공간에서
Register, stack을 독립적으로 가진다.

따라서, Context switching이 일어날 때,
register의 값만 변경되고

code, heap, data 영역은 공유 된다

자원은 process 단위로 받고,
작업/스케줄링은 Thread 단위로 진행함


스레드가 프로세스보다 Context Switching이 빠른이유를 좀 더 자세하게 살펴보자

1) sp(Stack Pointer), fp(Frame Pointer), pc(Program Counter) 레지스터
- pc는 실행해야 할 명령어의 위치를 가리키는 레지스터이다.

- 쓰레드별로 main함수를 독립적으로 가지고 있지 않고, 호출도 독립적으로 진행되기 때문에 쓰레드별로 현재 pc값은 달라야 한다. 따라서 pc는 공유되지 않는다.

- 쓰레드는 독립적인 스택을 가지고 있기 때뭉네 스택의 정보를 담고 있는
sp, fp는 공유되지 않는다.

2) 범용적으로 사용가능한 레지스터
- 시스템을 어떻게 디자인 하느냐에 따라 달라지는 것이기 때문에 일반적으로 공유된다고 할 수 없다.

다중 스레드의 경우 Register Set을 switching하는 과정에서
프로세스 내부적으로 Thread Stack을 제외한 모든 메모리 공간을 공유하기 때문에
스택에 관련된 몇개의 레지스터(sp,fp)만 바꾸는 과정이 프로세스 Context Switching 과정을 대신한다.

3) 캐시메모리
- 캐시 메모리는 CPU에서 한번 이상 읽어 들인 메모리의 데이터를 저장하고 있다가
CPU가 다시 그 메모리에 저장된 데이터를 요구할 때, 메인 메모리를 통하지 않고
바로 값을 전달하는 용도로 사용된다.

- 프로세스 사이에서 공유하는 메모리가 하나도 없기 때문에 컨테스트 스위칭이 발생하면 캐시에 있는 모든 데이터를 모두 리셋하고, 다시 캐시 정보를 불러와야 한다.

- 쓰레드는 캐시 정보를 비울 필요가 없기 때문에 프로세스와 쓰레드의 컨텍스트 스위칭 속도의 차이는 이때 발생한다.

=> 실제로 다중 프로세스보다 다중 스레드가 빠른 이유는 캐시 메모리에 있다.
캐시는 CPU에 읽어들인 메모리의 데이터를 임시적으로 저장하고 있다가 CPU가
다시 필요할 때 다시 전달해주는 요도로 사용한다. 
(메인 메모리로 접근하는 경우보다 캐시를 사용할 때 훨씬 빨라진다.)

다중 프로세스의 경우, 이 캐시메모리에 올리는 데이터를 계속 갱신시켜야한다.

하지만, 다중 스레드의 경우 A스레드 ,B스레드 모두 메모리를 공유하기 때문에
데이터를 갱신시킬 필요가 없다. 이때문에 스레드는 다중 프로세스보다 수배,수십배
더 빠르다.
````



# 데드락(교착상태)

````
프로세스나 스레드가 결코 일어날 수 없는 특정 이벤트를 기다리는 상태
* 특정 이벤트 : 자원의 할당과 해제

외나무다리

트랜잭션이 서로 꼬여서 작업이 멈춰버리는 상태

트랜잭션 처리 과정

1) 해당 행 레벨 LOCK
2) 해당 행 정보 기록
3) 데이터 CRUD
4) COMMIT & 행 UNLOCK


교착상태 네 가지 필요조건
1) 상호 배제 조건
- 한 자원에 대한 여러 프로세스의 동시 접근 불가

2) 점유와 대기 조건
- 자원을 가지고 있는 상태에서 다른 프로세스가 사용하고 있는
자원의 반납을 기다리는 것

3) 비선점 조건
- 다른 프로세스의 자원을 강제로 가져올 수 없음

4) 순환 대기 조건
- 각 프로세스가 순환적으로 다음 프로세스가 요구하는
자원을 가지고 있는 것
````



# URL vs URI

```
URL은 인터넷 상의 자원 위치를 나타내고

URI는 인터넷 상의 자원을 식별하기 위한 문자열의 구성을 뜻한다.
```

# TCP/IP

````
패킷통신을 위한 인터넷 규약

IP (인터넷 프로토콜)

ip는 데이터 조각(패킷)들을 최대한 빨리 목적지로 보내는 역할
조각들의 순서가 뒤바뀌거나 일부가 누락되더라도 크게 상관하지 않고 보내는데 집중한다.

TCP (전송 제어 프로토콜)

TCP 는 IP보다 느리지만 꼼꼼한 방식을 사용한다.
도착한 조각을 점검하여 줄을 세우고 망가졌거나 빠진 조각을 다시 요청한다. 

두 방식을 조합해서 인터넷 데이터 통신을 하는 것을 묶어 TCP/IP라 한다.
````

* reference - https://brunch.co.kr/@wangho/6

# HTTP

## HTTP Request

```
POST /payment-sync HTTP/1.1

Accept: application/json
Accept-Encoding: gzip, deflate
Connection: keep-alive
Content-Length: 83
Content-Type: application/json
Host: intropython.com
User-Agent: HTTPie/0.9.3

{
    "imp_uid": "imp_1234567890",
    "merchant_uid": "order_id_8237352",
    "status": "paid"
}


1) 시작라인 
메소드 종류 / URI / HTTP 버전
예시 ) GET /search HTTP/1.1

2) 헤더
HOST : URL 정보
Content-length : 본문의 길이

3) 바디
request의 실제 메시지/내용
```

## Http Response

```
HTTP/1.1 404 Not Found

Connection: close
Content-Length: 1573
Content-Type: text/html; charset=UTF-8
Date: Mon, 20 Aug 2018 07:59:05 GMT

<!DOCTYPE html>
<html lang=en>
  <meta charset=utf-8>
  <meta name=viewport content="initial-scale=1, minimum-scale=1, width=device-width">
  <title>Error 404 (Not Found)!!1</title>
  <style>
    *{margin:0;padding:0}html,code{font:15px/22px arial,sans-serif}html{background:#fff;color:#222;padding:15px}body{margin:7% auto 0;max-width:390px;min-height:180px;padding:30px 0 15px}* > body{background:url(//www.google.com/images/errors/robot.png) 100% 5px no-repeat;padding-right:205px}p{margin:11px 0 22px;overflow:hidden}ins{color:#777;text-decoration:none}a img{border:0}@media screen and (max-width:772px){body{background:none;margin-top:0;max-width:none;padding-right:0}}#logo{background:url(//www.google.com/images/branding/googlelogo/1x/googlelogo_color_150x54dp.png) no-repeat;margin-left:-5px}@media only screen and (min-resolution:192dpi){#logo{background:url(//www.google.com/images/branding/googlelogo/2x/googlelogo_color_150x54dp.png) no-repeat 0% 0%/100% 100%;-moz-border-image:url(//www.google.com/images/branding/googlelogo/2x/googlelogo_color_150x54dp.png) 0}}@media only screen and (-webkit-min-device-pixel-ratio:2){#logo{background:url(//www.google.com/images/branding/googlelogo/2x/googlelogo_color_150x54dp.png) no-repeat;-webkit-background-size:100% 100%}}#logo{display:inline-block;height:54px;width:150px}
  </style>
  <a href=//www.google.com/><span id=logo aria-label=Google></span></a>
  <p><b>404.</b> <ins>That’s an error.</ins>
  
  
1) 상태 라인
HTTP 버젼 / status code / status message
예시) HTTP/1.1 404 Not Found

2) 헤더


3) 바디
```

# https

```
https는 http에 secure가 붙은것으로 http의 보안문제를 해결해주는 프로토콜이다.

https는 두 가지 측면에서 http를 보완해준다.
1) 데이터 교환

https는 http와 다르게 클라이언트에서 정보, 데이터를 전달할 때
암호화해서 서버로 전해준다. 따라서, http보다 안전하다.

2) 신뢰할 수 있는 사이트

해당 사이트가 신뢰할 수 있는 사이트인지 검증해준다.

https의 암호화 방식은
대칭키, 비대칭키 방식이 있다.

1) 대칭키

대칭키방식은 클라이언트와 서버가 서로 같은 키를 가지고 
데이터를 암호화, 복호화하는 방식이다.

그런데, 대칭키를 서로 가지려면 어느 한쪽에서는 이 대칭키를
전달해줘야한다. 그렇기에 이 대칭키 자체가 노출될 위험이있다.
이를 해결하기 위해 비대칭키를 사용한다.

2) 비대칭키(공개키)

비대칭키 방식은 이용하고자하는 사이트에서는 비밀키를 가지고 있고,
이와 한 쌍이되는 공개키를 여러개 공개하는 것이다.

예로 A키로 암호화를 하면 B키로만 복호화 할 수 있고,
B키로 암호화하면 A키로만 복화화 할 수 있다.


```

## https - 통신 방식

```
https로 클라이언트와 서버가 통신할 때는
대칭키와 공개키 방식을 혼용해서 사용한다.

클라이언트 서버 통신에 앞서 서버는 CA에서 인증서를 받는다.

CA(Certificate authority)
공인된 기관에서 서버가 믿을 수 있는 서버인지 보증하는 SSL 보증서를 발급한다.

1. 인증

핸드쉐이크
1) 클라이언트는 랜덤데이터를 생성해 서버에 전달
2) 서버도 마찬가지로 랜덤데이터, 해당서버의 인증서를 클라이언트에 전달
3) 클라이언트는 이 인증서를 브라우저에 내장 된 CA로 검증 요청한다.

- CA에 있는 인증서들은 해당 CA의 개인키로 암호화 되어있다.
- 그렇다면 이 CA의 공개키와 CA의 개인키가 일치한다면 이 CA의 공개키로
 인증서를 복호화할 수 있다.

2. 데이터

주고 받는 다량의 데이터를 비대칭키로 암호화,복호화 하는 것은 컴퓨터에 큰 부담을 준다.

따라서, 데이터는 대칭키로 암호화한다.
단, 보완문제를 해결하기 위해 이 대칭키를 교환할 때
비대칭키를 사용한다.

즉, 대칭키, 비대칭키 방식 혼합


* SSL 이라는 보안 프로토콜을 사용한다는 표시다. SSL은 Secure Socket Layer이라는 약자로 보안 소켓 레이어
```

# AJAX

```
비동기적으로
XML이나 JSON과 같은 데이터를 주고 받는 기술

자바스크립트 라이브러리
서버와 클라이언트 단의 비동기적인 소통창구
```

# 이벤트루프

```
자바스크립트 엔진은 Memory heap과 call stack으로 이루어져있다
자바스크립트는 단일 스레드 프로그래밍인데
이 의미는 call stack이 하나라는 이야기다

Memory heap : 메모리 할당이 일어나는 곳
Call Stack : 코드가 실행될 때 쌓이는 곳 stack형태로 쌓임

Web API
브라우저에서


* 콜백함수
다른 함수의 실행이 끝날때까지 특정 코드가 실행되지 않도록 기다려주는 방법
```

https://velog.io/@thms200/Event-Loop-%EC%9D%B4%EB%B2%A4%ED%8A%B8-%EB%A3%A8%ED%94%84

# JS this

```javascript
자바스크립트 this는 호출하는 방법에 따라 달라진다.
호출한놈===this
Global=>window(브라우저)

bind로 묶으면 이 호출하는 놈을 지정할 수 있다.

var someone={
	name : "서광근",
	whoAmI : function{console.log(this);}
}

someone.whoAmI;
var other=someone.whoAmI;
other;
var me=other.bind(someone);
me.whoAmI;

[결과]
서광근
window
서광근
```

# 클로저 / 스코프체인

```
스코프는 함수단위이다
하위스코프는 상위스코프를 참조해나간다.

* 스코프 : 각 함수마다 존재하는 변수들의 집합 (변수명,값의 쌍?)

클로저는 말그대로 값을 가두는 것

결국 클로저는 스코프(각 함수마다 존재, 변수 명들의 집합)를 계속 들고 있는 거 군요?
(원래는 함수 내부에 선언한 변수는 함수가 끝나면 사라지지만, 클로저가 스코프를 계속 들고 있으므로 그 함수 내부의 변수를 참조할 수 있게 됨!)
```

https://mingcoder.me/2020/02/28/Programming/JavaScript/execute-context/

# 실행컨텍스트

```
1. 글로벌 실행 컨텍스트



2. 함수 실행 컨텍스트


*
var 변수 선언과 함수선언문에서만 호이스팅이 일어난다.
var 변수/함수의 선언만 위로 끌어 올려지며, 할당은 끌어 올려지지 않는다.
let/const 변수 선언과 함수표현식에서는 호이스팅이 발생하지 않는다.
```



# 프론트면접

https://sunnykim91.tistory.com/121

# JSON

```
키-값 쌍으로 이루어진 오브젝트를 전달하기 위한 데이터 형식
자료를 주고 받을 때 그 자료를 표현하는 방법

eval() 함수로 파싱

객체 => 중괄호
배열 => 대괄호


{
    "name": "식빵",
    "family": "웰시코기",
    "age": 1,
    "weight": 2.14
}
```

# XML

````
HTML 형식의 자료를 주고 받을 수 있는 형식
XML 파서로 파싱

<dog>
    <name>식빵</name>
    <family>웰시코기<family>
    <age>1</age>
    <weight>2.14</weight>
</dog>
````



# WAS(Web Application Server)

```
1) Web server
 클라이언트 요청을 받아 정적인 데이터를 처리해 반환하거나
 동적인 데이터 요청을 Web Container에 전달한다.


2) Web Container
 JSP, Servlet 구동 환경 제공
 동적인 데이터를 처리하고 Web Server에 반환한다

client => Web Server => Web container
```





# Jvm

```
Java Virtual Machine 자바 가상 머신

java와 OS사이에서 중개자 역할을한다.
그리고 OS에 구애받지 않는다.
가장 중요한 메모리 관리, Garbage Collector를 수행한다.
```

# Garbage Collector

```
자바의 메모리를 관리하기 위한 기술이다.
자바의 메모리 공간은 stack , static , heap 3가지 영역으로 나뉜다.

heap 영역에 적재되는 메모리 중 참조 받지 않는 메모리를 자동으로 해제 하는 역할을 수행한다.
```







osi 7계층 , tcp/ip 4계층



# web.xml / pom.xml / spring.xml

```
@@ web.xml

Web Application의 Deployment Descriptor(환경 파일)로서 XML 형식의 파일

- 웹과 관련된 설정(리스너, 어플리케이션 파라미터, 서블릿 설정, 필터 설정 등)을 담고 있다.
- 클라이언트의 요청이 들어오면 그에 따라 해당 요청을 처리를 할 곳으로 넘겨주고, 그 결과인 서버쪽 응답을 클라이언트에게 넘겨주는 곳 DispatcherServlet을 여기서 설정한다. (load-on-startup을 통해 순서를 정해줄 수 있다.)

* 리스너란?
어떠한 이벤트가 발생하면 호출되어 처리하는 객체

* 서블릿

클라이언트의 요청과 서버의 응답이 이 서블릿을 통해 이루어지게된다.
web.xml에서는 서블릿설정을 spring.xml을 참조하도록했다.
spring.xml에는 디비연결설정이나, 마이바티스, mapper와 같은 설정들이 저장되어있는 파일이다

* 필터
UTF-8과 같이 언어 설정

@@ pom.xml

- 빌드 / 배포와 관련된 모든 설정을 담고 있고 MAVEN이라는 유틸리티에서 메타 정보로 사용하는 설정파일
- 자바 라이브러리를 관리하기 위한 원격 저장소


@@ spring.xml

spring.xml에는 디비연결설저이나, 마이바티스, mapper와 같은 설정들이 저장되어있는 파일이다
```

# DispatcherServlet

```
사용자의 요청을 톰캣과 같은 서블릿컨테이너가 받는데
이때, 제일 앞에서 서버로 들어오는 모든 요청을 처리하는 프론트 컨트롤러이다.

그래서, 공통 처리작업을 DispatcherServlet이 처리한 후 적적한 세부 컨트롤러로 위임한다.

이곳에서 URL 패턴도 지정해준다.
```

## 장점

![image](https://user-images.githubusercontent.com/49560745/100175270-61ff4180-2f11-11eb-9ede-8e4c7ee43bb0.png)

```
Spring MVC는 DispatcherServlet이 등장함에 따라 web.xml의 역할이 축소되었다.
기존에는 web.xml에 모든 서블릿에 대한 url 매핑을 모두 등록해줘야했지만,
이를 DispatcherServlet이 핸들링해주면서 상당히 편리해졌다.
```

* reference - https://mangkyu.tistory.com/18

# git / github

```
git은 버전관리시스템이다.
소스코드를 효율적으로 관리해준다.
언제 수정을 했고, 어떤 수정을 했는지 기록되고, 만약 수정이 잘못되었다면
log를 통해 다시 되돌릴 수 있다.

이처럼 소스코드의 버전을 관리해주는 것을 git이라한다.


github는
git에서 관리한 소스코드들을 저장할 수 있는 또 다른 공간이자 커뮤니티이다.
github에서는 오픈소스들이 자유롭게 공유되고, 세계의 모든 개발자들사이에서
생산적인 일이 이루어진다.
```



# jsp / java bean

```jsp
자바빈이란 자바빈 규격서에 따라 생성된 자바 클래스이다.

쉽게 말해 jsp 페이지의 디자인 부분과 로직부분을 나누어 개발할 수 있도록하는 것이다. 

자바빈 클래스에는 파라미터가 없는 생성자가 반드시 있어야 하며, 클래스 외부에서 필드에 접근할때에는 반드시 메소드를 통하여 접근해야 하며 이때 get, set 으로 시작하는 메소드를이용

1. 자바빈 프로퍼티
프로퍼티는 자바빈에 저장되어 있는 값

2. <jsp:useBean> 태그를 이용한 자바 객체 사용

jsp 페이지의 주요 기능 중 하나는 데이터를 보여주는 기능이다.
ex) 게시판 글 목록보기, 게시판 글 보기 , 게시판 글 읽기

jsp에서는 이런 데이터를 자바빈 클래스에 담아 보내주는게 일반적이다.

<jsp:useBean id="bbs" class="bbs.Bbs" scope="page"/>
<jsp:setProperty name="bbs" property="bbsTitle"/>
<jsp:setProperty name="bbs" property="bbsContent"/>
    
    Bbs 객체를 생성하고, jsp로 넘어온 데이터 순서대로 setProperty를 이용해 값을 설정해준다.

```

## 프로퍼티

```
클래스에 외부에서 접근하려면 반드시 get, set을 이용해야한다.
이때, 이런 메소드를 통해 관리되는 데이터를 프로퍼티라한다.
그리고 setName, getName 에서 set ,get 을 뺀 Name을 프로퍼티 네임이라 부른다.
```



# 클라우드

```
클라우드 컴퓨팅?
서로 다른 물리적인 위치에 있는 컴퓨터들의 리소스를 가상화 기술로 통합해 서비스를 제공하는 것

많은 비용이 발생하는 인프라 구축(여러대의 컴퓨터를 사거나 OS를 구축하는 등)에 필요한 자원이나 시간을 줄일 수 있기에 메인 서비스 개발에 집중할 수 있다는 장점이 있다.

클라우드 서비스는 서비스 제공자가 어느 범위까지 서비스를 관리(제공)하는가에 따라 3가지로 분류된다

1) laas(이에스)

클라우드 제공자가 인프라를 구축해서 서비스를 제공하는 것이다.
사용자는 가상화서버와 그 상위단만 관리하면되기에 많은 비용을 절감할 수 있다.
즉, 하드웨어 자원의 일부를 떼어주는 것

단점이라하면, 가상화서버 하위 단에 접근할 수 없다는 점이다.

2) Paas(패스)

플랫폼이 서비스로 제공되는 것
코드만 짜면된다. 예를 들면 java , node js와 같은 런타임을 미리 깔아놓고, 컴파일도 클라우드에서 해준다.

하지만, 어플리케이션이 플랫폼에 종속되어 다른 플랫폼을 사용할 수 없다는 단점이 있다.

3) Saas(쌔스)

소비 관점에서 제공되는 클라우드 서비스
유튜브나 네이버 오피스 같은 서비스

단점으로는 SaaS의 특성상 반드시 인터넷에 접속할 수 있어야만 사용할 수 있고, 외부의 데이터 노출에 대한 위험이 있다.
```

reference - https://wnsgml972.github.io/network/2018/08/14/network_cloud-computing/

# Spring

## DI

```
* DI(Dependency Injection)
스프링이 내부에 있는 객체들간의 관계를 관리할 때 사용하는 기법

즉, 특정 객체에 필요한 객체를 외부에서 결정해서 연결시키는 것을 의미한다.

모듈간의 결합도가 낮아지고, 유연성이 높아진다.


* 태그

@RequestMapping을 통해 기존 web.xml이 했던 역할을 대신할 수 있다.
@RequestParam을 이용해 <form> 태그에서 POST 방식으로 넘어온 파라미터들을 제어할 수 있다.

@autowired
의존성 자동 주입
- 설정 파일에 의존 객체를 명시하지 않아도 스프링이 필요한 의존 빈 객체를 찾아서 주입해준다.

즉, @Autowired 어노테이션이
적용된 의존 대상은
xml 설정에서 의존 주입 관련 설정을 하지 않아도 된다.
<constructor-arg>태그나
<property> 태그를 사용하지 않아도 된다.

대신, <context:annotation-config> 태그를 추가하면 된다.

Q) 그렇다면 스프링이 어떻게 알아서 처리한다는 것인가?
@Autowired 어노테이션을 사용하면 스프링은 '타입'을 이용해서
의존 대상 객체를 검색한다.
즉, 해당 타입에 할당할 수 있는 빈 객체를 찾아서 주입 대상을 선택한다.

Q) 만약 동일한 타입을 가진 빈 객체가 두개 이상 존재한다면?
같은 타입이 두개 이상일경우
스프링이 어떤 빈을 주입할지 알 수 없어, 스프링 컨테이너를 초기화 하는 과정에서 Exception을 발생시킨다.
```

# IOC

```
Inversion of Control
제어의 역전

메소드나 객체의 호출작업을 개발자가 결정하는 것이 아니라, 외부에서 결정되는 것을 말한다.

서블릿을 개발해서 서버에 배포할 수는 있지만, 배포하고 나서는 개발자가
직접 제어할 수 있는 방법은 없다. 대신 서블릿에 대한 제어 권한을 가진 컨테이너가 적절한 시점에
서블릿 클래스의 객체를 만들고 그 안의 메소드를 호출한다.

개발자는 필요한 부분을 개발해서 끼워 넣기의 형태로 개발하고 실행하게 된다.

이렇게 조립된 코드의 최종 호출은 개발자에 의해서 제어되는 것이 아니라
프레임워크의 내부에서 결정된 대로 이뤄지게되는데
이를 IOC, 제어의 역전이라한다.
```



## AOP

```
횡단관심에 따라 프로그래밍 하는 것

log4j
```



di





빅데이터 하둡

# mvc1 vs mvc2 vs Spring mvc

```
mvc1 패턴

- html코드내에 자바코드가 공존하는 방식
- 간단한 프로그램을 설계하는데 적합하다.
- view와 controller를 한 곳에서 처리하는 것

mvc2 패턴

- view, controller, model을 분리해서 처리하는 것
1. 보여주는 view(JSP페이지), 처리 하는 model(빈,클래스), 제어하는 controller(서블릿)로 확실하게 나뉜다.
2. 구조가 복잡하여 학습이 어렵고 설정 및 작업 분량이 많다.
3. 백엔드와 프론트 엔드가 나뉘어져 분업이 편리하다.

spring mvc


1) 처리요청(URL)
2) HandlerMapping (URL과 매핑되는 컨트롤러 검색)
3) HandlerMapping (URL과 매핑되는 컨트롤러 반환)
4) controller (처리요청)
5) modelAndView 리턴
6) 실행결과 view에 요청
7) 실행결과 리턴
8) 응답생성 출력 요청
9) JSP 생성 후 사용자에게 전달
```

![image](https://user-images.githubusercontent.com/49560745/100300508-83c3fb80-2fd9-11eb-8142-4d10d3072020.png)

reference - https://nickjoit.tistory.com/9

# 자바스크립트

## 자바스크립트의 원시타입

```javascript
string, number, boolean, null, undefined

자바스크립트 변수는 원시타입 값이 그대로 저장된다.(메모리 참조가 아닌 값의 복사)

ex)
// color1의 값을 color2에 저장한다.
var color1 ="red";
var color2 = color1;
console.log(color1); // "red"
console.log(color2); // "red"
color1 = "blue"
console.log(color1); // "blue"
console.log(color2); // "red"

```

## var / let / const

```
scope는 허용범위를 뜻한다.

var(function - scoped)

변수 재선언 가능 , 재할당 가능

let(block - scoped)

변수 재선언 불가, 재할당 가능

const(block - scoped)

변수 재선언, 재할당 불가

* undefined - 변수는 존재하나, 어떠한 값으로 할당되지 않아 자료형이 정해지지 않은 상태

null - 변수는 존재하나, null로 (값이) 할당된 상태
즉, null 자료형이 정해진 상태

* null 은 값이 없다는 뜻, 0조차 아니라는 뜻
```

# async / await / promise / 이벤트 루프

```
promise로 구현된 비동기 처리 함수는
콜백을 예측 가능한 패턴으로 사용하도록 도와주며,
콜백함수 안에서 생성된 프로미스 객체를 활용해 콜백함수가 성공,실패,오류 각각의 경우에 따라 후속 처리를 할 수 있습니다.
순차적이지 않는 비동기함수의 실행순서를 제어할 수 있게 도와줍니다.
콜백패턴에 비해 코드 가독성이 좋고 반환된 결과물을 사용하기 편합니다.
```





db index

db 성능튜닝 

mysql



OS

컴구



# CSS

## # . 의 의미

```
#은 id 값을 선택자로 지정할 때 사용한다.
.은 class 값을 선택자로 지정할 때 사용한다.

 HTML 태그에 고유 식별 번호를 지정해서 개별적인 디자인 효과를 줄 때 사용
```



하둡프로젝트 / javascript / 인성



# Hadoop

````
빅데이터
- 한대의 컴퓨터로는 저장허거나 연산하기 어려운 규모의 거대 데이터

분산
- 여러대의 컴퓨터로 나눠서 일을 처리함

저장
- 데이터를 저장한다

분석
- 데이터가 저장된 컴퓨터에서 데이터를 분석하고 그 결과를 합친다

````

## 네임노드 vs 데이터노드

```
네임노드 : 파일을 쪼개주는 역할, 쪼개진 파일이 어느 데이터 노드에 저장되어있는지 기록

데이터노드 : 쪼개진 파일이 저장되어있는 곳
```

#      Block vs Non-block

# Sync vs Async

|       | Block | Non-Block  |
| ----- | ----- | ---------- |
| Sync  | JAVA  |            |
| Async |       | javascript |

```
제어권의 반환
결과값의 전달


Block vs Non-block
제어권, 반환
제어할 수 없는 대상을 
어떻게 처리하는가?에 대해 논의하는 것

-------------------------------
function 호출자(){         
	functionA();
	
	functionB();
	
	functionC();
}

functionA(){
	/*
		로직
	*/
	return something;
}
-------------------------------
* Block

제어권을 함수 호출/종료에 맞게 순차적으로 넘겨준다.

호출자() => functionA() => functionA()수행, 결과반환 => functionB() => ...=>functionC()

* non-block

함수 호출/종료와 관계없이 제어권을 넘겨준다.

호출자() => functionA() => fucntionA()수행 => functionB() =>functionB()수행 => functionA() 결과 반환 => functionB()결과 반환 => functionC() 수행

Sync vs Async

*Synchronous

함수A()의 끝과 함수B()의 시작을 맞춘다

*ASynchronous

순차적으로 실행이 이루어지지 않는다.

시간
대상들의 시간을
일치시키는가?
```

## 정리

```
* Blocking/NonBlocking

Blocking/NonBlocking은 호출되는 함수가 바로 리턴하느냐 마느냐가 관심사다.

호출된 함수가 바로 리턴해서 호출한 함수에게 제어권을 넘겨주고, 호출한 함수가 다른 일을 할 수 있는 기회를 줄 수 있으면 NonBlocking이다.

그렇지 않고 호출된 함수가 자신의 작업을 모두 마칠 때까지 호출한 함수에게 제어권을 넘겨주지 않고 대기하게 만든다면 Blocking이다.

* Synchronous/Asynchronous

Synchronous/Asynchronous는 호출되는 함수의 작업 완료 여부를 누가 신경쓰냐가 관심사다.

호출되는 함수에게 callback을 전달해서, 호출되는 함수의 작업이 완료되면 호출되는 함수가 전달받은 callback을 실행하고, 호출하는 함수는 작업 완료 여부를 신경쓰지 않으면 Asynchronous다.
```





8대 정렬

알고리즘

자료구조

OS/컴구

OSI 7계층 TCP/IP 4계층

DB

네트워크





자바 Primitive type  vs reference type

#    

#     

#     

#     

# * 인성

# 지원한 이유에 대해 말씀해주세요

```

자체서비스



AI 역량검사
채용플랫폼
인사관리시스템
언택트면접
```



# 지원한 직무에서 지원자가 수행해야하는 주요 역할은 무엇인가?

````
유관부서의 요구사항을 이끌어내야하고, 요구사항을 sw 관점에서 설계해야하고, sw를 버그나 성능 저하 없이 만들어야하는
역할들을 수행한다고 생각합니다. 

A라는 역할을 수행해 회사에 간접적으로 ~한 영향을
회사를 더 좋아지게 하는 역할
````

# 해당 역할을 수행하면서 필요한 지식은 무엇이라 생각하고, 지원자는 어떠한 준비를 하였는지?

```

```

# 지원직무에 필요한 기술적인 역량이나, 유사 경험에서 성과를 얻은 경험이 있는지?

```
지원직무에서 어떠한 유사 접점을 만들 수 있느냐
```

# 지원직무를 잘 수행할 수 있는 본인만의 강점이 있다면 무엇인가?

```

```

# 가장 부족한 점은 무엇인가?

```
CS 지식
CS지식이 이 직무에서 ~에 활용되는데 이 점이 좀 부족하다
이를 채워나가고 있다
```

# 인재상/핵심가치 중에 가장 자신 있는 부분과 그 이유는?

````

````

# 정직/원칙준수를 잘했던 경험이 있다면?

```

```

# 소통과 협력으로 가장 좋은 성과를 얻은 경험은?

```
주장
이유/근거
사례
재주장



```

# 해결하기 어려웠던 문제를 자신만의 방법으로 해결했던 경험?

````

````

# 윗사람이 이야기하는 본인의 장단점?

```

```

# 최근 관심있는 사회이슈와 그 이슈에 대한 본인의 견해는 무엇인가?

```

```

# 입사 후 어떠한 위치까지 올라가고 싶은지?

```

```



