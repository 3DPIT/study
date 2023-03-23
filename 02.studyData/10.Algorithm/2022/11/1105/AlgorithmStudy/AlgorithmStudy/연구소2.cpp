#include<stdio.h>
#include<iostream>
#include<vector>
#include<string.h>
#include<queue>
#include<algorithm>
#define NS 54
using namespace std;
int N, M;
int ret;
int board[NS][NS];
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };
int D[NS][NS];

bool safeZone(int y, int x) {
	return 0 <= y && y < N && 0 <= x && x < N;
}

struct Data {
	int y, x, cnt;
};

void dfs(int y, int x, int cnt) {
	if (cnt == M) {
		int visit[NS][NS] = { 0, };
		queue<Data>q;

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (D[y][x] == 1) {
					q.push({ y,x,0 });
					visit[y][x] = 0;
				}
			}
		}

		while (!q.empty()) {
			Data c = q.front(); q.pop();

			for (int dir = 0; dir < 4; dir++) {
				Data n;
				n.y = c.y + dy[dir];
				n.x = c.x + dx[dir];
				n.cnt = c.cnt + 1;

				if (safeZone(n.y, n.x)&&visit[n.y][n.x]==0 && board[n.y][n.x]!=1) {
					visit[n.y][n.x] = n.cnt;
					q.push(n);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == 0 && board[i][j] == 0) return;

			}
		}
		int preRet = 0x80000000;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] != 0 && board[i][j] != 2) {

					preRet = max(preRet, visit[i][j]);
				}
			}
		}
		ret = min(ret, preRet);
		return;
	}
	

	for (int i = y; i < N; i++) {
		for (int j = x; j < N; j++) {
			if (board[i][j] == 2) {
				D[i][j] = 1;
				dfs(i, j+1, cnt + 1);
				D[i][j] = 0;
			}
		}
		x = 0;
	}
}

void init() {
	ret = 0x7fffffff;
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> board[i][j];
		}
	}
}
/*
0 ∫Ûƒ≠
1 ∫Æ
2 πŸ¿Ã∑ØΩ∫
*/
void virus() {


	dfs(0, 0, 0);
	

}

int main() {
	init();
	virus();
	if (0x80000000 == ret)cout << 0 << endl;
	else if (0x7fffffff == ret)  printf("%d", -1);
	else cout << ret << endl;
	return 0;
}