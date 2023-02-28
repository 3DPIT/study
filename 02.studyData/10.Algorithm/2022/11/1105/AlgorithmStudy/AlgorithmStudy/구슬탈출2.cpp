#include <stdio.h>
#include <iostream>
#include <queue>
#define NSIZE 14
#define MSIZE 14
using namespace std;

int N, M, ret;
char board[NSIZE][MSIZE];
int visit[NSIZE][NSIZE][NSIZE][NSIZE];
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };

struct Data {
	int ry, rx, by, bx, cnt;
};
Data initPos;
bool safeZone(int y, int x) {
	return 0 <= y && y < N && 0 <= x && x < M;
}


void BFS() {
	queue<Data>q;
	q.push(initPos);

	while (!q.empty()) {
		Data c = q.front(); q.pop();
		if (c.cnt == 11) {
			ret = -1;
			break;
		}
		if (board[c.ry][c.rx] == 'O') {
			ret = c.cnt;
			break;
		}
		for (int dir = 0; dir < 4; dir++) {
			Data n;
			Data copyC = c;
			int redMoveCount = 0;
			int flag = 0;

			while (1) {//레드공 이동
				n.ry = copyC.ry + dy[dir];
				n.rx = copyC.rx + dx[dir];
				n.cnt = c.cnt + 1;
				redMoveCount++;
				if (board[n.ry][n.rx] == 'O') {
					flag = 1;
					break;
				}
				else if (board[n.ry][n.rx] == '#') {
					n.ry = n.ry - dy[dir];
					n.rx = n.rx - dx[dir];
					redMoveCount--;
					break;
				}
				copyC.ry = n.ry;
				copyC.rx = n.rx;
			}

			int blueMoveCount = 0;
			while (1) {//파란공 이동
				n.by = copyC.by + dy[dir];
				n.bx = copyC.bx + dx[dir];
				blueMoveCount++;
				if (board[n.by][n.bx] == 'O') {
					flag = 1;
					break;
				}
				else if (board[n.by][n.bx] == '#') {
					n.by = n.by - dy[dir];
					n.bx = n.bx - dx[dir];
					blueMoveCount--;
					break;
				}
				copyC.by = n.by;
				copyC.bx = n.bx;
			}

			if ((board[n.ry][n.rx] == 'O'&&board[n.by][n.bx] == 'O')||
				(board[n.ry][n.rx] == '.'&&board[n.by][n.bx] == 'O'))
				continue;

			if (n.ry == n.by&&n.rx == n.bx) {
				if (board[n.by][n.bx] == 'O') continue;
				if (redMoveCount < blueMoveCount) {
					n.by -= dy[dir];
					n.bx -= dx[dir];
				}
				else {
					n.ry -= dy[dir];
					n.rx -= dx[dir];
				}
			}
			if (visit[n.ry][n.rx][n.by][n.bx] == 0) {
				visit[n.ry][n.rx][n.by][n.bx] = 1;
				q.push(n);
			}
		}
	}
}

void initData() {
	N = M = 0;
	ret = 0x7fffffff;
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> board[i][j];
			if (board[i][j] == 'R') {
				initPos.ry = i;
				initPos.rx = j;
				board[i][j] = '.';
			}
			else if (board[i][j] == 'B') {
				initPos.by = i;
				initPos.bx = j;
				board[i][j] = '.';
			}
		}
	}
	//for (int i = 0; i < N; i++) {
	//	for (int j = 0; j < M; j++) {
	//		cout << board[i][j] << " ";
	//	}
	//	cout << endl;
	//}
}

int main(void) {


	int testCase = 1;
	for (int tc = 0; tc < testCase; tc++) {
		initData();
		BFS();
		cout << (ret==0x7fffffff?-1:ret) << endl;
	}
	return 0;
}