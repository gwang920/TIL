# LINUX FOR CONSOLE



##### CentOS 버전 설치

```
su -
cd /etc/yum.repos.d/
yum -y install wget 


(mv CentOS-Base.repo CentOS-Base.repo.bak
chmod 644 *
rm -f *.repo~
yum clean all)

괄호의 과정은 전부 생략했다 (생략해도 문제가 발생하진 않았는데 정확하게 해석해도 되느는지 모르겠다)

```



##### yum 오류발생시

```
Modules complémentaires chargés : fastestmirror


One of the configured repositories failed (Inconnu),
and yum doesn't have enough cached data to continue. At this point the only
safe thing yum can do is fail. There are a few ways to work "fix" this:

     1. Contact the upstream for the repository and get them to fix the problem.

     2. Reconfigure the baseurl/etc. for the repository, to point to a working
        upstream. This is most often useful if you are using a newer
        distribution release than is supported by the repository (and the
        packages for the previous distribution release still work).

     3. Disable the repository, so yum won't use it by default. Yum will then
        just ignore the repository until you permanently enable it again or use
        --enablerepo for temporary usage:

            yum-config-manager --disable <repoid>

     4. Configure the failing repository to be skipped, if it is unavailable.
        Note that yum will try to contact the repo. when it runs most commands,
        so will have to try and fail each time (and thus. yum will be be much
        slower). If it is a very temporary problem though, this is often a nice
        compromise:

            yum-config-manager --save --setopt=<repoid>.skip_if_unavailable=true

Cannot find a valid baseurl for repo: base/7/x86_64



방법

==> #dhclient
```



##### IFCONFIG

```
ip addr  // ifconfig와 동일한 명령어

yum -y install net-tools   // tool을 설치하자 (ifconfig도 사용 가능)
```



##### jdk / apacheTomcat 설치

```
1) # wget --no-cookies \
--no-check-certificate \
--header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" \
"http://download.oracle.com/otn-pub/java/jdk/8u171-b11/512cd62ec5174c3487ac17c61aaa89e8/jdk-8u171-linux-x64.tar.gz"

// 이 방법은 link 연결이 http로 걸려서 file이 down 되지 않는다(압축이 풀리지 않음)


2) scp apache-tomcat-9.0.22.tar.gz root@192.168.111.115/root/

// 그래서 파일전송을 이용하자. gitBash나 locallinstall이 가능한 server 에서 전송해주자

3) jdk 설치
- mv jdk1.8.0_221 jdk1.8   // 이름 간단하게 바꿔주자
- cp -r jdk1.8 /etc        // recursive : 디렉토리를 복사할 경우 하위 디렉토리와 파일을 모두 복사
/usr/bin 에서 심볼릭링크를 걸자
-ln -s /etc/jdk1.8/bin/java java

4) Tomcat 설치
- tar xvf tomcat ~.tar.gz   // 압축풀기
- cd apache-tomcat-9.0.22   // tomcat은 이동만되어도 설치가 완료된다
- cd conf    // 설정을 위해 이동
- firewall => 아래 내용을 참고하자

```



##### firewall 설정

```
1) 포트추가
firewall--cmd --permanent --zone=public --add-port=1521/tcp

2) 방화벽에 연결가능 한 list
firewall-cmd --list-services

3) http 추가 (이용가능하도록)
firewall-cmd --permanent --add-service=http

* 설정
vi server.xml //포트설정 '80' line 69 (in=> /file/apache-tomcat-9.0.22/conf)

vi /etc/profile

JAVA_HOME=/etc/jdk1.8
export JAVA_HOME
CLASSPATH=$JAVA_HOME/lib
export CLASSPATH
PATH=.:$JAVA_HOME/bin:$PATH

추가

tomcat startup

cd file/apache-tomcat-9.0.22/bin

으로 이동하고
./startup.sh 입력
```



