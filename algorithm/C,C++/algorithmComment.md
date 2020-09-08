##### 1. map 컨테이너 iterator

```c++
for(auto it=map.begin(); it!=map.end(); ++it) {
       string key=it->first;
       string value=it->second;
       cout << key << ' ' << value;
   }
```

##### 2. 2차원 배열의 원소가 문자열 일 때 

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

##### 3. vector 초기화(크기 및 값 지정)

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

##### 4.트러블 슈팅 **signal: floating point exception (core dumped)**

```
나누기 할시 변수/0꼴이 있으면 발생
```



##### 5. 배열 최대크기

```
[20001] x [20001]
```



##### 6. int 형 범위 초기화

```c++
int answer = 0x7f7f7f7f;
```





##### 7. 플로이드 와샬 알고리즘

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



##### 8. priority_queue

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



##### 9. queue VS stack

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



##### 10. 자료형 크기

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

// long long -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
// int -2,147,483,648~ 2,147,483,647
// overflow 범위를 초과하는 것
```



##### 11. 배열 초기화 ( 전역 / 지역)

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



##### 12. string -> int

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



##### 13. rotate (90 도 회전)

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

##### 14. 재귀 return 

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

##### 15. 조합 속도

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

##### 16. 16 진수 -> 10진수 / 16진수 ->2진수

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
    
    
16진수 표기법
[Decimal Hexadecimal Binary]
    
[0 0 0000] [8 8 1000]
[1 1 0001] [9 9 1001]
[2 2 0010] [10 a 1010]
[3 3 0011] [11 b 1011]
[4 4 0100] [12 c 1100]
[5 5 0101] [13 d 1101]
[6 6 0110] [14 e 1110]
[7 7 0111] [15 f 1111]   
```

##### 17. HEADER : climits

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

##### 18. 우선순위큐 오름차순(struct)

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



##### 19. 비트마스킹기법

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

##### 20. 반올림 (자릿수)

```c++
#include <iostream>
using namespace std;
double round( double num, int d )
{
	return (floor((num) * pow(float(10), d) + 0.5f) / pow(float(10), d));
}


int main(){
    double num=3.955;
    cout << round(num,2);  // (숫자,자릿수(자릿수 -1 자리에서 반올림한뒤 자릿수 까지만 표기))
    pirntf("%.2f",num);  // ".자릿수f,변수명" => 자릿수 -1 자리 반올림후 자릿수 까지만 표기
	return 0;
}

[출력]
3.96
3.96
```





# KAKAO

##### 방금그곡

# 방금그곡 - 프로그래머스



```C++
무한 디버깅했던 문제다.
    
아래 풀이법 이외에도 C# => c , A# => a와 같이 하나의 문자로 대체해 풀이할 수 도 있다.

```

## 고려하지 못한 조건

## #1

```c++
C#,D# 은 하나의 문자이다.
    
실행시간이 2, 악보는 "AC#"일 때 
실행시간동안의 음악의 총 악보는 "AC"가 아닌 "AC#"이다.

=> 아래 함수를 만들어 해결
    
-----------------------------------------------------------------------------------------
int calcLength(string s){
    int lg=s.length();
    for(int i=0;i<s.length();i++){
        if(s[i]=='#') lg--;
    }
    return lg;
}

-----------------------------------------------------------------------------------------
```

## #2

```c++
음악의 총 악보가 "BA#BA" 이고, 네오가 기억한 멜로디가 "BA"라 할때
    
-----------------------------------------------------------------------------------------
[1]
int idx=new_sco.find(m);
if(new_sco[idx+m.length()]=='#') continue;
if(diff_time>maxtime){
	maxtime=diff_time;
	answer=m_name;
}

-----------------------------------------------------------------------------------------
위와 같이 처리하면 문제가 생긴다.
    
find는 문자열의 첫 인덱스부터 진행되기때문에 "BA#"을 찾고 continue 해버린다.
따라서, while(new_sco[idx+m.length()]=='#') 반복문을 활용해 '#'을 찾지 못할 때까지 반복해줘야한다.
    
=> 위 [1]코드를 아래와 같이 변경해 해결
    
-----------------------------------------------------------------------------------------
[2]
int idx=new_sco.find(m);
while(idx<new_sco.length() && new_sco[idx+m.length()]=='#'){
            idx=new_sco.find(m,idx+1);
        }
        if(idx>new_sco.length()) continue;
        if(new_sco[idx+m.length()]!='#'){
            if(diff_time>maxtime){
                maxtime=diff_time;
                answer=m_name;
            }
        }

-----------------------------------------------------------------------------------------
```

## #3

```c++
음악 길이보다 재생된 시간이 짧을 때는 처음부터 재생 시간만큼만 재생된다.

    위 조건을 고려할 때도 A# , C#을 하나의 문자로 처리해야한다.

-----------------------------------------------------------------------------------------
[1]
if(recur>=1){
          while(recur--) new_sco+=sco;
          if(rem){ 
            new_sco+=sco;
          }
        }else{
            new_sco=sco.substr(0,rem);
        } 

-----------------------------------------------------------------------------------------

 => 위 [1]코드를 아래와 같이 변경해 해결
-----------------------------------------------------------------------------------------
[2]
    
if(recur>=1){
          while(recur--) new_sco+=sco;
          if(rem){ 
            new_sco+=sco;
          }
        }else{
            int cnt=0;
            string s="";
            for(int i=0;i<sco.length();i++){
                if(sco[i]!='#') cnt++;
                if(cnt>diff_time) break;
                s+=sco[i];
            }
            new_sco=s;
        } 
-----------------------------------------------------------------------------------------
```



# 성공

```c++
#include <string>
#include <vector>
#include <iostream>
using namespace std;
string answer = "(None)";

int searchIdx(string str){
    for(int i=0;i<str.length();i++){
        if(str[i]==',') return i;
    }
}

int calcTime(string s){
    string h=s.substr(0,2);
    string m=s.substr(3);
    int tmp=stoi(h)*60+stoi(m);
    return tmp;
}

int calcLength(string s){
    int lg=s.length();
    for(int i=0;i<s.length();i++){
        if(s[i]=='#') lg--;
    }
    return lg;
}

void game(string m,vector<string> mus){
    int maxtime=0;
    for(int i=0;i<mus.size();i++){
        string s_time=mus[i].substr(0,5);
        string e_time=mus[i].substr(6,5);
        int tmp=13+searchIdx(mus[i].substr(12));
        string m_name=mus[i].substr(12,tmp-13);
        string sco=mus[i].substr(tmp);
        
        int e=calcTime(e_time),s=calcTime(s_time);
        int diff_time=e-s;
        int length=calcLength(sco);
        int recur=diff_time/length;
        int rem=diff_time%length;
        string new_sco="";        
        if(recur>=1){
          while(recur--) new_sco+=sco;
          if(rem){ 
            new_sco+=sco;
          }
        }else{
            int cnt=0;
            string s="";
            for(int i=0;i<sco.length();i++){
                if(sco[i]!='#') cnt++;
                if(cnt>diff_time) break;
                s+=sco[i];
            }
            new_sco=s;
        } 
        int idx=new_sco.find(m);
        
        while(idx<new_sco.length() && new_sco[idx+m.length()]=='#'){
            idx=new_sco.find(m,idx+1);
        }
        if(idx>new_sco.length()) continue;
        if(new_sco[idx+m.length()]!='#'){
            if(diff_time>maxtime){
                maxtime=diff_time;
                answer=m_name;
            }
        }
    }
}
string solution(string m, vector<string> musicinfos) {
    game(m,musicinfos);
    return answer;
}
```



##### 추석트래픽( 부동소수점 비교 )

```
if(a+0.999>b) => 실패
if(a+1-b>0.001) => 성공

부동소수점을 비교할 때는 기준값(위에서 0.001)을 세워두고
비교하는 두 값의 차를 구해 등호연산하자!
```



##### 문자열 압축( substr exception 처리)

```c++
# exception 처리

​```c++
오류메시지 : C++ exception with description "basic_string::substr: __pos (which is 18) > this->size() (which is 17)" thrown in the test body.


substr 범위가 벗어나 오류가 발생한다.
    
    
    아래 주석을 풀어주고
    string b="";
 	바꿔주면 성공!
-----------------------------------------------------------------------------------------

#include <string>
#include <vector>
#include <iostream>
#include <math.h>
using namespace std;

int answer = 987654321;

void comp(string s,int cnt){
    if(s.length()==1){
        answer=1;
        return;
    }
    if(cnt>s.length()/2) return;
    string str="";
    int compCnt=1;
    for(int i=0;i<s.length();i+=cnt){
        string a=s.substr(i,cnt);
        string b=s.substr(i+cnt,cnt);
     //   if(i+cnt<s.length()) b=s.substr(i+cnt,cnt);
        if(a!=b){
            if(compCnt==1) str+=a;
            else str+=to_string(compCnt)+a;
            compCnt=1;
        }
        else if(a==b){
            compCnt++;
        }
    }
    if(answer>str.length()) answer=str.length();
    comp(s,cnt+1);
}


int solution(string s) {
    comp(s,1);
    return answer;
}
​```
```



##### 기둥과 보설치

```
1)
실패 - > 삭제 조건을 정확하게 전부 구하기 쉽지 않다.
2)
성공 -> 일단 삭제를 한 뒤, 조건에 맞나 확인하는 작업으로 변경했다.
 => 간단한 방법을 생각해내자..!
```

##### 수식 최대화

```c++
풀이과정
    
1) 연산자의 우선순위를 백트래킹으로 구해준다.
    visit 배열을 이용해
    visit[cnt]=i로 두고
    이때 cnt는 순서, i는 연산자를 나타내는 수가 된다 (i==1 이면 '-' , i==2 이면 '+' i==3 이면 '*')

2) cnt(=순서)대로 수식을 계산한다
    2)-1 
    -----------------------------------------------------------------------
    1. 만일 cnt==1 이면 '-' 연산자에 해당하는 작은 수식을 모두 계산해주어야한다.
    따라서, 재귀함수로 이를 구현했다.
    ex) 전체 수식이 123-456*432-125 이라면
    ex=(123-456)*432-125을 구한뒤
    :ex=-333*432-125
    cnt는 유지한채로 재귀함수를 탐색한다
    game(ex,cnt);
    -----------------------------------------------------------------------
    2. cnt에 해당하는 연산자가 모두 계산이 되었다면 
    game(ex,cnt+1)로 그 다음 우선순위 연산자로 넘어간다.
     -----------------------------------------------------------------------    
    * 이때 주의할점은 '-' 연산자이다.
      '-'는 연산자이기도 하지만 동시에 음수를 나타낼 수 있다.
        그렇기에 '-' 연산자의 바로 앞에 또 다른 연산자(-,+,*)가 온다면
        이 '-' 연산자는 음수를 나타내는 것으로 인식하고 재귀함수를 진행한다.
        
        ex) 123*-234
        이때 oper는 *, s1은 123,s2는 -234가 된다.
        
     -----------------------------------------------------------------------
    2)-2 
    calc 함수를 구현해 작은 수식을 계산해준다.
    calc(oper,s1,s2) => return s1 (oper) s2
    				s1 - s2 / s1 + s2 / s1 * s2

    

많은 오류를 범했던 문제..

1) stoll,stoi,stol 등 string을 int,long 형을 바꿔주는 함수에서
공백을 변환하려 하면 signal: segmentation fault (core dumped) 오류가 발생한다.
    
2) 우선순위 중복체크를 안하면 다음 step으로 넘어가더라도 모든 연산자가 계산되지 않을 수 있다.
    
    why? 중복체크를 안하면 visit 배열이
    visit[1]=1; visit[2]=1; visit[3]=1;
	이 될 수 있어 '-' 연산자만 계산 된다.

3) set 함수에서 cnt==3 일 때 계산하면 안된다!
        
        
        
        +
        
        
수식최적화
----------------------------------------------------------------------------------------
1) 계산된 결과값 or 계산되지 않는 결과값을 새로운 벡터에 담는다.
    ex) 현재 우선순위 연산자를 '-'라 할 때
        1+2-3-4*5
        
        새로운 벡터 1+-1-7*5
        가 담기게 된다.
        즉,

        1) 연속적으로 계산 operator가 나올 경우 갱신된 결과값에 계산을 할 수 없다.
        
        2) index를 쫓으면서 컨트롤하다보니 복잡해진다.(벡터에서 => 새로운 벡터로 이동)
        => 디버깅을 통해 실행결과값을 확인하지 않고서는 모든 조건을 파악하기 쉽지 않다.
        => 초기설계로 통과할 확률이 현저히 작아진다.

for(int i=0;i<o.size();i++){
        if(o[i]==op){
            if(flag){
                long long temp=new_number[new_number.size()-1];
                new_number.erase(new_number.end()-1);
                new_number.push_back(opCalc(op,temp,number[i+1]));
                continue;
            }
            flag=true;
            new_number.push_back(opCalc(op,number[i],number[i+1]));
        }else{
            if(flag){
                flag=false;
            }else{
                new_number.push_back(number[i]);
            }
            if(i==o.size()-1) new_number.push_back(number[i+1]);
            new_o.push_back(o[i]);
        }
    }
  
----------------------------------------------------------------------------------------- 2) 계산된 결과값을 바로 현재 벡터에 갱신해준다.
    
    ex) 1+2-3-4*5
    
    마찬가지로 현재 우선순위 연산자를 '-'라 할 때
    v[0]=1;
	v[1]=-1;
	v[1]=-4;
	v[2]=5;

	가 된다.

for(int i=0;i<3;i++){
        char op=oper(visit[i]);
        for(int j=0;j<o.size();j++){
             if(o[j]==op){
                 number[j]=opCalc(op,number[j],number[j+1]);
                 number.erase(number.begin()+j+1);
                 o.erase(o.begin()+j);
                 j--;
             }
        }
    }

-----------------------------------------------------------------------------------------
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

##### 괄호 추가하기

````c++
단순하게 생각하자

#include <iostream>

using namespace std;
int N,res=-987654321;
string s;

int calc(int a,int b,char oper){
	int result=a;
	switch(oper){
		case '+':result+=b; break;
		case '-':result-=b; break;
		case '*':result*=b; break;
	}
	return result;
}

void game(int idx,int cur){
	if(idx>N-1){
		res=max(res,cur); return;
	}
	char oper=(idx==0)?'+':s[idx-1];
	int next=calc(s[idx]-'0',s[idx+2]-'0',s[idx+1]);
	game(idx+2,calc(cur,s[idx]-'0',oper));
	game(idx+4,calc(cur,next,oper));
}

int main(){
	cin >> N;
	cin >> s;
	game(0,0);
	cout << res << "\n";
	return 0;
}
````



##### 아기상어

```c++
거리를 구할 때
dist=abs(ny-y)+abs(nx-x);
로 두면
아기상어는 자신보다 큰 물고기가 있는 칸을 지나지 못한다는
조건을 위배한다.
따라서, 경로를 추적해야한다.
=> visit[ny][nx]=visit[y][x]+1;
```



##### 테트로미노

````
단순 bfs를 사용하면 visit때문에 시작점에서 모든 모양을 탐색할 수 없다.
백트래킹을 사용하자.

1)
@ @
@ @
2)
@ @ @ @
3)
@
@ @
  @
4)
@
@
@ @
````



##### 나무재테크

```
시간초과..!
=> 큐를 전부 비우고 다시 채우는 것보다 조건을 만족하지 않는 요소만 제거하면
시간복잡도가 개선된다.
vector+sort로 우선순위큐의 기능을 구현할 수 있다.
```



##### 이차원 배열과 연산

```c++
우선순위큐에서 2개의 변수의 우선순위를 설정하고자 할 때
음수를 적극 활용하자

y,x;
-y,-x;

를 적절히 석으면

priority_queue<pair<int,int>> pq; 에서

(내림차순,내림차순) (내림차순,오름차순) (오름차순,내림차순) (오름차순,오름차순)

정렬이 가능하다.
```



##### 2048

````c++
1) rotate를 매번 갱신한 값을 저장해야한다.
    
void game(int cnt){
	if(cnt==5){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(res<map[i][j]) res=map[i][j];
			}
		}
		return;
	}
	int board[21][21];
	memcpy(board,map,sizeof(map));
	for(int i=0;i<4;i++){
		move();sum();move();
		game(cnt+1);	
		memcpy(map,board,sizeof(map));
		rotate();
		memcpy(board,map,sizeof(map));  // 이 코드가 없으면 rotate가 1회전만 한다.
	}
}

2) 배열을 함수의 매개변수로 넘기면 참조하기 쉽지 않다.
    vector로 넘기면 값이 넘어간다. 배열은 주소값이 전달된다.
    
* 참고
https://github.com/gwang920/TIL/blob/master/algorithm/C%2CC%2B%2B/Baekjoon/%EB%B0%B1%EC%A4%80%2012100%20-%202048.md
````



##### 원판돌리기

````c++
1) 초기에 원판 원소의 합(sum)과 개수(cnt)를 먼저 구해 조건을 만족하는 경우 

sum-=circle[i][j]; cnt--;
의 방식을 사용할 시 반례는 다 맞는데 왜 틀리는지 모르겠다.

매번 sum과 cnt 를 세어 계산하니 맞다. 희안하다.

2) 소수점 비교시 형변환이 필요하다

double avg=(double)sum/(double)cnt;
if((double)circle[i][j]>avg)
````



##### 스티커 붙이기

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


시간초과 조심하자
[시간초과]
void game(int cnt){
	if(cnt>3 || cnt>=res) return;
	if(check()){
		res=min(res,cnt);
		return;
	}
	for(int i=1;i<=H;i++){
		for(int j=1;j<N;j++){
			if(cnt>=res) return;
			if(map[i][j] || map[i][j-1] || map[i][j+1]) continue;
			map[i][j]=1;
			game(cnt+1);
			map[i][j]=0;
		}
	}
}

[통과]
void game(int cnt,int idx){
	if(cnt>3 || cnt>=res) return;
	if(check()){
		res=min(res,cnt);
		return;
	}
	for(int i=idx;i<=H;i++){
		for(int j=1;j<N;j++){
			if(cnt>=res) return;
			if(map[i][j] || map[i][j-1] || map[i][j+1]) continue;
			map[i][j]=1;
			game(cnt+1,i);
			map[i][j]=0;
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

##### 치킨 배달

```c++
거리를 구하는 문제에서 두 좌표가 모두 주어진다면
vector에 넣어 쉽게 계산할 수 있다.(굳이 bfs로 탐색하지 않아도 된다)

vector<pair<int,int>> house,chicken;

for(int i=0;i<house.size();i++){
	for(int j=0;j<chicken.size();j++){
		dist=abs(house[i].first-chicken[j].first)+abs(house[i].second-chicken[j].second);
	}
}

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
			if(now_y==y && now_x==x)
            {
				y=v[map[y][x]][1].first; x=v[map[y][x]][1].second; -- line3
			}else
            {
				y=v[map[y][x]][0].first; x=v[map[y][x]][0].second; -- line5
			}
```

```
stirng to *char
string str[20];
const char* c=str[i];

string을 *char로 변환하려면
const를 붙여줘야한다.
```
