# 프로그래머스 N개의 수의 최소공배수

- 실패의 else문과 성공의 gcd / lcm 을 비교하자..

  

# 실패

```c++
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
#include <iostream>
using namespace std;

int solution(vector<int> arr) {
    sort(arr.begin(),arr.end());
    int i=0;
    int flag=1;
    int check_num=1;
    
    while(true){
        if(i==arr.size()-1) return arr[i];
        if(arr[i+1]%arr[i]==0){
            i++;
        }
        else{
            int min_=min(arr[i],arr[i+1]);
            check_num=1;
            while(1){
                if(flag==0) {
                    arr[i+1]=arr[i]*arr[i+1]*check_num;
                    cout << arr[i+1] << " ";
                    i++;
                    break;
                }
                flag=0;
                for(int j=2;j<=min_;j++){ 
                if(arr[i]%j==0 && arr[i+1]%j==0){  
                    check_num=j;
                    flag=1;
                    arr[i]/=j;
                    arr[i+1]/=j;
                    break;
                }
             }
            }
          
            
        }   
    }

}
```



# 성공

```c++
#include <string>
#include <vector>

using namespace std;

int gcd(int a, int b)        // 최대공약수 구하기
    {
	int c;
	while (b != 0)
	{
		c = a % b;
		a = b;
		b = c;
	}
	return a;
}
int lcm(int a, int b)         // 최소공배수 구하기
{
    return a * b / gcd(a, b);
}

int solution(vector<int> arr) {    
    for(int i=0;i<arr.size()-1;i++){
        arr[i+1]=lcm(arr[i],arr[i+1]);
    }
    
    return arr[arr.size()-1];
}
```

