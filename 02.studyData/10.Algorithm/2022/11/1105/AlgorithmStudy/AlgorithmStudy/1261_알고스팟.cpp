// 우선 순위 큐 사용하는 경우
// 시간복잡도 O(N^2logN)
#include<stdio.h>
#include<queue>
using namespace std;
int N, M;
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };
int board[104][104];
int visit[104][104];

bool safeZone(int y, int x) {
	return 0 <= y && y < N && 0 <= x && x < M;
}

int main(void) {

	scanf("%d %d", &M, &N);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%1d", &board[i][j]);
			visit[i][j] = -1;
		}
	}

	priority_queue<pair<int,pair<int,int>>> pq;
	pq.push(make_pair(0, make_pair(0, 0)));
	visit[0][0] = 0;

	while (!pq.empty()) {
		int y = pq.top().second.first;
		int x = pq.top().second.second;
		pq.pop();

		for (int dir = 0; dir < 4; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (safeZone(ny, nx)&&visit[ny][nx] == -1&&board[ny][nx] == 0) {
				visit[ny][nx] = visit[y][x];
				pq.push(make_pair(-visit[ny][nx], make_pair(ny, nx)));
			}
			else if(safeZone(ny, nx)&&visit[ny][nx] == -1&&board[ny][nx] == 1){

				visit[ny][nx] = visit[y][x] + 1;
				pq.push(make_pair(-visit[ny][nx], make_pair(ny, nx)));
			}
		}
	}

	printf("%d", visit[N - 1][M - 1]);
	return 0;
}

//
// O(N^2) - 큐 두개 사용한경우
//
//#include<stdio.h>
//#include<iostream>
//#include<queue>
//using namespace std;
//int N, M;
//
//struct Data {
//	int y; int x; int cnt;
//};
//int board[104][104];
//int dy[] = { 0,1,0,-1 };
//int dx[] = { 1,0,-1,0 };
//int visit[104][104];
//
//bool safeZone(Data n) {
//	return 0 <= n.y && n.y < M && 0 <= n.x && n.x < N;
//}
//
//int main(void) {     
//
//	scanf("%d %d ", &N, &M);
//	for (int i = 0; i < M; i++) {
//		for (int j = 0; j < N; j++) {
//			scanf("%1d", &board[i][j]);
//			visit[i][j] = -1;
//		}
//	}
//
//	queue<Data>q;
//	queue<Data>nq;
//	q.push({ 0, 0 });
//	visit[0][0] = 0; 
//	int ret = 0x7fffffff;
//
//	while (!q.empty()) {
//		Data c = q.front(); q.pop();
//		if (c.y ==M-1 && c.x == N-1) {
//			ret = min(ret, c.cnt);
//		}
//
//		for (int dir = 0; dir < 4; dir++) {
//			Data n = c;
//			n.y = c.y + dy[dir];
//			n.x = c.x + dx[dir];
//
//			//if (safeZone(n)) {
//			//	if (visit[n.y][n.x] == -1) {
//			//		if (board[n.y][n.x] == 0) {
//			//			visit[n.y][n.x] = visit[c.y][c.x];
//			//			q.push(n);
//			//		}
//			//		else {
//			//			n.cnt++;
//			//			visit[n.y][n.x] = visit[c.y][c.x]+1;
//			//			nq.push(n);
//			//		}
//			//	}
//			//}
//
//			if (safeZone(n)&&visit[n.y][n.x] == -1&&board[n.y][n.x]==0) {
//				visit[n.y][n.x] = visit[c.y][c.x];
//				q.push(n);
//			}
//			else if (safeZone(n)&&visit[n.y][n.x] == -1 && board[n.y][n.x] == 1) {
//				n.cnt++;
//				visit[n.y][n.x] = visit[c.y][c.x]+1;
//				nq.push(n);
//			}
//		}
//		if (q.empty()) {
//			q = nq;
//			nq = queue<Data>();
//		}
//	}
//
//	if (ret == -1) {
//		cout << 0 << endl;
//	}
//	cout << visit[M- 1][N - 1] << endl;
//	//cout <<ret << endl;
//
//
//	return 0;
//}