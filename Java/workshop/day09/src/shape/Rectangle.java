package shape;

public class Rectangle extends Shape {
	private int width;
	private int height;
	
		
	public Rectangle() {
	}

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point point, int width, int height) {
		super(point);
		this.width = width;
		this.height = height;
	}
	

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Rectangle [point=" + point + ", width=" + width + ", height=" + height + "]";
	}

	@Override
	public double getArea() {
		double result = 0.0;
		result = this.width*this.height;
		return result;
	}

	@Override
	public double getCircume() {
		double result = 0.0;
		result = (this.width+this.height) *2;
		return result;
	}

}
