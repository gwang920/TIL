# 프로그래머스 - 등굣길

- 카테고리 : DP(동적계획법)
- map 초기화 여부에 따라 효율성 성공여부가 갈린다
- map[101] [101]={0,}; => 통과
- map[101] [101]; => 실패



# 성공

```c++
#include <string>
#include <vector>
using namespace std;

int solution(int m, int n, vector<vector<int>> puddles) {
    int map[101][101]={0,};
    int d[101][101];
    
    for(int i=0;i<puddles.size();i++){
        map[puddles[i][0]][puddles[i][1]]=-1;
    }
    d[1][0]=1;
    for(int i=1;i<=m;i++){
        for(int j=1;j<=n;j++){
            if(map[i][j]==-1) d[i][j]=0;
            else{
                d[i][j]=(d[i-1][j]+d[i][j-1])%1000000007;
            }
            
        }
    }
    return d[m][n];
}
```

