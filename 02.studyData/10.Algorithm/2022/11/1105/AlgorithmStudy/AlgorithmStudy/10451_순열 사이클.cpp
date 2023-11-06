//#include<iostream>
//#include<vector>
//#include<string.h>
//using namespace std;
//
//int visit[1004];
//bool flag = true;
//vector<vector<int> > G(1004);
//int ret;
//
//void dfs(int node,int cnt) {
//	visit[node] = true;
//	
//	for (int i = 0; i < G[node].size(); i++) {
//		int nextNode = G[node][i];
//		if (visit[nextNode] == false){
//			visit[nextNode ] = cnt;
//			dfs(nextNode,cnt);
//		}
//		else {
//			flag = false;
//		}
//	}
//}
//
//int main(void) {
//	int T;
//	int N;
//	cin >> T;
//	while (T--) {
//		cin >> N;
//		memset(visit, 0, sizeof(visit));
//		flag = true;
//		ret = 0;
//		for (int i = 0; i <= N; i++) {
//			G[i].clear();
//		}
//		for (int u = 1; u <= N; u++) {
//			int v;
//			cin >> v;
//			G[u].push_back(v);
//		}
//
//		for (int i = 1; i <= N; i++) {
//			int cnt = 0;
//			flag = true;
//			if (visit[i] == 0) {
//				dfs(i, cnt++);
//				if (flag == false) {
//					ret++;
//					flag = true;
//				}
//			}
//		}
//
//		cout << ret << endl;
//	}
//}

#include<iostream>
using namespace std;
int a[1001];
bool c[1001];

void dfs(int x) {
	if (c[x]) return;
	c[x] = true;
	dfs(a[x]);
}

int main(void) {
	int t;
	cin >> t;
	while (t--) {
		int n;
		cin >> n;
		for (int i = 1; i <= n; i++) {
			cin >> a[i];
			c[i] = false;
		}

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (c[i] == false) {
				dfs(i);
				ans += 1;
			}
		}

		cout << ans << '\n';
	}
}




















