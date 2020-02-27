# 백준 - 16985 Maaaaaaaaaze

- 카테고리 : 완전탐색

```c++
3차원 배열 탐색 문제

실패코드
1) 출발, 도착 블록 결정하기
	꼭지점 (0,0) , (0,4) , (4,0) , (4,4) 중 최소 한곳이 1인 판을 백터에 저장한다.
2) 남은 블록 순서정하기
 	2(상,하판 배열) x 3!
3)  모든 블록 회전하기
	(0,0,0,0,0) -> (0,0,0,0,1) -> (0,0,0,0,2) -> ... -> (1,0,0,1,0) -> ... -> (4,4,4,4,4)
4) bfs 탐색
	y,x,z 3방향에 대해 모두 탐색한다.
	
성공코드
1) 모든 블럭의 순서를 정한다.
	next_permutation을 활용한다.
2) 모든 블록 회전하기
	단, 이때 시작 블록의 시작점이 0이면 pass한다.
3) bfs 탐색
	y,x,z 3방향에 대해 모두 탐색한다.
```

# 참고

```c++
next-permutation을 쓰면 간단해진다.
A형에서는 라이브러리 제한이 없으니 최대한 활용하자.

+ 

cout << '-1' << endl;

[출력]
11569

cout << -1 << endl;

[출력]
-1
```



# 실패

```c++
#include <iostream>
#include <vector>
using namespace std;

vector<int> v,arr;

const int dx[]={0,1,0,-1};
const int dy[]={1,0,-1,0};

int map[5][5][5],res,start,end;
bool sel[5],re[5],ro[5];

void dfs(int y,int x){
	
	if([])
	
}

void rotate(int idx){
	int temp[5][5];
	for(int i=0;i<5;i++){
		for(int j=0;j<5;j++){
			temp[i][j]=map[idx][4-j][i];
		}
	}
	for(int i=0;i<5;i++){
		for(int j=0;j<5;j++){
			map[idx][i][j]=temp[i][j];
		}
	}
}


void rotate_select(){
	for(int i=0;i<2;i++){
		start=arr[i]; end=arr[1-i];
		if(map[start][0][0] && map[end][4][4]){
			dfs(0,0);
		}
		
	}
}

void remain_select(int cnt){
	if(cnt==3){
		rotate_select();
		return;	
	}
	for(int i=0;i<5;i++){
		if(sel[i] || re[i]) continue;
		re[i]=1;
		remain_select(cnt+1);
		re[i]=0;
	}
}

void select(int cnt){
	if(cnt==2){
		arr.clear();
		for(int i=0;i<5;i++){
			if(sel[i]) arr.push_back(i);
			else{
				rem.push_back(i);
			}
		}
		remain_select(0);
		return;
	}
	
	for(int i=0;i<v.size();i++){
		if(sel[v[i]]) continue;
		sel[v[i]]=true;
		select(cnt+1);
		sel[v[i]]=false;
	}
}

int main(){
	for(int t=0;t<5;t++){
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				bool flag=true;
				cin >> map[t][i][j];
				if(map[t][i][j] && flag){
					if((i==0 && j==0) || (i==0 && j==4) || (i==4 && j==0) || (i==4 && j==4)){
						flag=false; v.push_back(t);
					}
				}
			}
		}
	}
	select();
	cout << res << endl;
	return 0;
}
```





# 성공

```c++
#include <iostream>
#include <algorithm>
#include <queue>
#include <string.h>
using namespace std;

struct info{
	int z,y,x;
};

const int dx[]={0,1,0,-1,0,0};
const int dy[]={1,0,-1,0,0,0};
const int dz[]={0,0,0,0,1,-1};

int map[5][5][5],backup[5][5][5],d[5]={0,1,2,3,4},res;

void rotate(int idx){
	int temp[5][5]={0,};
	for(int i=0;i<5;i++){
		for(int j=0;j<5;j++){
			temp[i][j]=backup[idx][4-j][i];
		}
	}
	for(int i=0;i<5;i++){
		for(int j=0;j<5;j++){
			backup[idx][i][j]=temp[i][j];
		}
	}
}

void bfs(){
	queue<info> q;
	q.push({0,0,0}); int visited[5][5][5]={0,};
	visited[0][0][0]=1;
 	while(!q.empty()){
		auto now=q.front(); q.pop();
		int y=now.y; int x=now.x; int z=now.z;
		if(z==4 && y==4 && x==4){
			res=min(res,visited[z][y][x]-1);
			if(res==12){
				cout << res << endl;
				exit(0);
			}
			return;
		}
		
		for(int i=0;i<6;i++){
			int ny=y+dy[i]; int nx=x+dx[i]; int nz=z+dz[i];
			if(ny<0 || nx<0 || nz<0 || ny>4 || nx>4 || nz>4) continue;
			if(visited[nz][ny][nx]) continue;
			if(backup[nz][ny][nx]==1){
				visited[nz][ny][nx]=visited[z][y][x]+1;
				q.push({nz,ny,nx});	
			}
		}
	}
}

void print(){
	cout << endl;
	for(int i=0;i<5;i++){
		for(int j=0;j<5;j++){
			for(int k=0;k<5;k++){
				cout << map[i][j][k];
			}
			cout <<endl;
		}
		cout << endl;
	}
}

void select(){
	do{	
		for(int i=0;i<5;i++){
			memcpy(backup[d[i]],map[i],sizeof(map[i]));
		}
		for(int i=0;i<4;i++){
			rotate(0);
			if(!backup[0][0][0]) continue;
			for(int j=0;j<4;j++){
				rotate(1);
				for(int k=0;k<4;k++){
					rotate(2);
					for(int m=0;m<4;m++){
						rotate(3);
						for(int n=0;n<4;n++){
							rotate(4);
							if(!backup[4][4][4]) continue;
							bfs();
						}
					}
				}
			}
		}
	}while(next_permutation(d,d+5));
}

int main(){
	for(int t=0;t<5;t++){
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				cin >> map[t][i][j];
			}
		}
	}
	res=987654321;
	select();
	if(res==987654321){
		cout << -1 << endl;
	}else{
		cout << res << endl;	
	}
	return 0;
}
```

