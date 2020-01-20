# 프로그래머스 여행경로

##### 카테고리 : DFS/BFS

<https://programmers.co.kr/learn/courses/30/lessons/43164>



- 우선순위만 고려하다 보니 전체 도시를 방문하지 않는 경우가 생긴다

- 예외 테스트 케이스 -> 구글링 및 질문하기 참고

* 참고 ( 예외 테스트 케이스 )

문제 조건 중 다음과 같은 조건이 있습니다.

1. 주어진 항공권은 모두 사용해야 합니다.
2. 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
3. 모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.

여기서 1,2번 테스트 케이스의 경우 2번 조건에 대해서 잘 해석하셔야합니다.

전체적으로 1, 3번 조건을 만족해서 나올 수 있는 length(최종 경로) == length(어떤 경로) 일 경우 2번 조건을 만족해야합니다.

예시를 보이자면

```
[["ICN", "COO"], ["ICN", "BOO"], ["COO", "ICN"], ["BOO", "DOO"]]
```

위와 같은 테스트 케이스에서

2번 조건을 만족하면서 탐색하면
`ICN -> BOO -> DOO` 까지만 가게 되는 해석의 여지가 생깁니다.

그래서 1,2,3번 조건을 엄격하게 지킬 경우
`ICN -> COO -> ICN -> BOO -> DOO` 의 답이 나오게 됩니다.



# 실패

```c++
#include <string>
#include <vector>
#include <stdio.h>

using namespace std;

vector<string> answer;
int visited[10000]={0,};
int index=0;

void dfs(string s,string add,vector<vector<string>> tickets)
{
    s="ZZZZ";
    
    for(int i=0;i<tickets.size();i++){
        if(visited[i]) continue;
        if(tickets[i][0]==add){
            if(s>tickets[i][1]){
                s=tickets[i][1];
                index=i;
            }
        }
    }
    visited[index]=1;
    answer.push_back(s);

    if(answer.size()<=tickets.size()){
        dfs("",s,tickets);
    }
}

vector<string> solution(vector<vector<string>> tickets) {
   
    string cp="ZZZZ";
    
    for(int i=0;i<tickets.size();i++){
        if(tickets[i][0]=="ICN"){
            if(tickets[i][1]<cp){
                cp=tickets[i][1];
                index=i;
            }
        }
    }
    visited[index]=1;
    answer.push_back("ICN");
    answer.push_back(cp);
    dfs("",cp,tickets);
    
    return answer;
}
```





# 성공

```c++
#include <string> 
#include <vector> 
#include <algorithm> 

using namespace std; 

bool dfs(string from, vector<vector<string>>& tickets, vector<bool>& visit, vector<string>& temp, vector<string>& answer, int cnt) 
{ 
    temp.push_back(from); 
    
     // sort로 배열 정리가 됐기 때문에 최초로 생성되는 것이 정답
    if (cnt == tickets.size()) 
    { answer = temp; 
     return true; } 
    
    for (int i=0 ;i<tickets.size() ; i++) 
    { 
        
    if (tickets[i][0] == from && !visit[i]) 
    { 
     visit[i] = true; 
     bool success = dfs(tickets[i][1], tickets, visit, temp, answer, cnt+1); 
     if (success) return true; // 0.01ms    dfs 전체 종료
     // if (success) break; 20.71ms 
        
     visit[i] = false; 
    } 
    } 
    
    temp.pop_back(); 
    return false; 
} 

vector<string> solution(vector<vector<string>> tickets) 
{ 
    vector<string> answer, temp; 
    vector<bool> visit(tickets.size(), false); 
    sort(tickets.begin(), tickets.end()); 
    
    dfs("ICN", tickets, visit, temp, answer, 0); 

    return answer; 
}

```

