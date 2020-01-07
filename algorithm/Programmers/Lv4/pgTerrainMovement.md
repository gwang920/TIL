# 프로그래머스 - 지형이동

- 카테고리 : BFS

  ### 실패 코드는 90000 x 90000 의 index를 갖는 배열이 필요했다. ( 사실상 불가능한 코드 )

- testcase 30개중 15개만 통과했다. ( 최대 배열 사이즈  20000 x 20000 으로 만족 가능한 testcase 개수가 15개인 것 같다. )

- 1) 기본로직은 사다리 없이 이동가능한 구간들을 같은 level로 묶는다.

  - land의 크기가 300 x 300 이므로 최대 level이 90000이 될 수 있다.

- 2) 이제 level별로 이동을 시작한다.

  - 중복을 제외하고 ( [x] [y] == [y] [x] 로 둔다) level별 가장 최소가 되는 비용을 배열에 담는다.

- 3) 마지막으로 그리디를 이용하여 가장 작은 비용을 갖는 구간 부터 탐색을 시작한다.



   ### 다른 풀이를 보니 우선순위 큐를 이용해서 간단하게 풀이했다.





# 실패

```c++
#include <string>
#include <vector>
#include <iostream>
#include <math.h>
#include <queue>
#include <algorithm>
using namespace std;

bool visited[301][301]={0,};
int check[301][301]={(0,0),};
int dx[4]={0,1,0,-1};
int dy[4]={1,0,-1,0};

int cost[20001][20001]={0,};
vector<vector<int>> v[90001];
queue<pair<int,int>> q;
int cnt=0;
int minn=10001, start_f=0, start_s=0; // 최소값 저장 , 시작 지점 설정
void conn(int y,int x,vector<vector<int>> land,int cnt)
{
    q.push({y,x});
    while(!q.empty()){
        auto now=q.front(); q.pop();
        int y=now.first,x=now.second;
        for(int i=0;i<4;i++){
            int ny=y+dy[i],nx=x+dx[i];
            if(ny<0 || nx<0 || ny>land.size()-1 || nx>land.size()-1) continue;
            if(visited[ny][nx]) continue;
            if(check[ny][nx]==cnt){             // 같은 level 이면
                visited[ny][nx]=1;
                q.push({ny,nx});
            }else{
                int temp=0;
                temp=abs(land[y][x]-land[ny][nx]);
                // cost = 비용 배열 , check = 레벨 배열
                if(!cost[cnt][check[ny][nx]]){
                    cost[cnt][check[ny][nx]]=temp;
                    cost[check[ny][nx]][cnt]=temp;
                } 
                // level 별 최소값 저장
                if(cost[cnt][check[ny][nx]]>temp){
                  cost[cnt][check[ny][nx]]=temp;
                  cost[check[ny][nx]][cnt]=temp;
                } 
                // 시작 지점 설정
                if(minn>temp){
                    minn=temp;
                    start_f=cnt;
                    start_s=check[ny][nx];
                }
            }
        }
    }
}
void level(int y,int x,vector<vector<int>> land,int height,int cnt){
    q.push({y,x});
    check[y][x]=cnt;
    while(!q.empty()){
        auto now=q.front(); q.pop();
        for(int i=0;i<4;i++){
        int ny=now.first+dy[i]; int nx=now.second+dx[i];
        if(ny<0 || nx<0 || ny>land.size()-1 || nx>land.size()-1) continue;
        int temp=0;
            temp=abs(land[now.first][now.second]-land[ny][nx]);
            //  temp=abs(land[y][x]-land[ny][nx]);
        if(temp>height || check[ny][nx]) continue;
        check[ny][nx]=cnt;    
        q.push({ny,nx});    
            }    
        }
    }
int solution(vector<vector<int>> land, int height){
    int answer = 0;
    // level
    for(int i=0;i<land.size();i++){
        for(int j=0;j<land.size();j++){
            if(!check[i][j]) {
                cnt++;
                level(i,j,land,height,cnt); 
                 }
        }
    }
    
    // connection
    for(int i=0;i<land.size();i++){
        for(int j=0;j<land.size();j++){
            if(!visited[i][j]){
                    visited[i][j]=1;
                    conn(i,j,land,check[i][j]);
            }
        }
    }
    
    // cost sumation
    bool visit[5001]={0,};
    visit[start_f]=1; visit[start_s]=1;
    answer+=cost[start_f][start_s];
    int count=1;
    while(1){
        minn=10001;
        // 최소 경로 check
        for(int i=1;i<=cnt;i++){
            if(!visit[i]) continue;
                for(int j=1;j<=cnt;j++){
                    if(visit[j] || !cost[i][j] || i==j) continue;
                    if(minn>cost[i][j]){
                        minn=cost[i][j];
                        start_f=i; start_s=j;
                    }
                }
        }
        answer+=cost[start_f][start_s];
        visit[start_s]=1;
        count++;
        if(count>=cnt-1) return answer;
    }
}
```





# 성공

```c++
#include <string>
#include <vector>
#include <queue>
#include <functional>
#include <iostream>
#include <math.h>

using namespace std;
queue<pair<int,int>> q;

typedef pair<int,pair<int,int>> PAIR;
priority_queue<PAIR,vector<PAIR>,greater<PAIR>> pq;
int N;
int visited[301][301];
int dy[]={1,0,-1,0};
int dx[]={0,1,0,-1};

void bfs(vector<vector<int>> land,int height){
    
    while(!q.empty()){
        auto now=q.front(); q.pop();
        int y=now.first, x=now.second;
        for(int i=0;i<4;i++){
            int ny=y+dy[i]; int nx=x+dx[i];
            if(ny<0 || nx <0 || ny>N-1 || nx>N-1) continue;
            
            int diff=abs(land[y][x]-land[ny][nx]);
            
            if(diff<=height && !visited[ny][nx]){
                q.push({ny,nx});
                visited[ny][nx]=1;
            }
            else if(diff>height && !visited[ny][nx]){
                pq.push({diff,{ny,nx}});
            }
        }
    }
}

int solution(vector<vector<int>> land, int height) {
    int answer = 0;
    N=land.size();
    q.push({0,0});
    visited[0][0]=1;
    bfs(land,height);
    while(!pq.empty()){
        
        while(!pq.empty() && visited[pq.top().second.first][pq.top().second.second])
            pq.pop();
        
        if(pq.empty())
            break;
        
        q.push({pq.top().second.first,pq.top().second.second});
        answer+=pq.top().first;
        visited[pq.top().second.first][pq.top().second.second]=1;
        bfs(land,height);
    }
    return answer;
}
```



# 추가 ( 실패 - 실수 : ************************ 지점)

```c++
#include <string>
#include <vector>
#include <algorithm>
#include <queue>
#include <math.h>
#include <functional>
#include <iostream>
using namespace std;
queue<pair<int,int>> q;

typedef pair<int,pair<int,int>> PAIR;
priority_queue<PAIR,vector<PAIR>,greater<PAIR>> pq;

vector<vector<int>> map;
const int dx[]={0,1,0,-1};
const int dy[]={1,0,-1,0};
int visited[300][300]={0,};
int size,level;

void bfs(int y,int x){
    q.push({y,x});
    while(!q.empty()){
        auto now=q.front(); q.pop();
        for(int i=0;i<4;i++){
            int ny=now.first+dy[i];
            int nx=now.second+dx[i];
            
            if(ny>size-1 || nx>size-1 || ny<0 || nx<0) continue;
            int dist=abs(map[y][x]-map[ny][nx]); //(X) ************************
			// int dist= abs(map[now.first][now.second]-map[ny][nx]); (O)
            if(visited[ny][nx]) continue;
            
            if(dist<=level){
                q.push({ny,nx});
                visited[ny][nx]=1;
            }else if(dist>level){
                pq.push({dist,{ny,nx}});
            }
        }
    }
    return;
}



int solution(vector<vector<int>> land, int height) {
    int answer = 0;
    size=land.size(); map=land; level=height;
    visited[0][0]=1;
    bfs(0,0);
    while(!pq.empty()){
        
        while(!pq.empty() && visited[pq.top().second.first][pq.top().second.second]) pq.pop();
        
        if(pq.empty()) break;
        
        answer+=pq.top().first;
        cout << answer << endl;
        cout << pq.top().second.first << " " << pq.top().second.second << endl;
        visited[pq.top().second.first][pq.top().second.second]=1;
        bfs(pq.top().second.first,pq.top().second.second);
    }
    return answer;
}
```

