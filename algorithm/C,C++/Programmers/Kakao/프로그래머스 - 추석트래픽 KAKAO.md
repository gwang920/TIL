# 프로그래머스 - 추석트래픽 KAKAO

```
부동소수점 비교..
```



# 실패

```c++
#include <string>
#include <vector>
#include <iostream>

using namespace std;

string stArr[2000],endArr[2000];

string endTime(string s){
    for(int i=11;i<s.length();i++){
        if(s[i]==' '){
            return s.substr(11,i-11);
        }
    }
}

string executeTime(string s){
    for(int i=11;i<s.length();i++){
        if(s[i]==' '){
            return s.substr(i+1,s.length()-(i+2));
        }
    }
}

string makeString(int h,int m,int s,int ms){
    string str=to_string(h)+':'+to_string(m)+':'+to_string(s)+':'+to_string(ms);
    return str;
}
string startTime(string end,string exe){
    int h=stoi(end.substr(0,2));
    int m=stoi(end.substr(3,2));
    int s=stoi(end.substr(6,2));
    int ms=stoi(end.substr(9));
    int es,ems;
    
    for(int i=0;i<exe.length();i++){
        if(exe.length()==1){
           es=stoi(exe); break;
        }
        if(exe[i]=='.'){
            es=stoi(exe.substr(0,i));
            ems=stoi(exe.substr(i+1))-1;
            break;
        }
    }
    ms-=ems;
    if(ms>=0) return makeString(h,m,s,ms);
    else{
        ms+=999;
        s--;
        s-=es;
    }
    if(s>=0) return makeString(h,m,s,ms);
    else{
        s+=60;
        m--;
    }
    if(m>=0) return makeString(h,m,s,ms);
    else{
        m+=60;
        h-=1;
    }
    return makeString(h,m,s,ms);
}

int countTime(){
    return 0;
}

int solution(vector<string> lines) {
    int answer = 0;
    if(lines.size()==1) return 1;
    for(int i=0;i<lines.size();i++){
        string end=endTime(lines[i]);
        string exe=executeTime(lines[i]);
        string start=startTime(end,exe);
        stArr[i]=start; endArr[i]=end;
        answer=max(answer,countTime());
    }
    
    for(int i=0;i<lines.size();i++){
        cout << stArr[i] << " " << endArr[i] << endl;
    }
    
    return answer;
}
```

# 실패(테스트케이스 3번)

```c++
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<float> stArr,endArr;
double MinDelta=0.0001;

string endTime(string s){
    for(int i=11;i<s.length();i++){
        if(s[i]==' '){
            return s.substr(11,i-11);
        }
    }
}

string executeTime(string s){
    for(int i=11;i<s.length();i++){
        if(s[i]==' '){
            return s.substr(i+1,s.length()-(i+2));
        }
    }
}

float startTime(string end,string exe){
    float h=stof(end.substr(0,2))*3600;
    float m=stof(end.substr(3,2))*60;
    float s=stof(end.substr(6));
    float es=stof(exe);
    
    float time=h+m+s-es;
    return time;
}

int solution(vector<string> lines) {
    int answer = 0;
    if(lines.size()==1) return 1;
    for(int i=0;i<lines.size();i++){
        string end=endTime(lines[i]);
        string exe=executeTime(lines[i]);
        float start=startTime(end,exe);
        stArr.push_back(start); endArr.push_back(start+stof(exe));
    }
    
    sort(stArr.begin(),stArr.end());
    sort(endArr.begin(),endArr.end());
    
    for(int i=0;i<endArr.size();i++){
        int count=0;
        for(int j=i;j<stArr.size();j++){
            if(endArr[i]+0.999>stArr[j]){
                count++;
            }else{
                break;
            }
            answer=max(answer,count);
        }
    }
    return answer;
}
```



# 성공

```c++
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<float> stArr,endArr;
double MinDelta=0.0001;

string endTime(string s){
    for(int i=11;i<s.length();i++){
        if(s[i]==' '){
            return s.substr(11,i-11);
        }
    }
}

string executeTime(string s){
    for(int i=11;i<s.length();i++){
        if(s[i]==' '){
            return s.substr(i+1,s.length()-(i+2));
        }
    }
}

float startTime(string end,string exe){
    float h=stof(end.substr(0,2))*3600;
    float m=stof(end.substr(3,2))*60;
    float s=stof(end.substr(6));
    float es=stof(exe);
    
    float time=h+m+s-es;
    return time;
}

int solution(vector<string> lines) {
    int answer = 0;
    if(lines.size()==1) return 1;
    for(int i=0;i<lines.size();i++){
        string end=endTime(lines[i]);
        string exe=executeTime(lines[i]);
        float start=startTime(end,exe);
        stArr.push_back(start); endArr.push_back(start+stof(exe));
    }
    
    sort(stArr.begin(),stArr.end());
    sort(endArr.begin(),endArr.end());
    
    for(int i=0;i<endArr.size();i++){
        int count=0;
        for(int j=i;j<stArr.size();j++){
            if(endArr[i]+1-stArr[j]>0.001){
                count++;
            }else{
                break;
            }
            answer=max(answer,count);
        }
    }
    return answer;
}
```

