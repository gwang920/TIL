# 기술면접

##  환경

###   1. 플랫폼, 라이브러리, 프레임워크, API의 차이점

```
플랫폼 - 프로그램의 실행 환경이고,
라이브러리 - 프로그램 제작 시 필요하거나 자주 사용되는 기능을 모아놓은 것
프레임워크 - 프로그램의 기본 구조로서 그 자체만으로는 움직이지 않으나	 필요한 기능을 한데 모아 구축해놓은 것
API - 라이브러리와 같이 함수의 집합이라 말할 수 있지만 더욱 포괄적으로 그 함수들에 대한 명세까지 포함하고 있다.
```



##  언어

###   1. java언어의 특징은 무엇인가

```
- 객체지향 프로그래밍 언어
- jvm에 의해 운영체제 없이 독립적으로 작동하므로 이식성이 높은 언어이다.
- Garbage Collector에 의해 자동적인 메모리 관리가 가능하다.
- 기본자료형을 제외하고 모든 요소가 객체로 표현된다.
- 다중 동기화(Multi - Thread)를 지원한다.
* Garbage Collector : 메모리 관리 기법 중의 하나로, 프로그램이 동적으로 할당했던 메모리 영역 중에서 필요없게 된 영역을 해제하는 기능
```

### 2. java의 DataType

```
Primitive type(기본형) - 스택 메모리 영역에 실제 값을 저장하는 데이터 타입
Reference type(참조형) - 힙 메모리 영역에 실제 값을, 스택에는 메모리 주소를 저장한다. new로 정의한다.
```





 ## 개념

  ### 1. JDK, SDK 차이점은 무엇인가

```
SDK는 다양한 언어로 소프트웨어를 작성할 수 있도록 지원하는 일반적인 번들
JDK는 JAVA언어로 소프트웨어를 개발하는데 필요한 특정 번들로 모든 java 표준 api를 지원한다.

* 개발키트(번들) - 소프트웨어 개발 키트는 일반적으로 소프트웨어 기술자가 사용하여 특정한 소프트웨어 꾸러미, 소프트웨어 프레임워크, 하드웨어 플랫폼, 컴퓨터 시스템, 게임기, 운영 체제 등을 위한 응용 프로그램 등을 만들 수 있게 해주는 개발 도구의 집합
```



### 2. OOP의 특징에 대해 설명하시오

```
OOP는 객체의 관점에서 프로그래밍 하는 것을 의미합니다.
C언어를 절차 지향 프로그래밍이라 하는데, 절차 지향 프로그래밍은 프로세스가 함수 단위로 순서대로 진행되는 것을 말합니다.

반면 OOP는 객체들의 유기적인 관계를 통해서 프로세스가 진행됩니다.
즉, 애플리케이션을 구성하는 요소들을 객체로 바라보고, 객체들을 유기적으로 연결하여 프로그래밍 하는 것을 말합니다.


```



### 3. 인터페이스 vs 추상클래스

| 인터페이스 [has a]                                           | 추상 클래스 [is a]                                           |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 클래스가 아니다                                              | 클래스다                                                     |
| 클래스와 관련이 없다                                         | 클래스와 관련이 있다(주로 베이스 클래스로 사용)              |
| 한 개의 클래스에 여러 개를 사용할 수 있다 (implements - 구현) | 한 개의 클래스에 여러 개를 사용할 수 없다.  (extends - 상속) |
| 구현 객체의 같은 동작을 보장하기 위한 목적                                                   * 문 - 열다, 닫다                                                                                                  => 상속(동물 울음, 행동)과는 다르게 열다, 닫다에 부여할 특정 속성이 없다. 즉, 같은 동작을 보장해야만 한다. | 상속을 받아서 기능을 확장시키는 데 목적                                                      * 동물 - 울음, 행동                                        ex. 호랑이 - 어흥, 염소 - 음메 |



```
* 참고

추상화 vs 인터페이스
https://commin.tistory.com/106
추상화, 인터페이스 사용 이유
https://marobiana.tistory.com/58

추상클래스는 구체화 시킬 구현체를 추상화시키는 기법이며 인터페이스는 구현할 컴포넌트의 표준을 정하는 것입니다.
(헤드퍼스트 디자인패턴에 보면 추상클래스를 사용하는 것보다 인터페이스로서 구현하는 것을 추천하고 있고 실제로도 그렇게 구현을 하는것이 유연성이 있다고 합니다.)

어떠한 인터페이스를 구현한 객체에 대해서 동일한 동작을 보장한다


```

- 추상클래스 보충

```

어미고양이(부모클래스) - 야생고양이

  - 자는법 (메소드) 
  - 집에서 사는법 (추상화 메소드)

새끼고양이(자식클래스) - 집고양이

  - 자는법 (메소드)
  - 집에서 사는법 (메소드)
----------------------------------------
어미고양이는 야생고양이기에 집에서 사는법을 모른다. 그렇기 때문에 추상화 메소드를 만든다. (대신 구현은 하지 않음)

어미고양이는 자는법이 있었고, 자식에게 전수하였다.
그러나 자식은 집고양이라 어미고양이와 자는법이 달랐다.

그래서 자식고양이 나름대로 자는법을 새로 터득하였다.
그게 이미 구현되어있는 부모클래스의 내용을 Override를 하는 것이다.

새끼고양이는 집 생활을 하며, 어미고양이가 모르는, 집에 사는법을 더 많이 터득하였다.
(부모 클래스보다 더 많이 구현되는 경우가 대부분이다)

출처: https://marobiana.tistory.com/58 [Take Action]
```



### 4. object에 대해 설명하시오.

```
실세계의 객체는 상태와 행동을 가진다. 소프트웨어 객체는 실세계 객체를 바탕으로 모델링 된다.
Object(객체)는 저장 공간에 할당되어 값을 가지거나 식별자에 의해 참조되는 공간을 의미하며 변수, 자료구조, 함수 또는 메소드가 될 수 있다. 프로그래밍 언어는 변수를 이용해 객체에 접근하므로 메모리 할당 전까지는 객체는 존재하지 않는다.

즉, OOP에서 객체는 클래스의 Instance(값)로 데이터(변수)와 데이터에 관련되는 동작(함수)이다.
절차, 방법, 기능을 모두 포함한 개념으로 변수들과 그와 관련된 메소드들이 모여 이룬 하나의 꾸러미
```

### 5. Class, Object, Instance 차이

```java
- 클래스 

객체를 만들어 내기 위한 설계도 
맴버 변수와 메서드 들의 집합

* 참고
- java내에서 파일명.java와 public class 클래스이름 에서 파일명==클래스이름이 되어야 한다.
- 자바 파일명과 public class의 클래스 명은 일치해야함
- 한 파일 내에 클래스가 여러 개 있을 수 있는데, public class는 하나만 존재할 수 있으며, 파일명과 같아야 함

- 오브젝트

소프트웨어 세계에 구현할 대상
'Class 의 Instance' 라고 부름

- 인스턴스

설계도(class)를 바탕으로 소프트웨어 세계에 구현된 구체적인 실체
객체를 소프트웨어에 실체화 하며 '인스턴스' 라고 부르고 실체화된 인스턴스는 메모리에 할당 된다.
'~의 인스턴스' 라는 관계를 가질때 사용한다 (객체는 클래스의 인스턴스다)
인스턴스는 원본으로부터 생성된 복제본을 뜻함


- 클래스 vs 오브젝트
클래스는 객체를 만들어 내기 위한 설계도 이고 객체는 클래스로 구현한 실체된 대상 이다.

- 오브젝트 vs 인스턴스
클래스의 타입으로 선언 한것을 객체라 하고, 그 객체가 메모리에 할당 되어질때(new) 인스턴스 라고 한다.
객체는 현실세계에 가깝고, 인스턴스는 관계의 초점에 가까운 개념 (객체는 클래스의 인스턴스)

* 참고
public class Main{  // 클래스
	static final String name ="seo";
	
	public static void main(String[] args){
		Main a; // 객체
		
		a= new Main(); // 인스턴스
	}
}
```



### 6. Overloading,Overriding 차이

```
오버로딩 - 하나의 클래스 내에서 이름이 같은 여러 개의 메소드를 정의하는 것
		 매개변수의 타입이 다르거나 개수가 달라야 한다.	리턴타입과 접근제어자는 영향을 주지 않는다.
		 
* 사용하는 이유 		 
1. 같은 기능을 하는 메소드를 하나의 이름으로 사용할 수 있다.

우리가 흔히 콘솔창에 텍스트를 출력할 때 사용하는 println라는 메소드를 대표적인 예로 들어볼 수 있다. 실은 이 함수가 오버로딩의 결정체이다. 우리는 println의 인자 값으로 int, double, boolean, String 등의 아주 다양한 타입의 매개변수들을 집어넣어도 우리는 그 함수들이 어떻게 실행되지는 모르지만 콘솔창에 아주 잘 출력해주는 것을 볼 수 있다.

이렇게 '출력하다.'라는 같은 기능을 가진 메소드들를 println이라는 하나의 이름으로 정의가 가능한 것이다.

2. 메소드의 이름을 절약할 수 있다.

이 위에서 예로 들었던 println을 생각해보자. 이 메소드를 매개변수의 종류에 따라서 다르게 지정한다고 생각해보자. printlnInt, printlnDouble, printlnBoolean 등 수많은 메소드들의 이름을 정해줘야 할 것이다. 이는 프로그래머의 입장에서는 메소드의 네이밍에 고민을 가중시킨다. 그리고 이런 이름들은 다른 곳에 사용할 가능성도 생기게 된다.

오버라이딩 - 부모 클래스에서 상속받은 메소드를 재정의하는 것
		 리턴타입, 인수, 인수 자료형은 반드시 같아야 하며 접근 제어자는 같거나 더 넓은 개념으로 사용해			야한다.
```

#### 6 - 1. Overloading

- OverLoading.java

```java
class OverLoading{
  //함수의 이름은 모두 같지만,
  //전달받는 인자의 타입과 갯수는 전부 다르다.
  public void overLoad(){
    System.out.println("This is overLoad()");
  }
  public void overLoad(int i){
    System.out.println("This is overLoad(int i) : "+i);
  }
  public void overLoad(String str){
    System.out.println("This is overLoad(String str) : "+str);
  }
  public void overLoad(int i, String str){
    System.out.println("This is overLoad(int i, String str) : "+i+", "+str);
  }
}
```

- Main.java

```java
public class Main {
  public static void main(String[] args) {
    OverLoading ol = new OverLoading();
    //메소드의 이름은 모두 같지만 인자값은 다르다.
    //인자의 타입에 맞는 메소드가 자동으로 실행된다.
    ol.overLoad();
    ol.overLoad(10);
    ol.overLoad("over load");
    ol.overLoad(20, "over load2");
  }
}
```

```
This is overLoad()
This is overLoad(int i) : 10
This is overLoad(String str) : over load
This is overLoad(int i, String str) : 20, over load2
```

#### 6 - 2. Overriding

```
오버라이딩이란 상속을 받은 하위 객체가 상위 객체의 메소드를 새롭게 정의하고 그대로 덮어쓰고 사용하는 것을 말한다.
하위 객체의 메소드 이름과 인자값의 타입은 상위 객체의 메소드와 반드시 일치해야 한다.
```

- SuperClass.java

```java
public class SuperClass {
  public void method1(){
    System.out.println("SuperClass method1()");
  }
  public void method2(String str){
    System.out.println("SuperClass method2(String str)"+str);
  }
}
```

- ChildClass.java

```java
public class ChildClass extends SuperClass {
  public void method1(){
    System.out.println("ChildClass method1()");
  }
  public void method2(String str){
    System.out.println("ChildClass method2(String str) : "+str);
  }
}
```

- Main.java

```java
public class Main {
  public static void main(String[] args) {
    ChildClass cc = new ChildClass();

    cc.method1();
    cc.method2("world");
  }
}
```

```
ChildClass method1()
ChildClass method2(String str) : world
```



### 7. mvc란 ?

```

Controller(컨트롤러) - servlet 
- 일종의 조정자라고 할 수 있다. 클라이언트의 요청을 받았을 때 그 요청에 대해 실제 업무를 수행하는 모델 컴포넌트를 호출한다. 또한, 클라이언트가 보낸 데이터가 있다면 모델에 전달하기 쉽게 데이터를 가공한다. 모델이 업무를 마치면 그 결과를 뷰에게 전달해 준다.

Model(모델)
- 컨트롤러가 호출할 때 요청에 맞는 역할을 수행한다. 비즈니스 로직을 구현하는 영역으로 응용프로그램에서 데이터를 처리하는 부분이다. 비즈니스 로직이란 업무에 필요한 데이터처리를 수행하는 응용프로그램의 일부라고 할 수 있다. DB에 연결하고 데이터를 추출하거나 저장, 삭제, 업데이트, 변환 등의 작업을 수행한다. 상태의 변화가 있을 때 컨트롤러와 뷰에 통보해 후속 조치	명령을 받을 수 있게 한다.

View(뷰) - JSP
- 컨트롤러로부터 받은 모델의 결과값을 가지고 사용자에게 출력할 화면을 만드는 일을한다. 만들어진 화면을 웹브라우저에 전송하여 웹브라우저가 출력하게 하는 것이다. 화면에 표시되는 부분은 추출한 데이터나 일반적인 텍스트 데이터를 표시하거나 입력폼 또는 사용자와 상호작용을 하기 위한 인터페이스를 표시하는 영역이다.
```



![image](https://user-images.githubusercontent.com/49560745/72142264-a8ba7a80-33d7-11ea-9826-6d8760550bab.png)

- 출처 : <https://asfirstalways.tistory.com/180>

```
MVC 구동원리

1. 웹브라우저가 웹 서버에 웹 어플리케이션 실행을 요청한다.
2. 웹 서버는 들어온 요청을 처리할 수 있는 서블릿을 찾아 요청을 전달한다.
3. 서블릿은 모델 자바 객체의 메서드를 호출한다.
4. 데이터를 가공하여 값 객체를 생성하거나, JDBC를 사용하여 데이터베이스와 인터랙션을 통해 값 객체를 전달한다.
5. 업무 수행을 마친 결과값을 컨트롤러에 반환한다.
6. 컨트롤러는 모델로부터 받은 결과값을 View에 전달한다.
7. JSP는 전달받은 값을 참조하여 출력할 결과 화면을 만들고 컨트롤러에게 전달한다.
8. 뷰로부터 받은 화면을 웹 서버에게 전달한다.
9. 웹 브라우저는 웹 서버로부터 요청한 결과값을 응답받으면 그 값을 화면에 출력한다.
```



### 8. java 변수

```
● 지역 변수 local variables : 지역 변수를 선언한 곳에서부터 생명이 시작되고, 지
							역 변수를 선언한 중괄호가 끝나면 소멸
● 매개 변수 parameters : 메소드가 호출될 때 생명이 시작되고, 메소드가 끝나면
					소멸 (정확히 호출될 때 시작하지는 않지만, 이렇게 기억해두어도 무방)
● 인스턴스 변수 instance variables : 객체가 생성될 때 생명이 시작되고, 그 객체를
								참조하고 있는 다른 객체가 없으면 소멸
● 클래스 변수 class variables : 클래스가 생성될 때 생명이 시작되고, 자바 프로그
							램이 끝날 때 소멸
```

ex)

````java
public class VariableTypes {
 int instanceVariable;
 static int classVariable;
 public void method(int parameter) {
 int localVariable;
 }
}
````

#### 8 - 1. 클래스변수 (static int) vs 인스턴스 변수 (int)

```
1.클래스를 설계할 때, 멤버변수 중 모든 인스턴스에 '공통적으로 사용'해야하는 것에 static을 붙인다.

 - 인스턴스를 생성하면, 각 인스턴스들은 서로 독립적기 때문에 서로 다른 값을 유지한다. 경우에 따라서는 각 인스턴스들이 공통적으로 같은 값이 유지되어야 하는 경우 static을 붙인다.

2. static이 붙은 멤버변수는 인스턴스를 생성하지 않아도 사용할 수 있다.

 - static이 붙은 멤버변수(클래스변수)는 클래스가 메모리에 올라갈때 이미 자동적으로 생성되기 때문이다.

3. static이 붙은 메서드(함수)에서는 인스턴스 변수를 사용할 수 없다.

 - static이 메서드는 인스턴스 생성 없이 호출가능한 반면, 인스턴스 변수는 인스턴스를 생성해야만 존재하기 때문에... static이 붙은 메서드(클래스메서드)를 호출할 때 인스턴스가 생성되어있을수도 그렇지 않을 수도 있어서 static이 붙은 메서드에서 인스턴스변수의 사용을 허용하지 않는다. (반대로, 인스턴스변수나 인스턴스메서드에서는 static이 붙은 멤버들을 사용하는 것이 언제나 가능하다. 인스턴스변수가 존재한다는 것은 static이 붙은 변수가 이미 메모리에 존재한다는 것을 의미하기 때문이다.)

4. 메서드 내에서 인스턴스 변수를 사용하지 않는다면, static을 붙이는 것을 고려한다.

 - 메서드의 작업내용중에서 인스턴스 변수를 필요로 한다면, static을 붙일 수 없다. 반대로 인스턴스변수를 필요로 하지 않는다면, 가능하면 static을 붙이는 것이 좋다. 메서드 호출시간이 짧아지기 때문에 효율이 높아진다. (static을 안붙인 메서드는 실행시 호출되어야할 메서드를 찾는 과정이 추가적으로 필요하기 때문에 시간이 더 걸린다.)

5. 클래스 설계시 static의 사용지침

 - 먼저 클래스의 멤버변수중 모든 인스턴스에 공통된 값을 유지해야하는 것이 있는지
    살펴보고 있으면, static을 붙여준다.
 - 작성한 메서드 중에서 인스턴스 변수를 사용하지 않는 메서드에 대해서 static을
    붙일 것을 고려한다.
 - static키워드를 쓰면, 객체를 생성하지 않고도 변수나 함수를 사용한다.
 - 객체를 생성하지 않아도 되니까 편리하고 속도도 빠르다.


일반적으로 인스턴스변수와 관련된 작업을 하는 메서드는 인스턴스메서드(static이 안붙은 메서드)이고 static변수(클래스변수)와 관련된 작업을 하는 메서드는 클래스메서드static이 붙은 메서드)라고 보면 된다.


출처: https://vaert.tistory.com/101 [Vaert Street]
```

[예제]

```java
[예제6-4] CardTest.java

 

class CardTest{

      public static void main(String args[]) {

            // 클래스변수(static 변수)는 객체생성없이 '클래스이름.클래스변수'로 직접 사용 가능하다.

            System.out.println("Card.width = " + Card.width);
            System.out.println("Card.height = " + Card.height);

            Card c1 = new Card();
            c1.kind = "Heart";
            c1.number = 7;

            Card c2 = new Card();
            c2.kind = "Spade";
            c2.number = 4;

            System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")" );

            System.out.println("c2는 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")" );             System.out.println("이제 c1의 width와 height를 각각 50, 80으로 변경합니다.");

            c1.width = 50;
            c1.height = 80;

            System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")" );

            System.out.println("c2는 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")" );

      }

}

 

class Card {

     String kind ;                         // 카드의 무늬 - 인스턴스 변수
     int number;                         // 카드의 숫자 - 인스턴스 변수
     static int width = 100;             // 카드의 폭 - 클래스 변수
     static int height = 250;             // 카드의 높이 - 클래스 변수

}

* 참고
Card클래스의 클래스변수(static변수)인 width, height 그리고 color는 Card클래스의 인스턴스를 생성하지 않고도 '클래스이름.클래스변수'와 같은 방식으로 사용할 수 있다.

Card인스턴스인 c1과 c2는 클래스 변수인 width와 height를 공유하기 때문에, c1의 width와 height를 변경하면 c2의 width와 height값도 바뀐 것과 같은 결과를 얻는다.

Card.width, c1.width, c2.width는 모두 같은 저장공간을 참조하므로 항상 같은 값을 갖게 된다.

인스턴스 변수는 인스턴스가 생성될 때 마다 생성되므로 인스턴스마다 각기 다른 값을 유지할 수 있지만, 클래스 변수는 모든 인스턴스가 하나의 저장공간을 공유하므로, 항상 공통된 값을 갖는다.

출처: https://vaert.tistory.com/101 [Vaert Street]
```

[실행결과]

```
Card.width = 100
Card.height = 250
c1은 Heart, 7이며, 크기는 (100, 250)
c2는 Spade, 4이며, 크기는 (100, 250)
이제 c1의 width와 height를 각각 50, 80으로 변경합니다.
c1은 Heart, 7이며, 크기는 (50, 80)
c2는 Spade, 4이며, 크기는 (50, 80)


출처: https://vaert.tistory.com/101 [Vaert Street]
```

#### 8 - 2. 클래스메소드 vs 인스턴스 메소드

```
클래스는 '데이터(변수)와 데이터에 관련된 메서드의 집합'이라고 할 수 있다. 같은 클래스 내에 있는 메서드와 멤버변수는 아주 밀접한 관계가 있다. 인스턴스메서드는 인스턴스변수와 관련된 작업을 하는, 즉 메서드의 작업을 수행하는데 인스턴스변수를 필요로 하는 메서드이다.

그래서 인스턴스변수와 관계없거나(메서드 내에서 인스턴스변수를 사용하지 않거나), 클래스변수만을 사용하는 메서드들은 클래스메서드로 정의한다.

출처: https://vaert.tistory.com/101 [Vaert Street]
```

[예제]

```java
[예제6-12] MyMathTest2.java

class MyMath2 {

      long a, b;     

      // 인스턴스변수 a, b를 이용한 작업을 하므로 매개변수가 필요없다.

      long add() {       return a + b; }
      long subtract() {       return a - b; }
      long multiply() {       return a * b; }
      double divide() {       return a / b; }

      // 인스턴스변수와 관계없이 매개변수만으로 작업이 가능하다.
      static long add(long a, long b) {       return a + b; }
      static long subtract(long a, long b) {       return a - b; }
      static long multiply(long a, long b) {       return a * b; }
      static double divide(double a, double b) {       return a / b; }

}

class MyMathTest2 {

      public static void main(String args[]) {

            // 클래스메서드 호출
            System.out.println(MyMath2.add(200L, 100L));
            System.out.println(MyMath2.subtract(200L, 100L));
            System.out.println(MyMath2.multiply(200L, 100L));
            System.out.println(MyMath2.divide(200.0, 100.0));
            
            MyMath2 mm = new MyMath2();
            mm.a = 200L;
            mm.b = 100L;
            // 인스턴스메서드는 객체생성 후에만 호출이 가능함.
            System.out.println(mm.add());
            System.out.println(mm.subtract());
            System.out.println(mm.multiply());
            System.out.println(mm.divide());

}


출처: https://vaert.tistory.com/101 [Vaert Street]
```

[결과]

```
300
100
20000
2.0
300
100
20000
2.0

출처: https://vaert.tistory.com/101 [Vaert Street]
```



#### 추가

```java
import java.util.*;
class Example{
    
    static private int K=1;  // static이라 static 클래스에서 접근 가능
    
    static void display(){
        System.out.println("St");
        
    }
     static class Innerclass{
        private int a =36;
        public void printK(){
                System.out.println(K+a);
                display();
        }
    }
    class Innerclass2{
        private int a=37;
        public void printL(){
            System.out.println(K+a);
        }
        
    }
}

public class Test{
    public static void main(String args[]){
        Example ex=new Example();
        ex.display();
        Example.Innerclass Inner=new Example.Innerclass();
        Inner.printK();
        //Example.Innerclass2 Inner2=new Example.Innerclass2();
        //Inner2.printL(); 
        // 주석문을 실행하면 오류난다.
        // Innerclass2는 static이 아니기에 접근할 수 없다.
    }
}

[결과]
St
37
St

```

### 9. Getter/Setter

- 클래스의 특성중 정보 은닉을 가장 잘 보여주는 메소드

- 보통 클래스의 멤버변수는 private로 접근제한자를 설정한 후

  getter/setter를 통해 멤버변수의 값을 변경,호출하게 된다.

```java
예제)


import java.util.*;
class Student{
	// 은닉된 멤버변수 --> 현재 클래스 내에서만 접근 가능
	private String name;
	private int age;
	
	// 은닉된 멤버변수에 값을 넣는 방법
	public void setName(String name){
		this.name=name;
	}
	public void setAge(int age){
		this.age=age;
	}
	
	// 은닉된 멤버변수의 값을 읽는 방법
	public String getName(){
		return name;
	}
	public int getAge(){
	
		return age;
	}
}


public class Exam{
		public static void main(String args[]){
		
			Student s= new Student();
			s.setName("미래현차그룹직원");
			s.setAge(29);
			
			String name=s.getName();
			System.out.println(name);
			int age=s.getAge();
			System.out.println(age);
		
		}
}

[결과]
미래현차그룹직원
29
```

