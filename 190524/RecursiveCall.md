# I.재귀호출(recursive call)

##### - 메서드의 내부에서 자신을 다시 호출하는 것

- 알고리즘에서 유용하다(?)

```java
void method(){
	method();   //재귀호출. 메서드 자신을 호출한다.
}
```



##### - 재귀호출의 대표적인 예) 팩토리얼 계산

```java
class FactorialTest{
	public static void main(String args[]){
		int result = factorial(45);
		
		Systme.out.println(result);
	}
	
	static int factorial(int n){
		int result=0;
		
		if(n==1)
			result=1;
		else
			result = n* factorial(n-1);  //다시 메서드 자신을 호출한다.
		return result;
}
}

 5 * factorial(4)
       4 * factorial(3)
    	     3* factorial(2)
    		      2* factorial(1)
    			       1
     
실행결과 => 120
```



##### - 실습

#####    x^1 부터 x^n 까지의 합을 구하자

```java
class PowerTest {
    public static void main (String[] args){
		int x=2;
        int n=5;
        int result=0;
        
        for(int i=1;i<=n;i++){
			result+=power(x,n);
        }
        System.out.println(result);
    }
    
    
    static long power(int x,int n){
		if(n==1) return x;                         // 2*p4*p3*p2*p1(==2)  n기준
        return x*power(x,n-1);
    }
}

2^5 ( 2 * power(2,4)
    		2 * power(2,3)
    			   2 * power(2,2)
    					  2 * power(2,1) 
    						        2 )
    + 2^4 ( 2 * power(2,3)
    			   2 * power(2,2)
    					  2 * power(2,1)
    						        2 )
    
          + 2^3  ( 2 * power(2,2)
    				   2 * power(2,1)
    					          2 )
                
    			+2^2 ( 2 * power(2,1) 
                         		              2 )
    					     
                     		    +2^1 ( 2 )

실행결과 => 62
```

추가 실습 = > 재귀 알고리즘 풀어보자
<<<<<<< HEAD



재귀 
=======
>>>>>>> 77479ae67562148ec0413d783ffc5c8674cf0839
