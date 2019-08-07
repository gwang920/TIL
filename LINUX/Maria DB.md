# Maria DB

##### Maria DB 연결

```
p554

MariaDB-10.0.15-centos7_0-x86_64-client.rpm
MariaDB-10.0.15-centos7_0-x86_64-common.rpm
MariaDB-10.0.15-centos7_0-x86_64-server.rpm

Download

1)
cd /file/maria
yum -y remove mairadb-libs   // 충돌나는 패키지 삭제 in root
yum -y localinstall Maria*   // Maria로 시작하는 파일 전부 설치

2)
systmectl restart mysql
systmectl status mysql
chkconfig mysql on   // 서비스 상시가동

3)
firewall-config 방화벽 설정  영구적->public->mysql check

4)

mysqladmin -u root password '111111'    // password 설정
mysql -u root -p    // 접속 ( 비밀번호 입력 )

5) root 에서 mysql 입력
6) Use mysql;
   SELECT user,host FROM user;
   
+------+-----------+
| user | host      |
+------+-----------+
| root | 127.0.0.1 |
| root | ::1       |
|      | localhost |
| root | localhost |
|      | server1   |
| root | server1   |
+------+-----------+

// 현재 root 라는 이름의 사용자는 4명 127~ , ::1~, localhost~, server1

7) 따라서 192.168.111.000 으로 시작하는 IP 주소 모두가 접속할 수 있도록 사용자 생성

GRANT ALL PRIVILEGES ON *.* TO user1@'192.168.111.%' IDENTIFIED BY '비밀번호';

+-------+---------------+
| user  | host          |
+-------+---------------+
| root  | 127.0.0.1     |
| user1 | 192.168.111.% |
| root  | ::1           |
|       | localhost     |
| root  | localhost     |
|       | server1       |
| root  | server1       |
+-------+---------------+

이제 user1이라는 이름의 사용자가 생성된것을 확인할 수 있다

8) 마찬가지로 다른 나의 ip로 접속하도록 생성하자
GRANT ALL PRIVILEGES ON *.* TO user1@'70.12.114.%' IDENTIFIED BY '111111';
GRANT ALL PRIVILEGES ON *.* TO user1@'localhost' IDENTIFIED BY '111111';


이제 데이터 베이스를 생성하자

1)CREATE DATABASE shop; //shop 이라는 database 생성
2)CREATE TABLE PRODUCT(
	ID INT PRIMARY KEY,
	NAME NVARCHAR(20) NOT NULL,
	PRICE INT NOT NULL,
	REGDATE DATE
); 
// PRODUCT 테이블 생성

3)컬럼추가

INSERT INTO PRODUCT VALUES (100,'pants1', 10000, SYSDATE());
INSERT INTO PRODUCT VALUES (101,'pants2', 20000, SYSDATE());
INSERT INTO PRODUCT VALUES (102,'pants3', 30000, SYSDATE());
INSERT INTO PRODUCT VALUES (103,'pants4', 40000, SYSDATE());
INSERT INTO PRODUCT VALUES (104,'pants5', 50000, SYSDATE());

4) 조회하자
MariaDB [shop]> select * from PRODUCT
    -> ;
+-----+--------+-------+------------+
| ID  | NAME   | PRICE | REGDATE    |
+-----+--------+-------+------------+
| 100 | pants1 | 10000 | 2019-07-25 |
| 101 | pants2 | 20000 | 2019-07-25 |
| 102 | pants3 | 30000 | 2019-07-25 |
| 103 | pants4 | 40000 | 2019-07-25 |
| 104 | pants5 | 50000 | 2019-07-25 |
+-----+--------+-------+------------+

```



##### JAVA CODE 연결

```JAVA
project
build path에
1) mariadb-java-client-2.4.2 추가
2) ojdbc6_g.jar 추가


package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {

	public static void main(String[] args) 
	throws Exception{
		
		String id="user1";
		String pwd="111111";
		String url="jdbc:mariadb://192.168.111.100:3306/shop";
		
		// shop = database name
		
		Class.forName("org.mariadb.jdbc.Driver"); // 드라이버 로드
		
		Connection con = DriverManager.getConnection(url, id, pwd);   // 연결 얻기
		
		String sql = "SELECT * FROM PRODUCT";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rset =pstmt.executeQuery(); // executeQuery :수행결과로 ResultSet 객체의 값을 반환
		
		while(rset.next()) {
			
			int iid= rset.getInt("ID");
			String name= rset.getString("NAME");
			int price = rset.getInt("PRICE");
			String regdate= rset.getString("REGDATE");
			System.out.println(iid+" "+name+" "+price+" "+regdate);
		}
	}
}


실행결과

100 pants1 10000 2019-07-25
101 pants2 20000 2019-07-25
102 pants3 30000 2019-07-25
103 pants4 40000 2019-07-25
104 pants5 50000 2019-07-25

```



Maria DB 비밀번호 재설정

```
MariDB root 비밀번호 강제 재설정

# service mysql stop
# /usr/bin/mysqld_safe --skip-grant-tables &
# mysql -uroot mysql
MariaDB [mysql]> update user set password=PASSWORD("새로운비밀번호") where User='root';
MariaDB [mysql]> flush privileges;

# service mysql restart
```



Maria DB 삭제

```
- yum list installed mariadb\*       // 설치되어있는 mariadb 파일 조회
- yum remove -y 파일명    // 조회된 파일을 모두 삭제하자

ex)
[root@server1 ~]# yum list installed mariadb\*
Loaded plugins: fastestmirror, langpacks
Loading mirror speeds from cached hostfile
Installed Packages
MariaDB-client.x86_64 10.0.15-1.el7.centos @/MariaDB-10.0.15-centos7_0-x86_64-client
MariaDB-common.x86_64 10.0.15-1.el7.centos @/MariaDB-10.0.15-centos7_0-x86_64-common
MariaDB-server.x86_64 10.0.15-1.el7.centos @/MariaDB-10.0.15-centos7_0-x86_64-server



```

