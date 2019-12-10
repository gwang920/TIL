# 프로그래머스 - 큰 수 만들기

- 카테고리 : 탐욕법
- 문자열의 개수를 만족하는 범위안에서 max값을 구하고 answer에 + 해준다.







```c++
#include <string>
#include <iostream>
#include <algorithm>

using namespace std;
string solution(string number, int k) {
    string answer="";
    int length=number.length()-k;
    int idx=0;
    while(1){
        char max='0';
        for(int i=idx;i<=answer.length()+k;i++){
        if(length==answer.length()) return answer;
        if(max<number[i]){
            max=number[i];
            idx=i+1;
        }
    }
        answer+=max;
    }
}
```

