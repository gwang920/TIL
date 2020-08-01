# 스프링 개발 환경 구축

# 1. JDK

```shell
1) jdk 다운로드 후 경로 설정 C:/java/jdk1.8 하고 설치하자!
2) path 설정하자
  
  1. window + R -> sysdm.cpl 실행 -> 고급 -> 환경변수 -> 사용자변수 새로만들기
	-> 변수이름 : JAVA_HOME / 경로 : jdk - path (ex:D:\java/jdk-14.0.2)
	
  2. 시스템 변수
	변수 PATH 선택 후 편집 -> bin PATH 경로 복사 후 Paste
				(path 경로는 ';' 세미콜론으로 구분된다.)
				
-----------------------------------------------------------------------------------------
 	* 시스템 변수 설정 시 JAVA_HOME\bin으로 하니 설정이 잘안된다.
 	  그냥 path 전체경로를 붙여넣자.
	* CLASS_PATH는 설정안해도 됐다(?)
	필요시에 CLASS_PATH도 설정해주자.
-----------------------------------------------------------------------------------------

3) 설치 확인하자
	cmd 창에 메시지 입력

	1. java -version
	
	C:\Users\gwangguen>java -version
	java version "14.0.2" 2020-07-14
	Java(TM) SE Runtime Environment (build 14.0.2+12-46)
	Java HotSpot(TM) 64-Bit Server VM (build 14.0.2+12-46, mixed mode, sharing)
	
	2. javac -version

	C:\Users\gwangguen>javac -version
	javac 14.0.2

	위 메시지가 나오면 설치가 완료된 것!
```

# 2. 이클립스

```
1) Ecilpse 다운로드
2) Eclise IDE for Java EE Developers 선택 (주로 웹 프로그래밍에 맞는 버전이다.)
3) 설치 위치를 설정하자.
4) 라인센스 동의 (디폴트로 가면 된다.)
5) 설치 후 launch 할 때 workspace 폴더를 만들어주자.
* 참고
https://offbyone.tistory.com/12
```

# 3. 스프링

```shell
스프링 설치 방법은 두 가지다.
1) 스프링 홈페이지에서 다운로드
	* 참고
	https://all-record.tistory.com/154
2) 이클립스 marketplace 이용
	HELP -> EclipseMarketplace -> sts 검색 후 다운로드
```

# 4. 메이븐

```shell
메이븐 홈페이지에서 맞는 버전 다운로드
경로는 자유롭게 설정하고, 압축만 풀면 설치 완료!

(가능하면 설치파일을 한 곳으로 설정하자)

이것도 JDK와 마찬가지로 환경 변수 세팅이 필요하다.

	1. window + R -> sysdm.cpl 실행 -> 고급 -> 환경변수 -> 사용자변수 새로만들기
	-> 변수이름 : MAVEN_HOME / 
	   경로 : maven - path (ex) D:\apache-maven-3.6.3-bin\apache-maven-3.6.3
	
	2. 시스템 변수
		변수 PATH 선택 후 편집 -> bin PATH 경로 복사 후 Paste
		(path 경로는 ';' 세미콜론으로 구분된다.)
		
		(ex) ~;D:\apache-maven-3.6.3-bin\apache-maven-3.6.3\bin
```

# 5. 톰캣

```
1) 아파치 톰캣 다운로드
2) 경로는 자유롭게 설정하고, 압축풀면 설치완료
```

# 6. 오라클

```
Oracle 11g 

그리드의 개념이 더욱 강해진 버전.

* 그리드 컴퓨팅(grid computing)은 분산된 컴퓨팅 자원을 초고속네트워크로 모아 아주 큰 서버같이 보이도록 하는 것이라 할 수 있다. 따라서 성능을 일정 수준 이상으로 극대화 하는 개념이다.
```

# 7. 설치 오류 모음

```javascript
1) multiple annotation found at this line
	
	해결방법
	1. 에러코드를 지웠다 다시 붙여넣기
	2. 라이브러리 재 설정
	
	프로젝트 우클릭
	-> build path -> configuration build path
	-> jre system library 삭제
	-> 우측 add library 클릭
	-> jre system library선택하고 , jdk 선택후 적용
	
2) jdk 설치 시 Internel error 61003. 오류
 
  	해결방법
  	
  	이 오류가 발생하고, 확인버튼을 누르면 경로를 변경하라한다.
  	이때, 새로운 폴더를 만들고 경로를 지정하고 설치를 진행하면 된다.
    
3) failed to start 톰캣 오류

	해결방법
	
	톰캣라이브러리를 추가한다.
	-> build path -> configuration build path
	-> 우측 add library 클릭
	-> tomcat 9.0 선택 후 적용
```



