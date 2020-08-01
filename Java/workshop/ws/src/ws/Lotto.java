package ws;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
//		1. 6개의 숫자 입력 (범위 : 1~10)
//		2. 그 날의 당첨번호 6개 생성 (범위 : 1~10) 중복되지 않는 숫자 생성
//		3. 당첨금 생성  (범위: 10억~100억)
//		4. 입력 받은 숫자와 당첨번호 확인
//		- 3개 맞으면 : 4등 (당첨금 5%)
//		- 4개 맞으면 : 3등 (당첨금 10%)
//		- 5개 맞으면 : 2등 (당첨금 20%)
//		- 6개 맞으면 : 1등 (당첨금 50%)
//		5. 결과 출력
		System.out.println("6개의 번호를 입력하시오.(1~10)> ");
		Scanner my_num = new Scanner(System.in); 
		Random r = new Random();
		
		int my_num_a[] = new int[6];
		int lo_num_a[] = new int[6];
		// 내 번호 입력 (1~10)
		for(int i=0; i<my_num_a.length; i++) {
			String n = my_num.next();
			my_num_a[i] = Integer.parseInt(n);
		}
		// 로또 당첨번호 생성 (1~10). 중복 x
		for(int i=0; i<lo_num_a.length; i++) {
			lo_num_a[i] = r.nextInt(10)+1;
			for(int j=0; j<i; j++) {
				if(lo_num_a[i] == lo_num_a[j]) {
					i--;
					break;
				}
			}
		}
		// 당첨금 생성 (10억~100억)		
		float mon = (long)((r.nextInt(10)+1)*1000000000) + (long)(r.nextInt(1000000000)+1);
		float m = Math.abs(mon);
		// 당첨번호와 입력번호 비교
		int count = 0;
		for (int i=0; i<my_num_a.length; i++) {
			for (int j=0; j<lo_num_a.length; j++) {
				if(my_num_a[i] == lo_num_a[j]) {
					count++;
				}
			}
		}
		// 등수 저장, 당첨금 저장
		int grade = 0;
		float my_m = 0;
		if (count == 3) {
			grade = 4;
			my_m = (int)(m*0.05);
		}else if(count == 4) {
			grade = 3;
			my_m = (int)(m*0.1);
		}else if(count == 5) {
			grade = 2;
			my_m = (int)(m*0.2);
		}else if(count == 6) {
			grade = 1;
			my_m = (int)(m*0.5);
		}else {
			
		}
		
		String m2 = String.format("%,3.0f", m);
		String my_m2 = String.format("%,3.0f", my_m);
		System.out.printf("내 번호\t: ");
		for(int i=0; i<my_num_a.length;i++) {
			System.out.printf("%d\t", my_num_a[i]);
		}
		System.out.println();
		System.out.printf("당첨 번호\t: ");
		for(int i=0; i<lo_num_a.length;i++) {
			System.out.printf("%d\t", lo_num_a[i]);
		}
		System.out.println();
		System.out.printf("등수\t: "+grade+"등 입니다.\n");
		System.out.printf("총 당첨금\t: "+m2+"원 입니다.\n");
		System.out.printf("내 당첨금\t: "+my_m2+"원 입니다.\n");
	}
}