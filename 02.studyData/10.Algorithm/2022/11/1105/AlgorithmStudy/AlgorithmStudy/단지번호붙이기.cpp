#include<stdio.h>
#include<iostream>
#include<vector>
#include<string.h>
#include<algorithm>
#define NS 29
using namespace std;
int N;
char board[NS][NS];
int visit[NS][NS];
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };
int count1 = 0;
 bool safeZone(int y, int x) {
	return  0 <= y && y < N && 0 <= x && x < N;
}
 void dfs(int y, int x)
{
	for (int dir = 0; dir < 4; dir++) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if (safeZone(ny, nx) && board[ny][nx] == '1'&&visit[ny][nx] == 0) {
			visit[ny][nx] = 1;
			count1++;
			dfs(ny, nx);
		}
	}
}
int main(void)
{
	vector<int> ret;
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%s", board[i]);
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (visit[i][j]==0&&board[i][j] == '1') {
				visit[i][j] = 1;
				count1++;
				dfs(i, j);
				ret.push_back(count1);
				count1 = 0;
			}
		}
	}

	sort(ret.begin(), ret.end());
	cout << ret.size() << endl;
	for (int i = 0; i < ret.size(); i++) {
		cout << ret[i] << endl;
	}
	return 0;
}