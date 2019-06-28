# 프로그래머스 더 맵게

### - 카테고리 : 힙(Heap)





```
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> scoville, int K) {
    int answer =0;
    int sum=0;
    bool flag=true;

  while(true){
        
        sort(scoville.begin(),scoville.end());
            
            if(scoville[0]>K && flag==true){
                answer=-1;
                
                break;
            }
            flag=false;
            
            
            if(scoville[0]<K){
                
                sum=scoville[0]+scoville[1]*2;
                scoville.erase(scoville.begin());
                scoville[0]=sum;
                answer++;
                sum=0;
                
            }
        else {
            
            break;
            
        }
    }
  
    
    return answer;
}
```

