package shape;

public class ShapeTest {

	public static void main(String[] args) {
		//Shape s = new Shape(new Point(10,10));
		// Heterogeneous Collection
		Shape s[] = new Shape[3];
		s[0] = new Circle(new Point(1,1),5);
		s[1] = new Triangle(new Point(2,2),5,6);
		s[2] = new Rectangle(new Point(3,3),5,6);
		// Polymorphism
		for(Shape sh:s) {
			sh.move(5, 5);
			if(sh instanceof Circle) {  //sh가 Circle 이면
				Circle c = (Circle)sh;     //바꿔라
				c.fillColor("red");        //sh.fillcolor (x)  c에만 선언 된 함수 이기에
			}
			System.out.println(sh.toString());
			//System.out.println(sh.getArea());
			//System.out.println(sh.getCircume());
		}
		
	}

}





