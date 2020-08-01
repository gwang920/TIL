# Javascript

## I. var / let / const 차이

### var 는 'function - scoped' 이고, 

### let, const는 'block - scoped' 이다.

```
일단 scope 라는 것은 '허용범위'를 뜻한다.
즉, global - scope는 전역변수 scope, local - scpoe는 지역변수 scope를 뜻한다.
자바스크립트에서는 선언된 변수가 어디까지 허용되는 범위에 따라 fucntion scoped 와 block scoped로 나뉜다.

- block scoped는 일반적으로 다른 프로그래밍 언어에서 사용하는 방식과 같다.
변수의 허용범위를 블록단위로 보는 것이다.

- 그와 반대로 function scoped는 변수의 허용범위를 함수단위로 보는 것이다.

예시로 살펴보자.
```

#### 1. var (function - scoped)

```xml
var이 function - scpoed 특성을 갖는 이유는 hoisting 때문이라 할 수 있다.

(var는 4 가지의 특징을 갖는다. 
1. fucntion - scoped
2. 변수 명 중복
3. var 생략
4. 렉시컬
천천히 정리할 예정이다.)

우선 hoisting이 무엇인지 알아보자.
hoisting이라는 단어를 직역하면 끌어올리기, 들어 올려 나르기라는 뜻이 된다.
Javascript에서 호이스팅도 비슷한 의미를 갖는다.
간단하게 호이스팅을 '변수 선언문을 끌어올린다'는 뜻으로 이해하면 편하다.
호이스팅을 예제로 알아보자
```

- Hoisting 예제

```javascript
[예제 1]

fucntion hoistingEx(){
    // 이 위치로 hoisting 된다.
	console.log("value="+value);
	var value = 10;
	console.log("value="+value);
}
hoistingEx();

[실행결과]
value=undefined
value=10

-----------------------------------------------------------------------------------------
 위 코드에서 hoistingEx 안에서 변수 value의 호출이 두번 일어난다.
 이때 다른 프로그래밍언어였다면 value 가 선언문 이전에 호출되었기에 Error가 발생한다.
 하지만, Javascript의 경우 호이스팅이 됨으로써 [실행결과]와 같이 구동된다.
 
 즉, 호이스팅으로 인해 변수 선언문이 유효범위안의 제일 상단부로 끌어올려지고,
     선언문이 있던 자리에서 초기화가 되는 것이다. 따라서 위와 같은 결과를 갖게 된다.

-----------------------------------------------------------------------------------------
[예제 2]

var value=30;
fucntion hoistingEx(){
    // 이 위치로 hoisting 된다.(지역변수)
	console.log("value="+value);
	var value = 10;
	console.log("value="+value);
}
hoistingEx();

[실행결과]
value=undefined
vlaue=10
-----------------------------------------------------------------------------------------
 호이스팅을 알기전까지 이 예제코드에서 첫 번째 호출되는 value는 전역변수 value(=30)이 참조되는 줄 알았다. 첫 호출 value는 호이스팅에의해 지역변수를 참조하게 되는 것이다.
 
 따라서, 위와 같은 실행결과를 갖는다.


-----------------------------------------------------------------------------------------
 * undefined
undefiend : 변수는 존재하나, 어떠한 값으로도 할당되지 않아 자료형이 정해지지(undefined) 않은 상태
null : 변수는 존재하나, null 로 (값이) 할당된 상태. 즉 null은 자료형이 정해진(defined) 상태
    
var var1; //undefined (어떤 값도 할당되지 않아서 자료형을 알 수 없음)
var var2 = null; //null (null로 (값이) 할당되어서 자료형을 알 수 있음 - null의 자료형은 object다.)
```

```
위의 예제 처럼 함수 내에서 모든 변수가 '유효범위를 갖는 것'을 function scoped라 할 수 있다.

또 다른 예제를 살펴보자
```

```javascript
function scopeTest(){
	var a=0;
	if(true){
		var b=0;
		for(var c=0;c<5;c++){
			console.log("c="+c);
		}
		console.log("c="+c);
	}
	console.log("b="+b);
}

scopeTest();

[실행결과]
c=0;
c=1;
c=2;
c=3;
c=4;   // for문 종료
c=5;   // 마지막 증가문(c++) 에 의해 증가된 값.
b=0;

-----------------------------------------------------------------------------------------
위 예제는 function scoped의 특성을 잘보여주는 예시이다.
if , for문의 중괄호 범위를 벗어나더라도 함수 이내에 존재하는 모든 변수를 참조할 수 있다.
즉, a,b,c 모두 같은 유효범위를 갖으며, 함수 내에서 전역변수(?) 역할을 한다.
```

#### 2. let, const (block - scoped)

```javascript

javascript는 var만 존재했기에 아래와 같은 문제가 있었다.

-----------------------------------------------------------------------------------------
// 이미 만들어진 변수를 선언해도 에러가 발생하지 않음
var a='test';
var a='test2';

// hoisting에 의해 referenceError가 발생하지 않음
b='test';
var b;
-----------------------------------------------------------------------------------------

위의 문제점을 보완하는 것이 let과 const라 할 수 있다.

이 둘의 공통점은 var과는 다르게 '변수 재선언 불가능'이다.

그리고 이 둘의 차이점은 변수의 'immutable'여부이다.

let은 변수에 재할당이 가능하지만,
const는 변수 재선언, 재할당이 모두 불가하다.

예제로 살펴보자.
```

```javascript
[예제 1]

// let
let a='test';
let a='test2'; // Uncaught SyntaxError
a='test3' // 가능

// const
const b='test';
const b='test2'; // Uncaught SyntaxError
b='test3';  // Uncaught TypeError
```

```javascript
위 예제로 let, const의 차이점을 확인할 수 있다.

그렇다면 let, const는 hoisting이 불가능한 것인가?
그렇지 않다.

let, const는 block - scoped 단위로 hoisting이 일어난다.

-----------------------------------------------------------------------------------------
// tdz(Temporal dead zone)에 의해 Reference Error 발생
// let은 block -scoped에 의해 값이 할당되기전에 변수가 선언되어야 한다.
c='test'; // Reference Error
let c;

// let은 선언하고 나중에 값 할당 가능
let d;
d='test'; // 가능

// const는 선언과 동시에 할당해야함.
const a; // Missing initializer
-----------------------------------------------------------------------------------------

* TDZ란?
    
변수 선언 이전에 변수를 참조하는 영역
쉽게 말해 초기화되지 않은 변수가 있는 곳

변수가 초기화 되는 순간 TDZ에서 나오게 되며 변수를 사용할 수 있게 된다.

```







