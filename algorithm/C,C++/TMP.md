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

