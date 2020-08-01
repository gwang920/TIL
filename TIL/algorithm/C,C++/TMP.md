# TMP

```C++
#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int N,cnt;
int outer_cnt,inner_cnt;
int outer_rot,inner_rot;
string board[101][101];

vector<string> v,v1;
int main(){
	cin >> N >> cnt;
	
	for(int i=0;i<N;i++){
		for(int j=0;j<N;j++){
			cin >> board[i][j];
		}
	}
	int dir=1;
	if(cnt<0) dir=-1;
	
	if(N==2){
		outer_cnt=4; inner_cnt=0;
	}
	else if(N==3){
		outer_cnt=8; inner_cnt=0;
	}
	else{
		outer_cnt=(N,2)-pow(N-2,2);
		inner_cnt=(N-2,2)-pow(N-4,2);
	}
	outer_rot=abs(cnt)%outer_cnt;
	if(N>3) inner_rot=abs(cnt)%inner_cnt;
	
	for(int i=0;i<N;i++){
		v.push_back(board[0][i]);
		if(i==0 || i==N-1) continue;
		v1.push_back(board[1][i]);	
	} 
	for(int i=0;i<N;i++){
		v.push_back(board[i][N-1]);
		if(i==0 || i==N-1) continue;
		v1.push_back(board[i][N-2]);	
	} 
	for(int i=N-1;i>=0;i--){
		v.push_back(board[N-1][i]);	
		if(i==0 || i==N-1) continue;
		v1.push_back(board[N-2][i]);
	} 
	for(int i=N-1;i>0;i--){
		v.push_back(board[i][0]);	
		if(i==0 || i==N-1 || i==N-2) continue;
		v1.push_back(board[1][i]);
	} 
	
	vector<string> tmp,tmp1;
	if(dir==-1){
		tmp.assign(v.begin(),v.begin()+outer_rot);
		v.erase(v.begin(),v.begin()+outer_rot);
		for(int i=0;i<tmp.size();i++){
			v.push_back(tmp[i]);
		}
		tmp1.assign(v1.begin(),v1.begin()+inner_rot);
		v1.erase(v1.begin(),v1.begin()+inner_rot);
		for(int i=0;i<tmp1.size();i++){
			v1.push_back(tmp1[i]);
		}
		
	}else{
		tmp.assign(v.begin(),v.begin()+outer_cnt);
		v.erase(v.begin(),v.begin()+outer_cnt);
		for(int i=0;i<tmp.size();i++){
			v.push_back(tmp[i]);
			
		}
		tmp1.assign(v1.begin(),v1.begin()+inner_cnt);
		v1.erase(v1.begin(),v1.begin()+inner_cnt);
		for(int i=0;i<tmp1.size();i++){
			v1.push_back(tmp1[i]);
		}
	}
	int idx=0,idx1=0;
	for(int i=0;i<N;i++){
		board[0][i]=v[idx];
		idx++;
		if(i==0 || i==N-1) continue;
		board[1][i]=v1[idx1];	
		idx1++;
	} 
	for(int i=0;i<N;i++){
		board[i][N-1]=v[idx];
		idx++;
		if(i==0 || i==N-1) continue;
		board[i][N-2]=v1[idx1];
		idx1++;	
	} 
	for(int i=N-1;i>=0;i--){
		board[N-1][i]=v[idx];
		idx++;
		if(i==0 || i==N-1) continue;
		board[N-2][i]=v1[idx1];
		idx1++;
	} 
	for(int i=N-1;i>0;i--){
		board[i][0]=v[idx];
		idx++;
		if(i==0 || i==N-1 || i==N-2) continue;
		board[i][0]=v1[idx1];
		idx1++;
	} 
	
	for(int i=0;i<N;i++){
		for(int j=0;j<N;j++){
			cout << board[i][j] << ' ';
		}
		cout << "\n";
	}
	
	return 0;
}
```

# TMP#1

```C++
#include <iostream>

using namespace std;
int N,board[11][11];
const int dy[]={0,1},dx[]={1,0};
int bomb(){
	bool garo=0,sero=0;
	for(int i=6;i<=9;i++){
		int cnt=0,cnt1=0;
		for(int j=0;j<4;j++){
			if(board[i][j]) cnt++;
			if(board[j][i]) cnt1++;
		}
		if(cnt==4){
			sero=true;
			for(int j=0;j<4;j++){
				board[i][j]=0;
			}
		}
		if(cnt1==4){
			garo=true;
			for(int j=0;j<4;j++){
				board[j][i]=0;
			}
		}
	}
	if(garo && sero) return 3;
	if(garo) return 1;
	if(sero) return 2;
	return 0;
}

void move(int dir,int y,int x,int t){
	int ny=y-dy[dir],nx=x-dx[dir];
	if(t==1){
		while(1){
			ny+=dy[dir]; nx+=dx[dir];
			if(board[ny][nx] || ny==9 || nx==9){
				if(board[ny][nx]){
					ny-=dy[dir]; nx-=dx[dir];
				}
				board[ny][nx]=t;
				board[y][x]=0; return;
			}
		}
	}else{
		int ny1=y-dy[dir],nx1=x-dx[dir];
		if(t==2) nx1+=1;
		if(t==3) ny1+=1;
		board[ny1][nx1]=0;
		while(1){
			ny+=dy[dir],nx+=dx[dir];
			ny1+=dy[dir],nx1+=dx[dir];
			if(board[ny][nx] || board[ny1][nx1] || ny==9 || nx==9 || ny1==9 || nx1==9){
				if(board[ny][nx] || board[ny1][nx1]){
					ny-=dy[dir]; nx-=dx[dir]; ny1-=dy[dir]; nx1-=dx[dir];
				}
				board[ny][nx]=t; board[ny1][nx1]=t;
				board[y][x]=0; 
				return;
			}
		}
	}
}

void Ex_check(){
	int Ex_count=0,Ex_count1=0;
	for(int i=4;i<=5;i++){
		bool flag=false,flag1=false;
		for(int j=0;j<4;j++){
			if(board[i][j] && !flag){
				flag=true;
				Ex_count++;
			}
			if(board[j][i] && !flag1){
				flag1=true;
				Ex_count1++;
			}
		}
	}
	if(Ex_count1){
		for(int i=9;i>9-Ex_count1;i--){
			for(int j=0;j<4;j++){
				board[j][i]=0;
			}
		}
		for(int i=9-Ex_count1;i>=4;i--){
			for(int j=0;j<4;j++){
				move(0,j,i,board[j][i]);
			}
		}
	}
	
	if(Ex_count){
		for(int i=9;i>9-Ex_count;i--){
			for(int j=0;j<4;j++){
				board[i][j]=0;
			}
		}
		for(int i=9-Ex_count;i>=4;i--){
			for(int j=0;j<4;j++){
				move(1,i,j,board[i][j]);
			}
		}
	}
}

void print(){
	cout << endl;
	for(int i=0;i<10;i++){
		for(int j=0;j<10;j++){
			cout << board[i][j];
		}
		cout << endl;
	}
}

int main(){
	int t,x,y;
	cin >> N;
	while(N--){
		cin >> t >> x >> y;
		for(int i=0;i<2;i++){
			move(i,x+dy[i],y+dx[i],t);
		}	
		while(1){
			print();
			int check=bomb();
			if(!check) break;
			for(int i=8;i>=4;i--){
				for(int j=0;j<4;j++){
					if(check==3 || check==2) move(1,i,j,board[i][j]);
					if(check==3 || check==1) move(0,j,i,board[j][i]);
				}
			}
		}
		Ex_check();
	}
		
	print();
	return 0;
}
```