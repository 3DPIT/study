#include <vector>
#include <iostream>
#include <algorithm>
#include <queue>
#define NS 104
using namespace std;

int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };
struct Data {
	int y, x;
};

bool safeZone(int y, int x,int m,int n) {
	return 0<=y&&y<m&&0<=x&&x<n;
}

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
vector<int> solution(int m, int n1, vector<vector<int>> picture) {
	int number_of_area = 0;
	int max_size_of_one_area = 0;

	int visit[NS][NS] = { 0, };

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n1; j++) {
			if (picture[i][j] != 0&&visit[i][j]==0) {
				int cnt = 1;
				number_of_area++;
				visit[i][j] = 1;
				queue<Data>q;
				q.push({ i,j });

				while (!q.empty()) {
					Data c = q.front(); q.pop();
					for (int dir = 0; dir < 4; dir++) {
						Data n;
						n.y = c.y + dy[dir]; n.x = c.x + dx[dir];
						if (safeZone(n.y,n.x,m,n1)&&picture[n.y][n.x] == picture[i][j] && visit[n.y][n.x] == 0) {
							visit[n.y][n.x] = 1;
							cnt++;
							q.push({ n.y,n.x });
						}
					}
				}

				max_size_of_one_area = max(max_size_of_one_area, cnt);
			}
		}
	}



	vector<int> answer(2);
	answer[0] = number_of_area;
	answer[1] = max_size_of_one_area;
	return answer;
}

int main(void)
{
	solution(6, 4, { {1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3} });
	return 0;
}