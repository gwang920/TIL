# 프로그래머스 가장 큰 수

- 구상도 잘 되지않고 구현도 어려웠던 문제
- 다른 코드를 참고하여 풀이



##### replace 

```c++
기본문자열.replace(start_index,end_index,교체할 문자열)

string a="abc";
string b="def";
    
a.replace(a.length(),a.length()+b.length(),b);

결과
abcdef
```



##### to_string

```
int to string
- int 형을 string형으로 바꾸어준다

int a=123;
to_string(a);

```



##### 구상 - 1

1) 맨 앞자리가 큰 순서대로 배열을 정렬

​	1-1) 앞자리수가 같다면 같은수 처리를 분기하자

```
1 4 3 29 55 99

정렬

99 55 29 4 3 1

if) 앞자리수가 같다면 ,, 
 
 1 4 43 42 49 9 23
 9 (4 43 42 49) 23 1
 
 괄호를 어떻게 정렬하고, 괄호 다음에 오는 수와 조합되어도 우선순위가 바뀌기 않는지
 고려하기에는 너무 복잡하다
 
 구상 + 구현이 어려워 아래 코드를 참고했다
```



##### 구상 - 2

##### sort / bool cmp

- cmp는 항상 const / & 포함되어야 한다

```c++
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
bool cmp(const string &a, const string &b) {
	return a + b > b + a ? true : false;
}
    // strArr[0]
// 3 30 34 5 9
// 34 30 3 5 9
// 34 30 5 3 9
// 34 30 5 9 3
    // strArr[1]
// 34 30 3 5 9
// 34 3 30 5 9
// 34 3 5 30 9
// 34 3 5 9 30
    // strArr[2]
// 34 30 3 5 9
// 34 3 30 5 9
// 34 5 30 3 9
// 34 5 30 9 3
    // strArr[3]
// 9 5 30 34 3
// ... 변화 x
    // strArr[4]
// 9 5 30 34 3
// 9 5 30 34 3 
// 9 5 3 34 30
// 9 5 34 3 30

string solution(vector<int> numbers) {
	string answer = "";
	vector<string> strArr;
  // 문자열로 바꾸어 strArr 에 저장
	for (int i = 0; i < numbers.size(); i++) {
		strArr.push_back(to_string(numbers.at(i)));
        //number.at(i) == numbers[i]
	}
  
  // 조건대로 sort 정렬하자
  
	sort(strArr.begin(),strArr.end(),cmp);
	for (string str : strArr) {
		answer += str;
	}
  
  // string,, 
  // string answer="";
  // answer+="abc"
  // answer+="def"
  // answer[0] : abc
  // answer[1] " def
  
	if (answer[0] == '0')
		return "0";
	return answer;
}
```

