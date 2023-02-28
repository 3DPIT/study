#include<stdio.h>
#include<vector>
#include<iostream>
#define NS 54
#define MS 54
using namespace std;
int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};
int board[NS][MS];
int N, M, ret;
int sy, sx, sdir;

bool safeZone(int y, int x) {
	return 0 <= y && y < N && 0 <= x && x < M;
}

void init() {
	ret = 2;
	scanf("%d %d", &N, &M);
	scanf("%d %d %d ", &sy, &sx, &sdir);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &board[i][j]);
		}
	}
}

void play() {
	while (1) {
		if (board[sy][sx] == 0) {
			board[sy][sx] = ret++;
		}
		int copyDir = sdir;
		int copyY = sy;
		int copyX = sx;
		int dir = 0;
		for  (dir = 0; dir < 4; dir++) {
			copyDir--;
			if (copyDir == -1)copyDir = 3;
			int ny = copyY + dy[copyDir];
			int nx = copyX + dx[copyDir];
			if (board[ny][nx] == 0) {
				board[ny][nx] = ret++;
				sy = ny;
				sx = nx;
				sdir = copyDir;
				break;
			}

		}
		if (dir == 4) {//전체를 청소 못하는 경우
			int ny = sy - dy[sdir];
			int nx = sx - dx[sdir];
			if (board[ny][nx] == 1) {//벽인경우
				break;
			}
			else {
				sy = ny;
				sx = nx;
			}
		}
	}
}

int main(void) {
	init();
	play();
	cout << ret-2 << endl;
	return 0;
}