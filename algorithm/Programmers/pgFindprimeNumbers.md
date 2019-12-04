# 프로그래머스 소수찾기

- 카테고리 : dfs



# 실패

```c++
#include <string>
#include <vector>
#include <math.h>
#include <iostream>
#include <functional>

using namespace std;

int count=0;
string sub_str[100];

void dfs(string s,int k,string numbers){
    //check stoi
    sub_str[0]=s.substr(0,k+1);
    int num=stoi(sub_str[0]);
    for(int i=2;i<num;i++){
        if(num%i==0){
            count++;
            return;
        } 
    }
    
    if(s.length()==numbers.length()) return;
    
    //make
    for(int i=k+1;i<numbers.size();i++){
        string tmp=numbers[i]+"";
        
       dfs(s+tmp,i,numbers);
    }  
}

int solution(string numbers) {
    int answer = 0;
    for(int i=0;i<numbers.size();i++){
         dfs(numbers[i]+"",i,numbers);
    }
  
    cout << count;  
    // string 1 == int 49
    return 0;
}
```

