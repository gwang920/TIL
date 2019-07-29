package ws;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
 
public class BingGo {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // �������
        // 1. ���� ������ �Է�
        // 2. �������� ���� ���� ����� ���� ���� 1~100 �ߺ� x
        // 3. 1~100������ ���� �Է�
        // 4. ���ڸ� �Է� �޾Ƽ� �Է� ���� ���� �ִ� ���� 0���� ����
        // 5. ���ڸ� �Է� �޾Ҵµ� �� ���ڰ� ������ ��.
        // 6. ���� �Ǹ� ǥ��
        
        System.out.println("���� ����� �Է��Ͻÿ�.(2~10)> ");
        Scanner size = new Scanner(System.in);
        String n = size.nextLine();
        
        int mapsize = Integer.parseInt(n);
        int map[][] = new int[mapsize][mapsize];
        Random r = new Random();
        boolean[] check = new boolean[100];
        for(boolean t : check) {
            t = true;
        }
        int temp;
        //�� �Է�(���� ����)
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map.length; j++) {
                temp = r.nextInt(100);
                while(check[temp]) {
                    temp = r.nextInt(100);
                }
                map[i][j] = temp+1;
                check[temp] = true;
            }
        }
        
        Map<Integer, Rot> mapPosition = makeMapPosition(map);
        temp = -1;
        int val;
        int index = 1;
        //���� ����
        while(true) {
            System.out.println("���� ���ڸ� �Է��ϼ���(���� -> 0):");
            val = size.nextInt(); 
            if(val ==0 ) break;
            changeNum(map, val, mapPosition);
            temp = checkHorizionalBingGo(map);
            if(temp != -1) {
                printBingGO(map, false, temp, index);
                index++;
            }
            
            temp = checkVerticalBingGo(map);
            if(temp != -1) {
                printBingGO(map, true, temp, index);
                index++;
            }
            
            printMap(map);
        }
        System.out.println("���� ����");
        
    }
     public static void changeNum(int map[][], int targetNum, Map<Integer, Rot> mapPosition) {
            Rot numPosition = mapPosition.get(targetNum);
            
            if (numPosition == null) {
                return;
            }
            
            int sero = numPosition.sero;
            int garo = numPosition.garo;
            
            map[sero][garo] = 0;
        }
        
        public static Map<Integer, Rot> makeMapPosition(int map[][]) {
            Map<Integer, Rot> mapPosition = new HashMap<Integer, Rot>();
            
            for (int i = 0 ; i < map.length ; i++) {
                for (int j = 0 ; j < map[i].length ; j++) {
                    Rot numPosition = new Rot(i, j);
                    int number = map[i][j];
                    
                    mapPosition.put(number, numPosition);
                }
            }
            
            return mapPosition;
        }
    static void printBingGO(int[][] map,boolean vertical,int Mapindex,int index) {
        if(vertical) {
            for(int i=0;i<map.length;i++) {
                map[i][Mapindex] = -1;
            }
        }
        else {
            for(int i=0;i<map.length;i++) {
                map[Mapindex][i] = -1;
            }
        }
    }
    static int checkVerticalBingGo(int[][] map) {
        boolean check;
        for(int i=0;i<map.length;i++) {
            check = true;
            for(int j=0;j<map.length;j++) {
                if(map[j][i] > 0) check = false;
            }
            if(check) return i;
        }
        return -1;
    }
    
    static int checkHorizionalBingGo(int[][] map) {
        boolean check;
        for(int i=0;i<map.length;i++) {
            check = true;
            for(int j=0;j<map.length;j++) {
                if(map[i][j] > 0) check = false;
            }
            if(check) return i;
        }
        return -1;
    }
    static void printMap(int[][] map) {
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map.length; j++) {
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }   
    }
}
class Rot {
    int sero;
    int garo;
    
    Rot(int sero, int garo) {
        this.sero = sero;
        this.garo = garo;
    }
}
 