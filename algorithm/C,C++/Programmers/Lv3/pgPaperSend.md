# 프로그래머스 종이접기

- 서머/윈터코딩은 규칙 찾기나 수학적 공식을 이용하는 풀이가 주가 되는 것같다

- 규칙을 찾아내는 문제





```c++
#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n) {
    vector<int> answer;
    for(int i=0;i<n;i++){
        int size=answer.size();
        answer.push_back(0);
        for(int j=size-1;j>=0;j--){
            if(answer[j]==0) answer.push_back(1);
            else answer.push_back(0);   
        }
    }
    return answer;
}
```

