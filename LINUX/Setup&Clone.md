# 설치 및 클론

1. Network Setting - 70.12.114.200

2. /etc/yum.repos.d

3. /etc/sysconfig/selinux

4. Program install (to shell)

    - yum -y install wget

      apache-tomcat-9.0.22.tar.gz

      eclipse-jee-oxygen-3a-linux-gtk-x86_64.tar.gz

      jdk-8u221-linux-x64.tar.gz

5. profile setting

   1) JAVA_HOME=/etc/jdk1.8
   	export JAVA_HOME
   2) CLASSPATH=$JAVA_HOME/lib
   	export CLASSPATH
   3) PATH=.:$JAVA_HOME/bin:$PATH

   4) TOMCAT_HOME

6. firewall config  (영구적/런타임) - 1521 / 80 , http , mysql 체크

7. TOMCAT port   /conf/sever.xml   69 - line '80' 으로 변경

8. clone

    - CENTOS 폴더에서 설치된 SERVER 폴더 복사 붙여넣기

    - config 파일을 notepad로 열고 'server 이름' 변경 

    - Network Adapter - advanced : MAC address 복사
    - hosts name 설정

    - vi /etc/sysconfig/network-scripts/ifcfg-ens33

      MAC address 변경 - HWADDR





00:50:56:32:B6:55



vi /etc/bashrc

oracle config 잡기



