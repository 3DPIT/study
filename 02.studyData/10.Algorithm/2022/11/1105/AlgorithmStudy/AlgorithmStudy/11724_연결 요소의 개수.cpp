#include<stdio.h>
#include<vector>

using namespace std;

int N, M;
int visit[1004];
vector<vector<int>> G(1004);

void dfs(int node) {
	visit[node] = 1;

	for (int i = 0; i<G[node].size(); i++) {
		int n = G[node][i];
		if (visit[n] == 0) {
			dfs(n);
		}
	}
}

int main() {
	int ret=0;
	scanf("%d %d", &N, &M);

	for (int i=0; i < M; i++) {
		int u, v;
		scanf("%d %d", &u, &v);

		G[u].push_back(v);
		G[v].push_back(u);
	}

	for (int i = 1; i <= N; i++) {
		if (visit[i] == 0) {
			dfs(i);
			ret++;
		}
	}

	printf("%d\n", ret);

	return 0;
}