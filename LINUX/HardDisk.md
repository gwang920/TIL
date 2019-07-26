# 하드디스크 관리



IDE방식 (cd-rom)-> SATA(Serial ATA)방식





Vmware 



server



하드디스크 추가하기

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

