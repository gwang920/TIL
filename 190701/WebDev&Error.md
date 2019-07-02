# 웹 개발환경 구축하기

### eclipse / jdk 설정



##### 1) Server Download

Window -> Preferences -> Server -> Runtime Environment

->  Add -> Apche Tomcat 버전선택 -> browse(톰캣경로)



```
* 참고 : https://opensrc.tistory.com/180
```



##### 2) java build path

properties -> Java Build Path -> Add Library -> Tomcat



##### 3) Tomcat 에러 

#####  - Several ports(8005,8080,8009) required by Tomcat v9.0

- Tomcat이 사용하고 있는 기본 포트(8080,8009,8005)가 이미 사용중이라 생기는 오류

![캡쳐1](C:\Users\student\TIL\img\캡쳐1.PNG)

```
cmd창에 
명령어 입력 : netstat -p tcp -ano 

포트에 연결된 pid 를 확인할 수 있다

```

![캡처](C:\Users\student\TIL\img\캡처.PNG)

```
Tomcat이 사용하는 기본 포트는 0.0.0.0:8080, 0.0.0.0:8009와 127,0,0,1:8005이다.

0.0.0.0:8080의 PID 번호 4520을 삭제해주자

명령어 입력 : taskkill /f /pid 4520

```



#####  - HTTP 상태 404 ( tomcat 호출시 ) error

- 톰켓의 work폴더 삭제 하고 다시 실행하기



#####  - Starting Tomcat v9.0 Server at localhost

- servlet의 이름이 중복되어 생기는 오류

  ​

![캡처123](C:\Users\student\TIL\img\캡처123.PNG)



```
@WebServlet({ "/ProductServlet", "/product" }) 

@WebServlet({ "/ProductServlet", "/product" }) s

수정

@WebServlet({ "/ProductServlet", "/product" }) 

@WebServlet({ "/UserServlet", "/User" }) s

```

​






window -> preferences -> general -> workspace -> refresh