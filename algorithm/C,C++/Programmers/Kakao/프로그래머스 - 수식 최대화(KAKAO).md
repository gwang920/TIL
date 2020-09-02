# 프로그래머스 - 수식 최대화

- 카테고리 : 완전탐색

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
```

# 실패

```c++
#include <string>
#include <vector>
#include <iostream>
#include <string.h>
using namespace std;
long long answer = 0;
int count=0;
string n;
string calc(char oper,string s1,string s2){
    string s="";
    long long new_s1=stol(s1);
    long long new_s2=stol(s2);
    if(oper=='-') s=to_string(new_s1-new_s2);
    if(oper=='*') s=to_string(new_s1*new_s2);
    if(oper=='+') s=to_string(new_s1+new_s2);
    return s;
}
int visit[4]={0,};

void game(string ex,int cnt){
    cout << ex << endl;
     if(cnt>count){
         string k="";
         if(ex[0]=='-') k=ex.substr(1);
         long long tmp=stol(k);
         if(answer<abs(tmp)){
             answer=abs(tmp);
         }
         return;
     }
    int tmp=visit[cnt];
    char oper;
    if(tmp==1) oper='+';
    if(tmp==2) oper='-';
    if(tmp==3) oper='*';    
    string s="";
    for(int i=0;i<ex.length();i++){
        if(ex[i]==oper){
            int start=0,end=0;
            for(int j=i-1;j>=0;j--){
                if(ex[j]=='-' || ex[j]=='+' || ex[j]=='*'){
                    start=j+1;
                    break;
                }
                if(j==0){
                    start=j;
                    break;
                }
            }
            for(int k=i+1;k<ex.length();k++){
                if(ex[k]=='-' || ex[k]=='+' || ex[k]=='*'){
                    end=k+1;
                    break;
                }
                if(k==ex.length()-1){
                    end=k;
                    break;
                }
            }
  s=ex.substr(0,start-1)+calc(oper,ex.substr(start,i-1),ex.substr(i+1,end-1))+ex.substr(i,ex.length()-1);
        }
    }
    game(s,cnt+1);
}

void set(int cnt){
    if(cnt==count){
        game(n,0);
        return;
    }
    
    for(int i=1;i<=3;i++){
        if(visit[cnt] || visit[cnt]==-1) continue;
        visit[cnt]=i;
        set(cnt+1);
        visit[cnt]=0;
    }
}


long long solution(string expression) {
    n=expression;
    memset(visit,-1,sizeof(visit));
    for(int i=0;i<expression.length();i++){
        if(expression[i]=='+') visit[1]=0;
        else if(expression[i]=='-') visit[2]=0;
        else if(expression[i]=='*') visit[3]=0;
    }
    for(int i=1;i<=3;i++){
        if(visit[i]==0) count++;
    }
    
    set(1);
    return answer;
}
```




# 성공

```c++
#include <string>
#include <vector>
#include <iostream>
#include <string.h>
using namespace std;
long long answer = 0;
string n;
string calc(char oper,string s1,string s2){
    string s="";
    long long new_s1=stoll(s1);
    long long new_s2=stoll(s2);
    if(oper=='-') s=to_string(new_s1-new_s2);
    if(oper=='*') s=to_string(new_s1*new_s2);
    if(oper=='+') s=to_string(new_s1+new_s2);
    return s;
}
int visit[4]={0,},check[4]={0,};
void game(string ex,int cnt){
     if(cnt==4){
         long long tmp=stoll(ex);
         if(answer<abs(tmp)){
             answer=abs(tmp);
         }
         return;
     }
    int tmp=visit[cnt];
    char oper;
    if(tmp==1) oper='+';
    if(tmp==2) oper='-';
    if(tmp==3) oper='*';    
    for(int i=0;i<ex.length();i++){
        if(ex[i]==oper){
            if(i==0) continue;
            if(ex[i-1]=='+' || ex[i-1]=='*' || ex[i-1]=='-') continue;
            int start,end;
            for(int j=i-1;j>=0;j--){
                if(ex[j]=='+' || ex[j]=='*'){
                    start=j+1; break;
                }
                if(j==0){
                    start=j; break;    
                }
                if(ex[j]=='-'){
                    if(j==0){
                        start=j; break;
                    }
                    if(ex[j-1]=='-' || ex[j-1]=='+' || ex[j-1]=='*'){
                        start=j; break;
                    }
                    start=j+1; break;
                }
            }
            for(int k=i+1;k<ex.length();k++){
                if(ex[k]=='+' || ex[k]=='*'){
                    end=k-1; break;
                }
                if(k==ex.length()-1){
                    end=k; break;
                }
                if(ex[k]=='-'){
                    if(k==i+1){
                        continue;
                    }else{
                        end=k-1; break;
                    }
                }
            }
            string tmp=calc(oper,ex.substr(start,i-start),ex.substr(i+1,end-i));
            ex=ex.substr(0,start)+tmp+ex.substr(end+1);
            game(ex,cnt);
            return;
        }
    }
  game(ex,cnt+1);
}

void set(int cnt){
    if(cnt==4){
        game(n,1);
        return;
    }
    
    for(int i=1;i<=3;i++){
        if(visit[cnt] || check[i]) continue;
        check[i]=1; visit[cnt]=i;
        set(cnt+1);
        check[i]=0; visit[cnt]=0;
    }
}

long long solution(string expression) {
    n=expression;
    set(1);
    return answer;
}
```

# 성공

```c++
#include <string>
#include <vector>
#include <iostream>
#include <math.h>
using namespace std;

int visit[3],ch[3];
long long answer = 0;
// 0 : + , 1 : 0 , 2 : * 
char oper(int idx){
    if(idx==0) return '+';
    if(idx==1) return '-';
    if(idx==2) return '*';
}

long opCalc(char op,long a,long b){
    long res=0;
    if(op=='*') res=a*b;
    if(op=='-') res=a-b;
    if(op=='+') res=a+b;
    return res;
}

bool checkOp(char a){
    if(a-'0'>=0 && a-'0'<=9) return false;
    return true;
}
bool isOper(string str){
    for(int i=1;i<str.length();i++){
        if(checkOp(str[i])) return false;
    }
    return true;
}

bool flag=false;
void expCalc(string str,int cnt){
    if(isOper(str)){
       answer=max(answer,abs(stoll(str)));
       return;
    }
    string newstr="";
    char op=oper(visit[cnt]);
    int idx=0;
    string num="";
    vector<long> number;
    vector<char> o;
    for(int i=0;i<str.length();i++){
        if(checkOp(str[i])){
            if(i==0 || checkOp(str[i-1])) num+=str[i];
            else{
                number.push_back(stol(num));
                o.push_back(str[i]);  
                num="";
            } 
        }else{
            num+=str[i];
        }
        if(i==str.length()-1){
            number.push_back(stol(num));
            break;
        }
    }
    
    vector<long> new_number;
    vector<char> new_o;
    bool flag=false;
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
    newstr=to_string(new_number[0]);
    for(int i=0;i<new_o.size();i++){
        newstr+=new_o[i];
        newstr+=to_string(new_number[i+1]);
    }
    expCalc(newstr,cnt+1);
}

void makeOp(int cnt,string str){
    if(cnt==3){
        expCalc(str,0);
        return;
    }
    
    for(int i=0;i<3;i++){
           if(visit[cnt] || ch[i]) continue;
           visit[cnt]=i; ch[i]=1;
           makeOp(cnt+1,str);
           ch[i]=0; visit[cnt]=0;
    }
}


long long solution(string expression) {
    makeOp(0,expression);
    return answer;
}
```

# 로직 최적화

```c++
#include <string>
#include <vector>
#include <iostream>
#include <math.h>
using namespace std;

int visit[3],ch[3];
long long answer = 0;
// 0 : + , 1 : 0 , 2 : * 
char oper(int idx){
    if(idx==0) return '+';
    if(idx==1) return '-';
    if(idx==2) return '*';
}

long opCalc(char op,long a,long b){
    long res=0;
    if(op=='*') res=a*b;
    if(op=='-') res=a-b;
    if(op=='+') res=a+b;
    return res;
}

bool checkOp(char a){
    if(a-'0'>=0 && a-'0'<=9) return false;
    return true;
}

pair<vector<long>,vector<char>> strToVector(string str){
    vector<long> number;
    vector<char> o;
    string num="";
    for(int i=0;i<str.length();i++){
        if(checkOp(str[i])){
            if(i==0 || checkOp(str[i-1])) num+=str[i];
            else{
                number.push_back(stol(num));
                o.push_back(str[i]);  
                num="";
            } 
        }else{
            num+=str[i];
        }
        if(i==str.length()-1){
            number.push_back(stol(num));
            break;
        }
    }
    return make_pair(number,o);
}

void expCalc(string str){
    auto vec=strToVector(str);
    vector<long> number;
    vector<char> o;
    number=vec.first;
    o=vec.second;
    
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
    
    if(answer<abs(number[0])) answer=abs(number[0]);
}

void makeOp(int cnt,string str){
    if(cnt==3){
        expCalc(str);
        return;
    }
    
    for(int i=0;i<3;i++){
        if(visit[cnt] || ch[i]) continue;
        visit[cnt]=i; ch[i]=1;
        makeOp(cnt+1,str);
        ch[i]=0; visit[cnt]=0;
    }
}

long long solution(string expression) {
    makeOp(0,expression);
    return answer;
}
```

