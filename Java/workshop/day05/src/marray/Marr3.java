package marray;

import java.util.Random;

public class Marr3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 2���� �迭�� �̿��Ͽ� 5���� �л��� 4���� ������ 
		// ���� �Ͽ� ��� �Ͻÿ�
	
		
		int ma[][]=new int[4][4];
		
		Random r = new Random();
		
		for(int i=0;i<ma.length;i++) {
			for(int j=0;j<ma[i].length;j++) {
				ma[i][j]=r.nextInt(5)+1;
				System.out.print(ma[i][j]);
				
			}
			System.out.println();
		}
		
		// �л� �� ����� ����Ͻÿ�
		
		double savg=0.0;
		for(int temp[]:ma) {
			for(int data:temp) {
				int sum=0;
				sum += data;
				savg=(double)sum/ma.length;
			}
			System.out.println(savg);
		}
		
		// ���� �� ����� ����Ͻÿ�
		
		double cavg=0.0;
		for(int j=0;j<ma[0].length;j++) {
			int sum=0;
			for(int i=0;i<ma.length;i++) {
				sum +=ma[i][j];
			}
			cavg=(double)sum/(ma.length);
			System.out.println(cavg);
		}
		
		
		
		// ��ü ��� ���
		
		
		double savg1=0;
		int sum=0;
		for(int temp[]:ma) {
			for(int data:temp) {
				sum += data;
			}
		}
		savg1=(double)sum/(ma.length*ma.length);
		System.out.println(savg1);


	}
	
}
	
	
	

