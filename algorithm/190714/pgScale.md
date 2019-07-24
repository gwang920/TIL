# 프로그래머스 저울

- 카테고리 : 탐욕법(Greedy)
- <https://programmers.co.kr/learn/courses/30/lessons/42886>
- LV3 문제이지만, 구상에 99% 치중한 문제
- 수학적인 개념을 명확하게 이해할 수 있는 문제였다

```c++
#include <string>
#include <vector>
#include <algorithm>

using namespace std;
// 1 1 2 3 6 7 30
int solution(vector<int> weight) {
    int answer = 1;
    
    sort(weight.begin(),weight.end());
            
    for(int i=0;i<weight.size();i++){
        
        if(answer<weight[i]) break;
        
        answer+=weight[i];
        
        }
    
    return answer;
}
```

