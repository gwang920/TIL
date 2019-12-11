# 프로그래머스 - 체육복

- 카테고리 : 탐욕법





```c++
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int visit[31]={0,};
int visitR[31]={0,};
int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = n-lost.size();
    // 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
 //   => 가장 먼저 처리해줘야한다 밑의 for문에 조건식을 넣으면 만족하지 않는 경우가 생김
     for(int i=0;i<reserve.size();i++){
        for(int j=0;j<lost.size();j++){
             if(lost[j]==reserve[i]){
                answer++;
                visitR[i]=1;
                visit[j]=1;
                break;
            }
        }
     }
    for(int i=0;i<reserve.size();i++){
        for(int j=0;j<lost.size();j++){
            if(visit[j] || visitR[i]) continue;
            if(lost[j]==reserve[i]+1 || lost[j]==reserve[i]-1){
                answer++;
                visit[j]=1;
                break;
            }
        }
    }
    return answer;
}
```

