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

[![image](https://user-images.githubusercontent.com/49560745/77373920-cb401b00-6dac-11ea-9843-fe9e18e06a4b.png)