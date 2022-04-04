#include<stdio.h>
#include<iostream>
#include<string.h>
using namespace std;
#define NSIZE 102
int N;
int K;
int L;
int ret;
int board[NSIZE][NSIZE];
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };
void initValue()
{
	memset(board, 0, sizeof(board));
	ret = 1;
	N = K = 0;
	scanf("%d", &N);// 보드판 수
	scanf("%d", &K);// 사과 개수
	for (int k = 0; k < K; k++) {
		int y, x;
		scanf("%d %d", &y, &x);
		board[y][x] = -1;
	}
}
void play() {
	int y = 1; int x = 1;
	int size = 1;
	int head = 1;
	int tail = 0;
	int dir = 0;
	board[1][1] = 1;
	ret = 0;
	scanf("%d", &L);
	for (int l = 0; l < L; l++) {
		int X; char C;
		scanf("%d %c", &X, &C);

		while (1) {
			if (ret == X) {

				if (C == 'D') {
					dir++;
					if (dir == 4)dir = 0;
				}
				else {
					dir--;
					if (dir == -1)dir = 3;
				}
				if (l != L - 1)break;
			}
			++ret;
			y += dy[dir];
			x += dx[dir];
			if (board[y][x] == -1) {// 사과 위치
				board[y][x] = 0;
				size++;
			}
			tail = ret - size ;
			if (!(1 <= y && y <= N && 1 <= x && x <= N) || (board[y][x] != 0 && tail <= board[y][x])) {//탈출

				while (l != L-1) {
					l++;
					scanf("%d %c", &X, &C);
				}
				break;
			}
			board[y][x] = ret;

		}
	}
}
int main(void)
{
	initValue();
	play();
	cout << ret;
	return 0;
}