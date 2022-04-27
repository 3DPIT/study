#include<stdio.h>
#include<iostream>
#include<vector>
#include<string.h>
#define NS 25
using namespace std;
int board[NS][NS];
int visit[NS][NS];
int N;
int retMax, retMin;
int number[6];
int ret;
struct Data {
	int x, y;
};
bool safeZone(int y, int x) {
	return 1 <= y && y <= N && 1 <= x && x <= N;
}
void init() {
	retMax = 0x80000000;
	retMin = ret = 0x7fffffff;
	scanf("%d", &N);
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			scanf("%d", &board[i][j]);
		}
	}
}
void five(int x, int y, int d1, int d2) {
	memset(visit, 0, sizeof(visit));
	vector<Data>v1;
	vector<Data>v2;
	for (int i = x, j = y; i < x + d1, j >y - d1; i++, j--) {
		if (safeZone(i, j))
			v1.push_back({ i,j });
	}
	for (int i = x, j = y; i < x + d2, j < y + d2; i++, j++) {
		if (safeZone(i, j))

			v2.push_back({ i,j });

	}
	for (int i = x + d1, j = y - d1; i <= x + d1 + d2, j <= y - d1 + d2; i++, j++) {
		if (safeZone(i, j))

			v1.push_back({ i,j });
	}
	for (int i = x + d2, j = y + d2; i <= x + d2 + d1, j >= y + d2 - d1; i++, j--) {
		if (safeZone(i, j))

			v2.push_back({ i,j });
	}


	for (int i = 0; i < v1.size(); i++) {
		for (int xx = v1[i].x; xx <= v2[i].x; xx++) {
			for (int yy = v1[i].y; yy <= v2[i].y; yy++) {

				if (safeZone(xx, yy))
					visit[xx][yy] = 5;
			}
		}
	}

	//for (int i = 0; i < v1.size(); i++) {
	//	for (int y = v1[i].y; y <= v2[i].y; y++) {
	//		for (int x = v1[i].x; x <= v2[i].x; x++) {
	//			if (safeZone(y, x))
	//				visit[y][x] = 5;

	//		}

	//	}
	//}

	//for (int i = 1; i <= N; i++) {
	//	for (int j = 1; j <= N; j++) {
	//		if (visit[i][j] == 5) number[5] += board[i][j];
	//	}
	//}


/*	printf("\n");
	for (int i = 1; i <=N; i++) {
		for (int j = 1; j <= N; j++) {
			printf("%d ",visit[i][j]);
		}
		printf("\n");
	}
	printf("\n");*/
}
void one(int x, int y, int d1, int d2) {
	for (int i = 1; i < x + d1; i++) {
		for (int j = 1; j <= y; j++) {
			if (visit[i][j] == 0) {
				visit[i][j] = 1;
			}
		}
	}
}
void two(int x, int y, int d1, int d2) {
	for (int i = 1; i <= x + d2; i++) {
		for (int j = y + 1; j <= N; j++) {
			if (visit[i][j] == 0) {
				visit[i][j] = 2;
			}
		}
	}
}
void three(int x, int y, int d1, int d2) {
	for (int i = x + d1; i <= N; i++) {
		for (int j = 1; j < y - d1 + d2; j++) {
			if (visit[i][j] == 0) {
				visit[i][j] = 3;
			}
		}
	}
}
void four(int x, int y, int d1, int d2) {

	for (int i = x + d2 + 1; i <= N; i++) {
		for (int j = y - d1 + d2; j <= N; j++) {
			if (visit[i][j] == 0) {
				visit[i][j] = 4;
			}
		}
	}
}
void elect() {
	for (int d1 = 1; d1 <= N; d1++) {
		for (int d2 = 1; d2 <= N; d2++) {
			for (int x = 1; x <= N; x++) {
				for (int y = 1; y <= N; y++) {
					//x = 2; y = 4; d1 = 2; d2 = 2;
					if (x + d1 + d2 <= N && y - d1 < y&&y + d2 <= N) {
						memset(visit, 0, sizeof(visit));
						memset(number, 0, sizeof(number));
						five(x, y, d1, d2);
						one(x, y, d1, d2);
						two(x, y, d1, d2);
						three(x, y, d1, d2);
						four(x, y, d1, d2);
						for (int i = 1; i <= N; i++) {
							for (int j = 1; j <= N; j++) {
								number[visit[i][j]] += board[i][j];
							}
						}
						retMax = 0x80000000;
						retMin = 0x7fffffff;
						for (int n = 1; n <= 5; n++) {
							retMax = retMax < number[n] ? number[n] : retMax;
							retMin = retMin > number[n] ? number[n] : retMin;
						}
						int retnum = retMax - retMin;
						ret = ret > retnum ? retnum : ret;
					}
				}
			}
		}
	}
}
int main(void) {
	init();
	elect();
	printf("%d\n", ret);
	return 0;
}