package ws;

public class CarTest {
	
	public static void main(String[] args) {
		
		Engine engine1 = new Engine(3000,"4");
		Car car1 = new Car("���������","red",engine1);
		
		Engine engine2 = new Engine(4000,"6");
		Car car2 = new Car("�������ι�","white",engine2);
		
		System.out.println(car1.toString());
		System.out.println(car2.toString());
		
	}

}
