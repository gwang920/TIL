### Switch & case 문 break 의 역할

```java
public char randomNuber(){
	
	int number = 1;
    
	char chargen;
	
	switch(number){
	case 1 : 'A';
	case 2 : 'B';
	case 3 : 'C';
	defalut : System.out.println("해당되는 number가 없습니다.");
}
}
System.out.println(randomNumber());

실행결과 => 해당되는 number가 없습니다.

- break문이 없으면 다음 case로 계속 넘어간다.
- default는 switch문의 기본값으로 조건에 맞는 값이 없는경우 실행된다.
```

### return vs break

```java


public static char randomCharGen() {
       
        
        int number =3;
        
        switch(number) {
        case 1: return 'A';
        
        case 2: return 'B';
        
        case 3: return 'C';
        
        case 4: return 'D';
        
        case 5: return 'E';
        
        default : break;
        }
        
        return 'F';
        
    }

System.out.println(randomCharGen());

실행결과 => C

/////////////////////////////////////////////////////////////////////////////////////////

 public String Max(int a[]) {
        
        int index=3;
       
        switch(index) {
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
    
System.out.println(maxSubject);

실행결과 => 과학
```

