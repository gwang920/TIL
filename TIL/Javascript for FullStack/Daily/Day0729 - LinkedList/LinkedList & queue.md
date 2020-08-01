# LinkedList로 Queue 구현하기

```
LinkedList를 collection을 사용하지 않고 구현하다가
LinkedList로 Queue도 구현할 수 있지않을까 하는 의문이 들었다.

queue는 선형 자료구조이고, 선입선출구조이기 때문에

LinkedList에서 {자신의 값, 포인터(다음 값을 가리키는)}을 나타내는 node와
			   {list의 처음 값, 끝 node의 값}을 알려주는 포인터만 있으면
			   queue 구현이 가능할 것같다.

LinkedList로 충분히 구현가능할 것 같다.


* 참고
Queue
선형자료구조의 일종으로 First In First Out(FIFO) 즉, 먼저 들어간 원소가 먼저 나온다.
참고로 Java Collection에서 Queue는 인터페이스이다. 이를 구현하고 있는 Priority queue 등을 사용할 수 있다.
```



