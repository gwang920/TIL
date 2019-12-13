# 프로그래머스 - 배달

- 카테고리 : BFS (윈터코딩)

- 주의! map[y] [x] 와 map[x] [y] 전부 연결고리를 연결해주지 않으면 실패가 뜬다





# 성공

```c++
#include <iostream>
#include <vector>
#include <queue>


using namespace std;
queue<pair<int,int>> q;
int map[51][51]={0,};
int visited[51]={0,};
int solution(int N, vector<vector<int> > road, int K) {
    int answer = 0;
    for(int i=0;i<road.size();i++){
        int y=road[i][0], x=road[i][1];
         if(!map[y][x]){
             map[y][x]=road[i][2]; map[x][y]=road[i][2];
         }
         else if(map[y][x]>road[i][2]){
             map[y][x]=road[i][2]; map[x][y]=road[i][2];
         }
    }
    
   for(int i=1;i<=N;i++){
       if(map[1][i]) q.push({i,map[1][i]});
   }
    map[1][1]=1;
    
    while(!q.empty()){
        auto now=q.front(); q.pop();
        int y=now.first;
        int road=now.second;
        for(int i=1;i<=N;i++){
            if(map[y][i]){
                if(!map[1][i]){
                  map[1][i]=map[1][y]+map[y][i];
                  q.push({i,map[1][i]});  
                }
                else if(map[1][i]>map[1][y]+map[y][i]){
                  map[1][i]=map[1][y]+map[y][i];
                  q.push({i,map[1][i]});  
                }
            }
        }
    }

    for(int i=1;i<=N;i++){
            if(map[1][i]<=K) answer++;
    }

    return answer;
}
```

