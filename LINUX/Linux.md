# Linux



##### 리눅스 배경

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


SWAP -  메모리 영역이 부족할 때 사용한다

하드디스크 메모리를 빌려 쓴다

```



##### 리눅스를 사용하는 이유?

```
1. 리눅스는 오픈소스고 윈도우는 유료

즉, 리눅스는 오픈소스 라이브러리와 프로그램의 생태계가 있다는 뜻이고, 또한 이를 뒷받침하는 오픈소스 커뮤니티가 있기 때문에 그러한 프로그램을 각 배포판에 최적화된 형태로 패키징하고 관리하는 절차가 잘 되어 있다는 뜻

2. GUI가 아닌만큼 그 리소스를 서버 돌리는데 전력으로 사용 가능
```





##### Virtual Machine

- Vmware(가상의 환경 만들기)
- Virtual Box



##### 단축키

```
ctrl + R : 화면빠져나오기

ctrl shift +  : 창 키우기

ctrl - : 창 줄이기

ctrl + c : 중지

window + space : 한/영 전환
```



##### 설치

```

- 설치시에 그래픽 gui 버전 설정하기 !

- DVD/CD 파일 연동
CentOS-7.0-1406-x86_64-DVD

VMware virtual machine configuration(.vmx)  워드패드로 OPEN
- > 
바꿔주기
```



##### 리눅스 clone 복사

```
복사 후 실행하고 I moved it 선택해주자
```



##### DHCP[Dynamic Host Configuration Protocol]

```
자동으로 ' ~ ' 부분에 ip address 할당

70.12.144.~

앞 세자리에 할당할 수 있는 ip 개수

- > 254대 2^8(0~255) - 1 대의 컴퓨터를 설치할 수 있다
```



##### 가상세계 setting 법

```
1) cmd 실행

2) dos창 header 우클릭 빠른 편집모드

3) ip setting

paste -> rundll32 "C:\Program Files (x86)\VMware\VMware Player\vmnetui.dll" VMNetUI_ShowStandalone 


192.168.111.2  gateway 역할(DNS 서버)
```



##### ' / ' 의 개념

```
(1) /GAME/PUZZLE 
(2) GAME/PUZZLE 

(1)번의 '/GAME/PUZZLE'는 루트 디렉토리 밑에 있는 GAME 디렉토리 밑의 PUZZLE 디렉토리임을 나타냅니다. 

(2)번의 'GAME/PUZZLE'는 현재 디렉토리 밑에 있는 GAME이라는 디렉토리 밑의 PUZZLE 디렉토리임을 나타냅니다. 이때 GAME이라는 디렉토리가 어느 디렉토리 밑에 있는지 알 수 없습니다. 루트 디렉토리 밑에 포함된 것일 수도 있지만 다른 서브 디렉토리 밑에 포함된 디렉토리일 수도 있습니다. 따라서 (2)번 문장의 GAME 디렉토리가 루트 밑에 있는 디렉토리라는 보장이 없습니다. 

출처: https://booolean.tistory.com/400 [Boolean]
```



##### 터미널 ( 기본 명령어 p182)

```
ls : 디렉토리 정보 반환
ls -l : 상세 정보 반환
pwd : 현재디렉토리
whoami : 사용자 반환
ctrl + l : cmd창 초기화

wget http://download.hanbit.co.kr/centos/7/CentOS-Base.repo : 새 저장소 다운로드

mv : 이름 변경
- mv 현재이름 변경이름
- mv CentOS-Base.repo CentOS-Base.repo.bak

시스템 종료
- poweroff
- halt -p
- init 0
- shutdown -p +a ( a분 후에 종료 )

시스템 재부팅
- shutdown -r now
- reboot
- init 6

Switch User
- su 사용자 아이디

기록
- history
- 키보드 상 화살표

디스플레이
- cat -
ex) cat ifcfg ens-33
해당 문서가 display 된다

현재위치
- pwd

해당 폴더에 파일을 복사한다
- cp ../anaconda-ks.cfg .

이전폴더이동
- cd - (vs cd .. 상위 폴더로 이동(?)) 비교해보기

파일이동
- cd f* temp (temp라는 폴더에 모든 파일을 이동시키기)

파일삭제
- rm -i 파일명
- rm 파일명

폴더삭제
- rm -f 폴더명
- rm -r 폴더명 (삭제 + y/n question 파일마다)
- rm -rf 폴더명 (전체삭제 question 무시)

파일조회
- cat 파일명
- more 파일명

사용자지정 명령어
- vi .bashrc 
- alias 
- alias rm='rm-i'
- alias ls='rs-i'
- alias ll='clear'

.bashrc 테마/환경설정
- 명령을 찾을 수 없습니다. => 현재 디렉토리가 path에 지정되지 않았을 때
- ./ : 현재 디렉토리 밑에 (path가 지정되지 않았을 때 사용하자)

path 지정 (in bashrc)
- PATH=.:$PATH
- export PATH  // 모든 path에 적용
- . ./.bashrc : bashrc를 다시 실행 (새로운 환경설정을 적용하기 위해)

gedit 삭제 & 재설치
- [root@server1 file]# rpm -e gedit-3.8.3*
- [root@server1 file]# gedit
- bash: gedit: 명령을 찾을 수 없습니다...    
// 삭제완료
- cp /run/media/root/CentOS\ 7\ x86_64/Packages/gedit-3.8.3-6.el7.x86_64.rpm . 
// 파일복사
- rpm -Uvh gedit-3.8.3-6.el7.x86_64.rpm 
// 설치
```



##### 사용자 및 그룹 접근권한

```
해당 디렉토리에는 해당 그룹원만 접근가능하고
allfile에는 모두 접근가능하게 권한을 부여하자

nusers group : nuser1, nuser2, nuser3
musers group : muser1, muser2, muser3

/home/nusersfile
/home/musersfile
/home/allfile

group -g nusers nuser1
group -g nusers nuser2
group -g nusers nuser3

group -g musers muser1
group -g musers muser2
group -g musers muser3

cd /home
mkdir nusersfile
mkdir musersfile
mkdir allfile

* 파일 허가 지정
소유자(user)  그룹(group)  그 외 사용자(other)
 r  w  x       r  w  x       r  w  x
 4  2  1       4  2  1       4  2  1
 
chmod 770 nusersfile
chmod 770 musersfile

* chown 소유주명.그룹명 파일명

chown .nusers nusersfile
chown .musers musersfile
```



##### yum

```
yum -y install mysql-connector-odbc-5.2.5-6.el7.x86_64.rpm
=> yum에 있는 url을 찾아 해당파일을 설치한다.

yum localinstall mysql-connector-odbc-5.2.5-6.el7.x86_64.rpm 
=> 만약 loacl에 설치파일이 저장된경우에는 localinstall을 사용한다.


```



##### 파이프, 필터, 리다이렉션

```

리다이렉션 
- ls -la /etc > 20190725.txt // 조회한것을 txt 파일에 저장 한다


포그라운드 프로세서
- 화면에 나타나서 사용자와 상호작용하는 프로세스
_ yes

백그라운드 프로세서
- 화면에 보이지 않고 뒤에서 실행되는 프로세스
- yes &

프로세스 종료
- kill 프로세스name

ex)
root      4481  3636  5 13:25 pts/0    00:00:00 yes
root      4483  4442  0 13:25 pts/1    00:00:00 grep --color=auto yes

kill 4481
```



##### 파일위치검색

```
find ~ -size 0k -exec ls -l {} \;
=> 현재 사용자의 홈 디렉터리 하위에 파일 크기가 0인 파일의 목록 출력

find ~ -size 0k -exec cp {} temp  \;
=> 크기가 0k인 파일을 찾아서 temp폴더로 복사하기
```



##### 방화벽설정

```
firewall-config

oracle 연동시 포트에 추가해주자
```



##### 압축

```
xz 파일이름

압축은 하나의 파일만 가능하다
(여러개의 파일을 압축하려면 하나의 폴더에 넣고서 압축한다)

파일묶기
tar cvf 생성파일명 묶을폴더명

압축풀기
tar xcf my.tar
```



##### 링크

```
하드 링크 : 사이즈가 원본파일과 동일

파일의 보존성을 위해 사용

ln linktest/ltest hlink

심볼릭 링크 : 원본파일 + 위치지정

위치를 가르키기 위해 사용 (바로가기 파일과 비슷한 느낌)

ln -s linktest/ltest slink

lrwxrwxrwx. 1 root root 22  7월 19 02:19 java -> /etc/alternatives/java
-> 심볼릭 링크

cp -r jdk1.8 /etc
= > jdk1.8을 etc밑에 copy하겠다 (cp -r  => 해당 디렉토리의 하위 디렉토리도 같이 복사)

error
- cp: omitting directory 'spark-2.2.0-bin-hadoop2.7'
- 이때 cp -r을 써준다



cd /usr/bin 로 이동 후
ln -s /etc/jdk1.8/bin/java java    // 기본적으로 /etc 밑에 java가 있다(?)
= > 'java' 라는 이름으로 심볼릭링크를 걸어준 것


usr/bin
일반 사용자들이 사용가능한 명령어 파일들이 존재하는 디렉토리.

java 삭제 & 재설치
- 파일 -> 내폴더 -> file(생성) -> jdk파일 paste
- which java    // java 위치 확인
- cd /usr/bin   // java 위치로 이동
- rm java       // java 삭제(심볼릭을 삭제한다 즉, 연결고리만 끊는 것)
- cd file       // jdk 파일이 있는 폴더로 이동
- tar vxf jdk-8u221-linux-x64.tar.gz // tar -xvf [파일명.tar] 압축풀기
- java          // 아직 심볼릭 링크가 지정되지않아 찾을 수 없다
- mv jdk1.8.0_221 jdk1.8   // 이름 간단하게 바꿔주자
- cp -r jdk1.8 /etc        // recursive : 디렉토리를 복사할 경우 하위 디렉토리와 파일을 모두 복사
- cd /usr/bin         // usr/bin 경로로 심볼릭을 지정해주기 위해 이동
- ln -s /etc/jdk1.8/bin/java java    // 심볼릭 링크를 지정해주자
- java -version         // 이제 확인이 가능하다
```



##### vi 모드

```
vi filename = 해당 파일 수정하기
touch filename = 파일 생성하기
ex) touch t1.txts

:wq file name = 저장하고 나가기
:q! = 강제로 나가기 ( 저장 x )

vi /etc/profile => path / export 설정

INSERT MODE
 i   = 왼쪽 삽입/커서
 a   = 오른쪽 삽입/커서
 o   = 현재 커서의 다음줄에 입력
 s   = 현재 커서 위치의 한 글자를 지우고 입력
 cw  = 커서 이후 전부 삭제
 shift + a = 맨 왼쪽 삽입/커서
 shift + a = 맨 오른쪽 삽입/커서
 shift + o = 현재 커서의 이전 줄에 입력
 shift + s = 현재 커서의 한 줄을 지우고 입력
 
SET NUMBER
 set nu = line에 넘버링
 
LINE 이동
 gg = 맨 윗줄로 이동
 G  = 맨 뒷줄로 이동

 line + G
 ex) 30 G
 
 :line 이동라인
 ex):line 30

yy =  해당 line 복사
p  =  paste

/test = test search ( n을 누르면 다음 test로 계속 이동 )

vim -r filename = 복원
ex) vim -r t2.txt

rm .t2.txt.swp = 삭제

문자(열) 바꾸기
:%s/해당문자열/바꿀문자열
ex):%s/test/test1


```



##### 업데이트 중지하는 방법

```
p116
- 해당 os에 맞지 않는 sw를 설치(update)하면 os가 망가진다

cd /etc/yum.repos.d/
ls
1) gedit CentOS-Base.repo
 
 #released updates ~ 삭제

2) gedit CentOS-Sources.repo

 #released updates ~ 삭제
 
```



eclipse 설치

```
- eclipse
```



##### 톰캣 설치

```
- tomcat ~.tar.gz 파일 (for linux) download
- linux의 file 폴더에 paste
- cd file
- tar xvf tomcat ~.tar.gz   // 압축풀기
- cd apache-tomcat-9.0.22   // tomcat은 이동만되어도 설치가 완료된다
- cd conf    // 설정을 위해 이동
- firewall-config  // (런타임 / 영구적) 적용 http  + 포트 1521 추가
- vi server.xml // 포트 설정 80   (69 line)
- startup.sh   // 톰캣을 실행한다  (cd /file/apache-tomcat/bin 에서)

vi /etc/profile 에서

JAVA_HOME=/etc/jdk1.8
export JAVA_HOME
CLASSPATH=$JAVA_HOME/lib
export CLASSPATH
PATH=.:$JAVA_HOME/bin:$PATH

삽입

profile 은 컴퓨터가 부팅이되면 자동으로 setting 되도록 설정하는 기능(값)
```



##### 네트워크 설정

```
P117

명령어 : gedit ifcfg-ens33

- 주소
HWADDR(Mac address) : 네트워크카드의 고유 Number 

( clone 했을 시에 server의 mac address를 설정해주어야한다
 mac address가 original clone의 mac address로 설정되기 때문에ㄴ)

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



##### VM 안의 Windows설정

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



##### IP /  host name 연동

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


102
```



```
다른 windows에서 다른 리눅스 os의 oracle과 통신하는 방법?
```



##### 마운트

```

- 물리적인 cd룸(/ dev/ sr0 on)이 해당 디렉토리(/ run/media/.. )에 연결되어있다.

/ dev/ sr0 on / run/media/..


ex) cd /run/media/root/
	ls
	
	=>  (CentOS 7 x86_64)     in cdRom
	

- 하드디스크가 해당 디렉토리에 연결되어 있다. (swp 할 때 지정한 것)

/dev/sda2 on / type xfs


- mount (cd를 해당 위치에 마운트한다)

ex) mount /dev/cdrom /mycdroom

	(mycdroom에 cdrom을 마운트)

 	cd /mycdroom
 	ls
 
 => CentOS_BuildTag  GPL       RPM-GPG-KEY-CentOS-7          images
	EFI              LiveOS    RPM-GPG-KEY-CentOS-Testing-7  isolinux
	EULA             Packages  TRANS.TBL                     repodata

 	cd 정보가 나온다
 	

- umount (mount 분리 == cd 분리)

ex) umount /dev/cdroom/

	cd /run/media/root/
	ls
	
	=> (null)           in cdRom

```



```
1. network 설정
	vi /etc/sysconfig/network-scripts/ifcfg-ens33
	
	
	
BOOTPROTO=none
IPADDR=192.168.111.104
NETMASK=255.255.255.0
GATEWAY=192.168.111.2
DNS1=192.168.111.2


추가

systemctl restart network   // 적용을 위해 재실행


2. user 설정
	useradd
	permission
	chmod, chown, chgrp
	
3. tar, zip(unzip)

4. rpm, yum(localinstall , install)
	yum은 open source만 있다
	
	ex) yum -y localinstall oracle~
	
5. Program install
	tomcat , eclipse , jdk
	/etc/profile 환경설정
	ln -s 심볼릭링크
	firewall-config
	/usr/bin 이 path에 잡혀있기 때문에 /usr/bin에 설정해준다
```



##### CRON 과 AT

```
주기적으로 반복되는 일을 자동으로 실행하기 위한 명령어

vi /etc/crontab
00 05 1 * * root cp -r /home /backup     
// 매월 1시 새벽 5시 00분에 backup에 home 디렉토리를 복사한다

systemctl status crond     // active 확인하고
systemctl restart crond    // 적용을 위해 재시작 


/etc/crontab 파일 (edit 파일)
	/etc/cron.houly/
	/etc/cron.daily/
	/etc/cron.weekly/
	/etc/cron.monthly/
	
	
	edit 파일에 실행 명령어 작성 후
	
 실행을 위해 입력 : 01 * * * * root run-parts /etc/cron.hourly
	
		// 매시간 1분에 /etc/cron.hourly 디렉터리 안에 있는 명령들을 자동으로 실행
	
	run-parts : 디렉터리안의 명령을 모두 실행한다 (모든 script 실행)
	
	
	
	
 
 
 at 명령어
 
[root@server1 ~]# at 11:25 am today   // 11:25분에 실행 예약
at> cp -r /home /backup
at> reboot
at> reboot<EOT>       // ctrl + D 누름
job 1 at Wed Jul 24 11:25:00 2019
[root@server1 ~]# at -l      // 작업 상세 정보 ( 가장 앞에 출력되는 번호가 작업번호)
1	Wed Jul 24 11:25:00 2019 a root	

```



##### Oracle 설치

```
p571
- Oracle Database Express Edition 11g Release2 다운로드
- unzip oracle*

oracle 설치

용량 늘리기 ( 초기설정시 용량이 2GB / Oracle 설치 메모리 최소 1990MB)
dd if=/dev/zero of=/swapfile bs=1024 count=4194304  // 가상 메모리용 파일 생성(4GB)
mkswap /swapfile     // 파일을 가상 메모리로 포멧
swapon /swapfile     // 가상 메모리 활성화
swapon -s            // 가상 메모리 용량 확인


cd /root/file    // 파일 위치 디렉터리 이동
yum -y localinstall oracle*    // 오라클 설치

service oracle-xe configure    // 환경설정 시작

vi /etc/bashrc ->맨마지막줄에 추가하자
. /u01/app/oracle/product/11.2.0/xe/bin/oracle_env.sh  // 오라클 환경설정

/etc/init.d/oracle-xe start  // 서비스 시작
```



##### 네트워크

```

- TCP/IP
컴퓨터끼리 네트워크상으로 의사소통하는 약속(규칙)

- 호스트 이름
각가의 컴퓨터에 지정된 이름

도메인 이름 (도메인 주소)
- (Public) 외부에서 누구나 접근 가능하도록 지정한 이름
 
 브라우저 IP요청 -> DNS -> 브라우저 -> IP접속

넷마스크
- 네트워크의 규모를 결정

클래스
- 

게이트웨이
- 내부 네트워크를 외부로 연결하는 컴퓨터 / 장비

DHCP
- 자동 IP 할당 / setting
- ex) smartPhone on시에 기지국에 ip를 요청


linux network security
```





