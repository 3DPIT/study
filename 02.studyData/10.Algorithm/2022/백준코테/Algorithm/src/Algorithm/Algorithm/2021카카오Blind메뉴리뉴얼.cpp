#include <string>
#include <vector>
#include <iostream>
#include <algorithm>


using namespace std;
//int D[24];
vector<int>D;
int idx_size = 0;
int y_size = 0;
int orders_A[28][28];
int ret;
struct Data {
	string alpha;
};
vector<string> A[28];
void dfs(int idx, int cnt,int number) {
	if (idx == idx_size+2)return;
	if (cnt == number) {
		int people_cnt = 0;
		for (int i = 0; i < y_size; i++) {
			int cnt = 0;
			for (int j = 0; j < D.size(); j++) {
				if (orders_A[i][D[j]] == 1) cnt++;
			}

			if (cnt == number) {
				people_cnt++;
			}
		}
		if (people_cnt >= 2 && ret <= people_cnt) {
			ret = people_cnt;
  			string a;
			for (int i = 0; i < D.size(); i++) {
				a += D[i] + 'A';
			}
			A[ret].push_back(a);
		}
		return;
	}
	D.push_back(idx);
	dfs(idx + 1, cnt + 1, number);
	D.pop_back();
	dfs(idx + 1, cnt, number);
}
vector<string> solution(vector<string> orders, vector<int> course) {
	vector<string> answer;
	y_size = orders.size();
	int maxNumber = -1;
	for (int i = 0; i < orders.size(); i++) {
		for (int j = 0; j < orders[i].size(); j++) {
			maxNumber = max(maxNumber, orders[i][j] - 'A');
			orders_A[i][orders[i][j] - 'A'] = 1;
		}
	}
	idx_size = maxNumber;
	for (int i = 0; i < course.size(); i++) {
		ret = -1;
		dfs(0, 0,course[i]);

		if (A[ret].size() != 0) {
			if (ret == -1)break;
			for (int j = 0; j < A[ret].size(); j++) {
				string a = A[ret][j];
				answer.push_back(a);
			}
		}
		for (int i = 0; i < 28; i++) {
			A[i].clear();
		}
	}
	sort(answer.begin(), answer.end());
	return answer;
}

int main(void) {
	vector<string> a;
	a = solution({ "XYZ", "XWY", "WXA"}, { 2,3,4 });
	for (int i = 0; i < a.size(); i++) {
		cout << a[i] << " ";
	}
	return 0;
}