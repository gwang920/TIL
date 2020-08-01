# Call by Value 와 Call by Reference

- Call by Value : 값에 의한 호출
  - 데이터를 복사해서 함수로 전달하기 때문에 데이터가 변경 될 가능성이 없으나
  - 인자를 넘겨줄 때 마다 메모리에 공간이 할당 되기에 메모리 공간을 잡아먹는다.
- Call by Reference : 참조에 의한 호출
  - 반대로 Call by Reference는 메모리 공간 할당의 문제에서 벗어나긴 하지만
  - 데이터 값이 훼손(변경)된다.



## Call by Value

- 쉽게 말해 func함수와 main 함수의 값을 다르게 할 때 사용한다.
- func 함수 n 은 10 -> 20
- main 함수 n 은 10 으로 변화없다.
- 즉, main 함수의 n과 func함수의 n은 '서로 다른 메모리 공간'에 존재한다.

```c++
#include <stdio.h>

void func(int n){
	n=20;
}
int main(){
	
	int n=10;
	func(n);
	printf("%d",n);
	return 0;
}

출력 : 10
```



## Call by Reference

- main함수의 값과 func함수의 값을 동일하게 만들어줄 때 사용한다.
- func 함수 n 은 10 -> 20
- main 함수 n 도 10 -> 20 이 된다.
- 즉, Call by Reference를 사용하면 main 함수의 n과 func함수의 n은 '같은 공간'에 상주하게 된다.

```c++
#include <stdio.h>

void func(int &n){
	n=20;
}
int main(){
	
	int n=10;
	func(n);
	
	printf("%d",n);
	return 0;
}

출력 : 20
```

