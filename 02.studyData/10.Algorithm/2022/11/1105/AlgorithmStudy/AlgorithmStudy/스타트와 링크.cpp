#include <stdio.h>
#include <iostream>
#include <vector>
#include <string.h>
#include <algorithm>
using namespace std;
int N;
int board[24][24];
int D[24];
int ret;

void dfs(int cnt, int idx) {
	if (idx == N)return;
	if (cnt == N / 2) {
		int absRet = 0;
	/*	for (int i = 0; i < N; i++) {
			cout << D[i] << " ";
		}*/
		int start = 0;
		int link = 0;
		vector<int>startIdx;
		vector<int>linkIdx;
		for (int i = 0; i < N; i++) {
			if (D[i] == 0)startIdx.push_back(i);
			else linkIdx.push_back(i);
		}
		int startSum = 0;
		int linkSum = 0;
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < N/2; j++) {
				if (i == j)continue;
				startSum += board[startIdx[i]][startIdx[j]];
				linkSum += board[linkIdx[i]][linkIdx[j]];
			}
		}
		absRet = abs(startSum - linkSum);
		ret = ret > absRet ? absRet : ret;
		return;
	}

	D[idx] = 1;
	dfs(cnt + 1, idx + 1);
	D[idx] = 0;
	dfs(cnt, idx+1);
}

void init()
{
	memset(board, 0, sizeof(board));
	N = 0;
	ret = 0x7fffffff;
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			scanf("%d", &board[i][j]);
		}
	}
}
int main(void) {

	int testCase = 1;
	for (int tc = 0; tc < testCase; tc++) {
		init();
		dfs(0, 0);
		printf("%d\n", ret);
	}
	return 0;
}