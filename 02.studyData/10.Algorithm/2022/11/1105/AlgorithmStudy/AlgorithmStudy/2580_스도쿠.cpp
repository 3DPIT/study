#include <stdio.h>
#include <vector>
#include <cstdlib>
using namespace std;

int N;
int board[9][9];

struct Pos {
	int y;
	int x;
};
vector<Pos>zeroBlank;

void init() {
	N = 9;
	for (int i = 0; i < N; i++){
		for (int j = 0; j < N; j++) {
			scanf("%d", &board[i][j]);
			if (board[i][j] == 0) {
				zeroBlank.push_back({ i,j });
			}
		}
	}
}
bool checkNumber(int y, int x, int num) {
	//->
	for (int checkX = 0; checkX < 9; checkX++) {
		if (checkX == x) continue;
		if (board[y][checkX] == num) return false;
	}
	
	//V
	for (int checkY = 0; checkY < 9; checkY++) {
		if (checkY == y) continue;
		if (board[checkY][x] == num) return false;
	}

	//square
	int startY = (y / 3) * 3;
	int endY = startY + 3;
	int startX = (x / 3) * 3;
	int endX = startX + 3;

	for (int i = startY; i < endY; i++) {
		for (int j = startX; j < endX; j++) {
			if (board[i][j] == num) return false;
		}
	}

	return true;
}


void dfs(int idx) {
	if (idx == zeroBlank.size()) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				printf("%d ", board[i][j]);
			}
			printf("\n");
		}

		exit(0);
	}

	for (int num = 1; num <= 9; num++) {
		int y = zeroBlank[idx].y;
		int x = zeroBlank[idx].x;
		if (checkNumber(y, x, num)) {
			board[y][x] = num;
			dfs(idx + 1);
			board[y][x] = 0;
		}
	}
}

void playSudoku() {
	dfs(0);
}

int main(void)
{
	init();
	playSudoku();
	
	return 0;
}