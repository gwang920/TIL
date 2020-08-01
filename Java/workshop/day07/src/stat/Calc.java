package stat;

public class Calc {
	public static int sum(int a, int b) {
		return (a+b);
	}//static을 쓰고 안쓰고 차이 느껴보자
	
	
	//argument가 다르면 함수 이름 같이할 수 있다 ==오버로드
	public static int sum(int a[]) {
		int sum=0;
		for(int data : a) {
			sum+=data;
		}
		
		return sum;
	}
}
