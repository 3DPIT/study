#include<stdio.h>
#include<queue>
#include<vector>
#include<string.h>
#include<algorithm>

using namespace std;

int visit[1004];
vector<int> g[1004];

struct Data {
	int y, x;
};

void dfs(int node) {
	visit[node] = 1;
	printf("%d ", node);
	for (int i = 0; i < g[node].size(); i++) {
		int n = g[node][i];
		if (visit[n] == 0) {
			dfs(n);
		}
	}
}
void bfs(int V) {
	memset(visit, 0, sizeof(visit));
	printf("\n");
	queue<int>q;
	q.push(V);
	visit[V] = 1;
	while (!q.empty()) {
		int c = q.front(); q.pop();
		printf("%d ", c);

		for (int i = 0; i < g[c].size(); i++) {
			int n = g[c][i];
			if (visit[n] == 0) {
				visit[n] = 1;
				q.push(n);
			}
		}
	}
}

int main(void) {

	int N, M, V;

	scanf("%d %d %d", &N, &M, &V);

	for (int i = 0; i < M; i++) {
		int s, e;
		scanf("%d %d", &s, &e);
		g[s].push_back(e);
		g[e].push_back(s);
	}

	for (int i = 1; i <= N; i++) {
		sort(g[i].begin(), g[i].end());
	}
	
	dfs(V);
	bfs(V);

	return 0;
}
//
//
//4 5 1
//1 2
//1 3
//1 4
//2 4
//3 4
//
//1 2 4 3
//1 2 3 4
//
//5 5 3
//5 4
//5 2
//1 2
//3 4
//3 1
//
//3 1 2 5 4
//3 1 4 2 5
//
//1000 1 1000
//999 1000
//
//1000 999
//1000 999