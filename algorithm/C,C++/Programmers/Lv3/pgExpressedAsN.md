# 프로그래머스 N으로 표현

- 카테고리 : 완전탐색
- 괄호의 표현은 반복문으로 해결가능



```c++
#include <string>
#include <vector>
#include <math.h>
using namespace std;

int answer = 0x7f7f7f7f;
void dfs(int N,int number,int idx,int sum){
    
    if(idx>8) return;
    
    if(sum==number){
        answer=min(answer,idx); 
    }
    
    int tmp=0;
    for(int i=0;i<8;i++){
        tmp=tmp*10+N;
        
        dfs(N,number,idx+i+1,sum+tmp);
        dfs(N,number,idx+i+1,sum-tmp);
        dfs(N,number,idx+i+1,sum*tmp);
        dfs(N,number,idx+i+1,sum/tmp);
        
    }
}


int solution(int N, int number) {

    dfs(N,number,0,0);
    if(answer>8) return -1;
    else return answer;
}
```

