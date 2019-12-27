# 프로그래머스 - 하노이의 탑

- 카테고리 : 재귀(DFS)
- 일반화 된 식으로 재귀 함수를 구현하는 연습!
- Call by Reference 방식 참고.



# 성공

```c++
#include <string>
#include <vector>

using namespace std;
void dfs(vector<vector<int>> &answer,int n,int from,int to){
    if(n==1){
        answer.push_back({from,to});
    }else{
        int middle = 6 - from - to;
        dfs(answer, n - 1, from, middle);       
        answer.push_back({from, to});
        dfs(answer, n - 1, middle, to);
    }
}

vector<vector<int>> solution(int n) {
    vector<vector<int>> answer;
    dfs(answer,n,1,3);
    return answer;
}
```

