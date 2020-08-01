package set;

import java.util.HashSet;
import java.util.Random;
public class SetTest {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		Random r = new Random();
		
		while(true) {
			set.add(r.nextInt(45)+1);
			if(set.size()==6) {
				break;
			}
		}
//		set.add(1);
//		set.add(2);
//		set.add(1);
//		set.add(4);
//		set.add(1);
//		set.add(6); // 중복 허용 x
		System.out.println(set.toString());  
	}

}
