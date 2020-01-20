# 인스턴스 멤버 및 this() 의미

- 인스턴스 멤버 : 인스턴스가 가지고 있는 필드와 메소드를 의미
- this라는 키워드는 필드(전역번수)와 메소드, 생성자의 인스턴스 변수가 같을 때 인스턴스 필드임을 명확하게 하기 위해 사용한다.
- 예제에서 this를 사용하지 않은 jap는 전역변수로 인식되어 0이 출력된다.



# 예제	

```java
import java.lang.System;
class Main {
	  int kor,eng,jap=0; //인스턴스 필드
		 Main(int kor,int eng,int jap){  // java에서 class명과 같으면 생성자로 인식한다.
			this.kor=kor;
			this.eng=eng;
            jap=jap;
			
		}

    public static void main(String[] args) {
     
			Main obj=new Main(10,20,30);
			System.out.println(obj.kor);
			System.out.println(obj.eng);
        	System.out.println(obj.jap);
    }
}


[출력] 
10
20
0

```

