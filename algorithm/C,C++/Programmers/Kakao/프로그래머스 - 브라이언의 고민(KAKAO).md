# 프로그래머스 - 브라이언의 고민(KAKAO)



# 실패

```c++
#include <string>
#include <iostream>
#include <vector>
#include <string.h>
using namespace std;

vector<string> v;
int arr[1000][123]={0,};

bool blankCheck(string s){
    for(int i=0;i<s.length();i++){
        if(s[i]==' ') return false;
    }
    return true;
}
int letterCheck(char c){
    if(c>=97 && c<=122) return 1;
    if(c>=65 && c<=90) return 2;
}

bool levelCheck(int level){
    for(int i=0;i<level;i++){
        for(int j=0;j<v[level].size();j++){
            if(arr[i][v[level][j]]) return false;
        }
    }
    return true;
}

bool invalidCheck(){
    memset(arr,0,sizeof(arr));
    for(int i=0;i<v.size();i++){
        if(letterCheck(v[i][0])==1){
                if(letterCheck(v[i][1])==1) return false;
                if(v[i].length()>3){
                    for(int j=2;j<v[i].size()-1;j+=2){
                        if(v[i][0]==v[i][j]) return false;
                    }
                }
        }
        for(int j=0;j<v[i].size();j++){
            if(letterCheck(v[i][j])==1) arr[i][v[i][j]]=1;
        }
        if(i!=0){
            if(!levelCheck(i)) return false;  
        } 
    }
    return true;
}

void parseSentence(string s){
    // 소문자 97 - 122  => 1
    // 대문자 65 - 90   => 2
    string first="",second="";
    if(letterCheck(s[0])==1){
        if(s.length()<=3){
            v.push_back(s); return;
        }
        for(int i=1;i<s.length();i++){
            if(s[i]==s[0]){
                first=s.substr(0,i+1);
                second=s.substr(i+1);
                v.push_back(first);
                if(i!=s.length()-1) parseSentence(second);
                break;
            }
        }
    }
    
    if(letterCheck(s[0])==2){
        if(s.length()<=3){
            v.push_back(s); return;
        }
        if(letterCheck(s[1])==2){
            for(int i=0;i<s.length();i++){
                if(letterCheck(s[i])==1){
                    first=s.substr(0,i);
                    second=s.substr(i);
                    v.push_back(first);
                    parseSentence(second);
                    return;
                }
                if(i==s.length()-1) v.push_back(s);
            }
        }
        
        for(int i=2;i<s.length();i+=2){
            if(s[i-1]!=s[1]){
                first=s.substr(0,i-1);
                second=s.substr(i-1);
                v.push_back(first);
                if(i<=s.length()-1) parseSentence(second);
                break;
            }
            if(i==s.length()-1) v.push_back(s);
        }
    }
    // 규칙이 적용되지 않은 단어가 포함된 문장
}

string makeSentence(){
    string answer="";
     for(int i=0;i<v.size();i++){
        for(int j=0;j<v[i].size();j++){
            if(letterCheck(v[i][j])==2) answer+=v[i][j];
        }
        if(i!=v.size()-1) answer+=" ";
    }
    return answer;
}

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
string solution(string sentence) {
    if(!blankCheck(sentence)) return "invalid";
    parseSentence(sentence);
    for(int i=0;i<v.size();i++){
           cout << v[i] << endl;
    }
    if(!invalidCheck()) return "invalid";
    cout << makeSentence();
    return makeSentence();
}
```

