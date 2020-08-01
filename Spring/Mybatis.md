# Mybatis 프레임워크

- 프레임은 단순한 골격 (프레임워크와 분류)
- 프레임워크 : 프레임 + 기능 (IOC / AOP )



##### Mybatis 프레임워크특징

- 오픈소스

- SQL 명령어를 자바 코드에서 분리하여 xml파일에서 관리

- 한두 줄의 자바코드로 DB연동 처리

  ​

- 메커니즘



```
- index.html ->  main.mc  ->  servlet -> Controller 에서 main을 보내고 jsp를 spring.xml에 의해 입혀준다 -> main.jsp

- main.mc 는 servlet이동을 위해 존재
```



```
----- web.xml

<servlet>
		<servlet-name>action</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/config/spring.xml</param-value>
		</init-param>
	</servlet>

<servlet-mapping>
		<servlet-name>action</servlet-name>
		<url-pattern>*.mc</url-pattern>
	</servlet-mapping>
	
	
	에 의해 이동 .mc로
	
	----spring.xml
	
	<bean id="viewResolver"
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/view/" />
		<property name="suffix" value=".jsp" />
		<property name="order" value="0" />
	</bean>
```