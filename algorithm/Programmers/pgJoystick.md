# 프로그래머스 - 조이스틱

- 카테고리 : 탐욕법

- [상하] 이동 / [좌우] 이동
- [상하] 이동 - 최소 이동 거리 : 'A' 'Z'를 이용해 구한다.
- [좌우] 이동 - 최소 이동 거리 : Depth를 좌우로 넓혀가며 'A'가 아닌 지점을 탐색 지점으로 지정하고, 이동거리를 더해준다.





```c++
#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(string name) {
    int answer = 0;
    string s;
    int length=name.length();
    while(length--){
        s+='A';
    }
    int idx=0,cnt=1;
    while(1){
        if(name==s) return answer;
        if(name[idx]=='A'){
            int back=idx+cnt;
            int front=idx-cnt;
                if(front<0) front=name.length()-cnt;
                if(back>length-1) back=cnt-1;
                if(name[front]=='A' && name[back]=='A'){
                    cnt++;
                }
                else{
                if(name[front]=='A'){
                     idx=back;
                     answer+=cnt; cnt=1;
                } 
                else if(name[back]=='A'){
                    idx=front;
                    answer+=cnt; cnt=1;
                }else{
                    idx=front;
                    answer+=cnt; cnt=1;
                }
                }
        }else{
            int low=name[idx]-'A';
            int high='Z'-name[idx]+1;
            name[idx]='A';
            if(low>high)
                answer+=high;
            if(low<=high)
                answer+=low;
        }
    }
}
```

