

# 분산처리 시스템 구축 개요



![캡처](https://user-images.githubusercontent.com/49560745/62525581-9fe6db00-b872-11e9-8df8-abc9ae80d031.PNG)





```
데이터 분산 저장

namenode에의해 나머지 서버에 setting이 되고,

jobtracker가 tasktracker에게 분석을 요청하고, 받을 수 있다


1) 서버 4개 생성하기 paste
  하고 servername notepad 이용해서 바꿔주기
  
2) mac address 변경
   hostname
   vi /etc/hosts변경해주고

3) hadoop 설치

4) ssh 설정

 - private / public 키 생성
 	
 	ssh-keygen -t dsa -P '' -f ~/.ssh/id_dsa  
 
 - 배포키설정
 
	cat ~/.ssh/id_dsa.pub >> ~/.ssh/authorized_keys
 
 - 권한 부여
 	
 	scp authorized_keys root@hadoop2:~/.ssh/authorized_keys 
	scp authorized_keys root@hadoop3:~/.ssh/authorized_keys 
	scp authorized_keys root@hadoop4:~/.ssh/authorized_keys 
	
	// 루트 권한으로 authorized_keys를 ~/.ssh/authorize_keys로 전송해라
 	   hadoop2,3,4로 접근하기위해 키를 넣어준것
 		
5) xml 3개 / hadoop_env.sh / bashrc / profile 설정
 
 - xml
 
 	.xml for 분산처리 참고

 - vi hadoop_env.sh
 
 	 export JAVA_HOME=/etc/jdk1.8
	 export HADOOP_HOME_WARN_SUPPRESS="TRUE"

 - vi /etc/profile
 
 
	JAVA_HOME=/etc/jdk1.8
	CLASSPATH=/etc/jdk1.8/lib
	TOMCAT_HOME=/etc/tomcat
	HADOOP_HOME=/etc/hadoop-1.2.1    //추가
	export JAVA_HOME CLASSPATH TOMCAT_HOME HADOOP_HOME  // 추가
	PATH=.:$JAVA_HOME/bin:$TOMCAT_HOME/bin:$HADOOP_HOME/bin:$PATH //추가
	export PATH USER LOGNAME MAIL HOSTNAME HISTSIZE HISTCONTROL

 - vi /etc/bashrc 마지막 라인에 추가 
	 . /etc/hadoop-1.2.1/conf/hadoop-env.sh

   
6) 방화벽 허물기

  systemctl stop firewalld
  systemctl disable firewalld
   
7) masters / slaves 설정 
 (masters와 slaves는 존재하는 파일 in 'conf')
 
 DATANODE / TASKTRACKER => in slaves
 SECONDARY NAMENODE => in masters

8) 압축해서 각 서버에 뿌려주기

 - tar cvfz hadoop.tar.gz hadoop-1.2.1/
  압축해준다 (하둡)
  
 - scp hadoop.tar.gz root@hadoop2:/etc 
  2,3,4에 복사해준다
  
 - ssh root@min "cd /etc;tar xvfz hadoop.tar.gz;rm -rf hadoop.tar.gz"
   ssh root@ming "cd /etc;tar xvfz hadoop.tar.gz;rm -rf hadoop.tar.gz"
   ssh root@ansoh "cd /etc;tar xvfz hadoop.tar.gz;rm -rf hadoop.tar.gz"
   ssh root@yong "cd /etc;tar xvfz hadoop.tar.gz;rm -rf hadoop.tar.gz"

	 /etc 밑에 압축을 풀고, 압축파일 삭제해주겠다
	 " "안에 여러개의 명령어를 넣을 수 있다
 

9) 포맷하기

	hadoop namenode -format

10) start-all.sh

 

11) 결과확인

-----------------결과---------------
[root@hadoop1 hadoop-1.2.1]# jps
14833 NameNode
12292 TaskTracker
15163 Jps
15023 JobTracker

[root@hadoop2 hadoop-1.2.1]# jps
9847 Jps
9768 TaskTracker
9659 SecondaryNameNode
9566 DataNode

[root@hadoop3 hadoop-1.2.1]# jps
9110 TaskTracker
9001 DataNode
9195 Jps

[root@hadoop4 hadoop-1.2.1]# jps
9202 Jps
9123 TaskTracker
9014 DataNode

```



#### .xml for 분산처리 

##### mapred-site.xml

```

  <property>
   <name>mapred.job.tracker</name>
   <value>hadoop1:9001</value>
  </property> 
  
```

##### core-site.xml

```
 
 <property>
    <name>fs.default.name</name>
    <value>hdfs://hadoop1:9000</value>
  </property>
  <property>
    <name>hadoop.tmp.dir</name>
    <value>/etc/hadoop-1.2.1/tmp</value>
  </property> 
  
```

##### hdfs-site.xml

```
 
 <property>
    <name>dfs.permissions</name>
    <value>false</value>
  </property>
  <property>
    <name>dfs.replication</name>
    <value>2</value>
  </property>
  <property>
    <name>dfs.http.address</name>
    <value>hadoop1:50070</value>
  </property>
  <property>
    <name>dfs.secondary.http.address</name>
    <value>hadoop2:50090</value>
  </property>
  <property>
    <name>dfs.name.dir</name>
    <value>/etc/hadoop-1.2.1/name</value>
  </property>
  <property>
    <name>dfs.data.dir</name>
    <value>/etc/hadoop-1.2.1/data</value>
  </property> 
  
```

#### * 오류 시 reset

```

- 문제발생하면
  server1에서 stop-all.sh하고 
  모든 서버의 name data tmp 파일 삭제 후
  다시 포맷하자
 

 http://192.168.111.201:50070
 접속



windows에서 서버 접근시 안될 때


C:\Windows\System32\drivers\etc

hosts파일에 설정해주기 
70.12.114.201 hadoopserver2
추가!

+

firewalld 켰다 끄기 

systemctl start firewalld
systemctl enable firewalld

systemctl stop firewalld
systemctl disable firewalld


```

