#include<stdio.h>
#include<iostream>
#include<vector>
#define NS 51
using namespace std;
int N, M;
int board[NS][NS];
int ret;
vector<int>O;//구슬 저장
vector<int>newO;
int dy[] = { 0,-1,1,0,0 };
int dx[] = { 0,0,0,-1,1 };
int dy_s[] = {0,1,0,-1 };//당팽이 배열 dir
int dx_s[] = { -1,0,1,0 };
int one, two, three;
struct Data {
	int y, x;
};

void init() {
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			scanf("%d", &board[i][j]);
		}
	}
}
void snailPush() {
	O.clear();
	newO.clear();
	int num = 1;
	int cnt = 2;
	int y = (N - 1) / 2;
	int x = (N - 1) / 2;
	int dir = 0;
	while (1) {
		if (N - 1 == num) cnt = 3;
		if (y == 0 && x == 0)break;
		for (int c = 0; c < cnt; c++) {
			for (int ni = 0; ni< num; ni++) {
				Data n;
				n.y = y + dy_s[dir];
				n.x = x + dx_s[dir];
				if (board[n.y][n.x] != 0) {
					O.push_back({ board[n.y][n.x] });
					board[n.y][n.x] = 0;
				}
				y = n.y;
				x = n.x;
			}
			dir = (dir + 1) % 4;

		}
		num++;

	}
	while (1) {
		int flag = 0;
		for (int i = 0; i < O.size(); i++) {
			if (O.size() == 0)break;
			int cnt = 0;
			for (int j = i; j < O.size(); j++) {
				while (O[i] == O[j]) {
					cnt++;
					j++;
					if (j == O.size())break;
				}
				if (cnt>= 4) {//제거
					flag = 1;
					if (O[i] == 1) one += cnt;
					if (O[i] == 2)two += cnt;
					if (O[i] == 3)three += cnt;
					O.erase(O.begin() + i, O.begin() + j);
					i--;
					break;
				}
				else break;
			}
		}
		if (flag == 0)break;
	}
	for (int i = 0; i < O.size(); i++) {//새로운 구슬 생성
		if (O.size() == 0)break;
		int cnt = 0;
		for (int j = i; j < O.size(); j++) {
			while (O[i] == O[j]) {
				cnt++;
				j++;
				if (j == O.size())break;
			}
			newO.push_back(cnt);
			newO.push_back(O[i]);
			i = j;
			i--;
			//if (i + 1 == O.size() - 1) {
			//	newO.push_back(1);
			//	newO.push_back({ O[i + 1] });
			//}
			break;
		}
	}


}
void snailadd() {
	int num = 1;
	int cnt = 2;
	int y = (N - 1) / 2;
	int x = (N - 1) / 2;
	int dir = 0;
	while (1) {
		int flag = 0;
		if (N - 1 == num) cnt = 3;
		if (y == 0 && x == 0)break;
		for (int c = 0; c < cnt; c++) {
			for (int ni = 0; ni < num; ni++) {
				Data n;
				n.y = y + dy_s[dir];
				n.x = x + dx_s[dir];

				if (newO.size() == 0) {
					flag = 1;
					break;
				}
				board[n.y][n.x] = newO.front();
				newO.erase(newO.begin());
				y = n.y;
				x = n.x;
			}
			if (flag)break;
			dir = (dir + 1) % 4;

		}
		if (flag)break;
		num++;
	}


	
}
void magic(int dir, int S) {
	int y = (N + 1) / 2;
	int x = (N + 1) / 2;
	y--;
	x--;
	for (int s = 1; s <= S; s++) {
		Data n;
		n.y = y + (dy[dir] * s);
		n.x = x + (dx[dir] * s);
		board[n.y][n.x] = 0;
		//if (board[n.y][n.x] == 1) {
		//	one++;
		//	board[n.y][n.x] = 0;
		//}
		//else if (board[n.y][n.x] == 2) {
		//	two++;
		//	board[n.y][n.x] = 0;
		//}
		//else if (board[n.y][n.x] == 3) {
		//	three++;
		//	board[n.y][n.x] = 0;
		//}
	}
}
void play() {
	for (int m = 0; m < M; m++) {
		int dir, S;
		scanf("%d %d", &dir, &S);
		magic(dir, S);
		snailPush();
		snailadd();
	}
	ret = (1 * one) + (2 * two) + (3 * three);
}
int main(void) {
	init();
	play();
	snailPush();
	printf("%d\n", ret);
	return 0;
}