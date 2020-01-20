# 프로그래머스 - 땅따먹기

- 카테고리 : DP(?)

- 처음에 완전탐색문제로 인식했지만,  4^100000의 시간복잡도를 갖기에 매번 모든 배열의 최대값을 전부 갱신해가면서 코드가 진행되도록 구현했다.



# 성공

```c++
#include <iostream>
#include <vector>
using namespace std;

int solution(vector<vector<int> > land)
{
    int answer = 0;
    vector<vector<int>> renew;
    renew=land;
    for(int i=0;i<land.size()-1;i++){
        for(int j=0;j<4;j++){
            for(int k=0;k<4;k++){
                if(j==k) continue;
                if(renew[i+1][j]<land[i+1][j]+renew[i][k]){
                    renew[i+1][j]=land[i+1][j]+renew[i][k];
                }
            }   
        }
    }

    for(int i=0;i<4;i++){
        answer=max(renew[land.size()-1][i],answer);
    }

    return answer;
}

```

