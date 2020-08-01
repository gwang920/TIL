# LinkedList 구현하기

## 기능

```javascript
LinkedList를 활용해 데이터를 관리하는 어플리케이션을 구현했다.
LinkedList에서 append,insert,delete 3 가지의 기능을 구현했다.

append는 뒤로 삽입
insert는 중간에 삽입
delete는 데이터 삭제기능으로 구현했다.

readline을 통해 사용자의 입력을 받고
사용자가 데이터 리스트를 삽입,삭제할 수 있도록하며,
이에 대한 결과를 매번 return해줬다.
```

## 시간복잡도

```
serch(find)할 때 시간복잡도 최악의 경우는 O(N)
insert도 최악의 경우 O(N)
(왜냐하면 삽입 자체는 O(1)의 시간복잡도를 갖지만 탐색을 하는데 O(N)의 시간복잡도가 발생하기 때문)
delete도 insert와 같다.

```

## 보완해야할 점

```javascript
1) insert - index 기준으로 사용하기

이때 원소를 탐색할 때 index기준이 아닌 (물론 index를 찾는 함수는 구현했다. 그런데 index기준으로 삽입 구현이 안됐다.)
데이터의 원소를 기준으로 탐색하도록 했다.

예를들어 데이터 "A" 뒤에 데이터 "B"를 삽입한다면

LinkedList("B","A");
와 같이 호출되고 함수는 동작은 아래와 같다.

function insert(newElement, item) {
    var newNode = new Node(newElement); //새로운 노드 생성
    var current = this.find(item); // 삽입할 위치의 노드 찾기
    newNode.next = current.next; // 찾은 노드가 가리키는 노드를 새로은 노드가 가리키기
    current.next = newNode; // 찾은 노드는 이제부터 새로운 노드를 가리키도록 하기
}

2) videoStruct클래스의 link 사용하기

VideoStruct라는 클래스 안의 link를 다음 노드를 가리키는 포인터로 사용하기 위해 구현했는데, 사용하지 않고 node를 구현해 링크드리스트의 노드자체를 표현했다.

3) 모듈화하기

 하나의 파일에 모든 코드를 구현하니 가독성이 떨어지고 실수도 많이 발생했다.
 모듈화를 통해 코드를 분리하는 방법을 생각해보자
```



# Code

```javascript
//var module = require('./LinkedList')
var linkedList = new LinkedList();
var linkedListsize=0;
var flag=true;

////////////////////////////////////////// LinkedList //////////////////////////////////////////
// node 구현
function Node(element) {
    this.element = element;
    this.next = null;
}
 
// Linked List 구현
function LinkedList() {
    this.head = new Node("head");
    this.find = find;
    this.append = append;
    this.insert = insert;
    this.remove = remove;
    this.PrintList = PrintList;
    this.calcResult=calcResult;
    this.findPrevious = findPrevious;
}
 
// 노드 찾기
function find(item) {
    var currNode = this.head;
    while(currNode.element != item) {
        currNode = currNode.next;
    }
    return currNode;
}
 
// 이전 노드 찾기
function findPrevious(item) {
    var currNode = this.head;
    while(currNode.next != null && currNode.next.element != item) {
        currNode = currNode.next;
    }
    return currNode;
}

 
// 노드 추가
function append(newElement) {
    var newNode = new Node(newElement); //새로운 노드 생성
    var current = this.head; // 시작 노드
    while(current.next != null) { // 맨 끝 노드 찾기
        current = current.next;
    }
    current.next = newNode;
}
 
// 노드 중간 삽입
function insert(newElement, item) {
    var newNode = new Node(newElement); //새로운 노드 생성
    var current = this.find(item); // 삽입할 위치의 노드 찾기
    newNode.next = current.next; // 찾은 노드가 가리키는 노드를 새로은 노드가 가리키기
    current.next = newNode; // 찾은 노드는 이제부터 새로운 노드를 가리키도록 하기
}


// 노드 삭제
function remove(item) {
    var preNode = this.findPrevious(item); // 삭제할 노드를 가리키는 노드 찾기
    preNode.next = preNode.next.next; // 삭제할 노드 다음 노드를 가리키도록 하기
}
 
// 연결 리스트의 요소들을 출력
function PrintList() {
    var str='|';
    var currNode = this.head;
    while(currNode.next != null){
        str += `---[${currNode.next.element.id}, ${currNode.next.element.videoLength}sec]`;
        currNode = currNode.next;
    }
    str+="---[end]";
    return str
}
```

