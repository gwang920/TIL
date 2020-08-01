package ws4;

import shape.Circle;
import shape.Point;
import shape.Rectangle;
import shape.Shape;
import shape.Triangle;

public class ShapeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Shape s[] = new Shape[3];
		s[0] = new Circle(new Point(1,1),5);
		s[1] = new Triangle(new Point(2,2),5,6);
		s[2] = new Rectangle(new Point(3,3),5,6);
		
		for(Shape sh:s) {
			sh.move(5,5);
			if(sh instanceof Circle) {
				Circle c= (Circle)sh;
				
			}
		}
	
	}

}
