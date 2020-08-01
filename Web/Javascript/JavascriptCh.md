# Javascript 특징



```html
// 실행가능 : 함수는 어디서든 호출 된다.
<script>
	a();
function a(){
	alert('a');
};
var b=function(){
	alert('b');

}
</script>

// 실행 불가 : var는 선언되기 전에 호출 될 수 없다.
<script>
	b();
function a(){
	alert('a');
};
var b=function(){
	alert('b');

}
</script>



```

```html
<script>
function a(i){
	return 10*i;
};
function b(j){

	return 20*j;
};

function c(i,j){
	 var result=i()+j();
	 return result;

};
var data=c(a(2),b(2));         // 함수를 argument로 넣어 줄 수있지만
alert(data);				   // 오류 : a(2)는 20이라는 값이 되기때문에
</script>				 // var result=i(1)+j(2); var data=c(a(),b()); : 가능

```






```javascript
function Person(name,age){               //함수랑 구조가 같고 앞문자만 대문자
	
this.name=name;
this.age=age;

};

Person.prototype.print=function(){

alert(this.name + ' ' + this.age);

};     // 함수 호출시 한번만 호출


-------------비교 - 메모리관점에서

function Person(name,age){               //함수랑 구조가 같고 앞문자만 대문자
	
	
	this.name=name;
	this.age=age;
	this.print=function(){

		return this.name+ ' ' + this.age;   
	};                                        // 함수 호출시 매번 호출

};
```




```javascript
var Sk = {
	data:10,
	a:function(){alert('sk');}
};
var Hb = {
	data:20,
	a:function(){alert('hb');}
};


Sk.a();       // 구분을 명확하게 하기 위해 


// function a(){ alert('a');};
// function a(){ alert('aa');};          // 함수 이름이 같아도 에러는 안난다
// a();
```