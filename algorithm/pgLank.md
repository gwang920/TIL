# 프로그래머스 순위

- 카테고리 : 플로이드와샬
- 리그형식 순위 매기기 ( 주어진 모든 경우의 수(승,패)를 계산하여 순위를 추출하는 문제로 인식 ) => 실패
- 단순히 전투력의 순위를 매기는 문제



# 실패

```c++
#include <string>
#include <vector>

using namespace std;
int win[100];
int sum[100];
int check[100];
int answer = 0;
void dfs(int check[100],vector<vector<int>> results,int n,int start,int end){
    
    
    if(start==end) return;
    
    for(int i=start;i<=end;i++){
        int w=results[i][0];
        int l=results[i][1];
        sum[w]++; sum[l]++;
        win[l]++; 
    }
    
    
    for(int i=start;i<=end;i++){
        if(sum[i]==start-end-1 && !check[i]){
            answer++;;
            check[i]=1;
            end=i;
            dfs(check,results,n,start,end);
            start=i; end=n;
        }
        if(i==end){
            dfs(check,results,n,start,end);
        }
    }
    
    
    
}

int solution(int n, vector<vector<int>> results) {
    
    
    for(int i=0;i<results.size();i++){
        int w=results[i][0];
        int l=results[i][1];
        sum[w]++; sum[l]++;
        win[l]++;        
    }
    
    int start=0,end=0;
    for(int i=1;i<=n;i++){
        if(sum[i]==n-1 && !check[i]){
            answer++;;
            check[i]=1;
            end=i;
            dfs(check,results,n,start,end);
            start=i; end=n;
        }
        if(i==n){
            dfs(check,results,n,start,end);
        }
       
    }
//    dfs(check,results,n,start,end);
    
    return answer;
}
```



# 성공

```c++
#include <string>
#include <vector>
#include <iostream>
using namespace std;
 
int solution(int n, vector<vector<int>> results) {
    int answer = 0;
    vector<vector<int>> score(n+1, vector<int> (n+1, 0));
    // int score[101][101]={(0,0),}; 초기화 해주기 ( 실패가능성제거 )
    for(int i=0;i<results.size();i++)
    {
        score[results[i][0]][results[i][1]]++;
        score[results[i][1]][results[i][0]]--;
    }


    // k = 거쳐가는 노드
    for (int k = 1; k <= n; k++) {
        // i = 출발노드
        for (int i = 1; i <= n; i++) {
            if (score[i][k] == 0)
                continue;
            // j = 도착노드
            for (int j = 1; j <= n; j++) {
                if (score[i][k] == score[k][j]) {   // k를 이긴 놈 k에게 진놈
                    
                    score[i][j] = score[i][k];      
                    
                }
            }
        }
    }

    
    for (int i = 1; i <= n; i++) {
        int sum = 0;
        
        for (int j = 1; j <= n; j++) {
            if ((score[i][j] != 0) && (i != j))
                sum++;
        }
        
        if (sum == n - 1)
            answer++;
    }
    
    return answer;
}



score[][] 갱신 전
 0  1  0  0 0 
-1  0 -1 -1 1 
 0  1  0 -1 0 
 0  1  1  0 0 
 0 -1  0  0 0 

score[][] 갱신 후
 0 1  0  0 1 
-1 0 -1 -1 1 
 0 1  0 -1 1 
 0 1  1  0 1 
-1 -1 -1 -1 0 

```

