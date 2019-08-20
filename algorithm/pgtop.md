# 프로그래머스 탑

- 카테고리 : 큐/스택
- 배열을 이용해 간단하게 풀이했다

```c++
#include <string>
#include <vector>
#include <iostream>


using namespace std;

vector<int> solution(vector<int> heights) {
    vector<int> answer;
    int tmp[50]={0,};
    
    for(int i=heights.size()-1;i>=1;i--){
        for(int j=i-1;j>=0;j--){
            if(heights[i]<heights[j]){

                tmp[i]=j+1;
                break;
            }
        }
   }

  for(int i=0;i<heights.size();i++){
    answer.push_back(tmp[i]);
  }
    
    return answer;
}
```

