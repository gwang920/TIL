##### 프로그래머스 Lv2 예상대진표

* 참고 : ceil(a/2) != ceil(a/2.0)
* 수학적인 공식을 일반화하는 문제



```c++
#include <iostream>
#include <cmath>

using namespace std;

int solution(int n, int a, int b)
{
    int answer = 0;


    while(1){

        answer++;
        if(a%2==0){
            if(a-1==b){

                break;
            }

        }else if(a%2==1){

            if(a+1==b){

                break;
            }

        }

        a=ceil(a/2.0);
        b=ceil(b/2.0);

    }


    return answer;
}
```

