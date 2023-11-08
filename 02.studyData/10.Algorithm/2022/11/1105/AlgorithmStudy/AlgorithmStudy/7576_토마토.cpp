#include<stdio.h>
#include<iostream>
#include<vector>
#include<queue>
#define NS 1004
#define MS 1004
using namespace std;
int N, M;
int board[NS][MS];
int visit[NS][MS];
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };

struct Data {
	int y, x,cnt;
};

bool safeZone(int y, int x) {
	return 0 <= y && y < N && 0 <= x && x < M;
}

int main(void) {
	cin >> M >> N;
	vector<Data> v;
	queue<Data>q;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> board[i][j];
			if (board[i][j] == 1) {
				q.push({ i,j });
				visit[i][j] = 1;
			}
		}
	}
	int cnt = 0;
	while (!q.empty()) {
		Data c = q.front(); q.pop();

		for (int d = 0; d < 4; d++) {
			Data n;
			n.y = c.y + dy[d];
			n.x = c.x + dx[d];
			n.cnt = c.cnt + 1;
			cnt = n.cnt;
			if (safeZone(n.y,n.x)&&visit[n.y][n.x]==0&&board[n.y][n.x] == 0) {
				visit[n.y][n.x] = 1;
				q.push(n);
			}
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (visit[i][j] == 0 && board[i][j] == 0) {
				cout << -1 << endl;
				return 0;
			}
		}
	}

	cout << cnt-1 << endl;


	return 0;
}