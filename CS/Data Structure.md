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

[![image](https://user-images.githubusercontent.com/49560745/77373920-cb401b00-6dac-11ea-9843-fe9e18e06a4b.png)](https://user-images.githubusercontent.com/49560745/77373920-cb401b00-6dac-11ea-9843-fe9e18e06a4b.png)

#### 1-1. c++ / java / javascript 배열

```
Array를 정리하다 헷갈리는 부분이 생겼다.
분명히 자바,c++에서는 할당된 배열의 크기를 변경하지 못했는데
javascript에서는 배열 크기를 자유롭게 변경했던 기억이 있다.

그렇다면 배열의 크기는 변경이 가능한 것인가? 궁금해졌다.

결론부터 얘기하면, c++ 자바는 할당 후 배열의 크기를 변경할 수 없다.(기존배열 copy로만 변경을 흉내(?)낸다)
그에 반해 자바스크립트에서 배열은 자유롭게 크기 변경이 가능하다.

1) c++ / java는 배열의 크기를 변경하려면 새로운 배열을 할당해 기존배열을 copy하는 방식을 사용한다.

2) 자바스크립트 배열

자바스크립트 배열은 동적이다. 
배열의 크기가 필요에 따라 커지거나 작아질 수 있다. 
배열을 생성하거나, 크기가 변경되어 다시 할당을 할 때도 배열 크기를 선언할 필요가 없다. 
자바스크립트 배열은 밀집도가 높지 않고, 각 원소의 인덱스가 연속적이지 않아도 되고, 원소들 사이에 빈자리가 있어도 된다. 
자바스크립트 배열에는 length 프로퍼티가 존재한다.

* reference
https://jongmin92.github.io/2017/01/28/JavaScript/complete-guide-to-javascript-chapter-7/
```



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

```c++
* 시간복잡도
2개의 자식 노드를 갖는 이진트리를 이용해서 M개의 값들 중에서 원하는 값을 찾는다고 가정하자.
처음에는 M개 모두 탐색 대상이된다. 하지만, 첫 번째 자식 노드 층으로 이동하게 되면 그 수가 절반이 된다.
이제 M/2개의 값들이 남게 되는데, 다시 그 자식층으로 넘어가면 M/4개의 값들이 남는다.
이처럼 매번 남은 값들이 절반이 된다.
    
만약 탐색을 해야하는 자료의 수가 2^n 개라면 이진트리를 사용해서 n번의 탐색을 통해 원하는 값을 찾을 수 있다.
    
    log2(2^n)=n이므로, 이진탐색트리를 이용한 이진탐색의 시간복잡도는 log2(N)이 된다.
    다시말해, 자식 노드의 수가 m개인 트리로 N개의 자료에서 원하는 값을 탐색하는 알고리즘의
    시간복잡도는 logm(N)이 된다.


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


=> 참고문제
프로그래머스 - 예산
https://programmers.co.kr/learn/courses/30/lessons/12982

#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int solution(vector<int> budgets, int M) {
    int answer = 0;
    long long sum=0;
    sort(budgets.begin(),budgets.end());
    for(int i=0;i<budgets.size();i++)
            sum+=budgets[i];
    if(sum<=M) return budgets[budgets.size()-1];
    else{
        
        int left=1,right=budgets[budgets.size()-1];  // left=budgets[0]; 로 두면 오답
        while(left<=right){
            int mid=(left+right)/2;
            sum=0;
            for(int i=0;i<budgets.size();i++){
              if(budgets[i]>=mid) sum+=mid;
              else sum+=budgets[i];
            }
            if(sum<M){
                if(answer<mid) answer=mid;
                left=mid+1;
            }else if(sum>M){
                right=mid-1;
            }
          //  else{
          //      answer=mid;
           // }
        }
    }
    return answer;
}
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
삽입

삽입 상태에서 장애가 발생하는 지점은 신규 노드가 삽입되고 나서 
레드 노드가 연속해서 2개가 붙게 될 때이다.

해당 상황에 대해 해결방법이 크게 2가지 경우로 나뉩니다.
Case 1. 부모 노드가 레드인데, 부모님의 형제가 없거나 블랙일 때 - 회전
Case 2. 부모 노드가 레드인데, 부모님의 형제가 레드일 때 - 색상 변환

* 참고
https://m.blog.naver.com/PostView.nhn?blogId=min-program&logNo=221231697752&proxyReferer=http%3A%2F%2F59.29.251.41%2Ftm%2F%3Fa%3DCR%26b%3DWIN%26c%3D300019389618%26d%3D32%26e%3D5206%26f%3DbS5ibG9nLm5hdmVyLmNvbS9taW4tcHJvZ3JhbS8yMjEyMzE2OTc3NTI%3D%26g%3D1585101618430%26h%3D1585101617789%26y%3D0%26z%3D0%26x%3D1%26w%3D2019-07-24%26in%3D5206_1100_00001607%26id%3D20200325
```

### 6. Trie

```java
문자열에서 검색을 빠르게 해주는 자료구조

정수형 자료구조에 대하여 이진검색트리를 이용하면 O(logN)의 시간만에 원하는 데이터를 검색할 수 있다.
그러나, 문자열에서 이진 검색트리를 이용한다면 문자열의 길이가 M이라고 할 때 O(MlogN)의 시간복잡도를 가지게 된다.

이러한 이진트리 검색을 개선하기 위해 Trie 자료구조를 이용하면 O(M)의 시간만에 문자열 검색을 완료할 수 있다.

아래 그림은 문자열 집합 = {"AB" , "ABC", "ACDE", "ACEV", "CD" ,"CE"} 가 존재할 때 트라이의 예이다.

					  "      "
				   /   			\
				  A     		 C
				 / \			/  \
                AB  AC		   CD   CE
               /    / \
             ABC  ACD  ACE
             	  /		 \
                ACDE     ACEV
                
                
   일반적인 트리형태를 띄는 트라이에서 검색할 경우 최대 트리높이까지 탐색하게된다.
   따라서 트리의 높이를 H라고 할 때, 시간복잡도는 O(H)가 된다.
   이때, 트라이 구조에서 트리의 높이는 문자열의 최대길이 M이 되므로
   시간복잡도는 O(M)이 된다.
```

#### 트라이 구현 for C++

```c++
struct Trie {
    bool finish;    //끝나는 지점을 표시해줌
    Trie* next[26];    //26가지 알파벳에 대한 트라이
       
    /*
    *출처 https://k96-ozon.tistory.com/37
    클래스를 가지고 객체를 생성 할 때 (클래스의 인스턴스화라고 함) 자동으로 이 생성자를 호출하고 클래	스가 소멸될 때 소멸자가 자동으로 호출 된다
    
    기본적인 생성자 , 1) 클래스의 이름과 동일 2) 반환형이 선언되어 있지 않고, 실제 반환 x
    객체 생성시 딱 한번만 호출 
    */ 
    Trie() : finish(false) {   // finish = false로 초기화
        memset(next, 0, sizeof(next));
    }
       
    // 소멸자 (delete children), 할당된 메모리가 해제된다.
    ~Trie() {
        for (int i = 0; i < 26; i++)
            if (next[i])
                delete next[i];
    }
       
    void insert(const char* key) {
        if (*key == '\0')  // 숫자 0과 구분하기 위해 \0(문자 0 , 아스키코드 0x20) 사용,문자열의 								끝을 의미
            finish = true;    //문자열이 끝나는 지점일 경우 표시
        else {
            int curr = *key - 'A';
            /*
            char *ptr = NULL 과 char *ptr = 0 은 같은 의미라 볼 수 있습니다. 
			그러나 int a = NULL 과 int a = 0 의 의미는 다릅니다.
			왜냐하면 전자의 경우, NULL의 의미는 a 변수에 주소값 0 을 넣는것이고 후자는 정수 0을 a변				수에 넣는다는 뜻입니다.
			*/
            if (next[curr] == NULL)
                next[curr] = new Trie();    //탐색이 처음되는 지점일 경우 동적할당
            next[curr]->insert(key + 1);    //다음 문자 삽입
        }
    }
       
    Trie* find(const char* key) {
        if (*key == '\0') return this;//문자열이 끝나는 위치를 반환
        int curr = *key - 'A';
        if (next[curr] == NULL) return NULL;//찾는 값이 존재하지 않음
        return next[curr]->find(key + 1); //다음 문자를 탐색
    }
};
```

#### 포인터 연산

```c++
#include <stdio.h>

int main()
{
    int numArr[5] = { 11, 22, 33, 44, 55 };
    int *numPtrA;
    int *numPtrB;
    int *numPtrC;
    
	char *charPtr="54321";
    
    for(int i=0;i<5;i++){
    	printf("%c %s %p %p\n",*charPtr,charPtr,charPtr,&charPtr);
    	charPtr++;
	}
    // char형 포인터 변수에 string 을 할당하면, 반환된 주소 값은 문자열의 첫 번째 문자의 주소값 

    numPtrA = numArr;    // 배열 첫 번째 요소의 메모리 주소를 포인터에 저장

    numPtrB = numPtrA + 1;    // 포인터 연산
    numPtrC = numPtrA + 2;    // 포인터 연산
    
    printf("%p\n", numPtrA);    // 00A3FC00: 메모리 주소. 컴퓨터마다, 실행할 때마다 달라짐
    printf("%p\n", numPtrB);    // 00A3FC04: sizeof(int) * 1이므로 numPtrA에서 4가 증가함
    printf("%p\n", numPtrC);    // 00A3FC08: sizeof(int) * 2이므로 numPtrA에서 8이 증가함
	
	printf("%d\n", *numPtrA);    
    printf("%d\n", *numPtrB);    
    printf("%d\n", *numPtrC);    
    return 0;
}

[결과]
5 54321 0000000000404000 000000000023FE08
4 4321 0000000000404001 000000000023FE08
3 321 0000000000404002 000000000023FE08
2 21 0000000000404003 000000000023FE08
1 1 0000000000404004 000000000023FE08
000000000023FE10
000000000023FE14
000000000023FE18
11
22
33

[출처]
https://dojang.io/mod/page/view.php?id=509
https://dojang.io/mod/page/view.php?id=328
```

[![포인터](https://user-images.githubusercontent.com/49560745/82983030-5d250800-a02a-11ea-9494-ed9e801eef88.JPG)](https://user-images.githubusercontent.com/49560745/82983030-5d250800-a02a-11ea-9494-ed9e801eef88.JPG)

- int 형 배열은 원소를 4byte로 메모리 주소값에 할당한다
- 따라서, 포인터 변수에 +1을 하면 자료형 값 * 1 (4)만큼 주소값이 이동한다.
- char 포인터 변수도 마찬가지로 +1 해주면 char 자료형 크기(1) 만큼 주소값이 이동한다.
- 출처 - https://dojang.io/mod/page/view.php?id=509

### 7. Hash

```
  * 해싱
  하나의 문자열을 원래의 것을 상징하는 더 짧은 길이의 값이나 키로 변환하는 것.
  해싱은 해시테이블과 해시함수로 구성된다.
  
  * 해시함수
  - 해시 함수는 임이의 길이를 갖는 메시지를 입력받아 고정된 길이의 해시값을 출력(고정된 길이의 데이터로 매핑)하는 함수 또는 더 짧은 길이의 값으로 변환하는 함수
  - 키 값으로 코드가 저장되어 있는 주소(혹은 색인)를 산출하는 함수
  
  
  * 해시테이블
  key와 value를 갖는 자료구조이다.

[KEYS] [HASH FUNCTION] [INDEX] [BUCKETS]
  A     ------------->   01      바나나
  B     ------------->   02      사과
  C     ------------->   03       배
  
  해시테이블은 KEY,VALUE 형식으로 저장이 되어 KEY 값을 입력하면 해싱 함수를 통해 VALUE가 RETURN 된다.
  
  * 해시 충돌
  해시함수는 입력값의 수는 무한하지만, 출력값의 가지수는 유한하다. 그렇기에 이러한 경우반드시 충돌이 발생한다.(비둘기집 원리)
  
  
  [KEYS] [HASH FUNCTION] [INDEX] [BUCKETS]
  	A     ------------->   01      바나나 / 사과
  	B     ------------/    02
  	C     ------------->   03       배
  	
  	위는 해시 충돌을 나타낸 것이다. A,B 모두 01 인덱스에 접근하고 있다.
  	이때 BUCKETS의 공간이 충분하지 않다면 오버플로우가 발생한다. 
  	그렇기에 이러한 충돌을 해결해야한다.
  	
  	해시 충돌 해결 기법
  	
  	1) 체이닝(Chaining)
  	 버킷내에 연결리스트를 할당하여 버켓에 데이터를 삽입하다 해시 충돌이 발생하면 연결리스트로 데이터를 연결하는 방식이다. 체이닝의 경우 버켓이 꽉 차더라도 연결리스트로 계속 늘려가기에, 데이터의 주소값은 바뀌지 않는다.

출처: https://preamtree.tistory.com/20 [Preamtree의 행복로그]
  	 
  	 [KEYS] [HASH FUNCTION] [INDEX] [BUCKETS]
  		A     ------------->   01    [바나나] -> [사과] 
  		B     ------------/    02
  		C     ------------->   03       배
  	
  	2) 개방 주소법(Open Addressing)
  	체이닝 기법과는 다르게 데이터의 주소값이 변경되는 기법이다. 해시충돌이 일어나면 다른 버켓에 데이터를 삽입하는 방식을 개방 주소법이라 한다. 
  	먼저 해쉬 함수를 계산하여 계산된 주소에 다른 원소가 없으면 그 자리에 넣고, 이미 존재한다면 정해진 규칙에 따라 다음 자리를 찾게된다.
  	
  	H(X)= (2X+i)/m 이라는 해쉬 함수가 있고
  	[4,5,2,3]을 순차적으로 삽입한다고 하자.

  	 H(4)=4 H(5)=5 H(2)=2 H(3)=4
  	
KEY  INDEX     VALUE
 2 	   0        
    \  1
 3 	  `2        2
  	\  3        
 4  ->`4        4 (3)
 5 	-> 5        5
	   6	
	   
   순차적으로 데이터가 삽입되다가 3을 넣을 때 충돌이 발생하게 된다.

KEY  INDEX     VALUE
 2 	   0        
    \  1
 3 	  `2        2
  	\  3        
 4  ->`4        4 
 5 	-> 5        5
	   6        3
  	
  	이때 개방주소법의 선형 탐색에 따라 다음 빈공간(INDEX=6)에 3이 저장된다.
  	
  	* 참고
  	선형 탐색(Linear Probing): 해시충돌 시 다음 버켓, 혹은 몇 개를 건너뛰어 데이터를 삽입한다.
	제곱 탐색(Quadratic Probing): 해시충돌 시 제곱만큼 건너뛴 버켓에 데이터를 삽입(1,4,9,16..)
	이중 해시(Double Hashing): 해시충돌 시 다른 해시함수를 한 번 더 적용한 결과를 이용함.
	 https://preamtree.tistory.com/20 [Preamtree의 행복로그]
```

