# 프로그래머스 - Hindex

- 카테고리 : 정렬

- 테스트케이스 하나가 계속 안맞아 구글링을 참고했다.





# 실패

```c++
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    int count=0;
    sort(citations.begin(),citations.end());
    while(1){
        for(int i=0;i<citations.size();i++){
            if(count>=citations[i]){
                if(citations.size()-i-1==count) return count;
            }
        }
        count++;
    }
}
```



# 성공

```c++
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    sort(citations.begin(),citations.end(),greater<int>());
    while(answer<citations.size()){
        if(citations[answer]<=answer) break;
        answer++;
    }
    return answer;
}
```

