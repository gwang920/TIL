# Linux



리눅스 배경

```
- unix : 비싸다 / 접근제한이있다 

리눅스가 발전해서 windows가 된 것

리눅스 + 창문 = windows

리눅스 - 빅 데이터 환경을 구성하기 위해


- 빅데이터 환경

여러대의 컴퓨터로 빅데이터 환경 구축

조립 컴퓨터 + 리눅스   

싼 값으로 운영해야한다 (운영요금이 가장 중요)

- 발전

유닉스 - > 리눅스 -> 윈도우 / 맥os -> 안드로이드 / ios


* 파티션 분할

파티션 분할 - > 안전성이 높다

C / D / E

= > 새마운트지점 추가 - > 공간을 분리해서 지정하겠다


SWAP -  메모리 영역이 모자를 때 사용한다

하드디스크 메모리를 빌려 쓴다

```

Virtual Machine

- Vmware(가상의 환경 만들기)
- Virtual Box



단축키

```
ctrl + R : 화면빠져나오기

ctrl shift +  : 창 키우기

ctrl - : 창 줄이기

ctrl + c : 중지
```



설치

```

- 설치시에 그래픽 gui 버전 설정하기 !

- DVD/CD 파일 연동
CentOS-7.0-1406-x86_64-DVD


VMware virtual machine configuration(.vmx)  워드패드로 OPEN
- > 
바꿔주기
```



리눅스 clone 복사

```
실행하고 I moved it 선택해주자
```



DHCP[Dynamic Host Configuration Protocol]

```
자동으로 ' ~ ' 부분에 ip address 할당

70.12.144.~

앞 세자리에 할당할 수 있는 ip 개수

- > 254대 2^8(0~255) - 1 대의 컴퓨터를 설치할 수 있다
```



가상세계 setting 법

```
1) cmd 실행

2) dos창 header 우클릭 빠른 편집모드

3) ip seeting

paste -> rundll32 "C:\Program Files (x86)\VMware\VMware Player\vmnetui.dll" VMNetUI_ShowStandalone 


192.168.111.2  gateway 역할(DNS 서버)
```



터미널

```
ls : 디렉토리 파일 반환
pwd : 현재디렉토리
whoami : 사용자 반환
ctrl + l : cmd창 초기화

wget http://download.hanbit.co.kr/centos/7/CentOS-Base.repo : 새 저장소 다운로드

mv : 이름 변경
- mv 현재이름 변경이름
- mv CentOS-Base.repo CentOS-Base.repo.bak

```



업데이트 중지하는 방법

```
p116
- 해당 os에 맞지 않는 sw를 설치(update)하면 os가 망가진다

ㄴ
cd /etc/yum.repos.d/
ls
1) gedit CentOS-Base.repo
 
 #released updates ~ 삭제

2) gedit CentOS-Sources.repo

 #released updates ~ 삭제
 
 
 
 

```



네트워크 설정

```
P117

명령어 : gedit ifcfg-ens33

- 주소
HWADDR(Mac address) : 네트워크카드의 고유 Number 

( clone 했을 시에 server의 mac address를 설정해주어야한다
 mac address가 clone original의 mac address로 설정되기 때문에ㄴ)

= > 통신 매칭 ( 추적 가능 )

- clone시 설정 변경해주자
서버 clone 시 mac 주소를 변경해야한다
충돌때문에 !

edit virtual machine settings
-> network adapter
-> advanced
-> macaddress generate ( 새로운 맥 주소를 생성한다)

ex) HWADDR : 00:50:56:24:76:D2



- IP 설정
IPADDR : ip address 설정

IPADDR=192.168.111.100

100번으로 ip address가 지정된다


- host name 설정
hostname : hostname 반환
- host name 변경
hostnamectl set-hostname 이름
ex)hostnamectl set-hostname server1

사생활보호 전원



poweroff 종료
reboot 다시시작
```



VM 안의 Windows설정

```
pc설정 - 제어판 - 네트워크 및 인터넷 - 네트워크 및 공유센터 - 어댑터 설정 변경 - 이더넷 속성 - 

ipv4 click - ip주소 사용

192 168 111 200

255 255 255 0

192 168 111 2

192 168 111 2

-> 사용안함 - 사용함

c- windows - system32 -drivers - etc - hosts 파일

192.168.111.101 server1

192.168.111.102 server2

192.168.111.103 server3

192.168.111.200 win8



* 참고

windows8 시리얼키
XHQ8N - C3MCJ - RQXB6 - WCHYG - C9WKB

N6KXJ - P6YWY - 4C92Q - J7BVB - R6XGM
```



IP /  host name 연동

```
* ipaddress가 진짜 이름


gedit /etc/hosts

입력하면

- > 창이 하나 나온다
ip주소 이름 입력
ex) 192.168.111.100 server1


server1 에서 server2에 ping 하는 방법

1) ping server2 에는 unknown이 뜬다
  server1 는 server2이 누구인지 모른다
  
2) 따라서 gedit /etc/hosts
에서 설정을 같은 방법으로 바꾸어준다

ex) 192.168.111.200 server2

```



```
다른 windows에서 다른 리눅스 os의 oracle과 통신하는 방법?
```



