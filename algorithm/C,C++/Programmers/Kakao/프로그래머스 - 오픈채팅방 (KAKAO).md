# 프로그래머스 - 오픈채팅방 (KAKAO)

- 카테고리 : 시뮬레이션

```c++
문제 : https://programmers.co.kr/learn/courses/30/lessons/42888

항상 string을 index로 갖는 인자를 어떻게 컨트롤 할지 몰랐다.
단순 vector, map 에 자료형을 string으로 주면 간단하게 해결된다.

map<key,value>
map 컨테이너는 key,value 형식을 갖으며
map[key]=value; 형식으로 저장된다.
    
    이 오픈채팅방 문제도 위와 같이 map,vector를 이용해 풀이할 수 있다.

```



# 성공

```c++
#include <string>
#include <iostream>
#include <string>
#include <vector>
#include <map>
using namespace std;

vector<string> solution(vector<string> record) {
    vector<string> answer;
    map<string,string> rec;
    vector<pair<string,char>> temp;
    
    for(int i=0;i<record.size();i++){
        char tmp=record[i][0];
        if(tmp=='E'){
            int j;
            string id;
            for(j=6;record[i][j]!=' ';j++){
                id+=record[i][j];
            }
            string name;
            for(int k=j+1;k<record[i].size();k++){
                name+=record[i][k];
            }
            rec[id]=name;
            temp.push_back({id,'E'});
        }
        if(tmp=='L'){
            string id;
            for(int j=6;j<record[i].size();j++){
                id+=record[i][j];
            }
            temp.push_back({id,'L'});
        }
        if(tmp=='C'){
            string id;
            string name;
            int j;
            for(j=7;record[i][j]!=' ';j++){
                id+=record[i][j];
            }
            for(int k=j+1;k<record[i].size();k++){
                name+=record[i][k];
            }
            rec[id]=name;
        }
    }    
    
    for(int i=0;i<temp.size();i++){
        string name=rec[temp[i].first];
        if(temp[i].second=='E'){
            answer.push_back(name+"님이 들어왔습니다.");
        }else{
            answer.push_back(name+"님이 나갔습니다.");
        }
    }
    
    return answer;
}
```

