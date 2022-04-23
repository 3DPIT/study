#include<stdio.h>
#include<iostream>
#include<string.h>
#define NS 51
#define MS 51
using namespace std;
int N, M,T, ret;
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };
int visit[NS][MS];
int board[NS][MS];
int X, D, K;
int flag = 0;
void init() {
	N = M = T=ret = 0;
	scanf("%d %d %d", &N, &M, &T);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &board[i][j]);
		}
	}
}
void clockArr(int idx, int arr[MS]) {
	int copy = arr[M-1];
	for (int i = M-1; i >0; i--) {
		arr[i] = arr[i - 1];
	}
	arr[0] = copy;
}
void clockArrReverse(int idx, int arr[MS]) {
	int copy = arr[0];
	for (int i = 0; i <M-1; i++) {
		arr[i] = arr[i +1];
	}
	arr[M-1] = copy;
}
void dfs(int y, int x, int number) {
	
	for (int dir = 0; dir < 4; dir++) {
		int ny = y + dy[dir]; int nx = x + dx[dir];
		if (nx < 0) nx = M-1;
		if (nx == M) nx = 0;
		if (0<=ny&&ny<N&&visit[ny][nx] == 0 && board[ny][nx] == number) {
			flag = 1;
			board[ny][nx] = 0;
			visit[ny][nx] = 1;
			dfs(ny, nx, number);
		}
	}
}
void play() {
	for (int t = 0; t < T; t++) {
		scanf("%d %d %d", &X, &D, &K);

			if (D == 0) {
				for (int i = 0; i < N; i++) {
					if ((i+1)%X == 0) {
						for (int k = 0; k < K; k++) {
							clockArr(i, board[i]);
						}
					}
				}
			}
			else if (D == 1) {
				for (int i = 0; i < N; i++) {
					if ((i+1)%X == 0) {
						for (int k = 0; k < K; k++) {
							clockArrReverse(i, board[i]);
						}
					}
				}
			}

		int retSum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j]!=0&&visit[i][j] == 0) {
					flag = 0;
					int copyNumber = board[i][j];
					visit[i][j] = 1;
					dfs(i, j, board[i][j]);
					if (flag == 1)board[i][j] = 0;
					retSum += flag;
				}
			}//for j
		}//for i
		memset(visit, 0, sizeof(visit));
		if (retSum == 0) {//제거 못하는 경우
			double number = 0; int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] != 0) {
						number += board[i][j];
						count++;
					}
				}
			}
			double  avgNumber = number / count;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] != 0) {
						if (board[i][j] > avgNumber) {
							board[i][j]--;
						}
						else if (board[i][j] < avgNumber) {
							board[i][j]++;
						}
					}
				}
			}
		}
	}//for t

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			ret += board[i][j];
		}
	}
}
int main(void) {
	init();
	play();
	printf("%d\n", ret);
	return 0;
}