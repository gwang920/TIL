package ws;

public class ExCarTest {

	public static void main(String[] args) {
		
		Exengine engine = new Exengine(5000,5);
		ExCar car1= new ExCar("���������","black",engine);
		
		
		System.out.println(car1.toString());
		

	}

}
