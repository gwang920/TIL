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



# * 참고

## PythonShell - node에서 python파일 불러오기

```javascript
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



## 루트디렉토리내의 파일읽어오기

```javascript
fs.readdir

const testFolder = './tests/';
const fs = require('fs');

fs.readdir(testFolder, (err, files) => {
  files.forEach(file => {
    console.log(file);
  });
});
fs.readdirSync

const testFolder = './tests/';
const fs = require('fs');

fs.readdirSync(testFolder).forEach(file => {
  console.log(file);
});

-------------------------------------------------------------------------------
두 메소드의 차이점은 첫 번째 메소드는 비동기 적이므로 읽기 프로세스가 종료 될 때 실행될 콜백 함수를 제공해야한다는 것입니다.

두 번째는 동기식이며 파일 이름 배열을 반환하지만 읽기 프로세스가 끝날 때까지 코드의 추가 실행을 중지합니다.
```

## 상대경로 error

```javascript
require로 함수를 가져와 쓸 때
함수가 path를 가지고 있다면
이 경로를 require한 파일 기준으로 맞춰줘야한다.

아래는 CTRimgfilter.js 코드이다.
readfile() 함수를 만약 userrouter.js에서 require해와 사용하려면
testFolder의 경로를 userrouter.js기준으로 바꿔줘야한다.

CTRimgfilter.js 기준으로 uploads의 상대경로는 ../../uploads 이지만
userrouter.js 기준으로 uploads의 상대경로는 ../uploads이다.

따라서 userrouter.js에서 readfile() 을 사용하려면
const testFolder = './uploads'; 
이와 같이 경로를 지정해줘야한다.
```

![image](https://user-images.githubusercontent.com/49560745/90326039-4f927500-dfbe-11ea-808b-aa620d0067e1.png)



## 파일 이름 설정

```javascript
로컬에서 파일을 업로드할 때 파일명이 임의로 설정된다.
보안상 의도된 것인데 아래와 같이 설정하면 본 파일명으로 설정할 수 있다.

const upload = multer({
  storage: multer.diskStorage({
    destination: function (req, file, cb) {
      cb(null, 'uploads/');
    },
    filename: function (req, file, cb) {
      cb(null, file.originalname); // 원래 파일명으로 설정한다.
    }
  }),
});
```

* 참고 https://www.zerocho.com/category/NodeJS/post/5950a6c4f7934c001894ea83

