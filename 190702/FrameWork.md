# I. 프레임워크

- 뼈대 혹은 틀로서 소프트웨어 관점에서 접근하면 아키텍처에 해당하는 골격 코드
- 특징
  - 검증된 아키텍처로서 재사용성과 일관성 유지
  - 쉬운 관리
  - 개발자들의 역량 획일화
  - 빠른 구현 시간



#####  프레임워크 장점

- LightWeight
  - 경량
- IOC(Inversion of Control)
  - 제어의 역행
    - 객체 간의 느슨한 결합, 즉 낮은 결합도를 유지한다
- AOP(Aspect Oriented Programming)
  - 관점지향 프로그래밍 
    - 각 비즈니스 메소드마다 반복해서 등장하는 공통 로직을 분리함으로써 응집도가 높게 개발할 수 있다



##### 



##### 1) Spring 환경 설정 (SpringSet.md 참고)


```
1 - Spring Project Setting

1) Make Project
2) Spring Nature
3) maven(Add Spring Library) 
   - pom.xml(List up Library)  (pom.xml을 넣고 update)
   - Download Library

configure -> maven project

pom.xml에 필요한 파일을 코드로 작성하면 다운로드를 실행한다

- 서버가 끊기면 .m2를 다시 삭제하고 다시 실행하자

설치 끝나면 프로젝트 우클릭 -> maven -> maven update


```



```
참고

- src는 classpath 모든 path가 거쳐간다

- singleton 호출할때마다 하나씩 생겨라

- 의존성관리

- 의존성 주입은 xml로 한다

```



##### 2) IOC

- 순방향 흐름
  - APP -> STV / LTV 
- IOC 흐름
  - APP -> container -> STV / LTV   app이 container에게 요청하면
  - APP<-(STV/LTV) container          container가 stv ltv 전달해줌



```
2 - Spring Ioc(Inversion Of Control)

1) XML
2) Annotation

```





```
3 - Spring AOP(Aspect Oriented Programming)

1) XML
2) Annotation
```



##### 3) AOP 

##### AOP 용어

##### 조인포인트(Joinpoint)

- - 클아이어트가 호출하는 모든 비즈니스 메소드


- 포인트컷(Pointcut)
  - 필터링된 조인포인트
- 어드바이스

##### * 어드바이스 동작시점

```
Before - 함수가 시작되기이전에

After Returning - 함수가 다끝난다음에 동작

After Throwing - 예외가 발생하는 시점에서 동작

Around - 함수 시작 전/후에 모두 동작

```

```xml
<context:component-scan base-package="com.*"/>  - > com. 으로 시작하는 package를 scan한다
	
	<bean id="log" class="com.frame.LogAdvice"/>    
	
	<aop:config>  - > aop를 적용
	   <aop:pointcut expression="execution(* com..Biz+.select(..))" id="id01"/>
	
	   <aop:aspect ref="log"> -> id:log의 class의 method=""을 pointcut-ref=""에 적용하겠다
			<aop:before pointcut-ref="id01" method="printLog"/>   -> 
			<aop:after-returning pointcut-ref="id01" method="exLog"/> 
		</aop:aspect>
	</aop:config>
	
```





```
4 - Spring JDBC , ORM(Mybatis)
```

