# 프로그래머스 - 도둑질

- 카테고리 : DP(동적계획법)

- STEP 1. 모든 경우의 수를 포함하도록 문제를 분할한다.
  - 해당 문제에서는 첫번째 집을 터는 경우와 그렇지 않은 경우 두 가지로 큰틀을 나눌 수 있다.
- STEP 2. 점화식을 세운다.
  - 이전의 DP 값(dp[i-1]) 과 그 이전의 DP 값(dp[i-2]) + money[i]의 값을 비교하여 큰 값을 dp[i]에 넣어준다.



# 실패

```c++
#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

int visited[1000001]={0,};
priority_queue<pair<int,int>> pq;
int solution(vector<int> money) {
    int answer = 0;
    for(int i=0;i<money.size();i++){
        pq.push({money[i],i});
    }
    while(!pq.empty()){
        if(!visited[pq.top().second]){
            answer+=pq.top().first;
            visited[pq.top().second]=1;
            if(pq.top().second==0){
                visited[money.size()-1]=1;
            }else{
                visited[pq.top().second-1]=1;
            }
            if(pq.top().second==money.size()-1){
                visited[0]=1;
            }else{
                visited[pq.top().second+1]=1;            
            }
        }else{
            pq.pop();
        }
    }
    return answer;
}
```



# 성공

```c++
#include <string>
#include <vector>
#include <math.h>
using namespace std;
int dp1[1000001]={0,};
int dp2[1000001]={0,};
int solution(vector<int> money) {
    int answer = 0;
   
    dp1[0]=money[0];
    dp1[1]=money[0];
    dp2[0]=0;
    dp2[1]=money[1];
    for(int i=2;i<money.size()-1;i++){
        dp1[i]=max(dp1[i-2]+money[i],dp1[i-1]);
    }
    for(int i=2;i<money.size();i++){
        dp2[i]=max(dp2[i-2]+money[i],dp2[i-1]);
    }
    
    return max(dp1[money.size()-2],dp2[money.size()-1]);
}
```

