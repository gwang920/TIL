# 1. 객체 요소(value)를 배열 형태로 넣기

```
reduce를 활용해서 데이터를 취합하고자 
객체 {key:value} 형식을 {key:[value]}로 변형해줬다.
이때, 새로운 데이터를 추가하고자 할 때 아래와 같은 문제가 발생했다.
해결 방법은 실패코드 아래에 기재해놓았다.
```

## 실패

- object, array형태로 push 하기

```javascript
* list = add$$자바 공부하기$$["fisrt","pg"]
1) 

function Add(list){
  var rand=Math.floor(Math.random()*1000);
  var Data=new Object();
  var arr=new Array();
  arr.push(rand.toString());
  arr.push(list[1]);
  arr.push(list[2]);
  Data.id=arr[0];
  Data.value=arr[1]; 
  Data.tag=arr[2];
  info.todo.push(Data);
  return rand;
}

2)

function Add(list){
  var rand=Math.floor(Math.random()*1000);
  var Data=new Object();
  Data.id=toString(rand;
  Data.value=list[1]; 
  Data.tag=list[2];
  info.todo.push(Data);
  return rand;
}
-----------------------------------------------------------------------------------------
[OUTPUT]
var info={
 todo:[
  { id: [Array], value: [Array], tag: [Array] },
  { id: [Array], value: [Array], tag: [Array] },
      id: '962',
      value: '자바 공부하기',
      tag: '["fisrt","pg"]'
    }
  ]
}
```

## 성공

- 형태를 지정해주고 push해주면 value 값을 배열형태로 삽입할 수 있다.

````javascript
function Add(list){
  var rand=Math.floor(Math.random()*1000);
  var Data=new Object();
  info.todo.push({id:[rand.toString()],value:[list[1]],tag:[list[2]]});
  return rand;
}

-----------------------------------------------------------------------------------------
[OUTPUT]
var info={
  todo: [
    { id: [Array], value: [Array], tag: [Array] },
    { id: [Array], value: [Array], tag: [Array] },
    { id: [Array], value: [Array], tag: [Array] }
  ]
}
````

# 2. 배열 요소 삭제

```javascript
let b= [1, 2, 3, 4]; 
const idx = b.indexOf(1); // 1의 index (0) 값 반환
if(idx>-1) b.splice(idx, 1); // 배열에 해당되는 값이 없으면 -1이 반환된다

console.log(b);
console.log(idx);

-----------------------------------------------------------------------------------------
[OUTPUT]
[ 2, 3, 4 ]
0
```

