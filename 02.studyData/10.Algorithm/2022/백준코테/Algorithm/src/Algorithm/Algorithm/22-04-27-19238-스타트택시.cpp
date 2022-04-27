#include<stdio.h>
#include<iostream>
#include<vector>
#include<string.h>
#include<queue>
#define NS 24
using namespace std;
int N, M, F;
int board[NS][NS];
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };
int ret;
struct Pos {
	int y, x, cnt, feul, used;
}Taxi;
struct Data {
	int number, isStart;
};
Data peopleBoard[NS][NS];
Data startBoard[NS][NS];
Data endBoard[402][NS][NS];
bool safeZone(int y, int x) {
	return 0 <= y && y < N && 0 <= x && x < N;
}
void init() {
	scanf("%d %d %d", &N, &M, &F);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			scanf("%d", &board[i][j]);
		}
	}
	scanf("%d %d", &Taxi.y, &Taxi.x);
	Taxi.y--; Taxi.x--;
	for (int m = 1; m <= M; m++) {// ½Â°´ÀÇ Á¤º¸ ÀÔ·Â
		int sy, sx, ey, ex;
		scanf("%d %d %d %d", &sy, &sx, &ey, &ex);
		sy--; sx--; ey--; ex--;
		startBoard[sy][sx].isStart = 1;
		startBoard[sy][sx].number = m;
		endBoard[0][ey][ex].number = m;
	}
}
int BFS() {
	// ½Â°´ Å½»ö ÇÏ´Â Å¥
	int cnt = 0;
	while (1) {
		if (cnt == M)break;
		int visit[NS][NS] = { 0, };
		queue<Pos>t;
		Taxi.feul = F;
		t.push(Taxi);
		int minY, minX, minCnt;
		minY = minX = minCnt = 0x7fffffff;
		int fuel, used;
		visit[Taxi.y][Taxi.x] = 0;
		int number = 0;
		while (!t.empty()) {
			Pos c = t.front(); t.pop();
			//if (c.feul == 0 && startBoard[c.y][c.x].isStart != 1) return -1;
			if (startBoard[c.y][c.x].isStart == 1) { // ÃÖ¼Ò°ª »Ì´Â ºÎºÐ
				if (minCnt >= c.cnt) {
					minCnt = c.cnt;
					if (minY > c.y || (minY == c.y&&minX > c.x)) {
						number = startBoard[c.y][c.x].number;
						minY = c.y;
						minX = c.x;
						fuel = c.feul;
						used = c.used;
					}
				}
			}//if(peopleBoard
			for (int dir = 0; dir < 4; dir++) {
				Pos n;
				n.y = c.y + dy[dir]; n.x = c.x + dx[dir]; n.cnt = c.cnt + 1;
				n.feul = c.feul - 1;; n.used = c.used;
				if (safeZone(n.y, n.x) && visit[n.y][n.x] == 0 && board[n.y][n.x] == 0) {
					visit[n.y][n.x] = 1;
					t.push(n);
				}
			}
		}
		memset(visit, 0, sizeof(visit));

		//½Â°´ ÀÌµ¿ ÇÏ´Â Å¥
		if (minCnt == 0x7fffffff)return -1;
		while (!t.empty())t.pop();
		F = F - minCnt;//³²Àº°Í
		//used = minCnt;
		t.push({ minY,minX,0,F,used });
		visit[minY][minX] = 0;
		startBoard[minY][minX].number = 0;
		startBoard[minY][minX].isStart = 0;
		int flag = 0;
		while (!t.empty()) {
			Pos c = t.front(); t.pop();
			if (c.feul < 0)return -1;
			if (endBoard[0][c.y][c.x].number == number) {
				flag = 1;
				F = F - c.cnt;
				used += c.cnt;
				F += used * 2;
				endBoard[0][c.y][c.x].number = 0;
				endBoard[0][c.y][c.x].isStart = 0;
				Taxi.y = c.y; Taxi.x = c.x;
				break;
			}
			for (int dir = 0; dir < 4; dir++) {
				Pos n;
				n.y = c.y + dy[dir]; n.x = c.x + dx[dir]; n.cnt = c.cnt + 1;
				n.feul = c.feul - 1; n.used = c.used;
				if (safeZone(n.y, n.x) && board[n.y][n.x] == 0 && visit[n.y][n.x] == 0) {
					visit[n.y][n.x] = 1;
					t.push(n);
				}
			}
		}
		if (flag == 0)return -1;
		cnt++;

	}
	ret = F;
	return ret;
}
int main(void) {
	init();
	printf("%d", BFS());

	return 0;
}