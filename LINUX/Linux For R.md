# Linux For R

##### 설치

```
 /etc/yum.repos.d/
에서
vi epel.repo 
아래와 같이 모든 내용을 수정

baseurl=http://download.fedoraproject.org/pub/epel/7/$basearch
#metalink=https://mirrors.fedoraproject.org/metalink?repo=epel-7&arch=$basearch



1. R 인스톨 시 필요 라이브러이 인스톨
yum -y install epel-release

2. OS 업그레이드
yum -y upgrade

3. reboot

4. R 인스톨 시 필요 라이브러이 인스톨
yum -y update lvm2*
yum -y update device-mapper*

5. R 인스톨
yum -y install R

6. Rstudio 설치
www.rstudio.com
RStudio 1.2.1335 - Fedora 19/RedHat 7 (64-bit) 설치

7. reboot

8. 로그인 시 centos로 로그인 한 후 
rstudio 실행

```

