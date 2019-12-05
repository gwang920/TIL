



##### 2차원 배열의 원소가 문자열 일 때 

```c++
tickets 배열 : [[ICN, JFK], [HND, IAD], [JFK, HND]]



-

vector<string> answer;

answer.push_back(tickets[0][1]);
string a="";
a=answer[0];
printf("%c",a[0]);


결과
J
```





##### vector 초기화(크기 및 값 지정)

```c++
1) 1차원 배열
vector<bool> visit(tickets.size(), false); 

// (크기,초기값) 지정 가능

2) 2차원 배열
vector<vector<int> > arr(6, vector<int>(5, 0));

// int arr[6][5] 배열 선언. 0으로 값 초기화
```





##### 트러블 슈팅 **signal: floating point exception (core dumped)**

```
나누기 할시 변수/0꼴이 있으면 발생
```





##### int 형 범위 초기화

```c++
int answer = 0x7f7f7f7f;
```





##### 플로이드 와샬 알고리즘

```c++
기본 구조

// k = 거쳐가는 노드
for(int k=0;k<N;k++){
	// i = 시작 노드
	for(int i=0;i<N;i++){
		// j = 도착 노드
		for(int j=0;j<N;j++){
			if(map[i][j]<map[i][k]+map[k][j])
            	map[i][j]=map[i][k]+map[k][j];
		}	
	}
}
```





##### queue VS stack

```c++
간단하게 queue의 반대는 stack이다(?)


queue : 선입 선출
	q.front()						
  		   [][][][][][][][] 
	q.pop()				
stack : 후입 선출
						  s.top()
  		 [][][][][][][][]
  		 				  s.pop();
  		 				  
  		 				  
 ex)
 arr[4]={1,2,3,4};
 
 배열을 각각 queue와 stack에 넣어주면
 
 queue [1][2][3][4]
 stack [1][2][3][4]
 
 가 된다.
 
 이때 queue.top() = [1]
 	  stack.top() = [4]
 	  
 	  가 됨
 	  
 즉, queue와 stack은 top()의 위치가 다르다
 
 ex)
 	queue<int> q1;
    stack<int> s1;
    
    for(int i=0;i<5;i++){
        
        q1.push(i);
        s1.push(i);
    }
    
    cout << "q1=" << q1.front() <<"s1=" <<s1.top();
    q1.pop(); s1.pop();
    cout << "q1="<<q1.front() << "s1="<<s1.top();
    
    출력 	q1=0 s1=4 q1=1 s1=3
```



##### 자료형 크기

```c++
#include <string>
#include <vector>
#include <iostream>
using namespace std;
long long solution(int n) 
{
    vector<long> v;  // vector<int> v; 로 두면 효율성 오류 발생
    v.push_back(1);
    v.push_back(1);
    // int sum=0; 으로 두면 효율성 오류 발생
    long long answer = 0;
    long long sum=2;
    for(int i=0;i<n-2;i++){
         v.push_back(v[i]+v[i+1]);
         sum+=v[i+2];
     }
    answer=4*sum-2*(sum-1);
    return answer;
}

```



##### 배열 초기화 ( 전역 / 지역)

```c++
1) 전역변수 선언
int map[20001][20001];
int solution(int n, vector<vector<int>> edge) {

     for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
          cout << map[i][j];
        }
        cout << endl;
    }
}

출력
000000
000000
000000
000000
000000
000000

2) 지역변수 선언
int solution(int n, vector<vector<int>> edge) {
	int map[20001][20001];  // 쓰레기값이 들어간다
     for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
          cout << map[i][j];
        }
        cout << endl;
    }
}

출력
signal: segmentation fault (core dumped)
```

