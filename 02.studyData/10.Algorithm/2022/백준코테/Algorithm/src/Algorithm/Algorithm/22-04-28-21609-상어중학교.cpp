#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<queue>
#include<string.h>
#define NS 24
using namespace std;
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };
int N, M, ret;
int board[NS][NS];
int visit[NS][NS] = { 0, };

bool safeZone(int y, int x) {
	return 0 <= y && y < N && 0 <= x && x < N;
}
struct Data {// 일반 큐
	int y, x, cnt, sevenCnt;
};
struct DataInfo {// 우선 순위 큐 정렬조건 및 변수
	int y, x, cnt = 0, sevenCnt = 0;
	bool operator<(const DataInfo & i)const {
		if (cnt == i.cnt) {
			if (sevenCnt == i.sevenCnt) {
				if (y == i.y)return x < i.x;
				else  return y < i.y;
			}
			else return sevenCnt < i.sevenCnt;
		}
		else return cnt < i.cnt;
	}
};

priority_queue<DataInfo>pq;
void one() {
	memset(visit, 0, sizeof(visit));

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (visit[i][j] == 0 && board[i][j] > 0) {// 블랙 과 무지개 블록 제외
				int rainbowVisit[NS][NS] = { 0, };
				queue<Data>q;
				q.push({ i,j,0,0 });
				visit[i][j] = 1;
				int cnt = 1, sevenCnt = 0;
				while (!q.empty()) {
					Data c = q.front(); q.pop();
					for (int dir = 0; dir < 4; dir++) {
						Data n;
						n.y = c.y + dy[dir];  n.x = c.x + dx[dir];
						if (safeZone(n.y, n.x) && visit[n.y][n.x] == 0 && rainbowVisit[n.y][n.x] == 0) {
							if (board[n.y][n.x] == -2) {
								rainbowVisit[n.y][n.x] = 1;
								cnt++;
								sevenCnt++;
								q.push(n);
							}
							else if (board[n.y][n.x] == board[i][j]) {
								visit[n.y][n.x] = 1;
								cnt++;
								q.push(n);
							}
						}
					}
				}// while(!q.empty())
				if (cnt > 1) pq.push({ i,j,cnt,sevenCnt });// 분류
			}
		}
	}
}
void dfs(int y, int x, int cnt, int num) {
	for (int dir = 0; dir < 4; dir++) {
		Data n;
		n.y = y + dy[dir]; n.x = x + dx[dir];
		n.cnt = cnt + 1;
		if (safeZone(n.y, n.x) && visit[n.y][n.x] == 0 && (board[n.y][n.x] == -2 || board[n.y][n.x] == num)) {
			visit[n.y][n.x] = 1;
			dfs(n.y, n.x, n.cnt, num);
		}
	}
}
void two() {// 블록 제거
	memset(visit, 0, sizeof(visit));
	DataInfo n = pq.top();
	dfs(n.y, n.x, 0, board[n.y][n.x]);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (visit[i][j] == 1) {
				board[i][j] = 0;
			}
		}
	}
	ret += n.cnt*n.cnt;
}
void three() {//중력
	for (int j = 0; j < N; j++) {
		deque<int>q;
		for (int i = 0; i < N; i++) {
			if (board[i][j] != 0 && board[i][j] != -1) {
				q.push_back(board[i][j]);
				board[i][j] = 0;
			}
			else if (board[i][j] == -1) {
				int ci = i;
				while (!q.empty()) {
					board[--ci][j] = q.back(); q.pop_back();
				}
			}
		}
		int ci = N - 1;
		while (!q.empty()) {
			board[ci--][j] = q.back(); q.pop_back();
		}
	}
}
void four() {
	int crr[NS][NS] = { 0, };
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			crr[i][j] = board[j][N - i - 1];
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			board[i][j] = crr[i][j];
		}
	}
}
void init() {
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			scanf("%d", &board[i][j]);
			if (board[i][j] == 0)board[i][j] = -2;//무지개 -2로 변경
		}
	}
}

int main(void)
{
	init();
	while (1) {
		while (!pq.empty())pq.pop();
		one();
		if (pq.size() == 0) break;
		two();
		three();
		four();
		three();
	}
	printf("%d\n", ret);
	return 0;
}