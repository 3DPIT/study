#include<stdio.h>
#include<iostream>
#include<queue>
using namespace std;
int N, M;

char board[104][104];
int visit[104][104];
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };

struct Data {
	int y; int x; int cnt;
};

bool safeZone(int y, int x) {
	return 0 <= y && y < N && 0 <= x && x < M;
}

int main(void)
{
	cin >> N >> M;
	for (int y = 0; y < N; y++) {
		scanf("%s", &board[y]);
	}

	queue<Data>q;
	q.push({ 0, 0,0 });
	visit[0][0] = 1;

	while (!q.empty()) {
		Data c = q.front(); q.pop();
		
		for (int dir = 0; dir < 4; dir++) {
			Data n;
			n.y = c.y + dy[dir];
			n.x = c.x + dx[dir];
			n.cnt = c.cnt + 1;
			if (safeZone(n.y, n.x) && board[n.y][n.x] == '1' && visit[n.y][n.x] == 0) {
				visit[n.y][n.x] = n.cnt;
				q.push(n);
			}
		}
	}

	cout << visit[N - 1][M - 1]+1 << endl;
	
	return 0;
}