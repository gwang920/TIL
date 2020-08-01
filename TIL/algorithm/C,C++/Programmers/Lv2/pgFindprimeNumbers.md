# 프로그래머스 소수찾기

- 카테고리 : 완전탐색

- 순열 알고리즘을 참고하려 구글링 했는데 더 간단한 풀이가 있어 참고했다.

- check 함수를 통해 해당 숫자를 numbers가 포함하고 있는지 check한다.

- 결국, 소수 판정은  아래의 for문으로 해결 가능하다.

  - 1) 소수가 아닌 수는 2~9의 수로 나누어 떨어진다.
  - 2) 즉, 2~9의 배수를 순차적으로 방문처리하면 소수가 아닌 수는 배제된다.

  ```c++
  for(int i=2;i<=stoi(numbers);i++){
          if(!prime[i] && check(i,numbers)){
              answer++;
          }
          if(!prime[i]){
              for(int j=i;j<=stoi(numbers);j+=i){
                  prime[j]=true;
              }
          }
      }    
  ```

  



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



# 성공

```c++
#include <string>
#include <vector>
#include <algorithm>
#include <functional>
#include <iostream>
using namespace std;

bool check(int i,string numbers){
    vector<bool> visit(numbers.length());
    while(i!=0){
        bool flag=false;
        int temp=i%10;
        for(int j=0;j<numbers.length();j++){
            if(!visit[j] && numbers[j]-'0'==temp){
                flag=true;
                visit[j]=true;
                break;
            }
        }
        if(!flag){
            return false;
        }
        i/=10;
    }
    return true;    
}

int solution(string numbers) {
    int answer = 0;
    sort(numbers.begin(),numbers.end(),greater<int>());
    vector<bool> prime(stoi(numbers)+1);
    for(int i=2;i<=stoi(numbers);i++){
        if(!prime[i] && check(i,numbers)){
            answer++;
        }
        if(!prime[i]){
            for(int j=i;j<=stoi(numbers);j+=i){
                prime[j]=true;
            }
        }
    }    
    return answer;
}
```

