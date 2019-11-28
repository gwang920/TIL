# 프로그래머스 스킬트리





- | `skill` | `skill_trees`                     |
  | ------- | --------------------------------- |
  | "CBD"   | ["BACDE", "CBADF", "AECB", "BDA"] |

첫번째 방식은

1) skill의 각 문자에 대한 숫자값 (A=65,B=66,...)을 인덱스로 만들고, check[인덱스]=1 로 만든다

2) skill_trees의 배열을 첫 원소배열부터 탐색하면서 check[인덱스]=0 즉, skill에 없는 문자는 무시해준다

3) 그 다음 skill 의 배열 구조와 skill_trees의 배열구조를 순차적으로 비교한다

(여기서 skill_check[20]은 중복체크 방지 위함)

- 예를들어, CBD와 CBADF를 비교하자면
- skill[0]==skill_trees[0] 이므로 통과 (+ skill_check[0]=1)
- skill[1]==skill_trees[1] 이므로 통과 (+ skill_check[1]=1)
- skill_trees[2] 인 'A'는 skill에 없으므로 무시
- skill[2]==skill_trees[3] 이므로 통과 (+ skill_check[2]=1)
- skill_check 이 전부 체크되었으므로 answer++ 해준다



 문제 = > skill_trees의 배열에 skill의 원소가 들어있지 않을 수 있다



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

