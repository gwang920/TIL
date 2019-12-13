# 프로그래머스 - 가장 먼 노드

- 카테고리 : BFS
- 실패코드와 비교해서 정리하기
- 1행의 '1' 즉, 1과 1의 길이로 연결 된 노드를 전부 queue에 미리 저장한다.



# 실패

```c++
#include <string>
#include <vector>
#include <iostream>
#include <queue>
#include <math.h>
using namespace std;
int map[20001][20001];
bool visited[20001][20001];
queue<pair<int,int>> q;
int solution(int n, vector<vector<int>> edge) {
    int answer = 0;
    int maximum=0;
    for(int i=0;i<edge.size();i++){
            map[edge[i][0]][edge[i][1]]=1;
            map[edge[i][1]][edge[i][0]]=1;
    }
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(map[i][j]) {
               q.push({j,1});
                while(!q.empty()){
                    auto now=q.front(); q.pop();
                    int y=now.first;
                    int depth=now.second;
                    for(int k=2;k<=n;k++){
                        if(y==k) continue;
                        if(map[y][k]){
                            if(!map[1][k]) map[1][k]=depth+1;
                            else if(map[1][k]>depth+1){
                                map[1][k]=depth+1;
                                maximum=map[1][k];
                                q.push({k,depth+1});
                            }else{
                                maximum=depth+1;
                            }
                        }        
                    }
                }
            }
        }
        
    }
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            
            cout << map[i][j];
        }
        cout << endl;
    }
    
   for(int i=1;i<=n;i++){
       
       if(map[1][i]==maximum) answer++;
   }

    return answer;
}
```





# 성공

```c++
#include <string>
#include <vector>
#include <iostream>
#include <queue>
#include <math.h>
using namespace std;
int map[20001][20001];
bool visited[20001];
queue<pair<int,int>> q;
int solution(int n, vector<vector<int>> edge) {
    int answer = 0;
    int maximum=0;
    for(int i=0;i<edge.size();i++){
            map[edge[i][0]][edge[i][1]]=1;
            map[edge[i][1]][edge[i][0]]=1;
    }
        
        visited[1]=1;
        for(int j=1;j<=n;j++){
            if(map[1][j]==1) q.push({j,2});
        }
                while(!q.empty()){
                    auto now=q.front(); q.pop();
                    int y=now.first;
                    int depth=now.second;
          
                    for(int k=2;k<=n;k++){
                        if(y==k || visited[k]) continue;
                         if(map[y][k]){
                            if(!map[1][k]){
                                visited[k]=1;
                                map[1][k]=depth;
                                maximum=depth;
                                q.push({k,depth+1});
                        }   
                        }
                    }
                }
   for(int i=1;i<=n;i++){   
       if(map[1][i]==maximum) answer++;
   }
    return answer;
}
```

