# 프로그래머스 - 구명보트

<https://programmers.co.kr/learn/courses/30/lessons/42885>

카테고리 : 탐욕법(Greedy)

- erase를 사용하니 index참조  문제인지 에러(core dumped)가 발생했다.
- 구명보트에 탑승한 인원의 배열은 전부 0으로 하는 방식을 구현했다.

# 성공

```c++
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    int i=0;
    int j=people.size()-1;
    sort(people.begin(),people.end());
    while(1){
           if(people[i]==0 && people[j]==0) return answer;
            if(people[i]+people[j]<=limit){
                people[i]=0;
                people[j]=0;
                answer++;
                j--;
                i++;
            }
            else if(people[i]+people[j]>limit){
                people[j]=0;
                j--;
                answer++;
            }
        }
    }
```

