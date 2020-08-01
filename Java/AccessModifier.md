# 접근지정자

- 접근 지정자는 클래스 내에서 멤버의 접근을 제한한다.

```
public : 모든 접근 허용. 어떠한 클래스가 접근을 하든 모두 허용
protected : 상속받은 클래스 또는 같은 패키지에서만 접근 가능
default : 기본 제한자로써 아무것도 붙이지 않고 사용. 자신 클래스 내부와 같은 패키지 내에서 접근가능
private : 외부에서 접근 불가능. 같은 클래스 내에서 접근 가능
```



## Public

- 모든 접근 허용

```java
class Circle
{
	public float pi=3.141f,radius,area;
	public void area()
	{
		area = pi*radius;
		System.out.println("원의 넓이 : "+area);
	}
}

public class PublicAccessModifier {
	public static void main(String args[])
	{
		Circle c = new Circle();
		c.radius = 8.19f;
		c.area();
	}
}

결과 
원의 넓이 : 25.724789
```



## Protected

- 외부에서 접근 불가능하나 동일 패키지, 상속받은 클래스에선 접근가능
- Protected에서 상속의 개념이 빠지면 default이다.

```java
class A {
protected int num;
...
}

class B extends A {
protected int num;

public init(int n) {
num = n;
}

...

}

```



## Default

- 같은 클래스 내에서 접근 가능

```java
class A {
	int data = 40;
	void msg() { System.out.println("Hello java"); }
}

class Simple {

	public static void main(String args[]) {
		A obj = new A();
		System.out.println(obj.data);
		obj.msg();
	}
}

결과
40
Hello java

```



- 다른 패키지에서 접근 불가능

```java
- A.java

package com.pack; // com 폴더 내에 pack란 하위 디렉토리를 만들고 거기에 A.class를 저장

public class A {
	void msg() { System.out.println("Hello"); }
}

```



```java
- B.java

import com.pack.A; // com 폴더 내의 pack란 하위 디렉토리에 존재하는 A 클래스를 사용

class B {
	public static void main(String args[]) {
		A obj = new A();
		obj.msg();
	}

}

결과
컴파일에러
```



## Private

```java
class A {
	private int data = 40;
	private void msg() { System.out.println("Hello java"); }

}

class Simple {
	public static void main(String args[]) {
		A obj = new A();
		System.out.println(obj.data);
		obj.msg();
	}
}

결과
컴파일에러
```

