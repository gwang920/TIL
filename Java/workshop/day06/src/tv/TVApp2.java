package tv;

public class TVApp2 {

	public static void main(String[] args) {
		TV tv = new TV();  //default
		System.out.println(tv.toString());
		TV tv2 = new TV("blue",false,9);
		System.out.println(tv2.toString());
		TV tv3 = new TV("green");
		System.out.println(tv3.toString());
		tv3.setColor("");
		System.out.println(tv3.getColor());
//		tv3.color = "yellow"; ���� invisible
		// private ����Ұ��� encapsulation ���
		
	}

}
