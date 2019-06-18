# 프로그래머스 기능개발

```
  #include <stdio.h>
  #include <vector>
  
  
  using namespace std;
  
  vector<int> progresses;
   vector<int> speeds;
  vector<int> answer;
  
  
  int main(void){
  	
  	int x,y;
  	int n; 
  	scanf("%d",&n);
  	for(int i=0;i<n;i++){
  		
  		scanf("%d %d",&x,&y);
  		
  		progresses.push_back(x);
  		speeds.push_back(y);
  		
	  }
	  
  	 int a[100]={};
    
    for(int i=0;i<progresses.size();i++){
        
        while(1){
            if(progresses[i]>=100){
            
            break;
        }
            
            progresses[i]+=speeds[i];
            a[i]+=1;
        }
        
    }
    

    int check=progresses.size();
    int check1;
    int visited[100];
    for(int i=0;i<progresses.size();i++){
       
        int count=1;
        check1=0;
        
        for(int j=i+1;j<progresses.size();j++){
            
            if(a[i]>=a[j]){
             
                visited[j]=1;
                check1+=a[j];
                if(check1>a[i]) {
                            break;}
                count++;
            }
        }
        check-=count;
        
        answer.push_back(count);
        
        if(check==0) break;
    }
    for(int i=0;i<progresses.size();i++){
    		    printf("%d ",answer[i]);
	}

  }
  
 
```

