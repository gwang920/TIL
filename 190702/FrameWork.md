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

POJO  : 일반적인 자바 클래스



- 순방향
  - APP -> STV / LTV 
- IOC 흐름
  - APP -> container -> STV / LTV   app이 container에게 요청하면
  - APP<-(STV/LTV) container          container가 stv ltv 전달해줌



```
1 - Spring Project Setting

1. Make Project
2. Spring Nature
3. maven(Add Spring Library) 
   - pom.xml(List up Library)  (pom.xml을 넣고 update)
   - Download Library

configure -> maven project

pom.xml에 필요한 파일을 코드로 작성하면 다운로드를 실행한다

- 서버가 끊기면 .m2를 다시 삭제하고 다시 실행하자

설치 끝나면 프로젝트 우클릭 -> maven -> maven update


```



```
참고

src는 classpath 모든 path가 거쳐간다

singleton 호출할때마다 하나씩 생겨라

의존성관리

의존성 주입은 xml로 한다

```



```
2 - Spring Ioc


```





