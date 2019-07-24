# 정렬

##### sort함수

```
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

