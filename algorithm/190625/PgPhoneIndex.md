# 프로그래머스 전화번호목록

- 해시 분류지만 해시를 사용하지 않고 풀수있다
- 채점요소인 효율성에 따라 시간을 반복횟수를 줄일 수 있는 방법을 찾자

# 성공

- flag로 시간초과를 관리

```c++
#include <string>
#include <vector>
#include <iostream>
using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    string sub;
    bool flag=0;
    for(int i=0;i<phone_book.size();i++){
        if(flag==1) break;
        for(int j=0;j<phone_book.size();j++){
    
            if(i==j || phone_book[i].length()>phone_book[j].length()) {
                
                continue;
            }
                int k=phone_book[i].length();
                sub=phone_book[j].substr(0,k);
            
                if(phone_book[i]==sub){
                    
                    answer=false;
                    flag=1;
                    break;
                    
                }
        }
    }
    return answer;
}
```

