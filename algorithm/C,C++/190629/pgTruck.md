# 프로그래머스 - 다리를 지나는 트럭

<https://programmers.co.kr/learn/courses/30/lessons/42583>

- 카테고리 : 스택/큐

# 실패

- 문제점 다시 찾아 보기
- 마지막 차량에 대한 count 값이 증가되지 않는 듯 하다
- TestCase 1 
  - 정답: 110 출력: 109      // 모든 트럭을 다리가 수용할 수 있어 각 트력마다 index 차이가 '1'
- TestCase 2
  - 정답 : 8 출력: 6     // 다리길이가 == '2' 인경우 (마지막 트럭은 독립되어 지나감)
- TestCse 3
  - 정답 : 101 출력 : 101  // TestCase 1 과 같은경우

```c++
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> v;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    int sum_weight=0;
    int count = 0;
    
    for(int i=0;i<truck_weights.size();i++){
        // 다리가 트럭을 더 수용할 수 있다면
        if(sum_weight+truck_weights[i]<=weight)
        {
            sum_weight+=truck_weights[i];
            answer++;
            v.push_back(0);
            count++;
            
            // 다리위의 모든 차량의 index 증가
            for(int j=0;j<v.size();j++)
            {  
                v[j]++;
            }
            
            // 만약 대기트럭 모두 다리로 올라왔다면
                if(count==truck_weights.size())
                {
                v.push_back(1);
                answer++;
                answer+=bridge_length-(v[v.size()-1]);
      
                }
            }        
          else if(sum_weight+truck_weights[i]>weight){
            int num = v.front();
            
            answer+=bridge_length-num;
            // v.erase(v.begin());

            for(int j=0;j<v.size();j++){
                v[j]+=bridge_length-num;
            }
        }
        
        if(v.front()==bridge_length){
            sum_weight-=truck_weights[i-(v.size()-1)];// 다리위의 트럭 중 가장 앞서있는 트럭의 무게를 제외해야한다
            
            v.erase(v.begin());
            answer++;
            
            for(int j=0;j<v.size();j++){
                v[j]++;
            }
           }
        }         
    return answer;
}
```



# 성공

- 코드를 좀 더 간략하게 나눠보는 연습
- 연결고리들을 명확하게 나누는 방법
- vector  vs queue 

```c++
#include <string>
#include <vector>
#include <queue>
 
using namespace std;
 
int solution(int bridge_length, int weight, vector<int> truck_weights) {

    int now=0,cnt=0;
    int sum_weight=0;
    queue<int> q;
    
    for(int i=0;i<truck_weights.size();i++){
        
        now=truck_weights[i];
        
        while(true){
            if(q.empty()){
                q.push(now);
                cnt++;
                sum_weight+=now;
                break;
            }
            else if(q.size()==bridge_length){
                sum_weight-=q.front();
                 q.pop();
            }
            else{
                if(sum_weight+now>weight){
                    q.push(0);
                    cnt++;
                }
                else{
                    q.push(now);
                    cnt++;
                    sum_weight+=now;
                    break;
                } 
            } 
        }   
    } 
    return cnt+bridge_length;
}
```



