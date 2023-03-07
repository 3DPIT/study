#include<stdio.h>
#include<iostream>
#include<queue>
#define NS 54
using namespace std;
int N;
int L, R;
int ret;
int board[NS][NS];
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };

bool safeZone(int y, int x) {
	return 0 <= y && y < N && 0 <= x && x < N;
}

struct Data {
	int y, x;
};

void init() {
	scanf("%d %d %d", &N, &L, &R);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			scanf("%d", &board[i][j]);
		}
	}
}


void roadOpen() {

	while (1) {
		ret++;
		int visit[NS][NS] = { 0 };
		int cnt = 0;

		queue<Data>q;
		
		for (int i = 0; i < N; i++) {// check people
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == 0) {
					visit[i][j] = ++cnt;
					q.push({ i,j });

					while (!q.empty()) {
						Data c = q.front(); q.pop();

						for (int dir = 0; dir < 4; dir++) {
							Data n;
							n.y = c.y + dy[dir];
							n.x = c.x + dx[dir];
							int people = (abs(board[c.y][c.x] - board[n.y][n.x]));
							if (safeZone(n.y,n.x)&&L <= people && people <= R && visit[n.y][n.x] == 0) {
								visit[n.y][n.x] = cnt;
								q.push(n);
							}
						}
					}

				}
			}
		}
		if (cnt == N * N)break;
		
		Data data[2540] = { 0, };

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				data[visit[i][j]].y++;
				data[visit[i][j]].x += board[i][j];
			}
		}

		for (int n = 1; n <= cnt; n++) {
			data[n].x = data[n].x / data[n].y;

		}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (data[visit[i][j]].y == 1) continue;
					board[i][j] = data[visit[i][j]].x;
				}
			}
	

		//for (int i = 0; i < N; i++) {
		//	for (int j = 0; j < N; j++) {
		//		cout << board[i][j] << " ";
		//	}
		//	cout << endl;
		//}
	}
}

int main(void)
{
	init();
	roadOpen();
	cout << ret-1 << "\n";
	return 0;
}