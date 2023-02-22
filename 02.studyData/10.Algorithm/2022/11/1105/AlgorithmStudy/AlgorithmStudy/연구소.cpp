#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
#include <vector>
#define NSIZE 12
#define MSIZE 12
using namespace std;

int N, M;
int ret=0x80000000;
int board[NSIZE][MSIZE];
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };
struct Data {
	int y, x;
};
void COPY() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			printf("%d", board[i][j]);
		}
		cout << endl;
	}
}
void init() {
	N = M = 0;
	ret = 0x80000000;
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &board[i][j]);
		}
	}
}
bool safeZone(int y, int x) {
	return 0 <= y && y < N && 0 <= x && x < M;
}
void search() {
	int visit[NSIZE][MSIZE] = { 0, };
	queue<Data> q;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (board[i][j] == 2 && visit[i][j] == 0) {
				visit[i][j] = 1;
				q.push({ i,j });
				while (!q.empty()) {
					Data c = q.front(); q.pop();
						for (int dir = 0; dir < 4; dir++) {
							Data n;
							n.y = c.y + dy[dir];
							n.x = c.x + dx[dir];
							if (safeZone(n.y,n.x)&&board[n.y][n.x] == 0 && visit[n.y][n.x] == 0) {
								visit[n.y][n.x] = 1;
								q.push(n);
							}
					}
				}
			}
		}
	}

	int cnt = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (board[i][j] == 0 && visit[i][j] == 0) cnt++;
		}
	}
	ret = ret < cnt ? cnt : ret;

}
void dfs(int y, int x, int cnt) {
	if (cnt == 3) {
		//COPY();
		//cout << endl;
		search();
		return;
	}
	for (int i = y; i < N; i++) {
		for (int j = x; j < M; j++) {
			if (board[i][j] == 0) {
				board[i][j] = -1;
				dfs(i, j + 1, cnt+1);
				board[i][j] = 0;
			}
		}
		x = 0;
	}
}

int main() {

	int testCase = 1;
	for (int tc = 0; tc < testCase; tc++) {
		init();
		dfs(0, 0, 0);
		printf("%d\n",ret);
	}
	return 0;
}