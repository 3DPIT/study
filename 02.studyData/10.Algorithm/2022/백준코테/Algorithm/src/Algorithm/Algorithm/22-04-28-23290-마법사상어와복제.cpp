#include<stdio.h>
#include<iostream>
#include<vector>
#include<algorithm>
#define MS 14
using namespace std;
vector<int> boardCopy[MS][MS];
vector<int>board[MS][MS];
int smellBoard[MS][MS];
int sharkBoard[MS][MS];
struct Data {
	int y, x;
}shark;
int M, S;
int dy_s[] = {0,-1,0,1,0 };
int dx_s[] = {0,0,-1,0,1 };
int dy[] = {0 ,0,-1,-1,-1,0,1,1,1 };
int dx[] = {0, -1,-1,0,1,1,1,0,-1 };
int D[3];
int maxFish;
int sDir;
int ret;

bool safeZone(int y, int x) {
	return 1 <= y && y <= 4 && 1 <= x && x <= 4;
}
void copyMap(vector<int> A[][MS], vector<int>B[][MS]) {
	for (int i = 1; i <= 4; i++) {
		for (int j = 1; j <= 4; j++) {
			A[i][j] = B[i][j];
		}
	}
}

int sharkMoveChk() {
	int visit[5][5] = { 0, };
	Data c = shark;
	int fish = 0;
	for (int i = 0; i < 3; i++) {
		Data n;
		n.y = c.y + dy_s[D[i]]; n.x = c.x + dx_s[D[i]];
		if (!safeZone(n.y,n.x)) return -1;
		if (board[n.y][n.x].size() != 0,visit[n.y][n.x]==0) {
			visit[n.y][n.x] = 1;
			fish += board[n.y][n.x].size();
		}
		else return -1;
		c = n;

	}
	return fish;
}
void copyFish() {
	copyMap(boardCopy, board);
}
void dfs(int idx) {
	if (idx == 3) {
		int sum = sharkMoveChk();
		if(sum==-1) return ;
		else {

 			if (maxFish < sum) {
				maxFish = max(maxFish, sum);
				sDir = 0;
				for (int i = 0, num = 100; i < 3; i++, num /= 10) {
					sDir += D[i] * num;
				}
			}
			return;
		}
	}
	for (int i = 1; i <= 4; i++) {
		D[idx] = i;
		dfs(idx + 1);
		D[idx] = 0;
	}
}
void fishMove() {
	vector<int> cBoard[MS][MS];
	for (int i = 1; i <= 4; i++) {
		for (int j = 1; j <= 4; j++) {
			if (board[i][j].size() != 0) {
				for (int fish = 0; fish < board[i][j].size(); fish++) {// 물고기 이동 시키기
					int y = i; int x = j; int dir = board[i][j][fish];
					int ny = y + dy[dir]; int nx = x + dx[dir];
					if (safeZone(ny, nx)&& smellBoard[ny][nx] == 0&& sharkBoard[ny][nx] == 0) {
						cBoard[ny][nx].push_back(board[i][j][fish]);
					}
					else if(!safeZone(ny,nx)||smellBoard[ny][nx]!=0|| sharkBoard[ny][nx] != 1){
						for (int ii = 0; ii < 8; ii++) {
							dir--;
							if (dir == 0)dir = 8;
							ny = y + dy[dir]; nx = x + dx[dir];
							if (safeZone(ny, nx) && smellBoard[ny][nx] == 0&& sharkBoard[ny][nx]!=1) {
								cBoard[ny][nx].push_back(dir);
								break;
							}
						}
					}
				}
			}
		}
	}
	for (int i = 1; i <= 4; i++) {
		for (int j = 1; j <= 4; j++) {
			if (board[i][j].size() != 0) {
				board[i][j].clear();
			}
			if (cBoard[i][j].size()!= 0) {
				for (int ii = 0; ii < cBoard[i][j].size(); ii++) {
					board[i][j].push_back(cBoard[i][j][ii]);

				}
			}
		}
	}
	copyMap(boardCopy, cBoard);
}
void sharkMove() {
	vector<int> tempMap[MS][MS];
	copyMap(tempMap, board);
	int DIR[3] = { 0, };
	for (int i = 0, num = 100; i < 3; i++, num /= 10) {
		DIR[i] = sDir / num;
		sDir = sDir % num;
	}
	Data c = shark;
	sharkBoard[shark.y][shark.x] = 0;

	if (tempMap[c.y][c.x].size()) {

		smellBoard[c.y][c.x] = 3;//흔적 남기고
		tempMap[c.y][c.x].clear();// 물고기 제거
	}
	for (int i = 0; i < 3; i++) {
		Data n;
		n.y = c.y + dy_s[DIR[i]];
		n.x = c.x + dx_s[DIR[i]];
		if (tempMap[n.y][n.x].size()!=0) {
			smellBoard[n.y][n.x] = 3;//흔적 남기고
			tempMap[n.y][n.x].clear();// 물고기 제거
		}
		c = n;
		shark = c;
	}

	sharkBoard[shark.y][shark.x] = 1;
	copyMap(board, tempMap);


	sDir = 0;

}
void removeSmell() {
	for (int i = 1; i <= 4; i++) {
		for (int j = 1; j <= 4; j++) {
			if (smellBoard[i][j] != 0) {
				smellBoard[i][j]--;
			}
		}
	}
}
void copyBoard() {
	for (int i = 1; i <= 4; i++) {
		for (int j = 1; j <= 4; j++) {
			if(boardCopy[i][j].size()!=0)
				for (int k = 0; k < boardCopy[i][j].size(); k++) {
					board[i][j].push_back(boardCopy[i][j][k]);
				}
			boardCopy[i][j].clear();
		}
	}
	for (int i = 1; i <= 4; i++) {
		for (int j = 1; j <= 4; j++) {
			if (board[i][j].size() != 0) {
				for (int k = 0; k < board[i][j].size(); k++) {
					boardCopy[i][j].push_back(board[i][j][k]);
				}
			}
		}
	}
}
void init() {
	maxFish = 0x80000000;
	scanf("%d %d", &M, &S);
	int y, x, dir;
	for (int m = 1; m <= M; m++) {
		scanf("%d %d %d", &y, &x, &dir);
		board[y][x].push_back(dir);
		boardCopy[y][x].push_back(dir);
	}
	scanf("%d %d", &shark.y, &shark.x);
}
void play() {
	for (int s = 1; s <= S; s++) {
		copyFish();
		fishMove();
		dfs(0);
		sharkMove();
		removeSmell();
		copyBoard();
		memset(D, 0, sizeof(D));
		maxFish = 0x80000000;

	}
	for (int i = 1; i <= 4; i++) {
		for (int j = 1; j <= 4; j++) {
			if (board[i][j].size() != 0)ret += board[i][j].size();
		}
	}
}
int main(void)
{
	init();
	play();
	printf("%d\n", ret);
	return 0;
}