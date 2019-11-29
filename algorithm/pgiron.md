# 프로그래머스 쇠막대기

<https://programmers.co.kr/learn/courses/30/lessons/42585>

- 스택/큐를 이용하는 문제이지만 굳이 사용하지 않아도 풀린다
- 크게 answer에 영향을 미치는 괄호의 순서 조합을 3가지로 나눴다
- "( ("  막대 추가로 cnt 증가  :  cnt++
- "( )"  레이저를 만나 answer에 + cnt   :  answer + cnt
-  ") )"  막대 cnt 감소  :  cnt -- (+) 마지막 조각 answer에 +1  :  answer++;



```c++
#include <string>
#include <vector>

using namespace std;

int solution(string arrangement) {
    int answer = 0;
    int cnt=0;
    for(int i=0;i<arrangement.size();i++){
        
        if(arrangement[i]=='(' && arrangement[i+1]=='('){
            cnt++;
        }
        
        if(arrangement[i]=='(' && arrangement[i+1]==')'){
            answer+=cnt;
         
        }
        if(arrangement[i]==')' && arrangement[i+1]==')'){
            cnt--;
            answer++;
        }
        }
    return answer;
}
```

