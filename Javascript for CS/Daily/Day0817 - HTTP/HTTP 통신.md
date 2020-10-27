# HTTP 통신

## HTTP request

- 구조

![image](https://user-images.githubusercontent.com/49560745/90780227-40eaeb80-e339-11ea-8370-eae850975c2b.png)

```
1) start Line (요청 내용)
 - HTTP 메소드 / Request target / HTTP version
2) Header
 - HTTP 요청 그 자체에 대한 정보를 담고 있다
3) Body
 - HTTP 요청이 전송하는 데이터를 담고 있는 부분
```

## HTTP Response

- 구조

![image](https://user-images.githubusercontent.com/49560745/90782635-0d5c9100-e33a-11ea-88a7-7c1784507f68.png)

```
1) status Line (요청 내용)
 - HTTP 메소드 / Request target / HTTP version
2) Header
 - HTTP 요청 header와 동일
3) Body
 - HTTP 요청 body와 동일
```



## HTTP 메서드 종류

- GET

```
GET 요청 방식은 URI가 가진 정보를 검색하기 위해 서버측에 요청하는 형태
```

- POST

```
POST 방식도 GET과 마찬가지로 요청하는 메소드이지만 BODY에 데이터를 넣어보낸다.

GET은 URL에 정보를 보내는 점과 상반된다.
```

- HEAD

```
HEAD 요청 방식은 GET과 유사한 방식이다.

차이점은 웹 서버에서 헤더 정보 이외에는 어떤 데이터도 보내지 않는다.
```

- PUT

```
 POST와 유사한 전송 구조를 가진다.
 헤더 이외에 데이터가 함께 전송된다.

 원격지 서버에 지정한 콘텐츠를 저장하기 위해 사용되며 홈페이지 변조에 많이 악용되고 있다.
```

- DELETE

```
단어 그대로 원격지 웹 서버에 파일을 삭제하기 위해 사용된다.
PUT <-> DELETE

PUT과 DELETE는 서로 반대되는 개념
```

- CONNECT

```
웹 서버에 프락시 기능을 요청할 때 사용한다.
```







# reference

```
https://velog.io/@yoju/HTTP-RESTful-HTTP-API
https://ychae-leah.tistory.com/82
```

