# 상속과 다형성

## 상속

```
상속이란 부모의 속성을 그대로 물려받는 것을 말한다.
단순히, 물려받는 것에서 더 나아가 새로운 속성을 추가해 자식만의 특성을 가질 수 있게한다.
```



```javascript
Dog이라는 부모클래스로부터 bark속성을 상속받고,
BlackDog만의 특징인 running을 정의한코드이다.

-----------------------------------------------------------------------------------------
function Dog(){}

Dog.prototype.bark=function(){
    console.log("barking");
}

function BlackDog(){}

BlackDog.prototype=new Dog();
BlackDog.prototype.run=function(){
    console.log("running");
}

var blackDog=new BlackDog();
blackDog.bark();
blackDog.run(); 

[결과]
barking
running
```



## 다형성

```
다형성(polymorphism)은 poly(많은) + morph(형태)의 합성어로 
단어 그대로 해석하면 많은 형태를 가질 수 있는 능력을 말한다.

다형성은 하나의 추상 인터페이스에 대해 코드를 작성하고 이 추상 인터페이스에 대해 서로 다른 구현을
연결할 수 있는 능력으로 정의된다.

즉, 하나의 추상 인터페이스를 설계하고, 이를 다양한 방식으로 구현하는 것(?)이라 할 수 있다.
선언부분(인터페이스)와 구현부분은 1:N의 다형성 관계가 형성된다.

다형성이 직관적으로 이해되지 않아 하나의 예시를 가져왔다.(참고 - https://webclub.tistory.com/406)

USB와 USB와 연결되는 기기들이 있다.
모든 USB기기들은 USB의 규격에 맞춰 만들어져 있고, 이 규격에 적합하다면 어떤 USB기기든 연결가능하다.
이때 USB와 USB기기들의 관계가 설계와 구현 (1:N)의 관계를 맺는다고 볼 수 있다.
```

