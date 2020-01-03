# 프로그래머스 - 카드게임

- 카테고리 : DP
- 재귀함수를 추적하지 말자..!
  - 1) 왼쪽 카드를 버리는경우
  - 2) 왼쪽, 오른쪽 카드를 동시에 버리는 경우
  - 3) 오른쪽 카드를 버리는 경우( 오른쪽 카드 값이 작은 경우 )
- 조건을 세우고 조건과 동일하게 코드를 작성 하면된다.



# 성공

```c++
#include <string>
#include <vector>

using namespace std;
vector<int> L;
vector<int> R;
int dp[2001][2001];
int dfs(int l,int r){
    
   if(l==L.size() || r==R.size()) return 0;
   if(dp[l][r]) return dp[l][r];
    
   dp[l][r]=max(dfs(l+1,r+1),dfs(l+1,r));
   if(L[l]>R[r]){
       dp[l][r]=max(dp[l][r],dfs(l,r+1)+R[r]);
   }
    return dp[l][r];
}

int solution(vector<int> left, vector<int> right) {
    L=left;
    R=right;
    return dfs(0,0);
}
```

