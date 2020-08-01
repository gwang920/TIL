package marray;

import java.util.Random;

public class Marr3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 2차원 배열을 이용하여 5명의 학생의 4과목 점수를 
		// 생성 하여 출력 하시오
	
		
		int ma[][]=new int[4][4];
		
		Random r = new Random();
		
		for(int i=0;i<ma.length;i++) {
			for(int j=0;j<ma[i].length;j++) {
				ma[i][j]=r.nextInt(5)+1;
				System.out.print(ma[i][j]);
				
			}
			System.out.println();
		}
		
		// 학생 별 평균을 출력하시오
		
		double savg=0.0;
		for(int temp[]:ma) {
			for(int data:temp) {
				int sum=0;
				sum += data;
				savg=(double)sum/ma.length;
			}
			System.out.println(savg);
		}
		
		// 과목 별 평균을 출력하시오
		
		double cavg=0.0;
		for(int j=0;j<ma[0].length;j++) {
			int sum=0;
			for(int i=0;i<ma.length;i++) {
				sum +=ma[i][j];
			}
			cavg=(double)sum/(ma.length);
			System.out.println(cavg);
		}
		
		
		
		// 전체 평균 출력
		
		
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
	
	
	

