# 맵리듀스

```
- HDFS에 저장된 파일을 분산 배치 분석을 할 수 있게 도와주는 프레임워크
- 제공되는 판 위에서 분석을 한다!

- Map + Reduce라는 두 가지 단계로 데이터를 처리

- Map은 특정 데이터를 가져와서 key와 value쌍으로 묶는다.
- Reduce는 맵에서 가져온 ket와 value의 쌍을 다시 내가 필요한 정보들을 키와 쌍으로 묶는다.


mapreduce 프로그램이 wordcount 밑에 있다

```

##### 맵리듀스 예제

```
# vi t1.txt 
 
  read a book

# vi t2.txt
 
  write a book

# hadoop jar hadoop-examples-1.2.1.jar wordcount /data/input /data/output

- 두개의 파일을 읽어서 맵을 만들고 리듀스 (취합과정) 작업을 한다

map (read1 / a1 /book1)
    (write1 / a1 / book1)
    
reduce (read1 / a1 /book1 /write1 / a1 / book1)


출력파일 ( read1 / a2 / book2 / write1)



```

