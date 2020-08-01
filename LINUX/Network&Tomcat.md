네트워크 구조도

```
스위치 : 분배기
DNS서버 : 전세계의 정보(ip)를 가져와 저장
라우터 : 길잡이 역할 -> 들어온 정보를 어디로 보내줄 것인가
GATEWAY : 컴퓨터 네트워크에서 서로 다른 통신망, 프로토콜을 사용하는 네트워크 간의 통신을 가능하게 하는 컴퓨터나 소프트웨어

카카오톡 : 메세지 기반(송신자가 전송하면 HTTP로 메세지가 전송되고, 수신자는 HTTP를 통해 메시지를 받아감) 
NETWORK가 서로 접속 된 것이 아니다

* 채팅은 서버의 자원이 필요하다

HTS 주식 - 실시간 CONNECT

workspace  ex) 쇼핑몰의 테이블을 담을 공간

```



1) Naver와 연결하기 위한 Network 구성도

2) 다른 건물의 임의의 사용자와 채팅을 위한 Network 구성도

![네트워크구성도](https://user-images.githubusercontent.com/49560745/61841854-1974e580-aed1-11e9-9fd1-ffa993ab885a.PNG)



Tomcat - Web

```
- java에서 jsp파일 생성
- jsp 생성시 Context root 를 '/' 로지정 => ip 주소만 입력해도 자동으로 page가 로드 된다
/ == ROOT
(http://70.12.114.55/ 만 입력해도 로드 가능!)
- export 하자
  war file로 export , linux내의 file에 paste
	
  ps -ef | grep oracle   
  // 대상 프로세스(oracle)를 조회한다(상태표시 on이냐 off냐 등등)

  829  cd apache-tomcat-9.0.22/
  830  cd webapps/
  831  ls
  832  cp ~/file/test2.war .  // user의 홈폴더아래 test2.war를 복사해온다
  833  ls
  834  mv ROOT ROOT_BACK     
  // ROOT(최초의 TOMCAT 홈페이지)의 이름 변경 war file의 /(ROOT)와 중첩되므로
  835  ls
  836  cd bin
  840  shutdown.sh        
  841  startup.sh           // restart해도 웹 로드가 되지 않는다
  842  cd webapps/
  843  cd ..
  844  cd webapps/
  845  mv test2 ROOT       // 이름을 변경하고 실행하면 로드가 된다
  
  http://192.168.111.100/    // 리눅스 내의 ip

```



yum -y localinstall ora~

service oracle-xe configure

 default로 설정하고 비밀번호만 설정하자







70.12.114.190~ 사용가능



ip:70.12.114.200

netmask:255.255.255.0

gateway:70.12.114.1

dns1:168.126.63.1



200 web 201 db