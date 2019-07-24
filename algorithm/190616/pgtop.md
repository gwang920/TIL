# 프로그래머스 LV2 탑



수평 직선에 탑 N대를 세웠습니다. 모든 탑의 꼭대기에는 신호를 송/수신하는 장치를 설치했습니다. 발사한 신호는 신호를 보낸 탑보다 높은 탑에서만 수신합니다. 또한, 한 번 수신된 신호는 다른 탑으로 송신되지 않습니다.

예를 들어 높이가 6, 9, 5, 7, 4인 다섯 탑이 왼쪽으로 동시에 레이저 신호를 발사합니다. 그러면, 탑은 다음과 같이 신호를 주고받습니다. 높이가 4인 다섯 번째 탑에서 발사한 신호는 높이가 7인 네 번째 탑이 수신하고, 높이가 7인 네 번째 탑의 신호는 높이가 9인 두 번째 탑이, 높이가 5인 세 번째 탑의 신호도 높이가 9인 두 번째 탑이 수신합니다. 높이가 9인 두 번째 탑과 높이가 6인 첫 번째 탑이 보낸 레이저 신호는 어떤 탑에서도 수신할 수 없습니다.

| 송신 탑(높이) | 수신 탑(높이) |
| :------------ | :------------ |
| 5(4)          | 4(7)          |
| 4(7)          | 2(9)          |
| 3(5)          | 2(9)          |
| 2(9)          | -             |
| 1(6)          | -             |

맨 왼쪽부터 순서대로 탑의 높이를 담은 배열 heights가 매개변수로 주어질 때 각 탑이 쏜 신호를 어느 탑에서 받았는지 기록한 배열을 return 하도록 solution 함수를 작성해주세요.

##### 제한 사항

- heights는 길이 2 이상 100 이하인 정수 배열입니다.
- 모든 탑의 높이는 1 이상 100 이하입니다.
- 신호를 수신하는 탑이 없으면 0으로 표시합니다.

##### 입출력 예

| heights         | return          |
| :-------------- | :-------------- |
| [6,9,5,7,4]     | [0,0,2,2,4]     |
| [3,9,9,3,5,7,2] | [0,0,0,3,3,3,6] |
| [1,5,3,6,7,6,5] | [0,0,2,0,0,5,6] |



# 실패코드

##### 왼쪽부터 접근하는 방식

#####  해당코드의 반례가 무엇인지 생각해보기

```

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <math.h>
#include <vector>

using namespace std;

int main(void){
	vector<int> heights;
	
	int n=0;
	int k;
	scanf("%d",&k);
	for(int i=0;i<k;i++){
		scanf("%d",&n);
		heights.push_back(n);
		
		
	}

    
    vector<int> answer;
    for(int i=heights.size()-1;i>=0;i--){
        answer.push_back(0);
        for(int j=i-1;j>=0;j--){
                
                if(heights[j]>heights[i]){
                answer.pop_back();
                answer.push_back(j+1
		    );
                break;
        }
        }
    }
    for(int i=k-1;i>=0;i--){
    	
    	printf("%d",answer[i]);
    } 
}

```

# 성공

```c
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <math.h>
#include <vector>

using namespace std;

int main(void){
	vector<int> heights;
	
	int n=0;
	int k;
	scanf("%d",&k);
	for(int i=0;i<k;i++){
		scanf("%d",&n);
		heights.push_back(n);
		
		
	}

    
    vector<int> answer(heights.size());   //선언시 백터size를 정할 수 있다
    for(int i=0;i<heights.size();i++){
        
        for(int j=i-1;j>=0;j--){
                
                if(heights[j]>heights[i]){
                
                answer[i]=j+1;
                break;
        }
        } 
    }
    for(int i=0;i<k;i++){
    	
    	printf("%d",answer[i]);
    } 
}

```



# 성공 

##### vector의 개념을 명확하게 이해 하기 위해 push pop 활용

```c++
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <math.h>
#include <vector>

using namespace std;

int main(void){
	vector<int> heights;
	
	int n=0;
	int k;
	scanf("%d",&k);
	for(int i=0;i<k;i++){
		scanf("%d",&n);
		heights.push_back(n);
		
		
	}

    
	vector<int> answer;
    for(int i=0;i<heights.size();i++){
        answer.push_back(0);
        for(int j=i-1;j>=0;j--){

                if(heights[j]>heights[i]){
                answer.pop_back();
                answer.push_back(j+1);
                break;
        }
        }
    }    for(int i=k-1;i>=0;i--){
    	
    	printf("%d",answer[i]);
    } 
}

```

