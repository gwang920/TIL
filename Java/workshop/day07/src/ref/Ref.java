package ref;

public class Ref {
	int a;
	
	public void sum(int data) {
		data +=1000;                //함수가 종료되면 자동적으로 끝남
	}
	public void sum2(Ref ref) {
		ref.a+=1000;
	}

}
