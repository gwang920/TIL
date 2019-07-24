# 프로그래머스 카펫

카테고리 : 완전탐색

<https://programmers.co.kr/learn/courses/30/lessons/42842>

```c++
#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int red) {
    vector<int> answer;
    int sum=brown+red;
    int x=sum,y;
    while(1){
     if(x*y==sum && brown==2*x+(y-2)*2){
         answer.push_back(x);
         answer.push_back(y);
         return answer;
     }
        x--;
        y=sum/x;        
    } 
}
```

