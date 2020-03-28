# 기술면접

## 자료구조

- 자료는 구조화 하는 방법에 따라 리스트(List), 스택(stack), 큐(queue), 데크(dqueue), 트리(Tree), 그래프(Grapph) 등으로 나눌 수 있다. 이러한 자료구조의 유형은 프로그램으로 구현하는 방식에 따라 '순차 자료구조'와 '연결 자료구조'로 나눌 수 있다.
- 순차자료구조는 배열을 통해 구현하고, 연결자료구조는 포인터를 이용하여 구현한다.

### 1. Array vs Linked List

```
1) Array(배열)
- 가장 기본적인 자료구조, 논리적 저장순서와 물리적 저장순서가 일치한다.
따라서, 인덱스로 해당 원소에 접근할 수 있다. 그렇기 때문에 찾고자 하는 원소의 인덱스 값을 알고 있다면
Big-O(1)에(참조시간이 상수) 해당 원소로 접근할 수 있다. 즉 Random Access가 가능하다.

하지만, 삽입 또는 삭제 과정에서는 해당원소에 접근하여 작업을 완료한 뒤(Big-O(1)) 또 한가지의 작업을 추가적으로 해줘야한다. 만약 배열의 어떤 요소에 삽입 또는 삭제를 했다면 배열의 연속적인 특징이 깨진다.
따라서 삽입 또는 삭제한 원소보다 크 인덱스를 갖는 원소들을 shift해줘야하는 비용이 발생하고 이 경우
시간복잡도는(O(n))이 된다. 따라서 Array 자료구조의 시간복잡도의 worst case는 O(n)이 된다.

* Array vs ArrayList
1. 배열은 크기가 고정 arrayList는 사이즈가 동적인 배열
2. 길이에 대해 배열은 length 변수를 쓰고, arrayList는 size() 메서드를 사용
3. 배열은 element들을 할당하기 위해 assignment(할당) 연산자를 써야하고, 
   arrayList는 add() 메서드를 통해 element를 삽입

가장 결정적인 차이가 사이즈가 정적이냐 동적이냐이다.

Array List는 element를 add하고자할 때 capacity가 배열의 길이(Array List)와 같아진다면 기존의용량 + 기존의 용량/2 만큼 크기가 늘어난 배열에 기존 elementData를 copy한다.

size=4 인 ArrayList에 
	[1][2][3][4]
element 5를 추가한다면
	[1][2][3][4][5][] 로 배열이 현재배열크기/2 만큼 늘어난 배열에 기존 element가 copy된다.
	
https://zorba91.tistory.com/287


* 배열에서 데이터 추가는 ? index를 유지하면서 값을 추가해야하기 때문에 사실상 데이터 교체와 같음
* 자바에서 배열과 리스트(Linked List,Array List)가 있다.
* 리스트는 배열과 다르게 빈 엘리먼트는 절대 허용하지 않는다.

2) Linked List
- Array의 문제점을 해결하기 위한 자료구조가 Linked List이다. Linked List의 각각 원소들은 자기 자신다음에 어떠 원소인지만을 기억한다. 따라서 이 부분만 다른 값으로 바꿔주면 삭제와 삽입을(O(1))만에 해결 할 수 있다.

하지만 Linked List 역시 한가지 문제가 있다. 원하는 위치에 삽입을 하고자하면 원하는 위치를 Search 과정에서 첫번째 원소부터 다 확인해봐야한다는 것이다. Array와 달리 논리적 저장순서와 물리적 저장순서가 다르기 때문이다. 이것은 일단 삽입하고 정렬하는것과 마찬가지다. 이 과정 때문에 어떠한 원소를 삭제 또는 추가하고자 했을 때 그 원소를 찾기 위해 O(n)의 시간이 추가적으로 발생한다.

결국 Linked List 자료구조는 search에도 O(n)의 시간복잡도를 갖고 삭제에 대해서도 O(n)의 시간복잡도를 갖는다. Linked List는 Tree 구조의 근간이 되는 자료구조이며 Tree에서 사용되었을 때 그유용성이 드러난다.

* Linked List vs Array List
http://www.nextree.co.kr/p6506/
```

![image](https://user-images.githubusercontent.com/49560745/77373920-cb401b00-6dac-11ea-9843-fe9e18e06a4b.png)

### 2. Stack vs Queue

```
Stack
선형 자료구조의 일종으로 Last In First Out(LIFO) 즉, 나중에 들어간 원소가 먼저나온다.(ex 책 쌓기)

- push(item) : 스택의 맨 윗부분에 원소를 추가한다.
- pop() : 스택의 맨 윗부분의 원소를 삭제한다.
- peek() : 스택의 맨 윗부분의 원소를 반환한다.
- isEmpty() : 스택이 비어있으면 true를 반환한다.

Queue
선형자료구조의 일종으로 First In First Out(FIFO) 즉, 먼저 들어간 원소가 먼저 나온다.
참고로 Java Collection에서 Queue는 인터페이스이다. 이를 구현하고 있는 Priority queue 등을 사용할 수 있다.
```

### 3. Tree

```
트리는 스택이나 큐와 같은 선형구조가 아닌 비선형구조이다. 트리는 계층적관계(Hierarchical Realtionship)을 표현하는 자료구조이다. 이 트리라는 자료구조는 표현에 집중한다. 무엇인가를 저정하고
꺼내야한다는 사고에 벗어나 트리라는 자료구조를 바라보자.

트리를 구성하고 있는 구성요소들
- Node(노드) : 트리를 구성하고 있는 각각의 요소를 의미한다.
- Edge(간선) : 트리를 구성하기 위해 노드와 노드를 연결하는 선을 의미한다.
- Rood Node(루트 노드) : 트리구조에서 최상위에 있는 노드를 의미한다.
- Terminal Node	(=leaf Node,단말노드) : 하위에 다른 노드가 연결되어 있지 않은 노드를 의미한다.
- Internal Node (내부노드,비단말노드) : 단말 노드를 제외한 모든 노드로 루트 노드를 포함한다.

Binary Tree(이진트리)
- 루트노드를 중심으로 두 개의 서브트리(큰 트리에 속하는 작은트리)로 나뉘어진다. 또한 나뉘어진 서브트리도 모두 이진트리이어야 한다. 

트리에서는 각 층별로 숫자를 매겨서 이를 트리의 Level(레벨)이라고 한다. 레벨의 값은 0부터 시작하고 따라서 루트노드의 레벨은 0이다. 그리고 트리의 최고레벨을 가리켜 해당 트리의 height(높이)라고한다.
```

- 이진 탐색 트리의 탐색 연산(시간복잡도 O(log n)) 예제

```java
* 이진 탐색 트리 - 자신보다 작은자료는 왼쪽에,자신보다 큰 자료는 오른쪽의 자식 노드에있다.

package codingInterview;

public class BinarySearchTree {
    public static boolean search(int i, int[] array){
        boolean result = false;
        int left = 0;   
        int right = array.length-1;
        int mid = 0;                 //중간 값 인덱스
        
        while(left <= right){
            mid = (left + right)/2;  // 루프 돌 때마다 중간 값 초기화
            if(array[mid] == i){
                result = true;
                break;
            }
            else if(array[mid] > i){  // 찾는 값보다 큰 배열 값들 버리기
                right = mid-1;
            }
            else{                     // 찾는 값보다 작은 배열 값들 버리기
                left = mid+1;
            }
        }
        return result;
    }
 
    public static void main(String[] args) {
        int[] array = {1, 5, 7, 8, 12, 17, 23, 25}; // 배열 초기화
        System.out.println(search(10, array));
    }
}
```

```java
Perfect Binary Tree(포화 이진 트리) - 모든 잎의 레벨이 동일한 이진트리이며, 잎이 아닌 내부 노드들은
									모두 2개의 자식을 가지는 트리
									
									1  - 높이 0 / 레벨 1
								   / \
								  2   3 - 높이 1 / 레벨 2
								  /\  /\
								 4 5  6 7 - 높이 2 / 레벨 3
								 
								 높이가 d인 포화 이진 트리의 노드의 개수는 2^(d+1)-1 이 된다.

Complete Binary Tree(완전 이진 트리) - 포화 이진트리의 leaf들을 오른쪽에서부터 제거하여 얻어진 트리

									1 - 높이 0 / 레벨 1
								   / \
								  2   3 - 높이 1 / 레벨 2
								  /\  /
								 4 5  6  - 높이 2 / 레벨 3
								 
								 	1  - 높이 0 / 레벨 1
								   / \
								  2   3 - 높이 1 / 레벨 2
								  /\  
								 4 5    - 높이 2 / 레벨 3
								 
								 모두 완전 이진 트리의 예시이다.
								 높이가 d인 완전 이진 트리의 노드의 개수는 2^d 이상 2^(d+1)개
								 미만이다.

Full Binary Tree(정 이진 트리) - 모든 노드가 0개 혹은 2개의 자식노드만 갖는 이진트리

배열로 구성된 Binary Tree는 노드의 개수가 n 개이고 root가 0이 아닌 1에서 시작할 때, i 번째 노드에 대해서 parent(i) = i, left_child(i) = 2i , right_child(i) = 2i + 1 의 index 값을 갖는다.
```

### 4. Binary Heap

```
- 자료구조의 일종으로 Tree의 형식을 하고 있으며 Tree중에서도 배열에 기반한 Complete Binary Tree이다.
배열에 트리의 값들을 넣어 줄 때, 0번째는 건너뛰고 1번 index 부터 루트노드가 시작된다. 이는 노드의 고유번호값과 배열의 index를 일치시켜 혼동을 줄이기 위함이다.
힙(Heap)에는 최대힙(max heap),최소힙(min heap) 두 가지가 있다.

- Max Heap이란, 각 노드의 값이 해당 children의 값보다 크거나 같은 complete binary tree를 말한다.
- Min Heap은 Max Heap의 반대로서 각 노드의 값이 해당 children의 값보다 작거나 같은 경우이다.

Max Heap에서는 Root node 에 있는 값이 제일 크므로, 최대값을 찾는데 소요되는 연산의 time complexity 이 O(1)이다. 
그리고 complete binary tree이기 때문에 배열을 사용하여 효율적으로 관리할 수 있다. 
(즉, random access 가 가능하다. Min heap 에서는 최소값을 찾는데 소요되는 연산의 time complexity 가 O(1)이다.) 
하지만 heap 의 구조를 계속 유지하기 위해서는 제거된 루트 노드를 대체할 다른 노드가 필요하다. 
여기서 heap 은 맨 마지막 노드를 루트 노드로 대체시킨 후, 다시 heapify 과정을 거쳐 heap 구조를 유지한다. 이런 경우에는 결국 O(log n)의 시간복잡도로 최대값 또는 최소값에 접근할 수 있게 된다.

배열에 저장하였을 때의 장점을 살리기 위해서는 인덱스 값을 알아야한다. 어떻게 알아낼 수 있을까.
complete binary tree는 노드의 개수가 n개일 때 i번째 노드에 대해서 parent(i)=i/2, left_child(i)=2i, right_child(i)=2i+1의 index 값을 갖는다.
```

#### 4 - 1 Heapify

```
max-heapify는 root node의 값이 childe node 값보다 작으면 두 개의 child node중 값이 큰 노드와 root를 교체하고 이 과정을 교체할 노드가 없을 때 까지(처음에 root였던 노드가 leaf node가 될 때까지)
반복해주면된다. 이와 마찬가지로 min-heapify도 진행한다.
```

### 5. Red Black Tree

```
 Red Blakc Tree = 이진 탐색 트리 + 균형
 
 	 2
      \
       3
        \ 
         4
          \
           5
          
          위와 같은 문제를 해결하기 위한 자료구조가 red black tree 이다.
          (c++ stl의 map이 레드브랙트리로 만들어짐)
 
 RBT는 BST를 기반으로하는 트리형식의 자료구조이다. 
 결론부터 말하자면 Red Blakc Tree에 데이터를 저장하게 되면 Search,Insert,Delete에 O(log n)의 시간복잡도가 소요된다. 
 동일한 노드의 개수일 때, depth를 최소화하여 시간 복잡도를 줄이는 것이 핵심아이디어이다. 
 동일한 노드의 개수 일 때, depth(높이)가 최소가 되는 경우는 tree가 complete binary tree인 경우이다.

Red Black Tree의 정의
- Red Black Tree는 다음의 성질을 만족하는 BST이다.
1. 각 노드는 red or black이라는 색을 갖는다.
2. root node의 색은 black이다.
3. 각 leaf node는 black이다.
4. 어떤 노드의 색이 red라면 두 개의 children의 색은 모두 black이다.
5. 각 노드에 대해서 노드로부터 descendant(자손) leaves까지의 단순경로는 모두 같은 수의 black nodes들을 포함한다. 이를 해당 노드의 black-height라고 한다.
cf) black-height : 노드 x로부터 노드 x를 포함하지 않는 leaf node까지의 simple path 상에 있는 black nodes의 개수들
```

```
삽입

삽입 상태에서 장애가 발생하는 지점은 신규 노드가 삽입되고 나서 
레드 노드가 연속해서 2개가 붙게 될 때이다.

해당 상황에 대해 해결방법이 크게 2가지 경우로 나뉩니다.
Case 1. 부모 노드가 레드인데, 부모님의 형제가 없거나 블랙일 때 - 회전
Case 2. 부모 노드가 레드인데, 부모님의 형제가 레드일 때 - 색상 변환

* 참고
https://m.blog.naver.com/PostView.nhn?blogId=min-program&logNo=221231697752&proxyReferer=http%3A%2F%2F59.29.251.41%2Ftm%2F%3Fa%3DCR%26b%3DWIN%26c%3D300019389618%26d%3D32%26e%3D5206%26f%3DbS5ibG9nLm5hdmVyLmNvbS9taW4tcHJvZ3JhbS8yMjEyMzE2OTc3NTI%3D%26g%3D1585101618430%26h%3D1585101617789%26y%3D0%26z%3D0%26x%3D1%26w%3D2019-07-24%26in%3D5206_1100_00001607%26id%3D20200325
```



## 알고리즘


### 1. 시뮬레이션 vs 완전탐색

```
- 시뮬레이션은 문제에서 주어진 내용을 코드로서 작성하는 것
따라서 '이러한 과정을 거쳤을 때 나오는 결과값이 무엇인가?'에 대한 대답을 코드로 작성하는 것이라 할 수 있다.

- 완전탐색은 문제에서 과정이 주어지지 않고 결과값을 도출해내는 것.
시뮬레이션과는 다르게 과정이 주저이지 않으며 '가장 좋은 결과는 무엇인가?'에 대한 대답을 코드로 작성하는 것이다.
```



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
https://opentutorials.org/module/516/6127 (다형성)
https://opentutorials.org/module/516/6062 (추상클래스)

1) 공통적인 특징(하는 일)
- 추상클래스와 인터페이스는 상속받는 클래스 혹은 구현하는 인터페이스 안에 있는 추상메소드를 구현하도록
강제한다.

Q. 이 '하는 일'은 결국 추상 메소드를 구현하는거 아니냐?
그렇다면 추상클래스 하나만 존재하되, 추상클래스 안에 추상 메소드를 여러 개 두거나 혹은 전부 추상 메소드만 두면 될 텐데 왜 인터페이스가 존재하는 것일까?

=> 결론부터 얘기하자면 인터페이스와 추상클래스는 존재 목적이 다르다. 추상클래스는 그 추상클래스를 상속받아서 기능을 이용하고, 확장시키는데 있다.(다중 상속의 모호성 때문에 하나만 상속 받을 수 있다.) 
반면에 인터페이스는 함수의 껍데기만 잇는데, 그 이유는 그 함수의 구현을 강제하기 위해서이다. 구현을 강제함으로써 구현 객체의 같은 동작을 보장할 수 있다.

1. extends : 부모에서 선언/정의를 모두하며 자식은 메소드/변수를 그대로 사용할 수 있음
2. implements(interface 구현) : 부모 객체는 선언만하며 정의(내용)은 자식에서 오버라이딩 해야함

추상화 vs 인터페이스
https://commin.tistory.com/106
추상화, 인터페이스 사용 이유
https://marobiana.tistory.com/58

추상클래스는 구체화 시킬 구현체를 추상화시키는 기법이며 인터페이스는 구현할 컴포넌트의 표준을 정하는 것입니다.
(헤드퍼스트 디자인패턴에 보면 추상클래스를 사용하는 것보다 인터페이스로서 구현하는 것을 추천하고 있고 실제로도 그렇게 구현을 하는것이 유연성이 있다고 합니다.)

어떠한 인터페이스를 구현한 객체에 대해서 동일한 동작을 보장한다

2) 인터페이스
모든 멤버변수는 public static fianl 이어야 하며, 이를 생략할 수있다.
모든 메서드는 public abstract 이어야 하며, 이를 생략할 수 있다.


3) 인터페이스의 장점
그러면 인터페이스를 사용하는 이유는 무엇일까?

1. 개발시간을 단축시킬 수 있다.

개발자들이 각각의 부분을 완성할 때까지 기다리지 않고
서로 규약만 정해두어 각자의 부분만 따로 나눠서 작성된 코드를 컴파일 할 수 있다.

2. 표준화가 가능하다.

클래스의 기본틀을 제공하여 개발자들에게 정형화된 개발을 강요할 수 있다.

3. 서로 관계없는 클래스들에게 관계를 맺어 줄 수 있다.

코드의 종속성을 줄이고 유지보수성을 높이도록 해준다.
즉 클래스들끼리의 쓸데없는 상속을 줄일 수 있다.

4. 독립적인 프로그래밍이 가능하다.

클래스와 클래스간의 직접적인 관계를 인터페이스를 통해 간접적인 방법으로 변경하면,
한 클래스의 변경이 다른 클래스에 영향을 미치지 않는 독립적인 프로그래밍이 가능하다.
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

#### 3 - 1 다형성

```
하나의 클래스가 다양한 동작 방법을 가지고 있는 것
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
* mvc모델 1,2
아래 그림이 mvc모델2
mvc모델1은 mvc모델2에서 controller가 빠진형태이다.

mvc모델 1
- 정의 : 모든 클라이언트 요청과 응답을 JSP가 담당하는 구조이다.
- 장점 : 단순한 페이지 작성으로 쉽게 구현 가능하다. 중소형 프로젝트에 적합하다.
- 단점 : 웹 애플리케이션이 복잡해지면 유지보수 문제가 발생된다.

mvc모델 2
-  정의 : 클라이언트의 요청처리와 응답처리, 비즈니스 로직 처리하는 부분을 모듈화시킨 구조이다.
-  장점 : 처리작업의 분리로 인해 유지보수와 확장이 용이하다.
-  단점 : 구조 설계를 위한 시간이 많이 소요되므로 개발 기간이 증가한다.

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

#### 7 - 1. JSP?

```
JSP 는 Java Server pages의 약자
HTML코드에 JAVA 코드를 넣어 동적웹페이지를 생성하는 웹어플리케이션 도구이다.
JSP가 실행되면 자바 서블릿(Servlet)으로 변환되며 
웹 어플리케이션 서버에서 동작되면서 필요한 기능을 수행하고 
그렇게 생성된 데이터를 웹페이지와 함께 클라이언트로 응답한다.

* 웹(Web)
 웹이란 인터넷 기반의 정보기술로 World Wide Web의 줄임말로 쓰인다.
 전세계에 거대한 네트워크 망을 통해 정보를 공유하며 정보의 흐름은 양방향성을 가진다.

* 웹 어플리케이션
 웹 어플리케이션은 웹에서 실행되는 응용프로그램을 뜻하며 인터넷을 통한 은행업무,인터넷쇼핑 등등
 인터넷에서 하는 여러 서비스를 총칭하며 사용자가 필요한 요청(Request)을 하고 서버에서는 이에 해당하는
 요청을 수행하고 요청한 데이터를 응답(Response)한다.
 
 웹 어플리케이션이 위와 같이 동작하기 위한 구성요소
 
 1) 웹 브라우저 : 클라이언트에서 요청을하고 전달받은 페이지를 볼 수 있는 환경(크롬,Firefox,IE)
 
 2) 웹 서버 : 클라이언트로 부터 요청받아 서버에 저장된 리소스를 클라이언트에게 전달한다.
 			주로 정적컨텐츠를 담당한다.
 			(HTTP 요청을 받아들이고, HTML 문서,css와 같은 웹 페이지를 정적으로 처리해 반환하는 프로			그램)
 			
 3) 웹 어플리케이션 서버 : 줄여서 was라 부르며 서버단에서 필요한 기능을 수행하고 그 결과를 웹 서버에게 						  전달한다.
 					
  * 웹 서버 VS 웹 어플리케이션 서버
  웹 서버는 정적 데이터 처리,웹 어플리케이션 서버는 동적 데이터 처리
  WAS는 동적에 최적화되어 있는 서비스이기에 처리속도를 위해 정적은 웹 서버에서,동적은 was에서 처리
  웹 문서를 처리하는 기능을 분배하여 서버의 부담을 줄일 수 있다.
 					
 4) 데이터베이스 : 서비스에 필요한 데이터를 보관,갱신 등 관리 한다.
 
 * 자바 서블릿(Java Servlet)
 서블릿이란 웹페이지를 동적으로 생성하기 위한 서버측 프로그램
 웹어플리케이션 위에서 컴파일 되고 동작한다.
 
 * JSP 와 서블릿
 JSP와 서블릿은 결과적으로 하는 일은 동일하지만
 JSP는 HTML 내부에 JAVA 소스코드가 들어감으로 인해 HTML 코드를 작성하기 간편하다는 장점이 있으며
 서블릿은 자바코드내에 HTML 코드가 있어 읽고 쓰기가 굉장히 불편하여 작업 효울성이 떨어진다.
```

![image](https://user-images.githubusercontent.com/49560745/77242906-0294b780-6c47-11ea-8d36-030a7ea0c151.png)

```
1. 클라이언트가 어떤 동작을 함으로써 hello.jsp 를 요청하였다.

2. JSP 컨테이너가 JSP 파일을 읽는다.

3. JSP 컨테이너가 Generete (변환) 작업을 통해 Servlet ( .java )  파일을 생성한다.

4. .java 파일은 다시 .class 파일로 컴파일된다.

5. Execute (실행) 을통해 HTML 파일을 생성하여 JSP 컨테이너 에게 전달한다.

6. JSP 는 HTTP 프로토콜을 통해 HTML 페이지를 클라이언트 에게 전달한다.
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

### 10. static vs const

````
static
- 선언을 하게 되면 그 위치에 관계없이 프로그램의 시작부터 끝까지 메모리에 할당되어 있으면서 그 값을 마음대로 바꿀 수 없는 것. (전역,지역 변수 모두 가능)
- 그렇기 때문에 인스턴스(객체) 생성 없이 바로 사용 가능하다. 그러므로, 객체를 생성하지 않아도 되니까 편리하고 속도도 빠르다.
- 자주 변하지 않는 일정한 값이나 설정 정보같은 공용자원에 대한 접근에 있어서 매번 메모리에 로딩하거나 값을 읽어들이는 것보다 일종의 '전역변수'와 같은 개념을 통해서 접근하는 것이 비용도 줄이고 효율을 높일 수있다. 
- 인스턴스 생성 없이 바로 사용가능 하기 때문에 프로그램 내에서 공통으로 사용되는 데이터들을 관리 할 때 이용한다.

* 메모리 영역에는 static, 전역변수가 저장 된다.

* java 개발자가 static사용을 꺼리는 이유

Static 변수는 global state(역주: 전역 상태. 프로그램 혹은 한 모듈 전체의 상태)를 상징합니다. 
Global state는 추론과 테스트가 매우 까다롭습니다. 
가령 코드에서 static 변수를 사용한다고 하면, 이 변수의 상태는 코드 여러 부분에서 영향을 받을 수 있게 되고 따라서 변화를 추적하기가 어려워집니다. 
반면에 이를 객체화하여 인스턴스로 생성하면 테스트 중에 그 변수가 어떤 상태를 가지고 있는지 추론하는 것이 보다 간단해집니다.
프로그래머로서 제가 그동안 경험해온 바에 따르면 큰 개념에 대해서 그리기 위해선 일단 이해하고자 하는 범위를 좁혀 쉽게 추론할 수 있어야 합니다. 
일반적으로 우리는 작으면 작을수록 그 대상을 쉽게 이해합니다. 
다시 말해, 모듈화를 제대로 하지 않는다면 백만 줄 짜리 시스템의 상태에 대해서 추론하는 것은 굉장히 어려운 일입니다. 
이것은 단순히 static 변수 뿐만 아니라 모든 프로그래밍 이슈에 대해서 적용할 수 있는 중요한 사실입니다.

const
- 해당 변수를 const로 초기화한 이후에는 절대 바꾸지 못하도록 하는 것.
````

- static 예제(static의 문제점)

```java
public class FavoriteCoffee {
	static String coffee = "아메리카노";

	public static void main(String[] args) {
		FavoriteCoffee kate = new FavoriteCoffee();
		FavoriteCoffee kevin = new FavoriteCoffee();

		System.out.println("kate가 좋아하는 커피 : " + kate.coffee);
		System.out.println("kevin이 좋아하는 커피 : " + kevin.coffee);

		kate.coffee = "라떼"; //kate가 좋아하는 커피를 라떼로 변경하고자 한다.
		System.out.println("kate가 좋아하는 커피 : " + kate.coffee);
		System.out.println("kevin이 좋아하는 커피 : " + kevin.coffee);
	}
}

[결과]
kate가 좋아하는 커피 : 아메리카노
kevin이 좋아하는 커피 : 아메리카노
kate가 좋아하는 커피 : 라떼
kevin이 좋아하는 커피 : 라떼

kate.coffee를 라떼로 변경했을 뿐인데 kevine.coffee도 라떼로 변경됨을 확인할 수 있다.
이는 coffee라는 변수를 static키워드를 통해 정의 했기에 kate와 kevin은 같은 coffee변수를 공유하는 것이다.
    
위와 같이 static은 결코 남발해서는 안되며 공통으로 값을 유지하고 싶을 때만! 사용해야 한다.
```



### 11.  스택(stack), 힙(Heap), 데이터(data) 영역

```c++
데이터 영역
- 전역변수와 static 변수가 할당되는 지역
- 프로그램의 시작과 동시에 할당되고, 프로그램이 종료되어야 메모리에서 소멸됨

[예시]
#include <stdio.h>

int a=20; // 메모리 영역에 할당

int main(){

	...
	return 0;
}

스택 영역
- 함수 호출 시 생성되는 지역변수와 매개변수가 저장되는 영역
- 함수 호출이 완료되면 사라짐
- 스택 영역에 할당될 메모리의 크기는 컴파일 타임(컴파일 하는 동안)에 결정된다

[예시]
#include <stdio.h> 

void fct1(int); 
void fct2(int); 
int a = 10; // 데이터 영역에 할당 
int b = 20; // 데이터 영역에 할당 
int main() { 
    int i = 100; // 지역변수 i가 스택 영역에 할당 
	fct1(i); 
    fct2(i); 
    
    return 0; } 
void fct1(int c) { 
    int d = 30; // 매개변수 c와 지역변수 d가 스택영역에 할당 
                 
                 } 
void fct2(int e) { 
    int f = 40; // 매개변수 e와 지역변수 f가 스택영역에 할당 
}

힙 영역
- 필요에 의해 동적으로 메모리를 할당 할 때 사용
- 할당해야 할 메모리의 크기를 프로그램이 실행되는 동안 결정해야할 때 힙영역을 사용

[예시]
int main(){
	int i=10;
	int arr[i];
	
	return 0;
}

위의 예시에서 i의 크기가 10이기 때문에 arr 배열의 크기가 10이지 않을까? 결과는 아니다!
   
    컴파일 타임시에는 i가 4바이트의 크기라는 것을 알 수 있다. 그렇지만 i가 10으로 초기화 되었다는
    사실을 무시하고 넘어간다.
    i가 10으로 초기화 되는 시점은 '런타임' 시점이된다.
    따라서, 컴파일러는 arr의 크기가 40바이트가 된다는 사실을 알 수 없다.
    
    그렇기 때문에 이러한 사용자의 요구사항을 맞춰주기 위하여(런타임에 메모리 크기를 결정하고 싶을 때) 
    메모리 동적할당을 통해 힙 영역에 메모리를 할당해야한다.
    
    
* 참고

런타임 : 컴파일 과정을 마친 응용 프로그램이 사용자에 의해 실행되어지는 때
런타임에러 : 이미 컴파일이 완료되어 프로그램이 실행중임에도 불구하고 의도치 않은 예외사항으로 인하여
		   프로그램 실행 중 발생하는 오류형태
컴파일타임 : 컴파일 과정을 통해 컴퓨터가 인식할 수 있는 기계어 코드로 변환되어 실행 가능한 프로그램이
 			되는 과정
컴파일타임에러 : 소스코드가 컴파일 되는 과정 중에 발생하는 syntax error,파일 참조오류 등과 같은 문제들			  로 인해 컴파일이 방해되어 발생하는 오류

오류 유형
런타임에러 : 0으로나누기, 배열index 초과, 메모리 부족,널(Null) 참조 오류
컴파일에러 : Syntax error 등
```

#### 11 - 1 메모리 동적할당

![image](https://user-images.githubusercontent.com/49560745/76371750-a09e9d00-637e-11ea-9b1d-47c383588729.png)



```c++
malloc은 단순히 메모리만 할당하는 함수이기 때문에 개발자가 어떠한 데이터 형을 저장하는지 예측할 수 없다.

예를들어 4바이트를 할당하였을 경우 int형 데이터를 저장하기 위해서 사용하는지, float형 데이터를 사용하는지 예측할 수 없기 때문에 void포인터를 반환하여 개발자가 알맞은 용도로 변환하여 사용할 수 있도록 만든것이다.

예를들어 int형 데이터를 저장하기 위해서는 리턴되는 void*을 int*로 변환해야 한다.

int *i = (int*) malloc (sizeof(int));

1. sizeof(int)의 값은 4이다. 4라는 값을 전달하면서 malloc 함수를 호출한다.
2. 할당된 메모리의 주소가 void*형으로 리턴된다. 리턴되는 void*를 사용하려는 int*형으로 변환한다.
3. 포인터 변수 i에 대입한다.

[예시]

1) malloc함수로 메모리를 동적할당한다.
2) free함수를 이용하여 메모리를 해제한다.
=> 메모리를 동적으로 할당하고, 해제하지 않으면 언젠간 메모리가 부족하게 된다.
    
#include <stdio.h>
#include <stdlib.h>

int main() {
	int arr_1[5];	// 배열 선언
	int *arr_2;		// 포인터 변수 선언
	int i;

	for(i = 0; i < 5; i++) {
		arr_1[i] = i+1;	// 배열에 값 대입
	}

	arr_2 = (int*) malloc(sizeof(int)*5);// 메모리 할당, 배열의 크기만큼 할당하기 위해 5를 곱함

	for(i = 0; i < 5; i++) {
		arr_2[i] = arr_1[i];
		printf("%d ", arr_2[i]);
	}

	free(arr_2);	// free함수를 이용하여 메모리 해제

	return 0;
}

```

### 12. 아키텍처

```
최적화를 목표로 두고 시스템 구성과 동작원리 그리고 시스템의 구성환경등을 설명 및 설계하는 청사진 또는 설계도

1.시스템 구성 및 동작 원리
2.시스템 구성요소에 대한 설계 및 구현을 지원하는 수준을 기술
3.구성 요소 간의 관계 및 외부환경과의 관계 묘사
4.요구사양 및 시스템 수명주기 고려
5.시스템의 전체적인 최적화를 목표
```

### 13. REST API

```
1) REST - Representational State Transfer의 약어
	 - 웹의 장점을 최대한 활용한 아키텍처
	 - 네트워크 상에서 Client와 Server사이의 통신 방식 중 하나
	 - HTTP 기반으로 필요한 자원에 접근하는 방식을 정해놓은 아키텍처
	 	* 자원 : DBMS, 이미지,동영상,문서,파일,서비스(이메일 전송,푸쉬메시지) 등
	 - 자원의 이름(자원의 표현)으로 구분하여 해당 자원의 상태(정보)를 주고 받는 모든 것을 의미
	 	* 자원의 표현 : 그 자원을 표시하기 위한 이름
	 				ex) DB의 학생정보가 자원일 때 'students'를 자원의 표현으로 정한다.
		* 상태(정보) 전달 : 데이터가 요청되어지는 시점에서 자원의 상태(정보)를 전달한다.
						  JSON 혹은 XML을 통해 데이터를 주고 받는 것이 일반적
2) REST의 구체적 개념
	- HTTP URI(Uniform Resource Identifier)를 통해 자원을 명시하고, HTTP 	                         Method(PSOT,GET,PUT,DELETE)를 통해 자원에 대한 CRUD Operaiton을 적용하는 것
	- 웹 사이트의 이미지, 텍스트, DB내용 등의 모든 자원에 고유한 ID인 HTTP URI를 부여한다.
	
3) REST의 장단점
  장점
  	- HTTP 프로토콜의 인프라를 그대로 사용하므로 REST API사용을 위한 별도의 인프라를 구축할 필요가 없	   다.
  	- HTTP 표준 프로토콜에 따르는 모든 플랫폼에서 사용 가능하다.
  	- 언어와 플랫폼에 독립적이다.
  	- 서버와 클라이언트의 역할을 명확하게 분리한다.
  	- REST API 메시지가 의도하는 바를 명확하게 나타내므로 의도하는 바를 쉽게 알 수 있다.
  단점
  	- 표준이 존재하지 않는다.
  	- 사용할 수 있는 Method형태가 제한적이다.
  	  =>HTTP Method 형태가 4가지이다.

4) REST가 필요한 이유
	- 애플리케이션 분리 및 통합
	- 다양한 클라이언트의 등장
	  => 최근의 서버프로그램은 다양한 브라우저와 아이폰,안드로이드폰과 같은 모바일 디바이스에서도
	  통신을 할 수 있어야 한다.
	  
5) REST 구성 요소
	1. 자원(Resource) URI
		- 모든 자원에는 고유한 id가 존재하고, 이 자원은 Server에 존재한다.
		- 자원을 구별하는 ID는‘/groups/:group_id’와 같은 HTTP URI 다.
		- Client는 URI를 이용해서 자원을 지정하고 해당 자원의 상태(정보)에 대한 조작을
		 Server에 요청한다.
	2. 행위(Verb) HTTP Method
		- HTTP 프로토콜의 Method를 사용한다.(GET,POST,PUT,DELETE)
	3. 표현(Representation of Resource)
		- Client가 자원의 상태(정보)에 대한 조작을 요청하면 Server는 이에 적절한 응답				           (Representation)을 보낸다.
		- REST에서 하나의 자원은 JSON, XML, TEXT, RSS 등 여러 형태의 Representation으로 나타내어           질 수 있다.
		- JSON 혹은 XML를 통해 데이터를 주고 받는 것이 일반적이다.

6) REST 특징
	1. Server-Client 구조
		- 자원이있는 쪽이 Server,자원을 요청하는 쪽이 Client가 된다.
		  * REST Server : API를 제공하고, 비즈니스로직 처리 및 저장을 책임진다.
		  	Client : 사용자 인증이나 context(세션,로그인정보) 등을 직접 관리하고 책임진다.
		- 서로간 의존성이 줄어든다.(클라이언트와 서버에서 개발해야할 내용이 명확해지기 때문)
	
	2. Statless(무상태성)
		- Client의 context를 Server에 저장하지 않는다.
		  * 작업을 위한 상태정보를 따로 저장,관리 하지않는다. 즉,세션정보나 쿠기를 별도 저장하지 않음
		 	따라서, 구현이 단순해진다.
		- Server는 각각의 요청을 완전히 별개의 것으로 인식하고 처리한다.
		  * 각 API서버는 Client의 요청만을 단순 처리한다.
		  	서브스의 자유도각 높아진다.
	3. Cacheable(캐시 처리 가능)
		- HTTP가 가진 가장 강력한 특징 중 하나인 캐싱기능을 적용할 수 있다.
		  * 대량의 요청을 효율적으로 이용하기 위해 캐시가 요구됨.
		- 캐시 사용을 통해 응답시간이 빨라지고 REST Server 트랜잭션이 발생하지 않아
		  전체 응답시간,성능,서버의 자원이용률을 향상 시킬 수 있다.
	4. Layerd System(계층화)
		- Client는 REST API Server만 호출한다.
		- REST Server는 다중 계층으로 구성될 수 있다.
		  * API Server는 순수 비즈니스 로직을 수행하고 그 앞단에 보안,로드밸런싱,암호화,사용자 인증
		  	등을 추가하여 구조상의 유연성을 줄 수 있다.
		- PROXY,게이트웨이와 같은 네트워크 기반의 중간매체를 사용할 수 있다.
	5. Self-descriptiveness(자체 표현 구조)
    	- REST API 메세지만 보고도 이를 쉽게 이해할 수 있는 자체표현구조로 되어있다.
    6. Uniform Interface(인터페이스 일관성)
    	- URI로 지정한 Resource에 대한 조작을 통일되고 한정적인 인터페이스로 수행한다.
    	- HTTP프로토콜에 따르는 모든 플랫폼에서 사용가능하다.

 7) REST API
 	* API(Application Programming Interface)란
 	  데이터와 기능의 집합을 제공하여 컴퓨터 프로그램간 상호작용을 촉진하며, 서로 정보를 교환 가능하도록
 	  하는 것
 	REST API 정의
 		- REST기반으로 서비스 API를 구현한 것
 		- 최근 OPEN API(누구나 사용할 수 있도록 공개된 API: 구글 맵, 공공 데이터 등)
 		  마이크로 서비스(하나의 큰 애플리케이션을 작은 애플리케이션으로 쪼개어 변경과 조합이 가능하도		   록 만든 아키텍처) 등을 제공하는 업체 대부분은 REST API를 제공한다.
  
    REST API의 특징
    	- 사내 시스템들도 REST 기반으로 시스템을 분산해 확장성과 재사용성을 높여 유지보수 및 운용을
    	  편리하게 할 수 있다.
    	- REST는 HTTP 표준을 기반으로 구현하므로,HTTP를 지원하는 언어로 클라이언트,서버를 구성할 수 			 있다.
    	- 즉, REST API를 제작하면 델파이 클라이언트 뿐 아니라, 자바, C#, 웹 등을 이용해 클라이언트를 		   제작할 수 있다.
```

### 14. XML JSON

```JAVA
- XML이란? Extensible Markup Language의 약자
XML은 HTML과 매우 비슷한 문자 기반의 마크업언어이다.
이 언어는 기계와 사람이 동시에 읽기 편한 구조로 되어있다.

XML은 HTML처럼 데이터를 보여주는 목적이 아닌 데이터를 저장하고 전달할 목적으로 만들어짐
또한, XML태그는 HTML 태그처럼 미리 정의되어 있지 않고, 사용자가 직접 지정할 수 있다.

- JSON과 XML의 공통점
1. 저장하고 전달하기 위해 고안되었다.
2. 기계뿐만 아니라 사람도 쉽게 읽을 수 있다.
3. 계층적인 데이터 구조를 가집니다.
4. 다양한 프로그래밍 언어에 의해 파싱될 수 있습니다.
5. XMLHttpRequest 객체를 이용하여 서버로부터 데이터를 전송받을 수 있다.

- JSON과 XML의 차이점
1. JSON은 종료태그를 사용하지 않는다.
2. JSON구문이 XML의 구문보다 더 짧다.
3. JSON 데이터가 XML 데이터보다 더 빨리 읽고 쓸 수 있다.
4. XML은 배열을 사용할 수 없지만 JSON은 배열을 사용할 수 있다.
5. XML은 XML 파서로 파싱되며 JSON은 자바스크립트 표준 함수인 eval()함수로 파싱된다.

----------------------------------------------------------------------------------
- XML 예제
<dog>
    <name>식빵</name>
    <family>웰시코기<family>
    <age>1</age>
    <weight>2.14</weight>
</dog>

- JSON 예제
{
    "name": "식빵",
    "family": "웰시코기",
    "age": 1,
    "weight": 2.14
}

- JSON 배열
"dog": [
    {"name": "식빵", "family": "웰시코기", "age": 1, "weight": 2.14},
    {"name": "콩콩", "family": "포메라니안", "age": 3, "weight": 2.5},
    {"name": "젤리", "family": "푸들", "age": 7, "weight": 3.1}
]
        
[JSON 파싱 예제]
{
    "name": "hello!",
    "data": {
        "name": "jspiner",
        "age": 8,
        "birth": 1996
    }
}
 
[JOSN Parser]

JsonParser jsonParser = new JsonParser();

JsonObject jsonObject = (JsonObject) jsonParser.parse(json);
JsonObject dataObject = (JsonObject) jsonObject.get("data");

System.out.print("name : " + jsonObject.get("name"));
System.out.print("name : " + dataObject.get("name"));
System.out.print("age : " + dataObject.get("age"));
System.out.print("birth : " + dataObject.get("birth"));
        
[결과]
name : hello!
name : jspiner
age : 8
birth : 1996
    
[eval()]
<script type="text/javascript">
var jsonStr = "{no:1, name:'용남짱'}";
eval("var Obj = ("+ jsonStr +")" );

document.write(Obj.no + ', ');
document.write(Obj.name);
</script>

[결과]
1, 용남짱
----------------------------------------------------------------------------------        
- JSON의 사용범위
 XML문서는 XML DOM(Document Object Model)을 이용하여 해당 문서에 접근한다.
 하지만 JSON은 문자열을 전송받은 후에 해당 문자열을 바로 파싱하므로, XML보다 더욱 빠른 처리속도를 보인   다. 따라서, HTML과 자바스크립트가 연동되어 빠른 응답이 필요한 웹 환경에서 많이 사용
   
 하지만, JSON은 전송받은 데이터의 무결성을 사용자가 직접 검증해야한다.
 따라서 데이터의 검증이 필요한곳에서는 스키마를 사용하여 데이터의 무결성을 검증할 수 있는 XML이 아직도     많이 사용됨.
    
* 데이터 무결성
 데이터의 무결성은 데이터의 정확성,일관성,유효성이 유지되는 것
 
* 파싱
파싱은 parse에 -ing를 붙인 형태입니다. 주로 어떤 데이터를 다른 모양으로 가공하는 걸 말합니다.
예를 들어 parseInt("3")은 3이라는 스트링형 데이터를 다른 모양(정수)로 가공하는 걸 말합니다.
        
```

### 15. 트랜잭션

```
트랜잭션(Transaction)은 데이터베이스의 상태를 변환시키는 하나의 논리적 기능을 수행하기 위한 작업의 단위 또는 한꺼번에 모두 수행되어야 할 일련의 연산들을 의미한다.

Commit - Commit연산은 한개의 논리적 단위(트랜잭션)에 대한 작업이 성공적으로 끝났고, 데이터베이스가 다		시 일관된 상태에 있을 때 이 트랜잭션이 행한 갱신 연산이 완료된 것을 트랜잭션 관리자에게 알려주		  는 연산

Rollback - Rollback연산은 하나의 트랜잭션 처리가 비정상적으로 종료되어 데이터베이스의 일관성을 깨뜨렸		  을 때, 이 트랜잭션의 일부가 정상적으로 처리되었더라도 트랜잭션의 원자성을 구현하기 위해 트랜		    잭션이 행한 모든 연산을 취소시키는 연산
```

### 16. TDD(Test-Driven Development)

```java
- TDD 란?

매우 짧은 개발 사이클의 반복에 의존하는 소프트웨어 개발 프로세스
우선 개발자는 요구되는 새로운 기능에 대한 자동화 테스트케이스를 작성하고, 
해당 테스트를 통과하는 가장 간단한 코드를 작성한다. 
일단 테스트를 통과하는 코드를 작성한 후 상황에 맞게 리팩토링 하는 과정을 거친다.
말 그대로 테스트가 코드 작성을 주도하는 개발 방식이다.

- Add a Test

 테스트 주도형 개발에선 새로운 기능을 추가하기 전 테스트를 먼저 작성한다. 
 테스트를 작성하기 위해서, 개발자는 해당 기능의 요구사항과 명세를 분명히 이해하고 있어야한다. 
 이는 사용자 케이스와 사용자 스토리 등으로 이해할 수 있으며, 
 이는 개발자가 코드를 작성하기 전에 보다 요구사항에 집중할 수 있도록 도와준다. 
 이는 정말 중요한 부분이자 테스트 주도 개발이 주는 이점이라 할 수 있다.
 
- Run all tests and see if new one fails
  
  어떤 새로운 기능을 추가하면 잘 작동하던 기능이 제대로 동작하지 않는 경우가 발생할 수 있다.
  더 위험한 경우는 개발자가 이를 미처 인지하지 못하는 경우이다.
  이러한 경우를 방지하기 위해 테스트 코드를 작성하는 것이다.
  새로운 기능을 추가할 때 테스트 코드를 작성함으로써, 새로운 기능이 제대로 동작함과 동시에 기존의
  기능들이 잘 동작하는지 테스트를 통해 확인할 수 있는 것이다.
  
- Refactor code

 '좋은 코드'를 작성하기란 정말 쉽지가 않다. 
 코드를 작성할 때 고려해야 할 요소가 한 두 가지가 아니기 때문이다. 
 가독성이 좋게 coding convention 을 맞춰야 하며, 
 네이밍 규칙을 적용하여 메소드명, 변수명, 클래스명에 일관성을 줘야하며, 
 앞으로의 확장성 또한 고려해야 한다. 
 이와 동시에 비즈니스 로직에 대한 고려도 반드시 필요하며, 예외처리 부분 역시 빠뜨릴 수 없다. 
 물론 코드량이 적을 때는 이런 저런 것들을 모두 신경쓰면서 코드를 작성할 수 있지만 
 끊임없이 발견되는 버그들을 디버깅하는 과정에서 코드가 더럽혀지기 마련이다.

 이러한 이유로 코드량이 방대해지면서 리팩토링을 하게 된다. 
 이 때 테스트 주도 개발을 통해 개발을 해왔다면, 테스트 코드가 그 중심을 잡아줄 수 있다. 
 뚱뚱해진 함수를 여러 함수로 나누는 과정에서 해당 기능이 오작동을 일으킬 수 있지만 
 간단히 테스트를 돌려봄으로써 이에 대한 안심을 하고 계속해서 리팩토링을 진행할 수 있다. 
 결과적으로 리팩토링 속도도 빨라지고 코드의 퀄리티도 그만큼 향상하게 되는 것이다. 
 코드 퀄리티 부분을 조금 상세히 들어가보면, 
 보다 객체지향적이고 확장 가능이 용이한 코드, 
 재설계의 시간을 단축시킬 수 있는 코드, 
 디버깅 시간이 단축되는 코드가 TDD 와 함께 탄생하는 것이다.

 어차피 코드를 작성하고나서 제대로 작동하는지 판단해야하는 시점이 온다. 
 물론 중간 중간 수동으로 확인도 할 것이다. 
 또 테스트에 대한 부분에 대한 문서도 만들어야 한다. 
 그 부분을 자동으로 해주면서, 코드 작성에 도움을 주는 것이 TDD 인 것이다. 
 끊임없이 TDD 찬양에 대한 말만 했다. 
 TDD 를 처음 들어보는 사람은 이 좋은 것을 왜 안하는가에 대한 의문이 들 수도 있다.
 
 
- 의문점들

Q. 코드 생산성에 문제가 있지는 않나?
두 배는 아니더라도 분명 코드량이 늘어난다. 비즈니스 로직, 각종 코드 디자인에도 시간이 많이 소요되는데, 거기에다가 테스트 코드까지 작성하기란 여간 벅찬 일이 아닐 것이다. 코드 퀄리티보다는 빠른 생산성이 요구되는 시점에서 TDD 는 큰 걸림돌이 될 수 있다.

Q. 테스트 코드를 작성하기가 쉬운가?
이 또한 TDD 라는 개발 방식을 적용하기에 큰 걸림돌이 된다. 진입 장벽이 존재한다는 것이다. 어떠한 부분을 테스트해야할 지, 어떻게 테스트해야할 지, 여러 테스트 프레임워크 중 어떤 것이 우리의 서비스와 맞는지 둥 여러 부분들에 대한 학습이 필요하고 익숙해지는데에도 시간이 걸린다. 팀에서 한 명만 익숙해진다고 해결될 일이 아니다. 개발은 팀 단위로 수행되기 때문에 팀원 전체의 동의가 필요하고 팀원 전체가 익숙해져야 비로소 테스트 코드가 빛을 발하게 되는 것이다.

Q. 모든 상황에 대해서 테스트 코드를 작성할 수 있는가? 작성해야 하는가?
세상에는 다양한 사용자가 존재하며, 생각지도 못한 예외 케이스가 존재할 수 있다. 만약 테스트를 반드시 해봐야 하는 부분에 있어서 테스트 코드를 작성하는데 어려움이 발생한다면? 이러한 상황에서 주객이 전도하는 상황이 발생할 수 있다. 분명 실제 코드가 더 중심이 되어야 하는데 테스트를 위해서 코드의 구조를 바꿔야 하나하는 고민이 생긴다. 또한 발생할 수 있는 상황에 대한 테스트 코드를 작성하기 위해 배보다 배꼽이 더 커지는 경우가 허다하다. 실제 구현 코드보다 방대해진 코드를 관리하는 것도 쉽지만은 않은 일이 된 것이다.

모든 코드에 대해서 테스트 코드를 작성할 수 없으며 작성할 필요도 없다. 또한 테스트 코드를 작성한다고 해서 버그가 발생하지 않는 것도 아니다. 애초에 TDD 는 100% coverage 와 100% 무결성을 주장하지 않았다.
```

### 17. 함수형 프로그래밍

```java
함수형 프로그래밍의 가장 큰 특징
1) immutable data
2) first class citizen으로서의 function

immutable vs mutable
- immutable : 변경불가능함, immutable 객체는 객체가 가지고 있는 값을 변경할 수 없는 객체를 의미하며
			  값이 변경 될 경우, 새로운 객체를 생성하고 변경 된 값을 주입하여 반환해야한다.
- mutable : 해당 객체의 값이 변경될 경우 값을 변경한다.

first - citizen
- 함수형 프로그래밍 패러다임을 따르고 있는 언어에서의 함수(function)는 
  일급 객체(first class citizen)로 간주된다.

* 일급객체란?
	1) 변수나 데이터 구조안에 함수를 담을 수 있어서 함수의 파라미터로 전달할 수 있고, 함수의 반환값으로
	사용할 수 있다.
	2) 할당에 사용한 이름과 관계 없이 고유한 구별이 가능하다.
	3) 함수를 리터럴로 바로 정의 할 수 있다.
	
	참고 - 리터럴 vs 상수
	리터럴, 상수는 모두 변하지 않는 값(데이터)를 의미한다.
	리터럴은 데이터 그자체를 뜻한다.
	
	즉 상수는 변하지 않는 변수를 뜻하고, 리터럴은 변수에 넣는 변하지 않는 데이터를 의미한다.
	ex) int a=1; //a는 변수가된다.
		final int a=1; // a는 상수가된다.
		// 두 코드에서 1은 모두 리터럴이된다.
```

### 18. git과 git hub 차이

```
git - 지역저장소를 만들고 파일,코드등을 관리하는 작업
	  (local 내에서 소스코드를 관리하는 것)
github - git으로 관리한 자료를 다른 사람들과 공유하고 백업해둘 수 있는 사이트
		반대로 다른사람이 올린자료를 확인하고, 오픈소스 프로젝트기여,어떤 커밋을 했고, 어떤 코드르 올렸		  는지 등을 확인할 수 있다.
		(local에서 관리한 소스코드를 업로드하고 공유할 수 있는 공간)
```

### 19. UML vs ERD

```
소프트웨어 모델링이란 ? 객체나 DB를 그림으로 표현한 것
					모델링을 통해 이해하기 쉽고 사람들간의 소통이 편해진다.
					
소프트웨어는 크게 동작과 데이터로 나뉜다.
이때, UML이 동작이라면 ERD는 데이터 모델링을 하는 것

UML - 프로그램 설계를 표현하기 위해 사용
	  소프트웨어 시스템, 업무 모델링, 시스템의 산출물을 규정하고 시각화하며 문서화하는 언어
	  
ERD - 데이터들의 관계를 그림으로 표현한 것
```

### 20. 데이터베이스 설계

```
요구조건 분석 - 개념적 설계 - 논리적 설계 - 물리적 설계 - 구현

1. 요구조건 분석

"학사정보 시스템 DB를 만들고 싶어요!" "그럼 학생들 기본 정보, 성적, 수강 정보 등을 관리 할 수 있어야 하겠네. 수강 신청도 가능해야 하고 지도교수와의 관계도 명시할 필요가 있겠군. 그럼 학생, 교수, 학과, 과목, 수업등에 대한 테이블 설계가 필요 하겠네"

이런식으로 어떤 용도로 데이터베이스를 만드는가? 에 대해서 논의 하는 것이 요구조건 분석 단계이다.

2. 개념적 설계

대략적인 ER-다이어그램을 그리는 단계라고 생각하면 된다. 엔티티와 관계정도만 표현되면 된다. 학생은 교수와 수강, 강의관계가 있을수도 있고, 지도교수, 지도학생 관계에 있을수도 있다.(DBMS독립적인 개념 스키마 설계) 학생에겐 무조건 지도교수가 있어야 한다고 하면 학생 생성 -> 지도교수 배정이 하나의 트렌젝션이 되어야 할 수도 있다. 이런 관계를 연습장에 러프하게 구성하는 단계라고 볼 수 있다.

3. 논리적 설계

엔티티와 관계 정도만 그려진 ER-다이어그램에서 엔티티를 테이블로 구체화 한다. 학생이란 테이블엔 어떤 Attribute가 있어야 하고, 학생과 교수의 수강관계를 별도의 Relation 테이블로 구성할지를 논의한다.(DBMS에 종송적인 논리적 스키마를 설계) 어떤 테이블에 어떤 값이 Manipulation(삽입, 갱신, 삭제) 될때 또 다른 테이블 또한 같이 Manipulation되어야 하는지를 명확히 설계한다.(트렌젝션 인터페이스 설계)

여기서 부터 계층형 DBMS인지, 관계형 DBMS인지에 따라 하는 일이 바뀌고, 이 모두를 포괄된 표현을 쓰기 때문에 말이 어려운 것인데, 다른 포스팅에서 말했듯이 우리가 사용하는 거의 대부분의 DBMS는 관계형이다. 따라서 테이블을 설계하고 관계를 정립하는 단계라고 생각해버리면 이해하기 편하다.

4. 물리적 설계

앞단계에서 설계했던 테이블의 Attribute의 데이터 타입까지 결정한다. 재적상태를 true/false만 있는 boolean으로 구성할 것인가, Y=재적/N=제적/H=휴학/J=정학 등을 표현할 수 있는 CHAR(1)로 표현할 것인가, 1~255가지의 세부적인 상태를 표현할 수 있도록 TINY INT 형태로 할것인가를 정해야 한다. 그리고 많은 에트리뷰트들 중에서 뭘 인덱스로 할지 정한다. 어떤 형태의 조회 및 갱신이 많이 일어날지 고려를 해야 결정할수 있는 부분이다. 

결국 이정도면 테이블의 모양이 다 나온것이다. 이제 DBMS에 DDL로 CREATE문을 던지기만 하면 될 정도로 설계를 마치는게 물리적 설계이다. 이까지 됐으면 더불어 트랜젝션 또한 실제로 작성을 한다. Auto Commit을 할 것인지, 수동으로 몇몇 과정이 완료 된 후 Commit을 Manual하게 할것인지 결정하고 이에 대한 개발이 이루어진다.

5. 구현

앞서 다 설계된 데이터베이스를 SQL문으로 만들어서 DBMS에 던진다. 실제 그림으로만 있던 스키마를 실제 데이터베이스로 만들어 내는것이다. 하지만 앞선 논리적 설계, 물리적 설계 단계 중에서도 DDL을 적당히 던져가며 DBMS에 실제로 구조가 준완성되어 있더라도 이상한건 아니다. 요즘은 실제로 테이블을 대략적으로 만들고 코딩을 해 가면서 설계를 점점 구체화 해 가는 경우도 많기 때문이다. 하지만 이론적으론, 구현 단계에서 실제 데이터베이스가 만들어 진다고 알고 있으면 된다.

```

