#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>

using namespace std;
vector<int> a[20001];
int color[20001];
int visit[20001];

void dfs(int node, int c) {
	color[node] = c;
	for (int i = 0; i < a[node].size(); i++) {
		int next = a[node][i];
		if (color[node] == 0) {
			dfs(next, 3 - c);
		}
	}
}

bool dfs1(int node) {
	for (int i = 0; i < a[node].size(); i++) {
		int n = a[node][i];
		if (visit[n]) continue;
		visit[n] = 1;

		if (color[n] == 0 || dfs1(color[n])) {
			color[n] = node;
			return true;
		}
	}

	return false;
}

int main(void) {
	int t;
	scanf("%d\n", &t);
	
	while (t--) {
		int n, m;
		scanf("%d %d", &n, &m);
		for (int i = 1; i <= n; i++) {
			a[i].clear();
			color[i] = 0;
		}

		for (int i = 0; i < m; i++) {
			int u, v;
			scanf("%d %d", &u, &v);
			a[u].push_back(v);
		}

		//for (int i = 1; i <= n; i++) {
		//	if (color[i] == 0) {
		//		dfs(i, 1);
		//	}
		//}
		
		int count = 0;
		for (int i = 1; i <= n; i++) {
			fill(visit, visit + 20001, 0);
			if (dfs1(i)) count++;
		}

	/*	bool ok = true;
		for (int i = 1; i <= n; i++) {
			for (int k = 0; k < a[i].size(); k++) {
				int j = a[i][k];
				if (color[i] == color[j]) {
					ok = false;
				}
			}
		}*/

		//printf("%s\n", ok ? "YES" : "NO");
		if ((count == n)) {
			printf("YES\n");
		}
		else {
			printf("NO\n");
		}
	}

	return 0;
}