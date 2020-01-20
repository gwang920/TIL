# 프로그래머스 네트워크

- 카테고리 : BFS/DFS
- 2차원 배열을 통해 입력값을 받는다 (MAP을 그린다)
- 1) computers배열의 첫 컴퓨터와 연결된 컴퓨터를 시작으로 연결고리를 이어간다
- 2) 반복문을 통해 순차적으로 연결된 모든 컴퓨터에 대해 1) 의 과정을 반복한다

```
01101
10010
00010
00000
00010
1 - > 2 - > 4
1 - > 3 - > 4
1 - > 5 - > 4
```

# 성공

```C++
#include <string>
#include <vector>

using namespace std;
int check[200][200];
int arr[200][200];

void dfs(int i,int j,int n){
    check[i][j]=1;
    for(int k=0;k<n;k++){
        if(arr[i][k] && !check[k][i]){ 
            dfs(k,i,n);
        }
    }  
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
        arr[i][j]=computers[i][j];            
            }
        }
    
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){  
            if(arr[i][j] && !check[i][j]){
                answer++;
                dfs(i,j,n);
            }
        }
    }

    return answer;
}
```

