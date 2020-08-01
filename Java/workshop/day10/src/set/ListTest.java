package set;

import java.util.ArrayList;
import java.util.Random;

public class ListTest {

	public static void main(String[] args) {
		ArrayList<Integer> list = 
				new ArrayList<>();
		Random r = new Random();
		
		while(true) {
			list.add(r.nextInt(45)+1);
			if(list.size()==10) {
				break;
			}
		}
		for(Integer i:list) {  // type 변수 : 배열
			System.out.println(i);
		}

		System.out.println(list.toString());  // 
	}
	
	

}
