# I. 변수와 메서드

###  1) 선언위치에 따른 변수의 종류

* 클래스변수 (method) : static + 인스턴스변수 / 공통적 (C의 전역변수 개념) 으로 값을 유지
* 인스턴스 변수 (heap) : 클래스 영역에 선언 / 독립적
* 지역 변수 (stack) : 매서드 내에 선언 / 매서드가 종료되면 소멸

```java
class Variables
{
	int iv;        // 인스턴스변수
	staric int cv; // 클래스변수(static변수, 공유변수)
	
	void method(){
	int lv=0;      // 지역변수
	}
}
```

## 2) 클래스변수와 인스턴스변수

* 클래스변수와 인스턴스변수의 차이를 느껴보자
  * 카드게임
    * 속성 (무늬, 숫자) : 인스턴스변수 -> 7,4,3 / 하트,클로버 등 변화가능한 요소
    * 속성 (폭, 높이) : 클래스변수 -> 모든 인스턴스가 공통적으로 같은 값으로 유지 되어야할 요소

``` java
class Card{
	String kind;          // 무늬
	int number;			  // 숫자
	
	static int width = 100;  // 폭
	static int height = 250; // 높이
}

//만약 카드의 높이를 변경해야할 때, 모든 카드의 height값을 변경하지않고 한 카드의 height값만 변경해도 모든 카드의 height 값이 변경된다.


```

## 3) 메서드

* 메서드를 사용하는 이유

  ##### 1. 높은 재사용성

  ##### 2. 중복된 코드의 제거

  ##### 3. 프로그램의 구조화

```java

메서드 구조

반환타입 메서드이름 (타입 변수명,타입 변수명, ...)
{
	// 메서드 호출시 수행될 코드
}

int add(int a,int b)
{
	int result = a + b;
	return result;  //호출한 메서드로 결과를 반환한다.
}
```



* 실습

  ```java
  //	4과목의 점수를 입력 받는다.국어, 영어, 수학, 과학
  //	입력 예: 89 92 89 100
  //
  //	입력 받은 점수를 이용하여 다음을 출력 하시오
  //	1. 합을 출력 하시오
  //	2. 평균을 출력 하시오
  //	3. 평균이 90점 이상이면 A, 80점 이상이면 B, 70점 이상이면 C, 60점 이상이면 D, 이하면 F
  //	4. 최고점의 과목을 출력 하시오
  //	5. 최하점의 과목을 출력 하시오
  //	6. 오름차순 정렬 
  //	7. 내림차순 정렬
  
  --Grade.java
  
  package ws;
  
  public class Grade {
  
  	public int sum(int a[]) {
  		int sum=0;
  		for(int i=0;i<a.length;i++) {
  			sum+=a[i];
  		}
  		return sum;
  	}
  	
  //	public static double avg(int a[]) {
  //		int avg=0, sum=0,grade=0;
  //
  //		for(int i=0;i<a.length;i++) {
  //			sum+=a[i];
  //		}
  //		avg=sum/a.length;
  //		switch((int)avg/10) {
  //		case 9: grade='A';
  //		case 8: grade='B';
  //		case 7: grade='C';
  //		case 6: grade='D';
  //		default : grade='F';
  //		}
  //		return avg;   // 두 개의 리턴 값? int + char ?
  //	}
  	public double avg(int a[]) {
  		int avg=0, sum=0,grade=0;
  
  		for(int i=0;i<a.length;i++) {
  			sum+=a[i];
  		}
  		avg=sum/a.length;
  		switch((int)avg/10) {
  		case 9: grade='A';
  		case 8: grade='B';
  		case 7: grade='C';
  		case 6: grade='D';
  		default : grade='F';
  		}
  		return avg; 
  	}
  	
  	public char grade(int a[]) {
  		int avg=0, sum=0;
  				char grade=0;
  
  		for(int i=0;i<a.length;i++) {
  			sum+=a[i];
  		}
  		avg=sum/a.length;
  		switch((int)avg/10) {
  		case 9: grade='A';
  		case 8: grade='B';
  		case 7: grade='C';
  		case 6: grade='D';
  		default : grade='F';
  		}
  		return grade;
  		
  	}
  	public String Max(int a[]) {
  		int max=0;
  		int maxindex=0;
  		String maxSubject;
  		for(int i=0;i<a.length;i++) {
  			if(max<a[i]) {
  				maxindex=i;
  			}
  		}
  		switch(maxindex) {
  		case 0: maxSubject="국어";
  				break;
  		case 1: maxSubject="영어";
  				break;
  		case 2: maxSubject="수학";
  				break;
  		case 3: maxSubject="과학";
  				break;
  		default : maxSubject="null";
  		}
  		return maxSubject;
  		
  	}
  	public String Min(int a[]) {
  		int min=100;
  		int minindex=0;
  		String minSubject;
  		for(int i=0;i<a.length;i++) {
  			if(min<a[i]) {
  				minindex=i;
  			}
  		}
  		switch(minindex) {
  		case 0: minSubject="국어";
  				break;
  		case 1: minSubject="영어";
  				break;
  		case 2: minSubject="수학";
  				break;
  		case 3: minSubject="과학";
  				break;
  		default : minSubject="null";
  		}
  		return minSubject;
  		
  	}
  	public int[] asc(int a[]) {
  		
  		int temp=0;
  		for(int i=0;i<a.length;i++) {
  			for(int j=0;j<a.length;j++) {
  				if(a[i]<a[j]) {
  					temp=a[i];
  					a[i]=a[j];
  					a[j]=temp;
  				}
  			}
  		}
  		return a;
  		
  	}
  	public int[] dsc(int a[]) {
  		
  		int temp=0;
  		for(int i=0;i<a.length;i++) {
  			for(int j=0;j<a.length;j++) {
  				if(a[i]>a[j]) {
  					temp=a[i];
  					a[i]=a[j];
  					a[j]=temp;
  				}
  			}
  		}
  		return a;
  	}
  }
  
  
  
  --GradeTest.java
  
  
  package ws;
  
  import java.util.Arrays;
  import java.util.Scanner;
  
  
  public class GradeTest {
  
  	public static void main(String[] args) {
  		int a[]=new int[4];
  		System.out.println("점수를 입력하시오 : (국어,영어,수학,과학)");
  		Scanner sc=new Scanner(System.in);
  		for(int i=0;i<a.length;i++) {
  			a[i]=sc.nextInt();
  		}
  		
  		Grade g=new Grade();
  		
  		System.out.println("합="+g.sum(a));
  		System.out.println("평균="+g.avg(a));
  		System.out.println("등급="+g.grade(a));
  		System.out.println("MAXsub="+g.Max(a));
  		System.out.println("MINsub="+g.Min(a));
  		System.out.println("오름차순 "+Arrays.toString(g.asc(a)));
  		System.out.println("내림차순 "+Arrays.toString(g.dsc(a)));
  		
  	}
  }
  ```

  



##### * 캡슐화 장점

오류 데이터가 들어가는 것을 막는다

```java
ex) public int setcfSize{	

	return cfSize

}

기름통의 사이즈 = 50일때
현재 기름 cfSize는 50 초과하는 것을 막아준다
```
