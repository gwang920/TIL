package ws2;
 
import java.util.Random;
import java.util.Scanner;
 
public class Game1 {
 
    public static void main(String[] args) {
        
        char[][] map = new char[9][9];
        Scanner sc= new Scanner(System.in);
       
        char a= 'a';
        char A= 'A';// 65, 66, 67, 68, 69
        
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
            
            map[j][i] = randomCharGen();
            
            }
        }
 
        printMap(map);
        
        int count =20;
        int score = 0;
        
        //play
        while(true) {
            
            if(count==0) {
                System.out.println("����");
                break;
            }
            
            if(score ==20) {
                System.out.println("����");
                break;
            }
        
        
            
        System.out.println("�ٲ� ��� �Է� �Է� (x ���� �Է� y)");
        int x1 = sc.nextInt();
        int y1= sc.nextInt();
        
        System.out.println("�̿��� ��� ��ǥ �Է� (x ���� �Է� y)");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        
        if((Math.abs(x1-x2)+Math.abs(y1-y2)) != 1) {
            System.out.println("���� ������ �迭�� �Է��ϼ���");
            continue;
        
        }
        
        
        // change
        char temp = map[x1-1][y1-1];
        
        map[x1-1][y1-1] = map[x2-1][y2-1];
        map[x2-1][y2-1] = temp;
        
        score += scoreCount(map);
        
        System.out.println();
        printMap(map);
        
        
        count--;
        }
   
    }
    
    public static int scoreCount(char[][] map) {
        
        int tScore =0;
        
        //�������� ���Դµ� �� �������� �ִ� ��?
        for(int i=0; i<9; i++) {    
            
            int p=1;
            int temp =0;
            while(true)
            {
                if(p<8) {
                    
                    //3���� ���� ��
                    if(map[p-1][i] == map[p][i] &&
                       map[p][i] == map[p+1][i]) {
                        tScore++;
                        
                        map[p-1][i] = randomCharGen();
                        map[p][i] = randomCharGen();
                        map[p+1][i] = randomCharGen();
                        
                        p =0;
                        temp++;
                    }
                }
                
                if(p>=9 && temp ==0)
                    break;
                
                p++;
                temp =0;
                
                
            }
        }
        return tScore;
    }
    
    public static void printMap(char[][] map) {
        
        System.out.println();
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                
                System.out.print(map[j][i]+" ");
            }
            System.out.println();
        }
        
    }
    
    public static char randomCharGen() {
        Random r = new Random();
        
        int number =r.nextInt(5)+1;        
        
        switch(number) {
        case 1: return 'A';
        
        case 2: return 'B';
        
        case 3: return 'C';
        
        case 4: return 'D';
        
        case 5: return 'E';
        
        default : break;
        }
        return 'F';
    }
}