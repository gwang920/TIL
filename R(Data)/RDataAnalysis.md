# R 데이터 분석



```
- R : 데이터 분석 언어

- 통계를 기반으로한 데이터 분석

- 공짜지만 방대하고 세세한 설명서가 부족하다



프로젝트 생성 - > 프로젝트 스크립트 실행



run : 특정 범위만 실행 (line 단위)
source : 전체 파일범위를 실행
```



#### install / NA / NULL

```R
install.packages(
  pkgs,         # 설치할 패키지명 
  dependencies  # 기본값은 NA 며, pkgs가 동작하는 데 필요한 패키지를 설치한다. TRUE로 지정하면 
                # 이에 더해 패키지 제작자가 추천하는 패키지 역시 설치된다. 
)


패키지 받았는데 작동안하면

programfiles 밑에 있는 R폴더에서 해당 폴더삭제하고 다시 받기


-----------------------------------------------------------------------------


NA는 데이터 값이 없음을 뜻함


EX)

is.na : NA 값이 저장되어 있는지를 판단한다.

is.na(
   x # R의 데이터 객체 
)
NA가 저장되어 있으면 TRUE, 그렇지 않으면 FALSE를 반환한다.


> one <- 80
> two <- 90
> three <- 75
> four <- NA
> is.na(four)
[1] TRUE


EX) NA가 포함되었을 때 sum 구하기

d1 <- c(10,20,30,40,NA)
print(sum(d1,na.rm=TRUE))

결과

[1] 100

-----------------------------------------------------------------------------

NULL은 객체를 뜻하며, 변수가 초기화 되지 않았을 때 사용


EX)

is.null : 변수에 NULL이 저장되어 있는지를 판단한다.

is.null(
   x  # R의 데이터 객체 
)
반환 값은 NULL이 저장되어 있으면 TRUE, 그렇지 않으면 FALSE다.



> x <- NULL
> is.null(x)
[1] TRUE
> is.null(1)
[1] FALSE
> is.null(NA)
[1] FALSE
> is.na(NULL)
logical(0)
Warning message:
In is.na(NULL) : is.na() applied to non-(list or vector) of type 'NULL'


EX) NULL가 포함되었을 때 sum 구하기 

d1 <- c(10,20,30,40,NULL)
print(sum(d1))

결과

[1] 100

```



#### 문자열

```R
> a <- "hello"
> print(a)
[1] "hello"
> a <- 'hello'
> print(a)
[1] "hello"

```

#### Factor

```R
팩터 : 범주형 데이터


> sex <- factor("m", c("m", "f"))
> sex
[1] m
Levels: m f



data <- factor("b",c("b","m","s"));
print(data)
print(levels(data)[1])
print(levels(data)[2])
print(levels(data)[3])

> source('C:/Rstudio/r1/r02.R')
[1] b
Levels: b m s
[1] "b"
[1] "m"
[1] "s"

```

#### 벡터

```R
- index가 1부터 시작한다
- c를 이용해 사용한다


a <- c(1,3,5);
b <- c(1:5);
c <- c(1,3,c(4:6))

print(a);
print(b);
print(c)

결과
 
[1] b
Levels: b m s
> print(levels(data)[1])
[1] "b"
> print(levels(data)[2])
[1] "m"
> print(levels(data)[3])
[1] "s"

-

score <- c(100,90,80)
names(score) <- c("lee","kim","seo")  // names는 컬럼의 명칭을 지정할 수 있다
print(score)

결과

> print(score)
[1] 100  90  80
> score <- c(100,90,80)
> names(score) <- c("lee","kim","seo")
> print(score)
lee kim seo 
100  90  80 



--
identical : 두 벡터가 동일하냐 ?!를 묻는 것

> identical(c(1, 2, 3), c(1, 2, 3))
[1] TRUE
> identical(c(1, 2, 3), c(1, 2, 100))
[1] FALSE

--
%in% : 벡터에 포함되었냐 ?!를 묻는 것

> "a" %in% c("a", "b", "c")
[1] TRUE
> "d" %in% c("a", "b", "c")
[1] FALSE

--
rep : 반복된 값을 저장한다


rep : 주어진 값을 반복한다.

rep(
   x,      # 반복할 값이 저장된 벡터 
   times,  # 전체 벡터의 반복 횟수 
   each    # 개별 값의 반복 횟수 
)
반환 값은 반복된 값이 저장된 x와 같은 타입의 객체다.

EX)

> rep(1:2, times=5)
[1] 1 2 1 2 1 2 1 2 1 2
```



#### 시퀀스

```R
seq : 시퀀스를 생성한다.

seq(
  from,  # 시작 값 
  to,    # 끝 값 
  by     # 증가치 
)
from부터 to까지의 값을 by 간격으로 저장한 숫자 벡터를 반환한다.


EX)

a <- c(1:10)
b <-seq(1,10,3)
print(a)
print(b)


결과

> source('C:/Rstudio/r1/r03.R')
[1]  1  2  3  4  5  6  7  8  9 10
[1]  1  4  7 10
```





#### 리스트

```R
list : 리스트 객체를 생성한다.

list(
   key1=value1, 
   key2=value2, 
   ... 
)
반환 값은 key1에 value1, key2에 value2 등을 저장한 리스트다.



EX)

a <- list(name=c("kim","seo","lee","lim"),score=c(90,10,30,70))

print(a[2])
print(a$name[1])    // a의 name을 지칭할 때

결과

> source('C:/Rstudio/r1/r04.R')
$score
[1] 90 10 30 70

[1] "kim"

EX) 	

a <- list(s1=c(80,90,70,88),s2=c(90,10,30,70))

print(mean(a$s1))
print(mean(a$s2))
print(mean(a))               // 오류 발생 (NA)
print(mean(a$s1+a$s2))			// 두 벡터의 평균 합
print(mean(c(mean(a$s1),mean(a$s2))))     // 두 벡터의 평균

결과

> print(mean(a$s1))
[1] 82
> print(mean(a$s2))
[1] 50
> print(mean(a))
[1] NA
Warning message:
In mean.default(a) : 인자가 수치형 또는 논리형이 아니므로 NA를 반환합니다
> print(mean(a$s1+a$s2))
[1] 132
> print(mean(c(mean(a$s1),mean(a$s2))))
[1] 66


**************

80 70
s1의 첫번째 원소와 s2의 4번째 원소의 평균 구하기
print(mean(c(a$s1[1],a$s2[4])))       // 평균을 구할 때 벡터를 이용하자

결과 : 75 

print(mean(a$s1[1],a$s2[4]))

결과 : 80
 

```

#### 행렬

```R
- 한 가지 유형만 저장 가능 (숫자 + 문자 불가능)
- 2차원 배열이라고 생각하자




matrix : 행렬을 생성한다.

matrix( 
   data,          # 행렬을 생성할 데이터 벡터 
   nrow,          # 행의 수 
   ncol,          # 열의 수 
   byrow=FALSE,   # TRUE로 설정하면 행우선, FALSE일 경우 열 우선으로 데이터를 채운다. 
   dimnames=NULL  # 행렬의 각 차원에 부여할 이름 
)



EX)

matrix(c(1, 2, 3, 4, 5, 6, 7, 8, 9), nrow=3)



결과

> matrix(c(1, 2, 3, 4, 5, 6, 7, 8, 9), nrow=3)
     [,1] [,2] [,3]
[1,]    1    4    7
[2,]    2    5    8
[3,]    3    6    9


// row 순으로 지정 된다 (byrow default 값)





Ex)


matrix(c(1, 2, 3, 4, 5, 6, 7, 8, 9), nrow=3)


data <- c(1:9)
ma <-matrix(data,nrow=3)
rownames(ma) <- c("r1","r2","r3")
colnames(ma) <- c("c1","c2","c3")


print(ma[2,3])

print(ma[2:3,2:3])


print(mean(c(ma[2:2,1:3])))         // r2의 평균

print(mean(c(ma[1:3,3:3])))        // c3의 평균



결과


> print(ma[2,3])
[1] 8
> 
> print(ma[2:3,2:3])
     [,1] [,2]
[1,]    5    8
[2,]    6    9


[1] 5
[1] 8



ma <- matrix(c(1:6),nrow=3)
print(nrow(ma))
print(ncol(ma))


```

#### 데이터 프레임

```R
- 엑셀의 스프레드시트와 같이 표 형태로 정리한 모습을 하고 있다.


data.frame : 데이터 프레임을 생성한다.

data.frame(
   # value 또는 tag=value로 표현된 데이터 값. '...'은 가변 인자를 의미한다.
   ...,
   # 주어진 문자열을 팩터로 저장할 것인지 또는 문자열로 저장할 것인지를 지정하는 인자.
   # 기본값은 보통 TRUE다. 따라서 이 인자를 지정하지 않으면 문자열은 팩터로 저장된다.
   stringsAsFactors=default.stringsAsFactors()
)
반환 값은 데이터 프레임이다.

EX)

  x y  z
1 1 5 10
2 2 6 11
3 3 7 12
4 4 8 13
5 5 9 14


df1 <- data.frame(x=c(1:5),y=c(5:9),z=c(10:14))

print(df1$x)
print(df1[2,])    // 2행을 가져와라
print(df1$x[3])  
print(df1[3,1])
print(df1["y"])
print(df1[,2])   // 2열을 가져와라



결과

> print(df1$x)
[1] 1 2 3 4 5
> print(df1[2,])
  x y  z
2 2 6 11
> print(df1$x[3])
[1] 3
> print(df1[3,1])
[1] 3
> print(df1["y"])
  y
1 5
2 6
3 7
4 8
5 9
> print(df1[,2])
[1] 5 6 7 8 9


*********

df2 = df1[2:5,2:3]
df2=df1[c(2:5),c(2:3)]    // 두 결과는 같다

결과

  y  z
2 6 11
3 7 12
4 8 13
5 9 14

***********
컬럼 추가

df1 <- data.frame(
  
  "lee" = c(90,99,89,87),
  "kim" = c(91,98,81,86),
  "han" = c(92,97,82,85),
  "jun" = c(93,96,83,84),
  "goo" = c(94,95,84,83),
  "grade"=c("A","B","A","A")
)

each <- c(mean(df1$lee),mean(df1$goo),mean(df1$han),mean(df1$jun),mean(df1$kim))

print(mean(df1$"lee"))
print(mean(df1$"kim"))

print(mean(df1$"han"))
print(mean(df1$"jun"))
print(mean(df1$"goo"))

print(mean(each))

str(df1)
df1$lee <- c(0,0,0,0)
df1$hong <- c(100,100,100,100)
print(df1)

결과


> source('C:/Rstudio/r1/r07.R')
[1] 91.25
[1] 89
[1] 89
[1] 89
[1] 89
[1] 89.45

'data.frame':	4 obs. of  6 variables:
 $ lee  : num  90 99 89 87
 $ kim  : num  91 98 81 86
 $ han  : num  92 97 82 85
 $ jun  : num  93 96 83 84
 $ goo  : num  94 95 84 83
 $ grade: Factor w/ 2 levels "A","B": 1 2 1 1
 
  lee kim han jun goo grade hong
1   0  91  92  93  94     A  100
2   0  98  97  96  95     B  100
3   0  81  82  83  84     A  100
4   0  86  85  84  83     A  100




**********

컬럼삭제

df1 <- data.frame(
  
  a=c(1:4),
  b=c(5:8),
  c=c(9:12),
  d=c("A","B","A","B")
)


rownames(df1) <- c("aa","bb","cc","dd")
print(df1)

df2 <- df1[,-4]
print(df2)

결과

> source('C:/Rstudio/r1/r08.R')
   a b  c d
aa 1 5  9 A
bb 2 6 10 B
cc 3 7 11 A
dd 4 8 12 B

   a b  c
aa 1 5  9
bb 2 6 10
cc 3 7 11
dd 4 8 12
```





#### 형 변환

```R
df1 <- data.frame(
  
  a=c(1:4),
  b=c(5:8),
  c=c(9:12),
  d=c("A","B","A","B")
)


class(A)   // A의 타입을 반환한다

> class(df1[1,])
[1] "data.frame"
> class(df1$a)
[1] "integer"

df2 <- df1[,-4]
print(mean(as.numeric(df2[1,])))   // 평균을 구하기 위해 형변환을 해준다


```





##### 실습#1

```R
data <- data.frame(
  
  
  "lee" =c(90,70,88,33),
  "kim" =c(91,76,91,94),
  "hwan" =c(92,86,97,43),
  "lim" =c(93,81,94,40),
  "kang" =c(94,83,91,42),
  "han" =c(95,77,66,76)
  
)

sum_col <- c(sum(data[1:1,1:5]),sum(data[2:2,1:5]),sum(data[3:3,1:5]),sum(data[4:4,1:5]))
mean_col <- sum_col/5

data$avg <- mean_col
data$sum <- sum_col

sum_row <- c(sum(data[1:4,1:1]),sum(data[1:4,2:2]),sum(data[1:4,3:3]),sum(data[1:4,4:4]),sum(data[1:4,5:5]),sum(data[1:4,6:6]))
mean_row <-sum_row/5
  
sum_total <- sum(sum_col,sum_row)
avg_total <- sum_total/10
data[5:5,1:6] <-mean_row
data[6:6,1:6] <-sum_row/10

data[5:5,7:7] <- avg_total
data[6:6,8:8] <- sum_total



print(data)



결과


  lee  kim hwan  lim kang  han    avg  sum
1 90.0 91.0 92.0 93.0   94 95.0   92.0  460
2 70.0 76.0 86.0 81.0   83 77.0   79.2  396
3 88.0 91.0 97.0 94.0   91 66.0   92.2  461
4 33.0 94.0 43.0 40.0   42 76.0   50.4  252
5 56.2 70.4 63.6 61.6   62 62.8 3452.0   NA
6 28.1 35.2 31.8 30.8   31 31.4     NA 3452



추가 - 특정 조건을 만족하는 값 출력하기 

data2 <- data[data$lee >= 80,]    
print(data2)


결과

lee kim hwan lim kang han  avg sum
1  90  91   92  93   94  95 92.0 460
3  88  91   97  94   91  66 92.2 461


```



