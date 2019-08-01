# 하드디스크 관리

IDE방식 (cd-rom)-> SATA(Serial ATA)방식

IDE 방식 : IN - OUT 속도가 느리다



##### 하드디스크 추가하기

```
하드디스크 용량이 부족할 때

store 방식 : for single
split 방식 : for multifle (큰 용량을 추가할 때)
  

ls -l /dev/sd*     // HardDisk 조회
				   // 포맷 (포맷 후에 데이터 저장이 가능)
				   				   
				   
 1004  mkfs.ext4 /dev/sdb1
 1005  ls -l /dev/sd*
 1006  history
 1007  mkdir /mydata
 1008  cd mydata
 1009  cd /mydata
 1010  touch data1.txt

 1015  mount /dev/sdb1 /mydata   // mydata에 sdb1을 mount한다
 1016  cd /mydata/

 1018  touch data2.txt

 1020  cd
 1021  umount /dev/sdb1   // data1.txt 조회가능
 1022  cd /mydata
 1023  ls
 
 파티션 분할
 sdc(2GB)를 각각 1GB로 파티션 분할하자
 
 # fdisk /dev/sdC
 Comman : n            // 새로운 파티션 분할
 Select : p             // Primary 파티션 선택
 Partition number : 1  // 새로운 파티션 번호 선택
 First sector: enter  // enter 누르면 default (sdc1의 시작 값)
 Last sector : +1G    // 용량 1GB로 지정
 
 Comman : n            // 새로운 파티션 분할
 Select : p             // Primary 파티션 선택
 Partition number : 2   // 새로운 파티션 번호 선택
 First sector: enter    // enter 누르면 default (sdc2의 시작 값)
 Last sector : enter    // 용량 1GB로 지정 ( 2GB-1GB=1GB)

```



##### 하드디스크 제거

```
/fstab에서 mount를 제거한후에 edit창에서 삭제해주자
mount 제거 전에 edit 창에서 제거되면 시스템 오류가 발생한다
(alert창 반복)


vi /etc/fstab

dd 누르면 해당 line 삭제
u 누르면 원복

script에서
```



##### 여러 개의 하드디스크를 하나처럼 사용하기

```
RAID 와 LVM 방식을 이용하자

RAID(Redundant Array Of Inexpensive/Independetn Disk)
- 저렴하게 독립적인 디스크들을 묶어서 사용한다
- 신뢰성을 높이고, 성능을 향상시킨다

Linear RAID 
- 순차적으로 첫번째부터 저장

RAID0
- 2개 이상 동시 저장 / 가장 빠르다
- 데이터 안전성 보장 x

RAID1
- 2개 동시 저장 (디스크 복구 용)
- 미러링 (똑같은 데이터의 거울을 만든다 - backup)
 즉, 용량을 절반밖에 사용하지 못한다 
- 데이터 안전성을 보장

RAID5
- 3개 이상
- in/out 속도가 빠르다(큰 파일에 대한 빠른 Access)
- 패리티를 이용하기에 DISK가 한 장 날라가도 복구가 가능하다 (두장 이상은 불가능) 
- 101 에서 10이 되면 자동으로 101로 복구 (짝수패티리 사용 예)

RAID 1+0
- 안전성 + 속도


RAID 6
- default 4장(패리티 검사 2장 + 나머지 2장의 저장공간)


RAID 1 + 6
- 고 신뢰성
- 금융결제원과 같은 곳에 사용된다

```



##### RAID 생성 실습

```
md9 이라는 곳에 두개를 묶어 사용하겠다
포맷도하고 mount도하고

1. 각각의 Disk  fdisk - fd

2. mdadm - 디스크 묶기
   mdadm --create /dev/md9 --level=linear --raid-devices=2 /dev/sdb1 /dev/sdc1

--create /dev/md9      // md9 장치에 RAID 생성
--level=linear         // Linear RAID를 지정
--raid-devices=2 /dev/sdb1/ /dev/sdc1      // 2개의 하드디스크를 사용하며, 이어서 나오는 것은 장치이름

3. mkfs.ext4 - 포맷
    mkfs.ext4 /dev/md9
 
4. 폴더 생성
    mkdir /linear
 
5. mount
	mount /dev/md9 /linear

6. /etc/fstab - 영구적용하기
	vi /etc/fstab

==> /dev/md9  /linear ext4 defaults 1 2
```



##### 생성된 RAID 다시 원복하는 방법

```
1. vi /etc/fstab 에서 적용 삭제
2. umount /dev/md9
3. df를 통해 확인하자
4. mdadm --stop /dev/md9
5. rm -rf /dev/md/*

stop을 하고 삭제까지 해주자

(5. fdisk /dev/sdb
   fdisk /dev/sdc
   
   command (m for help) : d
   command (m for help) : w)
   
   fdisk는 의미 없었다,,
   
   
   reid 장점
   
```



##### RAID1 / RAID5

```
- data backup 기능을 갖는다
(RAID1 - mirroring / RAID5 - 패리티)

p363

디스크를 망가트리고 , RAID1 / RAID5의 복구기능을 확인해보자

- edit 에서 디스크 삭제
- 안전모드 입장 (비밀번호 입력)
- df     // mount된 RAID가 존재하지 않는 것을 확인할 수 있다
- mdadm --run /dev/md1      // 복구완료


안전모드에서 벗어나려면
망가진 디스크를 전부 STOP 시키고

- mdadm --stop /dev/md0

복구가능한 디스크 전부 RUN을 시킨후에

- mdadm --run /dev/md1

reboot 을 해줘야한다
```





##### LVM(Logical Volume Manager)

```
- 사용자들에게 할당되어지는 하드디스크 
- 가변적이다

 LVM 구현
fdisk - > pvcreate -> vgcreate -> lvcreate -> mkfs.ext4 -> mount -> etc/fstab


1) 파티션을 나누자
 fdisk /dev/sdb
 
command : n
select : p
partition number : 1
firstsector : enter
lastsector : enter
command : t
Hex Code : 8e

command : p
command : w   

2) 물리적인 볼륨 생성
 pvcreate /dev/sdb1  pvcreate /dev/sdc1

3) 볼륨 그룹 생성
 vgcreate myVG /dev/sdb1 /dev/sdc1
 
4) 볼륨 그룹의 파티션 생성
 lvcreate --size 1G --name myLG1 myVG   // 1GB할당
 lvcreate --size 3G --name myLG2 myVG
 lvcreate --extents 100%FREE --name myLG3 myVG  //나머지 용량 모두 할당


5) 포맷
 mkfs.ext4 /dev/myVG/myLG1
 mkfs.ext4 /dev/myVG/myLG2
 mkfs.ext4 /dev/myVG/myLG3

6) 마운트하자
 mkdir /lvm1 /lvm2 /lvm3    // 폴더생성
 mount /dev/myVG/myLG1 /lvm1
 mount /dev/myVG/myLG2 /lvm2
 mount /dev/myVG/myLG3 /lvm3

7) 영구 적용
vi /etc/fstab
에
/dev/myVG/myLG1  /lvm1  ext4 default 1 2
/dev/myVG/myLG2  /lvm2  ext4 default 1 2
/dev/myVG/myLG3  /lvm3  ext4 default 1 2

```



##### RAID에 CENTOS 설치

```
P393을 참고하여 RAID안에 CENTOS를 설치하자

swap개념

swap : 

- 리눅스에서 물리적 메모리(RAM)의 용량이 가득 차게될 경우 사용되는 여유 공간

- 시스템이 처리하고 있는 데이터를 저장할 RAM이 충분하지 않을 때 스왑 공간에 이 데이터를 기록

- 소량의 RAM을 사용하는 시스템에는 도움이 되지만, RAM을 대체할거라는 생각을 가지면 안된다


1) 이제 RAID 1의 결함 허용(BACKUP)이 잘되는지 확인하자

- RAID1의 하드디스크 2개중 하나 삭제하고 reboot
- mdadm --detail /dev/md/root     // RAID1 장치 확인

하드디스크 하나가 고장나도 운영체제는 잘 동작한다는 것을 확인할 수 있다

2) 다시 원상복귀 해보자

- 우선 하드디스크를 추가해주자 (새로 추가한 빈 디스크가 SCSI 0:0이면 부팅이 안 될 수 있기에 SCSI 0:2로 변경하자)
- fdisk -l /dev/sda 를 입력해 파티션을 확인하고 , 동일하게 /dev/sdb 장치의 파티션을 지정해주자

- fdisk /dev/sdb

/ sdb1 / 
 
command : n
select : p
partition number : 1
firstsector : enter
lastsector : sda1의 lastsector 값
command : t
Hex Code : fd

/ sdb2 / 

command : n
select : p
partition number : 2
firstsector : enter
lastsector : sda2의 lastsector 값
command : t
Hex Code : fd

command : w     // 설정저장


- 파티션이 지정 되면
   mdadm /dev/md/swap --add /dev/sdb1   //sda1와 동일하게
   mdadm /dev/md/root --add /dev/sdb2   //sda2와 동일하게
   
   지정해주자

```



