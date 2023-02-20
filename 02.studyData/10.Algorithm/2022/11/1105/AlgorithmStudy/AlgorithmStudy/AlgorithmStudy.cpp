#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
#include <vector>
#define NSIZE 12
#define MSIZE 12
using namespace std;

int N, M;
int ret;
int board[NSIZE][MSIZE];
struct Data {
	int y, x;
};
void COPY() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			printf("%d", board[i][j]);
		}
		cout << endl;
	}
}
void init() {
	N = M = ret = 0;
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &board[i][j]);
		}
	}
}
void dfs(int y, int x, int cnt) {
	if (cnt == 3) {
		COPY();
		search();
		return;
	}
	for (int i = 0; i < N; i++) {
		for (int j = x; j < M; j++) {
			if (board[i][j] == 0) {
				board[i][j] = -1;
				dfs(i, j + 1, cnt+1);
				board[i][j] = 0;
			}
		}
		x = 0;
	}
}
void search() {
	queue<Data> q;
}
int main() {

	int testCase = 1;
	for (int tc = 0; tc < testCase; tc++) {
		init();
		dfs(0, 0, 0);
		search();
		printf("#%d %d\n", tc, ret);
	}
	return 0;
}