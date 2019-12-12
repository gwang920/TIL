# 프로그래머스 - 정수 삼각형

- 카테고리 : DP
- DP 기본 문제
- 마지막 풀이는 코드가 깔끔해서 참고용으로 넣어보자.



# 성공

```c++
#include <string>
#include <vector>
#include <iostream>
using namespace std;
// 7 (0,0)
//10 15 (1,0) (1,1)
// 18 16 15 (2,0) (2,1) (2,2)
int solution(vector<vector<int>> triangle) {
    int answer = 0;
    int sum[501][501];
    sum[0][0]=triangle[0][0];
    for(int i=0;i<triangle.size()-1;i++){
        for(int j=0;j<triangle[i].size()-1;j++){
            if(sum[i+1][j]<sum[i][j]+triangle[i+1][j])
            {sum[i+1][j]=sum[i][j]+triangle[i+1][j];}
           if(sum[i+1][j+1]<sum[i][j]+triangle[i+1][j+1]){
               sum[i+1][j+1]=sum[i][j]+triangle[i+1][j+1];
           }
        }
    }
     
    for(int i=0;i<triangle.size();i++){
        answer=max(answer,sum[triangle.size()-1][i]);
    }
    
    return answer;
}
```







# 다른 풀이

```c++
#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> triangle) {

    //바닥부터 큰 값의 수를 윗 칸에 더해나간다
    for(int i = triangle.size()-2; i > -1; i--){
        for(int j = 0; j <= i; j++){
            triangle[i+1][j] > triangle[i+1][j+1] ? triangle[i][j] += triangle[i+1][j] : triangle[i][j] += triangle[i+1][j+1];
        }
    }

    return triangle[0][0];
}
```

