# 프로그래머스 - 보행자 천국

- 카테고리 : DP
- BFS를 이용해 풀이했더니 시간초과 => DP로 풀자.



# 실패

```C++
#include <vector>
#include <queue>
using namespace std;

int MOD = 20170805;

int dx[2]={0,1};
int dy[2]={1,0};
queue<pair<int,int>> q;
int solution(int m, int n, vector<vector<int>> city_map) {
    int answer = 0;
    int map[500][500]={0,};
    q.push({0,0});
    while(!q.empty()){
        auto now=q.front(); q.pop();
        int y=now.first;
        int x=now.second;
        if(y==m-1 && x==n-1) answer++;
        for(int i=0;i<2;i++){
            int ny=y+dy[i];
            int nx=x+dx[i];
            if(ny>m-1 || nx>n-1) continue;
            if(city_map[ny][nx]==1) continue;
            if(city_map[ny][nx]==2 && dy[i]) q.push({ny+1,nx});
            if(city_map[ny][nx]==2 && dx[i]) q.push({ny,nx+1});
            if(city_map[ny][nx]==0) q.push({ny,nx});
        }
    }
    return answer%MOD;
}
```



# 성공

```C++
#include <vector>
#include <string.h>
using namespace std;

int MOD = 20170805;

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
int solution(int m, int n, vector<vector<int>> city_map) {
    int answer = 0;
    int garo[501][501]={0,};
    int sero[501][501]={0,};
    garo[1][1]=1; sero[1][1]=1;
    for(int i=1;i<=m;i++){
        for(int j=1;j<=n;j++){
            if(city_map[i-1][j-1]==0){ // i-1 j-1 인덱스를 표현하기 위해
                					   // 표현상 다를 뿐 city_map[i-1][j-1]
                					   // garo[i][j] 는 같은 위치를 나타낸다(?)
                					   // 밑의 추가 참고.
                garo[i][j]+=(garo[i-1][j]+sero[i][j-1])%MOD;
                sero[i][j]+=(garo[i-1][j]+sero[i][j-1])%MOD;
            }
            if(city_map[i-1][j-1]==1){
              sero[i][j]=0;  
              garo[i][j]=0;
            } 
            if(city_map[i-1][j-1]==2){
                garo[i][j]=garo[i-1][j];
                sero[i][j]=sero[i][j-1];
            }
        }
    }
    answer=garo[m][n]%MOD;
    return answer;
}
```



# 추가

##### 기존 테스트 케이스

| m    | n    | city_map                                                     | answer |
| ---- | ---- | ------------------------------------------------------------ | ------ |
| 3    | 3    | [[0, 0, 0], [0, 0, 0], [0, 0, 0]]                            | 6      |
| 3    | 6    | [[0, 2, 0, 0, 0, 2], [0, 0, 2, 0, 1, 0], [1, 0, 0, 2, 2, 0]] | 2      |

```c++
#include <vector>

using namespace std;

int MOD = 20170805;

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
int solution(int m, int n, vector<vector<int>> city_map) {
    int answer = 0;
    int V[501][501]={0,};
    int H[501][501]={0,};
    
    city_map.clear();
    m=3;
    n=6;
    city_map.push_back({0,0,0,0,0,0,0});
    city_map.push_back({0,0, 2, 0, 0, 0, 2});
    city_map.push_back({0,0, 0, 2, 0, 1, 0});
    city_map.push_back({0,1, 0, 0, 2, 2, 0});
    
    
    V[1][1]=H[1][1]=1;
    for(int i=1;i<=m;i++){
        for(int j=1;j<=n;j++){   // i-1 index를 포함하기 위해
            if(city_map[i][j]==0){
                V[i][j]+=(V[i-1][j]+H[i][j-1])%MOD;
                H[i][j]+=(V[i-1][j]+H[i][j-1])%MOD;
            }
            else if(city_map[i][j]==1){
                V[i][j]=0;
                H[i][j]=0;
            }else{
                V[i][j]=V[i-1][j];
                H[i][j]=H[i][j-1];
            }
        }
    }
    answer=V[m][n]%MOD;
    return answer;
}

 결과 answer = 2
```

