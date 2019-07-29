package ws;

import java.util.Date;

public class Car {
    private String serial;
    private String name;
    private String color;
    private Engine engine;
    
    public int cnt=0;
 
    public Car(String name, String color, Engine engine) {		
    	// Ŭ������� ��ġ�ؾ��Ѵ� ?
    	Date date = new Date();
    		
		int year = date.getYear();
		int month = date.getMonth();
		int day = date.getDate();
		int hour = date.getHours();
		int minute = date.getMinutes();
		int second = date.getSeconds();
    	
    	this.serial =  "" +(year + 1900) + (month + 1) + day + hour + minute + second + (1000 + cnt);
    	// String �� int ������ ��Ÿ����  : "" + int;
        
    	this.name = name;
        this.color = color;
        this.engine = engine;
        cnt++;
    }
 
    @Override
    public String toString() {
        return "Car [serial=" + serial + ", name=" + name + ", color=" + color + ", engine=" + engine + "]";
    }
    
}