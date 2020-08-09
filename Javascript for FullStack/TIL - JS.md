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

# 3. 배열 중복 제거(indexOf)

```javascript
filter 와 indexOf를 사용하면 배열 요소의 중복제거가 가능하다.
filter는 조건에 부합하는 요소만을 가지고 새롭게 배열을 만들어준다.
indexOf는 해당하는 요소의 index 값을 반환해준다.

아래 예제에서
첫번째 abc는 indexOf("abc") => 0 이된다.
두번째 abc는 indexOf("abc") => 0 이된다. 중복이 되면 가장 앞에 있는 원소의 인덱스를 반환한다.
그리고 bcd indexOf("bcd") => 2가 된다.

따라서 indexof의 값과 index가 일치하는 0번째 abc와 2번째 bcd만이 filter로부터 추출된다.

-----------------------------------------------------------------------------------------
var nums=["abc","abc","bcd"];
let filteredArray = nums.filter((item, index) => nums.indexOf(item) === index );

console.log(filteredArray);

[결과]
[ 'abc', 'bcd' ]
```

# 4. JEST 오류

![image](https://user-images.githubusercontent.com/49560745/89480502-78518800-d7d0-11ea-8749-1f968a3ed3c0.png)

# 5. parseFloat() , parseInt()

```javascript
parseFloat() 문자열을 실수로 바꾸는 함수

문법 
ParseFloat(string)

1) 숫자만 바꾼다 (문자면 NaN반환)
2) 띄어쓰기를 허용하고, 첫번째 문자만 반환

parseFloat('12.34') => 12.34
parseFloat(' 12,34') = 12.34
parseFloat('12,34 56,78') => 12.34
parseFloat('A 12.34') => NaN
```

```javascript
parseInt() 문자열을 정수로 바꾸는 함수

문법
parseInt(stirng,n)

1) string을 n진법일때의 값을 바꿈

parseInt('12.68') => 12
parseInt('100',10) => 100
parseInt('100',2) => 4
parseInt('0x100') => 256
```

