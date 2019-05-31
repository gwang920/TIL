# I. Function

### Column안의 숫자를 조작하는 것

```
ABS - 절댓값
 ABS(수치)
 EX)ABS(-180) ==> 180
 
MOD - 나머지
 MOD(피제수,제수)  
 EX) MOD(7,3) ==>  1

ROUND - 반올림
 ROUND(대상 수, 반올림 자릿수)
 EX) ROUND(2.270,1) ==> 2.3

```

# II. String Function

### 문자열 함수

```
`
SELECT ENAME || ' ' || JOB AS EJOB FROM EMP;  // Column == EJOB
											// Column 속성 == ENAME 속성 + JOB 속성

`
SELECT LOWER(ENAME) || ' ' || JOB AS EJOB FROM EMP;
											// KING + PRESIDENT ==> king PRESIDENT
											
`
SELECT ENAME, SUBSTR(ENAME,1,3) FROM EMP; // 첫자부터 세번째자까지 STRING 에서 뽑기
										// ABCED ==> ABC

`
SELECT ENAME, SUBSTR(ENAME,1,3), 
REPLACE(ENAME,SUBSTR(ENAME,1,3),'AAA')
FROM EMP;
                                      // BCDEFG ==> AAAEFG
                                                                          
`
SELECT ENAME, SUBSTR(ENAME,1,4), 
-- 첫문자만 대문자로 만들어서 가져온다.
REPLACE(ENAME,SUBSTR(ENAME,2,LENGTH(ENAME)),
LOWER(SUBSTR(ENAME,2,LENGTH(ENAME))))
FROM EMP;                            //KING ==> King


`
SELECT ENAME,SAL,DEPTNO FROM EMP  // DEPTNO이 20이거나 30인
WHERE DEPTNO IN(20,30)   // == WHERE DEPTNO 20 OR DEPTNO 30
;

`
SELECT ENAME, HIREDATE,CURRENT_DATE,  // CURRENT_DATE 현재날짜(월/일/년) == SYSDATE
TO_CHAR(CURRENT_TIMESTAMP,'YYYY:MM:DD:HH:MM:SS')	
FROM EMP;							// TO_CHAR 형식지정 EX)2019:05:31:03:05:00
									// DATE 한정(?)
									
`
TO_CHAR(SYSDATE,'YYYY/MM') - TO_CHAR(HIREDATE,'YYYY/MM') // ERROR ==> (CHARACTER-														//		       CHARACTER)
												//SYSDATE - HIREDATE 가능 (숫자-숫자)
												
`
SELECT ENAME,SAL FROM EMP
WHERE SAL BETWEEN 2000 AND 5000 // 이상 ~ 이하
WHERE SAL >2000 AND <5000       // 초과 ~ 미만

```



# III. CASE

```
SELECT ENAME,
CASE WHEN JOB = 'PRESIDENT'
     THEN '왕'
     WHEN JOB = 'MANAGER'
     THEN '관리자'
     ELSE '직원'
END AS GRADE
FROM EMP;               // CASE문은 항상 조건 이외의 값들을 ELSE로 지정해줘야한다 + END
						// CASE ~ END 까지 하나의 Column ( GRADE로 Column명 바꾸자)
```