# super & this

## 1. super

```
super 키워드는 부모 오브젝트 함수를 호출할 때 사용된다.

super 키워드는 super() , super.메소드 두 가지 방식으로 선언할 수 있다.
super()는 부모의 생성자를 가져오는 역할을 하고
super.메소드는 부모의 메소드를 가져올 때 사용한다.
```

```javascript
class Cat { 
    constructor(name) {
      this.name = name;
    }
    
    speak() {
      console.log(this.name + ' 야옹 ');
    }
  }
  
  class Tiger extends Cat {
    speak() {
      super.speak();
      console.log(this.name + ' 어흥.');
    }
  }

  var nTiger=new Tiger("백호");
  nTiger.speak();

[결과]
백호 야옹
백호 어흥.
```

```javascript
우선 constructor에서 super키워드로 name,size,age를 받아오고 
Tiger의 특징으로 color를 삽입했다.

nameColor() 에는 Cat으로부터 가져온 name과 Color를 합쳐 리턴해주고있다.

super를 사용하는 이유는 재사용성이다.
만일 부모 클래스의 속성 혹은 기능에 추가적인 무언가를 넣어주어 활용할 때
다시 부모 클래스의 코드를 사용해야하는 중복이 발생한다.
부모 클래스의 속성이 만줄의 코드를 갖는다면 엄청난 비효율이 발생하지 않을까?
-----------------------------------------------------------------------------------------
class Cat{
    constructor(name,size,age){
        this.name=name;
        this.size=size;
        this.age=age;
    }

    name(){
        return this.name;
    }

    barking(){
        return this.first+this.second;
    }
}

class Tiger extends Cat{
    constructor(name,size,age,color){
        super(name,size,age);
        this.color=color;
    }

    nameColor(){
        return super.name()+this.color;
    }

    run(){
        return this.name+"running";
    }
}

var nTiger=new Tiger("백호","250kg","13","red");
console.log(nTiger.nameColor());
console.log(nTiger.run());

[출력]
백호red
백호running
```

## 2. this

```
this는 해당 메서드를 호출한 객체로 바인딩된다.
(이외에도 자바스크립트의 this키워드는 다양한 상황에 따라 다른 값을 나타낸다.)

this가 만들어지는 경우,

1. 일반 함수에서 this -> window
 
  기본적으로 this에는 전역객체인 window가 저장된다.
  
2. 중첩 함수에서 this -> window

  중첩함수도 특별한 조치(?)를 해주지 않는 이상 this는 전역객체인 window가 저장된다.
  
3. 이벤트에서 this -> 이벤트 객체

	이벤트리스너에서는 this는 이벤트를 발생시킨 객체가 된다.
 
4. 메소드에서 this -> 메소드 객체

    this는 해당 메서드를 호출한 객체로 바인딩된다.
 
5. 메소드 내부의 중첩 함수에서 this -> window

	2번과 같이 특별한 조치(?)를 해주지 않는 이상 중첩함수내의 this는 전역객체 window가 저장된다.
	
출처: https://beomy.tistory.com/6 [beomy]
```

```javascript
var myobject={
    name:'foo',
    sayName:function(){
        console.log(this.name);
    }
};

var otherobject={
    name:'bar'
};

otherobject.sayName=myobject.sayName;

myobject.sayName();
otherobject.sayName();

[결과]
foo
bar
```

## 3. super vs this

```
super키워드는 부모클래스의 메소드를 가져오기 위해 사용한다.
this는 키워드가 속한 객체를 호출한 놈(?)의 객체에게 바인딩된다. 
```

