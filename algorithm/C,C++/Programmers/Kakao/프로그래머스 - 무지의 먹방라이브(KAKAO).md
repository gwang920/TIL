# 프로그래머스 - 무지의 먹방라이브(KAKAO)

문제 : https://programmers.co.kr/learn/courses/30/lessons/42891#

- 카테고리 : ProblemSolving

```c++
구현 자체가 까다로웠던 문제
    
1) {food_times,index} 형식의 vector(tas)를 선언한다.
2) tas를 food_times의 원소를 기준으로 오름차순이 되게 정렬한다.
3) 순차적으로 진행한다.
  [5,6,2,5,2], k=14 일때
    
   정렬하면 [2,2,5,5,6]
    
  1. 현재 위치와 같은 값까지 이동해주고, 현재 값 * size 만큼 k에서 제거해준다.
    
    [2,2] 만큼 이동한다.(두바퀴를 돌면 0번 index값이 제거되므로) 
    2(food_times[idx]-bef)*5(size)만큼 k에서 제외한다.
    => idx=2; k=4가 된다.  
      k값이 tmp*size보다 클때까지 반복  
        
  2. [5,5] 만큼 이동하려 했더니 k값이 5*3 보다 작다.
        따라서, k값을 남은 원소의 수로 나누어주면 정답이 구해진다.
        단, [5,5,6]을 index 순으로 정렬해야한다.
        정렬해주면 [5,6,5]가 되고
       	(현재 idx=2 (0 -> 1 -> 2))
        k%3=1 이므로 현재 idx=2에 +1 이 구하고자 하는 index가 되고
        6은 index 순으로 재정렬 된 tas에서 index=3이므로 
        tas[3].second가 도출하고자하는 idx가 된다.
        배열은 0부터 시작하므로 answer=idx+1을 하면 정답이 도출된다.      
        

실수했던부분
1) 자료형
int형으로 선언하면 안된다.
=> food_times의 최대 원소값이 100,000,000 이기 때문
    
2) food_times의 원소합이 < k 일때 -1을 return 해줘야한다.
=> 만약 더 섭취해야 할 음식이 없다면 -1을 반환한다.
    
3) bef+=tas[idx].first;
=> bef+=tmp; (매번 갱신된 값을 더해줘야한다.)
```



# 실패

```C++
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

bool compare(pair<int,int> &a,pair<int,int> &b){
    return a.second<b.second;
}

int solution(vector<int> food_times, long long k) {
    int answer = 0;
    long long int size=food_times.size();
    vector<pair<int,int>> tas(size);
    for(int i=0;i<size;i++){
        tas[i]={food_times[i],i};
    }
    
	sort(tas.begin(),tas.end());
    int idx=0,cnt=0;
    long long int bef=0;
    int bre=0;
    while(1){
        long long int tmp=tas[idx].first-bef;
        int bef_idx=idx;
        cnt=0;
        while(idx<food_times.size() && tmp==tas[idx].first-bef){
            idx++;
            cnt++;
        }
         bre++;
         if(bre>10) return 1;
        if(k-tmp*size<=0){
            sort(tas.begin()+bef_idx,tas.end(),compare);
            idx=bef_idx+k%(size);
            answer=tas[idx].second;
            return answer+1;
        }
        k-=tmp*(size);
        bef+=tas[idx].first; // tas[idx].first가 아닌 tmp로 바꿔줘야한다.
        size-=cnt;
    }
    return -1;
}
```



# 성공

```c++
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

bool compare(pair<int,int> &a,pair<int,int> &b){
    return a.second<b.second;
}

int solution(vector<int> food_times, long long k) {
    int answer = -1;
    long long int size=food_times.size();
    long long int sum=0;
    vector<pair<int,int>> tas(size);
    for(int i=0;i<size;i++){
        sum+=food_times[i];
        tas[i]={food_times[i],i};
    }
    if(sum<=k) return answer;
	sort(tas.begin(),tas.end());
    int idx=0,cnt=0;
    long long int bef=0;
    while(idx<food_times.size()){  // while(1)으로 해도 상관없다.
        long long int tmp=tas[idx].first-bef;
        int bef_idx=idx;
        cnt=0;
        while(idx<food_times.size() && tmp==tas[idx].first-bef){
            idx++;
            cnt++;
        }
        if(k-tmp*size<=0){
            sort(tas.begin()+bef_idx,tas.end(),compare);
            idx=bef_idx+k%(size);
            answer=tas[idx].second;
            return answer+1;
        }
        k-=tmp*(size);
        bef+=tmp;
        size-=cnt;
    }
}
```

