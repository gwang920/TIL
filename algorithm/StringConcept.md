# string 개념



```c++
#include <iostream>
#include <vector>
#include <string>

using namespace std;

int N;
int arr[49];


int main() {

	string a = "6";
	string b = "7";

	char a1;
	char b1;

	a1 = 6 + '0';
	cout << "a1 : " << a1 << "\n";
	b1 = 7 + '0';
	cout << "b1 : " << b1 << "\n";
	cout << a1 + b1 << "\n";

	string s1,s2,s3,s4,s5;

	s1 += a1;
	cout << "s1 : " << s1 << "\n";
	s2 = a1;
	cout << "s1 : " << s2 << "\n";
	s3 += b1;
	cout << "s2 : " << s3 << "\n";
	s4 = a1 + b1;
	cout << "s3 : " << s4 << "\n";
	s5 += (a1 + b1);
	cout << "s4 : " << s5 << "\n";

	string news;
	news += a1;
	news += b1;
	cout << "news : " << news;

	return 0;
}

결과
a1 : 6
b1 : 7
109
s1 : 6
s2 : 6
s3 : 7
s4 : m
s5 : m
news : 67

      string 이나 char 형은 각각 한 값씩 string 연산을 하지 않으면
	  두 개 이상일 때 숫자로 계산된 값이 넣어지게 된다. 
    
결론 : '+' 로 string 을 만들 때 한 값씩 + 연산을 해주자.

```

