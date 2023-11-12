#include<stdio.h>
#include<queue>
#include<vector>
#include<iostream>
#include<algorithm>
#include<string.h>
using namespace std;

int N;
int board[104][104];
int groupBoard[104][104];
int visit[104][104];
int loadMap[104][104];
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };
int ret = 9999;

struct Data {
	int y;
	int x;
	int cnt;
};
queue<Data>q;

bool safeZone(int y, int x) {
	return 0 <= y && y < N && 0 <= x && x < N;
}

void areaGroupDFS(int y, int x, int groupNumber) {

	for (int dir = 0; dir < 4; dir++) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];

		if (safeZone(ny, nx) && board[ny][nx] == 1 && groupBoard[ny][nx] == 0) {
			groupBoard[ny][nx] = groupNumber;

			areaGroupDFS(ny, nx, groupNumber);
		}
	}
}


void copyBoardToGroupBoard(int copyBoard[][104]) {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			board[i][j] = copyBoard[i][j];
		}
	}
}

void dfs(int y, int x, int cnt, int num) {
	if (board[y][x] != 0 && board[y][x] != num) {
		ret = min(ret, cnt);
	}
	for (int dir = 0; dir < 4; dir++) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		int ncnt = cnt + 1;

		if (safeZone(ny, nx) && board[ny][nx] != num && visit[ny][nx] == 0) {
			visit[ny][nx] = ncnt;
			dfs(ny, nx, ncnt, num);
			visit[ny][nx] = 0;
		}
	}
}

void bfs(int y, int x, int cnt) {
	queue<Data>q;
	int num = board[y][x];
	q.push({ y,x,0 });

	while (!q.empty()) {
		Data c = q.front(); q.pop();
		if (board[c.y][c.x] != 0 && board[c.y][c.x] != num) {
			ret = min(ret, c.cnt);
			break;
		}
		for (int dir = 0; dir < 4; dir++) {
			Data n;
			n.y = c.y + dy[dir];
			n.x = c.x + dx[dir];
			n.cnt = c.cnt + 1;
			if (safeZone(n.y, n.x) && board[n.y][n.x] != num && visit[n.y][n.x] == 0) {
				visit[n.y][n.x] = 1;
				q.push(n);
			}
		}
	}
}

void bfs_refactor() {

	while (!q.empty()) {
	Data c = q.front(); q.pop();

		for (int dir = 0; dir < 4; dir++) {
			Data n;
			n.y = c.y + dy[dir];
			n.x = c.x + dx[dir];
			n.cnt = c.cnt + 1;
			if (safeZone(n.y, n.x) && board[n.y][n.x] == 0 && visit[n.y][n.x] == 0) {
				groupBoard[n.y][n.x] = groupBoard[c.y][c.x];
				visit[n.y][n.x] = n.cnt;
				q.push(n);
			}
		}
	}
}

int main(void) {

	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> board[i][j];
		}
	}

	// 구역 나누기
	int groupNumber = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (board[i][j] == 1 && groupBoard[i][j] == 0) {
				groupNumber++;
				groupBoard[i][j] = groupNumber;
				areaGroupDFS(i, j, groupNumber);
			}
		}
	}
	copyBoardToGroupBoard(groupBoard);
	////건너기테스트
	//int cnt1 = 0;
	//int cnt2 = 0;
	//memset(visit, 0, sizeof(visit));

	//for (int i = 0; i < N; i++) {
	//	for (int j = 0; j < N; j++) {
	//		if (board[i][j] != 0&& visit[i][j]==0 ) {
	//			visit[i][j] = 1;
	//			bfs(i, j, 0);
	//			memset(visit, 0, sizeof(visit));
	//		}
	//	}
	//}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (board[i][j] != 0) {
				q.push({ i,j,0 });
			}
		}
	}

	bfs_refactor();

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			for (int dir = 0; dir < 4; dir++) {
				int ny = i + dy[dir];
				int nx = j + dx[dir];
				if (safeZone(ny,nx)&&groupBoard[i][j] != groupBoard[ny][nx]) {
					ret = min(ret, visit[i][j] + visit[ny][nx]);
				}

			}
		}
	}

	cout << ret  << endl;

	return 0;
}