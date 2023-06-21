#include<stdio.h>
#include<iostream>
using namespace std;
int rowDirection(char board[54][54], int y, int x) {
	int cnt = 0;
	for (int i = 0; i < y; i++) {
		int xCheck = 0;
		for (int j = 0; j < x; j++) {
			if (board[i][j] == 'X') {
				xCheck = -1;
				break;
			}
		}
		if (xCheck != -1)
			cnt++;
	}
	return cnt;
}
int colDirection(char board[54][54], int y, int x) {
	int cnt = 0;
	for (int j = 0; j < x; j++) {
		int xCheck = 0;
		for (int i = 0; i < y; i++) {

			if (board[i][j] == 'X') {
				xCheck = -1;

				break;
			}
		}
		if (xCheck != -1)
			cnt++;
	}
	return cnt;
}
int main(void) {
	int N, M;
	cin >> N >> M;

	char board[54][54];
	for (int i = 0; i < N; i++)
		cin >> board[i];


	int rowNumber = rowDirection(board, N, M);
	int colNumber = colDirection(board, N, M);
	if (rowNumber >= colNumber) {
		cout << rowNumber << "\n";
	}
	else {
		cout << colNumber << "\n";
	}
}