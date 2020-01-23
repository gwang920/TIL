# 제네릭(Generics)

##### - 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에 컴파일 시 '타입체크'
##### => 실행시 타입 에러가 나는 것보다 컴파일 시에 미리 타입을 강하게 체크해서 에러를 사전에 방지
##### - 데이터 타입을 인스턴스 생성시 확정하는 것
##### => 비제네릭 코드는 불필요하게 타입 변환(Casting)을 하기 때문에 프로그램 성능에 악영향을 미친다
##### - 장점

##### 	객체의 타입  안전성이 높다

##### 	형변환의 번거로움이 줄어든다

```java
class Box<T> {   // 지네릭 타입 T 선언

	T item;
	void setItem(T item){
		this.item=item;
}
	T getItem() {
		return item;
}
	
}

-----
// Casting 
List list = new ArrayList();
list.add("Come");
String str = (String) list.get(0); // 타입 변환 필요

// 제네릭 사용
List<String> list2 = new ArrayList<>();
list2.add("Come");
String str2 = list.get(0); // 불필요

-----
// 비제네릭 타입 이용시
public class Corn{
    private Object obj;
    public Object get(){return obj;}
    public void set(Object obj){this.obj = obj;}
}

// 제네릭 타입 이용시
public class Corn<T>{
    private T t;
    public T get() {return t;}
    public void set(T t){this.t = t;}
}

// Object를 사용하면 모든 타입을 받을 수 있지만 매번 형 변환이 일어난다.
// 제네릭을 사용하면 형 변환을 최소화 할 수 있다.
------

 Box<string> b = new Box<string>();  // 지네릭 타입 호출
```

- 실습

  ```
  App -> Product -----> DB(추상클래스) <------ ProductDB
      -> User   ------>    		   <------ UserDB
      
      App을 통해 입력 받은 Product,User의 정보를 ProductDB,UserDB를 이용해
      DB에 넣는다(?)
  ```

  

```java
//App
package db3;

public class App {

	public static void main(String[] args) {
//			DB db= new UserDB();
			DB<User,String> db= new UserDB();
			User user=new User("id01","james","pwd01");
			
			db.insert(user);			//user가 바로 object로 들어간다 => 타입캐스팅되어서
			User userdb=db.select("");   //자동으로 타입캐스팅이 안되서
			
			
//			DB db2=new ProductDB(); //raw type 
			
			DB<Product,Integer> db2 = new ProductDB();
			db2.insert(new Product(190529,"T",10000));
			Product p = db2.select(200);
			p = new Product(190529,"pants",10000);
			System.out.println(p);
	}

}

// Product
package db3;

public class Product {
	int id;  //primary key
	String name;
	double price;
	
	
	
	public Product() {
	}
	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
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
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
}
//User
package db3;

public class User {
	
	
	String id;   // Primary key 제네릭의 키값
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

//DB
package db3;

public abstract class DB<T,U> {
	public abstract void insert(T obj);  //in
	public abstract T select(U obj);  //return
	
}

//ProductDB
package db3;

public class ProductDB extends DB<Product, Integer> {  // class,primary key

	@Override
	public void insert(Product obj) {
		System.out.println(obj.getId()+" "
				+obj.getName()+ " "+
				obj.getPrice()+" Inserted");
	}

	@Override
	public Product select(Integer obj) {
		Product p =null;
		System.out.println("Search:"+obj);
		p = new Product(200,"pants",10000);
		return p;
	}  //primary key를 참조한다

}

//UserDB
package db3;

public class UserDB extends DB<User, String> { // DB<int> x DB<integer> o

	@Override
	public void insert(User obj) {
		System.out.println(obj.getId()+ " "+obj.getName()+" Inserted");
	}

	@Override
	public User select(String obj) {
		
		return null;
	}
	
	
}


실행결과

id01 james Inserted
190529 T 10000.0 Inserted
Search:200
Product [id=190529, name=pants, price=10000.0]

```



