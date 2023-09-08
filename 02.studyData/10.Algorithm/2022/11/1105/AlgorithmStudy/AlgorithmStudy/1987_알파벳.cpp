#include<stdio.h>
#include<string>
#include<string.h>
#include<vector>
#include<algorithm>
using namespace std;

bool check[26];
int ret = -3000;
int cntRet = 0;
char board[24][24];
int N, M;
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };

bool safeZone(int y, int x) {
	return 0 <= y && y < N && 0 <= x && x < M;
}

void dfs(int y,int x,int cnt) {
	ret = max(ret, cnt);

	for (int dir = 0; dir < 4; dir++) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		int idx = board[ny][nx] - 'A';
		if (check[idx] == 0 && safeZone(ny,nx)) {
			check[idx] = 1;
			dfs(ny, nx, cnt + 1);
			check[idx] = 0;
			
		}
	}
}

int main(void)
{
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf(" %c", &board[i][j]);
		}
	}
	
	check[board[0][0] - 'A'] = 1;
	dfs(0,0, 1);


	printf("%d\n", ret);
	return 0;
}