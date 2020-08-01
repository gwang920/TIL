# Map vs HashMap

```
Map은 기본적으로 레드 블랙트리를 기반으로 되어있다.
따라서, Map의 모든 데이터는 정렬되어 저장된다.

HashMap은 Hashtable을 기반으로 한다.
HashMap은 unordered_map이라고 표현하기도 한다.

알고리즘의 차이로 데이터가 N 개일 때 map 은 O(logN)의 탐색 속도를,
unordered_map은 O(1)의 탐색 속도를 각각 갖는다.


따라서, 결론은 다음과 같다.

1. 데이터가 많은 경우에는 HashMap 이 map 보다 성능면에서 유리하다.
2. 문자열을 키로 사용하는 경우 문자열이 길어질 수록 unordered_map 이 map에 비해 더 성능이 떨어질 수 있다.
3. 유사도가 높은 문자열 집합을 키로 사용하는 경우에 map 의 성능이 떨어질 수 있다.

```

