package ws;

import java.util.Arrays;
import java.util.Scanner;


public class GradeTest {

	public static void main(String[] args) {
		int a[]=new int[4];
		System.out.println("점수를 입력하시오 : (국어,영어,수학,과학)");
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<a.length;i++) {
			a[i]=sc.nextInt();
		}
		
		Grade g=new Grade();
		
		System.out.println("합="+g.sum(a));
		System.out.println("평균="+g.avg(a));
		System.out.println("등급="+g.grade(a));
		System.out.println("MAXsub="+g.Max(a));
		System.out.println("MINsub="+g.Min(a));
		System.out.println("오름차순 "+Arrays.toString(g.asc(a)));
		System.out.println("내림차순 "+Arrays.toString(g.dsc(a)));
		
	}

}
