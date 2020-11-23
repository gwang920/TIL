# 언어

## JAVA

### 1. java언어의 특징은 무엇인가

```
- 객체지향 프로그래밍 언어

객체지향이란?
 객체지향 프로그래밍 패러다임 이전에는 컴퓨터 중심의 사고가 이루어지는 방식을 사용했다.
 하지만, 객체지향 패러다임은 컴퓨터 중심이 아닌 사람의 사고를 중심으로 이루어지는 프로그래밍 방식이다.
 따라서, 현실세계에 존재하는 사물을 실제 컴퓨터상에 구현하는 것이고, 이것을 객체라 하는데
 객체들의 특징을 뽑아와서 프로그래밍하는 것이다.

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

## Garbage Collector

```
jvm 내에서 메모리를 관리하기 위한 기법이다.
```

### 메모리 영역

````
우선, java의 메모리 영역을 살펴보자

java의 메모리는 stack / heap / static 3가지의 영역으로 나뉜다

1) stack
기본 자료형(int,boolean,double 등)을 갖는 변수나 함수의 매개변수와 같은
지역변수가 stack 영역에 저장된다.

이뿐만 아니라 heap영역의 메모리를 참조하는 변수들도 저장된다.

stack 영역의 데이터들은 메소드가 실행될 때, stack 영역에 올라가고,
메소드가 종료되면 소멸된다.

2) heap
참조형의 데이터 타입을 갖는 객체(인스턴스)나 배열 등이 heap 영역에 저장된다.
이때, heap영역의 데이터를 참조하는 변수가 stack 영역에 저장되는데

int[] a=new int[5];
System.out.println(a); // 결고 : @15db9742 (참조값)

위 처럼 stack 영역의 참조 변수는 참조 값을 갖고 있다.


3) static
하나의 java파일은 필드, 생성자, 메소드로 구성된다.
그 중 필드 부분에 선언된 변수(전역변수)나 멤버변수(static 키워드가 붙은 변수)
들이 static 영역을 차지한다.

이 static 영역의 데이터들은 프로그램 시작부터 종료까지 메모리에 남아있는다.

따라서, 무부별하게 전역변수를 많이 선언하면 메모리가 부족현상이 발생할 수 있다.
````

### 메모리 관리 기법

```
이제, garbage collector가 메모리를 관리하는 과정을 알아보자

garbage collector는 heap영역의 쓰레기 값을 관리한다.
즉, 참조되지 않는 데이터를 메모리에서 해제하고, 메모리 공간을 확보한다.

garbage collector의 과정은 다음과 같다.

1) stack의 모든 변수를 스캔하면서 각각 어떤 객체를 참조하는지 찾아서 마킹한다.
2) Reachable Object가 참조하고 있는 객체도 찾아서 마킹한다.
3) 마킹되지 않는 객체를 제거한다.  sweap

여기서 Reachable Object는 
stack 영역의 변수가 참조하고 있는 객체이다.
만일, stack 영역이 어떤 객체를 참조하고 있고, 메소드가 종료되면서 stack 영역이
소멸된다면 이 어떤 객체는 Unreachable Object가 된다.
이 객체가 garbage collector의 대상이 되는 것이다.


heap영역의 메모리 구조는 두 부분으로 나뉜다.

new generation / old generation

그리고 new gerneration 영역은 3 부분으로 나뉜다.

eden / survive0 / survive1

```

| New generation             | Old gerneration |
| -------------------------- | --------------- |
| eden / survive0 / survive1 |                 |

````
1) 우선 새로 생성된 힙영역의 데이터는 eden영역에 저장된다.
2) 이 eden 영역이 가득차면 survive 0로 이동한다.
이때, garbage collector(minor)가 동작하고, 살아남는놈만 이동
3) survive0 영역이 가득차면 이때 메모리의 age가 증가하고, survive1으로 이동한다.
마찬가지로, garbage collector(minor)가 동작하고, 살아남는놈만 이동


이 1) ~ 3)의 과정을 반복하다, New generation 영역이 가득차면,
Old generation 영역으로 메모리가 이동한다.

New generation 영역과 같이 old generation영역도 가득차면
garbage collector(major)가 동작하며, 메모리를 관리한다.


이처럼 garbage collector는 위의 과정을 계속해서 반복하며, 메모리를 관리한다.
````

