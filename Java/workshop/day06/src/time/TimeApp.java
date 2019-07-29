package time;


import java.util.Date;
import java.util.Random;
import java.util.Scanner;


public class TimeApp {

	public static void main(String[] args) {
		Time time;
		time = new Time();
		System.out.println(time.changeStandard());
		
		System.out.println("���糯¥ : " + time.getDate());
		
		System.out.println("����ð� : " + time.getTime());
		
		System.out.println("STOP - PUSH 'S'");
		Scanner sc= new Scanner(System.in);
		String butt=sc.next();
		if(butt.equals("S")) {   
			System.out.println(time.stopWatch());
		}
	}

	public static class Time {
		
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
	        case 9: return "����";
	        
	        case 10: return "��";
	        
	        case 3: return "�ٱ״ٵ�";
	        
	        case 2: return "���Ű";
	        
	        case 16: return "����";
	        
	        
	        default : return "standard";
	        }

		}

	}

}