# 프로그래머스 -  2 x n 타일링

- 카테고리 : DP

```
매번 1,000,000,007로 나눠줘야한다.
```



# 실패

```c++
#include <string>
#include <vector>

using namespace std;

int dp[60001];
int solution(int n) {
    int answer = 0;
    dp[1]=1;dp[2]=2;
    
    for(int i=3;i<=n;i++){
        dp[i]=(dp[i-1]+dp[i-2]);
    }
    return dp[n]%1000000007;
}
```





# 성공

```c++
#include <string>
#include <vector>

using namespace std;

int dp[60001];
int solution(int n) {
    int answer = 0;
    dp[1]=1;dp[2]=2;
    
    for(int i=3;i<=n;i++){
        dp[i]=(dp[i-1]+dp[i-2])%1000000007;
    }
    return dp[n];
}

-----------------------------------------------------------------------------------------
#include <string>
#include <vector>

using namespace std;

int dp[60001];
int d(int x){
    if(x==1) return 1;
    if(x==2) return 2;
    if(dp[x]!=0) return dp[x];
    return dp[x]=(d(x-1)+d(x-2))%1000000007; 
}

int solution(int n) {
    int answer = 0;
    return d(n);
}
```

