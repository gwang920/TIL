package ws;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
 
public class BingGo {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 빙고게임
        // 1. 빙고 사이즈 입력
        // 2. 정방형의 빙고 판을 만들기 랜덤 숫자 1~100 중복 x
        // 3. 1~100까지의 숫자 입력
        // 4. 숫자를 입력 받아서 입력 받은 값이 있는 곳은 0으로 변경
        // 5. 숫자를 입력 받았는데 그 숫자가 없으면 꽝.
        // 6. 빙고가 되면 표시
        
        System.out.println("빙고 사이즈를 입력하시오.(2~10)> ");
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
        //판 입력(랜덤 생성)
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
        //게임 시작
        while(true) {
            System.out.println("빙고 숫자를 입력하세요(종료 -> 0):");
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
        System.out.println("게임 종료");
        
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
 