# I. 데이터베이스

##### 	계층형 데이터베이스(Hierarchical Database)

#####     관계형 데이터베이스(Relational Database)



##### - 밸류형 데이터스토어(Key-Value Store: KVS)

#####  구글 등 대량의 데이터를 초고속으로 검색해야 하는 웹 서비스 등에서 사용



# II. SQL

##### 데이터베이스를 제어하기 위해 개발된 언어

####  SQL문

- ##### DDL(Data Definition Language)

  - ##### CREATE

  - ##### DROP
  	ex) drop table t_user;

  - ##### ALTER

- ##### DML(Data Manipulation Language)

  - ##### SELECT

  - ##### INSERT

    ##### INSERT INTO T_USER () VALUES ()

  - ##### DELETE

    ##### DELETE FROM T_USER WHERE ID='id01'

  - ##### UPDATE

    ##### UPDATE T_USER SET PWD='111',NAME='공말숙'  // 모든 데이터의 PWD NAME 이 바뀐다

    ##### UPDATE T_USER SET PWD='111',NAME='공말숙' WHERE ID='id03' 

    ##### // 그래서 WHERE(조건)를 넣어준다

- ##### DCL(Data Control Language)

  

#### SQL 기본 규칙

- ##### SQL문 마지막에 세미콜론(;)을 붙인다

- ##### 대문자, 소문자 구분이 없다 (단, 테이블에 등록된 데이터에 한해서는 대/소문자 구분)

  - ##### SQL문 : SELECT == select  BUT,  Data : Computer /= computer

- ##### 단어는 공백 / 줄바꿈으로 구분

  - ##### EX) CREATE TABLE Goods

- ##### 상수 작성법

  - ##### 문자열 / 날짜 /숫자 등을 상수

  - ##### 'abc' 작은따옴표로 문자열을 감싸면 문자열



```
COLUMN 이름 변경
- ALTER TABLE (TABLE NAME) RENAME COLUMN (COLUMN NAME) TO (NEW NAME)
SIZE 변경
- ALTER TABLE (TABLE NAME) MODIFY(COLUMN NAME) NUMBER(NEW SIZE);
COLUMN 추가
- ALTER TABLE (TABLE NAME) ADD (COLUMN NAME) (DATE TYPE);
Nullable 수정
- ALTER TABLE (TABLE NAME) MODIFY ((COLUMN NAME) NOT NULL);
TABLE명 변경
- ALTER TABLE (TABLE NAME) RENAME TO (NEW NAME);
TABLE 보기(Describe)
- DESC (TABLE NAME)

ALTER TABLE T_USER MODIFY (NAME UNIQUE);  // UNIQUE 제약 조건과 PRIMARY KEY 제약 조건이 모두 고유성을 강제 적용하지만 기본 키가 아닌 열 또는 열 조합에 대해 고유성을 강제 적용하려면 PRIMARY KEY 제약 조건 대신 UNIQUE 제약 조건을 사용

ALTER TABLE T_PRODUCT MODIFY (PRICE DEFAULT 1000); // PRICE 의 DEFAULT값이 1000원

ALTER TABLE T_PRODUCT ADD PRIMARY KEY(ID);  // PRIMARY KEY를 바꾼다

INSERT INTO T_PRODUCT (ID,NAME,REGDATE) VALUES('P02','PANTS2',SYSDATE); // INSERT문

INSERT INTO T_PRODUCT VALUES('P03','PANTS3',100.36,SYSDATE);  // 소수첫째자리에서 자동반올림되네

AUTOCOMMIT (CHECK)  // 자동 COMMIT

```



```
ORACLE 작동 오류 및 삭제시 접근방법

시작 -> 제어판 -> 관리도구 -> 상태관리

OracleServiceXE

OracleXETNSListener 1521 port

<http://127.0.0.1:8080/apex/f?p=4950>

// properties  -> Add External JARS...

C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib

ip보기 

cmd -> ipconfig
```





- 실습

##### T_USER의 CRUD를 각 프로그램에 작성 하시오

##### - SQL 문과 JAVA 연결해보자

```java
UserDao.java


package com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.User;

public class UserDao extends Dao<String, User> {

	@Override
	public void insert(User v) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;


//		pstmt=con.prepareStatement(Sql.insertUser);
//		pstmt.setString(1, v.getId());
//		pstmt.setString(2, v.getPwd());
//		pstmt.setString(3, v.getName());  // 여기서 Exception이 나면 close가 안된다 그래서 try catch
//		pstmt.executeUpdate();
//		close(pstmt);
//		close(con);
		try {
			con = getCon();
			pstmt = con.prepareStatement(Sql.insertUser);
			pstmt.setString(1,v.getId());
			pstmt.setString(2,v.getPwd());
			pstmt.setString(3,v.getName());
			int result = pstmt.executeUpdate(); 
			System.out.println(result);
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(con);
		}
	}

	@Override
	public void delete(String k) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;
		
		try {
			con = getCon();
			pstmt = con.prepareStatement(Sql.DeleteUser);
			pstmt.setString(1,k);
			int result = pstmt.executeUpdate(); //넣어줘야 삭제 된다
			System.out.println(result);
			
			
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(con);
		}
	}

	@Override
	public void update(User v) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;

		try {
			con = getCon();
			pstmt = con.prepareStatement(Sql.UpdateUser);
			pstmt.setString(1,v.getPwd());
			pstmt.setString(2,v.getName());
			pstmt.setString(3,v.getId());
			int result = pstmt.executeUpdate(); //넣어줘야 삭제 된다
			System.out.println(result);
			
			
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(con);
		}
		
	}

	@Override
	public User select(String k) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rset = null;
		
		try {
			con = getCon();
			pstmt = con.prepareStatement(Sql.SelectUser);
			pstmt.setString(1,k);
			rset = pstmt.executeQuery();
			rset.next();
			
			
			String uid = rset.getString("ID");   //column 명칭
			String upwd = rset.getString("PWD");   //column 명칭
			String uname = rset.getString("NAME");   //column 명칭
			System.out.println(uid + " "+upwd+" "+uname);
			
			
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(con);
		}
		
		return null;
	}

	@Override
	public ArrayList<User> select() throws Exception {
		
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rset = null;
		ArrayList<User> list = new ArrayList<User>();
	
		try {
			con = getCon();
			pstmt = con.prepareStatement(Sql.SelectAllUser);
			rset = pstmt.executeQuery();

			while(rset.next()) {
				String uid = rset.getString("ID");
				String upwd = rset.getString("PWD");
				String uname = rset.getString("NAME");
				
				System.out.println(uid+" "+upwd+" "+uname);
			}
			return list;
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(con);
		}
		
		
	}

}


Dao.java

package frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Dao<K, V> {

	String id;
	String pwd;
	String url;
	
	public Dao() {
		// 1. JDBC Driver Loading..
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  //자동으로 오라클에 접속하는 프로그램으로 바뀐다
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Error");
		}
		id = "db3";
		pwd = "db3";
		url = "jdbc:oracle:thin:@70.12.50.235:1521:xe";
		
	}
	
	public Connection getCon() {
		Connection con = null;
		try {
			con =
			DriverManager.getConnection(url,id,pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void close(PreparedStatement con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void close(ResultSet con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public abstract void insert(V v) throws Exception;

	public abstract void delete(K k) throws Exception;

	public abstract void update(V v) throws Exception;

	public abstract V select(K k) throws Exception;

	public abstract ArrayList<V> select() throws Exception;
}

Sql.java


package frame;

public class Sql {
	public static String insertUser
	= "INSERT INTO T_USER VALUES (?,?,?)";
	public static String DeleteUser
	= "DELETE FROM T_USER WHERE ID = ?";
	public static String UpdateUser
	= "UPDATE T_USER SET PWD=?,NAME=? WHERE ID=?";
	public static String SelectUser
	= "SELECT * FROM T_USER WHERE ID = ?";
	public static String SelectAllUser
	= "SELECT * FROM T_USER";
}


UserDelete.java

package test;

import com.UserDao;

import frame.Dao;
import vo.User;

public class UserDelete {

	public static void main(String[] args) {
		Dao<String,User> dao = new UserDao();
		
		try {
			dao.delete("id21");
			System.out.println("User Deleted");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

	}

}

UserInsert.java

package test;

import com.UserDao;

import frame.Dao;
import vo.User;

public class UserInsert {

	public static void main(String[] args) {
		Dao<String,User> dao = new UserDao();
		User user = new User("id56", "pwd55", "박주한");
		try {
			dao.insert(user);
			System.out.println("User Inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


UserSelect.java

package test;

import com.UserDao;

import frame.Dao;
import vo.User;

public class UserSelect {

	public static void main(String[] args) {
		Dao<String,User> dao = new UserDao();
		
		try {
			dao.select("id22");
			System.out.println("User Select");
		} catch (Exception e) {
		
			e.printStackTrace();
		}

	}

}

UserSelectAll.java

package test;

import java.util.ArrayList;

import com.UserDao;

import frame.Dao;
import vo.Product;
import vo.User;

public class UserSelectAll {

	public static void main(String[] args) {
		Dao<String,User> dao = new UserDao();
		ArrayList<User> list = new ArrayList<User>();
		
		try {
			 list=dao.select();
	            for(User us: list) {
	                System.out.println(us.toString());
	            }

		} catch (Exception e) {
		
			e.printStackTrace();
		}

	}

}

UserUpdate.java

package test;

import com.UserDao;

import frame.Dao;
import vo.User;

public class UserUpdate {

	public static void main(String[] args) {
		Dao<String,User> dao = new UserDao();
		User user = new User("id02", "asdf", "asdf"); //sql문의 순서가 아니라  User순서대로
		try {
			dao.update(user);
			System.out.println("User Update");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

Product.java
package vo;

import java.sql.Date;

public class Product {
	int id;
	String name;
	double price;
	Date regdate;

	public Product() {
	}

	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	
	
	public Product(int id, String name, double price, Date regdate) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.regdate = regdate;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", regdate=" + regdate + "]";
	}

}

User.java

package vo;

public class User {
	String id;
	String name;
	String pwd;
	public User() {}
	public User(String id,String pwd,String name) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}
	
	
}



```

