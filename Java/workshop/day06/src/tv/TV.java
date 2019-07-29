package tv;

public class TV {
	// attribute(�Ӽ�)
	
	private String color;
	private boolean power;
	private int channel;   // * public + int channel �����Ӱ� ���ٰ���
						 
	// constructor(�ʱ�ȭ)
	TV(){
		color = "red";
		power = false;
		channel = 10;
	}
	TV(String color, boolean power, int channel){ //���� �Լ� �̸��� �ٲ��� �ʴ´�. argument�� �ٸ��� ������ ����
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
	
	public String getColor() {   //private ���ڿ� �����ϱ� ����
		return color;
	}
	public void setColor(String color) {
		// ���� �� ������ �Ѵ�.
		// �÷��� ��� ���ؼ� ���� �Ѵ�.
		if(color.equals("") || color == null) {
			return;  //�ƹ��͵� ��ȯ X?
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
