# 프로그래머스 - 경주로 건설 

- 카테고리 : 다익스트라

```
간단한 다익스트라 문제

한가지 주의할 점은
next_sum=board[y][x]+a로 하면 오차가 발생한다.

next_sum=cur_sum+a 와 같이 각 케이스마다 매번
이전 sum값을 갖게끔 bfs 탐색을 해야한단.
```



# 성공

```C++
#include <string>
#include <vector>
#include <iostream>
#include <queue>
using namespace std;
vector<vector<int>> b;
struct INFO{
    int y,x,dir,sum;
};

queue<INFO> q;
int dy[]={0,1,0,-1},dx[]={1,0,-1,0};
void bfs(){
    q.push({0,0,0});
    q.push({0,0,1});
    while(!q.empty()){
        auto now=q.front(); q.pop();
        int y=now.y,x=now.x,dir=now.dir,sum;
        for(int i=0;i<4;i++){
            int ny=y+dy[i],nx=x+dx[i];
            if(ny<0 || nx<0 || ny>b.size()-1 || nx>b.size()-1) continue;
            if(b[ny][nx]==1) continue;
            sum=now.sum;
            if(dir==i){
                sum+=10;
            }else{
                sum+=60;
            }
            if(b[ny][nx]>=sum){
                b[ny][nx]=sum;
                q.push({ny,nx,i,sum});
            }
        }
    }
}

int solution(vector<vector<int>> board) {
    int answer = 0;
   
    for(int i=0;i<board.size();i++){
        for(int j=0;j<board[i].size();j++){
            if(!board[i][j]) board[i][j]=987654321;
        }
    }
    board[0][0]=0;
    b=board;
    bfs();
    
    answer=b[b.size()-1][b.size()-1];
    return answer*10;
}
```

