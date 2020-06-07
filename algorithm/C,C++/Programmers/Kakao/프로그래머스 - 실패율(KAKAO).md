# 프로그래머스 - 실패율(KAKAO)

```c++
문제 : https://programmers.co.kr/learn/courses/30/lessons/42889

 1) stages를 오름차순으로 정렬한다.
 2) 각 단계마다 실패율을 구하고, 우선순위큐에 삽입한다.(스테이지는 오름차순이므로 음수값으로 넣어준다.)
 	* 실패율을 구할 때 double로 타입캐스팅을 해줘야 정확한 실패율 값이 구해진다.
 3) answer에 push_back 해준다.
```



# 성공

```C++
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <queue>
using namespace std;
priority_queue<pair<double,int>> pq;
vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    int stage[501]={0,};
    sort(stages.begin(),stages.end());
    for(int i=0;i<stages.size();i++){
        stage[stages[i]]++;
    }
    double ch=stages.size();;
    for(int i=1;i<=N;i++){
        double fail=(double)stage[i]/ch;
        ch-=stage[i];
        pq.push({fail,-i});
    }
    
    while(!pq.empty()){
        auto now=pq.top();pq.pop();
        answer.push_back(-now.second);
    }
    
    return answer;
}
```

