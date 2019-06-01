# 객체지향프로그래밍

##### - 설계, 구현, 검증, 개발의 일련의 과정을 구조화하자

##### - frame : 뼈대를 세우자

```
App -------> Biz --------------> Dao ----------> Oracle
             ^ ^                 ^ ^
             | |                 | |
  UserBiz____| |                 | |
               |___ProductBiz    | |
           	                 | |
		    UserDao______| |_______ProductDuo

user
product
  
  
- 추상클래스 Biz, Dao를 생성
- 일련의 과정을 거치는 프로세스 구축

ex)
로그인 시스템

- App을 통해 user,product의 정보를 입력받는다
- Biz를 통해 신뢰성/보안 등을 검증
- Dao를 통해 Oracle(DB)로 로그인 정보를 전달한다
- user , product 객체는 프로세스 과정을 따라 이동한다
```

##### 실습

```java
/// App
package db;

public class App {

	public static void main(String[] args) {
		User user = new User("id01","james","pwd01");  //user 객체 생성
		
		Biz biz= new UserBiz("192.168.11.100");
//		biz.register(user); // UserBiz가 아직 없어도 사용할 수 있게 (Biz만 보고 개발할 수 있게)
//		biz.remove("id01"); 
		
		User dbuser=null;
		dbuser=(User)biz.get("id01"); //(User) ==type캐스팅
		System.out.println(dbuser);
	}

}

/// Biz
package db;

public abstract class Biz {
	public abstract void register(Object obj); // obj가 들어오면 그 obj를 등록하겠다.
	public abstract void remove(Object obj);
	public abstract Object get(Object obj);  // ex) id를 넣어줄테니 로그인 이후 화면을 가져오라 
}

/// Dao
package db;

public abstract class Dao {
	
	private String ip;

	
	
	//
	public Dao() {
	}

	public Dao(String ip) {
		this.ip = ip;
	}
	
	
	//
	public void connection() {
		System.out.println(ip+":connected..");
	}
	public void close() {
		System.out.println(ip+":closed..");
	}
	
	
	public abstract void insert(Object obj);     //Object 하위클래스는 '다들어간다' obj 
	public abstract Object select(Object obj);  // 모두 다 리턴,, product 객체를 만들어서 product 객체를 '리턴'한다
	public abstract void delete(Object obj);
	
}
/// ProductBiz
package db;

public class ProductBiz extends Biz {

	Dao dao;
	
	
	public ProductBiz(String ip) {
		dao = new ProductDao(ip);
	}
	@Override
	public void register(Object obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Object obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object get(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
/// UserBiz
package db;

public class UserBiz extends Biz {
	
	Dao dao;
	
	public UserBiz(String ip) {
		dao = new UserDao(ip);
	}
	
	@Override
	public void register(Object obj) {
		// Transaction start ...
		// 보안 검증 걸쳐서 통과하면
		dao.insert(obj);  // 여기다 데이터를 넣어줄게
		// Transaction end ...
	}

	@Override
	public void remove(Object obj) {
		// Transaction start ...
		dao.delete(obj);
		// Transaction end ...
	}

	@Override
	public Object get(Object obj) {
		User user=null;
		// Transaction start ...
		user=(User)dao.select(obj);
		// Transaction end ...
		return user;
	}

}
/// ProductDao
package db;

public class ProductDao extends Dao {
	
	public ProductDao() {
		
	}
	public ProductDao(String ip) {
		super(ip);   // 상속받은 것 을 constructor를 통해 setting
	}
	
	
	
	@Override
	public void insert(Object obj) {
		connection();
		Product product=(Product)obj;
		System.out.println(product.getId()+
				" "+ product.getName()+ " "
				+ product.getPrice()
				+" Inserted...");
		close();

	}

	@Override
	public Object select(Object obj) {
		Product product=null;
		String str=(String)obj;
		connection();
		product=new Product("nike","gwang",10000);
		close();
		return product;
	}

	@Override
	public void delete(Object obj) {
		String str=(String)obj;
		connection();
		System.out.println(str+" Deleted...");
		close();
	}

}
/// UserDao
package db;

public class UserDao extends Dao {

	public UserDao() {
		
	}
	public UserDao(String ip) {
		super(ip);
	}
	@Override
	public void insert(Object obj) {
		connection();
		User user = (User)obj; 
		System.out.println(user.getId()+ " "+
				user.getName()+" "
				+user.getPwd()+
				" Inserted...");
		close();
		
	}

	@Override
	public Object select(Object obj) {
		User user = null;
		String str= (String)obj;
		// DB에서 select해서 데이터를 가지고 온다.
		connection();
		user = new User("id01","Tom","pwd01");
		close();
		return user;
	}

	@Override
	public void delete(Object obj) {
		// TODO Auto-generated method stub
		String str= (String)obj;
		connection();
		System.out.println(str+"Deleted...");
		close();
	}

}

/// Product
package db;

public class Product {
	String id;
	String name;
	double price;
	
	//
	
	
	
	public Product() {
	}

	public Product(String id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	//
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
/// User
package db;

public class User {
	
	
	String id;
	String name;
	String pwd;
	
	
	//
	public User() {}
	public User(String id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
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
	
	//
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}
	
	
}



```

