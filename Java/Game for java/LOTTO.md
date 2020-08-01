

# LOTTO 객체 지향 실습 190525

* 시나리오

1. 유저는 한개의 계좌를 가지고 있다.

2. 유저는 계좌의 남은 돈이 허락하는 한도 내에서 복권을 살 수 있다.

3. 원하는 숫자 6개를 입력한다.

4. 복권은 입력받은 숫자와 당첨 숫자, 등수에 따른 상금을 보유한다.

5. 복권은 입력받은 숫자와 당첨 숫자를 비교해서 등수를 계산한다.

6. 복권은 등수에 따른 상금을 계좌에 입금한다.

### main - Lotto 게임

```JAVA
package ws;
 
import java.util.Scanner;
 
public class Lotto {
 
    public static void main(String[] args) {
        
        Account acc=null;     //-----1)
        Prize prize=null;
        
        System.out.println("도전 ? (yes/no)");
        
        Scanner sc=new Scanner(System.in);
        String att=sc.next();
        
        if(att.equals("yes")) {   // 문자열 비교시 equals를 쓴다.
            
            System.out.println("계좌 생성 : 계좌명 계좌번호");
            String owner=sc.nextLine();
            String accNum=sc.nextLine();
            
            try {
                acc=
                new Account(owner,accNum); // 1)null => 할당을 새로해준것 
                System.out.println(acc);
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            
            //withdraw
            boolean flag=true;
            while(flag) {
                System.out.println("입금액을 입력하시오 : ex)100000");
                Scanner in=new Scanner(System.in);
                int inp=in.nextInt();
                try {
                    flag=false;
                    acc.deposit(inp);
                } catch (Exception e) {
                    flag=true;
                    System.out.println("음수로 입력할 수 없습니다.");
                }
                System.out.println(acc);
            }
            
            
                //Lotto
                System.out.println("번호를 입력하세요");
                Scanner sc1=new Scanner(System.in);
                int number[]=new int[6];
                for(int i=0;i<6;i++) {
                        number[i]=sc1.nextInt();
                }
                prize = new Prize(number, acc);
                
                
                
                //deposit
                
                System.out.println("출금하시겠습니까? (yes/no)");
                String wit=sc.nextLine();
                if(wit.equals("yes")) {
                    System.out.println("출금액을 입력하시오 : ex)100000");
                    Scanner out=new Scanner(System.in);
                    int outp=out.nextInt();
                    try {
                        acc.withdraw(outp);
                    } catch (Exception e) { 
                        System.out.println(e.getMessage());
                    }
                    System.out.println(acc);
                }
                else if(wit.equals("no")) {
                    System.out.println("종료");
                    return;
                } // withdraw <-> deposit flag , try & catch 비교  
                
        }
        else { System.out.println("종료");
                return;
        }
        
    }
}
```

### Prize - 당첨번호 비교 / 상금

```java
package ws;
 
import java.util.Random;
import java.util.Scanner;
 
public class Prize {
    
    
    Account acc=new Account();
    
    int prizeNum[]=new int[6];
    int choiceNum[]=new int[6];
    int prize=0;
    
    public Prize(int number[], Account acc){
        
        
    int count=0;
    for(int i=0;i<prizeNum.length;i++) {
        choiceNum[i]=number[i];
    }
    
    Random r = new Random();
    
    // 로또 당첨번호 생성 6개
    for(int i=0; i<prizeNum.length; i++) {
        prizeNum[i] = r.nextInt(20)+1;
        for(int j=0; j<i; j++) {
            if(prizeNum[i] == prizeNum[j]) {
                i--;
                break;
            }
        }
    }
    //비교
    for(int i=0;i<prizeNum.length;i++) {
        for(int j=0;j<prizeNum.length;j++) {
            if(prizeNum[i]==choiceNum[j]) {
                count++;
            }
        }
    }
    //당첨금생성
    if(count==6) {
        prize=2000000000;
    }
    else if (count==5)
    {
        prize=100000000;
    }
    else if (count==4)
    {
        prize=10000000;
    }
    else if (count==3)
    {
        prize=5000000;
    }
    else if (count==2)
    {
        prize=5000;
    }
    
    System.out.print("당첨번호=");
    for(int i=0;i<prizeNum.length;i++) {
        
        System.out.print(prizeNum[i]+" ");
    }
    System.out.println();
    System.out.println("당첨금액 = "+prize);
    
    
    try {
        acc.deposit(prize);
    } catch (Exception e) {
    
    }
    this.acc = acc;
        System.out.println(acc);
    }
}
```

### Account - 계좌/입급/출금

```java
package ws;
 
import java.util.Scanner;
 
public class Account {
    
        
        private String owner;
        private String accNum;
        private double balance;
            
        public Account(String owner,String accNum) {
            
            this.owner=owner;
            this.accNum=accNum;    
        }
        public Account() {
            
        }
        
        
        public void withdraw(int money) 
                throws Exception {
            if(money<=0) {
                throw new Exception("음수로 입력할 수 없습니다.");
            }
            if(this.balance < money) {
                throw new Exception("잔액이 부족합니다.");
            }this.balance-=money;
            
        }
        public void deposit(int money) 
                throws Exception {
            if(money<=0) {
                throw new Exception("음수로 입력할 수 없습니다.");
            }
            this.balance+=money;
        }
 
        @Override
        public String toString() {
            return "Account [이름=" + owner + ", 계좌번호=" + accNum + ", 잔액=" + balance + "]";
        }
}
```



### Feed back

- 코드구현 이전에 구조화 된 틀을 미리 작성해야겠다. ( 뒤죽박죽이 됨) + 주석 + UML

- main 문을 줄일 수 있는 방법들을 공부하자

- scanner에서 문자 하나만 받는 방법 ?