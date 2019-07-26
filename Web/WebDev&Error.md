# 웹 개발환경 구축하기 & 에러

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

![tcp](https://user-images.githubusercontent.com/49560745/61844314-f00c8780-aed9-11e9-9533-61ea17bef39a.png)



```
cmd창에 
명령어 입력 : netstat -p tcp -ano 

포트에 연결된 pid 를 확인할 수 있다

```

![pid4520](https://user-images.githubusercontent.com/49560745/61844301-e7b44c80-aed9-11e9-9627-e72113036ed3.png)





```
Tomcat이 사용하는 기본 포트는 0.0.0.0:8080, 0.0.0.0:8009와 127,0,0,1:8005이다.

0.0.0.0:8080의 PID 번호 4520을 삭제해주자

명령어 입력 : taskkill /f /pid 4520

```



#####  - HTTP 상태 404 ( tomcat 호출시 ) error

- 톰켓의 work폴더 삭제 하고 다시 실행하기



#####  - Starting Tomcat v9.0 Server at localhost

- servlet의 이름이 중복되어 생기는 오류

  

![tomcat9 0](https://user-images.githubusercontent.com/49560745/61844160-6a88d780-aed9-11e9-95d3-11b9e5fff094.png)



```
@WebServlet({ "/ProductServlet", "/product" }) 

@WebServlet({ "/ProductServlet", "/product" }) s

수정

@WebServlet({ "/ProductServlet", "/product" }) 

@WebServlet({ "/UserServlet", "/User" }) s

```



1) window -> preferences -> general -> workspace -> refresh

2) window -> preferences -> server -> Runtim Enviroments에서 

TOMCAT 삭제하고 다시 넣기