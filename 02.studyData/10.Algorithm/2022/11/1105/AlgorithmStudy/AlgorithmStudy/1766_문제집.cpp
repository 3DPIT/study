#include<stdio.h>
#include<iostream>
#include<queue>
using namespace std;
vector<int>G[32004];
int g_visit[32004];
int main() {

	int N, M;
	cin >> N >> M;

	for (int i = 0; i < M; i++) {
		int u, v;
		cin >> u >> v;
		G[u].push_back(v);
		g_visit[v] += 1;
	}

	priority_queue<int>pq;

	for (int i = 1; i <= N; i++) {
		if (g_visit[i] == 0) {
			pq.push(-i);
		}
	}

	for (int i = 0; i < N; i++) {
		int c = -pq.top();
		pq.pop();
		printf("%d ", c);
		for (int i = 0; i < G[c].size(); i++) {
			int n = G[c][i];
			g_visit[n] -= 1;
			if (g_visit[n] == 0) {
				pq.push(-n);
			}
		}
	}

	return 0;
}


//
//#include<iostream>
//#include<stdio.h>
//#include<vector>
//#include<queue>
//using namespace std;
//vector<int> G[100004];
//queue<int> q;
//int n;
//int m;
//int d[100004];
//int main(void)
//{
//	scanf("%d%d", &n, &m);
//	for (int i = 0; i < m; i++)
//	{
//		int a, b;
//		scanf("%d%d", &a, &b);
//		G[a].push_back(b);
//		d[b]++;
//	}
//	for (int i = 1; i <= n; i++)
//	{
//		if (d[i] == 0) q.push(i);
//	}
//	while (!q.empty())
//	{
//		int now = q.front();
//		q.pop();
//		printf("%d ", now);
//		for (int i = 0; i < G[now].size(); i++)
//		{
//			int there = G[now][i];
//			d[there]--;
//			if (d[there] == 0) q.push(there);
//		}
//	}
//	return 0;
//}
