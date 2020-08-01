# 백준 18809 - Gaaaaaaaaaarden



# 성공

```c++
#include <iostream>
#include <queue>
#include <vector>
#include <string.h>
#define MAX 51
using namespace std;

vector<pair<int,int>> v;
queue<pair<pair<int,int>,int>> q;

const int dy[]={0,1,0,-1},dx[]={1,0,-1,0};
int N,M,G,R,res;
int map[MAX][MAX],backup[MAX][MAX],check[MAX][MAX];
int visit[MAX][MAX];
void spread(){
	int count=0;
	memset(visit,0,sizeof(visit));
	memcpy(backup,check,sizeof(check));
	for(int i=0;i<v.size();i++){
		if(!check[v[i].first][v[i].second]) continue;
		q.push({{v[i].first,v[i].second},1});	
	} 
	
	while(!q.empty()){
		auto now=q.front(); q.pop();
		int y=now.first.first,x=now.first.second,cnt=now.second;
		for(int i=0;i<4;i++){
			int ny=y+dy[i],nx=x+dx[i];
			if(ny<0 || nx<0 || ny>N-1 || nx>M-1) continue;	
			if(!map[ny][nx] || backup[ny][nx]==3 || backup[y][x]==3) continue;
			if(backup[ny][nx]==0){
				visit[ny][nx]=cnt;
				backup[ny][nx]=backup[y][x]; q.push({{ny,nx},cnt+1});
			}
			else if((backup[ny][nx]==2 && backup[y][x]==1) || (backup[ny][nx]==1 && backup[y][x]==2)){
				if(visit[ny][nx]!=cnt) continue;
				backup[ny][nx]=3; count++;
			} 	
		} 
	}
	res=max(res,count);
}
void dfs(int Gcnt,int Rcnt,int idx){
	if(Gcnt==G && Rcnt==R){
		spread();
		return;
	}
	
	for(int i=idx;i<v.size();i++){
		int y=v[i].first,x=v[i].second;
		for(int j=1;j<=2;j++){
			if(j==1 && Gcnt==G) continue;
			if(j==2 && Rcnt==R) continue;
			check[y][x]=j;
			dfs(Gcnt+j%2,Rcnt+j/2,i+1);
			check[y][x]=0;
		}
	}	
}

int main(){
	cin >> N >> M >> G >> R;
	for(int i=0;i<N;i++){
		for(int j=0;j<M;j++){
			cin >> map[i][j];
			if(map[i][j]==2) v.push_back({i,j});
		}
	}
	dfs(0,0,0);
	cout << res << endl;
	return 0;
}
```

