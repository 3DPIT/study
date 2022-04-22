#include<stdio.h>
#include<vector>
#include<iostream>
#define NS 54
#define MS 54
using namespace std;
int N, M,T, ret;
int board[NS][MS];
int dy1[] = { 1,0,-1,0 };
int dx1[] = { 0,-1,0,1 };

int dy2[] = { -1,0,1,0 };
int dx2[] = { 0,-1,0,1 };
bool safeZone(int y, int x) {
	return 0 <= y && y < N && 0 <= x && x < M&&board[y][x]!=-1;
}

struct pos {
	int y, x;
}AirCleaner[2];

void init() {
	N = M =T= ret = 0;
	int idx = 0;
	scanf("%d %d %d", &N, &M, &T);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &board[i][j]);
			if (board[i][j] == -1) {
				AirCleaner[idx].y = i;
				AirCleaner[idx++].x = j;
			}
		}
	}
}

void oneWayAir() {
	int y = AirCleaner[0].y-dy1[0];
	int x = AirCleaner[0].x - dx1[0];
	int dir = 0;
	while (1) {
		int ny = y - dy1[dir];
		int nx = x - dx1[dir];
		if (ny == AirCleaner[0].y&&nx == AirCleaner[0].x) {
			board[y][x] = 0;
			break;
		}
		if (ny<0 || nx==M || ny > AirCleaner[0].y || x < 0) {
			dir++;
			if (dir == 4) dir = 0;
			continue;
		}
		board[y][x] = board[ny][nx];
		y = ny; x = nx;
	}
}
void twoWayAir(){
	int y = AirCleaner[1].y - dy2[0];
	int x = AirCleaner[1].x - dx2[0];
	int dir = 0;
	while (1) {
		int ny = y - dy2[dir];
		int nx = x - dx2[dir];
		if (ny == AirCleaner[1].y&&nx == AirCleaner[1].x)
		{
			board[y][x] = 0;
 			break;
		}
		if (ny==N || nx==M || ny < AirCleaner[1].y || x < 0) {
			dir++;
			if (dir == 4) dir = 0;
			continue;
		}
		board[y][x] = board[ny][nx];
		y = ny; 
		x = nx;
	}
	
}
void spreadDust() {
	int cBoard[NS][MS] = { 0, };
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++)
		{
			int spaceCount = 0;
			if (board[i][j] != -1 && board[i][j] != 0) {//공기청정기 위치 아니고 먼지인경우만 체크
				int spreadDust = board[i][j] / 5;
				for (int dir = 0; dir < 4; dir++) {
					int ny = i + dy1[dir]; int nx = j + dx1[dir];
					if (safeZone(ny, nx)) {
						spaceCount++;
						cBoard[ny][nx] += spreadDust;
					}
				}
				int remainDust = board[i][j] - (spreadDust*spaceCount);
				cBoard[i][j] += remainDust;
			}
		}//for j
	}// for i

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if(board[i][j]!=-1)
			board[i][j] = cBoard[i][j];
		}
	}
}
void dustCount() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (board[i][j] != -1)ret += board[i][j];
		}
	}
}
void cleanAir() {
	for (int t = 0; t < T; t++) {
		spreadDust();
		oneWayAir();
		twoWayAir();
	}
	dustCount();
}

int main(void)
{
	init();
	cleanAir();
	printf("%d\n", ret);
	return 0;
}