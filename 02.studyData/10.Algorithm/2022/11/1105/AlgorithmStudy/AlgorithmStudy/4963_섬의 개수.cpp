#include<stdio.h>
#include<iostream>
#include<vector>
#include<string.h>
using namespace std;

int N, M;
//00 01 02
//10 11 12
//20 21 22
//
//dy 0 -1 -1 -1 0 1 1 1
//dx -1 -1 0  1 1 1 0 -1 

int dy[] = { 0,-1,-1,-1,0,1,1,1 };
int dx[] = { -1,-1,0,1,1,1,0,-1 };
int visit[54][54];
int board[54][54];

bool safeZone(int y, int x) {
	return 0 <= y && y < N && 0 <= x && x < M;
}

void dfs(int y, int x) {
	for (int dir = 0; dir < 8; dir++) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];

		if (safeZone(ny,nx)&&visit[ny][nx] == 0&&board[ny][nx]==1) {
			visit[ny][nx] = 1;
			dfs(ny, nx);
		}
	}
}

int main(void) {

	while (1) {
		cin >>M >> N;
		if (M == 0 && N == 0)break;
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cin >> board[i][j];
			}
		}

		memset(visit, 0, sizeof(visit));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j]==1&&visit[i][j] == 0) {
					visit[i][j] = 1;
					dfs(i, j);
					cnt++;
				}
			}
		}
		cout << cnt << endl;
	}

	return 0;
}