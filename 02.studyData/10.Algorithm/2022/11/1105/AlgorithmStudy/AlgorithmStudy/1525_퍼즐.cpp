#include<stdio.h>
#include<vector>
#include<queue>
#include<map>
#include<string>
using namespace std;
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };

int main(void) {

	int start = 0;
	map<int, int> visit;
	queue<int>q;
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			int temp;
			scanf("%d", &temp);
			if (temp == 0) temp = 9;

			start = start * 10 + temp;
		}
	}

	q.push(start);
	visit[start] = 0;
	while (!q.empty()) {
		int c = q.front(); q.pop();
		string currentNumber = to_string(c);
		int number = currentNumber.find('9');
		int y = number / 3;
		int x = number % 3;

		for (int dir = 0; dir < 4; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (0 <= ny && ny < 3 && 0 <= nx && nx < 3) {
				string n = currentNumber;
				swap(n[y * 3 + x], n[ny * 3 + nx]);
				int num = stoi(n);
				if (visit.count(num) == 0) {
					visit[num] = visit[c] + 1;
					q.push(num);
				}
			}
		}
	}

	if (visit.count(123456789) == 0) {
		printf("%d", -1);
	}
	else {
		printf("%d\n", visit[123456789]);
	}

	return 0;
}