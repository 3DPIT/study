#include<stdio.h>
#include<iostream>
#include<string.h>
#include<queue>
#define NS 9
using namespace std;
int N,M,ret;
int board[NS][NS];
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };
struct Data {
	int y, x, cnt;
};
void init() {
	N = M= 0;
	ret = 0x80000000;
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &board[i][j]);
		}
	}
}
int bfs() {
	queue<Data>q;
	int safeZone = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (board[i][j] == 2) {
				q.push({ i,j,0 });
			}
		}
	}
	int visit[NS][NS] = { 0, };//规巩 眉农
	while (!q.empty())
	{
		Data c = q.front(); q.pop();
		for (int dir = 0; dir < 4; dir++)
		{
			Data n;
			n.y = c.y + dy[dir]; n.x = c.x + dx[dir];
			n.cnt = c.cnt + 1;
			if ((0 <= n.y&&n.y < N && 0 <= n.x&&n.x < M)&&(visit[n.y][n.x]==0&&board[n.y][n.x]==0)) {
				visit[n.y][n.x] = 1;
				q.push(n);
			}
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (board[i][j] == 0 && visit[i][j] == 0) {
				safeZone++;
			}
		}
	}
	
	return safeZone;
}
void installWall(int y, int x, int count)
{
	if (count == 3) {
		int safeZone=bfs();
		ret = ret < safeZone ? safeZone:ret;
		return;
	}

	for (int i = y; i < N; i++) {
		for (int j = x; j < M; j++) {
			if (board[i][j] == 0) {
				board[i][j] = 3;//寒技快扁
				installWall(i, j + 1, count + 1);
				board[i][j] = 0;
			}
		}
		x = 0;
	}
}
int main(void)
{
	init();
	installWall(0,0,0);
	printf("%d\n", ret);
	return 0;
}