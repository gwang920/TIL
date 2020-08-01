# I. 객체지향언어

#### 1. 코드의 재사용성이 높다.

#### 2. 코드의 관리가 용이하다.

#### 3. 신뢰성이 높은 프로그래밍을 가능하게 한다.

* 객체지향 참고 : <https://woowabros.github.io/study/2016/07/07/think_object_oriented.html>



# II. 객체의 구성요소

##### 1. 속성 - 특성(attribute), 필드(field), 상태(state), 멤버변수(member variable)

##### 2. 기능 - 메서드(method), 함수(function), 행위(behavior)

``` 
ex) TV의 속성과 기능
속성 == 크기,길이,색상,높이,볼륨,채녈 등
기능 == 켜기,끄기,볼륨 높이기,볼륨 낮추기 등
```



# III. 인스턴스의 생성

* 객체 = 인스턴스

  ``` java
  클래스명 변수명;
  변수명 = new 클래스명();
  
  Tv tv;
  tv = new Tv();
  ```

* 예제

  ```java
<<<<<<< HEAD
  import java.util.*;
  
  public class Main{
  	public static void main(String args[]){
  		Tv tv;
  		tv = new Tv();
  		tv.channel = 7;
  		tv.channelDown();
  		System.out.println(tv.channel);
  	}
  }
  
  class Tv{
  	String color;
  	boolean power;
  	int channel;
  	
  	void power(){
  		power= !power;
  	}
  	void channelUp(){
  		++channel;
  	}
  	void channelDown(){
  		--channel;
  	}
  }
  
  [결과]
  6
  ```

* 참고

  ```java
  자바 파일명과 public class의 클래스 명은 일치해야한다.
  =======
  import java.util.*;
  
  public class Main{
  	public static void main(String args[]){
  		Tv tv;
  		tv = new Tv();
  		tv.channel = 7;
  		tv.channelDown();
  		System.out.println(tv.channel);
  	}
  }
  
  class Tv{
  	String color;
  	boolean power;
  	int channel;
  	
  	void power(){
  	power= !power;
  }
  void channelUp(){
  	++channel;
  }
  void channelDown(){
  	--channel;
  }
  
  }
  //  한 파일 내에 클래스가 여러 개 있을 수 있는데, public class는 하나만 존재할 수 있으며, 파일명과 같아야 한다.
  ```


  ```java
* 실습 (수정하자)

  * 'time' 을 활용하여 객체지향을 느껴보자
  * attribute - 날짜 / 시간 /  
  * function - 스탑워치 / 

  package time;
  
  import java.util.Date;
  import java.util.Random;
  import java.util.Scanner;
  
  public class TimeApp {
  	public static void main(String[] args) {
  
  		Time time;
  		time = new Time();
  
  		System.out.println(time.changeStandard());
  		System.out.println("현재날짜 : " + time.getDate());
  		System.out.println("현재시각 : " + time.getTime());
  		System.out.println("STOP - PUSH 'S'");
  
  		Scanner sc= new Scanner(System.in);
  		String butt=sc.next();
  
  		if(butt.equals("S")) {   
  
  			System.out.println(time.stopWatch());
  
  		}
  
  	}
  
  	public static class Time {
  		// attribute  (속성)
  		private int year;
  		private int month;
  		private int day;
  		private int hour;
  		private int minute;
  		private int second;
  		private int standard;
  
  		long startTime;
  		long endTime;
  		Date date = new Date();
  
  		
  
  		// constructor (초기화 or 초기값)
  
  		Time(){
  
  			year = date.getYear();
  			month = date.getMonth();
  			day = date.getDate();
  			hour = date.getHours();
  			minute = date.getMinutes();
  			second = date.getSeconds();
  			standard = 9;   // 서울 표준시간 09:00
  
  			startTime = System.currentTimeMillis();
  		}
  
  		
  
  		// function   (기능)
  		public String getTime() {
  
  			return  Integer.toString(hour)+ ":" +
  					Integer.toString(minute)+ ":"+
  					Integer.toString(second);
  		}
  
  		public String getDate() {
  			return Integer.toString(year+1900) + "-" +
  					Integer.toString(month+1) + "-" +
  					Integer.toString(day);
  
  		} //getYear =>replaced by Calendar.get(Calendar.YEAR) - 1900.
  		  //getMonth =>with the value 0 representing January.  +1
  
  		public float stopWatch() {
  			endTime = System.currentTimeMillis();
  			return (float)(endTime-startTime)/1000;
  		}
  		public String changeStandard() {
  			Random r=new Random();
  			standard+=r.nextInt(24)+1;
  			if(standard>24) {
  				standard-=24;
  			}
  			switch(standard) {
  	        case 9: return "서울";
  	        case 10: return "괌";
  	        case 3: return "바그다드";
  	        case 2: return "헬싱키";
  	        case 16: return "도쿄";
  	        default : return "standard";
  	        }
  		}
  	}
  }
  ```

  

##### * SW설계 메커니즘 

##### 	현실- > (Requirement 분석)  -> OOAD -> OOP

##### ex) TV -> UML / properity / function-> OOP



