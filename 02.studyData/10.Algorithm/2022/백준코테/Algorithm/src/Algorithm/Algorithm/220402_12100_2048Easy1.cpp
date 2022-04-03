#include<stdio.h>
#include<iostream>
#include<string.h>
#include<vector>
using namespace std;
#define NSIZE 21
int N, ret;
int board[NSIZE][NSIZE];

void init()
{
	ret = 0x80000000;
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			scanf("%d", &board[i][j]);
		}
	}

}
void dfsCopyArr(int carr[NSIZE][NSIZE], int arr[NSIZE][NSIZE])
{
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			carr[i][j] = arr[i][j];
		}
	}
}

void rotation(int arr[NSIZE][NSIZE])
{
	int carr[NSIZE][NSIZE] = { 0, };
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			carr[j][N-i-1] = arr[i][j];
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			arr[i][j] = carr[i][j];
		}
	}
}
void sumBlock(int board[NSIZE][NSIZE])
{
	vector<int>q;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j <N; j++) {
			if (board[i][j] != 0)q.push_back(board[i][j]);//일단 저장
			board[i][j] = 0;//초기화 시키기
		}
		for (int j = 0; j < q.size() - 1; j++) {
			if (q.size() == 0)break;
			if (q[j] == q[j+ 1] && q[j] != 0) {
				q[j] += q[j + 1];
				q.erase(q.begin() + j + 1);
			}
		}
		for (int j = N - 1; q.size(); j--) {
			board[i][j] = q.front();
			q.erase(q.begin());
		}
	}
}
void dfs(int idx)
{
	if (idx == 5) {
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++) {
				ret = ret < board[i][j] ? board[i][j] : ret;
			}
		}
		return;
	}

	for (int dir = 0; dir < 4; dir++) {
		int cboard[NSIZE][NSIZE] = { 0, };
		dfsCopyArr(cboard, board);
		sumBlock(board);
		dfs(idx + 1);
		rotation(cboard);
		dfsCopyArr(board, cboard);
	}

}
int main(void)
{
	init();
	dfs(0);
	printf("%d", ret);
	return 0;
}