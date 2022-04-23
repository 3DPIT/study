#include<stdio.h>
#include<iostream>
#include<vector>
#include<string.h>
#include<queue>
#define NS 54
using namespace std;
int N, M, ret;
int board[NS][NS];
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };
struct Data {
	int y, x, count;
};
bool safeZone(int y, int x) {
	return 0 <= y && y < N && 0 <= x && x < N;
}
vector<Data>virus;
vector<int>D;

void BFS() {
	queue<Data>q;
	int visit[NS][NS] = { 0, };
	for (int i = 0; i < M; i++) {
		q.push(virus[D[i]]);
		visit[virus[D[i]].y][virus[D[i]].x] = 1;
	}
	while (!q.empty()) {
		Data c = q.front(); q.pop();
		for (int dir = 0; dir < 4; dir++) {
			Data n;
			n.y = c.y + dy[dir];
			n.x = c.x + dx[dir];
			n.count = c.count + 1;
			if (safeZone(n.y, n.x) && visit[n.y][n.x] == 0 && board[n.y][n.x] !=1) {
				visit[n.y][n.x] = n.count;
				q.push(n);
			}
		}
	}
	int maxNumber = 0x80000000;
	//for (int i = 0; i < N; i++) {//17141
	//	for (int j = 0; j < N; j++) {
	//		if (board[i][j] == 0 && visit[i][j] == 0)return;
	//		maxNumber = maxNumber < visit[i][j] ? visit[i][j] : maxNumber;
	//	}
	//}
	for (int i = 0; i < N; i++) {//17142
		for (int j = 0; j < N; j++) {
			if (board[i][j] == 0 && visit[i][j] == 0)return;
			if(board[i][j]!=2&&visit[i][j]!=0)maxNumber = maxNumber < visit[i][j] ? visit[i][j] : maxNumber;
		}
	}
	ret = ret > maxNumber ? maxNumber : ret;
}
void dfs(int idx, int cnt) {
	if (idx > virus.size())return;
	if (cnt == M) {
		BFS();
		return;
	}
	D.push_back(idx);
	dfs(idx+1, cnt + 1);
	D.pop_back();
	dfs(idx + 1, cnt);
}
void init() {
	ret = 0x7fffffff;
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			scanf("%d", &board[i][j]);
			if (board[i][j] == 2) {
				virus.push_back({ i,j,1 });
			}
		}
	}
}
int main(void)
{
	init();
	dfs(0, 0);
	//if (ret == 0x80000000)ret = 1;
	printf("%d\n", ret==0x7fffffff?-1:ret-1);
	return 0;
}