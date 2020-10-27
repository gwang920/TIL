# Class, Object, Instance

## 1. class

```
자바스크립트에서 class를 사실상 함수라고 보는 느낌이 강하다.
단순히 동일한 기능을 하는 함수와 변수를 모아놓은 것이기에 그런 것 같기도하다.
쉽게말해, 함수의 상위 범위라고 할 수 있을 것 같다.

회사라는 class 안에 개발부서,인사부서,총무부서라는 함수(?)가 존재한다라고 표현해도 될지 모르겠다.
함수가 기능 단위의 코드를 그룹화한다면, class는 객체 단위의 함수와 변수를 그룹화한다.

그렇다면 class를 왜 사용하나?

class는 중복코드를 제거하고, 코드의 재사용성을 높이기 위함이다.
붕어빵틀에 붕어빵을 찍어내듯이 class라는 틀을 재사용해 자신만의 특징을 가진 객체를
생성해낼 수 있다. 코드의 유지보수성을 높이고, 코드의 구조화를 위해 클래스를 사용하는 느낌이다.

함수와 class의 특징적인 차이점은 hoisting 적용 여부이다.
(그 이외에도 상속,오버라이딩 등이 있지만)
함수와 다르게 class는 hoisting이 되지 않아 class를 선언하기전에
먼저 호출하면 Reference Error를 던진다.

Class는 함수를 함수 표현식과 함수 선언으로 정의 할 수 있듯이
class표현식, class선언 두 가지 방법으로 class를 정의할 수 있다.
```

## class 표현식

```
class 표현식은 이름을 가질 수도 갖지 않을 수 도 있다.
아래 예제를 보자.
```

```javascript
// unnamed
let unnamed = class {
  constructor(age, job) {
    this.age = age;
    this.job = job;
  }
};
console.log(unnamed.name);
//output : "Rectangle"


// named
let named = class myname {
  constructor(age, job) {
    this.age = age;
    this.job = job;
  }
};
console.log(named.name);
//output: "myname"
```

## class 선언

```
class 선언은 class 키워드와 함께 사용해야한다.
```

```javascript
class Rectangle {
  constructor(height, width) {
    this.height = height;
    this.width = width;
  }
}
```

## 2. object

```javascript
객체는 데이터와 함수의 집합이다.
원시타입을 제외한 나머지 값들을 모두 객체이다.
자바스크립트내에서 객체는 키와 값으로 구성된 프로퍼티들의 집합이다.

var person={
	name:'seo',
	age:29,
	job:'programmer',
	sayHello:function(){
		console.log("Hi My job is"+this.name);
	}
}

위 코드에서 person이 객체라 할 수 있다.
```

## 3. instance

```javascript
인스턴스는 객체로부터 실체화 된 대상이다.

계산기라는 객체를 실체화하기 위해 caculator라는 class를 활용할 수 있다.
calc1과 calc2가 인스턴스라 할 수 있다.


class calculator{
    constructor(a,b){
        this.a=a;
        this.b=b;
    }

    sum(){
        console.log(this.a+this.b);
    }
    avg(){
        console.log((this.a+this.b)/2);
    }
}

var calc1=new calculator(10,20);
calc1.sum();
var calc2=new calculator(20,30);
calc2.sum();
```



## class VS object VS instance

```
class는 설계도, object는 소프트웨어로 구현해야할 대상, instance는 object가 실체화된 것이라 할 수 있다.

커피숍이라는 객체를 구현한다고 생각해보자.
커피숍에는 커피숍이라는 객체 뿐만 아니라 메뉴판, 바리스타, 커피메뉴, 손님과 같이 커피숍안에 존재하는 모든 것들이 객체가 될 수 있다.

클래스는 이러한 객체들을 구현하기 위한 설계도이다.
메뉴판에는 메뉴와 가격이 존재해야할 것이고, 바리스타는 손님과 상호작용해야한다.
이러한 모든 것들을 설계하기 위한 틀이 클래스이다.

인스턴스는 커피숍을 객체라할 때 이 커피숍이 실체화 되는 것을 말한다.
커피숍 - 스타벅스
[객체]  [인스턴스]

정도로 표현하면 될 것 같다.

```

* 참고 - https://cerulean85.tistory.com/149

