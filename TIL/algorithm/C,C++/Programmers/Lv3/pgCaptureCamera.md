# 프로그래머스 - 단속 카메라

- 카테고리 : 탐욕법(Greedy)
- 솔루션 구글링 참고 - [https://ga0n.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%8B%A8%EC%86%8D%EC%B9%B4%EB%A9%94%EB%9D%BC](https://ga0n.tistory.com/entry/프로그래머스-단속카메라)
- 1) 먼저 출발 하는 순서대로 정렬
- 2) N의 도착 지점 > N+1의 도착지점이면 비교 값을 N+1 도착지점으로 갱신한다
- 3) N의 도착지점 < N+1의 출발 지점이면 카메라 개수를 증가시켜준다 + 비교 값을 N+1의 도착지점으로 갱신





```C++
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int solution(vector<vector<int>> routes) {
    int answer = 1;
    sort(routes.begin(),routes.end());
   
    int tmp=routes[0][1];
    
    for(int i=0;i<routes.size()-1;i++){
        if(tmp>routes[i][1]) tmp=routes[i][1];
        if(tmp<routes[i+1][0]){
            answer++;
            tmp=routes[i+1][1];   
        }
    }   
    return answer;
}
```

