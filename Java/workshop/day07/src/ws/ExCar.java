package ws;

import java.util.Date;

public class ExCar {
	
	private String serial;
	private String name;
	private String color;
	private Exengine engine;
	
	public int cnt=0;
	
	public ExCar(String name,String color,Exengine engine2) {
		Date date = new Date();
		
		int year=date.getYear();
		int month=date.getMonth();
		int day=date.getDate();
		int hour=date.getHours();
		int minute=date.getMinutes();
		int second=date.getSeconds();
		
		
		this.serial= "" + (year + 1900) + (month + 1) + day + hour + minute+second + (1000+cnt);
		
		this.name=name;
		this.color=color;
		this.engine=engine2;
		
		cnt++;
	}

	@Override
	public String toString() {
		return "ExCar [serial=" + serial + ", name=" + name + ", color=" + color + ", engine=" + engine + "]";
	}

	
	

}
