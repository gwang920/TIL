# 프로그래머스 K번째수

```c++
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    
    
    for(int i=0;i<commands.size();i++){
        
        int num;
        vector<int> arr;
        
        for(int j=commands[i][0]-1;j<commands[i][1];j++){
        
            arr.push_back(array[j]);
        }
        
        sort(arr.begin(),arr.end());
        
        int sub=arr[commands[i][2]-1];
        answer.push_back(sub);
        
    }
    
    return answer;
}

```

