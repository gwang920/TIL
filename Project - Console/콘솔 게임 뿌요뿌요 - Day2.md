# 콘솔 게임 뿌요뿌요 - Day2

```
1) 파일하나로 구현하다보니 함수 분류하기가 쉽지 않다.
2) 뿌요뿌요 원작은 방향키/세기가 조절 가능한데
  지금 구현하는 게임은 단순히 상에서 하로 구슬을 떨어뜨리고만 있다.
3) 구슬이 4개 이상 모였을 때 터지는 기능
   구슬이 연쇄적으로 터지는 기능( one loop 내에서)
   하트를 터트리면 같은 색상의 모든 구슬이 다터지는 기능
   
   까지 구현완료했다.
```



# TEMP

```C++
#include <iostream>
#include <queue>
#include <vector>
#include <Windows.h>
#include <conio.h>
#include <string.h>
#include <ctime>
#include <thread>

#define Board_Size_H 13
#define Board_Size_W 8
using namespace std;

const int dy[]={0,1,0,-1},dx[]={1,0,-1,0};
bool visit[Board_Size_H][Board_Size_W];
queue<pair<int,int>> q;
vector<pair<int,int>> v;
int Board[Board_Size_H][Board_Size_W]={0,};
int Score=0,idx,color;

int random_star_generate(){
	int color_star=rand()%10;
	return color_star;
}

int random_color_generate(){
	int random_color = rand() % 4;
	if(random_color==0) random_color++;
    return random_color;
}
void gotoxy(int x,int y)
{
	COORD pos={x,y};
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), pos); 
}

void Print_Board(){
	printf(" ");
	printf("\n");
	for(int i=0;i<Board_Size_H;i++){
		for(int j=0;j<Board_Size_W;j++){
			gotoxy(7+j*2,1+i);
			if(!Board[i][j]){
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),3);
				printf("·"); continue;
			}
			if(Board[i][j]>3){
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),Board[i][j]/2);
				printf("♥");
			}else{
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),Board[i][j]);
				printf("●");
			}
		}
		printf("\n");
	}
	printf("\n\n");
	gotoxy(10,15);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),3);
	printf("Score : %d",Score);
	
}
void init(){
	memset(visit,0,sizeof(visit));
	v.clear();
}
void All_Bomb(int color){
	for(int i=0;i<Board_Size_H;i++){
		for(int j=0;j<Board_Size_W;j++){
			if(visit[i][j]) continue;
			if(Board[i][j]==color || Board[i][j]==color*2){
				Score++;
				Board[i][j]=0;
			}
		}
	}
}

bool Search(int i,int j,bool ON){
	int cnt=1;
	init();
	visit[i][j]=1;
	q.push({i,j}); v.push_back({i,j});
		while(!q.empty()){
			auto now=q.front(); q.pop();
			int y=now.first,x=now.second;
			for(int dir=0;dir<4;dir++){
				int ny=y+dy[dir],nx=x+dx[dir];
				if(ny<0 || nx<0 || ny>Board_Size_H-1 || nx>Board_Size_W-1) continue;
				if(visit[ny][nx] || !Board[ny][nx]) continue;
				if(Board[ny][nx]==Board[i][j]){
					cnt++; visit[ny][nx]=1;
					q.push({ny,nx});
					v.push_back({ny,nx});
				}
				if(Board[ny][nx]>3 && Board[ny][nx]/2==Board[i][j]){
					visit[ny][nx]=1;
					cnt++;
					q.push({ny,nx});
					v.push_back({ny,nx});
				}
			}
		}
		if(cnt>=4){
			if(ON) Score+=cnt;
			for(int k=0;k<v.size();k++){
				int y=v[k].first,x=v[k].second;
				if(Board[y][x]>3){
					All_Bomb(Board[y][x]/2);
				}
				Board[y][x]=0;
			}
			return true;
		}
	return false;
}

bool Bumb(bool ON){
	bool flag=false;
	for(int i=0;i<Board_Size_H;i++){
		for(int j=0;j<Board_Size_W;j++){
			if(Board[i][j]){
				if(Search(i,j,ON)) flag=true;
			}		
		}
	}
	return flag;
}

void move(){
	for(int j=0;j<Board_Size_W;j++){
		for(int i=Board_Size_H;i>=0;i--){
			if(!Board[i][j]){
				for(int k=i-1;k>=0;k--){
					if(Board[k][j]){
						Board[i][j]=Board[k][j];
						Board[k][j]=0;
						break;
					}
				}				
			}
		}
	}
}

void Add_Element(){
	for(int j=0;j<Board_Size_W;j++){
		for(int i=0;i<Board_Size_H-1;i++){
			Board[i][j]=Board[i+1][j];
			Board[i+1][j]=0;
		}
	}
	int Temp[Board_Size_H][Board_Size_W],Count=0;
	memcpy(Temp,Board,sizeof(Board));	
	while(1){
		for(int j=0;j<Board_Size_W;j++){
			while(1){
				int r_c=random_color_generate();
				if(random_star_generate()==1){
					r_c*=2;
				}
				Board[Board_Size_H-1][j]=r_c;
				if(Search(Board_Size_H-1,j,0)){
					memcpy(Board,Temp,sizeof(Temp));
					continue;	
				}
			else break;
			}
			memcpy(Temp,Board,sizeof(Board));
			Count++;
			if(Count==Board_Size_W){
				return;
			}
		}
	}
}
bool Null_Board(){
	for(int i=0;i<Board_Size_H;i++){
		for(int j=0;j<Board_Size_W;j++){
			if(Board[i][j]) return false;
		}
	}
	Add_Element();
	return true;
}

void comb_print(int comb){
	gotoxy(10,15);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),3);
	printf("%d combo!!  ",comb);
	Sleep(1000/2);
}


void Check(){
	bool flag=true;
	int comb=0;
	while(1){
		if(Bumb(1)){
			Print_Board();
			move();
			Sleep(1000/2);
			Print_Board();
			if(flag){
				Add_Element();
				flag=false;	
			}
			comb++;
			if(comb>1) comb_print(comb-1);
			move();
			Sleep(1000/2);
		}
		else return;
	}	
}

void makeBoundary(){
	printf("\n");
	for(int i=0;i<14;i++){
		for(int j=0;j<10;j++){
			if(j==0){
				printf("     ■");
			}
			else if(j==9 || i==13){
				printf("■");
			}else{
				printf("  ");
			}		
		}
		printf("\n");
	}
	printf("\n");
	printf("******** Press 'q' To End ********");
}
void move(int idx,int color){
	gotoxy(idx+7,0);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),color);
	printf("●");
}

void down(int idx,int color){
	int B_idx=idx/2;
	for(int i=0;i<Board_Size_H;i++){
		if(Board[i][B_idx]){
			Board[i-1][B_idx]=color;
			return;
		}
		if(i==Board_Size_H-1 && !Board[i][B_idx]){
			Board[i][B_idx]=color; 
			return;
		}
	}
}

bool GameOver(int idx){
	for(int j=0;j<Board_Size_W;j++){
		if(Board[0][j]){
			gotoxy(0,16);
			SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),3);
			printf("============= GAME OVER ============");
			return true;
		}
	}
	return false;
}

void Set_Shooter(){
	color=random_color_generate();
	gotoxy(idx+7,0);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),color);
	printf("●");
}

void StartGame(){
	Score=0;idx=6;
	Print_Board(); 
	Set_Shooter();
	while(1){
		if(GameOver(idx)) return;
		if(Null_Board()){
			gotoxy(5,15);
			SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),3);
			printf("!!!!!!!!!!Bonus 100 Point!!!!!!!!!!");
			Score+=1000;
			Sleep(1000);
			gotoxy(5,15);
			printf("                                  ");
			gotoxy(10,15);
			printf("Score : %d",Score);
		}
		int key=getch();
		switch (key){
            case 'a':
            	gotoxy(idx+8,0);
            	printf("   ");
            	if(idx>0) idx-=2;
				move(idx,color);
                break;
            case 'd':
            	gotoxy(idx+8,0);
            	printf("   "); 
            	if(idx<14) idx+=2;
				move(idx,color);
                break;
            case ' ':
            	down(idx,color);
            	Print_Board();
            	Check();
            	Print_Board();
            	gotoxy(idx+8,0);
            	printf("  "); 
            	Set_Shooter();
            	Print_Board();
            	break;
            case 'q':
            	gotoxy(0,15);
            	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),10);
            	printf("\n============== EXIT ============== ");
            	return;
            default:
                break;
        }
	}
}


void CursorOFF(){
	HANDLE consoleHandle = GetStdHandle(STD_OUTPUT_HANDLE);
    CONSOLE_CURSOR_INFO info;
    info.dwSize = 100;
    info.bVisible = FALSE;
    SetConsoleCursorInfo(consoleHandle, &info);
}

void StartScreen(){
	printf("\n\n\n");
	printf("=======   PUYO PUYO GAME   =======\n\n");
	printf("Operation Key\n");
	printf("'a' : left move\n");
	printf("'d' : right move\n");
	printf("'space bar' : shooting \n\n");
	printf("======= Press 's' to start =======\n\n\n\n");
	printf("        Made By Gwang Guen\n");
	printf("        Ref - https://github.com/gwang920/TIL\n");
}

void Init_Board(){
	for(int i=0;i<Board_Size_H;i++){
		for(int j=0;j<Board_Size_W;j++){
			Board[i][j]=random_color_generate();
		}
	}
	while(Bumb(0)){
		move();
	}
}

int main(){
	system("color 7");  
	CursorOFF();
	srand((unsigned)time(NULL));
	StartScreen();
	while(1){
		int key=_getch();
		if(key=='s' || key=='S'){
			system("cls");
			Init_Board();
			makeBoundary();
			StartGame();
			break;
		}
	}
	return 0;
}
```

