# 프로그래머스 프린트

- 카테고리 : 스택/큐

- stack을 이용한 풀이





```c++
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <iostream>
using namespace std;
stack<int> st;
int solution(vector<int> priorities, int location) {
    int answer = 1;
    int check[101]={0,};
    vector<int> backup=priorities;
    sort(backup.begin(),backup.end());
    for(int i=0;i<backup.size();i++){
        st.push(backup[i]);
    }

    while(1){
        for(int i=0;i<priorities.size();i++){
            int top=st.top(); 
            if(!check[i] && top==priorities[i]){
                if(i==location) return answer;
                answer++;
                st.pop();
                check[i]=1;
            }   
        }
    }
}
```

