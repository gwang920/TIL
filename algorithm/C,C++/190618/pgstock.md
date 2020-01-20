# 프로그래머스 주식가격

##### 스택/큐를 이용한 문제



# 실패

```c++
#include <string>
#include <vector>
#include <stdio.h>


using namespace std;


vector<int> prices;

vector<int> answer;
	
	
	
int main(void){
	
	int n,k;
	int cnt=0;
	
	scanf("%d",&n);
	
	for(int i=0;i<n;i++){
		
		
		scanf("%d",&k);
		
		prices.push_back(k);
	}



	
    
    for(int j=0;j<prices.size();j++){
            cnt=1;
           for(int i=j+1;i<prices.size();i++){
           	
           	
            if(prices[j]<=prices[i] ){
            	if(i==j+1) continue;     // * 문제 지점
                    cnt++;
                        
                 
            }
            else{
            	
            	break;
			}
              
    }
    
    answer.push_back(cnt);	
			
    }
    
    answer[prices.size()-1]=0;
 
    
    
    for(int i=0;i<n;i++){
    	printf("%d ",answer[i]);
	}
	
	
	
	return 0;
	
}
```



##### 반례 12332

##### 정답 : 4 3 2 1 0

##### 내 결과 : 4 3 1 1 0

##### 이유 : j+1일때 continue하면 연속된 수가 나올 때 count가 되지 않는다



# 성공

```c++
#include <string>
#include <vector>
#include <stdio.h>


using namespace std;


vector<int> prices;

vector<int> answer;
	
	
	
int main(void){
	
	int n,k;
	int cnt=0;
	
	scanf("%d",&n);
	
	for(int i=0;i<n;i++){
		
		
		scanf("%d",&k);
		
		prices.push_back(k);
	}



	
    
    for(int j=0;j<prices.size();j++){
            cnt=0;
           for(int i=j+1;i<prices.size();i++){
           	
           	if(prices[j]>prices[i]) {
           		cnt++;
           		break;
           		
			   }
            if(prices[j]<=prices[i] ){
            	
                    cnt++;
                        
                 
            }
            else{
            	
            	break;
			}
              
    }
    
    answer.push_back(cnt);	
			
    }
    
    answer[prices.size()-1]=0;
 
    
    
    for(int i=0;i<n;i++){
    	printf("%d ",answer[i]);
	}
	
	
	
	return 0;
	
}

```