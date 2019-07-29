package tv;

public class TVApp3 {

	public static void main(String[] args) {
		TV tvs[] =new TV[3];
		tvs[0] = new TV("red");
		tvs[1] = new TV("blue");
		tvs[2] = new TV("green");
		
		for(TV tv : tvs) {  // for( 배열에 들어가 있는 타입 : 배열)
			System.out.println(tv);
		}
	}
}