



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

3) vector형을 갖는 우선순위큐
#include <functional>  // greater를 위함

typedef pair<int,pair<int,int>> PAIR;
priority_queue<PAIR,vector<PAIR>,greater<PAIR>> pq;


* 참고
Queue 
- 기본 생성자 형식
queue<자료형> 변수명;
ex) queue<int> q;

- 내부 컨테이너 구조를 바꾸는 생성자 형식
queue<자료형,컨테이녀 자료형> 변수명;
ex) queue<int,list<int>> q;
	queue<string,list<string>> q;	
```





##### 트러블 슈팅 **signal: floating point exception (core dumped)**

```
나누기 할시 변수/0꼴이 있으면 발생
```



##### 배열 최대크기

```
[20001] x [20001]
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



##### string -> int

```c++
string numbers=155;
int temp=5;
if(numbers[j]-'0'==temp)

와 같이 string -> int로 변환하여 비교가 가능하다.
```



##### rotate (90 도 회전)

```c++
for (int y = 0; y < n; ++y) {
			for (int x = 0; x < n; ++x) {
				temp[y][x] = map[n - x - 1][y];           ///90 도 회전 ?  
			} 
		}

		for (int y = 0; y < n; ++y) {			// map[y][x]=map[n-x-1][y] 하지 않는 이유는  
			for (int x = 0; x < n; ++x) {		// map[y][x]의 값이 먼저 바뀌기 때문에 원래의 map[y][x]  값은 사라진다. 
				map[y][x] = temp[y][x];
			}
		}
```

##### 재귀 return 

```c++

bj15684참고

int Connect(int Count,int Goal,int Idx){
	
	if(Count==Goal){
		if(Check()==true){
            cout << true << endl;
		return 1;
		}
		return 0;
	}
   	 ( 생략 )
    
        .
        .
        .
	Connect(Count+1,Goal,i);
}


int main(){
	for(int i=0;i<4;i++){
		if(Connect(0,i,1)==1){  
			cout << i << endl;
			return 0;
		}
	}
	cout << "-1" << endl;
	return 0;
}
------------------------------------------------------------------------------------
출력 값
true
true
true
true
true
-1
------------------------------------------------------------------------------------
    
true 가 출력 될 때마다 해당 i 값이 출력 되어야하는데 그렇지 않다! 
    
=> 재귀에서 조건에 만족하는 모든 경우의 수가 return 된다.
   그렇기에 main함수의 if 조건문은 적절하지 않다.
   세부 재귀 함수가 아닌 Top 재귀 함수의 값이 return 되기 때문(?)

```



### 실수

##### BFS - 단순한 실수를 놓치지 말자

```
map[y][x]로 두면 값이 다르게 된다.
이미 queue에 (1,2)가 저장된 상태에서
bfs(3,4)를 해주면

(q.front().first = 1) != (y=3)
(q.front().second=2) != (x=4)

으로 두 값이 같지 않다.
```



```C++
void bfs(int y,int x){
    q.push({y,x});
    while(!q.empty()){
        auto now=q.front(); q.pop();
        for(int i=0;i<4;i++){
            int ny=now.first+dy[i];
            int nx=now.second+dx[i];
            
            if(ny>size-1 || nx>size-1 || ny<0 || nx<0) continue;
            int dist=abs(map[y][x]-map[ny][nx]); //(X) ************************
			// int dist= abs(map[now.first][now.second]-map[ny][nx]);
            if(visited[ny][nx]) continue;
            
            if(dist<=level){
                q.push({ny,nx});
                visited[ny][nx]=1;
            }else if(dist>level){
                pq.push({dist,{ny,nx}});
            }
        }
    }
    return;
}
```



##### DFS 인자 넘겨주기

- Case 1 - 인자를 변형시키고 넘겨주는 경우
- Case2 - DFS호출 함수 안에 인자를 번형시키는 경우
- 두 Case의 함수 결과 값은 당연히 다르다.

```c++
Case 1 -

void Dfs(int idx,int sum,vector<int> &Case){
	
	cout << Case[2] << endl;	
	if(idx==number.size()){
		Maximum=max(Maximum,sum);
		Minimum=min(Minimum,sum);
		return;
	}
	
	if(Case[0]){
		Case[0]--;
		Dfs(idx+1,sum+number[idx],Case);
	}
	if(Case[1]){
		Case[1]--;
		Dfs(idx+1,sum-number[idx],Case);	
	}
	if(Case[2]){
		Case[2]--;
		Dfs(idx+1,sum*number[idx],Case);	
	}
	if(Case[3]){
		Case[3]--;
		Dfs(idx+1,sum,Case);	
	}
}

Case 2 -

void Dfs(int plus,int minus,int multiply,int divide,int idx,int sum){
	
	
	if(idx==number.size()){
		
		Maximum=max(Maximum,sum);
		Minimum=min(Minimum,sum);
		
		return;
	}
	
	if(plus>0) Dfs(plus-1,minus,multiply,divide,idx+1,sum+number[idx]);
	if(minus>0) Dfs(plus,minus-1,multiply,divide,idx+1,sum-number[idx]);
	if(multiply>0) Dfs(plus,minus,multiply-1,divide,idx+1,sum*number[idx]);
	if(divide>0) Dfs(plus,minus,multiply,divide-1,idx+1,sum/number[idx]);
}
```



