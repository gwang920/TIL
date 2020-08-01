package shape;


public class User {
	String id;
	public User() {
		id = "Kim";
	}
	//인스턴스메소드
	public void draw(Shape shape) {//한가지 타입의 참조변수로 여러 타입으로 구현할 수 있다.
		System.out.println(shape.getArea());
		System.out.println(shape.getCircume());
		System.out.println(shape.getPoint());
		
	}
	
	 
	
	//추상클래스 객체 생성 x      하위클래스 생성가능 
	//Shape s= T ,R ,C    다형성 폴리모피즘  == 의미는 같지만 표현되는 방식이 다르다 
	// EX) 그래픽카드 슬롯 s 그래픽카드 T R C 
}
