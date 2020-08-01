package ws;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex0517 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	System.out.println("6개의 번호를 입력하시오.(1~10)> ");
	Scanner my_num = new Scanner(System.in);
	Random r = new Random();
	
	int my_num_a[]=new int[6];
	int lo_num_a[]=new int[6];
	
	for(int i=0;i<my_num_a.length;i++) {
		String n=my_num.next();
		my_num_a[i] = Integer.parseInt(n);
		
	}
	
	for(int i=0;i<lo_num_a.length;i++) {
		lo_num_a[i] = r.nextInt(10)+1;
		for(int j=0;j<i;j++) {
			if(lo_num_a[i]==lo_num_a[j]) {
				i--;
				break;
			}
		}
	}

	
	}

}
