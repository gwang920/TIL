# Spring Framework 기반 Web Project

# 1) index.html

- TeamProject/web/index.html

```javascript
<script>
	location.href="index.mc";
</script>
```



```xml

 	 location.href '기능'
	 1) 현재 접속중인 페이지 정보를 갖는다.
            location.href; // 현재 페이지 확인
	 2) 값을 변경한다.(ex 다른 페이지로 이동)
	    location.href="이동할 페이지 주소"; // 페이지 이동
	--------------------------------------------------------------------------
        Servlet Mapping으로 2)를 구현한다.
	    Servlet Mapping 방법 두 가지
	    1 - web.xml (web/WEB-INF/web.xml)
	      
	      'web.xml' 파일에 경로를 설정하면 모든 파일에 적용된다.
	      => 다수의 요청을 받을 수 있게 url pattern으로 지정하는 것
	      
	      ex) 
	      
	      <servlet-mapping>
			<servlet-name>action</servlet-name>
			<url-pattern>*.mc</url-pattern>
	      </servlet-mapping>
	    
	    2 - 어노테이션 방법
	     가장 위 클래스 상단에 @WebServlet("/매핑명")으로 매핑한다.
	----------------------------------------------------------------------------     
	     
	그렇다면 Mapping을 해주는 이유는 무엇인가 ?
	1) 보안상에 있어 더 안전하다.
	
	full path : http://localhost:8080/프로젝트명/servlet/패키지명.클래스명		
	=> full path로 나타내면 패키지명이나 해당 파일의 경로가 노출된다. 보안에 취약하기에 매핑을 사용하자.
	
	2) 주소가 간결해진다.
	
	url 매핑 후 http://localhost:8080/프로젝트명/URL명
	=> 간결하게 표시 가능.
	
	* 참고 
	.html을 .mc로 매핑하는 이유는 ?
	
	html은 정적으로 web 어플리케이션을 구동할 수 없다. 
	따라서 동적으로 웹어플리케이션을 구동하기 위해 매핑을 해주고 프론트 컨트롤러에 이를 위임한다.
```



# 2) Mybatis

```xml
Mybatis는 관계형 데이터베이스 프로그래밍을 좀 더 쉽게 할 수 있게 도와주는 프레임워크이다.
JDBC를 이용하면 한 개의 클래스에 반복되는 코드가 존재하고, 한 파일에 JAVA,SQL 언어가 있어
재사용성이 떨어지고, 유지보수가 쉽지 않다는 단점이 있다.

MyBatis를 사용하는 이유
1) SQL 쿼리를 xml에 분리하여 관리할 수 있어 생산성이 증가하고, 반복처리 코드 없이 간결하게 사용 가능하다.
=> JDBC는 try~catch 처리, Statement, ResultSet의 데이터 처리를 하기 위해 많은 코드를 써야 한다.
2) SQL 수정시 프로그램 재 컴파일 없이 사용가능하다.
3) spring 과의 연동으로 자동화하여 처리 가능하다.
=> 객체와 sql 사이의 mapping을 도와준다.

~Mapper.xml <-> ~Mapper.java(인터페이스)

<mapper namespace="com.mapper.userMapper">
=> namespace 가 mapping 경로를 안내한다.
```

- TeamProject/src/config/userMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
PUBLIC "-//mybatis.org/DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.mapper.userMapper">

	
	<select id="select" parameterType="String" 
	resultType="User">
		SELECT * FROM W_USER WHERE ID=#{id}
	</select>
	
	<select id="selectall" 
	resultType="User">
		SELECT * FROM W_USER ORDER BY 1
	</select>
	<insert id="insert" parameterType="User">
		INSERT INTO W_USER VALUES (#{id},#{pwd},#{name},#{hint},#{hint_answer})
	</insert>
	<update id="update" parameterType="User">
		UPDATE W_USER SET PWD=#{pwd},NAME=#{name} WHERE ID=#{id}
	</update>
	<delete id="delete" parameterType="String">
		DELETE FROM W_USER WHERE ID=#{id}
	</delete>
	
</mapper>
```

- TeamProject/src/com/mapper/userMapper.java

```java
package com.mapper;

import java.util.ArrayList;
import com.vo.User;

public interface userMapper {
	public void insert(User obj);
	public void delete(String obj);
	public void update(User obj);
	public ArrayList<User> select(String obj);
	public ArrayList<User> selectall();
}
```

## Mybatis 설정

```xml
스프링에서 Mybatis를 사용하려면 Mybatis 라이브러리 추가가 필요하다.
(메이븐을 설정하면 자동으로 추가된다.)

pom.xml에 MyBatis를 사용하기 위해 추가해준다.

		<!-- MyBatis -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis</artifactId>
			<version>3.2.3</version>
		</dependency>

		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis-spring</artifactId>
			<version>1.2.2</version>
		</dependency>
```

## Mybatis 특징

```
1) SQL문이 자바 코드로부터 완전히 분리
2) 생산성 : SQL작업을 XML 파일에서만 수행하기 때문에 코드가 짧아 진다.
3) 유지보수성 향상

DAO는 XML에 있는 SQL만 가져다 쓰면된다. 즉, SQL 코드 변경 시 XML 파일을 제외한
나머지 파일들이 영향을 받지 않는다.
```



# 3) Frame

```java
Biz , Dao의 뼈대를 생성하자.
인터페이스 생성
```

- TeamProject/src/com/frame/ObjectBiz.java

```java
package com.frame;

import java.util.ArrayList;

public interface ObjectBiz<K,V> {
	public void insert(V v);
	public void delete(K k);
	public void update(V v);
	public ArrayList<V> select(K k);
	public ArrayList<V> selectAll();
}
```

- TeamProject/src/com/frame/ObjectDao.java

```java
package com.frame;

import java.util.ArrayList;

public interface ObjectDao<K,V> {
	public void insert(V v);
	public void delete(K k);
	public void update(V v);
	public ArrayList<V> select(K k);
	public ArrayList<V> selectAll();
}
```



# 4) Oracle - Mybatis

## 1) ojdbc, 커넥션풀 라이브러리 추가

```xml
pom.xml에 라이브러리 추가.
-----------------------------------------------------------------------------------------
	<!-- DBCP -->
		<dependency>
			<groupId>commons-dbcp</groupId>
			<artifactId>commons-dbcp</artifactId>
			<version>1.2.2</version>
		</dependency>
		<!-- <dependency> 
			<groupId>com.oracle</groupId> 
			<artifactId>ojdbc6</artifactId> 
			<version>11.2.0</version> 
		</dependency> -->
-----------------------------------------------------------------------------------------

ojdbc의 경우 maven에서 제공하지 않는 라이브러리이다.
따라서, dependency만 작성해주면 연동이 되지않는다.

ojdbc 다운을 위해 repository를 추가해주자.
-----------------------------------------------------------------------------------------
 <repository>
    <id>oracle</id>
    <name>Oracle JDBC Repository</name>
    <url>http://repo.spring.io/plugins-release/</url>
  </repository>
</repositories>
-----------------------------------------------------------------------------------------

* 커넥션풀 : db 커넥션을 미리 만들어놓고 요청이 들어오면 커넥션을 하나 씩 배정해 DB에 접속하는 시간을 줄여주는 역할
```

## 2) root-context.xml에 연동을 위해 추가

```xml
진행하는 메뉴추천시스템 프로젝트의 해당 xml : MySpring.xml
-----------------------------------------------------------------------------------------
<!-- 1. Database Setting -->
	<bean id="dataSource"
		class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName"
			value="oracle.jdbc.driver.OracleDriver" />
		<property name="url"
			value="jdbc:oracle:thin:@:1521:xe" />
		<property name="username" value="db" />
		<property name="password" value="db" />
	</bean>

	<!-- 2. Transaction Setting -->
	<bean id="txManager"
		class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource" />
	</bean>

	<!-- 3. MyBatis Setting -->
	<bean id="sqlSessionFactory"
		class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<property name="configLocation"
			value="classpath:com/config/mybatis.xml" />
	</bean>

	<!-- 4. Spring Mybatis Connect -->
	<bean id="sqlSessionTemplate"
		class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg ref="sqlSessionFactory" />
	</bean>

	<!-- 5. Mapper Setting -->
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property name="basePackage" value="com.mapper" />
	</bean>
-----------------------------------------------------------------------------------------
해당 내용을 추가해주자.


* 오류 발생 시
네임스페이스가 제대로 추가되지 않은 경우에 오류가 발생할 수 있다.
따라서, MySpring.xml을 켜고 하단에 Namespaces탭을 클릭하고, mybatis-spring을 체크하고 저장하자.
```

## 3) MVC모델 설계

```
MVC모델에 맞게 프레임을 구성하자.


food(DTO)를 객체로 요청되는 과정

controller -> FoodBiz -> FoodDao -> FoodMapper.java(인터페이스) -> FoodMapper.xml -> db
						 [food(vo)객체 전달]
```

### 1- Mapper 인터페이스

- TeamProject/src/com.mapper/foodMapper.java

```java
package com.mapper;

import java.util.ArrayList;

import com.vo.Food;

public interface foodMapper {
	public void insert(Food v);
	public void delete(String k);
	public void update(Food v);
	public ArrayList<Food> select(String id);
	public ArrayList<Food> selectall();
}
```

### 2- Mapper xml 

- TeamProject/src/com.config/foodMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
PUBLIC "-//mybatis.org/DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.mapper.foodMapper">
	<!-- namespace 주소가 인터페이스 경로와 일치해야한다. -->
    
	<select id="select" parameterType="String"
	resultType="food">
		select food.* from food
		where food.id not in( 
			select food_id 
			from (select * from preference union select * from ignore)
			where user_id=#{id})
	</select>
	<select id="selectall" 
	resultType="food">
		SELECT * FROM food ORDER BY 1
	</select>
	<insert id="insert" parameterType="food">
		INSERT INTO food VALUES (seq_food.nextval,#{name},#{imgName1},#{imgName2},#{imgName3},#{category})
	</insert>
	<update id="update" parameterType="food">
		UPDATE food SET NAME=#{name},CATEGORY=#{category},IMGNAME1=#{imgName1 },IMGNAME2=#{imgName2 },IMGNAME3=#{imgName3 } WHERE ID=#{id}
	</update>
	<delete id="delete" parameterType="String">
		DELETE FROM food WHERE ID=#{id}
	</delete>
</mapper>
```

### 3- Mapper.xml을 Mybatis.xml에 추가

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration
PUBLIC "-//mybatis.org/DTD Config 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
	<typeAliases>
		<typeAlias type="com.vo.User" alias="user"/>
		<typeAlias type="com.vo.Board" alias="board"/>
		<typeAlias type="com.vo.Food" alias="food"/>
	</typeAliases>
	
	<mappers>
		<mapper resource="com/config/boardMapper.xml"/>
		<mapper resource="com/config/categoryMapper.xml"/>
		<mapper resource="com/config/foodMapper.xml"/>  <!-- 추가 -->
		<mapper resource="com/config/hintMapper.xml"/>
		<mapper resource="com/config/ignoreMapper.xml"/>
		<mapper resource="com/config/preferenceMapper.xml"/>
		<mapper resource="com/config/userMapper.xml"/>
	</mappers>
</configuration>
```

### 4- Controller

```
기본적인 흐름
- 클라이언트가 요청하면 @Controller에 진입한다. 
  컨트롤러는 요청에 대한 작업을 수행한다.
  뷰쪽으로 데이터를 전달한다.

- MainController
- UserController
- MenuController

```

- TeamProject/src/com/controller/MainController.java

```java
package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	// index.html -> index.mc(url-pattern) -> @Controller -> @RequestMapping -> mv return
	@RequestMapping("/index.mc")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/error.mc")
	public ModelAndView error() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("view/error");
		return mv;
		
	}
}
```

- MainController 동작 과정

```xml
1) 메인페이지에 접근한다.(index.html)
2) url-pattern으로 변경된다. => index.mc
3) @Controller가 사용자의 요청을 가로챈다.
4) @RequestMapping의 요청경로에 따라 요청을 매핑한다.
    
    @RequestMapping("path")
   요청경로 path는 view가 존재하는 경로이다.
   => /index.jsp
   
5) mv(뷰 페이지 이름)를 반환한다.
```



- TeamProject/src/com/controller/MenuController.java

```java
package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frame.ObjectBiz;
import com.frame.StringBiz;
import com.mapper.preferenceMapper;
import com.vo.Food;

@Controller
public class MenuController {

	@RequestMapping(value="/menu_add_table_add_list.mc", produces="application/text; charset=utf8")
	@ResponseBody
	public String addMenuList(@RequestParam("id") String id) {
		ObjectMapper obm = new ObjectMapper();
		AbstractApplicationContext factory = new GenericXmlApplicationContext("MySpring.xml");
		ObjectBiz<String,Food> foodList = (ObjectBiz<String, Food>)factory.getBean("FoodBiz");
		String val ="fail";
		
		try {
			if(id == "") val = obm.writeValueAsString(foodList.selectAll());
			else val = obm.writeValueAsString(foodList.select(id));
			System.out.println(val);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return val;
	}
	@Autowired
	preferenceMapper pm;
	
	
	@RequestMapping(value="/add_pre_roullet.mc",  produces="application/text; charset=utf8")
	@ResponseBody
	public String addPreInRoullet(@RequestParam("id") String id) {
		
		ObjectMapper obm = new ObjectMapper();
		AbstractApplicationContext factory = new GenericXmlApplicationContext("MySpring.xml");
		StringBiz<String,String> preBiz = (StringBiz<String,String>)factory.getBean("PreferenceBiz");
		String val ="fail";

		try {
			val = obm.writeValueAsString(pm.selectById(id));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return val;
	}
	
	@RequestMapping("AddPre.mc")
	@ResponseBody
	public String addPreTable(@RequestParam("id") String id,@RequestParam("name") String name) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("MySpring.xml");
		StringBiz<String, String> PreBiz = (StringBiz<String, String>)factory.getBean("PreferenceBiz");
		try {
			PreBiz.insert(id, name);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
	
	@RequestMapping("AddIgnore.mc")
	@ResponseBody
	public String addIgnTable(@RequestParam("id") String id,@RequestParam("name") String name) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("MySpring.xml");

		StringBiz<String,String> IgnBiz = (StringBiz<String,String>)factory.getBean("IgnoreBiz");
		try {
			IgnBiz.insert(id, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
	
}
```

```
@ResponseBody
```

### 5- Biz

```

```



###  6- Dao

```

```



# 메뉴 선정 로직

![image](https://user-images.githubusercontent.com/49560745/99873926-e8243b00-2c26-11eb-943f-137ccb51b2c9.png)

````
* 클라이언트 요청 흐름

예) food(DTO)를 객체로 요청되는 과정

								[food(vo)객체 전달]
사용자 요청 ->(1)controller ->(2)FoodBiz ->(2)FoodDao ->(3)FoodMapper.java(인터페이스) ->(4)Mybatis.xml ->(5)FoodMapper.xml -> db
````



![image](https://user-images.githubusercontent.com/49560745/99871736-47cb1800-2c20-11eb-99ec-1704fdd94cef.png)

## 1) 메뉴 추가

````
1. 추가 버튼 
 1-1. 메뉴 데이터 불러오기(preference 테이블, ignore 테이블에 존재하지 않는 Food 테이블의 메뉴데이터 불러오기)

 1-2. AJAX 요청으로 비동기 데이터 로드
 1-3. 메뉴를 클릭하면 preference 테이블에 insert(url : Addpre.mc) / 메뉴 데이터 삭제(클라이언트 화면)
````



## 2) 메뉴 삭제

```
1. 삭제 버튼
 1-1. 메뉴 데이터 불러오기(preference 테이블의 메뉴 데이터 불러오기)
 1-2. AJAX 요청으로 비동기 데이터 로드
 1-3. 메뉴를 클릭하면 preference 테이블의 메뉴 데이터 delete / 메뉴 데이터 삭제(클라이언트 화면)
```

![image](https://user-images.githubusercontent.com/49560745/99872080-8bbf1c80-2c22-11eb-8557-95ac23432a83.png)



## 3) 룰렛 Page로 이동

```
1. 룰렛돌리기 버튼
 1-1. 룰렛 생성(preference 테이블 데이터를 룰렛 세그먼트에 삽입)
 1-2. 페이지 이동(스크롤 다운)
```

## 4) 룰렛 돌리기

```
1. 룰렛 화살표 버튼
 1-1. 선정된 메뉴에 해당하는 이미지 출력 
  Imgname과 일치하는 로컬에 저장된 사진 파일이름 출력

2. reset 버튼
 2-1. 룰렛 초기화
 
3. 검색하기 버튼
 3-1. 선정된 메뉴가 Kakao Api로 전달되고, 위치 검색 기능 도입
 사용자가 검색한 위치에 선정된 메뉴를 판매하는 모든 식당을 list 화
```







```
controller -> biz -> dao -> 마이바티스-mapper -> db
				vo 객체로 데이터 전달!
		
mapper -> BoardMapper 인터페이스 -> BoardMapper.xml -> viewAll



Bean이란?
쉽게 말해 스프링 빈은 자바 객체를 뜻한다.
스프링 컨테이너에 의해서 자바 객체가 만들어지게 되면 
이 객체를 스프링은 스프링 빈이라고 부르는 것이다.
일반 자바 객체와 스프링 빈의 차이점은 없다고 한다!

@Autowired
쉽게 의존성을 주입하는 어노테이션
(@Autowired 어노테이션을 사용하지 않으면 의존성 주입을 위해
XML파일에 Bean설정을 해주어야한다. 
그렇기에 의존성 주입을 간단한 방법으로 하고자 하는게 @Autowired이다. 
@Autowired 어노테이션은 자동으로 의존성을 주입해준다.)

```



# DAO vs DTO vs VO

```
DB,DAO,DTO의 차이를 쉽게 비유한 내용을 가져왔다.
-----------------------------------------------------------------------------------------
DB : 데이터 줄게
DAO : 일일이 담기 귀찮다. 딱 맞는 바구니에 담을 수 없을까?
DTO : 아 유레카! 주는 데이터에 맞춰서 데이터 형식들을 만들어 놓은
클래스를 만들어야겠군 이름은 DTO라고 불러야겠다.
-----------------------------------------------------------------------------------------
DB 값 → DAO → Service → DTO

* 출처
https://java119.tistory.com/31
```

## DAO

```
Database Access Object의 약자로서 데이터베이스의 data에 접근하기 위한 객체
DB 접근을 위한 로직과 비즈니스 로직을 분리하기 위해 사용
```

- DAO 예제

```JAVA
package com.food;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.frame.ObjectDao;
import com.mapper.foodMapper;
import com.vo.Food;


@Component("FoodDao")
public class foodDao implements ObjectDao<String, Food> {

	@Autowired
	foodMapper fm;
	// foodDao 클래스는 fm을 참조한다.
    // Autowired를 사용하는 클래스는 @Component로 명시해줘야한다.
	
	@Override
	public void insert(Food v) {
		// TODO Auto-generated method stub
		fm.insert(v);
	}

	@Override
	public void delete(String k) {
		// TODO Auto-generated method stub
		fm.delete(k);
	}

	@Override
	public void update(Food v) {
		// TODO Auto-generated method stub
		fm.update(v);
	}

	@Override
	public ArrayList<Food> select(String k) {
		// TODO Auto-generated method stub
		System.out.println(k+" in food Dao");
		return fm.select(k);
	}
	
	@Override
	public ArrayList<Food> selectAll() {
		// TODO Auto-generated method stub
		
		return fm.selectall();
	}
}
```

## DTO

```
Data Transfer Objetc의 약자로서 계층간 데이터 교환을 위한 자바빈즈이다.
여기서 말하는 계층간의 의미는 Controller,view,Businesslayer 등을 말하며 각 계층간
데이터 교환을 위한 객체를 의미한다.
즉, DTO는 로직을 가지지 않는 순수한 데이터 객체이며 getter setter만을 갖는 클래스이다.

* 자바빈(JavaBean)이란 
JavaBean규격서에 따라 작성된 자바클래스
```

- DTO 예제

```java
package com.vo;

public class Food {
	int id;
	String name;
	String imgName1;
	String imgName2;
	String imgName3;
	String category;
	public Food() {
		super();
	}
	public Food(int id, String name, String imgName1, String imgName2, String imgName3, String category) {
		super();
		this.id = id;
		this.name = name;
		this.imgName1 = imgName1;
		this.imgName2 = imgName2;
		this.imgName3 = imgName3;
		this.category = category;
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
	public String getImgName1() {
		return imgName1;
	}
	public void setImgName1(String imgName1) {
		this.imgName1 = imgName1;
	}
	public String getImgName2() {
		return imgName2;
	}
	public void setImgName2(String imgName2) {
		this.imgName2 = imgName2;
	}
	public String getImgName3() {
		return imgName3;
	}
	public void setImgName3(String imgName3) {
		this.imgName3 = imgName3;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", imgName1=" + imgName1 + ", imgName2=" + imgName2 + ", imgName3="
				+ imgName3 + ", category=" + category + "]";
	}
}
```

## * 프로퍼티 - 깔끔하게 정리하기

```
setter/getter 에서 set과 get 이후에 나오는 단어가 property이다. 
그래서 위 클래스에서 프로퍼티는 Id, Name 등등 이다.
그렇기 때문에 메소드의 멤버변수는 아무렇게 지어도 영향없이
getter,setter로 프로퍼티를 표현한다!
-----------------------------------------------------------------------------------------

setImgName3 => 프로퍼티 : ImgName3
setName => 프로퍼티 : Name

-----------------------------------------------------------------------------------------

자바는 다양한 프레임워크에서 데이터 자동화처리를 위해 리플렉션 기법을 사용하는데, 데이터 자동화 처리에서 제일 중요한 것은 표준규격입니다. 예를들어 윗 클래스 DTO에서 property가 name, age라면 name, age의 키값으로 들어온 데이터는 리플렉션 기법으로 setter를 실행시켜 데이터를 넣을 수 있습니다. 
중요한 것은, 우리가 setter를 요청하는 것이 아닌 프레임워크 내부에서 setter가 실행된다는 점입니다.(눈에 보이지않음) 

그래서 layer간(특히 서버 -> View로 이동 등)에 데이터를 넘길때에는 DTO를 쓰면 편하다는 것이 이런이유 때문입니다. View에 있는 form에서 name 필드 값을 프로퍼티에 맞춰 넘겼을 때, 받아야 하는 곳에서는 일일히 처리하는 것이 아니라 name속성의 이름이랑 매칭되는 프로퍼티에 자동적으로 DTO가 인스턴스화 되어 PersonDTO를 자료형으로 값을 받을 수 있습니다. 그래서 key-value 로 존재하는 데이터는 자동화 처리된 DTO로 변환되어 쉽게 데이터가 셋팅된 오브젝트를 받을 수 있습니다.

출처: https://lemontia.tistory.com/591 [side impact]
```

## VO

```
Value Object는 DTO와 혼용해서 사용하지만 미묘한 차이가 있다!

DTO와 VO의 공통점은 넣어진 데이터를 getter를 통해 사용하므로 주 목적은 같다. 
그러나 DTO의 경우는 가변의 성격을 가진 클래스 이다(setter 활용). 
그에반해 VO는 불변의 성격을 가졌다는 차이점이 있다.(readOnly-getter 기능만 존재)

즉, 쉽게 보면 DTO : GET/SET
			VO : GET
```



# 문제점 및 보완점

```
1) vo에 setter가 존재한다.
2) AOP를 적극 활용한 로직을 크게 찾아보기는 힘들다.
3) 게시판 기능 / 댓글 기능
4) 메뉴 이미지 파일 DB에 저장
```





# MenuController.java

```java
package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frame.ObjectBiz;
import com.frame.StringBiz;
import com.mapper.preferenceMapper;
import com.vo.Food;

@Controller
public class MenuController {

	@RequestMapping(value="/menu_add_table_add_list.mc", produces="application/text; charset=utf8")
	@ResponseBody
	public String addMenuList(@RequestParam("id") String id) {
		ObjectMapper obm = new ObjectMapper();
		AbstractApplicationContext factory = new GenericXmlApplicationContext("MySpring.xml");
		ObjectBiz<String,Food> foodList = (ObjectBiz<String, Food>)factory.getBean("FoodBiz");
		String val ="fail";
		
		try {
			if(id == "") val = obm.writeValueAsString(foodList.selectAll());
			else val = obm.writeValueAsString(foodList.select(id));
			System.out.println(val);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return val;
	}
	@Autowired
	preferenceMapper pm;
	
	@RequestMapping(value="/add_pre_roullet.mc",  produces="application/text; charset=utf8")
	@ResponseBody
	public String addPreInRoullet(@RequestParam("id") String id) {
		
		ObjectMapper obm = new ObjectMapper();
		AbstractApplicationContext factory = new GenericXmlApplicationContext("MySpring.xml");
		StringBiz<String,String> preBiz = (StringBiz<String,String>)factory.getBean("PreferenceBiz");
		String val ="fail";

		try {
			val = obm.writeValueAsString(pm.selectById(id));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return val;
	}
	
	@RequestMapping("AddPre.mc")
	@ResponseBody
	public String addPreTable(@RequestParam("id") String id,@RequestParam("name") String name) {
		
//		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("MySpring.xml");
		StringBiz<String, String> PreBiz = (StringBiz<String, String>)factory.getBean("PreferenceBiz");
		try {
			PreBiz.insert(id, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
	
	@RequestMapping("AddIgnore.mc")
	@ResponseBody
	public String addIgnTable(@RequestParam("id") String id,@RequestParam("name") String name) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("MySpring.xml");

		StringBiz<String,String> IgnBiz = (StringBiz<String,String>)factory.getBean("IgnoreBiz");
		try {
			IgnBiz.insert(id, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
}

```



````java
위 코드를 차례로 살펴보자.

1) @RequestMapping

@RequestMapping 컨트롤러로부터 url을 전달받을 수 있다.
Url당 하나의 컨트롤러에 매핑 되던 다른 핸들러 매핑과 달리 메서드까지 세분화하여 적용할 수 있다.
파라미터, 헤더 등 더 넓은 범위를 적용할 수도 있다.
produces는 content-type을 설정하기 위함이다.
produces의 디폴트 값은 charset=ISO-8859-1이다.
위 타입은 한글이 ?? 으로 출력되는 문제가 생길 수 있다.
utf8로 설정해주자.


2) @ ResponseBody

위 어노테이션이 설정되어있으면 메소드에서 리턴되는 값은 View를 통해서 출력되지않고, HTTP ResponseBody에 직접 쓰여지게된다.


 * Http 통신 방식
 1) HyperText Transfer Protocol
 
 HTML 문서를 교환하기 위한 통신규약
 서버<->클라이언트
 프론트엔드<->백엔드
 
 HTTP는 TCP/IP기반
 
 2) 통신방식
 클라이언트가 HTTP Request를 보내면 HTTP Response를 보내는 구조
 stateless하다
 
 3) HTTP Request 구조
 - start line
 - headers
 - body
 
 3-1) start line
 start line 또한 3부분으로 구성되어있다.
 
 예시) GET/ Search HTTP/1.1
 
  - HTTP Method
  해당 request가 의도한 action을 정의하는 부분
  get post put delete options 등이 있다.
  주로 get post가 사용됨
  
  - Request target 
  해당 request가 전송되는 목표 uri
  
  - HTTP version
  말 그대로 http의 버전이다.
  
  3-2) headers
  해당 request에 대한 추가 정보(addtional information)를 담고 있는 부분.
  예를 들어, request 메세지 body의 총 길이 (Content-Length), HOST(www.google.com) 등.
  
  3-3) body
  해당 request의 실제 메세지/내용
  
  
  * http 구조 예시
  
  POST /payment-sync HTTP/1.1

Accept: application/json
Accept-Encoding: gzip, deflate
Connection: keep-alive
Content-Length: 83
Content-Type: application/json
Host: intropython.com
User-Agent: HTTPie/0.9.3

{
    "imp_uid": "imp_1234567890",
    "merchant_uid": "order_id_8237352",
    "status": "paid"
}


클라이언트에서 서버로 필요한 데이터를 전송하기 위해서 JSON이라는 데이터를 요청 본문에 담아서 서버로 보내면, 서버에서는 @RequestBody 어노테이션을 사용하여 HTTP 요청 본문에 담긴 값들을 자바 객체로 변환 시켜, 객체에 저장시킵니다.
    
    
서버에서 클라이언트로 응답 데이터를 전송하기 위해서 @ResponseBody 를 사용하여 자바 객체를 HTTP 응답 본문의 객체로 변환하여 클라이언트로 전송시키는 역할을 합니다.
    
    
비동기 통신을 하기위해서 클라이언트가 서버로 요청 메시지의 본문에 데이터를 담아서 보내야하며, 서버도 클라이언트로 응답을 보내기 위해서는 응답 메시지의 본문에 데이터를 담아서 보내야 합니다.
    
    
json
xml을 능가하는 데이터 포맷
자료의 종류에 큰 제한이 없다.
프로그램의 변수값을 표현하는데 효과적이다.
    
key:value 쌍
        
만드는 방식에 제한이 없다.
````



```
https://offbyone.tistory.com/16
프로젝트 버전 변경시
```



# KAKAO API

```
			<link rel="stylesheet" href="view/css/kakaoMap.css">
			
			<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f0d6e6a070335aaa5e70c85e9c45b206&libraries=services"></script>

			
			<script type="text/javascript" src="view/js/kakaoMap_geolocation.js"></script>
			<script type="text/javascript" src="view/js/kakaoMap_request.js"></script>
			
			
			
							var mapContainer = document.getElementById('map'), // 지도를 표시할 div
				mapOption = {
					center : new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
					// center: new kakao.maps.LatLng(35.233446, 127.650310), // 지도의 중심좌표
					level : 3
				// 지도의 확대 레벨
				};

				// 지도를 생성합니다 
				map = new kakao.maps.Map(mapContainer, mapOption);
				// 장소 검색 객체를 생성합니다
				ps = new kakao.maps.services.Places();
				// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
				infowindow = new kakao.maps.InfoWindow({
					zIndex : 1
				});

				userPosition = {};
				markers = [];
```



# IOC/DI

```
스피링의 대삼각형

IOC/DI/AOP/PSA

IOC/DI

스프링 프레임워크의 근간
오브젝트의 생명주기와 의존관계에 대한 프로그래밍 모델
유연하고 확장성이 뛰어난 코드를 만들 수 있게 해주는 프로그래밍 모델

-by 토비의 스프링

유연하고 확장성이 뛰어나다
=> 변경이 있을 때 수정이 쉽다
=> 수정할 부분만 수정하면 된다
= 관심사의 분리가 잘 이루어져있다.


AOP
관심사를 기준으로 관점지향적인 프로그래밍

부가기능 인프라로직

- 애플리케이션 전 영역에서 나타날 수 있음
- 중복코드를 만들어낼 가능성 때문에 유지보수가 힘들어짐
- 비즈니스 로직과 함께 있으면 비즈니스 로직을 이해하기 어려워짐

------------------------------------> 횡단 관심사
			  권한체크		  권한체크
성능검사		성능검사		성능검사
 로깅		  	   로깅			로깅
브즈니스로직	   비즈니스로직 	  비즈니스로직
성능검사		 성능검사		 성능검사

*로그인기능		*글작성기능		*글삭제기능

다양한 AOP 구현방법
1) 컴파일
2) 바이트코드조작
3) 프록시패턴 (Spring AOP)

```





```
.p_add (추가) => 
```

