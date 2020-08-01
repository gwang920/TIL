

# 객체

```
객체는 관련된 데이터와 함수(일반적으로 여러 데이터와 함수로 이루어지는데, 객체 안에 있을 때는 보통 프로퍼티와 메소드라 부른다.)

객체는 여러 속성을 하나의 변수에 저장할 수 있도록 해주는 데이터 타입으로 key/value 쌍을 저장할 수 있는 구조이다.
```

- 객체의 특징

```javascript
- 객체는 변수이다. 그러나 객체에는 많은 값이 포함될 수 있다.(단일 값도 포함 가능)
- 객체는 중괄호 표기를 이용하여 만든다.
- 객체는 각각의 key/value에 대한 정보를 나열할 수 있다.
- key는 문자열 또는 기호여야 한다.
- value는 모든 유형이 될 수 있다.
- 객체에서 명명된 값을 'Properties'라고 한다.
- 객체 변수를 복사하면 참조가 복사되고 객체가 복사되지 않는다.

let user = { name: "John" };
let admin = user; // copy the reference


자바스크립트에서 원시값을 제외한 모든 값이 객체이다.

* 기본데이터 형식 : 원시 값을 갖는 데이터
아래는 객체가 아닌 기본 데이터 유형이다.

String
number
boolean
null
undefined
```

- 객체를 생성하는 것은 변수를 정의하고 초기화하는 것으로 시작한다.

```javascript
var person={};
var person= new Object();
```

- 객체에 포함된 데이터와 함수를 출력해보자.

[예제]

```javascript
var person = {
  name: ['Bob', 'Smith'],
  age: 32,
  gender: 'male',
  interests: ['music', 'skiing'],
  bio: function() {
    alert(this.name[0] + ' ' + this.name[1] + ' is ' + this.age + ' years old. He likes ' + this.interests[0] + ' and ' + this.interests[1] + '.');
  },
  greeting: function() {
    alert('Hi! I\'m ' + this.name[0] + '.');
  }
};


[실행결과]
person.bio()
=> Bob Smith is 32 years old. He likes music and skiing.

person.greeting()
=> Hi! I'm Bob.
```

- 객체는 각기 다른 이름을 갖는 복수개의 멤버로 구성된다.
- [이름과 값] 한 쌍의 값은 ',' 로 구분되고, 이름과 값은 ':' 로 분리된다.



## 프로퍼티

```javascript
프로퍼티는 객체의 속성을 나타내는 이름과 활용 가능한 값을 가지는 특별한 형태이다. 
특정객체가 가지고 있는 정보를 품고 있어 "그 객체가 가진 정보에 직접적으로 접근"할 수 있게 해준다.

프로퍼티라는 용어를 잘 모르고있었는데 프로퍼티는 아래 예제에서 확인해보자.
```

```javascript
var foo={}; // foo 객체 생성.
foo.a=1; // .연산자를 이용하여 a라는 이름의 프로퍼티를 생성하면서 1이라는 값을 할당
var sum = foo.a+10; // .연산자를 이용하여 foo 객체의 a프로퍼티에 접근하여 값을 활용가능
console.log(sum);
> 11


프로퍼티의 정의를 위 예제에서 모두 확인할 수 있다.
1) 객체의 속성을 나타내는 이름과 값을 가짐
2) 객체에 접근하여 값을 활용하게 해줌
```

- 프로퍼티 추가 시 , 주의할 점

```javascript
1. 프로퍼티에 값을 할당하지 않는 경우

"일반 변수"는 값을 할당하지 않고 프로퍼티만 선언할 경우 자동으로 undefined를 할당한다.
"프로퍼티"는 어떤 정보도 할당받지 않으면 존재이유가 없기에 syntax error가 발생한다.

2. 프로퍼티의 삭제

프로퍼티는 undefined, null을 할당한다고 해서 삭제되지 않기에 반드시 delete 키워드를 사용한다.
```

```javascript
let user={name:"jone"};

user.age=30;
user.age=null;
console.log(user.age);

delete user.age;
console.log(user.age);

{ name: 'jone' }
null
undefined
```

## 객체 생성 방법

### 1. 객체 리터럴 사용

```javascript
var person = {
	firstName:"John",
	lastName:"Doe",
	age:50,
	eyeColor:"blue"
};
```

### 2. new 키워드로 단일 객체 정의

```javascript
var person = new Object();
person.firstName = "John";
person.lastName = "Doe";
person.age = 50;
person.eyeColor = "blue";
```

## this 키워드

```
this 키워드는 지금 동작하고 있는 코드를 가지고 있는 객체를 가리킨다.
```

```javascript
var person1 = {
  name: 'Chris',
  greeting: function() {
    alert('Hi! I\'m ' + this.name + '.');
  }
}

var person2 = {
  name: 'Brian',
  greeting: function() {
    alert('Hi! I\'m ' + this.name + '.');
  }

person1.greeting() => "Hi! I'm Chris."
person2.greeting() => "Hi! I'm Brian."
```





# * Object vs Map

```
Object의 경우 데이터가 순차적으로 적재되지 않는다. 
브라우저는 Object에서 set활동이 일어나면 아무곳에 공간을 만들어서 값을 넣어버린다.

Map은 key-value 형식으로 구성되어 있으며 순차적으로 데이터를 적재한다. 
여기서 발생되는 추가적인 활동(데이터 재배치, 정렬 등) 이 set 처리에 대해 일부 성능저하를 발생시킨다.

단순 처리에 사용한 데이터는 90만건이며 90만번의 루프를 통해서 
Map의 set이 Object의 set보다 약 2배정도 성능이 느린것으로 확인되었다. 
반대로 get으로 정보를 조회하면 Map이 Object보다 10배에 가까운 성능을 발휘하고 있었다.


쉽게 말해

많은 데이터 갱신과 적은 데이터 출력 Object>Map
적은 데이터 갱신과 많은 데이터 출력 Object<<<<<<Map

이라고 할 수 있다.
```

[https://medium.com/@wdjty326/javascript-es6-map-vs-object-performance-%EB%B9%84%EA%B5%90-7f98e30bf6c8](https://medium.com/@wdjty326/javascript-es6-map-vs-object-performance-비교-7f98e30bf6c8)