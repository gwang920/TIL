





​			

```
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









```
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

vector<int> v[90001];
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
                if(!v[cnt].size()){
                    v[cnt].push_back(0);
                    v[check[ny][nx]].push_back(0);
                    v[cnt][check[ny][nx]]=temp;
                    v[check[ny][nx]][cnt]=temp;
                }
                 // level 별 최소값 저장
             
                if(v[cnt][check[ny][nx]]>temp){
                    v[cnt][check[ny][nx]]=temp;
                    v[check[ny][nx]][cnt]=temp;
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
    answer+=v[start_f][start_s];
    int count=1;
    while(1){
        minn=10001;
        // 최소 경로 check
        for(int i=1;i<=cnt;i++){
            if(!visit[i]) continue;
                for(int j=1;j<=cnt;j++){
                    if(visit[j] || !v[i][j] || i==j) continue;
                    if(minn>v[i][j]){
                        minn=v[i][j];
                        start_f=i; start_s=j;
                    }
                }
        }
        answer+=v[start_f][start_s];
        visit[start_s]=1;
        count++;
        if(count>=cnt-1) return answer;
    }
}
```





```
#include <string>
#include <vector>
#include <iostream>
using namespace std;
vector<int> v[5001];

int solution(vector<vector<int>> land, int height) {
    int answer = 0;
    
    v[0].push_back(0);
    v[500].push_back(0);
    v[0][3]=1;
    v[500][3]=5555;
    cout << v[0][3] << v[500][3];
    return answer;
}
```







```
#include <string>
#include <vector>
#include <iostream>
#include <cstdlib> // for abs()
#include <functional> // for greater
#include <queue>
using namespace std;

int visited[300][300];
int visitedPQ[300][300];
int answer;
int diff; // pq에 push할때 필요한 정보
int N; // N은 이제 land의 가로길이. (land는 정사각형)
int dy[] = { 0, 0, 1, -1 };
int dx[] = { 1, -1, 0, 0 }; // 오른 왼 위 아래
queue <pair<int, int>> q;

typedef pair<int, pair<int, int>> PAIR;

priority_queue< PAIR, vector<PAIR>, greater<PAIR> > pq;

void BFS(vector<vector<int>> land, int height)
{
    while(!q.empty())
    {
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        for (int i = 0; i < 4; i++)
        {
            int ny = dy[i] + y;
            int nx = dx[i] + x;
            if (ny >= N || ny < 0 || nx >= N || nx < 0)
                continue;

            diff = abs(land[y][x] - land[ny][nx]);

            if ( diff <= height && !visited[ny][nx])
            {  // 사다리 도움없이 이동할 수 있다면,
                q.push(make_pair(ny, nx));
                visited[ny][nx] = 1;
            }
            else if( diff > height && !visited[ny][nx])// 사다리가 필요하다면, 
            {
                pq.push(make_pair(diff, make_pair(ny, nx)));
                //visitedPQ[ny][nx] = 1;
            }
        }
    }
}

int solution(vector<vector<int>> land, int height)
{
    N = land.size();
    q.push(make_pair(0, 0));
    visited[0][0] = 1;
    BFS(land, height);
    while (!pq.empty())
    {
        while (!pq.empty() && visited[pq.top().second.first][pq.top().second.second])
            pq.pop();

        if (pq.empty())
            break;

        q.push(make_pair(pq.top().second.first, pq.top().second.second));
        visited[pq.top().second.first][pq.top().second.second] = 1;
        answer += pq.top().first;
        BFS(land, height);
    }
    return answer;
}

```

