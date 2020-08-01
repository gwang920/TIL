# 정렬

##### sort함수

```c++
sort(시작 값,종료 값, default(오름차순))


ex)
#include <algorithm>

int arr[5]={4,3,1,5,2};
Print(arr);  //정렬 전
sort(arr,arr+n);
Print(arr);   // 정렬 후

출력

arr[i] : 4 3 1 5 2
arr[i] : 1 2 3 4 5


ex)vector 정렬

#include <algorithm>

vector<int> d;

sort(d.begin(),d.end());             // 오름차순 정리
sort(d.begin(),d.end(),greater<int>());  // 내림차순정리
sort(d.begin(),d.end(),compare)     // 사용자 정의 함수 사용
```

#초기화


방문처리 배열을 초기화할 때 for문안에
선언하고 초기화해주면 매번 초기화가 자동으로
돈다

for(int i=0;i<N;i++){


 int visited[10001]={};



}
