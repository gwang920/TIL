# R Programming

#### If Else

```R
felse : 주어진 test 값에 따라 yes 또는 no 값을 반환한다.

ifelse(
 test, # 참, 거짓을 저장한 객체
 yes, # test가 참일 때 선택할 값
 no # test가 거짓일 때 선택할 값
)
test에 다수의 TRUE, FALSE가 저장되어 있을 때 TRUE에 대해서는 yes 값을, FALSE에 대해서는 no 값을 선택하여 반환한다.


EX)

> x <- c(1, 2, 3, 4, 5)
> ifelse(x %% 2 == 0, "even", "odd")
[1] "odd" "even" "odd" "even" "odd"
```

#### FOR

```R
for (i in data) {
  i를 사용한 문장
}

data에 들어 있는 각각의 값을 변수 i에 할당하면서 각각에 대해 블록 안의 문장을 수행한다.


EX)

> for (i in 1:10) {
+    print(i)
+ }

결과

[1] 1
[1] 2
[1] 3
[1] 4
[1] 5
[1] 6
[1] 7
[1] 8
[1] 9
[1] 10


EX) 가변길이 함수

f1 <- function(...){
  
    args <- list(...)
    for(i in args){
      
        print(i)
      
    }
  
}

f1(1,2,3,4,5,6,7)

결과

[1] 1
[1] 2
[1] 3
[1] 4
[1] 5
[1] 6
[1] 7

EX) 짝수만 출력하기

f1 <- function(...){
  
    args <- list(...)    
    str(args)
    for(i in (...)){        #  for(i in args)로 하면 error
        if(i %% 2 == 0){    #  args list 자체를 인덱스 1로만 인식(?)
          print(i);
        }
    }
}

f1(c(1:100))


결과
[1] 2
[1] 4
.
.
.
[1] 100
```



#### Global Environment

```R
n <- 100
f1 <- function(){
  
    n <<-1     # 글로벌 변수가 바뀐다 (100 -> 1) 
    return (n) # n <-1 이면 리턴값은 1이나 글로벌변수는 100이된다
  
}


print(f1())

```

