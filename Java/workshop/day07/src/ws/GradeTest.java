package ws;

import java.util.Arrays;
import java.util.Scanner;


public class GradeTest {

	public static void main(String[] args) {
		int a[]=new int[4];
		System.out.println("������ �Է��Ͻÿ� : (����,����,����,����)");
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<a.length;i++) {
			a[i]=sc.nextInt();
		}
		
		Grade g=new Grade();
		
		System.out.println("��="+g.sum(a));
		System.out.println("���="+g.avg(a));
		System.out.println("���="+g.grade(a));
		System.out.println("MAXsub="+g.Max(a));
		System.out.println("MINsub="+g.Min(a));
		System.out.println("�������� "+Arrays.toString(g.asc(a)));
		System.out.println("�������� "+Arrays.toString(g.dsc(a)));
		
	}

}
