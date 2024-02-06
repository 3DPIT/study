#include<stdio.h>
#include<vector>
#include<iostream>
using namespace std;
int main() {
	int N;
	int x, y, d, g;
	int dy[] = { 0,-1,0,1 };//L, U,R,D
	int dx[] = { 1,0,-1,0 };
	int board[104][104] = { 0, };
	cin >> N;
	while (N--) {
		vector<int>load;
		cin >> x >> y >> d >> g;
		load.push_back(d);
		for (int gIdx = 0; gIdx < g; gIdx++) {
			for (int i = load.size()-1; i >= 0; i--) {
				int dir = load[i] + 1;
				if (dir == 4) dir = 0;
				load.push_back(dir);
			}
		}
		
		board[y][x] = 1;
		for (int i = 0; i < load.size(); i++) {
			y += dy[load[i]];
			x += dx[load[i]];
			board[y][x] = 1;
		}
		//-> ^ < ^
	}
	int ret = 0;
	for (int i = 0; i <= 100; i++) {
		for (int j = 0; j <= 100; j++) {
			if (board[i][j] == 1 && board[i][j + 1] == 1 && board[i + 1][j] == 1 && board[i + 1][j + 1] == 1) {
				ret++;
			}
		}
	}
	cout << ret << endl;
}