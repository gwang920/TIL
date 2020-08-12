# promise

```
promise 콜백지옥의 해결책이다.
우선 콜백지옥이 무엇인지 살펴보자.
```

```
아래 코드처럼 delay함수를 동기적으로 처리하기 위해 내부에 콜백을 삽입한다.
콜백지옥은 이 내부에 콜백이 무한히 존재하게 될 때를 말한다.
가독성도 떨어지고 유지보수하기 어려워보인다.
```

```javascript
fucntion delay(sec,callback){
	setTimeout(()=>{
		callback(new Date(),toISOString());
	},sec*1000);
}

delay(1,(result)=>{
	console.log(1,result);
    delay(1,(result)=>{
  		console.log(2,resulut);
        delay(1,(result)=>{
    		console.log(3,result);
		})  
	})    
})

[결과]
1 2020-08-12T14:01:21.524Z
2 2020-08-12T14:01:22.551Z
3 2020-08-12T14:01:23.553Z
```

```
이를 promise를 통해 해결할 수 있다.

우선 resolve()는 함수가 정상적으로 실행했을 때의 반환값,
reject()는 함수에 오류가 발생했을 때의 반환값이다.

그리고 delayP() 메소드는 Promise객체를 반환한다.
이를 받는 것이 then이다.
이에 따라 결과의 1~3 line은 Promise 객체의 결과값인 resolve()를 받아
정상적으로 동기적 실행이된다.

결과의 4번째 line에 'undefined'는 프로미스 객체로 resolve값을 리턴 받지 않았기때문에
발생하게된다.
즉, then은 resolve()라는 결과를 받아야만 동기적으로 실행되며 의도한 결과값을 출력할 수 있는 것이다.

마찬가지로 마지막 5번째 line의 'wow'는 resolve()를 받지 않기에 시간 지연없이 곧 바로 실행되는 것을 확인할 수 있다.
```

```javascript
function delayP(sec){
	return new Promise((resolve,reject)=>{
		setTimeout(()=>{
			resolve(new Date().toISOString());
		},sec * 1000);
	});
}

delayP(1).then((result)=>{
    console.log(1,result);
    return delayP(1);
}).then(result=>{
    console.log(2,result);
    return delayP(1);
}).then((result)=>{
    console.log(3,result);
}).then((result)=>{
    console.log(4,result);
    return 'wow';
}).then((result)=>{
    console.log(result);
})

[결과]
1 2020-08-12T14:11:58.659Z
2 2020-08-12T14:11:59.689Z
3 2020-08-12T14:12:00.690Z
4 undefined
wow
```

