# 프로그래머스 타겟넘버

카테고리 : DFS/BFS

- 재귀함수 사용시에 전역변수/지역변수의 역할에 대해 공부할 수 있었다
- DFS를 이용한 가장 간단하며 개념을 잡을 수 있는 문제

```c++
#include <string>
#include <vector>

using namespace std;

// 재귀 함수 사용 시 전역변수로 선언시 초기값을 해당 값으로 지정해주기
// vector<int> numbers;
// int target; 으로 선언하면
// target=0 ,vector의 크기는 0이 된다
vector<int> numbers_copy;
int target_copy=0;
int answer;

void dfs(int number, int depth,int sum){
    sum+=number;
    depth++;
    if(numbers_copy.size()==depth){
        
        if(sum==target_copy){
            answer++;
        }
        return;
    }

    else{
         dfs(numbers_copy[depth],depth,sum);
        dfs((-1)*numbers_copy[depth],depth,sum);
    }
}

int solution(vector<int> numbers, int target) {
    //int answer; 변수명이 같으면 return시에 가장 가까운놈을 return한다
    numbers_copy=numbers;
    target_copy=target;
    
    dfs(numbers[0],0,0);
    dfs((-1)*numbers[0],0,0);
    return answer;
}
```

