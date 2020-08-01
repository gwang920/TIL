# 프로그래머스 섬연결하기

카테고리 : 탐욕법

<https://programmers.co.kr/learn/courses/30/lessons/42861>

매 단계마다 최적의 경로(방법)을 찾아나가 최종적인 답을 찾아내는 전형적인 탐욕법 문제였다.

- 우선 2차원 배열을 통해 섬의 위치, 연결관계를 표현하고 2차원 배열의 최상단(0,0)에 가까우면서 섬연결 비용이 최소가 되는 지점에서 부터 탐색을 시작한다.
- 예를들어 섬 1과 섬2가 최소 비용이 되는 지점이면 섬1, 섬2를 visited(방문)처리해준다.
- 다음 step은 연결된 모든 섬(섬1, 섬2)과 연결되는 모든 경로중에 비용이 가장 최소가 되는 경우를 찾아 연결하고, 마찬가지로 visited(방문)처리 해준다.
- 만약 섬3이 섬1,섬2와 연결되는 경로 중 최소 비용 경로라고 하면 visited(방문)처리 해주고, 마찬가지로 모든 섬(섬1,섬2,섬3)과 연결되는 최소 비용 경로를 찾아 위와 같이 반복한다.
- 이처럼 매번 최적의 경로(최소의 비용)을 찾아나가 답을 도출해낸다.

- (+ 다익스트라 알고리즘으로 풀이해보자)



# 성공

```c++
#include <string>
#include <vector>
#include <queue>

using namespace std;

queue<pair<int,int>> q;

int arr[100][100]={(0,0),};
int cost=0,now_y=0,now_x=0;
int min_check=9999;
int visited[100]={0,};
int check_sum[100][100];

int check(int n){
    for(int i=0;i<n;i++){
        if(!visited[i]) return false;
        // return true;    서순 차이
    }
    return true;
}

int solution(int n, vector<vector<int>> costs) {
    
    
    for(int i=0;i<costs.size();i++){
        
        if(min_check>costs[i][2]){
            min_check=costs[i][2];
            
            now_y=costs[i][0];
            now_x=costs[i][1];
        }
        
        arr[costs[i][0]][costs[i][1]]=costs[i][2];
        arr[costs[i][1]][costs[i][0]]=costs[i][2];   
    }
    
    q.push({now_y,now_x});
    
    while(!q.empty()){
         
        if(check(n)) return cost;
        
         auto now=q.front();
         now_y=now.first;
         now_x=now.second;
         q.pop();
    
        // 방문처리
        visited[now_y]=1;
        visited[now_x]=1;
        
        check_sum[now_y][now_x]=1;
        check_sum[now_x][now_y]=1;
        
        // 합계
        
        cost+=arr[now_y][now_x];
        
        min_check=9999;
        
        // 가장 짧은경로 찾기
        for(int i=0;i<n;i++){   
            
            if(visited[i]!=0){
                
                for(int j=0;j<n;j++){
                    
                    // 이미 더해준 경로, 길이없는 경우는 무시, 
                    if(arr[i][j]==0 || check_sum[i][j] || visited[j]) continue;
                    // if(arr[i][j]==0 || check_sum[i][j]) continue; visited를 고려하지 않으면 안된다
                   
                    if(min_check>arr[i][j])
                    {   
                        min_check=arr[i][j];
                        now_y=i;
                        now_x=j;
                        
                        }
                }
            }
        }
        q.push({now_y,now_x});
    }
}
```

