



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



##### priority_queue

```c++
우선순위큐에 여러개의 값이 들어갈 때 순차적으로 비교한다.
first -> second -> ...
    첫 번쨰 위치의 원소들을 비교하고 정렬, 두 번째 위치의 원소들을 비교하고 정렬 

[예제]
#include <iostream>
#include <queue>

using namespace std;
priority_queue<pair<int,int>> pq;

int main(){
	
	pq.push({2,1});
	pq.push({2,2});
	pq.push({1,3});
	pq.push({1,4});
	pq.push({3,5});
	int size=pq.size();
	for(int i=0;i<size;i++){
		cout << pq.top().first << " " << pq.top().second << endl;
		pq.pop();	
	}
	
	
	return 0;
}

[출력]
3 5
2 2
2 1
1 4
1 3
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
    
    +

char character='B';// 알파벳 A는 65 B는 66이다.
  char number='1';   // char형 1은 int 형 49이다.
  1) 문자형 문자인경우 : 문자 - 'A';
  		character - 'A'
        => 1
  2) 숫자형 문자인경우 : 문자 - '0';
  		number - '0'
  		=> 1
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

##### 조합 속도

```c++

case2 >>>>>> case1

8!*2 vs 8!+1

[Case1] 실패
void set(int idx){
	if(idx==10){
		game();
		return;
	}
	for(int i=2;i<10;i++){
		if(visit[i]) continue;
		if(idx!=4){
			arr[idx]=i;	visit[i]=1;
		} 
		set(idx+1);
		if(idx!=4) visit[i]=0;
	}
}

[Case2] 통과
void set(int idx){
	if(idx==4){
		set(idx+1);
		return;
	}
	if(idx==10){
		game();
		return;
	}
	for(int i=2;i<10;i++){
		if(visit[i]) continue;
		arr[idx]=i;	
		visit[i]=1;
		set(idx+1);
		visit[i]=0;
	}
}

```

##### 16 진수 -> 10진수 / 16진수 ->2진수

```c++
[16 진수 -> 10진수]

ex)
c921
1(16) = 1 x 16^0 = 1 x 1 
2(16) = 2 x 16^1 = 2 x 16
9(16) = 9 x 16^2 = 9 x 256
C(16) = C x 16^3 = C x 4096

c921(16)= 12 x 4096 + 9 x 256 + 2 x 16 + 1  

[16진수 -> 2진수]

ex)
A23 = 1010 0010 0011
BEE = 1011 1110 1110
70C558 = 0111 0000 1100 0101 0101 1000
```

##### HEADER : climits

```c++
#include <climits>
#include <iostream>
using namespace std;
int main(){

int min=INT_MIN;
int max=INT_MAX;

cout << "min:" << min << endl;
cout << "max:" << max << endl;
return 0;
}

[결과]
min:-2147483648
max:2147483647
```

##### 우선순위큐 오름차순(struct)

```c++
우선순위큐에 구조체에 여러개의 인자를 넣어줄 때 비교연산이 모호해진다.
[예시]
struct INFO{
	int y,x,z;
}
priority_queue<INFO> pq;

위와 같이 선언하면 y,x,z 중 우선순위를 결정할 수 없다.
    
차라리,
typedef pair<int,pair<int,int>> INFO;
priority_queue<INFO> pq;

와 같이 선언하면 순차적(first->second)으로 우선 순위를 결정할 수 있다.
```



##### 비트마스킹기법

```C++
특정 알고리즘이 아닌 bit을 활용한 하나의 기술이라고 할 수 있다.

AND(&)연산
	대응하는 두 비트가 모두 1일 때, 1을 반환.
	1010 & 1111 = 1010
OR(|)연산
	대응하는 두 비트가 모두 1 또는 하나라도 1일 때, 1을 반환.
	1010 | 1111 = 1111
XOR(^)연산
	대응하는 두 비트가 서로 다르면 1을 반환.
	1010 | 1111 = 0101
NOT(~)연산
	비트의 값을 반전하여 반환.
	~1010 = 0101
	
시프트(Shift) 연산(>>, <<)
    	왼쪽 또는 오른쪽으로 비트를 옮긴다.
	1010 | 1 << 2
	1010 | 0100 => 1110

	1110 & ~1 << 2		//먼저 이동하고 not연산
	1110 & 1011 => 1010

```



# SWEA

##### 오래된 스마트폰

```c++
1) DFS 리턴 범위 설정
  if(cnt>M || cnt>=res) return; -> if(cnt>=M || cnt>=res) return;
2) 가지 생성과 visit처리
   visit에 cnt를 저장해 visit[s]<cnt가 클 경우에만 return 시켰다.
```





# 백준

#### 스티커 붙이기

````c++
* 회전시키는 방법(모양이 직사각형인 경우)

1) 바뀌는 모양으로 범위를 지정한다.
바뀌기 전의 크기가 r=2 c=5 인경우

[y축길이=2, x축길이=5]

[][][][][][]
        []

90도 회전하면
[y축길이=5, x축길이=2] 가된다.

  []
  []
  []
[][]
  []

따라서 i,j의 범위인 r,c를 서로 바꿔준다.
for(int i=1;i<=c;i++){
	for(int j=1;j<=r;j++){
		
	}
}
        
2) 인덱스를 비교한다.
    바뀐모양, ()는 바뀌기전 모양의 index가 들어간다.
    [(2,1)][(1,1)]
    [(2,2)][(1,2)]
    [(2,3)][(1,3)]
    [(2,4)][(1,4)]
    [(2,5)][(1,5)]
    
    따라서
    
    (1,1)=(2+1-1,1)
    (1,2)=(2+1,-2,1)
    
   for(int i=1;i<=c;i++){
	for(int j=1;j<=r;j++){
		board[i][j]=tmp[r+1-j][i];
	}
} 

이 됨을 확인 할 수 있다.
````



##### 감시

````c++
실패코드의 재귀와 성공코드의 재귀를 비교하자.

cam개의 카메라를 4방향으로 탐색하는 모든 경우의수를 구하는 재귀

[예시]
cam=4
0000 0001 0002 0003 
0010 0011 0012 ...
4440 4441 4442 4443

[실패]
void dfs(int cnt){
	if(cnt==pow(4,cam)) return;
	Camera();
	for(int i=0;i<cam;i++){
		int tmp=d[i].dir;
		d[i].dir=(d[i].dir+1)%4;
		dfs(cnt+1);
		d[i].dir=tmp;
	}
}

[성공]
void dfs(int cnt){
	if(cnt==cam+1) return;
	Camera();
	for(int i=0;i<4;i++){
		d[cnt].dir=(d[cnt].dir+1)%4;
		dfs(cnt+1);
	}
}

````

##### 사다리조작

````c++
[실패]
void connect(int cnt,int idx){
	if(cnt>3) return; 
	check(cnt);
	for(int j=idx+1;j<=H;j++){ // (1) j의 시작
		for(int i=1;i<=N;i++){ // (2) i의 범위
			if(bridge[j][i-1] || bridge[j][i] || bridge[j][i+1]) continue;
			bridge[j][i]=1;
			connect(cnt+1,j);
			bridge[j][i]=0;		
		}
	}
}

+ 함수 변수를 cnt만 선언시 인덱스 조절이 안되어 시간초과

    
  1  2  3  4    
1 .--.  .  . 
2 .--.  .  .
3 .  .  .  . 
    
   j=idx+1일 경우에 가로선이 하나만 설치 된다.  
    
  1  2  3  4    
1 .--.  .--. 
2 .--.  .  .
3 .  .  .  .
    
    j=idx일 때 위와 같이 하나의 행에 두 개의 다리 설치 가능
    
[성공]
void connect(int cnt,int idx){
	if(cnt>3) return; 
	check(cnt);
	for(int j=idx;j<=H;j++){
		for(int i=1;i<N;i++){
			if(bridge[j][i-1] || bridge[j][i] || bridge[j][i+1]) continue;
			bridge[j][i]=1;
			connect(cnt+1,j);
			bridge[j][i]=0;		
		}
	}
}
````

##### 연구소3

```
- 문제에서 조건들을 정리하고, 하나씩 체킹하면서 코딩하자.
- EX) 활성 바이러스가 비활성 바이러스가 있는 칸으로 가면 비활성 바이러스가 활성으로 변한다.


반례
5 1
11111
11111
01010
11111
11111

출력
3
```

##### 낚시왕

```
+ 
상어가 이동하는 로직에서
backup배열이 필요하다.
이동한 상어의 위치가 현재 이동하지않은 상어의 위치로 올 수 있기 때문

만약 (1,1)의 상어가 (3,3)으로 이동했고, 이에 대한 정보를 backup배열 없이 갱신했다면
(3,3)은 이동하지 못하고 사라진다.
```

##### DSLR

```
1) DFS를 적용하기전에 탈출 조건문을 만들 수 있는지 확인하자.
2) 시간초과 
	pow -> 수식으로 변경하여 해결
3) 메모리초과
	visit배열로 중복제거하여 해결
```



# 실수

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



##### index

```c++
line3,line5 에서 y를 바꾸면, 뒤의 x값 변경시 오류 발생

int now_y=v[map[y][x]][0].first; int now_x=v[map[y][x]][0].second;
			if(now_y==y && now_x==x){
				y=v[map[y][x]][1].first; x=v[map[y][x]][1].second; -- line3
			}else{
				y=v[map[y][x]][0].first; x=v[map[y][x]][0].second; -- line5
			}
```

