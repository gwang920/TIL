# C++ concept



##### class

```
- 자바의 클래스 개념과 동일하다(?)
- c++의 구조체(struct)개념이 확장 된 것

* 구조체는 하나의 구조로 묶일 수 있는 데이터, 변수들의 집합

- 클래스는 변수뿐만 아니라 함수까지 포함 시킬 수 있다

- private 
 접근 제한자 (비공개)
 데이터 영역을 보호하기 위해 사용
 외부에서 변경하거나 참조할 수 없다

- public
 접근 제한자 (공개)
 외부에서 변경하거나 참조할 수 있다
```



##### 생성자 / 소멸자

```
- 생성자 (Constructor)

ex)

Person::Person()
{
}

- 소멸자 (Destructor)

ex)
 
Person::~Person()
{
}


```

##### inline함수

```
inline함수는 프로그램의 실행 속도를 
향상시키기 위해 사용

일반함수와는 다르게 호출되어 실행되지 않고, 
컴파일 된 함수 코드가 코드안에 직접 삽입된다


- 일반함수 호출시

#include <stdio.h> 


void print() 
{ 
printf("Hello, world!\n"); 
} 

int main() 
{ 

print(); 
return 0; 
}


코드 실행 과정

1.main 시작
2.print 함수 호출
3.main 복귀



- inline함수 호출시

#include <stdio.h> 

void print() 
{ 

printf("Hello, world!\n"); 
} 

int main() 
{ 
print(); 
return 0; 

}


코드 실행 과정

1.일반 함수와 달리 코드자체에 컴파일 되어
삽입되므로 아래의 코드처럼 컴파일 된다

#include <stdio.h> 
int main()
{ 

printf("Hello, world!\n"); 
return 0; 
}



```
