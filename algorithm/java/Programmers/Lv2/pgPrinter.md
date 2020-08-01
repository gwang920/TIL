# 프로그래머스 - 프린터

- 카테고리 : 스택/큐
- java는 모든 경우의 수를 컴파일한다.
- 메소드 maxreturn 에서 if 이외일 때에도 return 값을 지정해주어야함.



# 성공

```c++
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
           ArrayList<Integer> List=new ArrayList<>();
        for(int i=0;i<priorities.length;i++){
            List.add(priorities[i]);
        }
        
        int max=Collections.max(List);
        int idx=maxreturn(max,List);
        
        while(true){
            
            for(int i=0;i<priorities.length;i++){
                if(max==priorities[i]){
                    answer++;
                    if(i==location){
                        return answer;
                        }
                    List.set(idx,0);
                    max=Collections.max(List);
                    idx=maxreturn(max,List);
                }
            }
        }
    }
 public static int maxreturn(int tmp,ArrayList<Integer> List){
            for(int i=0;i<List.size();i++){
             if(tmp==List.get(i)){
                   return i;
             }
    }
     return 0;
}    
}

```

