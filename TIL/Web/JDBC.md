# JDBC란 ?

```
- JAVA Database Connectivity
- 자바 프로그램 내에서 DB와 관련된 일을 처리할 수 있도록 도와주는 일을 한다.
- 이때, JDBC API를 이용하여 작업을 진행하는데 하나의 API로 모든 종류의 DBMS에 사용할 수 있다.
```

# 실행 순서

```
1. JDBC 드라이버 로딩
2. DriverManager.getConnection을 통해 데이터베이스에 Connection 한다.
3. Query 실행을 위해 Statement 객체를 생성한다.
4. Query 실행
5. statement 종료
6. DB Connection 종료
```

# Statement / PreparedStatement

```
- SQL을 실행할 수 있는 객체이다.

- 차이점
1) Statement
 - 단일로 사용될 때 빠른 속도를 지닌다.
 - 쿼리에 인자를 부여할 필요가 없다.
 - 매번 컴파일을 수행해야 한다.

2) PreparedStatement
  - 쿼리에 인자를 부여할 수 있다.
  - 처음 프리 컴파일 이후, 컴파일을 수행하지 않아도 된다.
  - 여러번 수행될 때 빠른 속도를 지닌다.
```



## 1. Statement

##### 매번 쿼리를 수행할 때 마다 1) - 3) 단계를 거친다.

##### 1) 쿼리분석

##### 2) 컴파일

##### 3) 실행

```java
String sqlstr="SELECT name,meom FROM TABLE WHERE num= " + num
Statement stmt = conn.credateStatement();
ResultSet rst = stmt.executeQuerey(sqlstr);
```

## 2. PreparedStatement

##### 1) ~ 3)의 단계를 최초 실행시 한번만 거친다.

```java
String sqlstr = "SELECT name, memo FROM TABLE WHERE num = ? " 

PreparedStatement stmt = conn.prepareStatement(sqlstr); 

pstmt.setInt(1, num);

ResultSet rst = pstmt.executeQuerey(); 

```

# Transaction

##### 트랜잭션(Transaction)은 여러 단계의 작업을 하나로 처리하는 것으로, 

##### 하나로 인식된 작업이 모두 성공적으로 종료되면 commit이 되고, 

##### 단 하나라도 문제가 생기면 rollback 되어 작업 수행 전단계로 모든 과정이 회수 된다.

**즉, 트랜잭션 내 모든 명령은 모두 성공이거나 실패이어야 한다.**

```
- 트랜잭션을 위한 메소드 : commit(), rollback()
  - commit() : 트랜잭션의 commit 수행
  - rollback() : 트랜잭션의 rollback 수행
- 자동 트랜잭션 메소드 : setAutoCommit(bollean autoCommit)
  - setAutoCommit() : commit이 자동적으로 수행 됨. default 값이 true
  - 트랜잭션 처리시 자동 오토커밋을 방지하기 위해 setAutoCommit(false); 로 설정
```

```java
Connection con = null;   //null로 초기화 1)
		try {
			con = DriverManager.getConnection(url, id, pwd); //2)  1)+2) db연결
			con.setAutoCommit(false);  // 오토커밋 false로 지정
            // 트랜잭션은 여러 개의 쿼리가 하나의 작업으로 수행 되어야 하기 때문에 자동으롤 커밋되지 			   않게 설정해야한다.
		} catch (SQLException e) {
			e.printStackTrace();
		}
```

# JDBC for oracle 연결 과정

```java
// 드라이버 로딩

Class.forName("oracle.jdbc.driver.OracleDriver");

// DB 연결

Connection con = null; 
con = DriverManager.getConnection(url, id, pwd);

// 쿼리 준비

PreparedStatement pstmt = null;
pstmt = con.prepareStatement(Sql.insertFactory);

// 쿼리 실행

psmt.executeUpdate();

// 데이터 가져오기

ResultSet rs = null;
rs = psmt.executeQuery();

==> rs.next() 를 이용하여 한 줄씩 읽어들인다.
	    PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Factory> fs = new ArrayList<Factory>();
		
		try {
			pstmt = con.prepareStatement(Sql.selectAllFactory);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Factory f = new Factory(rs.getString("FACTNO"), rs.getString("FACNAME"), rs.getString("FACLOC"));
				
				fs.add(f);
			}

// 커넥션 close
            
 catch (Exception e) {
			throw e;
		} finally {
			close(rs);
			close(pstmt);
		}            

```

# 실습

### 1. ERD



![1560250176498](C:\Users\student\AppData\Roaming\Typora\typora-user-images\1560250176498.png)



### 2. UML

![1560250190421](C:\Users\student\AppData\Roaming\Typora\typora-user-images\1560250190421.png)



### 3. DDL

```sql
CREATE TABLE T_FACTORY(
FACTNO VARCHAR2(5),
FACNAME VARCHAR2(14),
FACLOC VARCHAR2(13)
);
ALTER TABLE T_FACTORY ADD PRIMARY KEY(FACTNO);
 
CREATE TABLE T_PRODUCTS(
PDNO NUMBER, 
PDNAME VARCHAR2(10),
PDSUBNAME VARCHAR2(10),
FACTNO VARCHAR2(5),
PDDATE DATE,
PDCOST NUMBER,
PDPRICE NUMBER,
PDAMOUNT NUMBER
);
ALTER TABLE T_PRODUCTS ADD PRIMARY KEY(PDNO);
ALTER TABLE T_PRODUCTS ADD FOREIGN KEY(FACTNO)
REFERENCES T_FACTORY(FACTNO);

```

### 4. DML

```sql
INSERT INTO T_FACTORY (FACTNO, FACNAME, FACLOC) 
VALUES ('1', 'EDIYA', 'SEOUL');
 
INSERT INTO T_FACTORY (FACTNO, FACNAME, FACLOC) 
VALUES ('2', 'STARBUCKS', 'NEWYORK');
 
INSERT INTO T_FACTORY (FACTNO, FACNAME, FACLOC) 
VALUES ('3', 'CAFEBENE', 'JEJU');
 
INSERT INTO T_PRODUCTS VALUES(
001, 'COFFEE', 'AMERICANO', 1, SYSDATE, 500, 1500, 100
)
 
INSERT INTO T_PRODUCTS VALUES(
002, 'COFFEE', 'LATTE', 2, SYSDATE, 1000, 2500, 100
)
 
INSERT INTO T_PRODUCTS VALUES(
003, 'COFFEE', 'GREENLATTE', 2, SYSDATE, 1500, 3000, 50
)
 
INSERT INTO T_PRODUCTS VALUES(
004, 'COFFEE', 'MOCHA', 2, SYSDATE, 1500, 3000, 55
)
 
INSERT INTO T_PRODUCTS VALUES(
005, 'COFFEE', 'VANLATTE', 2, SYSDATE, 2000, 3500, 30
)
 
INSERT INTO T_PRODUCTS VALUES(
006, 'COFFEE', 'VANLATTE', 1, SYSDATE, 1800, 3200, 30
)
 
INSERT INTO T_PRODUCTS VALUES(
007, 'COFFEE', 'MOCHA', 1, SYSDATE, 1200, 2700, 70
)
 
INSERT INTO T_PRODUCTS VALUES(
008, 'TEA', 'GREENTEA', 1, SYSDATE, 600, 1800, 170
)
 
INSERT INTO T_PRODUCTS VALUES(
009, 'TEA', 'REDTEA', 1, SYSDATE, 600, 1900, 150
)
 
INSERT INTO T_PRODUCTS VALUES(
010, 'TEA', 'BLACKTEA', 2, SYSDATE, 800, 2400, 130
)
 
INSERT INTO T_PRODUCTS VALUES(
011, 'TEA', 'ICEDTEA', 2, SYSDATE, 400, 1600, 110
)
 
INSERT INTO T_PRODUCTS VALUES(
012, 'DESERT', 'BREAD', 2, SYSDATE, 800, 3200, 45
)
 
INSERT INTO T_PRODUCTS VALUES(
013, 'DESERT', 'BAGLE', 2, SYSDATE, 900, 3500, 30
)
 
INSERT INTO T_PRODUCTS VALUES(
014, 'DESERT', 'CAKE', 1, SYSDATE, 1200, 4000, 25
)
 
INSERT INTO T_PRODUCTS VALUES(
015, 'DESERT', 'MACARON', 2, SYSDATE, 800, 3500, 20
)
```

### 5. 작성코드

```java
@ Package : com

- FactoryBiz

package com;
import java.sql.Connection;
import java.util.ArrayList;
import frame.Biz;
import frame.Dao;
import vo.Factory;

public class FactoryBiz extends Biz<String, Factory> {
	Dao<String, Factory> dao;
	public FactoryBiz() {
		dao = new FactoryDao();
	}
	@Override
	public void insert(Factory v) throws Exception {
		Connection con = null;
		try {
			con = getCon();
			dao.insert(v, con);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}
	}
	@Override
	public void delete(String k) throws Exception {
		Connection con = null;
		try {
			con = getCon();
			dao.delete(k, con);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}
	}
	@Override
	public void update(Factory v) throws Exception {
		Connection con = null;
		try {
			con = getCon();
			dao.update(v, con);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}
	}
	@Override
	public Factory select(String k) throws Exception {
		Connection con = getCon();
		Factory f = null;
		
		try {
			f = dao.select(k, con);	
		} catch (Exception e) {
			
		} finally {
			close(con);
		}
		
		return f;
	}
	@Override
	public ArrayList<Factory> selectAll() throws Exception {
		Connection con = getCon();
		ArrayList<Factory> fs = null;
		
		try {
			fs = dao.selectAll(con);	
		} catch (Exception e) {
			
		} finally {
			close(con);
		}
		
		return fs;
	}
	
}

- FactoryDao

package com;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import frame.Dao;
import frame.Sql;
import vo.Factory;

public class FactoryDao extends Dao<String,Factory> {
	@Override
	public void insert(Factory v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.insertFactory);
			pstmt.setString(1, v.getFact_no());
			pstmt.setString(2, v.getFac_name());
			pstmt.setString(3, v.getFac_loc());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}
	}
	@Override
	public void delete(String k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.deleteFactory);
			pstmt.setString(1, k);
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}
		
	}
	@Override
	public void update(Factory v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.updateFactory);
			pstmt.setString(1, v.getFac_loc());
			pstmt.setString(2, v.getFact_no());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}
		
	}
	@Override
	public Factory select(String k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Factory f = null;
		
		try {
			pstmt = con.prepareStatement(Sql.selectFactory);
			pstmt.setString(1, k);
			rs = pstmt.executeQuery();
			rs.next();
			f = new Factory(rs.getString("FACTNO"), rs.getString("FACNAME"), rs.getString("FACLOC"));	
		} catch (Exception e) {
			throw e;
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return f;
	}
	@Override
	public ArrayList<Factory> selectAll(Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Factory> fs = new ArrayList<Factory>();
		
		try {
			pstmt = con.prepareStatement(Sql.selectAllFactory);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Factory f = new Factory(rs.getString("FACTNO"), rs.getString("FACNAME"), rs.getString("FACLOC"));
				
				fs.add(f);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return fs;
	}
}

- ProductsBiz

package com;
import java.sql.Connection;
import java.util.ArrayList;
import frame.Biz;
import frame.Dao;
import vo.Factory;
import vo.Products;

public class ProductsBiz extends Biz<String, Products> {
	Dao<String, Products> dao;
	
	public ProductsBiz() {
		dao = new ProductsDao();
	}
	@Override
	public void insert(Products v) throws Exception {
		Connection con = null;
		try {
			con = getCon();
			dao.insert(v, con);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}
	}
	@Override
	public void delete(String k) throws Exception {
		Connection con = null;
		try {
			con = getCon();
			dao.delete(k, con);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}
		
	}
	@Override
	public void update(Products v) throws Exception {
		Connection con = null;
		try {
			con = getCon();
			dao.update(v, con);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}
	}
	@Override
	public Products select(String k) throws Exception {
		Connection con =getCon();
		Products p=null;
		
		try {
			p=dao.select(k,con);
			
		}catch(Exception e) {
			
		}finally {
			close(con);
		}
		return p;
	}
	@Override
	public ArrayList<Products> selectAll() throws Exception {
		Connection con = getCon();
		ArrayList<Products> ps=null;
		
		try {
			ps=dao.selectAll(con);
		}catch(Exception e) {
			
		}finally {
			close(con);
		}
		return ps;
	}
	public Products max(String k) throws Exception {
		Connection con =getCon();
		Products p=null;
		ProductsDao pdao = (ProductsDao) dao; 
		try {
			p=pdao.max(k,con);
			
		}catch(Exception e) {
			throw e;
		}finally {
			close(con);
		}
		return p;
	}
}

- ProductsDao

package com;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import frame.Dao;
import frame.Sql;
import vo.Factory;
import vo.Products;

public class ProductsDao extends Dao<String, Products> {
	@Override
	public void insert(Products v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.insertProducts);
			pstmt.setInt(1, v.getPd_no());
			pstmt.setString(2, v.getPd_name());
			pstmt.setString(3, v.getPd_sub_name());
			pstmt.setString(4, v.getFact_no());
			pstmt.setInt(5, v.getPd_cost());
			pstmt.setInt(6, v.getPd_price());
			pstmt.setInt(7, v.getPd_amount());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}
	}
	@Override
	public void delete(String k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.deleteProducts);
			pstmt.setString(1, k);
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}
	}
	@Override
	public void update(Products v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.updateProducts);
			pstmt.setInt(1, v.getPd_amount());
			pstmt.setInt(2, v.getPd_no());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}
	}
	@Override
	public Products select(String k, Connection con) throws Exception {
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		Products p =null;
		
		try {
			pstmt=con.prepareStatement(Sql.selectProducts);
			pstmt.setString(1,k);
			rs=pstmt.executeQuery();
			rs.next();
			p=new Products(rs.getInt("PDNO"),rs.getString("PDNAME"),rs.getString("PDSUBNAME"),rs.getString("FACTNO"),
					rs.getDate("PDDATE"),rs.getInt("PDCOST"),rs.getInt("PDPRICE"),
					rs.getInt("PDAMOUNT"));
		}catch(Exception e) {
			throw e;
		}finally {
			close(rs);
			close(pstmt);
			
		}
		return p;
	}
	@Override
	public ArrayList<Products> selectAll(Connection con) throws Exception {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		ArrayList<Products> ps=new ArrayList<Products>();
		try {
			pstmt=con.prepareStatement(Sql.selectAllProducts);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Products p=new Products(rs.getInt("PDNO"),rs.getString("PDNAME"),rs.getString("PDSUBNAME"),rs.getString("FACTNO"),
						rs.getDate("PDDATE"),rs.getInt("PDCOST"),rs.getInt("PDPRICE"),
						rs.getInt("PDAMOUNT")); //INT형 EX) PD_NO에 있는 값을 INT형으로 가져온다
				ps.add(p);
			}									 // "대문자" 형으로 맞춘다
		}catch(Exception e) {
			throw e;
		}finally {
			close(rs);
			close(pstmt);
		}
		return ps;
	}
	
	public Products max(String k, Connection con) throws Exception {
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		Products p =null;
		
		try {
			pstmt=con.prepareStatement(Sql.maxPriceProductsInTheFactory);
			pstmt.setString(1,k);
			rs=pstmt.executeQuery();
			rs.next();
			p=new Products(rs.getInt("PDNO"),rs.getString("PDNAME"),rs.getString("PDSUBNAME"),rs.getString("FACTNO"),
					rs.getDate("PDDATE"),rs.getInt("PDCOST"),rs.getInt("PDPRICE"),
					rs.getInt("PDAMOUNT"));
		}catch(Exception e) {
			throw e;
		}finally {
			close(rs);
			close(pstmt);
			
		}
		return p;
	}
}


@ Package : frame

- Biz

	package frame;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.ArrayList;

	public abstract class Biz<K,V> {
		
		String id;
		String pwd;
		String url;
		
		public Biz() {
			// 1. JDBC Driver Loading..
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");  //자동으로 오라클에 접속하는 프로그램으로 바뀐다
			} catch (ClassNotFoundException e) {
				System.out.println("Driver Loading Error");
			}
			id = "db";
			pwd = "db";
			url = "jdbc:oracle:thin:@70.12.50.234:1521:xe";
			
		}
		
		public Connection getCon() {   // connection
			Connection con = null;
			try {
				con =
				DriverManager.getConnection(url,id,pwd);
				con.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return con;
		}
		
		public void close(Connection con) {     //connection close
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
		public abstract ArrayList<V> selectAll() throws Exception;
		
//		public abstract V max(K k) throws Exception;
		
	 
	}

- Dao

package frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Dao<K, V> {
	
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
	
	public abstract void insert(V v,Connection con) throws Exception;
	public abstract void delete(K k,Connection con) throws Exception;
	public abstract void update(V v,Connection con) throws Exception;
	public abstract V select(K k,Connection con) throws Exception;
	public abstract ArrayList<V> selectAll(Connection con) throws Exception;
	
//	public abstract V max(K k, Connection con) throws Exception;
}

- Sql

package frame;
public class Sql {
	public static String insertProducts = "INSERT INTO T_PRODUCTS VALUES (?,?,?,?,SYSDATE,?,?,?)";
	public static String deleteProducts = "DELETE FROM T_PRODUCTS WHERE PDNO =?";
	public static String updateProducts = "UPDATE T_PRODUCTS SET PDAMOUNT=? WHERE PDNO=?";
	public static String selectProducts = "SELECT * FROM T_PRODUCTS WHERE PDNO = ?";
	public static String selectAllProducts = "SELECT * FROM T_PRODUCTS ORDER BY PDNO";
	public static String insertFactory = "INSERT INTO T_FACTORY VALUES (?,?,?)";
	public static String deleteFactory = "DELETE FROM T_FACTORY WHERE FACTNO =?";
	public static String updateFactory = "UPDATE T_FACTORY SET FACLOC=? WHERE FACTNO=?";
	public static String selectFactory = "SELECT * FROM T_FACTORY WHERE FACTNO =?";
	public static String selectAllFactory = "SELECT * FROM T_FACTORY ORDER BY FACTNO";
	public static String maxPriceProductsInTheFactory = "SELECT * FROM T_FACTORY f, T_PRODUCTS p WHERE f.FACTNO = p.FACTNO AND p.PDPRICE IN (SELECT MAX(p2.PDPRICE) FROM T_PRODUCTS p2 GROUP BY FACTNO) AND f.FACTNO = ?";
}

@ Package : test

- FactoryDelete

package test;
import com.FactoryBiz;
import frame.Biz;
import vo.Factory;
public class FactoryDelete {
	public static void main(String[] args) {
		String str = "3";
		Biz<String, Factory> biz = new FactoryBiz();
		try {
			biz.delete(str);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

- FactoryInsert

package test;
import com.FactoryBiz;
import frame.Biz;
import vo.Factory;
public class FactoryInsert {
	public static void main(String[] args) {
		Factory f = new Factory("4", "BLUEBOTTLE", "GANGNAM");
		Biz<String, Factory> biz = new FactoryBiz();
		
		try {
			biz.insert(f);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
	    }
	}
}


- FactorySelect

package test;
import com.FactoryBiz;
import frame.Biz;
import vo.Factory;
public class FactorySelect {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Biz<String,Factory> biz = new FactoryBiz();
		
		try {
			Factory f = biz.select("2");
			System.out.println(f.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


- FactorySelectAll

package test;
import java.util.ArrayList;
import com.FactoryBiz;
import frame.Biz;
import vo.Factory;
public class FactorySelectAll {
	public static void main(String[] args) {
		Biz<String,Factory> biz = new FactoryBiz();
		
		try {
			ArrayList<Factory> fs = biz.selectAll();
			
			for (Factory f : fs) {
				System.out.println(f.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

- FactoryUpdate

package test;
import com.FactoryBiz;
import frame.Biz;
import vo.Factory;
public class FactoryUpdate {
	public static void main(String[] args) {
		Factory f = new Factory("4","","GANGNAM");
		Biz<String, Factory> biz = new FactoryBiz();
		try {
			biz.update(f);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

- Max

package test;
import com.ProductsBiz;
import frame.Biz;
import vo.Products;
public class Max {
	public static void main(String[] args) {
		Biz<String,Products> biz= new ProductsBiz();
		ProductsBiz pbiz = (ProductsBiz) biz;
		try {
			Products p=pbiz.max("2");
			System.out.println(p.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

- ProductDelete

package test;
import com.ProductsBiz;
import frame.Biz;
import vo.Products;
public class ProductDelete {
	public static void main(String[] args) {
		String str = "16";
		Biz<String, Products> biz = new ProductsBiz();
		try {
			biz.delete(str);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

- ProductInsert

package test;
import com.ProductsBiz;
import frame.Biz;
import vo.Products;
public class ProductInsert {
	public static void main(String[] args) {
		Products p = new Products(16, "COFFEE", "LONGBLACK", "4", 1300, 3900, 32);
		Biz<String, Products> biz = new ProductsBiz();
		
		try {
			biz.insert(p);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
	    }
	}
}

- ProductSelect

package test;
import com.ProductsBiz;
import frame.Biz;
import vo.Products;
public class ProductSelect {
	public static void main(String[] args) {
		Biz<String,Products> biz= new ProductsBiz();
		
		try {
			Products p=biz.select("3");
			System.out.println(p.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

- ProductSelectAll

package test;
import java.util.ArrayList;
import com.ProductsBiz;
import frame.Biz;
import vo.Products;
public class ProductSelectAll {
	public static void main(String[] args) {
		Biz<String,Products> biz= new ProductsBiz();
		try {
		ArrayList<Products> ps=biz.selectAll();
			
			for(Products p : ps) {
				System.out.println(p.toString());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

- ProductUpdate

package test;
import com.ProductsBiz;
import frame.Biz;
import vo.Products;
public class ProductUpdate {
	public static void main(String[] args) {
		Products p = new Products(16, 35);
		Biz<String, Products> biz = new ProductsBiz();
		try {
			biz.update(p);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

@ Package : vo

- Factory

package vo;
public class Factory {
	
	String fact_no;
	String fac_name;
	String fac_loc;
	
	
	
	public Factory() {
	}
	public Factory(String fact_no, String fac_name, String fac_loc) {
		this.fact_no = fact_no;
		this.fac_name = fac_name;
		this.fac_loc = fac_loc;
	}
	public String getFact_no() {
		return fact_no;
	}
	public void setFact_no(String fact_no) {
		this.fact_no = fact_no;
	}
	public String getFac_name() {
		return fac_name;
	}
	public void setFac_name(String fac_name) {
		this.fac_name = fac_name;
	}
	public String getFac_loc() {
		return fac_loc;
	}
	public void setFac_loc(String fac_loc) {
		this.fac_loc = fac_loc;
	}
	@Override
	public String toString() {
		return "Factory [fact_no=" + fact_no + ", fac_name=" + fac_name + ", fac_loc=" + fac_loc + "]";
	}
	
	
	
	
}
- Products

package vo;
import java.sql.Date;
public class Products {
	
	int pd_no;
	String pd_name;
	String pd_sub_name;
	String fact_no;
	Date pd_date;
	int pd_cost;
	int pd_price;
	int pd_amount;
	
	public Products() {
	}
	public Products(int pd_no, int pd_amount) {
		this.pd_no = pd_no;
		this.pd_amount = pd_amount;
	}
	public Products(int pd_no, String pd_name, String pd_sub_name, String fact_no, Date pd_date, int pd_cost,
			int pd_price, int pd_amount) {
		this.pd_no = pd_no;
		this.pd_name = pd_name;
		this.pd_sub_name = pd_sub_name;
		this.fact_no = fact_no;
		this.pd_date = pd_date;
		this.pd_cost = pd_cost;
		this.pd_price = pd_price;
		this.pd_amount = pd_amount;
	}
	public Products(int pd_no, String pd_name, String pd_sub_name, String fact_no, int pd_cost,
			int pd_price, int pd_amount) {
		this.pd_no = pd_no;
		this.pd_name = pd_name;
		this.pd_sub_name = pd_sub_name;
		this.fact_no = fact_no;
		this.pd_cost = pd_cost;
		this.pd_price = pd_price;
		this.pd_amount = pd_amount;
	}
	public int getPd_no() {
		return pd_no;
	}
	public void setPd_no(int pd_no) {
		this.pd_no = pd_no;
	}
	public String getPd_name() {
		return pd_name;
	}
	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}
	public String getPd_sub_name() {
		return pd_sub_name;
	}
	public void setPd_sub_name(String pd_sub_name) {
		this.pd_sub_name = pd_sub_name;
	}
	public String geFact_no() {
		return fact_no;
	}
	public void setFact_no(String fact_no) {
		this.fact_no = fact_no;
	}
	public Date getPd_date() {
		return pd_date;
	}
	public void setPd_date(Date pd_date) {
		this.pd_date = pd_date;
	}
	public int getPd_cost() {
		return pd_cost;
	}
	public void setPd_cost(int pd_cost) {
		this.pd_cost = pd_cost;
	}
	public int getPd_price() {
		return pd_price;
	}
	public void setPd_price(int pd_price) {
		this.pd_price = pd_price;
	}
	public int getPd_amount() {
		return pd_amount;
	}
	public void setPd_amount(int pd_amount) {
		this.pd_amount = pd_amount;
	}
	@Override
	public String toString() {
		return "Products [pd_no=" + pd_no + ", pd_name=" + pd_name + ", pd_sub_name=" + pd_sub_name + ", fact_no="
				+ fact_no + ", pd_date=" + pd_date + ", pd_cost=" + pd_cost + ", pd_price=" + pd_price + ", pd_amount="
				+ pd_amount + "]";
	}
}
```

```
참고사이트

https://hyeonstorage.tistory.com/113
https://devbox.tistory.com/entry/Comporison
https://blog.outsider.ne.kr/6


오류

다른 pc에서 다시 실행할 때
project 우클릭 - > properties -> java build path -> add external jars..

추가해주자..!
```

