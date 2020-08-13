# mysql - nodejs - docker 연동 오류 모음

## 1. npm ENOTFOUND 에러

![image](https://user-images.githubusercontent.com/49560745/90104467-4c5d7600-dd7f-11ea-8063-dce336f5189f.png)

```
npm ENOTFOUND 에러 처리
입력 
> npm config delete proxy
```

## 2. mysql ENOTFOUND 에러

![image](https://user-images.githubusercontent.com/49560745/90129473-b0923100-dda3-11ea-852d-23af9dfe7067.png)

```
nodejs와 docker내 mysql 연동시 위와 같은 에러가 발생했다.

크게 원인은 두 가지 인것 같다.
1) host 설정 오류
2) 3306 포트 오류
=> 로컬내에 다른 mysql과 포트번호가 겹쳐서 발생하는 것 같다.
```

#### 1) host 설정오류

```
아래 코드는 오류가 발생할 때의 세팅이다.
host에 문제가 있을 줄 상상도 못하고
port, user, database를 신나게 바꿔줬다.

권한 문제일 수도 있어 권한도 여러번 설정해줬지만 그대로 enotfound했다.
```

```javascript
let mysql=require('mysql2');
let connection=mysql.createConnection({
    host : 'localhost',
    user : 'root',
    password:'password',
    database:'mydb1',
    port:'9876'
});

connection.connect();

connection.query('SELECT * FROM t',(err,t)=>{
    if(err){
        console.log(err)
        console.log('조회 에러')
    }else{
        console.log(t);
        console.log('완료');
    }
})

connection.end();
```

```
host를 바꿔주니 해결 됐다.
= > 192.168.99.100

해당 ip는 mysql 내에서 조회되는 ipaddress 주소가 아닌
도커 내에 설치된 mysql setting에서 확인할 수 있었다.
```

![image](https://user-images.githubusercontent.com/49560745/90130052-bc322780-dda4-11ea-91f8-49ba76b5244f.png)

```javascript
let mysql=require('mysql2');
let connection=mysql.createConnection({
    host : '192.168.99.100',
    user : 'root',
    password:'password',
    database:'mydb1',
    port:'9876'
});

connection.connect();

connection.query('SELECT * FROM t',(err,t)=>{
    if(err){
        console.log(err)
        console.log('조회 에러')
    }else{
        console.log(t);
        console.log('완료');
    }
})

connection.end();
```

![image](https://user-images.githubusercontent.com/49560745/90129944-88570200-dda4-11ea-904a-80b52bb88d78.png)

