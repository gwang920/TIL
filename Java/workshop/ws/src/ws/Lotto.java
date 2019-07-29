package ws;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
//		1. 6���� ���� �Է� (���� : 1~10)
//		2. �� ���� ��÷��ȣ 6�� ���� (���� : 1~10) �ߺ����� �ʴ� ���� ����
//		3. ��÷�� ����  (����: 10��~100��)
//		4. �Է� ���� ���ڿ� ��÷��ȣ Ȯ��
//		- 3�� ������ : 4�� (��÷�� 5%)
//		- 4�� ������ : 3�� (��÷�� 10%)
//		- 5�� ������ : 2�� (��÷�� 20%)
//		- 6�� ������ : 1�� (��÷�� 50%)
//		5. ��� ���
		System.out.println("6���� ��ȣ�� �Է��Ͻÿ�.(1~10)> ");
		Scanner my_num = new Scanner(System.in); 
		Random r = new Random();
		
		int my_num_a[] = new int[6];
		int lo_num_a[] = new int[6];
		// �� ��ȣ �Է� (1~10)
		for(int i=0; i<my_num_a.length; i++) {
			String n = my_num.next();
			my_num_a[i] = Integer.parseInt(n);
		}
		// �ζ� ��÷��ȣ ���� (1~10). �ߺ� x
		for(int i=0; i<lo_num_a.length; i++) {
			lo_num_a[i] = r.nextInt(10)+1;
			for(int j=0; j<i; j++) {
				if(lo_num_a[i] == lo_num_a[j]) {
					i--;
					break;
				}
			}
		}
		// ��÷�� ���� (10��~100��)		
		float mon = (long)((r.nextInt(10)+1)*1000000000) + (long)(r.nextInt(1000000000)+1);
		float m = Math.abs(mon);
		// ��÷��ȣ�� �Է¹�ȣ ��
		int count = 0;
		for (int i=0; i<my_num_a.length; i++) {
			for (int j=0; j<lo_num_a.length; j++) {
				if(my_num_a[i] == lo_num_a[j]) {
					count++;
				}
			}
		}
		// ��� ����, ��÷�� ����
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
		System.out.printf("�� ��ȣ\t: ");
		for(int i=0; i<my_num_a.length;i++) {
			System.out.printf("%d\t", my_num_a[i]);
		}
		System.out.println();
		System.out.printf("��÷ ��ȣ\t: ");
		for(int i=0; i<lo_num_a.length;i++) {
			System.out.printf("%d\t", lo_num_a[i]);
		}
		System.out.println();
		System.out.printf("���\t: "+grade+"�� �Դϴ�.\n");
		System.out.printf("�� ��÷��\t: "+m2+"�� �Դϴ�.\n");
		System.out.printf("�� ��÷��\t: "+my_m2+"�� �Դϴ�.\n");
	}
}