package ref;

public class RefTest {

	public static void main(String[] args) {
		Ref ref = new Ref();
		System.out.println(ref.a);
		ref.sum2(ref);                    // call by reference
		System.out.println(ref.a);

		
		int data = 100;                 // 새로운 변수 ,, Ref의 data와는 다른변수
		ref.sum(100);					// call by value
		System.out.println(data);
	}

}
