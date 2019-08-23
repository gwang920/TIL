# 프로그래머스 단어 변환

- 카테고리 : DFS / BFS
- 구상은 어렵지 않았는데 , 코드 구현에 오류가 너무 많았다...
- 디버깅에 속도가 점점 붙는 느낌이 든다.. !
- 코드를 한 번 더 정리하자



# 실패

```c++

int dfs(int i,int bgcount){
    cout << bgcount;

  if(new_target==backup[i]){
      cout << bgcount;
      return bgcount;
  } 
   for(int j=0;j<backup.size()-1;j++){
        if(i==j || visited[j]) continue;
        if(check(i,j)){
            visited[i]=1;
            bgcount++;
            dfs(j,bgcount);                       
        }
    }   
}

이 코드의 문제점은 int 형인 dfs의 반환 값이 모두 지정 되지 않는 점이다.
꼬리물기로 dfs()->dfs()->... 로 그려질텐데

if문의 조건에 만족해야만 return을 해준다.
결국 if 문에 해당되지 않는 dfs()들은 return이 되지 않는다....!
    
    
    +
    
    
    성공 코드의 주석문을 잘보자 (오류 코드)
    
```



# 성공

```c++
#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<string> backup;
string new_target;
int n;
int flag=0;
int visited[50]={0,};
int num=0;

bool check(int words_i,int words_j){
    int count=0;
    string a=backup[words_i];
    string b=backup[words_j];
    for(int i=0;i<n;i++){        
        if(a[i]!=b[i]){
            count++;
        }        
    }
    if(count==1){   
        return true;
    }
    return false;
}

// call by value
void dfs(int i,int bgcount,vector<int> &v){
  if(new_target==backup[i]){
      cout << bgcount;
      num=bgcount;
      return;
  } 
    
   for(int j=0;j<backup.size()-1;j++){
        if(i==j || v[j]) continue;
        if(check(i,j)){
            v[i]=1;
          //count++;
            dfs(j,bgcount+1,v);  
        }
    }   
}

int solution(string begin, string target, vector<string> words) {
    new_target=target;
    n=words[0].length();
    backup=words;
    backup.push_back(begin);
    vector<int> v;
    int min=9999;
    
   // 반환 가능 여부 판단
    for(int i=0;i<words.size();i++){
        v.push_back(0);
        if(words[i]==target){
            flag=1;
        }
    }
    if(!flag) return 0;   
    
    // 순차적으로 탐색
    for(int i=0;i<words.size();i++){
      //  if(words[i]==target) continue;
          if(check(i,backup.size()-1)==true){
            dfs(i,1,v);
            if(min>num){
            min=num;
            }
        }
   }   
    cout << min;
    return min;
}
```

