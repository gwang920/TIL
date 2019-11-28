# 프로그래머스 멀쩡한 사각형

- 카테고리 : 수학적 개념 적용 + 규칙찾기
- 1) 'gcd(최대공약수)' 찾아 적용은 했다.
- 2) '반복 최소 단위 사각형에서 사용할 수 없는 사각형의 갯수' 규칙을 못찾아 아래 사이트 참고
- => (가로길이 + 세로길이 -1 ) 가 사용할 수 없는 사각형의 갯수가 된다는 간단한 규칙이었다.
- 참고 <https://greenapple16.tistory.com/89>



##### W, H가 1억 이하의 자연수이기 때문에 연산 시 자료형 범위 초과에 유의



# 성공

```c++
using namespace std;

long long solution(int w, int h)
{
	int gcd;
	long long sum = (long long)w * (long long)h;
	
	for (int i = (w < h) ? w : h; i > 0; i--) { //최대 공약수 구하기
		if ((w % i == 0) && (h % i == 0)) { 
			gcd = i;
			break;
		}
	}
	return sum - gcd * ((w / gcd) + (h / gcd) - 1);
}
```



