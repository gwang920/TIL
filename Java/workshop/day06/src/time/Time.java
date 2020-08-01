package time;

import java.util.Date;
import java.util.Random;

public class Time {
	
	// attribute
	
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int second;
	private int standard;
	long startTime;
	long endTime;
	Date date = new Date();
	
	// constructor
	
	@SuppressWarnings("deprecation")
	Time(){
		year = date.getYear();
		month = date.getMonth();
		day = date.getDate();
		hour = date.getHours();
		minute = date.getMinutes();
		second = date.getSeconds();
		standard = 9;
		
		startTime = System.currentTimeMillis();
	}
	
	// function
	
	public String getTime() {
		return  Integer.toString(hour)+ ":" +
				Integer.toString(minute)+ ":"+
				Integer.toString(second);
	
	}
	public String getDate() {
		return Integer.toString(year+1900) + "-" +
				Integer.toString(month+1) + "-" +
				Integer.toString(day);
	} //getYear =>replaced by Calendar.get(Calendar.YEAR) - 1900.
	  //getMonth =>with the value 0 representing January.
	public float stopWatch() {
		endTime = System.currentTimeMillis();
		return (float)(endTime-startTime)/1000;
	}
	public String changeStandard() {
		
		Random r=new Random();
		standard+=r.nextInt(24)+1;
		if(standard>24) {
			standard-=24;
		}
		
		switch(standard) {
        case 9: return "¼­¿ï";
        
        case 10: return "±¡";
        
        case 3: return "¹Ù±×´Ùµå";
        
        case 2: return "Çï½ÌÅ°";
        
        case 16: return "µµÄì";
        
        
        default : return "standard";
        }

	}

}
