#include<stdio.h>
#include<iostream>
#include<vector>
#include<algorithm>
#define NS 100
using namespace std;
int N, M, H, K;
int dy[] = { 0,0,1,-1 };
int dx[] = { 1,-1,0,0};

int dyN[] = { -1,0,1,0 };
int dxN[] = { 0,1,0,-1 };

int dy0[] = { 1,0,-1,0 };
int dx0[] = { 0,1,0,-1 };

struct Data {
	int y, x, dir,num;
};
vector<Data>run;
vector<Data>runBoard[NS][NS];
int board[NS][NS];
int sBoard[NS][NS];//술래 위치
Data S;//술래
int ret;
int rotationNum[205];

bool safeZone(int y, int x) {
	return 0 <= y && y < N && 0 <= x && x < N;
}

void init() {
	ret = 0;
	run.clear();
	memset(rotationNum, 0, sizeof(rotationNum));
	memset(board, 0, sizeof(board));
	memset(sBoard, 0, sizeof(sBoard));

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			runBoard[i][j].clear();
		}
	}

	scanf("%d %d %d %d", &N, &M, &H, &K);

	int idx = 0;
	for (int n = 1; n < N; n++) {
		rotationNum[idx++] = n;
		rotationNum[idx++] = n;
	}
	rotationNum[idx++] = N-1;

	for (int m = 1; m <= M; m++) {
		int y, x, dir;
		scanf("%d %d %d", &y, &x, &dir);
		run.push_back({ y-1,x-1,dir,m });
		runBoard[y][x].push_back({ y-1,x-1,dir,m });
	}

	for (int h = 1; h <= H; h++) {
		int y, x;
		scanf("%d %d", &y, &x);
		board[y-1][x-1] = -1;
	}
	S.y = (N /2); S.x = (N / 2);
	sBoard[S.y][S.x] = 1;
}

void play() {
	int flag = 0;
	int idx = 0;
	int gidx = 0;
	int ggidx = 0;
	int nidx = rotationNum[0];
	for (int k1 = 1; k1 <= K; k1++) {
		for (int k = 0; k < M; k++) {
			if (run[k].dir == -1) continue;
			int D = abs(run[k].y - S.y) + abs(run[k].x - S.x);
			if (D <= 3) {
				Data n;
				n.dir = run[k].dir;
				n.y = run[k].y + dy[n.dir];
				n.x = run[k].x + dx[n.dir];
				if (sBoard[n.y][n.x] == -1) continue;
				if (safeZone(n.y, n.x) && sBoard[n.y][n.x] != -1) {//범위에 있고 술레위치가 아니면
					for (int s = 0; s < runBoard[run[k].y][run[k].x].size(); s++) {
						if (runBoard[run[k].y][run[k].x][s].num == k + 1) {
							runBoard[run[k].y][run[k].x].erase(runBoard[run[k].y][run[k].x].begin() + s);

							runBoard[n.y][n.x].push_back({ n.y,n.x,n.dir,k });//이동완료
							run[k] = n;

						}

					}
				}
				else if (!safeZone(n.y, n.x)) {
					if (n.dir == 1)n.dir = 0;
					else if (n.dir == 0)n.dir = 1;
					else if (n.dir == 2) n.dir = 3;
					else if (n.dir == 3) n.dir = 2;
					n.y = S.y + dy[n.dir];
					n.x = S.x + dx[n.dir];
					if (sBoard[n.y][n.x] == -1) continue;
					if (safeZone(n.y, n.x) && sBoard[n.y][n.x] != -1) {//범위에 있고 술레위치가 아니면
						for (int s = 0; s < runBoard[S.y][S.x].size(); s++) {
							if (runBoard[run[k].y][run[k].x][s].num == k) {
								runBoard[run[k].y][run[k].x].erase(runBoard[run[k].y][run[k].x].begin() +s);

								runBoard[n.y][n.x].push_back({ n.y,n.x,n.dir,k });//이동완료
								run[k] = n;

							}

						}
					}
				}
			}// D<=3
		}

		//술래 이동
		if(flag == 0) {

			sBoard[S.y][S.x] = 0;
			S.y = S.y + dyN[idx];
			S.x = S.x + dxN[idx];
			sBoard[S.y][S.x] = -1;
			gidx++;

			if (gidx == nidx) {
				idx++;
				if (idx == 4) idx = 0;
				gidx = 0;
				nidx = rotationNum[ggidx++];
			}

			for (int dir = 0; dir < 3; dir++) {
				int ny = S.y + dy[idx] * dir;
				int nx = S.x + dx[idx] * dir;
				if (board[ny][nx] != -1) {
					if (runBoard[ny][nx].size() == 0) continue;
					ret += runBoard[ny][nx].size()*k1;
					for (int s = 0; s < runBoard[S.y][S.x].size(); s++) {
						if (runBoard[S.y][S.x][s].num == runBoard[ny][nx][s].num) {
							int num = runBoard[ny][nx][s].num;
							runBoard[S.y][S.x].erase(runBoard[S.y][S.x].begin() + s);

							runBoard[ny][nx].push_back({ ny,nx,idx,num });//이동완료
							run[k1].y = -1;
							run[k1].x = -1;
							run[k1].dir = -1;
							break;
						}

					}
				}
			}

			if (S.y == 0 && S.x == 0) {
				flag = 1;
				idx = 0;
			}
		}
		else if (flag == 1) {

			sBoard[S.y][S.x] = 0;
			S.y = S.y + dy0[idx];
			S.x = S.x + dx0[idx];
			sBoard[S.y][S.x] = -1;


			if (gidx == nidx) {
				idx++;
				gidx = 0;
				nidx = rotationNum[gidx];
			}

			for (int dir = 0; dir < 3; dir++) {
				int ny = S.y + dy[idx] * dir;
				int nx = S.x + dx[idx] * dir;
				if (board[ny][nx] == -1) {
					ret += runBoard[ny][nx].size()*k1;
					for (int s = 0; s < runBoard[S.y][S.x].size(); s++) {
						if (runBoard[S.y][S.x][s].num == runBoard[ny][nx][s].num) {
							int num = runBoard[ny][nx][s].num;
							runBoard[S.y][S.x].erase(runBoard[S.y][S.x].begin() + s);

							runBoard[ny][nx].push_back({ ny,nx,idx,num });//이동완료
							run[k1].y = -1;
							run[k1].x = -1;
							run[k1].dir = -1;
							break;
						}

					}
				}
			}

			if (S.y == N-1/2 && S.x == N-1/2) {
				flag = 0;
				idx = 0;
			}
		}
	}
}

int main(void) {
	init();
	play();
	cout << ret;
	return 0;
}