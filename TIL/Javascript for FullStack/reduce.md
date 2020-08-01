# reduce

```javascript
reduce()메서드는 배열의 각 요소에 대해 주어진 리듀서(reducer) 함수를 실행하고,
하나의 결과값을 반환한다.

리듀서 함수는 네 개의 인자를 갖는다.

1. 누산기(accumulator)
	콜백의 반환 값을 누적한다. initialValue가 제공 된 경우 초기값은 initialValue가 된다.
2. 현재 값(currentValue)
	현재 처리할 배열(요소)의 값
3. 현재 인덱스(currentIndex)
	현재 처리할 배열(요소) 값의 인덱스, 0 또는 1부터 시작
4. 원본 배열(array)
	reduce()를 호출한 배열, 리듀서에서 쓰이는 배열
```

## reduce 표현 방식

```javascript
1) 완전함수

-----------------------------------------------------------------------------------------
function add(){
  var a=[0, 1, 2, 3, 4].reduce(function(accumulator, currentValue, currentIndex, array) {
  return accumulator + currentValue;
})
  return a;
};
// expected output : 10
console.log(add());
-----------------------------------------------------------------------------------------

2) 화살표 함수

-----------------------------------------------------------------------------------------
function add(){
  var a=[0, 1, 2, 3, 4].reduce( (prev, curr) => prev + curr );
  return a;
};
// expected output : 10
console.log(add());
-----------------------------------------------------------------------------------------

```

- array=[0,1,2,3,4] 의 작동 방식을 살펴보자

| callback   | accumulator | currentValue | currentIndex | array       | 반환 값 |
| ---------- | ----------- | ------------ | ------------ | ----------- | ------- |
| 1번쨰 호출 | 0           | 1            | 1            | [0,1,2,3,4] | 1       |
| 2번째 호출 | 1           | 2            | 2            | [0,1,2,3,4] | 3       |
| 3번째 호출 | 3           | 3            | 3            | [0,1,2,3,4] | 6       |
| 4번쨰 호출 | 6           | 4            | 4            | [0,1,2,3,4] | 10      |

## 1) 배열의 모든 값 합산

```javascript
-----------------------------------------------------------------------------------------
const array1 = [1, 2, 3, 4];

const reducer = (accumulator, currentValue) => accumulator + currentValue;
// 1 + 2 + 3 + 4
console.log(array1.reduce(reducer));
// expected output: 10

// 5 + 1 + 2 + 3 + 4
console.log(array1.reduce(reducer, 5));
// expected output: 15

-----------------------------------------------------------------------------------------
const array2 = ["1","2","3","4"];
const reducer2= (accumulator, currentValue) => accumulator + currentValue;

// "1" + "2" + "3" + "4"
console.log(array2.reduce(reducer));
// expected output : "1234"

// "5"+"1"+"2"+"3"+"4"
console.log(array2.reduce(reducer,5));
// expected output" "51234" 
// 숫자 + 문자 = 문자 로 인식한다.
-----------------------------------------------------------------------------------------
```

## 2) 객체 배열에서의 값 합산

```javascript
객체 배열들어 있는 값을 합산하기 위해서는 반드시 초기값(initialValue)을 설정해줘야한다.

1) 완전함수 방식

-----------------------------------------------------------------------------------------
var initialValue=0;
var sum=[{x:1},{x:2},{x:3}].reduce(function(accumulator,currentValue){
	return accumulator+currenValue;
},initialvalue)

console.log(sum) // 6
-----------------------------------------------------------------------------------------

2) 함수 표현식

-----------------------------------------------------------------------------------------
var initialvalue=0;
var sum=[{x:1},{x:2},{x:3}].reduce((accumulator,currentValue)=>accumulator+currentValue,initialValue);

console.log(sum) // 6
-----------------------------------------------------------------------------------------
```

## 3) 객체 배열 연결하기

```javascript
-----------------------------------------------------------------------------------------
1) 객체내 배열 연결하기
    
var friends = [{
  name: 'Anna',
  books: ['Bible', 'Harry Potter'],
  age: 21
}, {
  name: 'Bob',
  books: ['War and peace', 'Romeo and Juliet'],
  age: 26
}, {
  name: 'Alice',
  books: ['The Lord of the Rings', 'The Shining'],
  age: 18
}];

var allbooks = friends.reduce(function(accumulator, currentValue) {
  return [...accumulator, ...currentValue.books];
}, ['Alphabet']);

console.log(allbooks);
//> Array ["Alphabet", "Bible", "Harry Potter", "War and peace", "Romeo and Juliet", "The Lord of the Rings", "The Shining"]
-----------------------------------------------------------------------------------------
2) 객체내 객체 연결하기    
    
var friends = [{
  name: 'Anna',
  books: ['Bible', 'Harry Potter'],
  age: 21
}, {
  name: 'Bob',
  books: ['War and peace', 'Romeo and Juliet'],
  age: 26
}, {
  name: 'Alice',
  books: ['The Lord of the Rings', 'The Shining'],
  age: 18
}];

var allname = friends.reduce(function(accumulator, currentValue) {
  return [...accumulator, ...currentValue.name];
}, ['Alphabet']);

console.log(allname);
//> Array ["Alphabet", "A", "n", "n", "a", "B", "o", "b", "A", "l", "i", "c", "e"]
// 객체의 요소가 배열형태가 아닌경우 문자열의 문자를 하나의 객체로 보고 연결한다

```





