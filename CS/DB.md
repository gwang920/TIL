## 데이터베이스

### 1. 데이터베이스를 사용하는 이유

```
파일처리 시스템의 문제점을 해결하기 위해서

1) 중복 : 파일처리시스템은 각 파일마다 필요한 데이터를 각각 가지고 있어야 하므로 시간,노력,경제비용에 있어 효율이 없다.

2) 비일관성 : 데이터에 변경이 발생하면 각 파일에서 해당하는 데이터를 모두 변경해야하므로 수정에 문제가 있고, 한꺼번에 수정이 되지않으면 데이터 값이 파일마다 달라지는 문제가 발생한다.

3) 응용 프로그램 개발 문제 : 파일 시스템은 파일의 용도에만 맞춰서 제작되기에 다른 프로그램을 만드려면 다시 데이터베이스 작업을 해줘야한다.

4) 데이터 베이스 관리 문제 : 데이터가 여러 파일에 산재되어 있고, 그 파일마다 데이터베이스 양식이 다르기 때문에 일률적인 검색이나 추가 작업이 어렵다.
```

### 2. DB/DBS/DBMS

```
- 데이터베이스 : 공유되어 사용될 목적으로 통합하여 관리되는 표준 데이터 집합
- 데이터베이스 시스템(DBS) : 데이터베이스를 생성,저장,관리하는 시스템
						 DB + DBMS를 포괄하는 개념으로 시스템 전체를 의미한다.
					 
- 데이터베이스 관리 시스템(DBMS) : 다수의 사용자들이 데이터베이스 내의 데이터를 접근할 수 있도록 해주는 소프트웨어 도구의 집합
DB 자체만을 가지고 데이터를 이용하면 매우 불편하다. DBMS내에 내장된 질의어들을 통해 사용자들은 DB에 효율적으로 접근할 수 있다.
(예: 오라클,SQL,MYSQL)

DBS VS DBMS

DBS는 데이터베이스 시스템 그 자체를 의미하고, DBMS는 사용자와 응용프로그램에게 편리하고 효율적인 데이터베이스 환경을 제공하는 DBS의 구성요소중 하나이다.
```

- 데이터베이스 시스템(DBS) 구성요소

```
[일반사용자]					   [데이터베이스 관리시스템] [데이터베이스]
				     <==>  	  [데이터 언어]
[데이터베이스 관리자]   
```

### 3. 데이터베이스 특징

```
1. 데이터 독립성 
  - 물리적 독립성 : 데이터베이스의 사이즈를 늘리거나 성능 향상을 위해 데이터 파일을 늘리는 등 데이터베이스의 변경이 있더라도 관련된 응용프로그램을 수정할 필요가 없다.
  - 논리적 독립성 : 데이터베이스는 논리적인 구조로 다양한 응용 프로그램의 논리적 요구를 만족할 수 있다.
  
2. 데이터 무결성
  - 여러 경로를 통해 잘못된 데이터가 발생하는 경우를 방지하는 기능
  - 데이터 유효성검사를 통해 데이터의 무결성을 유지한다.
  
3. 데이터 보안성
  - 인가된 사용자들에 한해서 데이터베이스에 접근가능하도록 한다.
  
4. 데이터 일관성
  - 연관된 정보를 논리적인 구조로 관리함으로써 어떤 데이터만 변경했을 때 발생할 수 있는 데이터의 불일치성을 배제할 수 있다.
  - 일부데이터가 변경되더라도 나머지 데이터와 일치하지 않는 경우를 배제할 수 있다.
  
5. 데이터 중복 최소화 
  - 데이터 베이스는 데이터를 통핪해서 관리함으로써 파일 시스템의 단점 중의 하나인 자료의 중복, 데이터의 중복 문제를 해결할 수 있다.
  
   
* 
일관성 vs 무결성

일관성(Consistency) : 사용자가 조회 또는 변경하는 데이터는 그 작업을 마칠 때까지 다른 사용자에 의해서 변경되지 못하게 한다.

무결성(Integrity) : 데이터베이스의 데이터와 구조는 변경된 순서대로 전체 데이터베이스에 적용된다.

- 프로젝트 개념(?)
일관성(Consistency) : 시스템을 구현하는 기능의 의미는 처음 시스템의 목적이 바뀌기 전까지 다른 시스템의 각부에서도 같은 의미이어야 한다.

무결성(Integrity) : 시스템의 기능의 의미가 바뀐다면 그 바뀐 기능과 관련된 다른 부분에서도  똑같이 적용되어야한다.


출처: https://silverktk.tistory.com/243 [Insight..]
-----------------------------------------------------------------------------------------  
- 실시간 접근성(Real-Time Accessibility) : 비정형적인 질의(조회)에 대하여 실시간 처리에 의한 응답이 가능해야 합니다.

- 계속적인 변화(Continuous Evolution) : 데이터베이스의 상태는 동적입니다. 데이터의 삽입, 삭제, 갱신으로 항상 최신 데이터를 유지해야 합니다.

- 동시 공용(Concurrent Sharing) : 데이터베이스는 서로 다른 목적을 가진 여러 응용자들을 위한 것이므로 다수의 사용자가 동시에 같은 내용의 데이터를 이용할 수 있어야 합니다.
=> 데이터 무결성

- 내용에 의한 참조(Content Reference) : 데이터베이스에 있는 데이터를 참조할 때 데이터 레코드의 주소나 위치에 의해서가 아니라 사용자가 요구하는 데이터 내용으로 찾습니다.
```

### 4. 데이터베이스 성능

```
데이터베이스의 성능 이슈는 디스크 I/O를 어떻게 줄이느냐에서 시작된다.
(I/O - INPUT & OUTPUT)

랜덤 I/O VS 순차 I/O

디스크 I/O란 디스크 드라이브의 플래터(원판)을 돌려서 읽어야 할 데이터가 저장된 위치로 디스크 헤더를 이동시킨 후 데이터를 읽는 것을 의미한다. 
(쉽게 말해 우리가 데이터를 작성하고 변경할 때 디스크 즉, HDD에 그것이 저장되는 것을 말한다.)
이 때 데이터를 읽는데 걸리는 시간은 디스크 헤더를 움직여서 읽고 쓸 위치로 옮기는 단계에서 결정된다. 즉 디스크의 성능은 디스크 헤더의 위치 이동 없이 얼마나 많은 데이터를 한 번에 기록하느냐에 따라 결정된다고 볼 수 있다.

위와 같은 작업을 순차 I/O라고 볼 수 있는데, 랜덤 I/O는 순차 I/O에 비해 여러번 읽기 또는 쓰기 요청을 한다.(작업 부하가 커짐)


현실에서는 대부분 랜덤 I/O로 작업이 이루어지는데 랜덤 I/O를 순차 I/O로 바꾸려는 시도로부터 시작되는 
데이터베이스 쿼리 튜닝은 랜덤 I/O자체를 줄여주는 목적을 갖는다.
```

### 5. INNER JOIN / OUTER JOIN

```
조인(JOIN)이란 2개 이상의 테이블을 엮어 조회하는 것이다.

INNER JOIN은 서로 매칭되는 것만 조회하는 것이다.
OUTER JOIN은 매칭 되는 것뿐만 아니라 미매칭 데이터도 함께 조회한다.

outer join은 left outer join, inner outer join, full outer join으로 나뉜다.
이때 left, right는 미매칭 데이터도 죄회할 테이블 방향이라고 할 수 있다.
따라서 left outer join은 왼쪽에 있는 테이블이 매칭여부와 관계없이 모두 나오게 된다.


       TABLE A             TABLE B
	IDX IDX_NAME         IDX IDX_NAME
	 1     A			  2    B
	 2     B			  3    C


1) 테이블 A에만 존재하는 IDX 조회

SELECT * FROM A LEFT OUTER JOIN B ON A.IDX=B.IDX
WHRER B.CODE IS NULL

[결과]
	IDX IDX_NAME          IDX  IDX_NAME
	 1     A			  null   null
	 	 
2) 테이블 A의 모든 IDX는 매칭여부와 관계없이 모두 조회

SELECT * FROM A OUTER JOIN B ON A.IDX=B.IDX

[결과]
	IDX IDX_NAME          IDX  IDX_NAME
	 1     A			  null   null
	 2     B				2	  B
	 
3) 테이블 A와 테이블 B의 매칭되는 IDX만 조회

SELECT * FROM A INNER JOIN B A.IDX=B.IDX

[결과]
	IDX IDX_NAME          IDX  IDX_NAME
	 2     B				2	  B
	 
4) 테이블 A에만 존재하는 IDX와 테이블 B에만 존재하는 IDX를 조회

SELECT * FROM A INNER JOIN B ON A.IDX= B.IDX
WHERE A.IDX IS NULL OR B.IDX IS NULL

[결과]
	IDX IDX_NAME          IDX  IDX_NAME
	 1     A			  null  null
	null  null			   3     c
```

### 6. VIEW(가상테이블)

```
VIEW 특징
- 뷰는 사용자에게 접근이 허용된 자료만을 제한적으로 보여주기 위해 하나 이상의 기본 테이블로부터 유도된, 이름을 가지는 가상테이블이다.
- 뷰는 물리적으로 존재하지 않지만 사용자에게 있는 것처럼 간주된다. (뷰를 통해 데이터를 관리할 수 있다.)
- 뷰는 복잡한 Quert를 얻을 수 있는 결과를 간단한 Query로 얻을 수 있게한다.

VIEW 사용 목적
- 보안관리를 목적으로 사용(보안성)
=> 뷰를 보면 컬럼과 데이터만 공개되므로 원천 테이블은 알 수 없다.
- 편의를 목적으로 사용(편리성)
- 수행속도의 향상을 목적으로 사용(속도 향상)
- SQL 성능을 향상시킬 목적으로 사용(활용성)
- 임시적인 작업을 위해 사용


VIEW 기능을 사용하여 테이블을 만들면 매번 복잡한 쿼리문을 돌지않고 이미 만들어진 테이블을 불러오므로 속도가 빨라지는 장점이 있다.
(자주 사용하는 조회 쿼리문이 있을 때 이를 뷰 테이블로 만들어놓으면 효율적인 작업이 가능하다.)

* VIEW 테이블 VS 임시테이블
뷰는 삭제하지 않으면 계속 남아있는 가상테이블이고
임시테이블은 세션이 끝나면 자동으로 삭제된다.
+ 
뷰테이블은 WITH READ ONLY 등 과같은 기능을 사용할 수 있어 보안상 더 유리하다.
```

### 7. 인덱스

```
인덱스를 책에 비유하자면 책의 맨 처음에 있는 색인, 목차와 같다.
이때, 데이터는 책의 내용이 될것이고, 데이터가 저장된 레코드의 주소는 인덱스 목록에 있는 페이지번호가 된다.
DBMS는 데이터베이스에서 원하는 데이터를 가져오려면 데이터베이스에 있는 모든 테이블을 검색해야하기에 시간이 오래걸린다.
그래서 컬럼의 값과 레코드가 저장된 주소값을 키와 값의 쌍으로 인덱스를 만들어주는 것이다.(인덱스 테이블 생성)7,7

DBMS의 인덱스는 항상 정렬된 상태를 유지한다. 그렇기에 검색에는 유리하지만 새로운 값을 추가하거나 수정하는 경우 성능이 좋지않다.(쿼리문의 실행속도가 느려진다.)
결론적으로 DBMMS의 인덱스는 데이터의 저장 성능을 희생하여 데이터의 검색 효율을 향상시키기 위해 사용한다.
```

#### 7-1. 인덱스 자료구조

```
1) B +Tree 인덱스 알고리즘
 일반적으로 사용되는 인덱스 알고리즘은 B+ Tree 알고리즘이다. B+Tree 알고리즘은 트리구조를 갖되 하나의 부모에 여러개의 자식을 가질 수 있다.
 
 ex)
 [7,11] 부모 노드에 [5,6,8,9,13,14]의 데이터를 삽입한다면
 B+Tree 구조는 다음과 같다
 		
 		[7,11]
 	 /     |	\	
 [5,6]   [8,9]  [13,14]
 
  부모노드값보다 작은경우 왼쪽, 큰 경우 오른쪽 노드에 저장된다.
  
2) Hash 인덱스 알고리즘
  Hash 자료구조는 키,값 쌍으로 데이터가 저장되어 매우 빠른 검색을 지원한다.
  
  * 해시함수
  - 해시 함수는 임이의 길이를 갖는 메시지를 입력받아 고정된 길이의 해시값을 출력(고정된 길이의 데이터로 매핑)하는 함수 또는 더 짧은 길이의 값으로 변환하는 함수
  - 키 값으로 코드가 저장되어 있는 주소(혹은 색인)를 산출하는 함수
  
  * 해싱
  하나의 문자열을 원래의 것을 상징하는 더 짧은 길이의 값이나 키로 변환하는 것.
  
3) 왜 데이터베이스 index를 생성하는데 B+Tree를 사용하나?
  데이터 접근하는 시간복잡도가 O(1)인 Hash Table이 더 효율적으로 보인다.
  SELECT 질의의 조건에는 부등호(<>) 연산도 포함된다. Hash Table에서 등호(=)연산이 아닌 부등호 연산을    하는 경우 문제가 발생한다. 그렇기에 동등연산에 특화된 Hash는 부등호 연산이 #### 7필요한 데이터베이스의 자료구조에 적합하지않다.
```

#### 7-2. 인덱스 성능과 고려해야할 점

```
SELECT 쿼리의 성능을 향상시키는 INDEX는 항상 좋지만은 않다.

* INSERT, DELETE, UPDATE 쿼리문을 실행할 때 별도의 과정이 추가적으로 발생한다.

	INSERT의 경우 INDEX에 대한 데이터를 추가해야하므로 그만큼 성능에 손실이 있다.
	
	DELETE의 경우 INDEX에 존재하는 값을 삭제하는 것이 아닌 사용 안한다는 표시가 남는다.
	=> 죽, row수는 그대로인 것이다. 이 작업이 계속해서 반복된다면
	실제 데이터는 1000건인데 데이터가 10만건이 있는 결과를 낳을 수도 있다.
	
	UPDATE의 경우는 INSERT,DELETE 두 경우의 문제점을 모두 수반한다.
	=> UPDATE는 이전 데이터를 삭제하고 새 데이터를 삽입하는 개념이기 때문이다.
	
* 인덱스 활용 법
- 전체 데이터 중 10~15% 이내의 데이터를 검색할 때 사용하면 효율적이다.
- 두 개이상의 컬럼이 WHRER절이나 JOIN 조건으로 자주 사용되는 경우 인덱스를 생성하는 것이 효율적이다.
- 한 테이블에 저장된 데이터 용량이 상당히 클 경우 유리하다.
- 가능 한 수정이 빈번하게 일어나지 않는 컬럼을 설정한다.
	

* 고려사항
- 인덱스를 위한 추가 공간이 필요하다.
- 지나치게 많은 인덱스는 많은 오버헤드를 발생시킨다.
- NULL 값을 가지는 컬럼의 인덱스 ENTRY는 생성되지않는다.
```

### 8. Statement vs PreparedStatement

```
Statement와 PreparedStatement는 SQL을 실행할 수 있는 객체이다

Statement

1. 단일로 사용될 때 빠른 속도를 갖는다.
2. 쿼리에 인자를 부여할 수 없다.
3. 매번 컴파일을 수행해야 한다.


PreparedStatement

1. 쿼리에 인자를 부여할 수 있다.
2. 처음 프리컴파일 된 후, 이후에는 컴파일을 수행하지 않는다.
3. 여러번 수행될 때 빠른 속도를 지닌다.


가장 큰 차이는 
"
Statement는 매번 실행시 파싱과정을 거치게 된다.
PreparedStatement는 실행시 여러번 반복하더라도 파싱과정을 한번만 한다.
"
인듯하다.

DBMS에 SQL 명령을 실행시키면
DBMS는 SQL구문을 해석하고 실행계획을 작성합니다. 그리고 수행합니다.
많은 DBMS는 반복적인 SQL이 실행될 때 효율을 높이기 위해 SQL문을 키로 실행계획을 캐싱합니다.

Ststement 를 사용하게 되면 파라미터가 달라질 경우 다른 SQL문으로 인식하여 구문분석과 실행계획을 다시 작성합니다.
PreparedStatement를 사용하면 실행계획은 재사용 될 수 있습니다. 

-출처 https://okky.kr/article/355434?note=1129877
-----------------------------------------------------------------------------------------

select * from user
    
    -> parse(구문분석) -> bind(치환) -> execute(실행) -> patch(인출)
    
    * select 구문 실행 단계
    
    statement를 사용해 select문을 입력했을 때 매번 위의 단계를 거친다.
    반면, preparedstatement를 사용하면 최초 1회 parse과정을 거친후 이후에는 생략가능하다.
    이때, select된 데이터가 메모리 어딘가에 저장이 되고 필요할 때마다 이 메모리에 접근해서 사용하는 것이다.
    
    
우선 속도 면에서 PreparedStatement가 빠르다고 알려져 있다. 
이유는 쿼리를 수행하기 전에 이미 쿼리가 컴파일 되어 있으며, 
반복 수행의 경우 프리 컴파일된 쿼리를 통해 수행이 이루어지기 때문이다.

PreparedStatement에는 보통 변수를 설정하고 바인딩하는 static sql이 사용되고 Statement에서는 쿼리 자체에 조건이 들어가는 dynamic sql이 사용된다. PreparedStatement가 파싱 타임을 줄여주는 것은 분명하지만 static sql을 사용하는데 따르는 퍼포먼스 저하를 고려하지 않을 수 없다.

하지만 성능을 고려할 때 시간 부분에서 가장 큰 비중을 차지하는 것은 테이블에서 레코드(row)를 가져오는 과정이고 SQL 문을 파싱하는 시간은 이 시간의 10 분의 1 에 불과하다. 그렇기 때문에 SQL Injection 등의 문제를 보완해주는 PreparedStatement를 사용하는 것이 옳다.

* 바인딩
메서드와 객체를 묶어놓은 것

예를들면 A라는 객체가 있고, B라는 객체에 GO()라는 메서드가 있다.
이때, A객체에서 A.GO()가 실행되도록하는것이 바인딩이라 할 수 있다.
```

### 9. 엔터티(Entity), 속성(Attribute)

```
1 - 엔터티

1) 엔터티란 ?

엔터티는 쉽게 말해 실체,객체라고 할 수 있다.
쉽게말해 실제 업무에서 사용되는 데이터 집합이다.

- 엔터티는 사람,장소,물건,사건,개념 등과 같은 명사에 해당된다.
- 엔터티는 업무상 관리가 필요한 것에 해당된다.
- 엔터티는 저장되기 위한 어떤 것(Thing)에 해당된다.

ex) 커피숍이라는 곳에선 커피라는 엔터티가 존재할 수 있다.
그리고 엔터티는 인스턴스의 집합으로 나타나게 된다.
이때, 커피라는 엔터티가 있다면 아이스아메리카노,그린티라떼,초코라떼와 같은 인스터스들이
엔터티에 포함되는 것이다.


2) 엔터티의 특징
- 반드시 엔터티가 사용되는 곳의 업무에서 필요하며 관리하고자 하는 정보
- 엔터티가 포함하는 인스턴스에 대해 "유일한 식별자"로 식별이 가능해야 함
   EX) 사원번호 (가능), 이름(불가능 WHY? 동명이인)
- 엔터티는 지속적으로 존재하는 "두개" 이상의 인스턴스들의 조합이어야 함
- 엔터티는 반드시 속성을 지녀야 함
- 엔터티는 업무 프로세스에 의해서 이용되어야 함
- 엔터티는 다른 엔터티와 최소 한 개 이상의 관계가 있어야 함


3) 엔터티의 분류
  3)-1 실체유형 (유무형)에 따른 분류
  - 유형엔터티(Tangible Entity)
   물리적인 형태가 존재하는 엔터티이며 안정적이고 지속적으로 활용되는 엔터티
   ex) 사원,물품,자료 등
  - 개념 엔터티(Conceptual Entity)
   물리적인 형태는 존재하지 않고 관리해야 할 개념적인 정보로 구분되는 엔터티
   ex) 조직,보험상품 등
  - 사건 엔터티(Event Entity)
   업무를 수행함에 따라 발생되는 엔터티
   ex) 주문,청구,미납 등
  
  3)-2 발생시점에 따른 분류
  - 기본/키 엔터티(Fundamental/Key Entity)
	해당 업무에 원래 존재하는 정보로 다른 엔터티와의 관계에 의해 발생 또는 생성되지 않고 "독립적으로 존재하는 엔터티"이다. 이는 독립적으로 생성이 가능하며 다른 엔터티의 부모역할을 한다.
	ex) 사원, 부서, 고객, 상품 등
	
  - 중심 엔터티(Main Entity)
    기본 엔터티로 부터 발생되며 업무에 있어서 중심적인 역할을 한다. 일반적으로 데이터 양이 많으며 "다른 엔터티와의 관계를 통해 행위 엔터티를 생성"한다.
	 ex) 계약, 사고, 청구, 주문 등

  - 행위 엔터티(Active Entity)
    "두 개이상의 부모엔터티로 부터 주로 발생"되고, 자주 엔터티의 내용이 바뀌거나 데이터양이 증감한다. 분석초기 단계보다는 상세 설계단계나 프로세스와 상관모델링을 진행하면서 도출될 수 있다.
	 ex) 주문목록, 사원변경이력 등


출처: https://doorbw.tistory.com/227 [Tigercow.Door]


2 - 속성

1) 속성이란?

  - 엔터티의 항목
  - 업무에 필요한 데이터를 저장하는 분리되지 않는 최소 단위
  - 오직 하나의 속성 값을 갖는다
   이와 반대되는 개념 <=> 다중값 속성
   						- 속성 하나에 여러개의 속성값을 가지는 경우
   						ex) 전화번호(집,핸드폰 등 다양한 값을 가짐)
   						- 하나의 엔터티에 포함 될 수 없음
   						- 1차 정규화 또는 별도의 엔터티를 만들어야 한다.
  - 주식별자에게 종속된다.
  
2) 속성의 종류
  2) -1 특성에 따른 분류
   - 기본속성
    업무에서 도출되는 본래 속성
    ex) 제품명,제조년월,제조원가 등
   - 설계속성
    데이터 모델링 과정에서 발생하는 속성
    유일한 값 부여
    ex) 상품코드, 사원번호
   - 파생 속성
     다른 속성에 영향을 받아 발생하는 속성
     보통 다른 속성의 계산값이 된다.
     ex) 평균값, 합계
     
    - 엔터티 구성방식에 따른 분류
   
   2) -2 엔터티 구성방식에 따른 분류
    - PK속성
      엔터티를 식별할 수 있는 속성
      유일한 값 부여 ex) 사원번호
      
    - FK속성
      다른 엔터티와의 관계를 연결하는 속성
      보통 다른 엔터티의 PK속성
      
    - 일반속성
      엔터티에 포함되어 있으나 PK,FK에 포함도지 않는 속성
      ex) 사원명,주소 등
      
      
      
 *
 엔터티 -> 테이블
 속성 -> 컬럼(열),애트리뷰트
 인스턴스 -> 튜플(행),레코드
 엔터티셋 -> 레코드 집합
 엔터티타입 -> 속성 집합
 카디날리티 -> 릴레이션 튜플의 개수
 
 
```

### 10. 릴레이션 vs 테이블

```
릴레이션 vs 테이블

릴레이션은 테이블이라 할 수 있다.
하지만, 둘은 작은 차이를 보인다.
결론부터 얘기하면 릴레이션은 모두 테이블이지만, 테이블은 모두 릴레이션이 아닐 수 있다.

대표적인 릴레이션의 특징을 얘기하자면
1) 릴레이션에 속한 두 열은 같은 이름을 가질 수 없다.
2) 릴레이션은 한 열의 모든 값들이 동일한 종류여야한다.
3) 릴레이션은 동일한 행을 가질 수 없다


--------------
ID | PS | NAME
--------------
A    11   대통배
B    22   쿠팡
B    22   쿠팡
---------------

위 테이블은 릴레이션이 아니다.
릴레이션은 동일한 행을 가질 수 없다.

--------------
ID | PS | NAME
--------------
A    11   대통배
B    22   쿠팡
22   SSG
---------------

 위 테이블은 릴레이션이다.
-----------------------------------------------------------------------------------------
* oracle 다중 insert

mysql 구문에 따라

insert into tablename
(컬럼1,컬럼2,컬럼3)
values(값1,값2,값3),(값4,값5,값6),..,(..);

위와 같이 다중 insert를 하면 syntax오류 난다.

오라클에서는 아래와 같이 다중 insert 할 수 있다.

insert all
  into a (컬럼1,컬럼2,컬럼3) values (값1,값2,값3)
  into a (컬럼1,컬럼2,컬럼3) values (값4,값5,값6)
select * from a  
  
  
  * insert all 을 사용할 때 테이블이 비어있으면 실행되지않는다(?)
```

### 11. 정규화

```
1) 정규화의 배경
 한 릴레이션에 여러 엔터티의 애트리뷰트들을 혼합하게 되면 정보가 중복 저장되며, 저장공간을 낭비하게 된다.
 그뿐만 아니라 중복된 정보로 인해 "갱신 이상"이 발생한다. 
 동일한 정보를 한 릴레이션에서는 변경하고, 나머지 릴레이션에서 변경하지 않는 경우 어느 것이 정확한지
 알 수 없다. 
 이러한 문제를 해결하기 위해 정규화를 한다.
 
 1) -1 갱신이상
  삽입 이상 - 원하지 않는 자료가 삽입된다든지, 삽입하는데 자료가 부족해 삽입이 되지않아 발생하는 문제
  삭제 이상 - 하나의 자료만 삭제하고 싶지만, 그 자료가 포함된 튜플(행) 전체가 삭제 되는 문제
  수정(갱신) 이상 - 정확하지 않거나 일부의 튜플만 갱신되어 정보가 모호해지거나 일관성이 없어져 정확한
  				 정보파악이 되지 않는 문제
  				 

2) 정규화란 무엇인가 ?
  관계형 데이터베이스에서 중복을 최소화하기 위해 데이터를 구조화 하는 작업이다.
  다시 말해 "불만족스러운" 릴레이션의 애트리뷰트(열,속성)들을 나누어서 "만족스러운" 작은 릴레이션으로 분해하는 작업이다.
  정규화 과정을 거치면 정규형을 만족하게 된다.
  정규형이란 특정 조건을 만족하는 릴레이션의 스키마 형태를 말하며 제 1정규형,제 2정규형,제 3정규형,.. 등이 존재한다.
  
  * 스키마
  스키마는 데이터베이스의 구조와 제약 조건에 관한 전반적인 명세를 기술한 메타데이터의 집합
 
 2) -1 "불만족스러운" 릴레이션이란?
  엔터티를 구성하고 있는 애트리뷰트간에 함수적 종속성을 판단한다. 
  판단된 함수적 종속성은 좋은 릴레이션설계의 기준이 된다.
  즉, 각각의 정규형마다 어떠한 함수적 종속성을 만족하는지에 따라 정규형이 정의되고,
  그 정규형을 만족하지 못하는 정규형을 나쁜 릴레이션으로 판단한다.
  
 2) -2 함수적 종속성이란?
  어떤 기준 X에 의해서 다른 것들(Y)이 고유하게 구분된다면 Y는 X에 종속되었다하고,
  이를 함수적 종속성이라한다.
  
  
  ID 	NAME	DEP
  20    KIM	  컴퓨터공학과
  30	SEO	   수학과
  40    YOO    신방과
  
  위와 같은 릴레이션에서 함수적 종속성을 보자면
  NAME 과 DEP는 ID에 의해서 고유하게 구분되므로 NAME과 DEP는 ID에 함수적으로 종속되었다 할 수 있다.
  여기서 ID는 결정자가 되고, NAME,DEP는 종속자가 된다.
  
  이를 기호로 표현하면
  ID -> (NAME,DEP)
  이다.
  
  2) -3 각각의 정규형은 어떠한 조건을 만족해야하는가?
    1. 분해의 대상인 분해 집합 D는 무손실 조인을 보장해야한다.
    2. 분해집합 D는 함수적 종속성을 보존해야한다.
```

#### 제 1 정규형

```
1차 정규형은 각 로우마다 컬럼의 값이 1개씩만 있어야 한다. 이를 컬럼이 원자값(Atomic Value)를 갖는다고 한다. 예를 들어, 아래와 같은 경우 카페라떼의 사이즈 컬럼 값이 2개이므로 1차 정규형을 만족하지 못한다.
```

[![image](https://user-images.githubusercontent.com/49560745/85359011-1e626f00-b550-11ea-997f-f2e8874974b2.png)](https://user-images.githubusercontent.com/49560745/85359011-1e626f00-b550-11ea-997f-f2e8874974b2.png)

 * 1차 정규형을 만족하지 못하는 릴레이션

```
이를 해결하기 위해 다음과 같이 테이블을 표현할 수 있다.
한개의 로우를 더 추가해 1차 정규형을 만족시킨다.
데이터의 논리적 구성을 위해 이 부분을 희생하는 것이다.
```

[![image](https://user-images.githubusercontent.com/49560745/85359150-7600da80-b550-11ea-817b-ce008742f312.png)](https://user-images.githubusercontent.com/49560745/85359150-7600da80-b550-11ea-817b-ce008742f312.png)

 * 1차 정규형을 만족하는 릴레이션

#### 제 2 정규형

```
2차 정규화부터 본격적인 정규화의 시작이라 할 수 있다.
2차 정규형은 테이블의 모든 컬럼이 완전 함수적 종속을 만족하는 것이다.
즉, 기본키중에 특정 컬럼만 종속된 것(부분적 종속)이 없어야 한다는 것이다.

위의 테이블을 보면 기본키는 커피종류와 사이즈 두개로 볼 수 있다.
이 두개가 합쳐져야만 한 로우를 구분할 수 있다.
근데 가격의 경우 커피종류에만 종속되어 있다. 즉, 커피종류를 알면 가격을 알 수 있다.
따라서 가격이 두 번들어가는 것은 불필요한 것으로 본다.
```

[![image](https://user-images.githubusercontent.com/49560745/85359588-a4cb8080-b551-11ea-8248-a7b7cad07e62.png)](https://user-images.githubusercontent.com/49560745/85359588-a4cb8080-b551-11ea-8248-a7b7cad07e62.png)

 * coffee_type Table

[![image](https://user-images.githubusercontent.com/49560745/85359734-0db2f880-b552-11ea-9c1b-ed9c34415e45.png)](https://user-images.githubusercontent.com/49560745/85359734-0db2f880-b552-11ea-9c1b-ed9c34415e45.png)

 * size_type Table

```
이를 해결하기 위해 위와 같이 테이블을 쪼갠다.
이때 위 테이블은 2차 정규형을 만족시킨다.
위 테이블 같은 경우 삽입/삭제/갱신 이상을 겪지 않는다. 
하지만, 테이블이 더 복잡해질경우 갱신이상이 발생하는데 이를 해결하는 것이 바로 3차 정규화이다.
```

#### 제 3 정규형

```
제 2 정규형에 속하면서
기본키가 아닌 모든 속성이 기본키에 이행적 함수 종속이 되지 않으면 제 3 정규형이다.

이행적이란 말은 삼단논법 관계를 갖는 함수적 종속이라 할 수 있다.
X->Y 이고 Y->Z 이면 X->Z이고 Z가 X에 이행적으로 함수 종속되었다고 한다.
```

[![image-20200623141249769]()

[](https://github.com/gwang920/TIL/blob/master/CS/TechInterview.md)

```
위 그림의 종속관계를 살펴보면
학번 -> 학과
학번 -> 등록금
학과 -> 등록금

이다.

학번 -> 학과 -> 등록금 이므로 2차 등록금은 학번에 2차종속형이라 할 수 있다.
그런데, 따지고보면 학과에 의해 등록금이 결정되는 것이지
학번에 의해 결정되는 것이 아니다.
따라서, X -> Y -> Z 에서 [X,Y] [Y,Z]로 테이블을 분류하면 제 3정규형이 만족된다.
즉, 학번  -> 학과 -> 등록금 [학번,학괴] [학과,등록금]
```

[![image](https://user-images.githubusercontent.com/49560745/85363661-6c7d6f80-b55c-11ea-8168-ad8102cef745.png)](https://user-images.githubusercontent.com/49560745/85363661-6c7d6f80-b55c-11ea-8168-ad8102cef745.png)

 * 학번 테이블

[![image](https://user-images.githubusercontent.com/49560745/85363761-ad758400-b55c-11ea-96fc-e48c5ea8c728.png)](https://user-images.githubusercontent.com/49560745/85363761-ad758400-b55c-11ea-96fc-e48c5ea8c728.png)

 * 학과 테이블

### 12. DB Optimizer

```
why optimizer?

DB에서 데이터를 조회하고, 저장하는 작업이 거의 대다수!
서버의 70% 이상이 SQL 처리시간!

따라서, SQL 처리 시간만 최적화해도 성능을 크게 향상할 수 있다.
```

#### 쿼리처리 흐름

````
1) 사용자가 작성한 쿼리를 parser에 전달한다. 
2) Parser
(문법적인 오류를 찾는다, 컴파일의 느낌?)
3) Optimizer(실행계획, 비용평가)

 Opimizer는 인덱스의 유무, 데이터 분산 또는 편향 정도 등의
 통계정보를 참고하여 "여러 실행계획을 작성하고",
 이들의 "비용을 연산"하고,
 "가장 낮은 비용을 가진 실행계획을 선택"하는 DBMS 핵심엔진
 
 => 만일 통계정보가 부정확하거나, 통계량이 적을 때는
 우리가 수동으로 실행계획을 짜야한다.

4) 플랜평가
````

#### 실행계획

```
MYSQL 기준

쿼리문에 explain을 붙이면 실행계획이 나온다.

explain
select *
from
user;
```

#### 최적화 예제

````
SELECT hobby,max(respondent)
FROM survey_results_public
WHERE respondent < 100
GROUP BY hobby;

쿼리 처리 시간 약 1초!
````

| id   | selet_type | Table                       | Type | Rows  | Extra                                 |
| ---- | ---------- | --------------------------- | ---- | ----- | ------------------------------------- |
| 1    | SIMPLE     | survey_results<br />_public | ALL  | 72522 | Using temporary,<br />Using file sort |

```
1)
TYPE : ALL => Table Full Scan
테이블의 모든 row에 접근 => 가장 비효율적인 방법

2) EXTRA : Using temporary, Uing File sort
Using temporary : 쿼리를 처리하는 동안 중간결과를 담아두기 위한 임시테이블

Using file sort : 결과를 정렬
=> 정렬할 필요가 없을땐 없애는게 어떨까?
```

#### Full Table Scan

```
Full Table Scan이 더 유리한 경우

- 테이블의 크기가 작을 때
- 조건절이 없을 때(where,on)
- 조건에 일치하는 레코드 수가 굉장히 많을 때

그러나!
예제 테이블은
1) 테이블 대용량
2) Where 존재
3) 결과 집합 고작 2개

따라서, index scan을 해보는게 어떨까?
```

#### 무엇을 인덱스로 잡을까

````
resondent,hobby 순으로 인덱싱

후보1) create index repondent_hobby_index on survey_results_public(respondent,hobby);

hobby, respondent 순으로 인덱싱

후보2) create index hobby_repondent_index on survey_results_public(hobby,respondent);
````

