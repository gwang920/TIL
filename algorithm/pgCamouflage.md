# 프로그래머스 위장(해시)

<https://programmers.co.kr/learn/courses/30/lessons/42578>

- 해시를 이용한 조합문제
- 만약 배열중에 headgear의 종류가 1개(=yellow_hat)이라면 조합의 수는 2개이다....!
  - 'yellow_hat을 착용하는 경우 , 착용하지 않는 경우' 가 문제의 POINT



# 실패#1

```c++
#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 0;
    int visited[30]={0,};
    int a[30]={0,};

for(int i=0;i<clothes.size();i++){
    for(int j=i;j<clothes.size();j++){
        
        if(visited[j]) continue;
        
        if(clothes[i][1]==clothes[j][1]){
            
            visited[j]=1;
            a[i]++;
            
        }
        
    }
}
int plus=0;
int multi=1;
for(int i=0;i<clothes.size();i++){
    
    plus+=a[i];
    multi*=a[i];

}
answer=plus+multi;


return answer;
}
```



# 실패#2

##### 도저히 답이 안나와서 배열 크기 문제로 인식하고 짠 코드,,

```c++
#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 0;
    int visited[30]={0,};
    int a[30]={0,};
   
int totalSize=sizeof(clothes);   
// sizeof(arr) 문장을 통해서 arr 배열의 전체 크기를 byte 로 구해서 totalSize 변수에 대입


int rowSize=sizeof(clothes[0]); 
// sizeof(arr[0]) 문장을 통해서 arr 배열의 0 번째 요소의 크기를 byte 로 구해서 rowSize 변수에 대입

int elementSize=sizeof(clothes[0][0]);
    //sizeof(arr[0][0]) 문장을 통해서 arr[0][0] 요소의 크기를 byte 로 구해서 elementSize 변수에 대입
    
int cul=totalSize/elementSize; // cul의 갯수
int row=totalSize/rowSize;   //row의 갯수

for(int i=0;i<row;i++){
    for(int j=i;j<row;j++){
        
        if(visited[j]) continue;
        
        if(clothes[i][1]==clothes[j][1]){
            
            visited[j]=1;
            a[i]++;
            
        }
        
    }
}
int plus=0;
int multi=1;
for(int i=0;i<row;i++){
    
    plus+=a[i];
    multi*=a[i];

}
answer=plus+multi;


return answer;
}
```

# 성공

```c++
#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 0;
    int a[30]={0,};
    int visited[30]={0, };
    
    for(int i=0;i<clothes.size();i++){
        for(int j=0;j<clothes.size();j++){
            if(visited[j]) continue;
            if(clothes[i][1]==clothes[j][1] ){
                visited[j]=1;
                a[i]++;
            }                                   
        }
    }
 
    int alsum=1;
    for(int i=0;i<clothes.size();i++){
       if(a[i]>0){
             alsum*=(a[i]+1); // clothes 2종류 headgear 1종류라면 
           					// 3(2+착용하지 않았을 경우) * 2(1+착용하지 않았을 경우) 가 경우의수
        }
    }
    
    answer=alsum-1;  // 모두 착용하지 않는 경우는 제외하자
    return answer;
}
```

