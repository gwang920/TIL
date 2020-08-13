###  INNER JOIN / OUTER JOIN

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
WHERE B.CODE IS NULL

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