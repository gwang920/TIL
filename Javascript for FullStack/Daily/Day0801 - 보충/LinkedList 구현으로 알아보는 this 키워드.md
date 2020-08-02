# LinkedList 구현으로 알게 된 this 키워드

```javascript
 이 문제를 접하기 전까지 this 키워드를 추상적으로만 이해하고 있었다.
 그냥 바인딩해주는 키워드(?)라고만 생각했다.
 아래 코드를 통해서 this 키워드의 역할을 이해하게 되었다.
 
 우선 아래코드로 문제를 살펴보자

-------------------------------------------------------------------------------
               
 function LinkedList(){
    this.head=new Node("head");
    this.findIdx=findIdx;
    this.insert=insert;
}

 function findIdx(index){
    var currnode=this.head;
    console.log(currnode);
     while(index && currnode.next!=null){
         index--;
         currnode=currnode.next;
     }
    return currnode;
}

 function insert(newElement,index){
     var newNode=new Node(newElement);
     //var current=this.findIdx(index);
     var current =findIdx(index);
     newNode.next=current.next;
     current.next=newNode;
}

-------------------------------------------------------------------------------
 1) insert를 거친 findIdx() 호출
 
 insert("head",1); 실행
 
 위 insert함수를 실행하면 findIdx함수가 호출된다.
 이때, findIdx함수 내의 currnode가 "undefined"로 잡힌다.
 
 2) findIdx() 단독 호출

 linkedlist.findIdx(1); 실행
 findIdx만 단독으로 호출하면 undefined가 아닌 "head"가 출력된다.
 
 3) 차이점
 
 바로 this 키워드 때문에 발생한 차이였다.
 우선 findIdx만 단독으로 호출될 때는
 linkedList.findIdx()로 linkedList 생성자 함수로 this 키워드가 바인딩된다.
 
 그와 반대로 insert 함수내에서 findIdx()를 호출할 때 this로 바인딩하고 있지않다.
 
 따라서, 각각 undefined, Node{element: 'head',next :null}이 출력되는 것이다.
 
 아래 예제를 통해 확인해보자
```

- this 바인딩 하지 않은 코드

```javascript
insert로부터 호출된 findIdx()의 currnode는 undefined를 나타낸다.
(출력을 위해 나머지 코드는 주석처리함)
```

![image](https://user-images.githubusercontent.com/49560745/89099098-e17b7900-d427-11ea-9004-c91c29736e00.png)

- this 바인딩 해준 코드

```javascript
insert 함수 내 findIdx를 this 키워드로 바인딩하여 (51 line)
Node{element: 'head',next :null}가 출력됨을 확인할 수 있다.
```

![image](https://user-images.githubusercontent.com/49560745/89099219-a3328980-d428-11ea-8ae5-bce5448c1a2a.png)

# this

```
this는 해당 메서드를 호출한 객체로 바인딩된다.
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

* 참고 : https://webclub.tistory.com/78 this키워드 정리

- LinkedList.js

```javascript
var linkedlist=new LinkedList();
module.exports=linkedlist;

function Node(element){
    this.element=element;
    this.next=null;
}

function LinkedList(){
    this.head=new Node("head");
    this.findPrevious=findPrevious;
    this.find=find;
    this.findIdx=findIdx;
    this.remove=remove;
    this.printList=printList;
    this.insert=insert;
    this.append=append;
}

function append(item){
    var newNode=new Node(item);
    var currnode=this.head;
    while(currnode.next!=null){
        currnode=currnode.next;
    }
    currnode.next=newNode;
}

function find(item){
    var currnode=this.head;
    console.log(currnode);
    while(currnode.element!=item){
        currnode=currnode.next;
    }
    return currnode;
}
function findIdx(index){
    var currnode=this.head;
    console.log(currnode);
     while(index && currnode.next!=null){
         index--;
         currnode=currnode.next;
     }
    return currnode;
}
function findPrevious(item){
    var currnode=this.head;
    while(currnode.next!=null && currnode.next.element!=item){
        currnode=currnode.next;
    }
    return currnode;
}

function insert(newElement,index){
     var newNode=new Node(newElement);
     //var current=this.findIdx(index);
     var current =findIdx(index);
     newNode.next=current.next;
     current.next=newNode;
}

function remove(item){
    var preNode=this.findPrevious(item);
    preNode.next=preNode.next.next;
}


function printList(){
    var currnode=this.head;
    var arr=[];
    while(currnode.next!=null){
        arr+=currnode.element;
        currnode=currnode.next;
    }
    arr+=currnode.element;
    return arr;
}
```

- application.js

```javascript
const linkedlist = require('./LinkedList.js');

linkedlist.append("abc");
linkedlist.append("def");
linkedlist.insert("head",1);
// linkedlist.findIdx(1);
// linkedlist.find(1);
console.log(linkedlist.printList());
```



