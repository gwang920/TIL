# 프로그래머스 - 후보키(KAKAO)

- 카테고리 : 완전탐색

```
'맞왜틀 무한반복 무한디버깅'했던 문제다.

1) index순으로 완전탐색하더라도 오류가 생긴다.
   완전탐색을 하면서 모든 경우를 검증했다.
   이때, 후보키를 만족하면 해당 케이스는 return 시켜주면 충분히 답이 도출된다고 생각했다.
   하지만, 오류가 발생한다. 완전탐색의 특성상 깊이를 먼저 탐색하기에 최소성을 만족하지 않는 조합이 먼저 발	생할 수 있다.
ex) [0,1,2]가 후보키를 만족해 먼저 들어왔더라도 [1,2]가 후보키를 만족하므로 [0,1,2]는 후보키가 아니게 된다.

2) 1)번의 오류를 하나의 함수에 넣었다.
  즉, 유일성을 만족하는 조합을 vector에 저장하면서 최소성인지 아닌지 판단하는 로직을 함께 짰다.
  오류가생긴다.

3) 1) + 2) 번의 오류를 전부잡아줬다.

 일단 완전탐색으로 유일성을 만족하는 조합을 전부 저장한 후 
 최소성을 만족하지 않는 경우를 모두 제거했다.
```



# 실패 #1

```c++
#include <string>
#include <vector>
#include <iostream>
using namespace std;
vector<vector<string>> r;
vector<vector<int>> comb;
int answer = 0;
bool check(vector<int> stor){
    for(int i=0;i<r.size()-1;i++){
         string s;
        for(int j=0;j<stor.size();j++){
            s+=r[i][stor[j]];
        }
        for(int k=i+1;k<r.size();k++){
            string s1;
            for(int l=0;l<stor.size();l++){
                s1+=r[k][stor[l]];
            }
            if(s==s1) return false;
        }   
    }
    
     return true;
}

void dfs(int idx,int cnt,vector<int> stor){
    if(cnt>r[0].size()) return;
    if(!stor.empty()){
        if(check(stor)) return;
    }
    for(int i=idx;i<r[0].size();i++){
        stor.push_back(i);
        dfs(i+1,cnt+1,stor);
        stor.pop_back();
    }
}

int solution(vector<vector<string>> relation) {
    r=relation;
    vector<int> a;
    dfs(0,0,a);
    return comb.size();
}
```



# 실패 #2

```c++
#include <string>
#include <vector>
#include <iostream>
using namespace std;
vector<vector<string>> r;
vector<vector<int>> comb;
int answer = 0;
bool check(vector<int> stor){
    for(int i=0;i<r.size()-1;i++){
         string s;
        for(int j=0;j<stor.size();j++){
            s+=r[i][stor[j]];
        }
        for(int k=i+1;k<r.size();k++){
            string s1;
            for(int l=0;l<stor.size();l++){
                s1+=r[k][stor[l]];
            }
            if(s==s1) return false;
        }   
    }
    int cnt=0;
   
    bool flag=true;
    for(int i=0;i<comb.size();i++){
        bool visit[9]={0,};
        cnt=0;
        for(int j=0;j<comb[i].size();j++){
            for(int k=0;k<stor.size();k++){
               if(comb[i][j]==stor[k]){
                   if(visit[stor[k]]) continue;
                     visit[stor[k]]=1;
                    cnt++; break;                
                }  
            }
        }
 
        if(cnt==stor.size() && comb[i].size()>stor.size()){
            comb.erase(comb.begin()+i);
           // flag=true;
        }
        else if(cnt && comb[i].size()<stor.size()){
            flag=false;
            return true;
        }
        
    }
     if(flag) comb.push_back(stor);
     return true;
}

void dfs(int idx,int cnt,vector<int> stor){
    if(cnt>r[0].size()) return;
    if(!stor.empty()){
        if(check(stor)) return;
    }
    for(int i=idx;i<r[0].size();i++){
        stor.push_back(i);
        dfs(i+1,cnt+1,stor);
        stor.pop_back();
    }
}

int solution(vector<vector<string>> relation) {
    r=relation;
    vector<int> a;
    dfs(0,0,a);
    return comb.size();
}
```





# 성공

```c++
#include <string>
#include <vector>
#include <iostream>
using namespace std;
vector<vector<string>> r;
vector<vector<int>> comb;
int answer = 0;
int visit[1001]={0,};
void remove(){
    int cnt=0;
    for(int i=0;i<comb.size()-1;i++){
        for(int j=i+1;j<comb.size();j++){
            cnt=0;
            for(int k=0;k<comb[i].size();k++){
                for(int l=0;l<comb[j].size();l++){
                    if(comb[i][k]==comb[j][l]){
                        cnt++;
                    }
                }
                if(cnt==comb[j].size() && comb[i].size()>comb[j].size()){
                            visit[i]=1;
            }else if(cnt==comb[i].size() && comb[i].size()<comb[j].size()){
                            visit[j]=1;
                }
            }
        }
    }    
    answer=comb.size();
    for(int i=0;i<1000;i++){
        if(visit[i]) answer--;
    }
}

bool check(vector<int> stor){
    for(int i=0;i<r.size()-1;i++){
         string s;
        for(int j=0;j<stor.size();j++){
            s+=r[i][stor[j]];
        }
        for(int k=i+1;k<r.size();k++){
            string s1;
            for(int l=0;l<stor.size();l++){
                s1+=r[k][stor[l]];
            }
            if(s==s1) return false;
        }   
    }
    comb.push_back(stor);
    return true;
    
}

void dfs(int idx,int cnt,vector<int> stor){
    if(cnt>r[0].size()) return;
    if(!stor.empty()){
        if(check(stor)) return;
    }
    for(int i=idx;i<r[0].size();i++){
        stor.push_back(i);
        dfs(i+1,cnt+1,stor);
        stor.pop_back();
    }
}

int solution(vector<vector<string>> relation) {
    r=relation;
    vector<int> a;
    dfs(0,0,a);
    remove();
   
    return answer;
}
```

