







```c++
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <math.h>
using namespace std;

int dx[4]={1,0,-1,0};
int dy[4]={0,1,0,-1};
    
// 사다리 모든 경우 탐색 하고 최소 비용 리턴?
int go(int height,int check[300][300],int cost,int y,int x,vector<vector<int>> land){
     
    if(y==land.size()-1 && x==land.size()-1) return cost;

    int cnt=0;
    for(int i=0;i<4;i++){
        int nx=x+dx[i];
        int ny=y+dy[i];
        
        if(cnt==4) return 2147483647;
        
    if(nx<0 || ny<0 || nx>land.size()-1 || ny>land.size()-1 || check[ny][nx]) {
        cnt++; continue;
    }
        int dif=abs(land[y][x]-land[ny][nx]);
     
        if(dif>height) cost+=dif;
        
        check[ny][nx]=1;
        
        go(height,check,cost,ny,nx,land);
    }
}

int solution(vector<vector<int>> land, int height) {
    int min_cost=2147483647;
    //vector<vector<int>> check(300,vector<int>(300,0));
    int check[300][300]={};
    check[0][0]=1;
    min_cost=min(min_cost,go(height,check,0,0,0,land));

    return min_cost;
}
```







```c++
#include <string>
#include <vector>
#include <iostream>
#include <math.h>
#include <queue>
using namespace std;
int check[300][300]={(0,0),};
int dx[4]={0,1,0,-1};
int dy[4]={1,0,-1,0};
vector<vector<int>> v;
queue<pair<int,int>> q;
        
void bfs(int y,int x,vector<vector<int>> land,int height,int cnt){
    
    v[cnt].push_back(land[y][x]);  // vector 값이 초기화 되지 않았기에 segmentfault 발생
    
    while(!q.empty()){
        auto now=q.front(); q.pop();
        for(int i=0;i<4;i++){
        int ny=now.first+dy[i]; int nx=now.second+dx[i];
        if(ny<0 || nx<0 || ny>land.size()-1 || nx>land.size()-1) continue;
        int temp=0;
            temp=abs(land[y][x]-land[ny][nx]);
        if(temp>height || check[ny][nx]) continue;
        
        v[cnt].push_back(land[ny][nx]);    
        check[ny][nx]=cnt;    
        q.push({ny,nx});    
    }    
    }

}

int solution(vector<vector<int>> land, int height) {
    int answer = 0;
    int cnt=1;
    
    for(int i=0;i<land.size();i++){
        for(int j=0;j<land.size();j++){
            if(!check[i][j]) {
                check[i][j]=cnt; q.push({i,j}); bfs(i,j,land,height,cnt); cnt++; 
                 }
        }
    }
    
    for(int i=0;i<land.size();i++){
        for(int j=0;j<land.size();j++){   
            cout << check[i][j] << endl;
        }
        cout<< ""<< endl;
    }

    return answer;
}
```



```c++
#include <string>
#include <vector>
#include <iostream>
#include <math.h>
#include <queue>
using namespace std;
int check[300][300]={(0,0),};
int visited[300][300]={(0,0),};
int dx[4]={0,1,0,-1};
int dy[4]={1,0,-1,0};
int con[300][300]={(0,0),};
queue<pair<int,int>> q;
vector<int> v[300];
vector<int> sum;
priority_queue<int> pq;

void line(int y,int x,vector<vector<int>> land){
    
    visited[y][x]=1;
    int ny=0,nx=0;
    for(int i=0;i<4;i++){
        
        ny=y+dy[i];
        nx=x+dx[i];
        
        if(ny<0 || nx<0 || ny>land.size()-1 || nx>land.size()-1 || 3ㅊ 98visited[ny][nx]) continue;
        
        if(check[y][x]==check[ny][nx]) line(ny,nx,land);
        if(check[y][x]!=check[ny][nx]) 
        {   int temp=0;
            if(!con[check[y][x]][check[ny][nx]]) con[check[y][x]][check[ny][nx]]=10000;
            temp=abs(land[y][x]-land[ny][nx]);
            con[check[y][x]][check[ny][nx]]=min(temp,con[check[y][x]][check[ny][nx]]);
            
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

int solution(vector<vector<int>> land, int height) {
    int answer = 0;
    int cnt=0;
    
    for(int i=0;i<land.size();i++){
        for(int j=0;j<land.size();j++){
            if(!check[i][j]) {
                cnt++;
                level(i,j,land,height,cnt); 
                 }
        }
    }
    for(int i=0;i<land.size();i++){
        for(int j=0;j<land.size();j++){
            if(!visited[i][j]) {
                line(i,j,land); 
                 }
        }
    }
    for(int i=0;i<land.size();i++){
        for(int j=0;j<land.size();j++){   
            cout << check[i][j];
        }
        cout<< ""<< endl;
    }
    
 
    for(int i=1;i<=cnt;i++){
        for(int j=1;j<=cnt;j++){
            if(con[i][j]) {pq.push(con[i][j]); }
 
        }
    }
   
   while(1){
       if(pq.size()==cnt-1) break;
       
       pq.pop();
   } 
 
   
       for(int i=0;i<cnt-1;i++){
       answer+=pq.top(); pq.pop();    
       }
       
    return answer;
}
```

