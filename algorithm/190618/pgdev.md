# 프로그래머스 기능개발

##### - 문제는 사이트를 참고하자



# 실패

##### -  작업은 동시에 진행되어도 배포는 순차적으로( 날짜를 누적해서) 진행된다고 문제 이해를 잘못해서  이중 for문을 이용했다.  ==> 무조건 progresses[i] > progresses[i+1] 이면 같은 날에 배포된다.

##### - 작업일수 a[ ] 에 저장 방법  ***

##### i) (100-progresses) /speeds 구해서 ceil로 소수점이 나오면 올림해준다

##### ii)  while(1)   [ 내가 푼 방법 ]



```c++
	 int a[100]={};
    
    for(int i=0;i<progresses.size();i++){   // ***
        
        while(1){
            if(progresses[i]>=100){
            
            break;
        }
            
            progresses[i]+=speeds[i];
            a[i]+=1;
        }
        
    }
    

    int check=progresses.size();
    int check1;

    for(int i=0;i<progresses.size();i++){     
       
        int count=1;
        check1=0;
        
        for(int j=i+1;j<progresses.size();j++){
            
            if(a[i]>=a[j]){
             
              
                check1+=a[j];
                if(check1>a[i]) {
                            break;}
                count++;
            }
        }
        check-=count;
        
        answer.push_back(count);
        
        if(check==0) break;
    }
    
```



# 성공

```c++
#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    int a[100]={};
    int max;
    for(int i=0;i<progresses.size();i++){    // ***
        
        while(1){
            if(progresses[i]>=100){
            
            break;
        }
            progresses[i]+=speeds[i];
             a[i]+=1;
        }
    }
    max=a[0];
    int cnt=1;
    for(int i=1;i<progresses.size();i++){
  
        
        if(max>=a[i]){
                cnt++;
        }
        else{
            answer.push_back(cnt);
            cnt=1;
            max=a[i];
            
        }
        
    }
    
    answer.push_back(cnt);
   
    return answer;
}

```