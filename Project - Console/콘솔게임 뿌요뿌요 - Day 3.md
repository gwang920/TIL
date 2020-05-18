

# 콘솔게임 뿌요뿌요 - Day 3

```
멀티스레드를 활용하여
1) Board에 구슬을 2초마다 생성
2) 조작키로 구슬 게임 플레이

위 두가지를 동시에 구현했는데 오류가 생긴다.
=> 구슬을 생성하기 위해 기존의 보드에 있던 구슬을 모두 한칸 위로(y축방향) 이동시킬텐데,
  이 타이밍과 동시에 구슬을 떨어트린다면 둘 중 우선순위를 누구한테 줄 것인가?
```



# 멀티스레드

```c++
멀티스레드 구현은 생각보다 단순하다.

usigned __stdcall 함수명(void *arg){
	 내용
}

쓰레드 함수를 구현하고

int main(){
	_beginthreadex(NULL,0,Thread_ABC,0,0,NULL);
}


실행시킬 곳에 쓰레드 함수를 호출한다.
```



```c++
#include <stdio.h>
#include <Windows.h>
#include <process.h>

unsigned __stdcall Thread_ABC(void *arg)
{
	while(1){
		printf("A");
		Sleep(1000);
	}
}

int main(void){
	_beginthreadex(NULL,0,Thread_ABC,0,0,NULL);
	while(1){
		printf("B");
		Sleep(2000);
	}
	return 0;
}
```



# 소스코드

```c++
#include <iostream>
#include <queue>
#include <vector>
#include <Windows.h>
#include <conio.h>
#include <string.h>
#include <ctime>
#include <thread>
#include <process.h>

#define Board_Size_H 13
#define Board_Size_W 8
using namespace std;

const int dy[]={0,1,0,-1},dx[]={1,0,-1,0};
bool visit[Board_Size_H][Board_Size_W];
queue<pair<int,int>> q;
vector<pair<int,int>> v;
int Board[Board_Size_H][Board_Size_W]={0,};
int Score=0,idx,color;
bool flag=true;

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

unsigned __stdcall Thread_Add_Element(void *arc){
	while(1){
	Sleep(2000);
	for(int j=0;j<Board_Size_W;j++){
		for(int i=0;i<Board_Size_H-1;i++){
			Board[i][j]=Board[i+1][j];
			Board[i+1][j]=0;
		}
	}
	int Temp[Board_Size_H][Board_Size_W],Count=0;
	memcpy(Temp,Board,sizeof(Board));
	bool flag=false;	
	while(1){
		if(flag) break;
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
				flag=true;
				break;
			}
		}
	}
	Print_Board(); 
	}	
}

bool Null_Board(){
	for(int i=0;i<Board_Size_H;i++){
		for(int j=0;j<Board_Size_W;j++){
			if(Board[i][j]) return false;
		}
	}
//	Add_Element();
	return true;
}

void comb_print(int comb){
	gotoxy(10,15);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),3);
	printf("%d combo!!  ",comb);
	Sleep(1000);
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
	_beginthreadex(NULL,0,Thread_Add_Element,0,0,NULL);
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

int main(void){
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

