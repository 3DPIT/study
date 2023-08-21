#include<iostream>
#include<cstdio>
#include<vector>
#include<algorithm>
using namespace std;
int N;
int ret = 0x7fffffff;
int board[54][54];
vector<int> D;
vector<int>d;
int checkd[54];
void costSum(vector<int>d) {
	bool ok = true;
	int sum = 0;
	for (int i = 0; i < N - 1; i++) {
		if (board[d[i]][d[i + 1]] == 0) ok = false;
		else {
			sum += board[d[i]][d[i + 1]];
		}
	}
	if (ok && board[d[N - 1]][d[0]] != 0) {
		sum += board[d[N - 1]][d[0]];
		ret = min(ret, sum);
	}
}
void dfs_next_permutation(int cnt, int N) {
	if (cnt == N) {
		costSum(d);
		return;
	}

	for (int i = 1; i <= N; i++) {
		if (checkd[i] == 1)continue;
		checkd[i] = 1;
		d.push_back(i);
		dfs_next_permutation(cnt + 1, N);
		d.pop_back();
		checkd[i] = 0;
	}
}



int main(void) {
	scanf("%d", &N);
	for (int i = 1; i <= N; i++) {
		D.push_back(i);
	}
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			scanf("%d", &board[i][j]);
		}
	}
	dfs_next_permutation(0,N);
	//do {
	//	costSum(D);
	//} while (next_permutation(D.begin(), D.end()));


	printf("%d\n", ret);
	return 0;
}