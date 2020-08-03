# Class와 Prototype

## 1. class VS prototype

```
오늘 자바스크립트에서 class를 사용해봤는데 사실상 클래스는 함수라고한다.
(ES6에서 class가 생기긴 했지만 이는 사실 함수이며 프로토타입 기반의 syntatic sugar다.)

자바스크립트는 java나 c++과 같이 객체지향언어이지만 class 기반의 언어가 아니다.
최근에 class 기능이 추가된것이지 자바스크립트가 class 기반의 언어로 바뀌었다는 것을 의미하지 않는다.
즉, 자바스크립트는 프로토타입 기반의 객체지향언어라고 할 수 있다.

그렇다면 prototype을 알아보자
```

```javascript
아래 코드에서 blackDuck과 whiteDuck은
각각 2개의 wings와 mouse를 가지며 메모리에는 총 4개가 할당된다.
만일 객체를 10000개를 만든다하면 40000개의 변수가 메모리상에 할당되는 것이다.

이러한 문제점을 해결하기 위해 프로토타입을 사용한다.
-----------------------------------------------------------------------------------------
function Duck() {
  this.wings = 2;
  this.mouse = 1;
}
var blackDuck  = new Duck();
var whiteDuck = new Duck();
console.log(blackDuck.eyes);  
console.log(blackDuck.nose);  
console.log(whiteDuck.eyes); 
console.log(whiteDuck.nose); 

[결과]
2
1
2
1
```

```javascript

아래는 위 코드를 프로토타입을 사용해 재구현한 것이다.
간단히 보면 Duck.prototype 이라는 빈 객체가 존재한다.
이 빈객체에 값(wings,mouse)를 할당하고,
blackDuck,whiteDuck은 어딘가에 있는 이 객체에 접근해
값들을 가져와 사용할 수 있다.
-----------------------------------------------------------------------------------------
function Duck(){}

Duck.prototype.wings=2;
Duck.prototype.mouse=1;

var blackDuck=new Duck();
var whiteDuck=new Duck();

console.log(blackDuck.wings);
console.log(blackDuck.mouse);

[결과]
2
1
```

## 2. 프로토타입을 왜 사용하나?

```
속성을 자유롭게 추가하고 삭제할 수 있기 때문이다.
그리고 이 프로토타입을 통해 상속을 흉내낼 수 있다.
```

-  참고 - [https://medium.com/@bluesh55/javascript-prototype-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-f8e67c286b67](https://medium.com/@bluesh55/javascript-prototype-이해하기-f8e67c286b67)
- 프로토타입의 구조를 함수 생성에 빗대어 풀어쓴 글을 참고했다.



## 자바스크립트 vs JAVA,C++ [  프로토타입, 클래스 ]

```
자바스크립트는 C++ 과 Java 가 가지고 있는 전통적인 객체지향 컨셉과는 약간의 차이점을 가지
고 있다 . 이 점에 대해서 확실히 이해하려면 방금 설명한 클래스 개념이 사실은 자바스크립트에서 존재
하지 않는다 는 사실 을 받아들 여야 한다 . 다시 말해 자바스크립트에서 모든 것들은 객체에 기반하고 있다
는 사실이다 . 

자바스크립트에서는 원형 Prototype 이라는 표기법이 있는데 , 이를 이용해서 객체가 생성되게
된다 . 

하나의 예를 들자면 , 전통적인 객체 지향 컨셉에서는 「 박지성이라고 불리는 새로운 객체를 축구
선수라는 클래스를 이용하여 생성한다 」 라는 개념이 자바스크립트와 같은 원형 적 Prototypal 객체 지향 언어
에서는 「 축구 선수라는 객체를 재사용하여 이것을 하나의 원형으로서 밑바탕에 깔고 박지성이라고 불
리는 새로운 객체를 생성한다 」 라는 개념으로 조금은 바뀌어 설명될 수 있는 것이다.

조금 더 이해를 돕기 위한 예로써 붕어빵을 만든다고 해보자 . 
전통적인 객체지향 컨셉에서는 붕어빵을 만들기 위한 틀을 클래스 개념으로 볼 수 있다. 
이 틀이 붕어빵의 모 양과 크기 등과 같은 특성을 결정한다. 
이 틀과 적당한 재료만 있으면 우리는 똑같은 붕어빵을 만들어낼 수 있다. 
하지만 자바스크립트의 원형적 객체 지향 언어에서는 붕어빵 틀이 따로 존재하지 않는다. 
어디선가 구한 붕어빵을 가지고 붕어빵 장수를 찾아가 이 붕어빵과 똑같은 붕어빵을 만들어 달라고 할 뿐이다
```

