package ref;

public class Ref {
	int a;
	
	public void sum(int data) {
		data +=1000;                //�Լ��� ����Ǹ� �ڵ������� ����
	}
	public void sum2(Ref ref) {
		ref.a+=1000;
	}

}
