//#include<stdio.h>
//#include<iostream>
//#include<queue>
//using namespace std;
//
//int visit[200004];
//struct Data {
//	int pos;
//	int cnt;
//};
//int main(void)
//{
//	queue<Data>q;
//	int s, e;
//	scanf("%d %d", &s, &e);
//	q.push({ s,0 });
//	visit[s] = 1;
//	while (!q.empty()) {
//		Data c = q.front(); q.pop();
//		if (c.pos == e)
//		{
//			cout << c.cnt << endl;
//			break;
//		}
//		Data n = c;
//		n.pos = n.pos - 1;
//
//		if (n.pos >= 0 && visit[n.pos] == 0) {
//			visit[n.pos] = 1;
//			n.cnt += 1;
//			q.push(n);
//		}
//		n = c;
//		n.pos = n.pos + 1;
//		if (n.pos >= 0 && visit[n.pos] == 0) {
//			visit[n.pos] = 1;
//			n.cnt += 1;
//			q.push(n);
//		}
//		n = c;
//		n.pos = n.pos * 2;
//		if (n.pos >= 0 && n.pos <= 100000 && visit[n.pos] == 0) {
//			visit[n.pos] = 1;
//			n.cnt += 1;
//			q.push(n);
//		}
//	}
//	return 0;
//}
#include<iostream>
#include<queue>
using namespace std;
const int MAX = 200000;
bool check[MAX + 1];
int dist[MAX + 1];

int main() {
	int n, m;
	cin >> n >> m;
	check[n] = true;
	dist[n] = 0;
	queue<int>q;
	q.push(n);

	while (!q.empty()) {
		int now = q.front();
		q.pop();
		if (now - 1 >= 0) {
			if (check[now - 1] == false) {
				q.push(now - 1);
				check[now - 1] = true;
				dist[now - 1] = dist[now] + 1;
			}
		}
		if (now + 1<= MAX) {
			if (check[now +1] == false) {
				q.push(now + 1);
				check[now + 1] = true;
				dist[now + 1] = dist[now] + 1;
			}
		}
		if (now * 2 <= MAX) {
			if (check[now *2] == false) {
				q.push(now *2);
				check[now *2] = true;
				dist[now *2] = dist[now] + 1;
			}
		}
	}

	cout << dist[m] << endl;
}