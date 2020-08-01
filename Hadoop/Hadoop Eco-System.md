# Hadoop Eco-System

#### HIVE

```
- map reduce를 쉽게하기 위해서 Hive를 도입 (map reduce 프로그래밍이 상당히 복잡)
- 요청한 sql문장을 Map Reduce 프로그램으로 변환해준다
```

##### HIVE 데이터구조

```
hive

hadoop에 들어가는 데이터구조를 mysql에 저장



data의 구조는 maria db에 정의 되어있다

data -> in hadoop
data 구조 -> in mariadb
sql문 -> in hive

hive에서 데이터 구조를 보고 sql 문을 쓰면 meta정보(table 컬럼정보)를 갖고 map reduce 프로그램을 자기가 짠다 -> jobtracker에 주고 jobtracker가 실제 데이터를 분석한다
```





```
관리자가쓰는거 - mysql


1) grant all privileges on *.* to 'hive'@'localhost' identified by '111111';
flush privileges;
// 모든권한을 하이브에게 주겠다

2) select user,host from user

Query OK, 0 rows affected (0.01 sec)

MariaDB [mysql]> select user,host from user;+------+-----------------------+
| user | host                  |
+------+-----------------------+
| root | 127.0.0.1             |
| root | ::1                   |
|      | localhost             |
| hive | localhost             |
| root | localhost             |
|      | localhost.localdomain |
| root | localhost.localdomain |
+------+-----------------------+
7 rows in set (0.00 sec)


// hive가 생성된다



3)
create database hive_db;
grant all privileges on hive_db.* to 'hive'@'%' identified by '111111' with grant option;  //% 어디서든
grant all privileges on hive_db.* to 'hive'@'localhost' identified by '111111' with grant option;
flush privileges;
commit;

MariaDB [mysql]> select user,host from user
    -> ;
+------+-----------------------+
| user | host                  |
+------+-----------------------+
| hive | %                     |
| root | 127.0.0.1             |
| root | ::1                   |
|      | localhost             |
| hive | localhost             |
| root | localhost             |
|      | localhost.localdomain |
| root | localhost.localdomain |
+------+-----------------------+
8 rows in set (0.00 sec)

// hive %가 생성된다

4) mysql -u hive -p hive_db


	show database;

	http://apache.tt.co.kr/hive/hive-1.0.1/

	tar xvf ~.tar.gz
	//압축풀어주고

	mv ~ hive
	//이름변경하고

	cp -r hive /etc
	// etc아래로 복사해주자

5) profile 설정

JAVA_HOME=/etc/jdk1.8
CLASSPATH=/etc/jdk1.8/lib
TOMCAT_HOME=/etc/tomcat
HIVE_HOME=/etc/hive
HADOOP_HOME=/etc/hadoop-1.2.1

export JAVA_HOME CLASSPATH TOMCAT_HOME HADOOP_HOME HIVE_HOME
PATH=.:$JAVA_HOME/bin:$TOMCAT_HOME/bin:$HADOOP_HOME/bin:$HIVE_HOME/bin:$PATH
export PATH USER LOGNAME MAIL HOSTNAME HISTSIZE HISTCONTROL

// profile에 수정해줘야 hive를 아무데서나 접근가능해진다

* ps -ef | grep mysql
mysql 떠있나 확인하기



6) conf/hive-site.xml 설정 (파일생성하기)

<?xml version="1.0"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
<configuration>
    <property>
        <name>hive.metastore.local</name>   하이브가 생성하는 메타정보를 mysql에 저장
        <value>true</value>
        <description>controls whether to connect to remove metastore server or open a new metastore server in Hive Client JVM</description>
    </property>
    <property>
        <name>javax.jdo.option.ConnectionURL</name>
        <value>jdbc:mariadb://localhost:3306/hive_db?createDatabaseIfNotExist=true</value>
        <description>JDBC connect string for a JDBC metastore</description>
    </property>
    <property>
        <name>javax.jdo.option.ConnectionDriverName</name>
        <value>org.mariadb.jdbc.Driver</value>
        
        하이브가 마리아db로 들어간다 하이브에 마리아db의 jdbc가 있어야한다
        <description>Driver class name for a JDBC metastore</description>
    </property>
    <property>
        <name>javax.jdo.option.ConnectionUserName</name>
        <value>hive</value>
        <description>username to use against metastore database</description>
    </property>
    <property>
        <name>javax.jdo.option.ConnectionPassword</name>
        <value>111111</value>
        <description>password to use against metastore database</description>
    </property>
</configuration>



7) cp mariadb-java-client-1.3.5.jar /etc/hive/lib
hive에 마리아 db넣기
그래야 동작이가능하다

// 버전을 확인하자 , 버전이 다르면 hive 실행 시 오류발생

8)

hadoop dfs -mkdir /tmp
hadoop dfs -chmod 777 /tmp    // 권한을 줘야 hive 폴더를 만들 수 있다
hadoop dfs -mkdir /user/hive/warehouse

hadoop dfs -chmod g+w /tmp
hadoop dfs -chmod g+w /user/hive/warehouse
hadoop dfs -chmod 777 /tmp/hive

9) HIVE에 들어가자

[root@hadoopserver2 lib]# hive
19/08/07 15:15:19 WARN conf.HiveConf: DEPRECATED: Configuration property hive.metastore.local no longer has any effect. Make sure to provide a valid value for hive.metastore.uris if you are connecting to a remote metastore.
19/08/07 15:15:19 WARN conf.HiveConf: HiveConf of name hive.metastore.local does not exist

Logging initialized using configuration in jar:file:/etc/hive/lib/hive-common-1.0.1.jar!/hive-log4j.properties
hive> 



// 성공

mariadb-java-client-1.3.5.jar
hive/lib에 jdbc driver 복사




```









```

************ 분산모드에서 실행시에는 모든 server를 다 켜줘야한다

************ winodws에서 실행시 c > system32 > drivers > etc > hosts에
ip설정해주기



in HIVE
1) 테이블만들자 
CREATE TABLE HDI(id INT, country STRING, hdi FLOAT, lifeex INT, mysch INT, 

eysch INT, gni INT) ROW FORMAT DELIMITED FIELDS TERMINATED BY ',' STORED AS 

TEXTFILE;


2) 
hive> show tables;
OK
hdi
Time taken: 0.026 seconds, Fetched: 1 row(s)



3)

txt파일을 root에 paste하고

load data local inpath '/root/hdi.txt' into table HDI;
// 현재 big data file을 로드한다

// hadoopserver2:70050 의 user 밑에 hdi.txt파일이 생성된다 

4) 데이터를 뽑아와보자

hive> select id,country from hdi;
OK
1	Norway
2	Australia
3	Netherlands
4	United States
5	New Zealand
6	Canada


```



##### profile 설정 적용안될 때

```
다시 시작해주자
. /etc/profile

```

##### hadoop 비정상 종료시

```
하둡 비정상종료시 safe mode로 전환된다


mkdir: org.apache.hadoop.hdfs.server.namenode.SafeModeException: Cannot create directory /tmp. Name node is in safe mode.




hadoop dfsadmin -safemode leave
```

