# Algorithm

## Method는 클래스 안에

```
- 메소드는 클래스 안에 선언 한다.
```





## Error) GetMax.java:13: error: missing return statement

```java
java는 모든 경우의 수를 컴파일한다.

public static int max(int a){
	
	for(int i=0;i<10;i++){
		if(a==i) return;
	
	}
return; // a==i가 아닌 경우도 꼭 return 해주자.
}
```



## Queue 사용법

```
import java.util.Queue;
import java.util.LinkedList;

1) 선언
Queue<Integer> q=new LinkedList<Integer>();
Queue<Integer> q=new Array<Integer>();
Queue q=new LinkedList();

2) 사용법
- 삽입 : q.offer(1);
		q.offer(2);
- 출력 : System.out.println(q); => 1 2
- 맨 앞 값 : q.element(); // default가 0?
- 맨 앞 값 : q.peek(); // element와 동일
- 맨 앞 값 삭제: q.poll(); 
- 크기 : q.size();

```



## ArrayList 사용법

```
import java.util.ArrayList;

1) 선언
ArrayList<Integer> List=new ArrayList<>();

2) 사용법
- 삽입 : List.add(0);
	    List.add(1);
	  
- 삭제 : List.remove(1); // List.remove(인덱스);
- 가져오기 : List.get(0); // List.get(인덱스);
- 크기 : List.size();
```

