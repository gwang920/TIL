package shape;


public class User {
	String id;
	public User() {
		id = "Kim";
	}
	//�ν��Ͻ��޼ҵ�
	public void draw(Shape shape) {//�Ѱ��� Ÿ���� ���������� ���� Ÿ������ ������ �� �ִ�.
		System.out.println(shape.getArea());
		System.out.println(shape.getCircume());
		System.out.println(shape.getPoint());
		
	}
	
	 
	
	//�߻�Ŭ���� ��ü ���� x      ����Ŭ���� �������� 
	//Shape s= T ,R ,C    ������ ����������  == �ǹ̴� ������ ǥ���Ǵ� ����� �ٸ��� 
	// EX) �׷���ī�� ���� s �׷���ī�� T R C 
}
