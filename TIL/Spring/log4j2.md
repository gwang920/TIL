





	<filter-mapping>
		<filter-name>enc</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping> 어떻게 들어오든간에 utf 8로 바꿔라
	
	
	  <servlet>
			<servlet-name>action</servlet-name>  서블렛 이름
			<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>   // spring에서 제공해주는 서블렛
	
			<init-param>  서버가 start가 되면서 설정해주는 것
				<param-name>contextConfigLocation</param-name>			<param-		value>/WEB-INF/config/spring.xml</param-value>   
			</init-param>
		</servlet>
	
	







```
-- Log4j

1. web.xml
listener 추가 

<listener>
  	<listener-class>org.springframework.web.util.Log4jConfigListener</listener-class>
  </listener> 
  <context-param>
  	<param-name>log4jConfigLocation</param-name>
  	<param-value>/WEB-INF/config/log4j.properties</param-value>
  </context-param>
  
  
  
  
	<listener>
		<listener-class>org.springframework.web.util.Log4jConfigListener</listener-class>
	</listener>
	<context-param>
		<param-name>log4jConfigLocation</param-name>
		<param-value>/WEB-INF/config/log4j.properties</param-value>
	</context-param>
  
  
2. log4j.properties
WEB-INF -> config 에 paste


3. spring.xml 에 추가
<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
4. Logger.java 
- AOP 로 생성



-- Exception
1. web.xml 수정

	<!-- 무언가가 요청이 들어올 때 환경설정 -->
	<listener>
  	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
  
  <context-param>
  	<param-name>contextConfigLocation</param-name>
  	<param-value>/WEB-INF/config/springex.xml</param-value>
  </context-param>
  
2. springex.xml을 config에 추가하자


<!-- exception(key=)이 일어나면 error page를 띄워줄래 -->
 	<bean id="exeptionResolver" 
 	class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
 		<property name="exceptionMappings">
 			<props>
 				<prop key="java.lang.ArithmeticException">
 					error
 				</prop>
 			</props>
 		</property>
 	</bean>
 	
 	
 	key=" "      // 실제 에러페이지의 에러 name
 	
 3. error.jsp 생성
 
 <prop>
   error  == jsp name
 <prop>
 
 
 
 어떤 로그를 찍어서 어떻게 분석할 것이냐
 
 
 linux 내에 적용   (디렉토리 생성해서 linux내에서 생성되도록)
 
 가상의 error page 
 
 
 
 
 
 * root 설정
 
 프로젝트 -> properties -> web project setting -> context root 변경

```

