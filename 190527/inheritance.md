# 상속(inheritance)

### I. 상속의 정의

##### 기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것

##### 	- 적은 양의 코드로 새로운 클래스 작성 가능

##### 	- 코드의 추가 및 변경 용이

##### ==> 상속은 코드의 재사용성을 높이고 코드의 중복을 제거하여 프로그램의 생산성/유지보수에 기여

```java
class Parent ()
class Child extends Parent(){}

Parent == 부모클래스
Child == 자식클래스

Child 클래스가 Parent 클래스를 상속한다!
    
 ex)
    
  class Tv {
	boolean power; 
    int channel;
      
    void channelUp(){ ++channel;}
  }

class CaptionTv extends Tv{
    boolean caption;
    void displayCaption(String text){
	if(caption){
		System.out.println(text);
        
    }
    }
}

class captionTest{
	CaptionTv ctv =new CaptionTv();
    ctv.channel=10;             //부모클래스로붙너 상속받은 멤버
    ctv.chnnelUp();				//부모클래스로붙너 상속받은 멤버
    System.out.println(ctv.channel);
}


실행결과
11
```

### II. 클래스간의 관계

##### 포함관계 - 상속이외의 클래스를 재사용 하는 방법

```java
class Circle {
	int x;  //원점의 x좌표
	int y;	//원점의 y좌표
	int r;	//반지름
}

class Point {
	int x;  // x좌표
	int y;  // y좌표
}

Point 클래스르 재사용해서 Circle클래스를 작성하자

class Circle{
	Point c = new point(); // 원점
	int r;
}
```

### III. 클래스간의 관계 결정하기

```java
class Circle{
	Point c= new point();
	int r;
}

class Circle extends Point{
	int r;
}

관계 개념을 명확히 하는 것이 중요

A is a B
A has a B

A Circle is a point 원은 점이다 ?
A Circle is a Shape 원은 도형이다.
    
A Circle has a Shape 원은 도형을 가지고 있다?
A Circle has a Point 원은 점을 가지고 있다.
```

##### - 실습

```java
package company;

public class Employee {
	protected String id;
	protected String name;
	protected double salary;
	protected String dept;   //자유롭게 접근 가능  + 하위 클래스에서 접근가능
	
	public Employee() {
	}
	
	public Employee(String id, String name, double salary, String dept) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", dept=" + dept + "]";
	}
	
	
	public double salaryM() {
		double money=0;
		double temp =0;
		// 4대 보험료 8.4%
		// 세금 3.2% 공제
		temp+=this.salary*0.084;
		temp+=this.salary*0.032;
		money = this.salary-temp;
		
		return money;
	}
	
	public double annSalary() {
		
		double ann=this.salaryM()*12;
		
		return ann;
	}
}

//////////////////////////////
package company;
			//Employee 클래스를 상속
public class Manager extends Employee{
	
	private double incentive;
	
	
	//default constructor;
	public Manager() {
	} 
	//constructor overloading
	public Manager(String id, String name, double salary, String dept, double incentive) {
    
		
		//super(id, name, salary, dept); employee의 컨스트럭터를 이용 + incentive
        //	if id가 private 이면 this.id=id;   접근 x why ? private 때문에
		
		this.id=id; //protected면 하위클래스에서 자유롭게 접근가능
		this.name=name;
		this.salary=salary;
		this.dept=dept;
		this.incentive = incentive;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", salary=" + salary + ", dept=" + dept + ", incentive="
				+ incentive + "]";
	}
	
	@Override //함수의 재정의
	public double salaryM() {
		double money = 0;
		money = super.salaryM() + this.incentive;   //매니저는 인센티브가 있다.
		return money;
	}
	// 통상 private를 쓰지만 팀플에서 protected 쓰기도한다
	// 재정의
	// override 상위 값을 재정의 하겠다
	
}
///////////////////////
package company;

public class Company {

	public static void main(String[] args) {
		
		Employee e1=new Employee("11", "James", 1000, "Dev");
		System.out.println(e1);
		System.out.println(e1.salaryM());
		System.out.println(e1.annSalary());
		
		Manager m1=new Manager("22", "Tom", 1000, "Dev",100);
		System.out.println(m1);
		System.out.println(m1.salaryM());	  // 월급
		System.out.println(m1.annSalary());   // 연봉
	}
}

실행결과
Employee [id=11, name=James, salary=1000.0, dept=Dev]
884.0
10608.0
Manager [id=22, name=Tom, salary=1000.0, dept=Dev, incentive=100.0]
984.0
11808.0
```



