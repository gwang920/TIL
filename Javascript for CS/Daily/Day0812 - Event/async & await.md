# async / await

```
async / await은 promise처럼 비동기를 다루는 놈이다.
아래를 보면 myFunc 메소드는 'func'를 return 하지만
async 키워드가 붇은 myAsync()메소드는 promise를 출력한다.

즉, async는 promise를 반환하는 함수이다!
```

```javascript
function myFunc(){
	return 'func';
}
async function myAsync(){
	return 'async';	
}

console.log(myFunc());
console.log(myAsync());

[결과]
func
Promise { 'async' }
```

```
then은 promise 객체를 결과값으로 받는다.
그렇기 때문에 async가 반환하는 promise 객체의 결과값(resolve)인 async가 출력된다.
```

```javascript
async function myAsync(){
	return 'async';	
}

myAsync().then((result)=>{
	console.log(result);
});
[결과]
async
```

```
이제 이를 async await으로 구현해보자.
await은 async가 resolve()될 때까지 기다렸다가
resolve()를 받고 실행된다.

아래 코드는 3초뒤에 async가 출력된다.
```

```javascript
function delayP(sec){
	return new Promise((resolve,reject)=>{
		setTimeout(()=>{
		resolve(new Date().toISOString());
	
	},sec*1000);
	});
}


async function myAsync(){
	await delayP(3);
	return 'async';	
}

myAsync().then((result)=>{
	console.log(result);
});

[결과]
async
```

