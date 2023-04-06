#include<stdio.h>
#include<iostream>
#include<vector>
#include<string.h>
#include<algorithm>
using namespace std;

#define NS 14
int N,M,K;
int dy[] = { -1,-1,-1,0,0,1,1,1 };
int dx[] = { -1,0,1,-1,1,-1,0,1 };
int A[NS][NS];
int Die[NS][NS];
int board[NS][NS];
int ret;
vector<int>Tree[NS][NS];

struct Data {
	int y;
	int x;
};

bool safeZone(int y, int x) {
	return 0 <= y && y < N && 0 <= x && x < N;
}
void init() {
	memset(A, 0, sizeof(A));


	scanf("%d %d %d", &N, &M, &K);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			Tree[i][j].clear();
			board[i][j] = 5;
			scanf("%d", &A[i][j]);
		}
	}
	
	for (int m = 0; m < M; m++) {
		int y, x,age;
		scanf("%d %d %d", &y, &x, &age);
		Tree[y-1][x-1].push_back(age);
	}
}

void spring();
void summer();
void fall();
void winter();
void working();
int main(void)
{
	int testCase = 1;
	for (int tc = 0; tc < testCase; tc++) {
		init();
		working();
		cout << ret << endl;
	}
	return 0;
}

void spring() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < Tree[i][j].size(); k++) {
				if (Tree[i][j].size() == 0) break;
				if (board[i][j] - Tree[i][j][k] >= 0)// 양분이 충분한 경우
				{
					board[i][j] -= Tree[i][j][k];
					Tree[i][j][k]++;// 나이 증가
				}
				else {//양분이 부족한 경우
					Die[i][j] += Tree[i][j][k] / 2;
					Tree[i][j].erase(Tree[i][j].begin()+k);
					k--;
				}
			}
		}
	}
}

void summer() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			board[i][j] += Die[i][j];
			Die[i][j] = 0;
		}
	}
}

void fall() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < Tree[i][j].size(); k++) {
				if (Tree[i][j][k] % 5 == 0)// 5배수
				{
					for (int dir = 0; dir < 8; dir++) {
						int ny = i + dy[dir];
						int nx = j + dx[dir];

						if (safeZone(ny, nx)) {//애기 생산
							Tree[ny][nx].push_back(1);
						}
					}
				}
			}
		}
	}
}

void winter() {//R2D2 열일중
	ret = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			board[i][j] += A[i][j];
			ret += Tree[i][j].size();
			sort(Tree[i][j].begin(), Tree[i][j].end());
		}
	}
}
 
void working() {
	for (int k = 0; k<K; k++) {
		spring();
		summer();
		fall();
		winter();
	}
}