#include<stdio.h>
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int N;
char board[29][29];
int visit[29][29];
vector<int>v;
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };
int cnt = 0;
bool safeZone(int y, int x) {
	return 0 <= y && y < N && 0 <= x && x < N;
}

void dfs(int y, int x) {
	for (int dir = 0; dir < 4; dir++) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if (safeZone(ny, nx) && board[ny][nx] == '1' && visit[ny][nx] == 0) {
			visit[ny][nx] = cnt++;
			dfs(ny, nx);
		}
	}
}
int main() {

	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%s", board[i]);
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (visit[i][j] == 0&& board[i][j] == '1') {
				cnt = 0;
				visit[i][j] = ++cnt;

				dfs(i, j);
				v.push_back(cnt);
			}
		}
	}

	sort(v.begin(), v.end());

	printf("%d\n",v.size());
	for (int i = 0; i < v.size(); i++) {
		printf("%d\n", v[i]);
	}
	return 0;
}