# 프로그래머스 스킬트리





- | `skill` | `skill_trees`                     |
  | ------- | --------------------------------- |
  | "CBD"   | ["BACDE", "CBADF", "AECB", "BDA"] |

### 첫번째 방식 (실패)

1) skill의 각 문자에 대한 숫자값 (A=65,B=66,...)을 인덱스로 만들고, check[인덱스]=1 로 만든다.

2) skill_trees의 배열을 첫 원소배열부터 탐색하면서 check[인덱스]=0 즉, skill에 없는 문자는 무시해준다.

3) 그 다음 skill 의 배열 구조와 skill_trees의 배열구조를 순차적으로 비교한다.

(여기서 skill_check[20]은 중복체크 방지 위함)

- 예를들어, CBD와 CBADF를 비교하자면
- skill[0]==skill_trees[0] 이므로 통과 (+ skill_check[0]=1)
- skill[1]==skill_trees[1] 이므로 통과 (+ skill_check[1]=1)
- skill_trees[2] 인 'A'는 skill에 없으므로 무시
- skill[2]==skill_trees[3] 이므로 통과 (+ skill_check[2]=1)
- skill_check 이 전부 체크되었으므로 answer++ 해준다



 #### 문제 = > skill_trees의 배열에 skill의 원소가 들어있지 않을 수 있다



### 두번째 방식 (성공)

1) 첫번째 방식과 마찬가지로 skill과 skill_trees의 각 원소의 공통 알파벳만 추출하여 String s를 만든다.

2) go(skill,s) 함수를 통해 String의 길이만큼 비교해나간다. ( skill길이 >= s길이가 항상 성립 )

3) skill==substr(s,s.length()) 이면 answer++ 해주고, 바로 return한다.



# 실패

```c++
#include <string>
#include <vector>
#include <stdio.h>
using namespace std;

int skill_check[20]={0,};
void reset(){
    for(int i=0;i<20;i++){
        skill_check[i]=0;
    }
}

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    int check[100];
    bool flag=false;
    
    for(int i=0;i<skill.length();i++){
        int cnt=skill[i];
        check[cnt]=1;
    }
    
    for(int i=0;i<skill_trees.size();i++){
        reset();
        for(int j=0;j<skill_trees[i].length();j++){
            if(flag){
                flag=false;
                break;
            }
            int cnt=skill_trees[i][j];
            if(!check[cnt]) continue;
            else{
                for(int k=0;k<skill.length();k++){
                    
                    if(skill_check[k]) continue;
                    int skill_cnt=skill[k];
                    if(cnt!=skill_cnt){
                    answer++;
                    flag=true;
                    break;
                }else{
                        skill_check[k]=1;
                        break;
                    }      
                }
            }         
        }
    }
    
    return answer;
}
```







# 성공

```c++
#include <string>
#include <vector>


using namespace std;
int answer = 0;

void go(string skill,string s){
    for(int i=0;i<skill.length()-s.length()+1;i++){
        string check=skill.substr(i,s.length());  // substr(시작인덱스,길이) (O)
        //string check=skill.substr(i,s.length()-1); substr(시작인덱스,종료인덱스) (X)		 
       if(check==s) answer++; return;
    }
}

int solution(string skill, vector<string> skill_trees) {
    
    int check[100]={0,};
    for(int i=0;i<skill.length();i++){
        int index=skill[i];
        check[index]=1;
    }
    
    for(int i=0;i<skill_trees.size();i++){
        string s="";
        for(int j=0;j<skill_trees[i].length();j++){
            int index=skill_trees[i][j];
            if(check[index]){
                s+=skill_trees[i][j];   
            }
        }
        go(skill,s);
    }
    return answer;
}
```

