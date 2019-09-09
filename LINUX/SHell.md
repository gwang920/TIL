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



- Case 문을 통해 Tomcat을 제어하자

```
1) profile 설정

vi /etc/profile

TOMCAT_HOME=/root/file/apache-tomcat-9.0.22
export TOMACAT_HOME

추가

. /etc/profile        // profile 재가동 (적용)


      1 #!/bin/sh
      2 case "$1" in
      3   start)
      4     echo "Start Tomcat ......"
      5         $TOMCAT_HOME/bin/startup.sh
      6 echo "started";;
      7  stop)
      8     echo "Stop Tomcat ....."
      9         $TOMCAT_HOME/bin/shutdown.sh
     10 echo "stoped";;
     11   check)
     12     echo "Check Tomcat,,,"
     13         ps -f | grep apache-tomcat-9.0.22
     14         echo "checked";;
     15 esac
     16 exit 0


		case1.sh start
		case1.sh stop
		case1.sh check
```



- For 문

```
1) .sh로 끝나는 파일을 모두 조회하고 , 파일 개수를 return, var1.sh일 때 OK! : var1.sh를 출력하자

      1 #!/bin/sh
      2 for i in $(ls *.sh)
      3 do
      4  if [ $i = "var1.sh" ]
      5  then
      6     echo "OK!: $i"
      7  fi
      8  cnt=`expr $cnt + 1`
      9 done
     10 echo "$cnt"
     11 exit 0
     
     
        for1.sh
                           

```

- While 문

```
while [ var ]     //while 다음에 한칸 띄우자



```



window의 eclipse 에 jdk / eclipse / tomcat  paste (web 폴더 밑에)

ftp / telnet : 해킹에 치명적이다

window에 있는 web서버가 파일서버가 된다



```
1) eclipse내의 Dynamic WebProject 생성
2) eclipse의 web 아래 설치파일 paste
3) server 연결
4) windows의 cmd 창에서 ipconfig로 ip 확인후

linux 터미널에서

yum -y install wget

wget http://70.12.114.55/test/jdk1.8.tar.gz

를 입력하면

download 된다
```





```
#!/bin/sh

set $(date)

startTomcat(){
echo "Input Number is .. "$1
echo "$(date)"
set $(date)
echo $1 $2

echo "start Tomcat Function...."
echo $4 $5 $6
  return
}

stopTomcat() {

   echo "Input Number is .. "$1 $2
   echo "stop Tomcat Function...."

   return



}

echo "Tomcat Management Tool...."

while [ 1 ]
do
   echo "Input Command (start,stop,check,q): "
   read cmd

   case $cmd in
        start)
        echo $1 $2

        startTomcat 10
          echo "Tomcat Started";;

        stop)
        stopTomcat 40 50
          echo "Tomcat Stopped";;

        q)

           echo "Exit"
           break;;
   esac
done
echo "EXit Shell Program"
exit 0


```



```
substr

A=aaabcd
${a:0:4}

결과 aaab



******* 주의 ********

date 사용시

date=`date` // ` `  (~) 사용하자

date='date' // 작은따옴표 x


"${date:0:4}-${date:6:2}-${date:10:2}"

date : 20190710

결과
2019-07-10




-----------------------------------------------------------------------------
1)

#!/bin/sh
date=`date`
echo "$date"
partitionName="${date:0:4}-${date:6:2}-${date:10:2}"
echo $partitionName
fileName="work.log"
echo $fileName
if [ -f /root/log/$fileName  ]
then


 hive << EOF

LOAD DATA LOCAL INPATH '/root/log/$fileName' OVERWRITE INTO LOGINFO PARTITION (cDate="$partitionName")

EOF
      echo "OK"

      echo "OK"
      else
        echo "File Not Found"
      fi
      
      
      
2)

vi /etc/ crontab


SHELL=/bin/bash
PATH=/sbin:/bin:/usr/sbin:/usr/bin
MAILTO=root

# For details see man 4 crontabs

# Example of job definition:
# .---------------- minute (0 - 59)
# |  .------------- hour (0 - 23)
# |  |  .---------- day of month (1 - 31)
# |  |  |  .------- month (1 - 12) OR jan,feb,mar,apr ...
# |  |  |  |  .---- day of week (0 - 6) (Sunday=0 or 7) OR sun,mon,tue,wed,thu,fri,sat
# |  |  |  |  |
# *  *  *  *  * user-name  command to be executed
  15 11 12 8  * root run-parts /root/cron.daily
  
  


```







##### sh로 파일 설치 경로 설정

```
1. jdk 설치

   /etc/jdk1.8

   /usr/bin/java symbolic link

2. tomcat 설치

   /etc/tomcat  

   /usr/bin/startcat  symbolic link

   /usr/bin/stopcat  symbolic link

3. eclipse 설치

   /etc/eclipse

   /usr/bin/eclipse symbolic link

4. 메뉴를 구성하여 설치를 진행한다

5. 단, 설치가 되어 있을 경우 삭제 후 설치 진행

6. 중간에 사용자에게 물어보면서 진행 (ex 삭제하시겠습니까?)


- jdk / eclipse / tomcat setup

#!/bin/sh
while [ 1 ]
do
echo "Input what you wanna install (jdk , tomcat, eclipse) or quit (q) "
read cmd
case $cmd in
        jdk)
                wget http://70.12.114.58/test/jdk1.8.tar.gz
                tar xvfz jdk1.8.tar.gz
                if [ -e /etc/jdk1.8 ]
                then
                        echo "Already exits. wanna delete? (Y/N)"
                        read cmdd
                        if [ "$cmdd" = "Y" ]
                        then
                                rm -rf /etc/jdk1.8
                        fi
                fi
                mv jdk1.8.0_221 /etc/jdk1.8
                if [ -e /usr/bin/java ]
                then
                        rm /usr/bin/java
                fi
                ln -s /etc/jdk1.8/bin/java /usr/bin/java
                echo "JDK install Complete";;
        tomcat)
                wget http://70.12.114.57/test/tomcat.tar.gz
                tar xvf tomcat.tar.gz
                fname=/etc/tomcat
                if [ -e $fname ]
                then
                        echo "Already exits. wanna delete? (Y/N)"
                        read cmdd
                        if [ $cmdd = 'Y' ]
                                then
                                        rm -rf $fname
                        fi
                fi
                mv apache-tomcat-9.0.22 tomcat
                mv tomcat /etc/
                if [ -e /usr/bin/startcat ]
                then
                  rm /usr/bin/startcat
                fi
 
                if [ -e /usr/bin/stopcat ]
                then
                 rm /usr/bin/stopcat
                fi
                ln -s /etc/tomcat/bin/startup.sh /usr/bin/startcat
                ln -s /etc/tomcat/bin/shutdown.sh /usr/bin/stopcat
               echo "Tomcat install Complete";;
       eclipse)
                 if [ -d /etc/eclipse ]
                        then
                       echo "eclipse is already installed. do you want remove and reinstall it?[Y,N]"
                       read reinstall
                       until [ "$reinstall" = "Y" ] || [ "$reinstall" = "N" ]
                            do
                               echo "please input Y or N"
                               read reinstall
                             done
                        if [ $reinstall = "N" ]
                        then
                                echo "install system stop.."
                                return
                        else
                        rm -rf /etc/eclipse/
                        fi
                else
                        echo "install system is start"
                fi
                echo "eclipse install start"
                wget http://70.12.114.51/test/eclipse.tar.gz
                tar xvfz eclipse.tar.gz
               mv eclipse /etc/eclipse
                if [ -e /usr/bin/eclipse ]
                then
                        rm /usr/bin/eclipse
                fi
                ln -s /etc/eclipse/eclipse /usr/bin/eclipse
                echo "Tomcat install Complete";;
        q)
                break;;
        	*)
	                ;;
	esac
 
	done
 
	exit 0
```





* 참고

```
입력
for1.sh 1.sh 2.sh 3.txt


echo "$0" 
echo "$1"
echo "$2"
echo "$3"


	for1.sh
	
	
	
결과 

	for1.sh
	1.sh
	2.sh
	3.txt


```

