#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;
int N, M;
int D[10004];
int ret;
vector<int>d;
void dfs(int sum, int idx, int cnt) {
	if (idx >=N)return;

	if (sum == M) {
		for (int i = 0; i < d.size(); i++) {
			cout << d[i] << " ";
		}
		cout << endl;
		ret++;
		//return;
	}

	d.push_back(idx);
	dfs(sum , idx+1, cnt + 1);
	d.pop_back();
	dfs(sum + D[idx], idx+1, cnt);
}

int main(void) {
	
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++) {
		cin >> D[i];
	}
	dfs(0, 0,0);

	cout << ret << endl;
	return  0;
}