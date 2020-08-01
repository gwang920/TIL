# 프로그래머스 방문길이

- 카테고리 : 시뮬레이션(?)

- 'RL' 인경우 answer =1 이 되야함
- 실패 코드는 'RL'인 경우 2가 return 된다.



# 실패

```c++
#include <string>
#include <queue>
#include <iostream>
using namespace std;
int fcheck[12][12]={};
int scheck[12][12]={};
queue<pair<int,int>> q;
int solution(string dirs)
{
	int answer = 0;
    int y=5,x=5;
    for(int i=0;i<dirs.length();i++){
        if(dirs[i]=='U') q.push({-1,0});
        if(dirs[i]=='D') q.push({1,0});
        if(dirs[i]=='R') q.push({0,1});
        if(dirs[i]=='L') q.push({0,-1});
        
        while(!q.empty()){
            auto now=q.front(); q.pop();
            int now_y=now.first;
            int now_x=now.second;
	        if(y+now_y<0 || x+now_x<0 || y+now_y>10 || x+now_x>10) continue;
            
            y+=now_y; x+=now_x;
            
            if(fcheck[y][x] && scheck[y-now_y][x-now_x]) continue;
                                                          
            answer++; fcheck[y][x]=1; scheck[y-now_y][x-now_x]=1;      
        }
    }
	return answer;
}
```



# 성공

```c++
#include <string>
#include <queue>
#include <iostream>
using namespace std;
int check[11][11][11][11]={};  // 10 x 10에서 좌표점의 갯수는 11개
queue<pair<int,int>> q;
int solution(string dirs)
{
	int answer = 0;
    int y=5,x=5;
    for(int i=0;i<dirs.length();i++){
        if(dirs[i]=='U') q.push({-1,0});
        if(dirs[i]=='D') q.push({1,0});
        if(dirs[i]=='R') q.push({0,1});
        if(dirs[i]=='L') q.push({0,-1});
     
            auto now=q.front(); q.pop();
            int now_y=now.first;
            int now_x=now.second;
            
            if(y+now_y<0 || x+now_x<0 || y+now_y>10 || x+now_x>10) continue;
            
            y+=now_y; x+=now_x;
            
            if(check[y][x][y-now_y][x-now_x] || check[y-now_y][x-now_x][y][x]) continue;
            answer++; 
            check[y][x][y-now_y][x-now_x]=1;
    }
	return answer;
}

```

