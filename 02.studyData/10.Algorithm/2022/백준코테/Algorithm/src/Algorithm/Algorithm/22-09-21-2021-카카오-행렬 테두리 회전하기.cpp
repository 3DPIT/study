#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;
int N, M;
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };
int board[104][104];
int min_number;
struct Data {
	int sy, sx, ey, ex;
};

void numbering(int r, int c) {
	int number = 1;

	for (int i = 1; i <=r; i++) {
		for (int j = 1; j <= c; j++) {
			board[i][j] = number++;
		}
	}
}

int rotation(int r, int c,Data current, int board[104][104])
{
	min_number = 0x7fffffff;
	int y =  current.sy;
	int x = current.sx;
	int dir = 0;
	int number = 0;
	number = board[y][x];
	while (1) {
		y = y + dy[dir];
		x = x + dx[dir];
		if (y == current.sy&&x == current.sx)break;
		int cnumber = board[y][x];
		if (y == current.sy - 1 || x == current.sx - 1) {
			y = y - dy[dir];
			x = x - dx[dir];
			dir++;
			cnumber = number;
			if (dir == 4) dir = 0;
		}
		else if (y == current.ey+1 || x == current.ex+1) {
			y = y - dy[dir];
			x = x - dx[dir];
			dir++;
			cnumber = number;
			if (dir == 4) dir = 0;
		}
		else {
			board[y][x] = number;
		}
		min_number = min(min_number, number);

		number = cnumber;
	}
	board[y][x] = number;
	return min_number;
}

vector<int> solution(int rows, int columns, vector<vector<int>> queries) {
	vector<int> answer;
	numbering(rows, columns);
	Data current;
	for (int i = 0; i < queries.size(); i++) {
		current.sy = queries[i][0];
		current.sx = queries[i][1];
		current.ey = queries[i][2];
		current.ex = queries[i][3];
		int temp = board[current.sy][current.sx];
		min_number = temp;
		for (int y= current.sy; y < current.ey; y++) {
			board[y][current.sx] = board[y+1][current.sx];
			min_number = min(min_number, board[y][current.sx]);
		}

		for (int x = current.sx; x < current.ex; x++) {
			board[current.ey][x] = board[current.ey][x+1];
			min_number = min(min_number, board[current.ey][x]);
		}

		for (int y = current.ey; y > current.sy; y--) {
			board[y][current.ex] = board[y-1][current.ex];
			min_number = min(min_number, board[y][current.ex]);
		}

		for (int x = current.ex; x > current.sx; x--) {
			board[current.sy][x] = board[current.sy][x-1];
			min_number = min(min_number, board[current.sy][x]);
		}
		board[current.sy][current.sx+1] = temp;

		answer.push_back(min_number);

		
	}
	return answer;
}

int main(void)
{
	solution(6, 6, { {2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3} });
	return 0;
}
