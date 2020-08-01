package tv;

public class TV {
	// attribute(속성)
	
	private String color;
	private boolean power;
	private int channel;   // * public + int channel 자유롭게 접근가능
						 
	// constructor(초기화)
	TV(){
		color = "red";
		power = false;
		channel = 10;
	}
	TV(String color, boolean power, int channel){ //굳이 함수 이름을 바꾸지 않는다. argument만 다르면 에러가 없다
		this.color = color;
		this.power = power;
		this.channel = channel;
	}
	TV(String color){ 
		this.color = color;
		this.power = false;
		this.channel = 10;
	}
	
	// function
	
	public String getColor() {   //private 인자에 접근하기 위함
		return color;
	}
	public void setColor(String color) {
		// 숫자 못 들어오게 한다.
		// 컬러는 몇개로 정해서 동작 한다.
		if(color.equals("") || color == null) {
			return;  //아무것도 반환 X?
		}
		this.color = color;
	}
	
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	
	void power() {
		power =!power;
	}
	void channelUp() {
		channel++;
	}
	void channelDown() {
		channel--;
	}
	@Override
	public String toString() {
		return "TV [color=" + color + ", power=" + power + ", channel=" + channel + "]";
	}
	
}
