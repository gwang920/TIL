

# Hadoop Server 환경설정

#### 1. 파일 다운로드

```
1) java

2) hadoop

3) eclipse

4) tomcat

5) mysql(Maria DB)


wget https://archive.apache.org/dist/hadoop/common/hadoop-1.2.1/hadoop-1.2.1.tar.gz

(wget이 안되면 web으로 받자)
```



#### 2. host 설정

```
1) etc/hosts

2) etc/hostname
 hostnamectl set-hostname hadoopserver1

3) etc/sysconfig/network-scripts

TYPE="Ethernet"

BOOTPROTO=none

IPADDR=70.12.116.50

NETMASK=255.255.255.0

GATEWAY=70.12.116.2

DNS1=70.12.116.2

00:50:56:24:29:E5

4) etc/profile

JAVA_HOME=/etc/jdk1.8
CLASSPATH=/etc/jdk1.8/lib
TOMCAT_HOME=/etc/tomcat
HADOOP_HOME=/etc/hadoop-1.2.1       // 추가

export JAVA_HOME CLASSPATH TOMCAT_HOME
PATH=.:$JAVA_HOME/bin:$TOMCAT_HOME/bin:$HADOOP_HOME/bin:$PATH  // 추가
export PATH USER LOGNAME MAIL HOSTNAME HISTSIZE HISTCONTROL
```



#### 3. ssh 설정

```
- SERVER끼리 왕래하는데 PASSWORD 묻는 과정을 없애기 위해서
 key가 맞는 놈들끼리는 password를 묻지 말아라!

1) $ ssh-keygen -t dsa -P '' -f ~/.ssh/id_dsa  

[root@hadoopserver1 ~]# ssh-keygen -t dsa -P '' -f ~/.ssh/id_dsa
Generating public/private dsa key pair.
Your identification has been saved in /root/.ssh/id_dsa.
Your public key has been saved in /root/.ssh/id_dsa.pub.
The key fingerprint is:
a7:78:68:3b:66:0e:15:e6:d4:b3:f3:73:af:59:c4:e2 root@hadoopserver1
The key's randomart image is:
+--[ DSA 1024]----+
|                 |
|       .         |
|      + o        |
|     + . o   .   |
|      o S . . o  |
|     . o = . o   |
|    . + o o E .  |
|     o+o   o +   |
|     +o.    o..  |
+-----------------+

[root@hadoopserver1 .ssh]# more id_dsa  

 // id_dsa == private key

-----BEGIN DSA PRIVATE KEY-----
MIIBuwIBAAKBgQConcmb4NtI022YDpI1AXMZ82ky1j7K3EZ9osOZwfWBmRm2W56M
nKk8I0Kz3Tawwwf7ShNs0oH85eafxW8nwyg/M3pUlNzakRvt7WOcen7liHP+zQA9
aT7GZk6WoI3UKUJZ4JD2AQEQXGcMH0mnTeERTlfOMe31yScFxjPcbT9i3wIVAJPP
cSNOGDhS0+PyneFsc3RS6C7HAoGBAKRNyze9Jk/FoiIVnzNsGYT/lUkW4NKzry5I
QN4ax3KcGeItw/qtMuYbJdfXuNw4A86CPlKW3O1GXitQYwNToPnFxZYitzeERpSx
o1Jjew/S1AT9H+HvdMOsAHuOsdsT9FYRy2sgf34DfoIrB0vP4acjGzV7Xjvv4U0D
Cdz5FgNhAoGAeHPdVohwonUMOJ8vvhamm9ZPv+XYGCblZNX7AjU9tcTHAY+PlVq5
zihcDMuaBBdIr1+lqv+CLMAolJnKMKi55YUMGuSTr0YpI02DM+YdqDmwiecX3Kgr
GNabU3BMTM6t3bAm1LEzixQvZef+MR0ndFO4SBm8anK84xLbTN0mtbUCFHzcUi6s
TEztSepV61+Zncgq68hE
-----END DSA PRIVATE KEY-----

 // id_dsa.pub == public key

 2) $ cat ~/.ssh/id_dsa.pub >> ~/.ssh/authorized_keys 
 // 배포키 설정
```



#### 4. conf 설정

```
hadoop conf

cd /etc/hadoop-1.2.1/

1) vi core-site.xml

****************************************************************************
<configuration>

<property>

  <name>fs.default.name</name>

  <value>hdfs://localhost:9000</value>

</property>

<property>

  <name>hadoop.tmp.dir</name>

  <value>/etc/hadoop-1.2.1/tmp</value>     

  

</property>

</configuration>


systemctl disable firewalld  
// firewall 사용하지 않겠다 : server들끼리 port를 열겠다



****************************************************************************

2) vi hdfs-site.xml

 
****************************************************************************

<configuration>

<property>

  <name>dfs.replication</name>

  <value>1</value>

</property>

<property>

  <name>dfs.name.dir</name>

  <value>/etc/hadoop-1.2.1/name</value>

</property>

<property>

  <name>dfs.data.dir</name>

  <value>/etc/hadoop-1.2.1/data</value>

</property>

<property>

  <name>dfs.webhdfs.enabled</name>

  <value>true</value>

</property>

</configuration>


****************************************************************************

 

3) vi mapred-site.xml

 
****************************************************************************

<configuration>

<property>

  <name>mapred.job.tracker</name>

  <value>localhost:9001</value>

</property>

</configuration>

****************************************************************************

4) vi hadoop-env.sh

****************************************************************************
    
     9  export JAVA_HOME=/etc/jdk1.8
     10 export HADOOP_HOME_WARN_SUPPRESS="TRUE"
     
****************************************************************************
     
    
     추가
     
     // hadoop이 실행될 때 env를 훑고간다 
     
     
5) vi /etc/bashrc

****************************************************************************
 	95 . /etc/hadoop-1.2.1/conf/hadoop-env.sh
****************************************************************************

	추가    
	
	// booting시에 자동 시작하도록 

```



#### 5. format

```
1) hadoop namenode -format

 name폴더가 생성되면 format이 된 것
 (/etc/hadoop-1.2.1/ls)

2) start-all.sh

 hadoop을 실행하는 것(data 폴더가 생성된다)
 
 jps 명령어 실행시
 
4898 Jps
4747 TaskTracker
4396 DataNode
4525 SecondaryNameNode
4255 NameNode
4623 JobTracker

 나오면 Clear!

```



#### 6. localhost 파이어 폭스

```
파이어 폭스에 http://localhost:50070 입력하면 
현재 살아 있는 Live node에 대해 모니터링 할 수 있다
```

![MAIN](https://user-images.githubusercontent.com/49560745/62454976-5766e900-b7b0-11e9-96e8-adc00219862c.png)



##### 디렉토리 컨트롤

```
- Test 라는 디렉토리에 README.txt 올리고 가져오는 과정

hadoop dfs -mkdir /test

// test 디렉토리 생성 (in hadoop-1.2.1)

hadoop dfs -put README.txt /test

hadoop dfs -get /test/README.txt RN.txt

```

![tr](https://user-images.githubusercontent.com/49560745/62455289-f986d100-b7b0-11e9-8ce1-4f932ff955d1.png)



```
- Input1 폴더의 파일들의 워드를 세어서 output1에 저장. hadoop~.jar는 자바 어플리케이션 역할

hadoop dfs -mkdir /data

hadoop dfs -mkdir /data/input1

hadoop dfs -put README.txt /data/input1/README.txt

hadoop jar hadoop-examples-1.2.1.jar wordcount /data/input1 /data/output1

 다음과 같이 part-r-00000이 생성된다 (part-r-00000에 log(?)가 찍힌다)
```

![patr](https://user-images.githubusercontent.com/49560745/62455365-263ae880-b7b1-11e9-9437-5c80d4454e1f.png)