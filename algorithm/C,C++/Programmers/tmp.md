뿌요뿌요 st 문제
카테고리 : 시뮬레이션+BFS

```
#include <string>
#include <vector>
#include <iostream>
#include <queue>
#include <string.h>
using namespace std;
int map[7][7];
int visit[7][7];
int dy[]={0,1,0,-1},dx[]={1,0,-1,0};
queue<pair<int,int>> q;
vector<pair<int,int>> v;
void move(){
    for(int j=1;j<=6;j++){
        for(int i=6;i>=0;i--){
            if(!map[i][j]){
                for(int k=i;k>=0;k--){
                    if(map[k][j]){
                        map[i][j]=map[k][j];
                        map[k][j]=0;
                        break;
                    }
                }
            }
        }
    }
}

bool remove(){
    bool flag=false;
    memset(visit,0,sizeof(visit));
    for(int i=1;i<=6;i++){
        for(int j=1;j<=6;j++){
            if(map[i][j]){
               v.push_back({i,j}); q.push({i,j});
                visit[i][j]=1;
               while(!q.empty()){
                auto now=q.front(); q.pop();
                 int y=now.first,x=now.second;
                 for(int dir=0;dir<4;dir++){
                     int ny=y+dy[dir],nx=x+dx[dir];
                     if(ny<1 || nx<1 || ny>6 || nx>6) continue;
                     if(visit[ny][nx]) continue;
                     if(map[ny][nx]==map[i][j]){
                         q.push({ny,nx});
                         v.push_back({ny,nx});
                         visit[ny][nx]=1;
                     }
                 }
               }
                if(v.size()>=3){
                    flag=true;
                    for(int k=0;k<v.size();k++){
                        int y=v[k].first,x=v[k].second;
                        map[y][x]=0;
                    }
                }
                v.clear();
            }
        }
    }
    if(!flag) return false;
    else return true;
}

vector<string> solution(vector<vector<int>> macaron) {
    vector<string> answer;
    for(int i=0;i<macaron.size();i++){
        int idx=macaron[i][0],col=macaron[i][1];
        for(int j=1;j<=6;j++){
            if(map[j][idx]){
                map[j-1][idx]=col;
                break;
            }
            if(j==6 && !map[j][idx]){
                map[j][idx]=col; break;
            }
        }
        while(1){
            if(!remove()){
                move(); break;
            } 
            move();
        }
    }
    
    for(int i=1;i<=6;i++){
        string s="";
        for(int j=1;j<=6;j++){
              s+=to_string(map[i][j]); 
        }
        answer.push_back(s);
    }
    
    return answer;
}
```

