# SHell

```
- 사용자가 입력한 명령을 해석해 커널에게 전달하거나, 커널의 처리 결과를 사용자에게 전달하는 역할 (<->terminal)
```



##### bash 셸

```
- Alias 기능
- History 기능
- 연산기능
- 프롬프트 제어 기능
- 명령 편집 가능
```





```
$ - 어딘가 환경설정에 setting 되어있는 변수

cp name.sh /usr/bin

[root@server2 ~]# name.sh
User Name is:  root
HOST Name is:  server2


[root@server2 shell]# chmod 744 *
[root@server2 shell]# ls -l
합계 8
-rwxr--r-- 1 root root 82  7월 31 13:36 name.sh
-rwxr--r-- 1 root root 18  7월 31 13:33 temp

[root@server2 shell]# name.sh
User Name is:  root
HOST Name is:  server2

[root@server2 shell]# cp name.sh /usr/bin
[root@server2 shell]# cd
[root@server2 ~]# name.sh
User Name is:  root
HOST Name is:  server2

=> /usr/bin 에 file을 setting 해 놓으면
어느 root 에서든 해당 file이 실행가능하다

[root@server2 ~]# cd shell/
[root@server2 shell]# su - centos
마지막 로그인: 금  7월 19 16:17:28 KST 2019 일시 :0

[centos@server2 ~]$ name.sh
-bash: /bin/name.sh: 허가 거부

=> 744로 mode를 잡아놓았다
실행은 가능하나 권한이 없다

[centos@server2 ~]$ sh name.sh

User Name is: 
HOST Name is:  server2
```



##### 파라미터 변수

```
1) /home /mybackup

home을 tar.xz로 압축하고
mybackup으로 이동하자

      1 #!/bin/sh
      2 echo "start"
      3 tar cvfj $1.tar.xz $1
      4 
      5 mv $1.tar.xz $2
      6 
      7 exit 0


sh para2.sh /home /mybackup


2) home 디렉토리에서 sh 파일을 모두 찾아
/shfile에 복사한다.

      1 #!/bin/sh
      2 find $1 -name "*.$2" -exec cp {} $3 \;
      3 exit 0


para3.sh /root sh /shfile

3) IF문

tomcat이 있으면 ok 출력하고 tomcat start 해주고,
tomcat 상태를 출력하자

      1 #!/bin/sh
      2 fname=/root/file/apache-tomcat-9.0.22
      3 fdirec=/root/file/apache-tomcat-9.0.22/bin
      4 
      5 if [ -e $fname ]
      6 then
      7   echo "ok"
      8   $fdirec/startup.sh
      9 
     10  
     11   ps -ef | grep fname
     12 
     13 fi
     14 exit 0
     
if1.sh
```



*

```
1) bbb 디렉토리 존재하는경우
mv aaa /bbb    // bbb디렉토리로 aaa파일이 이동

2) bbb 디렉토리 존재하지 않는경우
mv aaa /bbb    /// bbb로 이름이 변경된다

```



Case 문을 통해 Tomcat을 제어하자

```
1) profile 설정

vi /etc/profile

TOMCAT_HOME=/root/file/apache-tomcat-9.0.22
export TOMACAT_HOME

추가

. /etc/profile        // profile 재가동 (적용)


#!/bin/sh
case "$1" in
  start)
    echo "Start Tomcat ......"
        $TOMCAT_HOME/bin/startup.sh
echo "started";;
 stop)
    echo "Stop Tomcat ....."
        $TOMCAT_HOME/bin/shutdown.sh
echo "stoped";;
  check)
    echo "Check Tomcat,,,"
        ps -f | grep apache-tomcat-9.0.22
        echo "checked";;
esac
exit 0        

		case1.sh start
		case1.sh stop
		case1.sh check
```



For 문

```
#!/bin/sh
for i in $(ls *.sh)
do
 echo "$i"
 cnt=`expr $cnt + 1`
done
echo "$cnt"
exit 0

```

