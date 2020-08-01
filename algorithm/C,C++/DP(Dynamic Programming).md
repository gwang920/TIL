# DP(Dynamic Programming)

참고 - <https://coding-all.tistory.com/2>

#### 1. 큰 문제를 작은 문제로 나눠서 푸는 기법

#### 2. 메모이제이션

- 컴퓨터 프로그램이 동일한 계산을 반복해야 할 때, 

  '이전에 계산한 값을 메모리에 저장'함으로써 

  동일한 계산의 반복 수행을 제거하여 프로그램 실행 속도를 빠르게 하는 기술

-  동적 계획법의 핵심이 되는 기술

​	(1) 중복 제거 전

![fibo1](https://user-images.githubusercontent.com/49560745/69130419-d7148b80-0af3-11ea-9607-4f6b443a0ab6.png)



##### 

​	(2) 중복 제거 후

![fibo2](https://user-images.githubusercontent.com/49560745/69130447-e267b700-0af3-11ea-962c-4cfa2478f9c9.png)



##### 



```
- 동적계획법(DP)는 중복된 계산을 막기 위해 저장된 결과를 배열에 저장한 뒤,
이를 다음 계산에 활용한다
```

#### 3. TOP - DOWN

```
- 재귀와 같은 방식
- 위에서 아래로 내려오면서 코드풀이가 진행되는 방식
```



##### 일반재귀

```c++
long long fib(long long n){
    if (n == 1 || n == 2)
        return 1;
    return fib(n - 1) + fib(n - 2);
}
```



##### 메모이제이션 방식

```c++
long long fib(long long n){
    if (n == 1 || n == 2)
        return 1;
    if (!memo[n])
        return memo[n];
    memo[n] = fib(n-1) + fib(n-2);
    return memo[n];
}
```



#### 예제 - 백준 (평범한배낭 - 12865)

```c++
#include <stdio.h>
#include <algorithm>

using namespace std;
 

int N,K;
int W[100],V[100];    
int dp[101][1000001];

int go(int i,int w){
    
    if(dp[i][w]>0) return dp[i][w];  // 메모이제이션
    if(i==N) return 0;
    
    int n1=0;
    if(K>=w+W[i])
          n1=V[i]+go(i+1,w+W[i]);
    
    int n2=go(i+1,w);
    
    return dp[i][w]=max(n1,n2);  // 메모이제이션이 가능한경우
    							 // 1) 해당 return이 실행 된 경우(dp[i][w]=max(n1,n2)도 실행)
    							 // 2) return 은 실행되지않고 dp[i][w]=max(n1,n2)만 만족되는 									경우
								 // 즉, return이 실행 되지않아도 등식은 update 된다 ?
    
    // dp[i][w]=max(n1,n2);
    // return dp[i][w];
}
 
int main(){
    
    scanf("%d %d",&N,&K);
    for(int i=0;i<N;i++) scanf("%d %d", W+i,V+i);
    printf("%d\n",go(0,0));
    return 0;
}
```

