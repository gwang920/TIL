# express

## express 기본구조 패키지 설치

```
npm i -g express-generator
express learn-express --view=pug
cd .\learn-express\
npm i
#package.json 에 있는 디펜던시들이 모두 설치됨
npm start
```

![image](https://user-images.githubusercontent.com/49560745/90303849-c3644d00-deec-11ea-8662-7f9f8acbe114.png)

## 미들웨어

```
중간 처리를 위한 함수

1) express 프레임워크에서 중간 처리 역할 ( 구조 처리 )
2) request - response 응답을 주기로 종료
3) 먼저 로드되는 미들웨어 함수가 먼저 실행됨 

 코드에서 app.use 안에 들어가는 함수가 모두 미들웨어이다!
 (app.use(), app.METHOD() 미들웨어 함수를 로드하기 위해 호출해야함)
```

```javascript
/* app.js */
var upload = require('./routes/upload');
app.use('upload', upload);
 
/* ./routes/upload.js */
router.get('/', function (req, res, next) {
  res.render('upload', { title: "파일 업로드" });
});

```

## 라우팅

```
클라이언트가 서버로 접속할때는 특정한 URL를 통해 접속한다. 
서버에서는 이 URL에 해당하는 자원을 클라이언트로 보내준다. 
혹은 POST요청일 경우는 자원을 만들기도 한다. 
이러한 클라이언트 요청을 위한 URL 스키마를 라우트라고 한다. 
서버에서는 라우팅 작업을 통해 클라이언트와 통신의 인터페이스를 제공해 준다. 
익스프레스에서 중요한 것 중 하나가 이 라우팅 모듈이다. 
```

- 기본 라우팅 설정

```javascript
var express=require("express")
var app = express()

app.get("/users",function(req,res){
	res.send("users")
})

// 해당 URI의 메소드로 요청이 들어오면
// 구현한 함수가 동작한다.
// req는 클라이언트 요청정보가 들어있다(요청쿼리나, 요청 바디 접근시 사용)
// res는 클라이언트 응답을 위한 객체
```

참고 http://jeonghwan-kim.github.io/express-js-2-%EB%9D%BC%EC%9A%B0%ED%8C%85/](http://jeonghwan-kim.github.io/express-js-2-라우팅/)





## Node js Express 정적 파일 서비스

```

사용자 폴더에서 web상으로 정적 파일 업로드하기

https://m.blog.naver.com/PostView.nhn?blogId=luvtoma&logNo=221140934971&proxyReferer=https:%2F%2Fwww.google.com%2F
```





```
 main.js => 루트 이면 router로 보내라
 => index.js => comment라는 URI로 요청이오면 RTComment로 가라
 => CTRcomments.js => DBcomments.js 
```





filter.js

```
var {PythonShell} = require('python-shell');

var options = {
    mode: 'text',
    pythonPath: '',
    pythonOptions: ['-u'],
    scriptPath: '',
    args: ['value1']
  };
  // 상대경로(?) 오류
  //C:\Users\User\Downloads\relay_05-master\relay_05-master\back_flask\appropriate-filetering\api.py
    PythonShell.run('C:\Users\User\Downloads\relay_05-master\relay_05-master\back_flask\appropriate-filetering\api.py', options, function (err, results) {
    if (err) throw err;
    console.log('results: %j', results);
  });
```

