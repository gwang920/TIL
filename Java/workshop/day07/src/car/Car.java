package car;

public class Car {
	// attribute
	private String name;
	private String color;
	private int fSize;
	private int cfSize;
	private int speed;
	private int maxSpeed;
	private int defaultSize=100;
	private static int serial = 1;
	private static int count = 1;
	// initialization block    보통 많이 사용 x why? constructor 에서 하면 되니까
	{
		cfSize=defaultSize*2;
		if(cfSize<=0) {
			cfSize=0;
		}
		cfSize++;   //인스턴스변수  생성될때마다 변한다 의미?
		
		count++;
		serial=count;
	}
	static {
		
		serial *= 1000;  //클래스변수
		count +=1000;
	}
	
	// constructor
	public Car() {//설정안해주면 default 로 설정 됨 cfsize=0;     인스턴트 설정 
		this.name = "K1";
		this.color = "red";
		this.fSize = 50;	
		this.maxSpeed = 50;
	}

	public Car(String name, String color, int fSize) {  //overload => (argument) 를 설정함으로써 중복을 피함
		this.name = name;
		this.color = color;
		this.fSize = fSize;
	}
	
	public Car(String name, String color, int fSize, int maxSpeed) {
		this.name = name;
		this.color = color;
		this.fSize = fSize;
		this.maxSpeed = maxSpeed;
	}

	public Car(String name, String color, int fSize, int cfSize, int speed) { // overload
		this.name = name;
		this.color = color;
		this.fSize = fSize;
		this.cfSize = cfSize;
		this.speed = speed;
	}

	// function
	
	@Override
	public String toString() {   //string 형태의 return
		return "Car [name=" + name + ", color=" + color + ", fSize=" + fSize + ", cfSize=" + cfSize + ", speed=" + speed
				+ "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getfSize() {
		return fSize;
	}

	public void setfSize(int fSize) {
		this.fSize = fSize;
	}

	public int getCfSize() {
		return cfSize;
	}

	public void setCfSize(int cfSize) 
			throws Exception {  // 캡슐화 장점 오류 데이터가 들어가는 것을 막는다
		if((this.cfSize + cfSize)>fSize) {  // this.cfSize 현재 기름의 사이즈 ?
			throw new Exception();
			//			return;        // 여기까지만 코드 진행된다
		}
		this.cfSize += cfSize;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		if(this.maxSpeed < speed) {
			this.speed=this.maxSpeed;
			return;
		}
		this.speed = speed;
	}
	
	//set get 안쓰더라도 만들어 놓자(?)
	
	public void go(int level) {  //level에 맞춰 출발해라    
		// level 1~5
		// speed up 1:10km
		// fuel down 1L 10km
		switch(level) {
		case 1:
			this.setSpeed(20);   // 캡슐화
			this.cfSize -=1;
			break;
		case 2:
			this.setSpeed(40);
			this.cfSize -=2;
			break;
		case 3:
			this.setSpeed(60);
			this.cfSize -=3;
			break;
		case 4:
			this.setSpeed(80);
			this.cfSize -=4;
			break;
		case 5:
			this.setSpeed(100);
			this.cfSize -=5;
			break;
		default:
			break;
		}
	}
	public void stop() {
		this.speed =0;
	}	
}