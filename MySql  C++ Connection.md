# MySql / C++ 연동


##### version

```
Tool : Visual studio 2019
Mysql : Mysql Server 5.7
```



##### 연동 방법

```
정리가 된 사이트를 참고했다

https://potatoggg.tistory.com/62

- 설치 중에 오류사항을 기록하기 위해 설치 해보자
```







```c++
#include <my_global.h>
#include <mysql.h>
#include <iostream>
#pragma comment(lib,"libmySQL.lib")
#define DB_HOST "127.0.0.1"
#define DB_USER "root"
#define DB_PASS "111111"
#define DB_NAME "test"
#define CHOP(x) x[strlen(x)-1]=' '

int main(void)
{

	MYSQL* connection = NULL, conn;
	MYSQL_RES* sql_result;
	MYSQL_ROW sql_row;
	int query_start;


	char name[12];
	char address[80];
	char tel[12];
	char query[255];

	mysql_init(&conn);

	connection = mysql_real_connect(&conn, DB_HOST, DB_USER,
		DB_PASS, DB_NAME, 3306, (char *)NULL, 0);

	if (connection == NULL)
	{

		fprintf(stderr, "Mysql connection error :%s", mysql_error(&conn));
		return 1;
	}

	query_start = mysql_query(connection, "select * from login");
	
	if (query_start != 0) {

		fprintf(stderr, "Mysql connection error :%s", mysql_error(&conn));
		return 1;
	}

	sql_result = mysql_store_result(connection);


	printf("ID 비밀번호\n");

	while ((sql_row = mysql_fetch_row(sql_result)) != NULL) {

		printf("%s %s \n", sql_row[0], sql_row[1]);
	}

	mysql_free_result(sql_result);

	printf("Insert Value \n");
	printf("이름 :");
	fgets(name, 12, stdin);
	CHOP(name);

	printf("비밀번호 :");
	fgets(address, 80, stdin);
	CHOP(address);

	sprintf(query, "insert into login vlaues""('%s','%s')",
		name, address
	);

	query_start = mysql_query(connection, query);
	if (query_start != 0)
	{

		fprintf(stderr, "Mysql connection error :%s", mysql_error(&conn));

		return 1;
	}

	mysql_close(connection);
}


```







##### c++ 라이브러리

```
https://stanford.edu/~stepp/cppdoc/

```













##### 오류 및 참고

```
- 라이브러리 꼬리물기(?) 오류
 라이브러리를 추가하면 해당 라이브러리에 포함된 라이브러리 파일이 없다
(why ? mysql 버전을 8.1로 설치하고, 5.7을 이용한 연동방법을 참고했다) 
 
- Visual Studio에서 운영체제의 bit 수를 변경하면 모든 환경설정을 다시 해주어야한다

x64 / x86


```





```

```









