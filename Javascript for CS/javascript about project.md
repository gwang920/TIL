# 1. express 기본 폴더 구조

```sqlite
-----------------------------------------------------------------------------------------
/public
/routes
/views

app.js
-----------------------------------------------------------------------------------------

* 참고
[public] 

정적 파일을 위한 폴더로서 자바스크립트 파일, 이미지 파일, CSS 등을 포함합니다. 웹URL의 루트폴더로 생각하시면 됩니다. 관리를 쉽게하기 위해 js와 css로 폴더를 구분했습니다. 

[routes] 

라우팅을 위한 폴더입니다. 라우팅 리소스 별로 모듈을 만들어 라우팅 로직을 구현합니다. 클라이언트에서 요청 별로 어떤 로직을 수행할지 정해놓은 파일이라고 생각하시면 됩니다. (java에서는 Controller 역할)

[views] 

request 요청에 대한 로직을 처리한 후 클라이언트에 응답을 보낼 때 html 코드로 변환해서 반환하는 파일을 정의한 폴더입니다.

[app.js] 

express  설정파일이 담겨있는 파일입니다.(파일 생성시 app.js로 생성됩니다.)
```

![image](https://user-images.githubusercontent.com/49560745/89726540-7d276d80-da56-11ea-9512-e0fe8e450d94.png)

# 2. 설정파일

## package.json

```
npm과 yarn을 통해 패키지를 하나씩 추가하게되면
수십개에서 수백개까지 패키지를 설치하게 된다.
이때 설치한 패키지의 이름과 버전을 기록해둘곳이 필요한데
이때 package.json에 기록된다.

따라서 노드로 프로젝트를 진행할 때는 package.json부터
만들고 시작하는 것이 좋다(기록을 위해)
```



## package-lock.json

```
1) package-lock.json 파일을 확인해보면 express 이외에도 node_modules에 들어있는 패키지 들의 정보가 있다. npm이나 yarn으로 패키지를 설치, 수정, 삭제 할때마다 내부 의존 관계를 이 파일이 저장한다.

2) package-lock.json 파일은 npm을 사용해서
node_modules 트리나 pakage.json 파일을 수정하게 되면 자동으로 생성되는 파일.
```

* 참고자료

[https://velog.io/@jayden/Package.json%EA%B3%BC-Package-lock.json-%EC%97%90-%EB%8C%80%ED%95%B4%EC%84%9C-gyk5hxige4](https://velog.io/@jayden/Package.json과-Package-lock.json-에-대해서-gyk5hxige4)



## config.js

```
DB에 관한 정보가 들어있다. 
(cofig 폴더는 DB 연결정보, API 키값 등 환경변수 정보 저장하는 곳이다.)

```

```javascript
const config = {
  db_info: {
    host: 'localhost',
    user: 'root',
    password: 'root123',
    port: 3306,
    database: 'boost',
    connectionLimit: 50,
    dateStrings: 'date',
    multipleStatements: true
  }
}

module.exports = config;
```

# 3. app.js

## app.js

```javascript
const express = require('express');
const app = express();
const path = require('path')
var cookieParser = require('cookie-parser');

const apiRouter = require('./routes/index');

const port = 80;

const getPath = (file) => {
  return path.join(__dirname + file);
}

// app.use는 미들웨어 요청이며, 요청이 올때마다 이 미들웨어를 거치며 클라이언트에게 응답
app.use(express.urlencoded({ extended: false }));
app.use(express.json());
app.use(express.static('public'));
app.use(cookieParser());
app.use('/api', apiRouter)


// get 이 눈에 보이는 요청을 처리한다면 post는 눈에 보이지 않는 주소를 요청받아 처리해주는 것
// 서버로 post를 보낸다.
app.post('/cookie', (req, res) => {
  const token = req.cookies.token;
  res.json({ login: (token ? token : null) });
})


// 해당 url로 sendfile 화면을 띄운다.
app.get('/', (req, res) => {  
  res.sendFile(getPath('/views/home.html'));
})

app.get('/login', (req, res) => {
  if (req.cookies.token) {      // 이미 로그인 되어있으면 root로 redirect
    return res.redirect('/');  
  }
  res.sendFile(getPath('/views/signin.html'))
})

app.get('/posts', (req, res) => {
  res.sendFile(getPath('/views/search_post.html'));
})

app.get('/posts/write', (req, res) => {
  if (!req.cookies.token) {
    return res.redirect('/login');
  }
  res.sendFile(getPath('/views/create_post.html'));
})

app.listen(port, () => {  // 포트연결
  console.log("start server");
});
```



# 4. 요청 흐름

```
게시판 글 검색의 흐름을 살펴보자
```

## 1) 사용자가 게시글 검색 버튼 클릭

```
검색 버튼이 클릭되면 id를 getElementById가 가로채고, serchByKeword를 실행한다.
```

- views/search_post.html

![image](https://user-images.githubusercontent.com/49560745/89727885-a00c4e80-da63-11ea-9133-c58b921bb2ab.png)



## 2) serchByKeyword 함수 실행

```
클릭 버튼으로 serchByKeyword 함수가 실행되고, await fetch의 경로로 전달된다(?)
```

- public/js/search_posts.js

![image](https://user-images.githubusercontent.com/49560745/89727292-1efe8880-da5e-11ea-98cb-d5b5660ac801.png)

## 3) routes의 index.js가 serach_posts.js의 경로를 가로챈다.

```
index.js가 경로를 가로채 컨트롤러에게 전달한다.
```

- routes/posts/index.js

![image](https://user-images.githubusercontent.com/49560745/89727562-0f347380-da61-11ea-889e-5cdaaa9f4a4e.png)

## 4) 컨트롤러는 model에게 요청한다.

```
index.js에 의해 serchPostByKeyword가 실행되고, model에게 결과값을 요청한다.
```

- routes/api/posts/posts.controller.js

![image](https://user-images.githubusercontent.com/49560745/89727709-26279580-da62-11ea-94f1-430d4c71edba.png)

## 5) model은 결과값(키워드에 해당하는 게시글)을 뱉어낸다.

- models/posts.js

![image](https://user-images.githubusercontent.com/49560745/89727161-3c7f2280-da5d-11ea-8158-e3144f16385d.png)







