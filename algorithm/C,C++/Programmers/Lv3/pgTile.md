# 프로그래머스 - 타일 장식법

- 카테고리 : 동적계획법(DP)
- 자료형을 int형으로 하면 효율성 오류발생
- => 자료형을 통일하자



```c++
#include <string>
#include <vector>
#include <iostream>
using namespace std;
long long solution(int n) 
{
    vector<long> v;
    v.push_back(1);
    v.push_back(1);
    long long answer = 0;
    long long sum=2;
    for(int i=0;i<n-2;i++){
         v.push_back(v[i]+v[i+1]);
         sum+=v[i+2];
     }
    answer=4*sum-2*(sum-1);
    return answer;
}

```

