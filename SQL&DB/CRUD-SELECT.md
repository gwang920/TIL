# I. CRUD

 #####  C --> INSERT

  ##### READ

 #####  UPDATE

 #####  DELETE



### II. FK(Foreign Key)

##### - FK는 PK를 참조한다

```
학생table 

  학번(pk)    이름       학과번호(fk)

	1901     신동빈          a11

    1902     마용득          a11

	1903     이건희          a12

	1904     이재용          a12

 

학과table

학과번호(pk)   		학과명

   a11           전기전자과

   a12           컴퓨터공학과
```



# III. SELECT 문

##### 질의 쿼리

```
SELECT * FROM (테이블 명);  // 전체 추출
SELECT A,B FROM (테이블 명);  // 일부 추출

`
SELECT ENAME,SAL,DEPTNO AS DNO  // AS 키워드 : COLUMN 명칭이 바뀐다
FROM
EMP;

`
SELECT ENAME,SAL,SAL*12 AS ASAL,DEPTNO AS DNO  // SAL*12를 ASAL COULMN명으로
FROM
EMP;

`
SELECT ENAME,SAL,SAL*12 AS "ANN SAL",DEPTNO AS DNO  // COLUMN명 띄어쓰기 필요할 때
FROM
EMP; 

`
SELECT 
ENAME||JOB  // 두개의 String 합치기
A || ' ' || B // 공백삽입
ENAME || ' ' || SAL // String + Number == String
FROM
EMP;

`
DISTINCT(JOB) // JOB 중복 없이 나열 ==> JOB이 X 개

`
SELECT * FROM EMP
WHERE JOB = 'MANAGER';

`
SELECT * FROM EMP           // AND절을 여러번 쓸 수 있다
WHERE JOB = 'MANAGER'
AND SAL >2500				// SAL이 2500보다 
AND HIREDATE > '04/15/1981'; // 날짜도 가능     

`
SELECT * FROM EMP
WHERE JOB = 'MANAGER'
AND ENAME LIKE 'C%';   // C로 시작하는 것, %A% ==> A가 포함된 것

`
SELECT * FROM EMP     //주석
-- where statement.   // 한 줄 주석
/*					  // 포함 주석
Multi Comments ..
*/
WHERE JOB = 'MANAGER'
AND ENAME LIKE 'C%';

`
SELECT ENAME,SAL,
-- 연봉을 계산 하시오 단, SAL의 세금은 13%, COMM의 세금은 12%
((SAL*12)*0.87) + (NVL(COMM,0)*12*0.88) AS ANSAL  // NVL ==> NULL값이 있어도 계산가능
FROM EMP					// NVL없이 계산하면 NULL 값이 하나라도 포함되면 NULL로 표시
WHERE ((SAL*12)*0.87) + (NVL(COMM,0)*12*0.88) > 30000; // ANSAL > 30000 (X)
													  // ANSAL은 단순 COLUMN명
													  
`
WHERE ((SAL*12)*0.87) + (NVL(COMM,0)*12*0.88) <> 52200; // <> NOT EQUAL 이면 출력
						// NVL(널을 포함하는 표현식의 소스 값,널을 변활할 대상 값)
`
SELECT ENAME,NVL2(COMM,'0','1') FROM EMP  // COMM이 있으면 1 없으면 0 표시

`
SELECT * FROM EMP
WHERE COMM IS NULL;   // COMM = NULL; (X) NULL은 비교연산이 안됨

`
SELECT * FROM EMP
WHERE (SAL <2000
AND DEPTNO=30)
OR ENAME LIKE '%E%';  // AND OR 조건의 적용(괄호 여부에 따라) 순서 생각해보기

`
SELECT ENAME,SAL FROM EMP
ORDER BY SAL   // 정렬 Default 오름차순 == ASC

`
SELECT ENAME,SAL FROM EMP
WHERE SAL > 1000
AND DEPTNO = 20
ORDER BY 1   // ORDER BY 순서는 항상 마지막 ==> 조건을 모두 만족한 후에 동작
			 // 1열 정렬 / ORDER BY 2  2열 기준 정렬
			 
`
SELECT * FROM EMP     //COMM 에는 NULL값 포함
ORDER BY COMM DESC    // NULL 값부터 정렬된다
;


SELECT * FROM EMP WHERE HIREDATE<'01/01/1982' AND HIREDATE>'12/31/1980'
ORDER BY JOB,SAL DESC;   // DATE '월/일/년'

`

```


